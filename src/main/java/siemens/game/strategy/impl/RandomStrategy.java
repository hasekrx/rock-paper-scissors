package siemens.game.strategy.impl;

import java.util.Random;

import siemens.game.enums.MoveEnum;
import siemens.game.enums.StrategyEnum;
import siemens.game.strategy.Strategy;

public class RandomStrategy implements Strategy {

	@Override
	public StrategyEnum getType() {
		return StrategyEnum.RANDOM;
	}

	@Override
	public MoveEnum getMove() {
		Random r = new Random();
		Integer index = r.nextInt(MoveEnum.values().length);
		return MoveEnum.values()[index];
	}

}
