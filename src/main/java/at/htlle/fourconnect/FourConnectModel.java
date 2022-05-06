package at.htlle.fourconnect;

import static at.htlle.fourconnect.FourConnectPresenter.checkWinner;
import static at.htlle.fourconnect.FourConnectView.dropDisk;

public class FourConnectModel {

    public static String[][] createPattern() {
        //Although the game is more like a table of 6
        //columns and 6 rows, we're going to have to make
        //a 2D array of 7 rows and 15 columns because graphically
        //there's an extra row to show the ___ at the bottom

        //and you have double the columns that show | | |
        //between each number
        String[][] f = new String[7][15];

        //Time to loop over each row from up to down
        for (int i = 0; i < f.length; i++) {

            //Time to loop over each column from left to right
            for (int j = 0; j < f[i].length; j++) {
                //Note how it is always the even column
                //that has the border and the odd column
                //between them that will be either empty or
                //have a number
                if (j % 2 == 0) f[i][j] = "|";
                else f[i][j] = " ";

                //Time to make our lowest row
                if (i == 6) f[i][j] = "-";
            }

        }
        return f;
    }

    public static int dropDiskPattern(String[][] f) {
        int c = dropDisk();
        int count = 0;
        boolean win = false;
        while (!win) {
            count++;
            if (count % 2 == 0) {
                for (int i = 5; i >= 0; i--) {
                    if (f[i][c] == " ") {
                        f[i][c] = "R";
                        break;
                    }

                }
            } else {
                for (int i = 5; i >= 0; i--) {
                    if (f[i][c] == " ") {
                        f[i][c] = "Y";
                        break;
                    }
                    checkWinner(f);
                }
        /*for (int i =5;i>=0;i--)
        {
            if (f[i][c] == " ")
            {
                f[i][c] = "R";
                break;
            }

         */


            }


        }
        return 0;
    }

    public void resetModel() {
    }

    public void incrementCount() {
    }

    public void playersTurn(int column) {
    }

    public String getNextPlayer() {
        return null;
    }
}
