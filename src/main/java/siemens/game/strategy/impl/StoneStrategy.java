package siemens.game.strategy.impl;

import siemens.game.enums.MoveEnum;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.Strategy;

public class StoneStrategy implements Strategy {

	@Override
	public StrategyEnum getType() {
		return StrategyEnum.STONE;
	}

	@Override
	public MoveEnum getMove() {
		return MoveEnum.ROCK;
	}

}
