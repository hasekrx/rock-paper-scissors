package siemens.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import siemens.game.Game;
import siemens.game.Player;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.StrategyFactory;

public class GameTest {
	
	private Player p1;
	private Player p2;
	private Game game;

	@Test
	public void AllTies_WhenBothPlayerWithAlwaysStone() {
		
		p1 = new Player("p1", StrategyFactory.getStrategy(StrategyEnum.STONE));
		p2 = new Player("p2", StrategyFactory.getStrategy(StrategyEnum.STONE));
		game = new Game(p1, p2, 10);
		
		game.runGame();
		
		assertEquals(10, game.getScore().get("tie"));
		
	}
	
	/**
	 * Sum the number of victories per player and ties.
	 */
	@Test
	public void AssertRoundsPlayed_WhenBothPlayerWithRandom() {
		
		p1 = new Player("p1", StrategyFactory.getStrategy(StrategyEnum.RANDOM));
		p2 = new Player("p2", StrategyFactory.getStrategy(StrategyEnum.RANDOM));
		game = new Game(p1, p2, 10);
		
		game.runGame();
		
		int sum = game.getScore().values().stream().mapToInt(Integer::valueOf).sum();
		assertEquals(10, sum);
	}
	

	@Test
	public void AssertP1Wins_WhenBothRocksVersusScissors() {
		
		p1 = new Player("p1", StrategyFactory.getStrategy(StrategyEnum.STONE));
		p2 = new Player("p2", StrategyFactory.getStrategy(StrategyEnum.SCISSORS));
		game = new Game(p1, p2, 1);
		
		game.runGame();
		
		
		assertEquals(1, game.getScore().get(p1.getName()));
		assertEquals(0, game.getScore().get(p2.getName()));
	}
	

	@Test
	public void AssertP2Wins_WhenBothRocksVersusPaper() {
		
		p1 = new Player("p1", StrategyFactory.getStrategy(StrategyEnum.STONE));
		p2 = new Player("p2", StrategyFactory.getStrategy(StrategyEnum.PAPER));
		game = new Game(p1, p2, 1);
		
		game.runGame();
		
		assertEquals(0, game.getScore().get(p1.getName()));
		assertEquals(1, game.getScore().get(p2.getName()));
	}
}
