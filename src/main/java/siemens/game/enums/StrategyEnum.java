package siemens.game.enums;

public enum StrategyEnum {

	RANDOM, STONE;

	public static boolean exists(String str) {
		for (StrategyEnum stratetegy : StrategyEnum.values()) {
			if (stratetegy.name().equalsIgnoreCase(str))
				return true;
		}

		return false;
	}

}
