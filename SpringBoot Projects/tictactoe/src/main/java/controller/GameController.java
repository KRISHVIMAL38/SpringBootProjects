package controller;

import java.util.List;

import models.Game;
import models.GameState;
import models.Player;

public class GameController {
	public Game createGame(int dimension,List<Player>players) {
		return Game.getBuilder()
				.setDimension(dimension)
				.setPlayers(players)
				.build();
	}
	
	public void executeMove(Game game) {
		game.makeNextMove();
	}
	
	public void displayBoard(Game game) {
		game.getBoard().displayBoard();
	}
	
	public String getWinner(Game game) {
		return game.getWinningPlayer().getName();
	}
	
	public GameState getGameStatus(Game game) {
		return game.getGameState();
	}
	
	public void setGameStatus(Game game,GameState gameState) {
		game.setGameState(gameState);
	}
}
