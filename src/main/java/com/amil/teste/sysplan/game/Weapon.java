package com.amil.teste.sysplan.game;

public class Weapon {

	private String name;
	private int used = 1;

	public Weapon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsed() {
		return used;
	}

	public void addUsed() {
		this.used++;
	}
}