package siemens.game.enums;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoveEnumTest {

	@Test
	public void whenRockAgainstScissors_RockWins() {
		assertTrue(MoveEnum.ROCK.defeat(MoveEnum.SCISSORS));
	}

	@Test
	public void whenRockAgainstPaper_RockLose() {
		assertFalse(MoveEnum.ROCK.defeat(MoveEnum.PAPER));
	}

	@Test
	public void whenScissorsAgainstPaper_ScissorsWin() {
		assertTrue(MoveEnum.SCISSORS.defeat(MoveEnum.PAPER));
	}

	@Test
	public void whenScissorsAgainstRock_ScissorsLose() {
		assertFalse(MoveEnum.SCISSORS.defeat(MoveEnum.ROCK));
	}
	
	@Test
	public void whenPaperAgainstRock_PaperWin() {
		assertTrue(MoveEnum.PAPER.defeat(MoveEnum.ROCK));
	}
	
	@Test
	public void whenPaperAgainstScissors_PaperLose() {
		assertFalse(MoveEnum.PAPER.defeat(MoveEnum.SCISSORS));
	}
	
	

}
