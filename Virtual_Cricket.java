import java.util.Scanner;
import java.util.Random;

public class Virtual_Cricket{

    private static Random rn = new Random();
    static String player1_name="";
    static int p1_choose = 1;
    static int delay = 0;

    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        println("What's you name?");
        player1_name = ob.nextLine();
        println("Welcome "+player1_name+", to Virtual Cricket!");      
        println("Do you need Instructions? (Y|N) || (1|0)");
        String instr = ob.nextLine();
        while(!(instr.equalsIgnoreCase("y") || instr.equalsIgnoreCase("n") || instr.equals("1") || instr.equals("0"))){
            println("Please answer Y or N for Yes/No");
            instr = ob.nextLine();
        }
        if(instr.equalsIgnoreCase("Y") || instr.equals("1"))
            instructions();

        println("Do you want text delay? Might look cool ;) (Y|N) || (1|0)");
        String delay_ = ob.nextLine();
        while(!(delay_.equalsIgnoreCase("y") || delay_.equalsIgnoreCase("n") || delay_.equals("1") || delay_.equals("0"))){
            println("Please answer Y or N for Yes/No");
            delay_ = ob.nextLine();
        }
        if(delay_.equalsIgnoreCase("Y") || instr.equals("1"))
            delay = 500;
        else
            delay = 0;
        //---------------------------------------------------------------

        /*
        println("Choose match type:");
        println("1. Player vs. Computer");
        println("2. Player vs. Player");
        println("?. ???????? vs. ????????");

        try{
        matchtype = ob.nextInt();
        while(matchtype != 1 && matchtype != 2 && matchtype != 69420){
        println("Choice not available");
        matchtype = ob.nextInt();
        }
        }catch(Exception e){
        println("Make a choice in numbers.");
        }
         */
        toss();

        game();

        credits();
    }

    public static void toss(){
        Scanner ob = new Scanner(System.in);
        println("------------------------------------------------------");
        println("TOSS");
        String p1_toss="";
        println("Choose Head or Tail. (H|T) || (1|0)");
        p1_toss = ob.nextLine();
        while(!(p1_toss.equalsIgnoreCase("h") || p1_toss.equalsIgnoreCase("t") || p1_toss.equals("1") || p1_toss.equals("0"))){
            println("Please answer H or T for Heads/Tails");
            p1_toss = ob.nextLine();
        }

        println("----------------------------------------------------");
        if(p1_toss.equalsIgnoreCase("H") || p1_toss.equals("1")){
            println("You chose Heads\nComputer chose Tails");
            p1_toss = 1+"";
        }
        else{
            println("You chose Tails\nComputer chose Heads");
            p1_toss = 0+"";
        }
        println("----------------------------------------------------");

        println("Throw a number (1-6) : ");
        int p1_throw = isValid(1,6);

        int p2_throw = rn.nextInt(6)+1;
        println("Computer threw       : "+p2_throw);

        println("----------------------------------------------------");

        //-------------Toss Decision Logic-------------------------------

        if((p1_throw+p2_throw)%2 == 1){
            println("Heads won the toss!");
            if(Integer.parseInt(p1_toss) == 1){
                println("You won the toss.");
                choose_batball();
            }
            else{
                println("Computer won the toss.");
                if(rn.nextInt(2)%2==0){
                    println("Computer chose to BAT\nYou are BOWLING");
                    p1_choose = 0;
                }
                else{
                    println("Computer chose to BOWL\nYou are BATTING");
                    p1_choose = 1;
                }

            }
        }
        else{
            println("Tails won the toss!");
            if(Integer.parseInt(p1_toss) == 0){
                println("You won the toss.");
                choose_batball();
            }
            else
                println("Computer won the toss.");
            if(rn.nextInt(2)%2==0){
                println("Computer chose to BAT\nYou are BOWLING");
                p1_choose = 0;
            }
            else{
                println("Computer chose to BOWL\nYou are BATTING");
                p1_choose = 1;
            }
        }
        //-------------END Toss Decision Logic-------------------------------
    }

    public static void game(){
        println("\n------------------------------------------------------");
        println("--------------------- INNING  1 ----------------------");
        println("----------- Player -------------- Computer ----------");
        println("---------- "+(p1_choose == 1?"Batting":"Bowling")+" --------------- "+(p1_choose == 0?"Batting":"Bowling")+" -----------");
        println("------------------------------------------------------");

        int inn1 = innings1();

        println("\n------------------------------------------------------");
        println("--------------------- INNING  2 ----------------------");
        println("----------- Player --------------- Computer ----------");
        println("---------- "+(p1_choose == 0?"Batting":"Bowling")+" --------------- "+(p1_choose == 1?"Batting":"Bowling")+" -----------");
        println("------------------------------------------------------");

        int p1_won = innings2(inn1+1);
        decide(p1_won);

        return;
    }

    private static int innings1(){
        int score=0;
        int p1throw=0;
        int p2throw=0;
        if(p1_choose == 1){
            for(;;){
                print("🢣  Your throw     : ");
                p1throw = isValid(1,6);
                print("   Computer throw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println("You are Out\n");
                    println("------------------------------------------------------");
                    println("|     You scored : "+score+". Target for Computer : "+(score+1)+"     |");
                    println("------------------------------------------------------");
                    return (score);
                }
                else{
                    score+=p1throw;
                    println("Score : "+score+"\n");
                }
                
            }
        }
        else{
            for(;;){
                print("   Your throw     : ");
                p1throw = isValid(1,6);
                print("🢣  Computer throw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println("Computer is Out\n");
                    println("------------------------------------------------------");
                    println("|     Computer scored : "+score+". Target for You : "+(score+1)+"     |");
                    println("------------------------------------------------------");
                    return (score);
                }
                else{
                    score+=p1throw;
                    println("Score : "+score+"Target : "+"\n");
                }
                
            }

        }
    }

    private static int innings2(int target){     
        int score=0;
        int p1throw=0;
        int p2throw=0;
        if(p1_choose == 0){
            for(;;){
                print("🢣  Your throw     : ");
                p1throw = isValid(1,6);
                print("   Computer throw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println("You are Out\n");
                    println("------------------------------------------------------");
                    println("|     You scored : "+score+". Target was : "+target+"     |");
                    println("------------------------------------------------------");
                    if(score==target)
                        return(2);
                    else
                        return(0);
                }
                else{
                    score+=p1throw;
                    println("\nScore : "+score+"Target : "+target+"\n");
                    if(score>target)
                        return (1);
                }
                
            }
        }
        else{
            for(;;){
                print("   Your throw     : ");
                p1throw = isValid(1,6);
                print("🢣  Computer throw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw);

                if(p1throw == p2throw){
                    println("Compter is Out\n");
                    println("------------------------------------------------------");
                    println("|     Computer scored : "+score+". Target was : "+(score+1)+"     |");
                    println("------------------------------------------------------");
                    if(score==target)
                        return(2);
                    else
                        return(1);
                }
                else{
                    score+=p1throw;
                    println("\nScore : "+score+"  |  Target : "+target+"\n");
                    if(score>target)
                        return (0);
                }
                
            }
        }
    }

    private static void decide(int input){
        if(input==1)
            println("You WON. Congratulation!");
        else if(input==0)
            println("You LOST. Try again perhaps?");
        else
            println("TIE");

    }

    private static void instructions(){
        println("INSTRUCTIONS HERE");
        println("------------------------------------------------------");
    }

    private static int isValid(int min, int max){
        Scanner ob = new Scanner(System.in);
        int num = 0;
        try{
            while(num<min || num>max){
                num = ob.nextInt();
                if(num<min || num>max)
                    println("Ivalid. Only numbers "+min+" to "+max+" allowed");
            }
        }catch (Exception e)
        {
            println("Enter only Numbers!");
            isValid(min, max);
        }
        return num;
    }

    private static void choose_batball(){
        Scanner ob = new Scanner(System.in);
        println("Choose Bat or Ball. (Bat|Ball) || (1|0)");

        String choose = ob.nextLine();
        while(!(choose.equalsIgnoreCase("bat") || choose.equalsIgnoreCase("ball") || choose.equals("1") || choose.equals("0"))){
            println("Please answer 1 or 0 for Bat/Ball");
            choose = ob.nextLine();
        }

        println("----------------------------------------------------");
        if(choose.equalsIgnoreCase("bat") || choose.equals("1")){
            println("You chose to BAT\nComputer is BOWLING");
            Virtual_Cricket.p1_choose = 1;
        }
        else{
            println("You chose to BOWL\nComputer chose BATTING");
            Virtual_Cricket.p1_choose = 0;
        }
    }

    private static void credits(){
        println("Thank you playing Virtual Cricket, "+player1_name);
        println("----------------------------------------------------");
        println("----------------------------------------------------");
        println("A game by Infinity (Shubham Sinha)");
    }

    private static void print(String s){
        System.out.print(s);
        try{
            Thread.sleep(delay);
        }
        catch (InterruptedException ie){}
    }

    private static void print(int s){
        System.out.print(s);
        try{
            Thread.sleep(delay);
        }
        catch (InterruptedException ie){}
    }

    private static void println(String s){
        System.out.println(s);
        try{
            Thread.sleep(delay);
        }
        catch (InterruptedException ie){}
    }

    private static void println(int s){
        System.out.println(s);
        try{
            Thread.sleep(delay);
        }
        catch (InterruptedException ie){}
    }
}