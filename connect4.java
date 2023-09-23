
/*- - - - - - -
  - - - - - - -
  - - - - - - -
  - - - - - - -
  - - - - - - -
  - - - - - - -
  - - - - - - -
 */

import java.util.Scanner;

class connect4 {
    char[][] arr=new char[6][7];
    static int score1=0;
    static int score2=0;
    char player1='X';
    char player2='O';

    void scoreboard(int x)
    {
        if(x==1)
        score1++;
        else
        score2++;
    }

    void newgame(int ng)
    {
        if(ng==5)
        {
        score1=0;
        score2=0;
        }
        for(int  i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                arr[i][j]='-';
            }
        }
        System.out.println("\n*****Connect 4*****\n");
        drawboard();
        play();
    }

    int checkx(char p,int r)
    {
        int count=0;
        
            for(int j=0;j<4;j++)
            {
                for(int k=0;k<4;k++){
                if(arr[r][j+k]==p)
                {
                    count++;
                }
                else
                {
                    break;
                }}
                if(count==4)
                return 1;
                else count=0;
            }
        //System.out.println("System check 4 passed");
        return -1;
    }

    int checky(char p,int j,int r)
    {
        //System.out.println("System check 5 passed");
        int count=0;
        for(int i=r;i<6;i++)
        {        
            //System.out.println("System check 5.1 passed");
            for(int k=0;k<4;k++)
            {
                if(i+k<6)
                if(arr[i+k][j]==p)
                count++;
                else
                break;
            }
            if(count==4)
            return 1;
            else 
            count=0;
        }
        //System.out.println("System check 5 passed");
        return -1;
    }

    int checklrd(char p)
    {
        int count=0;
        for (int i=3;i<6;i++)
        {
            for (int j = 6; j >2 ; j--) {
                for(int k=0;k<4;k++)
        {
            if(arr[i-k][j-k]==p)
            {
                count++;
            }
            else
            break;
        }
        if(count==4)
        return 1;
        else
        count=0;
            }
        }
       return -1;
        //System.out.println("System check 6 passed");
        
    }

    int checkrld(char p)
    {
        int count=0;
        for (int i=3;i<6;i++)
        {
            for (int j = 0; j <4 ; j++) {
                for(int k=0;k<4;k++)
        {
            if(arr[i-k][j+k]==p)
            {
                count++;
            }
            else
            break;
        }
        if(count==4)
        return 1;
        else
        count=0;
            }
        }
        return -1;
    }

    int isdraw()//this can be done with the use of t check that too improve the code
    {
        int i=0,j=0;
        for( i=0;i<6;i++)
        {
            for( j=0;j<7;j++)
            {
                if(arr[i][j]=='-')
                return -1;
            }
        }
        if(i==6 && j==7)
        return 0;
        else 
        return -1;
    }

    void drawboard()
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
    }

    void declare(int player)
    {
        int x;
        if(player=='X')
        x=1;
        else
        x=2;
        System.out.println("Player "+x+" Winssssss!!!");
    }

    int decide(int r,char player,int i,int j,int x)
    {
        r=checkx(player,i);
                if(r==1){
                declare(player);
                scoreboard(x);
                return 1;
                }
                else{
                r=checky(player,j,i);
                if(r==1){
                declare(player);
                scoreboard(x);
                return 1;}
                else
                {r=checklrd(player);
                    if(r==1){
                    declare(player);
                    scoreboard(x);
                    return 1;}
                    else{
                r=checkrld(player);
                    if(r==1){
                    declare(player);
                    scoreboard(x);
                return 1;}}
                    
            }}
        if(r==-1){
        isdraw();
        if(r==0)
        {
            System.out.println("Ah oh! It's a draw.");
            return 1;
        }
        }
        return 9;// code for comtinue
    }

    void play()
    {
        Scanner sc =new Scanner(System.in);
        int x=0,t=0,j,i,r=-1;
        
        while(true)
        {
            
            
            
            char player='-';
            t++;
            x=x%2;
            x++;
            if(x==1)
            player=player1;
            if(x==2)
            player=player2;
            System.out.print("Player "+ x + ": Choose column between 1 to 7: ");
            j=sc.nextInt();
            j--;
            if(j>=0 && j<=6)
            {
            if(arr[0][j]!='-')//condition to check if column is full
            {
            System.out.println("This column is full. Try another.");
            x--;//to skip this chance;
            continue;
            }
            
            for(i=5;i>=0;i--)//to enter the value in the matrix
            {
                //System.out.println("Check i: "+i);
                if(arr[i][j]=='-')//to check which row is empty
                {
                arr[i][j]=player;//entering the value in the matrix
                break;
                }

            }
            System.out.println("\n*****Connect 4*****\n");
            drawboard();
            //System.out.println("System check 1 passed");
            if(t>6)
            {
                //System.out.println("System check 2 passed");
                int k=decide(r, player, i, j, x);
                //System.out.println("System check 3 passed");
                if(k==1)
                return;

            }
        }
    else 
{
    x--;
    System.out.println("Invalid input. Choose a number between 1 and 7.");
}}
    }

    public static void main(String args[])
    {
        System.out.println("Welcome to the Connect 4 game!!!");
        Scanner sc=new Scanner(System.in);
        connect4 obj=new connect4();
        int choice;
        while(true)
        {
            System.out.println("Choose from he options below:");
            System.out.print("\n1.Start new game\n2.Resume\n3.Scoreboard\n4.Exit\n\nYour choice: ");
            choice=sc.nextInt();
           
            switch(choice)
            {
                case 1:
                obj.newgame(5);
                break;
                case 2:
                obj.newgame(7);
                break;
                case 3:
                System.out.println("Scoreboad:\nPlayer 1: "+score1+"\nPlayer 2: "+score2);
                break;
                case 4:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid Input. Enter again.");
            }}
        }

    }
    

