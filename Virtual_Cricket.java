import java.util.Scanner;
import java.util.Random;

public class Virtual_Cricket{

    private static Random rn;
    static String player1_name;
    static String player2_name;
    static int p1_choose = 9999;
    static int gamemode = 10;
    static int delay = 10;

    public static void main(String[] args){
        initialise();
        Scanner ob = new Scanner(System.in);
        println("Welcome "+player1_name+", to Virtual Cricket!");      
        println("Do you need Instructions? (Y|N) || (1|0)");
        String instr = gamemode==0 ? ob.nextLine() : ai_return("N");
        while(!(instr.equalsIgnoreCase("y") || instr.equalsIgnoreCase("n") || instr.equals("1") || instr.equals("0"))){
            println("Please answer Y or N for Yes/No");
            instr = ob.nextLine() ;
        }
        if(instr.equalsIgnoreCase("Y") || instr.equals("1"))
            instructions();

        println("Do you want text delay? Might look cool ;) (Y|N) || (1|0)");
        String delay_ = gamemode==0 ? ob.nextLine() : ai_return("0");
        while(!(delay_.equalsIgnoreCase("y") || delay_.equalsIgnoreCase("n") || delay_.equals("1") || delay_.equals("0"))){
            println("Please answer Y or N for Yes/No");
            delay_ = ob.nextLine() ;
        }
        if(delay_.equalsIgnoreCase("Y") || delay_.equals("1"))
            delay = 333;

        do{
            toss();

            game();

            println("Play Again? (Y|N) || (1|0)");
            String again = ob.nextLine();
            while(!(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n") || again.equals("1") || again.equals("0"))){
                println("Please answer Y or N for Yes/No");
                again = ob.nextLine() ;
            }
            if(again.equalsIgnoreCase("n") || again.equals("0")){
                credits();break;
            }
        }while(true);
    }

    private static void initialise(){
        rn = new Random();
        player1_name="";
        player2_name="Computer";
        p1_choose = 9999;
        gamemode = 9999;
        delay=0;
        Scanner ob = new Scanner(System.in);
        println("What's you name?");
        player1_name = ob.nextLine();
        setmode();
    }

    private static String ai_return(String s){
        println(s);
        return s;
    }

    public static void toss(){
        Scanner ob = new Scanner(System.in);
        println("------------------------------------------------------");
        println("TOSS");
        String p1_toss="";
        println("Choose Head or Tail. (H|T) || (1|0)");
        p1_toss = gamemode==0 ? ob.nextLine() : ai_return(rn.nextInt(2)+"");
        while(!(p1_toss.equalsIgnoreCase("h") || p1_toss.equalsIgnoreCase("t") || p1_toss.equals("1") || p1_toss.equals("0"))){
            println("Please answer H or T for Heads/Tails");
            p1_toss = ob.nextLine();
        }

        println("----------------------------------------------------");
        if(p1_toss.equalsIgnoreCase("H") || p1_toss.equals("1")){
            println(""+player1_name+" chose Heads\n"+player2_name+" chose Tails");
            p1_toss = 1+"";
        }
        else{
            println(""+player1_name+" chose Tails\n"+player2_name+" chose Heads");
            p1_toss = 0+"";
        }
        println("----------------------------------------------------");

        print("Throw a number (0-6) : ");
        int p1_throw =  gamemode==0 ? isValid(0,6) :  Integer.parseInt(ai_return((rn.nextInt(7))+""));

        int p2_throw = rn.nextInt(7);
        println(player2_name+" threw   : "+p2_throw);

        println("----------------------------------------------------");

        //-------------Toss Decision Logic-------------------------------

        if((p1_throw+p2_throw)%2 == 1){
            println("Heads won the toss!");
            if(Integer.parseInt(p1_toss) == 1){
                println(""+player1_name+" won the toss.");
                choose_batball();
            }
            else{
                println(player2_name+" won the toss.");
                if(rn.nextInt(2)%2==0){
                    println(player2_name+" chose to BAT\n"+player1_name+" is BOWLING");
                    p1_choose = 0;
                }
                else{
                    println(player2_name+" chose to BOWL\n"+player1_name+" is BATTING");
                    p1_choose = 1;
                }

            }
        }
        else{
            println("Tails won the toss!");
            if(Integer.parseInt(p1_toss) == 0){
                println(""+player1_name+" won the toss.");
                choose_batball();
            }
            else{
                println(player2_name+" won the toss.");
                if(rn.nextInt(2)%2==0){
                    println(player2_name+" chose to BAT\n"+player1_name+" is BOWLING");
                    p1_choose = 0;
                }
                else{
                    println(player2_name+" chose to BOWL\n"+player1_name+" is BATTING");
                    p1_choose = 1;
                }
            }
        }
        //-------------END Toss Decision Logic-------------------------------
    }

    public static void game(){
        println("\n------------------------------------------------------");
        println("--------------------- INNING  1 ----------------------");
        println("----------- "+(gamemode==0?"Player":player1_name)+" --------------- "+player2_name+" ----------");
        println("---------- "+(p1_choose == 1?"Batting":"Bowling")+" --------------- "+(p1_choose == 0?"Batting":"Bowling")+" -----------");
        println("------------------------------------------------------");

        int inn1 = innings1();

        println("\n------------------------------------------------------");
        println("--------------------- INNING  2 ----------------------");
        println("----------- "+(gamemode==0?"Player":player1_name)+" --------------- "+player2_name+" ----------");
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
                print("🢣  "+player1_name+" threw     : ");
                p1throw = gamemode==0 ? isValid(0,6) :  Integer.parseInt(ai_return((rn.nextInt(7))+""));
                print("    "+player2_name+" threw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println(""+player1_name+" is Out\n");
                    println("------------------------------------------------------");
                    println("|     "+player1_name+" scored : "+score+". Target for "+player2_name+" : "+(score+1)+"     |");
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
                print("    "+player1_name+" threw     : ");
                p1throw = gamemode==0 ? isValid(1,6) :  Integer.parseInt(ai_return((rn.nextInt(6)+1)+""));
                print("🢣  "+player2_name+" threw : ");
                p2throw = rn.nextInt(7);
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println(player2_name+" is Out\n");
                    println("------------------------------------------------------");
                    println("|     "+player2_name+" scored : "+score+". Target for "+player1_name+" : "+(score+1)+"     |");
                    println("------------------------------------------------------");
                    return (score);
                }
                else{
                    score+=p2throw;
                    println("Score : "+score);//+"  Target : "+"\n");
                }
            }
        }
    }

    private static void setmode(){
        if(player1_name.equalsIgnoreCase("aI")){
            setupmode();
            gamemode = 1;
        }
        else
            gamemode = 0;
    }

    private static int innings2(int target){     
        int score=0;
        int p1throw=0;
        int p2throw=0;
        if(p1_choose == 0){
            for(;;){
                print("🢣  "+player1_name+" threw     : ");
                p1throw = gamemode==0 ? isValid(0,6) :  Integer.parseInt(ai_return((rn.nextInt(7))+""));
                print("    "+player2_name+" threw : ");
                p2throw = rn.nextInt(6)+1;
                println(p2throw+"\n");

                if(p1throw == p2throw){
                    println(""+player1_name+" is Out\n");
                    println("------------------------------------------------------");
                    println("|     "+player1_name+" scored : "+score+". Target was : "+target+"     |");
                    println("------------------------------------------------------");
                    if(score==target-1)
                        return(2);
                    else
                        return(0);
                }
                else{
                    score+=p1throw;
                    println("\nScore : "+score+"  |  Target : "+target+"\n");
                    if(score>=target)
                        return (1);
                }

            }
        }
        else{
            for(;;){
                print("    "+player1_name+" threw     : ");
                p1throw = gamemode==0 ? isValid(1,6) : Integer.parseInt(ai_return((rn.nextInt(6)+1)+""));
                print("🢣  "+player2_name+" threw : ");
                p2throw = rn.nextInt(7);
                println(p2throw);

                if(p1throw == p2throw){
                    println(""+player2_name+" is Out\n");
                    println("------------------------------------------------------");
                    println("|     "+player2_name+" scored : "+score+". Target was : "+(target)+"     |");
                    println("------------------------------------------------------");
                    if(score==target-1)
                        return(2);
                    else
                        return(1);
                }
                else{
                    score+=p2throw;
                    println("\nScore : "+score+"  |  Target : "+target+"\n");
                    if(score>=target)
                        return (0);
                }

            }
        }
    }

    private static void decide(int input){
        if(input==1)
            println("------------------------------------------------------\n\n\n"+player1_name+" WON. Congratulation!\n\n\n------------------------------------------------------");
        else if(input==0)
            if(gamemode==0)
                println("------------------------------------------------------\n\n\n"+player1_name+" LOST. Try again perhaps?\n\n\n------------------------------------------------------");
            else
                println("------------------------------------------------------\n\n\n"+player2_name+" WON. Congratulation!\n\n\n------------------------------------------------------");
        else
            println("------------------------------------------------------\n\n\nTIE\n\n\n------------------------------------------------------");

    }

    private static void instructions(){
        println("INSTRUCTIONS HERE");
        println("------------------------------------------------------");
    }

    private static void setupmode(){
        println("SECRET UNLOCKED!");
        delay = 500;
        player1_name ="AI_1";
        player2_name ="AI_2";
    }

    private static int isValid(int min, int max){
        Scanner ob = new Scanner(System.in);
        int num=-1;
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

        String choose = gamemode==0 ? ob.nextLine() : ai_return(rn.nextInt(2)+"");
        while(!(choose.equalsIgnoreCase("bat") || choose.equalsIgnoreCase("ball") || choose.equals("1") || choose.equals("0"))){
            println("Please answer 1 or 0 for Bat/Ball");
            choose = ob.nextLine();
        }

        println("----------------------------------------------------");
        if(choose.equalsIgnoreCase("bat") || choose.equals("1")){
            println(""+player1_name+" chose to BAT\n"+player2_name+" is BOWLING");
            Virtual_Cricket.p1_choose = 1;
        }
        else{
            println(""+player1_name+" chose to BOWL\n"+player2_name+" chose BATTING");
            Virtual_Cricket.p1_choose = 0;
        }
    }

    private static void credits(){
        if(gamemode==0)
            println("Thank you playing Virtual Cricket"+(gamemode==0?", "+player1_name:""));
        println("----------------------------------------------------");
        println("----------------------------------------------------");
        println("A game by Infinity (Shubham Sinha)");
        return;
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