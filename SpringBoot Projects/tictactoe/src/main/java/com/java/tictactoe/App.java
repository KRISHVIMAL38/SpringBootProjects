package com.java.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import controller.GameController;
import models.Bot;
import models.BotDifficultyLevel;
import models.Game;
import models.GameState;
import models.Player;
import models.PlayerType;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!: Game is starting...");
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the dimension");
        int dimension=sc.nextInt();
        
        System.out.println("Enter the no of players");
        int noOfPlayers=sc.nextInt();
        
        List<Player>players=new ArrayList<>();
        System.out.println("Will there be any bot : y/n");
        String isBot=sc.next();
        
        if(isBot.equals("y")) {
        	noOfPlayers-=1;
        	System.out.println("Enter the name of bot");
        	String botName=sc.next();
        	
        	System.out.println("Enter the symbol of the bot");
        	char symbol=sc.next().charAt(0);
        	
        	System.out.println("Enter the difficulty level of the bot : 1.Easy 2.Medium 3.Hard");
        	int difficultyLevel=sc.nextInt();
        	
        	Bot bot =new Bot(botName,symbol,PlayerType.BOT,BotDifficultyLevel.fromValue(difficultyLevel));
        	players.add(bot);
        }
        
        for(int i=0;i<noOfPlayers;i++) {
        	System.out.println("Enter the name of the player ");
        	String playerName=sc.next();
        	
        	System.out.println("Enter the symbol of the player ");
        	char symbol=sc.next().charAt(0);
        	
        	Player player=new Player(playerName,symbol,PlayerType.HUMAN);
        	players.add(player);
        }
        
        GameController controller=new GameController();
        Game game=controller.createGame(dimension, players);
        
        controller.setGameStatus(game, GameState.IN_PROGRESS);
        
        while(controller.getGameStatus(game).equals(GameState.IN_PROGRESS)) {
        	System.out.println("Current Board");
        	game.getBoard().displayBoard();
        	
        	controller.executeMove(game);
        }
        
        if(controller.getGameStatus(game)==GameState.WIN) {
        	game.getBoard().displayBoard();
        	System.out.println("Winning Player is "+controller.getWinner(game));
        }
        else {
        	System.out.println("Game has been drawn");
        }
    }
}
