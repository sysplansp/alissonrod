package com.amil.teste.sysplan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.amil.teste.sysplan.game.Player;
import com.amil.teste.sysplan.util.LogExtrator;
import com.amil.teste.sysplan.util.StatisticExtrator;

/**
 * Hello world!
 *
 */
public class App {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Digite ctrl+z para sair ou informe o pathname do arquivo de log da partida: ");
		Scanner sc = new Scanner(System.in);
		String text;

		while (sc.hasNext()) {
			text = sc.next();

			File gameLog = new File(text);

			while (!gameLog.isFile()) {
				System.out.println("Digite ctrl+z para sair ou informe o pathname do arquivo de log da partida: ");
				sc = new Scanner(System.in);

				text = sc.next();
				gameLog = new File(text);
			}
			
			try {
				processLog(gameLog);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void processLog(File gameLog) throws FileNotFoundException {
		
		LogExtrator logExtrator = new LogExtrator(gameLog);
		List<Player> players = logExtrator.extrator();
		StatisticExtrator statistic = new StatisticExtrator(players);
		statistic.extrator();
	}
}
