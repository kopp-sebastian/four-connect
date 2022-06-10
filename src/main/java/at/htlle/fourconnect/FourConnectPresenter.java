package at.htlle.fourconnect;

public class FourConnectPresenter {

    FourConnectModel fourConnectModel;
    FourConnectView fourConnectView;

    public void executeGame() {
        boolean continueGame = true;
        fourConnectModel.resetModel();

        while(continueGame) {
            // Get some data from model to be displayed by view
            String disk = fourConnectModel.getNextPlayer();
            int column = fourConnectView.requestColumn(disk);

            // With the input from player update the model
            fourConnectModel.playersTurn(column);
            fourConnectModel.incrementCount();

            // check if we can terminate game
            checkTermination();
        }
    }

    private void checkTermination() {
    }

    public void setFourConnectModel(FourConnectModel fourConnectModel) {

    }

    public void setFourConnectView(FourConnectView fourConnectView) {
    }

    //The easy part: using these methods

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

}
