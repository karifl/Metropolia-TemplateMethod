package templateMethod;

import java.util.Scanner;

public class Player implements Players {

	private Scanner myChoice = new Scanner(System.in);
	int maxChambers=6;
	int minChambers =1;

	public int kill = 0;
	 public int wheel = 0;
	
	 public Player(){
	
	 }
	
	
	@Override
	public int[] pullTrigger(int[]numbers) {
		// TODO Auto-generated method stub 
		int	chamber = numbers[1];
		int	bullet = numbers[0];
				System.out.println("\n*CLICK*\n");
				if(chamber == bullet) {
					numbers[2]=1;
				return numbers;
				}
				if(chamber == 1) {
					chamber=2;
				}
				else if(chamber == 2) {
					chamber=3;
				}
				else if(chamber == 3) {
					chamber=4;
				}
				else if(chamber ==4) {
					chamber=5;
				}
				else if(chamber == 5) {
					chamber=6;
				}
				else if(chamber >= 6) {
					chamber=1;
					//System.out.println("jos chamber oli 6, tämän pitäisi olla yksi: "+ chamber);
					
				}else {
					System.out.println("MAHDOTONTA!!!");
					}

		
		//System.out.println("chamber after trigger: " + chamber);
		numbers[1]=chamber;
		return numbers;	
		
	}
	

	public int[] spinChamber(int []numbers) {
		// TODO Auto-generated method stub
		//System.out.println("chambers before rolling: " +numbers[1]);
		numbers[1] = (int) (Math.random()* ((maxChambers - minChambers)+1)+minChambers);
		//System.out.println("chambers after rolling: " +numbers[1]);
		return numbers;
	}


	public int[] action(int[]numbers) {
	
		int choice = 0;
	
		//System.out.println("bullet: " + numbers[0]);
		//System.out.println("Chamber: " + numbers[1]);
		
		System.out.println("What do you want to do?");
		System.out.println("\n1 = pull the trigger");
		System.out.println("\n2 = spin the wheel & pull the trigger");
		
		choice = myChoice.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("Pulling the trigger..");
			numbers = pullTrigger(numbers);
			//System.out.println("chamber: "+numbers[1]);
			break;
			
		case 2:
			System.out.println("Spinning the wheel:");
			numbers = spinChamber(numbers);
			numbers = pullTrigger(numbers);			
			break;
		
		default:
			break;
		}
		//System.out.println("bullet after switch: " + kill);
		//System.out.println("chamber after switch: " + wheel);
		return numbers;
		}
	}



