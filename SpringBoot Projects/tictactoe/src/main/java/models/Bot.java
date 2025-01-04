package models;

public class Bot extends Player{
	public Bot(String name, char symbol, PlayerType playerType ,BotDifficultyLevel level) {
		super(name, symbol, playerType);
		this.botDifficultyLevel=level;
	}

	private BotDifficultyLevel botDifficultyLevel;

	public BotDifficultyLevel getBotDifficultyLevel() {
		return botDifficultyLevel;
	}

	public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
		this.botDifficultyLevel = botDifficultyLevel;
	}
}
