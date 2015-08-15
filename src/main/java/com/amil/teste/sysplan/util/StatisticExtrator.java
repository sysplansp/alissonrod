package com.amil.teste.sysplan.util;

import java.util.List;

import com.amil.teste.sysplan.game.Player;
import com.amil.teste.sysplan.game.Weapon;

public class StatisticExtrator {

	List<Player> players;

	public StatisticExtrator(List<Player> players) {
		this.players = players;
	}

	public void extrator() {
		System.out.println("##################################################### Ranking Geral #####################################################");
		for (Player player : players) {
			System.out.println(String.format("Jogador: %s | N\u00famero de assassinatos: %d | N\u00famero de mortes: %d | Arma preferida: %s ", player.getName(),
					player.getMurders(), player.getDeaths(), getFavoriteWeapon(player)));
		}
		System.out.println("#########################################################################################################################");
	}

	private String getFavoriteWeapon(Player player) {

		String weaponName = "Nenhuma arma utilizada na partida.";
		int amount = 0;
		for (Weapon weapon : player.getWeapons()) {
			
			if (amount == weapon.getUsed()) {
				weaponName = weaponName + ", " + weapon.getName();
			} else if (weapon.getUsed() > amount) {
				weaponName = weapon.getName();
				amount = weapon.getUsed();
			}
		}
		return weaponName;
	}
}
