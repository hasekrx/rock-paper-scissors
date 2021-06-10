package siemens.app;

import java.util.Scanner;

import siemens.game.Game;
import siemens.game.Player;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.StrategyFactory;

public final class MainApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to the Rock paper Scissors Game");
		System.out.println("---------------------------------------");

		System.out.println("Players have two possible strategies: Random or Always Stone");
		System.out.println("Type random or stone");

		Scanner in = new Scanner(System.in);

		StrategyEnum strategy1 = validateStrategyInput(in, "Player One Strategy:");
		StrategyEnum strategy2 = validateStrategyInput(in, "Player Two Strategy:");

		int rounds = validateRoundInput(in, "How many rounds should be played?");

		Player player1 = new Player("Player 1", StrategyFactory.getStrategy(strategy1));
		Player player2 = new Player("Player 2", StrategyFactory.getStrategy(strategy2));

		Game game = new Game(player1, player2, rounds);

		game.runGame();
		game.printScoreBoard();

		in.close();
		System.exit(0);
	}

	private static int validateRoundInput(Scanner in, String msg) {
		int number = 0;
		while (number <= 0) {
			System.out.println(msg);
			while (!in.hasNextInt()) {
				String input = in.next();
				System.out.printf("\"%s\" is not a valid number.\n", input);
			}

			number = in.nextInt();

			if (number <= 0) {
				System.out.printf("Choose at least one round.\n");
			}
		}
		return number;
	}

	private static StrategyEnum validateStrategyInput(Scanner in, String msg) {

		boolean userInputIncorrect = true;
		String strategy;
		do {
			System.out.println(msg);

			strategy = in.next();
			if (!StrategyEnum.exists(strategy)) {
				System.out.printf("\"%s\" is not a valid \n", strategy);
			} else {
				userInputIncorrect = false;
			}

		} while (userInputIncorrect);

		return StrategyEnum.valueOf(strategy.toUpperCase());
	}

}