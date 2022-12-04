import java.util.Arrays;
import java.util.Scanner;


public class VirtualBird implements Contract {
   
    static String name;
    String nestingMaterial;
    Integer weight;
    int count=0;
   
    String [] goodTypeMaterial  = {"dead leaves","organic item","staw","hemp","Plant Fluff","Dried Grass Clippings"};
    String [] badTypeMaterial  = {"metal","plastic","rubber","non-organic","artificial grass"};
    String[] Material = {"metal","plastic","rubber","non-organic","artificial grass","dead leaves","organic item","staw","hemp","Plant Fluff","Dried Grass Clippings"};
 
    public VirtualBird(String bird){
        this.name=bird;
    }

    

   /*
    * grab an item from an array of items
    *@param name of item
    *return nothing
    */
    public void grab(String item) {
        boolean doesContain = Arrays.stream(Material).anyMatch(item::equalsIgnoreCase);
       if ( doesContain == false) {
        System.out.println("Please choose your item from the list provided! Start back the game and follow the instructions! ");
       }
       else {
         this.nestingMaterial=item;
        System.out.println("Congratulation. You have grabbed 1 "+ item +".\n Examine if it is the right type of material and if yes,use it to build your nest. \nIf not, drop it and grab another item" );
       }
     
    }


    /*
    *return a statement giving the name of the bird and some instructions for the game
    */
    public String toString() {
        return ("Hi! Your name is "+ this.name+"." +"To build your nest,choose between these items :\n + metal \n + plastic \n + rubber \n + non-organic \n + artificial grass \n + dead leaves \n + organic item \n + staw \n + hemp \n + Plant Fluff \n + Dried Grass Clippings\n **Go to the location(2,3) and grab an item. Good luck!!! \n");
    }


   /*
    * drop the item previously grabbed
    *@param name of item
    *return the name of the item dropped
    */
    public String drop(String item) {
        if ( nestingMaterial == null) {
            throw new RuntimeException("\n Please you haven't grabed an item.");
           }
        else{
     this.nestingMaterial=null;
    return (name+" you just dropped this item : " + item); }
        
    }


    /*
    * examine if the item grabbed is a good material for the nest
    *@param name of item
    *return nothing
    */
    public void examine(String item) {

        boolean doesContain = Arrays.stream(goodTypeMaterial).anyMatch(item::equalsIgnoreCase);
        if ( doesContain == false) {
         System.out.println("\n Oups! Your item is not of good quality for a nest.\n Drop it and grab another one");
        }
        else {  
         System.out.println("\n Congratulation. You have the good type of nesting material. \nUse it to build your nest" );
        }
    }


   /*
    * Use the item grabbed to build the nest
    *@param name of item
    *return nothing
    */
    
    public void use(String item) {
        
        boolean doesContain = Arrays.stream(goodTypeMaterial).anyMatch(item::equalsIgnoreCase);
        
        if ( nestingMaterial == null) {
           System.out.println("\n Please grab an item before using it. You don't actually have one");
           }
          else if ( doesContain == false) {throw new RuntimeException("Your material is may be not of good quality ");}
           else {
             this.nestingMaterial=null;
             System.out.println("\n Congratulation. You just used this "+ item +" \n Start back the process to complete your nest");
             count++;
             System.out.println(count);
             if(count==3){
                System.out.println("Congratulation!!! You won.\n You built a beautiful nest\n'''\\______/'''");
                System.exit(1);
             }
        }
    }


   /*
    * enable the bird to walk towards a direction
    *@param direction to be taken
    *return T/F if the bird is able to walk
    */
    public  boolean walk(String direction) {
        if ( direction.equalsIgnoreCase("left")){
            System.out.println("You just walked to the left");
             
        }
        else if (direction.equalsIgnoreCase("right")){
            System.out.println("\nYou just walked to the right");
        }
        else if(direction.equalsIgnoreCase("up")){
            System.out.println("You just moved to up");
        }
        else if(direction.equalsIgnoreCase("down")){
            System.out.println("You just went down");
        }
        else {
            throw new RuntimeException("Your direction must be either left,right,up or down");   
        }
        return true;
        
    }
  

   /*
    * enable the bird to fly from a point to another
    *@param x(depart) and y(arrival) 
    *return T/F if the bird is able to fly
    */
    public boolean fly(int x, int y) {
        
            System.out.println("\nYou just flight. You have arrived to your location("+x+","+y+")");
            return true;  
  
    }


   /*
    * Initialize the weight of the bird
    *@param Initial weight of the bird
    *return the initialized value of the weight of the bird
    */
    public  String Weight(Integer InitialWeight) {
        if ( InitialWeight >= 16 && InitialWeight <= 34) {
            weight=InitialWeight;
            return ("You just initialized your weight to: "+ InitialWeight + " pounds");
        }
        else {
         throw new RuntimeException("\n Sorry! Your weight must be between 16 and 34 pounds! You don't want to be sick");       
        }
    }

   /*
    * reduce the weight of the bird
    *return the new weight after decrease
    */
    
    public Integer shrink() {
        if ( weight==null  ) {
            throw new RuntimeException("\n Sorry! Initialize your weight first ");           
        }
         else if(weight < 4){
             throw new RuntimeException("\n Sorry! Your weight is less than 4 pounds, you will die if you shrink. Grow first!");          
        }
         else { 
            weight= weight-2;
            System.out.print("You just shrank from 2 pounds.Your new weight is  ");
            return weight;
        } 
    }


   /*
    * add the weight of the bird
    *return the new weight after the increase
    */    
    public Number grow() {
        if ( weight > 38) {
            throw new RuntimeException("\n Sorry! If your weight increases, you may not be able to walk or fly again and later die ");
        }       
         else { 
            weight= weight+2;
            System.out.print("You just grew. You weight increased by 2 pounds ");
            return weight;
        }
    }


   /*
    * print a message to say that the bird is resting
    *return void
    */
    public void rest() {
        System.out.println("You are resting. You can choose to sleep or take a nap ");     
    }

    
   /*
    * print a message to say that the bird can't undo and give the user steps to follow to undo an action manually
    *return void
    */
    public void undo() {   
           
       System.out.println("Sorry you can't undo what you just did. What you might want to do is to change your previous values using the diffent option you have");
      
    }
    boolean StillPlaying= true;
    
  
    public static void main(String[] args) {

        Scanner UserInput = new Scanner(System.in);
         System.out.println("What is your name little bird?");
         String Yourname= UserInput.nextLine();
         VirtualBird korokoro = new VirtualBird(Yourname);
         System.out.println(korokoro);       
         boolean StillPlaying= true;
         String UserResponse=" " ;      
         Integer x=0;
         Integer y=0;
        
            do{
            
             UserResponse= UserInput.nextLine();
   
                if ( UserResponse.equalsIgnoreCase("LOSE")) {
                  StillPlaying = false;
                  System.out.println("So sad! Better luck next time.");
                }   
                else if( UserResponse.equalsIgnoreCase("win")){
                    System.out.println("You have not yet finished your nest. Keep on the great work!!* ");
                }
                
               else if ( UserResponse.equalsIgnoreCase("grab")){
                    if(x==2 && y==3){  
                     System.out.println("What do you want to grab?");
                     String Inputgrab= UserInput.nextLine();
                     korokoro.grab(Inputgrab);
                    }
                    else{
                     System.out.println("You are not at the right position.\n You need to go to the position(2,3)");
                    }
                 
                }
                else if ( UserResponse.equalsIgnoreCase("drop")){
                     System.out.println("What do you want to drop?");
                     String Inputdrop= UserInput.nextLine();
                     System.out.println(korokoro.drop(Inputdrop));
                }
               else if ( UserResponse.equalsIgnoreCase("examine")){
                     System.out.println("which item do you want to examine?");
                     String Inputexamine= UserInput.nextLine();
                     korokoro.examine(Inputexamine);
                }
                else if ( UserResponse.equalsIgnoreCase("use")){
                     if(x==2 && y==2){
                     System.out.println("Which item are you using");
                     String InputUse= UserInput.nextLine();
                      korokoro.use(InputUse);      
                    }
                     else{
                      System.out.println(" You are not at the right place.\n You need to go to the location (2,2)");
                    }
                }
                else if ( UserResponse.equalsIgnoreCase("walk")){
                    
                 System.out.println("Which direction do you want to take left,right,up or down? ");
                 String Inputwalk= UserInput.nextLine();
                 korokoro.walk(Inputwalk);
                    
                    if(Inputwalk.equalsIgnoreCase("left")){
                       if(x>=-3){
                             x= x-1;          
                             System.out.println("Your current location is ("+x + ","+y +"). "); 
                        } 
                        else{System.out.println("You reached the boundaries");}
                    }
                    else if(Inputwalk.equalsIgnoreCase("right")){  
                        if(x<=3){        
                          x=x+1;
                          System.out.println("Your current location is ("+x + ","+y +"). "); 
                        }
                        else{System.out.println("You reached the boundaries");}
                    }
                    else if(Inputwalk.equalsIgnoreCase("UP")){
                        if(y<=3){
                         y=y+1;
                         System.out.println("Your current location is ("+x + ","+y +"). "); 
                        }
                        else{System.out.println("You reached the boundaries");}
                    }
                    else if(Inputwalk.equalsIgnoreCase("down")){
                        if(y>=3){
                         y=y-1;
                         System.out.println("Your current location is ("+x + ","+y +"). "); 
                        }
                        else{System.out.println("You reached the boundaries. You can't cross(4,4)");}
                    }
                 
                }
                else if ( UserResponse.equalsIgnoreCase("fly")){
                 System.out.println("Enter two integers to represent where you are going"); 
                  x= UserInput.nextInt();
                  y= UserInput.nextInt();
                 korokoro.fly(x, y);
                }
                else if ( UserResponse.equalsIgnoreCase("weight")){
                 System.out.println("To which value do you want to set your weight?\n It must be between 16 and 34 pounds! You don't want to be sick");
                 int Inputweight= UserInput.nextInt();
                 System.out.println(korokoro.Weight(Inputweight));
                }
                else if ( UserResponse.equalsIgnoreCase("shrink")){
                 System.out.println(korokoro.shrink());
                }

                else if ( UserResponse.equalsIgnoreCase("grow")){
                 System.out.println(korokoro.grow());
                }
                else if (UserResponse.equalsIgnoreCase("help")){
                 System.out.println(" *******************************************");
                 System.out.println("   ++++Grab an item at (2,3) an examine it++++");
                 System.out.println("   ++If the quality is good, use it at (2,2)++ ");
                 System.out.println("  &&&& If the quality is bad, drop it &&&&");
                 System.out.println("You have two means of transportation:walk and fly ");
                 System.out.println("      **You can rest if you are tired**");
                 System.out.println("      TIP: THERE IS NO TURNING BACK!!!");
                 System.out.println("   °°° You can rest if you are tired °°°");
                 System.out.println("Type ''help'' to look back at the instructions");
                 System.out.println(" *******************************************");
                }
            
               else if ( UserResponse.equalsIgnoreCase("rest")){korokoro.rest();}
               else if ( UserResponse.equalsIgnoreCase("undo")){korokoro.undo();}
               else { System.out.println("I don't know the word '' "+ UserResponse+ " '' ");}
              
            }
            while(StillPlaying);
     UserInput.close();
      
     
    }
}
