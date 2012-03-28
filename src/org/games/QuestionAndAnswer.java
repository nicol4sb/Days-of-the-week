package org.games;

import java.io.IOException;
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
	private static final String DO_YOU_WANT_TO_GO_ON_1_YES_2_NO = "DO_YOU_WANT_TO_GO_ON_1_YES_2_NO";

	public static void main(String[] args) throws IOException {

		// game language selection
		Locale selectedLocale = Locale.FRENCH;
		String quizzType = QuizzFactory.DAYS_OF_THE_WEEK; // default
		loadMessages();

		while (true) {
			System.out.println("Choose your language");
			System.out.println("1. English");
			System.out.println("2. French");

			int choice = IOUtils.safeReadIntegerFromKeyBoardInput(messages);

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
		int numberOfTimesQuestionIsRepeatedInCaseOfFailure = 4;

		// ask the questions until game's end
		while (true) {

			// choose the type of game
			if (numberOfQuestionsAsked == 0) {
				quizzType = IOUtils.readQuizzTypeFromKeyBoard(messages);
			}

			// check if game should be terminated
			if (numberOfQuestionsAsked >= maxQuestions) {
				System.out.println(MessageFormat.format(
						messages.getString(CONGRATS_SCORE_TEMPLATE), score,
						numberOfQuestionsAsked));

				while (true) {
					System.out.println(messages
							.getString(DO_YOU_WANT_TO_GO_ON_1_YES_2_NO));

					int answer = IOUtils
							.safeReadIntegerFromKeyBoardInput(messages);

					if (answer == -1) {
						continue;
					}
					if (answer == 1) {
						quizzType = IOUtils.readQuizzTypeFromKeyBoard(messages);
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

				String answerGiven = IOUtils.getAnswerFromKeyBoard();

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

	private static void loadMessages() {
		messages = ResourceBundle.getBundle("MessagesBundle",
				Locale.getDefault());
	}
}
