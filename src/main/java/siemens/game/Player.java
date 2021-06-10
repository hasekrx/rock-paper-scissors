package siemens.game;

import lombok.Data;
import siemens.game.strategy.Strategy;

@Data
public class Player {

	private String name;
	private Strategy strategy;

	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}

}
