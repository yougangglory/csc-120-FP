
public class Instructions {
    

    public void display(){
        System.out.println("WELCOME! THIS IS YOU  ");
        System.out.println("                                    ");
        System.out.println("    ( 0 V 0 )");
        System.out.println("                     "); 
        System.out.println("  /)(((    )))(\\");
        System.out.println("                             ");
        System.out.println("     /\\   /\\ ");
        System.out.println("                                              ");
        System.out.println("                                              ");
        System.out.println("                                              ");
        System.out.println("            **********************");
        System.out.println("                INSTRUCTIONS");
        System.out.println("            ***********************");
        System.out.println("  YOUR GOAL IS TO BUILD A NET FOR YOUR KIDS ");
        System.out.println("     ++++Grab an item at (2,3) an examine it++++");
        System.out.println("    ^++If the quality is good, use it at (2,2)++^");
        System.out.println("  &&&& If the quality is bad, drop it &&&&");
        System.out.println("You have two means of transportation:walk and fly ");
        System.out.println("      **You can rest if you are tired**");
        System.out.println("      TIP: THERE IS NO TURNING BACK!!!");
        System.out.println("   °°° You can rest if you are tired °°°");
        System.out.println("Type ''help'' to look back at the instructions");
        System.out.println("*************************************************");
        System.out.println("                                                   ");
        System.out.println("                                                   ");
       
    } 
         public static void main(String[] args){
       
         Instructions myInstructions = new Instructions();    
         myInstructions.display();
         VirtualBird.main(args);
           
        }
        
}