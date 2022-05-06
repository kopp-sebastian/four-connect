package at.htlle.fourconnect;

import java.util.Scanner;

import static at.htlle.fourconnect.FourConnectModel.createPattern;
import static at.htlle.fourconnect.FourConnectView.printPattern;

public class FourConnectApp {
    //We need to first create the basic visual pattern



    //Here's are basic move, making the lowest empty row
    //of a specific column have a Red
    public static void dropRedPattern(String[][] f)
    {
        int c = dropRedDisk();

        //Now that we know our column, we have to loop
        //over each row from the bottom to the top
        //till we find the first  empty space, drop, and
        //then finish (i.e., break) the move
        //Note: although as coders we're used to starting from
        //0 to the end, here that wouldn't work so well because
        //it would involve multiple if statements, but try it out
        //on your own if you want to
        for (int i =5;i>=0;i--)
        {
            if (f[i][c] == " ")
            {
                f[i][c] = "R";
                break;
            }

        }
    }

    private static int dropRedDisk() {
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

    //Same as the above step, just yellow
    public static void dropYellowPattern(String[][] f)
    {
        System.out.println("Drop a yellow disk at column (0–6): ");
        Scanner scan = new Scanner (System.in);
        int c = 2*scan.nextInt()+1;
        for (int i =5;i>=0;i--)
        {
            if (f[i][c] == " ")
            {
                f[i][c] = "Y";
                break;
            }

        }
    }


    //Here's where it gets hard.
    //That's because there are basically four patterns
    //of Reds or Yellows that can win the game
    //One pattern is a horizontal line of four Rs or Ys,
    //another is a vertical line, another is a left-up to right-down
    //diagonal line, and the last is left-down to right-up diagonal,
    //We thus need to code for each type of line
    //and the various places where the line can be

    public static void main(String[] args) {
        FourConnectModel fourConnectModel = new FourConnectModel();
        FourConnectView fourConnectView = new FourConnectView();
        FourConnectPresenter fourConnectPresenter = new FourConnectPresenter();

        fourConnectPresenter.setFourConnectModel(fourConnectModel);
        fourConnectPresenter.setFourConnectView(fourConnectView);

        fourConnectPresenter.executeGame();
    }
}
