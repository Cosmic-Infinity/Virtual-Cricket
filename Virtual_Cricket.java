import java.util.Scanner;
import java.util.Random;

class Virtual_Cricket{

    private static Scanner ob = new Scanner(System.in);
    private static Random rn = new Random();
    static int matchtype = 0;
    static int p1_choose = 0;

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

        game();

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

            System.out.println("----------------------------------------------------");
            if(p1_toss.equalsIgnoreCase("H") || p1_toss.equals("1")){
                System.out.println("You chose Heads\nComputer chose Tails");
                p1_toss = 1+"";
            }
            else{
                System.out.println("You chose Tails\nComputer chose Heads");
                p1_toss = 0+"";
            }
            System.out.println("----------------------------------------------------");

            System.out.println("Throw a number (1-6) : ");
            int p1_throw = isValid(1,6);

            int p2_throw = rn.nextInt(6)+1;
            System.out.println("Computer threw :"+p2_throw);

            System.out.println("----------------------------------------------------");

            //-------------Toss Decision Logic-------------------------------

            if((p1_throw+p2_throw)%2 == 1){
                System.out.println("Heads won the toss!");
                if(Integer.parseInt(p1_toss) == 1){
                    System.out.println("You won the toss.");
                    choose_batball();
                }
                else
                    System.out.println("Computer won the toss.");
            }
            else{
                System.out.println("Tails won the toss!");
                if(Integer.parseInt(p1_toss) == 0){
                    System.out.println("You won the toss.");
                    choose_batball();
                }
                else
                    System.out.println("Computer won the toss.");
            }
            //-------------END Toss Decision Logic-------------------------------

        }
    }

    public static void game(){
        System.out.println("------------------------------------------------------");
        System.out.println("----------------------INNING  1-----------------------");
        System.out.println("-----------Player 1----------------Computer-----------");
        System.out.println("-----------"+(p1_choose == 1?"Batting":"Bowling")+"-----------------"+(p1_choose == 0?"Batting":"Bowling")+"------------");
        System.out.println("------------------------------------------------------");

        int p1_won = innings2(innings1());

    }

    private static int innings1(){
        int score=0;
        int p1throw=0;
        int p2throw=0;
        if(p1_choose == 1){
            for(;;){
                System.out.print("Your throw : ");
                p1throw = isValid(1,6);
                System.out.print("\nComputer throw : ");
                p2throw = rn.nextInt(6)+1;
                System.out.println(p2throw);
                if(p1throw == p2throw){
                    System.out.println("You are Out");
                    System.out.println("You scored : "+score+". Target for Computer : "+score+1);
                    return (score);
                }
                else
                    score+=p1throw;
            }
        }
        else{
            for(;;){
                System.out.print("Your throw : ");
                p1throw = isValid(1,6);
                System.out.print("\nComputer throw : ");
                p2throw = rn.nextInt(6)+1;
                System.out.println(p2throw);
                if(p1throw == p2throw){
                    System.out.println("Computer is Out");
                    System.out.println("Computer scored : "+score+". Target for You : "+score+1);
                    return (score);
                }
                else
                    score+=p1throw;
            }

        }
    }

    private static int innings2(int target){     
        int score=0;
        int p1throw=0;
        int p2throw=0;
        if(p1_choose == 0){
            for(;;){
                System.out.print("Your throw : ");
                p1throw = isValid(1,6);
                System.out.print("\nComputer throw : ");
                p2throw = rn.nextInt(6)+1;
                System.out.println(p2throw);
                if(p1throw == p2throw){
                    System.out.println("You are Out");
                    System.out.println("You scored : "+score+". Target was : "+score+1);
                    if(score==target)
                        return(2);
                    else
                        return(0);
                }
                else{
                    score+=p1throw;
                    if(score>target)
                        return (1);
                }
            }
        }
        else{
            for(;;){
                System.out.print("Your throw : ");
                p1throw = isValid(1,6);
                System.out.print("\nComputer throw : ");
                p2throw = rn.nextInt(6)+1;
                System.out.println(p2throw);
                if(p1throw == p2throw){
                    System.out.println("Compter is Out");
                    System.out.println("Computer scored : "+score+". Target was : "+score+1);
                    if(score==target)
                        return(2);
                    else
                        return(1);
                }
                else{
                    score+=p1throw;
                    if(score>target)
                        return (0);
                }
            }
        }
    }

    private static void instructions(){
        System.out.println("INSTRUCTIONS HERE");
        System.out.println("------------------------------------------------------");
    }

    private static int isValid(int min, int max){
        Scanner ox = new Scanner(System.in);
        int num = 0;
        try{
            while(num<min || num>max){
                num = ox.nextInt();
                if(num<min || num>max)
                    System.out.println("Ivalid. Only numbers "+min+" to "+max+" allowed");
            }
        }catch (Exception e)
        {
            System.out.println("Enter only Numbers!");
            isValid(min, max);
        }
        return num;
    }

    private static void choose_batball(){
        System.out.println("Choose Bat or Ball. (Bat|Ball) || (1|0)");

        String choose = ob.nextLine();
        while(!(choose.equalsIgnoreCase("bat") || choose.equalsIgnoreCase("ball") || choose.equals("1") || choose.equals("0"))){
            System.out.println("Please answer 1 or 0 for Bat/Ball");
            choose = ob.nextLine();
        }

        System.out.println("----------------------------------------------------");
        if(choose.equalsIgnoreCase("bat") || choose.equals("1")){
            System.out.println("You chose to BAT\nComputer is BOWLING");
            Virtual_Cricket.p1_choose = 1;
        }
        else{
            System.out.println("You chose to BOWL\nComputer chose BATTING");
            Virtual_Cricket.p1_choose = 0;
        }
    }
}