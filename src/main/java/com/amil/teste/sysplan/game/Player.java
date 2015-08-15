package com.amil.teste.sysplan.game;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int death;
	private String name;
	private int murder;
	private List<Weapon> weapons = new ArrayList<Weapon>(); 

	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, String weaponName) {
		this.name = name;
		this.increaseWeaponsUsed(weaponName);
	}

	public int getDeaths() {
		return death;
	}

	public void addDeath() {
		this.death++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMurders() {
		return murder;
	}

	public void addMurder() {
		this.murder++;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void increaseWeaponsUsed(String weaponName) {
		if (!containsWeapon(weaponName)) {
			weapons.add(new Weapon(weaponName));
		}

		for (Weapon weapon : weapons) {
			if (weapon.getName().equals(weaponName)) {
				weapon.addUsed();
				break;
			}
		}
	}
	
	private boolean containsWeapon(String weaponName) {
		for (Weapon gun : weapons) {
			if (gun.getName().equals(weaponName)) {
				return true;
			}
		}
		return false;
	}
}
