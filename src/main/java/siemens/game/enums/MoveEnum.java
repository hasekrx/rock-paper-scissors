package siemens.game.enums;

public enum MoveEnum {
	ROCK {
		@Override
		public boolean defeat(MoveEnum otherMove) {
			return otherMove == SCISSORS;
		}
	},
	PAPER {
		@Override
		public boolean defeat(MoveEnum otherMove) {
			return otherMove == ROCK;
		}
	},
	SCISSORS {
		@Override
		public boolean defeat(MoveEnum otherMove) {
			return otherMove == PAPER;
		}
	};

	public abstract boolean defeat(MoveEnum otherMove);
}
