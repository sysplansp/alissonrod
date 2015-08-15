package com.amil.teste.sysplan.util;

import static com.amil.teste.sysplan.common.GamePatternConstant.KILLER_PATTERN;
import static com.amil.teste.sysplan.common.GamePatternConstant.WORLD_PATTERN;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

import com.amil.teste.sysplan.game.Player;

public class LogExtrator {

	private File gameLog;

	public LogExtrator(File gameLog) {
		this.gameLog = gameLog;
	}

	public List<Player> extrator() throws FileNotFoundException {

		Scanner input = new Scanner(gameLog);
		List<Player> players = new ArrayList<Player>();

		while (input.hasNextLine()) {

			String line = input.nextLine();
			if (line.contains("has ended")) {
				break;
			}

			if (line.contains("<WORLD> killed")) {
				Matcher m = WORLD_PATTERN.matcher(line);
				if (m.find()) {
					increaseDeadPlayer(m.group(1), players);
				}
				continue;
			}

			if (line.contains("using")) {
				Matcher m = KILLER_PATTERN.matcher(line);
				if (m.find()) {
					increaseKillerPlayer(m.group(1), m.group(2), m.group(3), players);
				}
				continue;
			}
		}
		input.close();

		return players;
	}

	private void increaseDeadPlayer(String name, List<Player> players) {

		if (!containsPlayer(players, name)) {
			players.add(new Player(name));
		}

		for (Player p : players) {

			if (name.equals(p.getName())) {
				p.addDeath();
				break;
			}
		}
	}

	private void increaseKillerPlayer(String killerName, String murderedName, String gunName, List<Player> players) {

		if (!containsPlayer(players, killerName)) {
			players.add(new Player(killerName));
		}
		
		if (!containsPlayer(players, murderedName)) {
			players.add(new Player(murderedName));
		}

		for (Player p : players) {
			if (killerName.equals(p.getName())) {
				p.addMurder();
				p.increaseWeaponsUsed(gunName);
			}

			if (murderedName.equals(p.getName())) {
				p.addDeath();
				break;
			}
		}
	}

	private boolean containsPlayer(List<Player> players, String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
