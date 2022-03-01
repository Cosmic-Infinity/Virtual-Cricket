import java.util.Scanner;
import java.util.Random;

class Virtual_Cricket{

    private static Scanner ob = new Scanner(System.in);
    private static Random rn = new Random();
    static int matchtype = 0;

    public static void main(){
        System.out.println("What's you name?");
        String player_name = ob.nextLine();
        System.out.println("Welcome "+player_name+", to Virtual Cricket!");      
        System.out.println("Do you need Instructions? (Y|N) || (1|0)");
        String instr = ob.nextLine();
        while(instr != "y" && instr != "n" && instr != "Y" && instr != "N" && instr != "1" && instr != "0"){
            System.out.println("Please answer Y or N for Yes/No");
            instr = ob.nextLine();
        }
        if(parseyn(instr, "Y"))
            instructions();
        //---------------------------------------------------------------

        System.out.println("Choose match type:");
        System.out.println("1. Player vs. Computer");
        System.out.println("2. Player vs. Player");
        System.out.println("?. ???????? vs. ????????");

        try{
            matchtype = ob.nextInt();
            while(matchtype != 1 && matchtype != 2 && matchtype != 69420){
                System.out.println("Choice not available");
                matchtype = ob.nextInt();
            }
        }catch(Exception e){
            System.out.println("Make a choice in numbers.");
        }

        if(matchtype == 1){

        }
        else if(matchtype == 2){

        }
        else if(matchtype == 69420){

        }
    }

    private static void toss(){
        System.out.println("TOSS");
        if(matchtype==1){
            System.out.println("Choose Head or Tail. (H|T) || (1|0)");
            String p1_toss = ob.nextLine();
            while(p1_toss != "h" && p1_toss != "t" && p1_toss != "H" && p1_toss != "T" && p1_toss != "1" && p1_toss != "0"){
                System.out.println("Please answer H or T for Heads/Tails");
                p1_toss = ob.nextLine();
            }
            if(p1_toss == "H" || p1_toss == "h" || p1_toss == "1"){
                System.out.println("Computer chose Tails");
                p1_toss = 1+"";
            }
            else
                System.out.println("Computer chose Heads");

            int tossing = rn.nextInt(2);
            if(tossing%2 == 1){
                System.out.println("Heads won the toss!");

            }
        }
    }

    
    
    private static boolean parseyn(String s, String t1){
        if(s==t1 || s==t1.toLowerCase() || s=="1")
            return true;
        else
            return false;
    }

    private static void instructions(){
        System.out.println("INSTRUCTIONS HERE");
    }
}