package strategy.gameWinningStrategy;

import models.Board;
import models.Move;

public interface GameWinningStrategy {
	public boolean checkForWinner(Board board,Move move);
}
