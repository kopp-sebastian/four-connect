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

}
