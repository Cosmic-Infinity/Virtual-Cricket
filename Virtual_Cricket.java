import java.util.Scanner;
import java.util.Random;

class Virtual_Cricket{

    private static Scanner ob = new Scanner(System.in);
    private static Random rn = new Random();
    static int matchtype = 1;

    public static void main(){
        System.out.println("What's you name?");
        String player_name = ob.nextLine();
        System.out.println("Welcome "+player_name+", to Virtual Cricket!");      
        System.out.println("Do you need Instructions? (Y|N) || (1|0)");
        String instr = ob.nextLine();
        while(!(instr.equalsIgnoreCase("y") || instr.equalsIgnoreCase("n") || instr.equals("1") || instr.equals("0"))){
            System.out.println("Please answer Y or N for Yes/No");
            instr = ob.nextLine();
        }
        if(instr.equalsIgnoreCase("Y") || instr.equals("1"))
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

        toss();

        if(matchtype == 1){

        }
        else if(matchtype == 2){

        }
        else if(matchtype == 69420){

        }
    }

    public static void toss(){
        System.out.println("------------------------------------------------------");
        System.out.println("TOSS");
        String p1_toss="";
        if(matchtype==1){
            System.out.println("Choose Head or Tail. (H|T) || (1|0)");
            p1_toss = ob.nextLine();
            while(!(p1_toss.equalsIgnoreCase("h") || p1_toss.equalsIgnoreCase("t") || p1_toss.equals("1") || p1_toss.equals("0"))){
                System.out.println("Please answer H or T for Heads/Tails");
                p1_toss = ob.nextLine();
            }
            if(p1_toss.equalsIgnoreCase("H") || p1_toss.equals("1")){
                System.out.println("You chose Heads\nComputer chose Tails");
                p1_toss = 1+"";
            }
            else{
                System.out.println("You chose Tails\nComputer chose Heads");
                p1_toss = 0+"";
            }

            System.out.println("Throw a number (1-6) : ");
            int p1_throw = isValid(1,6);

            int p2_throw = rn.nextInt(6)+1;
            System.out.println("Computer threw "+p2_throw);

            if((p1_throw+p2_throw)%2 == 1){
                System.out.println("Heads won the toss!");
                if(Integer.parseInt(p1_toss) == 1){
                    System.out.println("You won the toss.");
                }
                else
                    System.out.println("Computer won the toss.");
            }
            else{
                System.out.println("Tails won the toss!");
                if(Integer.parseInt(p1_toss) == 0){
                    System.out.println("You won the toss.");
                }
                else
                    System.out.println("Computer won the toss.");
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
        System.out.println("------------------------------------------------------");
    }

    private static int isValid(int min, int max){
        Scanner ox = new Scanner(System.in);
        int num = 0;
        while(num<min || num>max){
            try{
                num = ox.nextInt();
            }catch(Exception e)
            {
                System.out.println("Ivalid. Only numbers 1 to 6 allowed");
                //num=0;
                continue;
            }
        }
        return num;
    }
}