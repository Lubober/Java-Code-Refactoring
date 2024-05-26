public abstract class GameMode {
    public void playGame() throws Exception {
        this.initialiseGame();
        this.mainGame();
        this.declareGameWinner();
    }

    protected abstract void initialiseGame() throws Exception;

    protected abstract void declareGameWinner() throws Exception;

    protected abstract void mainGame() throws Exception;
}


