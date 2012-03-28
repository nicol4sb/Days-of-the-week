package org.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.games.quizzes.Quizz;
import org.games.quizzes.QuizzFactory;

public class QuestionAndAnswer {

	private static ResourceBundle messages;
	private static String CONGRATS_SCORE_TEMPLATE = "CONGRATS_SCORE_TEMPLATE";
	private static final String BRAVO = "BRAVO";
	private static final String TRY_AGAIN = "TRY_AGAIN";
	private static final String NOPE = "NOPE";
	private static final String WHAT_GAME = "WHAT_GAME";
	private static final String GAME_TYPE_DAYS = "GAME_TYPE_DAYS";
	private static final String GAME_TYPE_MONTHS = "GAME_TYPE_MONTHS";
	private static final String DO_YOU_WANT_TO_GO_ON_1_YES_2_NO = "DO_YOU_WANT_TO_GO_ON_1_YES_2_NO";
	private static final String PLEASE_SELECT_AMONG_CHOICES = "PLEASE_SELECT_AMONG_CHOICES";

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws IOException {

		// game language selection
		Locale selectedLocale = Locale.FRENCH;
		String quizzType = QuizzFactory.DAYS_OF_THE_WEEK; // default
		loadMessages();

		while (true) {
			System.out.println("Choose your language");
			System.out.println("1. English");
			System.out.println("2. French");

			int choice = safeReadIntegerFromKeyBoardInput();

			if (choice == -1) {
				continue;
			}
			if (choice == 1) {
				selectedLocale = Locale.ENGLISH;
				break;
			}
			if (choice == 2) {
				selectedLocale = Locale.FRENCH;
				break;
			}
		}

		Locale.setDefault(selectedLocale);

		loadMessages();

		int score = 0;
		int numberOfQuestionsAsked = 0;
		int maxQuestions = 3;
		int numberOfTimesQuestionIsRepeatedInCaseOfFailure = 3;

		// ask the questions until game's end
		while (true) {

			// choose the type of game
			if (numberOfQuestionsAsked == 0) {
				quizzType = readQuizzTypeFromKeyBoard();
			}

			// check if game should be terminated
			if (numberOfQuestionsAsked >= maxQuestions) {
				System.out.println(MessageFormat.format(
						messages.getString(CONGRATS_SCORE_TEMPLATE), score,
						numberOfQuestionsAsked));

				while (true) {
					System.out.println(messages
							.getString(DO_YOU_WANT_TO_GO_ON_1_YES_2_NO));

					int answer = safeReadIntegerFromKeyBoardInput();

					if (answer == -1) {
						continue;
					}
					if (answer == 1) {
						quizzType = readQuizzTypeFromKeyBoard();
						break;
					}
					if (answer == 2) {
						System.exit(0);
					}
				}

				// reset score
				score = 0;
				numberOfQuestionsAsked = 0;
			}

			// start a new quizz
			Quizz quizz = QuizzFactory.getQuizz(quizzType);

			int numberOfTimesTheQuestionHasBeenRepeated = 0;
			while (numberOfTimesTheQuestionHasBeenRepeated < numberOfTimesQuestionIsRepeatedInCaseOfFailure
					&& numberOfQuestionsAsked < maxQuestions) {

				if (numberOfTimesTheQuestionHasBeenRepeated > 0) {
					System.out.println(messages.getString(TRY_AGAIN));
				}

				System.out.println(quizz.getQuestion());
				numberOfQuestionsAsked++;

				String answerGiven = br.readLine();

				if (answerGiven.equalsIgnoreCase(quizz.getAnswer())) {
					System.out.println(messages.getString(BRAVO));
					score++;
					break;
				} else {
					numberOfTimesTheQuestionHasBeenRepeated++;
					if (numberOfTimesTheQuestionHasBeenRepeated > 0) {
						System.out.println(messages.getString(NOPE));
					}
				}
			}
		}

	}

	private static String readQuizzTypeFromKeyBoard() {
		String quizzType = "";
		while (true) {
			System.out.println(messages.getString(WHAT_GAME));
			System.out.println("1. " + messages.getString(GAME_TYPE_DAYS));
			System.out.println("2. " + messages.getString(GAME_TYPE_MONTHS));

			int choice = safeReadIntegerFromKeyBoardInput();

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
			}
		}
		return quizzType;
	}

	private static void loadMessages() {
		messages = ResourceBundle.getBundle("MessagesBundle",
				Locale.getDefault());
	}

	private static int safeReadIntegerFromKeyBoardInput() {

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
}