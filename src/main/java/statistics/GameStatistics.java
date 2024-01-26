package statistics;


import game.Game;

public class GameStatistics {
    private int winsAmount;
    private int losesAmount;

    public GameStatistics() {
        calculateStatistics(1000);
    }

    private void calculateStatistics(int iterationsAmount) {
        for (int i = 0; i < iterationsAmount; i++) {
            Game newGame = new Game();
            if (newGame.didParticipantWin) winsAmount++;
            else losesAmount++;
        }
    }

    @Override
    public String toString() {
        return String.format("Number of participant's wins: %d\n Number of participant's defeats: %d", winsAmount, losesAmount);
    }
}
