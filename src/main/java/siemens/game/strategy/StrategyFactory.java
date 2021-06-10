package siemens.game.strategy;

import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.impl.RandomStrategy;
import siemens.game.strategy.impl.StoneStrategy;

public class StrategyFactory {
	
	public static Strategy getStrategy(StrategyEnum type) {
		if(type.equals(StrategyEnum.RANDOM)) {
			return new RandomStrategy();
		} else {
			return new StoneStrategy();
		}
	}

}
