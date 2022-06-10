package at.htlle.fourconnect;

import java.util.Scanner;

public class FourConnectView {
    public void printView(String text){
        System.out.println(text);
    }

    public void printlnView(String text){
        System.out.println(text);
    }

    //Yes, we even need to make a new method for visually
    //printing our game, but at least it's not hard to do
    public static void printPattern(String[][] f)
    {
        for (int i =0;i<f.length;i++)
        {
            for (int j=0;j<f[i].length;j++)
            {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }

    public static int requestColumn() {
        //We need to have the user tell us what column he wants
        //to drop a red into
        //Note: the user isn't supposed to know that we have 15 columns
        //starting at index 0 till 14 but just 6 nice ones
        System.out.println("Drop a red disk at column (0–6): ");
        Scanner scan = new Scanner (System.in);

        //Thankfully, there's a simple formula for converting a 1-2-3-4-5-6
        //user column number into a 1-3-5-7-9-11-13
        int c = 2*scan.nextInt()+1;
        return c;
    }

    public int requestColumn(String disk) {
        return 0;
    }
}
