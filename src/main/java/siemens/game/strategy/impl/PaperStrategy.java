package siemens.game.strategy.impl;

import siemens.game.enums.MoveEnum;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.Strategy;

public class PaperStrategy implements Strategy {

	@Override
	public StrategyEnum getType() {
		return StrategyEnum.PAPER;
	}

	@Override
	public MoveEnum getMove() {
		return MoveEnum.PAPER;
	}

}
