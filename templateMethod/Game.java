package templateMethod;

public abstract class Game {
	
	protected int playersCount;
	
	abstract void initializeGame();
	
	abstract void makePlay(int player);
	
	abstract boolean endOfGame();
	
	abstract void printWinner();
	
	//Template method
	
	public final void playOneGame(int playersCount) {
		this.playersCount = playersCount;
		initializeGame();
		int i=0;
		while (!endOfGame()) {
			makePlay(i);
			i=(i+1) % playersCount;
		}
		printWinner();
	}



}
