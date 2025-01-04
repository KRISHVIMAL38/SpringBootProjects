package models;

import java.util.LinkedList;
import java.util.List;

public class Board {
	List<List<Cell>>board;

	public Board(int dimension) {
		this.board=new LinkedList<>();
		for(int i=0;i<dimension;i++) {
			this.board.add(new LinkedList<>());
			for(int j=0;j<dimension;j++) {
				this.board.get(i).add(new Cell(i,j));
			}
		}
	}
	
	public void displayBoard() {
		for(int i=0;i<board.size();i++) {
			for(int j=0;j<board.size();j++) {
				if(board.get(i).get(j).getCellstatus().equals(CellState.AVAIALABLE)) {
					System.out.print("|  |");
				}
				else {
					System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol()+"|");
				}
			}
			System.out.println();
		}
	}
	
	public void applyMove(Move move) {
		int row=move.getCell().getRow();
		int col=move.getCell().getCol();
		
		this.board.get(row).get(col).setCellstatus(CellState.FILLED);
	    this.board.get(row).get(col).setPlayer(move.getPlayer());;
	}
	
	public List<List<Cell>> getBoard() {
		return board;
	}

	public void setBoard(List<List<Cell>> board) {
		this.board = board;
	}
	
	
}
