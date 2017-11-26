package org.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import org.games.quizzes.QuizzFactory;

public class IOUtils {

	private static final String PLEASE_SELECT_AMONG_CHOICES = "PLEASE_SELECT_AMONG_CHOICES";
	private static final String WHAT_GAME = "WHAT_GAME";
	private static final String GAME_TYPE_DAYS = "GAME_TYPE_DAYS";
	private static final String GAME_TYPE_MONTHS = "GAME_TYPE_MONTHS";
	private static final String CAPITAL_OF_THE_WORLD = "CAPITAL_OF_THE_WORLD";

	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static int safeReadIntegerFromKeyBoardInput(ResourceBundle messages) {
		int answer = -1;
		try {
			String line = br.readLine();
			if (line != null) {
				answer = Integer.parseInt(line);
			}
		} catch (NumberFormatException e) {
			System.out.println(messages.getString(PLEASE_SELECT_AMONG_CHOICES));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answer;
	}

	public static String getAnswerFromKeyBoard() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String readQuizzTypeFromKeyBoard(ResourceBundle messages) {
		String quizzType = "";
		while (true) {
			System.out.println(messages.getString(WHAT_GAME));
			System.out.println("1. " + messages.getString(GAME_TYPE_DAYS));
			System.out.println("2. " + messages.getString(GAME_TYPE_MONTHS));
			System.out.println("3. " + messages.getString(CAPITAL_OF_THE_WORLD));

			int choice = IOUtils.safeReadIntegerFromKeyBoardInput(messages);

			if (choice == -1) {
				continue;
			}
			if (choice == 1) {
				quizzType = QuizzFactory.DAYS_OF_THE_WEEK;
				break;
			}
			if (choice == 2) {
				quizzType = QuizzFactory.MONTHS_OF_THE_YEAR;
				break;
			}if (choice == 3) {
				quizzType = QuizzFactory.CAPITAL_OF_THE_WORLD;
				break;
			}
		}
		return quizzType;
	}

	

}
