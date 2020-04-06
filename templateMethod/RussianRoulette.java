package templateMethod;

import java.lang.Math;
public class RussianRoulette extends Game{

	private boolean gameOver_player1=false;
	private boolean gameOver_player2=false;
	private int bet=0;
	

	Player one = new Player();
	Player two = new Player();

	
	@Override
	void makePlay(int player) {

		
	}

	@Override
	boolean endOfGame() {
		boolean ready = true;
		// TODO Auto-generated method stub
		return ready;
	}

	@Override
	void printWinner() {
		// TODO Auto-generated method stub
		
		if (this.gameOver_player1 == true) {
			System.out.println("Player 2 wins!");
			System.out.println("Player 2 receives: " +this.bet + " $");
		}
		if(this.gameOver_player2 == true) {
			System.out.println("Player 1 wins!");
			System.out.println("Player 1 receives: " +this.bet + " $");
		}
		}

	@Override
	
	void initializeGame() {
		// TODO Auto-generated method stub
		int bullet= 1;
		int[] number = new int[3]; //[0] = bullet, [1]= chamber, [2] = dead
		int chamber = 1;
		int maxChambers=6;
		int minChambers =1;
		this.bet = 500;
		
		System.out.println("Welcome to the Russian Roulette! \n Good Luck!\n");
		
		bullet =(int) (Math.random()* ((maxChambers - minChambers)+1)+minChambers); //initialize the bullet
		chamber = (int) (Math.random()* ((maxChambers - minChambers)+1)+minChambers);		//initalize the starting chamber
		
		number[0]=bullet;
		number[1]=chamber;
		
		while(!this.gameOver_player1 || !this.gameOver_player2 ) { 
			System.out.println("Player 1's turn to try");
			number = one.action(number);
			if(number[2] == 1) {
				System.out.println("*BANG* You shot your brains out.\n\n");
				this.gameOver_player1 = true;
				break;
			}
			
			System.out.println("Player 2's turn to try");
			number  =	two.action(number);
			if(number[2] == 1) {
				System.out.println("*BANG* You shot your brains out.");
				this.gameOver_player2 = true;
				break;
			}
			System.out.println("\n**********\n");
			
			this.bet= this.bet+this.bet;	
		}
		endOfGame();
		printWinner();	
		
		
	}

}
