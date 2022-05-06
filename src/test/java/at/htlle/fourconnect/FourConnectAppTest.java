package at.htlle.fourconnect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FourConnectAppTest
{
    FourConnectPresenter fourConnectPresenter;
    FourConnectModel fourConnectModel;
    @Before
    public void setup()
    {
        fourConnectModel = new FourConnectModel();
        fourConnectPresenter = new FourConnectPresenter();

        fourConnectPresenter.setFourConnectModel(fourConnectModel);
    }

    private int convertColumnToModel(int column)
    {
        return 2*column +1;
    }
    @Test
    public void horizontalLineWins()
    {
        //**Scenario**: Simple horizontal line
        //**Given** empty board
        fourConnectModel.resetModel();
        //**When** player1 drops disks starting with col 0 up to col 3
        //**And** player2 drops his disks on top of disks from player1
        for (int column = 0; column < 3; column++) {
            int columnInModel = convertColumnToModel(column);
            fourConnectModel.playersTurn(columnInModel);
            fourConnectModel.incrementCount();
            fourConnectModel.playersTurn(columnInModel);
            fourConnectModel.incrementCount();
        }
        fourConnectModel.playersTurn(convertColumnToModel(3));
        //**Then** after 4 rounds player1 has won the game
        Assert.assertEquals("R", fourConnectPresenter.checkWinner());
    }

    @Test
    public void verticalLineWins()
    {
        //**Scenario**: Simple vertical line
        //**Given** empty board
        fourConnectModel.resetModel();
        //**When** player1 drops disks always in col 0
        //**And** player2 drops his disks always in col 1
        //**Then** after 4 rounds player1 has won the game
        Assert.assertTrue(false);
    }

    @Test
    public void diagonalLineUpWins()
    {
        int[] turns1 = { 0,1,3,2,3 };
        int[] turns2 = { 1,2,2,4,3 };
        int actualTurn;
        //**Scenario:** Simple diagonal line up
        //**Given** empty board
        fourConnectModel.resetModel();
        //**When** player1 drops his disks in cols 0,1,3,2,3,3
        //**And** player2 drops his discs in cols 1,2,2,4,3
        for (int turn = 0; turn < 5; turn++) {
            actualTurn  = convertColumnToModel(turns1[turn]);
            fourConnectModel.playersTurn(actualTurn);
            fourConnectModel.incrementCount();
            actualTurn  = convertColumnToModel(turns2[turn]);
            fourConnectModel.playersTurn(actualTurn);
            fourConnectModel.incrementCount();
        }
        fourConnectModel.playersTurn(convertColumnToModel(3));

        //**Then** after 6 rounds player1 has won the game
        Assert.assertEquals("R", fourConnectPresenter.checkWinner());
    }

    @Test
    public void diagonalLineDownWins()
    {
        //**Scenario:** Simple diagonal line down
        //**Given** empty board
        //**When** player1 drops his disks in cols 0,0,3,0,1,2
        //**And** player2 drops his discs in cols 1,2,0,1,4
        //**Then** after 6 rounds player1 has won the game
        assertTrue( false );
    }

}
