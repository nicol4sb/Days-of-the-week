package org.games.quizzes;

public class QuizzFactory {

	// make these an enum for type safety
	public static final String DAYS_OF_THE_WEEK = "daysOfTheWeek";
	public static final String MONTHS_OF_THE_YEAR = "monthsOfTheYear";
	public static final String CAPITAL_OF_THE_WORLD = "capitalsOfTheWorld";
	
	public static Quizz getQuizz(String quizzType) {
		if (quizzType.equals(DAYS_OF_THE_WEEK))
			return new DaysOfTheWeek();
		if (quizzType.equals(MONTHS_OF_THE_YEAR))
			return new MonthsOfTheYear();
		if (quizzType.equals(CAPITAL_OF_THE_WORLD))
			return new CapitalsOfTheWorld();
		return null;
	}
}
