package models;

import java.util.LinkedList;
import java.util.List;

import exceptions.InvalidGameDimensionsException;
import strategy.gameWinningStrategy.GameWinningStrategy;
import strategy.gameWinningStrategy.OrderOneGameWinningStrategy;

public class Game {
	private Board board;
	private List<Player>players;
	private List<Move>moves;
	private GameState gameState;
	private int nextPlayerIndex;
	private Player winningPlayer;
	private GameWinningStrategy gameWinningStrategy;
	private Game() {}
	
	public void makeNextMove() {
		Player currentPlayer=players.get(getNextPlayerIndex());
		System.out.println("It's "+currentPlayer.getName()+" 's turn");
		Move move =currentPlayer.decideMove(board);
		
		int row=move.getCell().getRow();
		int col=move.getCell().getCol();
		
		if(board.getBoard().get(row).get(col).getCellstatus().equals(CellState.AVAIALABLE)) {
			//valid move
			board.applyMove(move);
			moves.add(move);
			
			//checkForWinner
			if(gameWinningStrategy.checkForWinner(board, move)) {
				gameState=gameState.WIN;
				winningPlayer=currentPlayer;
			}
			
			nextPlayerIndex+=1;
			nextPlayerIndex%=players.size();
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	public GameWinningStrategy getGameWinningStrategy() {
		return gameWinningStrategy;
	}
	public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
		this.gameWinningStrategy = gameWinningStrategy;
	}
	public Player getWinningPlayer() {
		return winningPlayer;
	}
	public void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	public GameState getGameState() {
		return gameState;
	}
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	public int getNextPlayerIndex() {
		return nextPlayerIndex;
	}
	public void setNextPlayerIndex(int nextPlayerIndex) {
		this.nextPlayerIndex = nextPlayerIndex;
	}
	
	public static class Builder{
		private int dimension;
		private List<Player>players;
		
		public Game build() {
			try {
				isvalid();
			}
			catch(InvalidGameDimensionsException ex) {
				System.out.println("Error has occured");
				return null;
			}
			
			Game game=new Game();
			game.setBoard(new Board(dimension));
			game.setGameState(GameState.IN_PROGRESS);
			game.setNextPlayerIndex(0);
			game.setPlayers(players);
			game.setMoves(new LinkedList<>());
			game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
			
			return game;
		}
		
		private void isvalid() throws InvalidGameDimensionsException {
			if(this.dimension<3) {
				throw new InvalidGameDimensionsException("Dimension must be >=3");
			}
		}
		public int getDimension() {
			return dimension;
		}
		public Builder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}
		public List<Player> getPlayers() {
			return players;
		}
		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}
		
		
	}
}
