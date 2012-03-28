package org.games.quizzes;

public class QuizzFactory {

	// make these an enum for type safety
	public static String DAYS_OF_THE_WEEK = "daysOfTheWeek";
	public static String MONTHS_OF_THE_YEAR = "monthsOfTheYear";

	public static Quizz getQuizz(String quizzType) {
		if (quizzType.equals(DAYS_OF_THE_WEEK))
			return new DaysOfTheWeek();
		if (quizzType.equals(MONTHS_OF_THE_YEAR))
			return new MonthsOfTheYear();
		return null;
	}
}
