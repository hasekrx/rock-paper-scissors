package siemens.game.strategy;

import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.impl.PaperStrategy;
import siemens.game.strategy.impl.RandomStrategy;
import siemens.game.strategy.impl.ScissorsStrategy;
import siemens.game.strategy.impl.StoneStrategy;

public class StrategyFactory {

	public static Strategy getStrategy(StrategyEnum type) {
		if (type.equals(StrategyEnum.RANDOM)) {
			return new RandomStrategy();
		}

		if (type.equals(StrategyEnum.STONE)) {
			return new StoneStrategy();
		}

		if (type.equals(StrategyEnum.SCISSORS)) {
			return new ScissorsStrategy();
		} else {
			return new PaperStrategy();
		}
	}

}
