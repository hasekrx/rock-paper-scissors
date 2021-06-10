package siemens.app;

import java.util.Scanner;

import siemens.game.Game;
import siemens.game.Player;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.StrategyFactory;

public class UserChooseApplication {
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the Rock paper Scissors Game");
		System.out.println("---------------------------------------");

		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Choose your next move");
		StrategyEnum strategy1 = validateStrategyInput(in, "Type stone, paper or scissors");
		StrategyEnum strategy2 = StrategyEnum.RANDOM;
		
		Player player1 = new Player("User Player", StrategyFactory.getStrategy(strategy1));
		Player player2 = new Player("Player 2", StrategyFactory.getStrategy(strategy2));

		Game game = new Game(player1, player2, 1);
		
		game.runGame();
		game.printScoreBoard();
		
	}
	
	private static StrategyEnum validateStrategyInput(Scanner in, String msg) {
		
		boolean userInputIncorrect = true;
		String strategy;
		do {
			System.out.println(msg);
			
			strategy = in.next();
			if(!StrategyEnum.exists(strategy)) {
				System.out.printf("\"%s\" is not a valid \n", strategy);
			} else {
				userInputIncorrect = false;
			}
			
		} while (userInputIncorrect);
	
		return StrategyEnum.valueOf(strategy.toUpperCase());
	}

}
