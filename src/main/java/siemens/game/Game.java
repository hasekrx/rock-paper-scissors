package siemens.game;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import siemens.game.enums.MoveEnum;

@Data
public class Game {

	private final static String TIE = "tie";

	private Player player1;
	private Player player2;
	private Integer rounds;
	private Map<String, Integer> score = new HashMap<>();

	public Game(Player p1, Player p2, Integer rounds) {
		this.player1 = p1;
		this.player2 = p2;
		this.rounds = rounds;
		initializeScore();
	}

	public void runGame() {
		for (int i = 0; i < rounds; i++) {
			String winner = getWinner(player1, player2);
			scoreWinner(winner);
		}
	}

	public void printScoreBoard() {
		for (Map.Entry<String, Integer> entry : score.entrySet()) {
			if (entry.getKey().equals("tie")) {
				System.out.println(String.format("During the game we had %d ties", entry.getValue()));
			} else {
				System.out.println(String.format("%s has %d points", entry.getKey(), entry.getValue()));
			}
		}
	}

	public String getWinner(Player player1, Player player2) {

		MoveEnum moveP1 = player1.getStrategy().getMove();
		MoveEnum moveP2 = player2.getStrategy().getMove();

		if (moveP1.equals(moveP2))
			return "tie";

		if (moveP1.defeat(moveP2)) {
			return player1.getName();
		}

		return player2.getName();
	}

	private void scoreWinner(String winner) {
		score.put(winner, score.get(winner) + 1);
	}

	private void initializeScore() {
		score.put(this.player1.getName(), 0);
		score.put(this.player2.getName(), 0);
		score.put(TIE, 0);
	}

}
