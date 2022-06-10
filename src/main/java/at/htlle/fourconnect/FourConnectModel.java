package at.htlle.fourconnect;

import static at.htlle.fourconnect.FourConnectView.dropDisk;

public class FourConnectModel {
    public static boolean checkWinner(String[][] f)
    {

        //Time to look for the first type of winning line,
        //a horizontal line
        //This line can be on any row, so let's loop over
        //each row starting from 0 to 5 (since 6 is just ___)
        for (int i =0;i<6;i++)
        {
            //On every row, the four-dotted line can look like
            //----_ _,  _----_, or _ _----
            //Here, _ can be an empty space or one of the colors
            //and - is not empty space  AND every - has the same
            // color (R or Y)
            //Note: since our R/Y/Empty's can only be in odd places,
            //because of how we created the pattern in the first
            //method, then our count has to be incremented by 2
            //and will start from 0 (which will be 1, ----_ _)
            //and stop at 6 (which will be 7, _ _----)
            for (int j=0;j<7;j+=2)
            {
                if ((f[i][j+1] != " ")
                        && (f[i][j+3] != " ")
                        && (f[i][j+5] != " ")
                        && (f[i][j+7] != " ")
                        && ((f[i][j+1] == f[i][j+3])
                        && (f[i][j+3] == f[i][j+5])
                        && (f[i][j+5] == f[i][j+7])))
                    //If we found a same-colored pattern, we'll return
                    //the color so that we will know who won
                    return true;
            }
        }

        //For a vertical line, let's first loop over eac
        //odd-numbered column by incrementing with 2
        //and check for consecutive boxes in the same column
        //that are the same color
        //Note: make sure you understand the horizontal line's
        //codes first or else everything below this point will
        //make no sense to you
        for (int i=1;i<15;i+=2)
        {
            //Of course, our lines will look like ----__ but reversed
            //and there is need to our rows by 2 but just one
            //and we have to start at the vertical version of ----__ and
            //and stop at _ _ ---- so it's from 0 to 2
            for (int j =0;j<3;j++)
            {
                if((f[j][i] != " ")
                        && (f[j+1][i] != " ")
                        && (f[j+2][i] != " ")
                        && (f[j+3][i] != " ")
                        && ((f[j][i] == f[j+1][i])
                        && (f[j+1][i] == f[j+2][i])
                        && (f[j+2][i] == f[j+3][i])))
                    return true;
            }
        }
        //For the left-up to right-down diagonal line
        //We'll have to loop over the 3 uppermost
        //rows and then go from left to right column-wise
        for (int i=0;i<3;i++)
        {
            //As expected, our uppermost box will start from 1
            //and increase by 2 until it becomes 7 (the 3rd box
            //on a row)
            //Note how we used 1 instead 0 for the count here
            //There's no real reason to use 1 instead of 0 or
            //vice versa, since we're still using an odd index
            //for the columns and incrementing by 2
            for (int j=1;j<9;j+=2)
            {
                if((f[i][j] != " ")
                        && (f[i+1][j+2] != " ")
                        && (f[i+2][j+4] != " ")
                        && (f[i+3][j+6] != " ")
                        && ((f[i][j] == f[i+1][j+2])
                        && (f[i+1][j+2] == f[i+2][j+4])
                        && (f[i+2][j+4] == f[i+3][j+6])))
                    return true;
            }
        }

        //Similar to the method above, but we're just reversing our
        //trajectory, i.e. we're starting from the rightmost column
        //instead of the leftmost like we did above
        for (int i=0;i<3;i++)
        {
            for (int j=7;j<15;j+=2)
            {
                if((f[i][j] != " ")
                        && (f[i+1][j-2] != " ")
                        && (f[i+2][j-4] != " ")
                        && (f[i+3][j-6] != " ")
                        && ((f[i][j] == f[i+1][j-2])
                        && (f[i+1][j-2] == f[i+2][j-4])
                        && (f[i+2][j-4] == f[i+3][j-6])))
                    return true;
            }

        }

        //If after going over the table and we find no
        //same colored lines, then we have to return something
        //that says that we didn't find a winning color :P
        return false;
    }


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
