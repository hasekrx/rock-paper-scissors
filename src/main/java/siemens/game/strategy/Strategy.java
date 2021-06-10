package siemens.game.strategy;

import siemens.game.enums.MoveEnum;
import siemens.game.enums.StrategyEnum;

public interface Strategy {

	public StrategyEnum getType();

	public MoveEnum getMove();

}
