package org.games.quizzes;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class DaysOfTheWeek implements Quizz {

	private String question;
	private String answer;

	private static final Random RND = new Random();

	private static final String WHAT_DAY_COMES_BEFORE_TEMPLATE = "WHAT_DAY_COMES_BEFORE_TEMPLATE";
	private static final String WHAT_DAY_COMES_AFTER_TEMPLATE = "WHAT_DAY_COMES_AFTER_TEMPLATE";

	public DaysOfTheWeek() {

		SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
		ResourceBundle messages = ResourceBundle.getBundle("Quizzes",
				Locale.getDefault());

		// get a random date
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, RND.nextInt(6));

		if (RND.nextDouble() > 0.5) {
			this.question = MessageFormat.format(
					messages.getString(WHAT_DAY_COMES_AFTER_TEMPLATE),
					dayOfWeekFormat.format(cal.getTime()));

			cal.add(Calendar.DAY_OF_WEEK, 1);
			this.answer = dayOfWeekFormat.format(cal.getTime());
		} else {
			this.question = MessageFormat.format(
					messages.getString(WHAT_DAY_COMES_BEFORE_TEMPLATE),
					dayOfWeekFormat.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_WEEK, -1);
			this.answer = dayOfWeekFormat.format(cal.getTime());
		}
	}

	@Override
	public String getQuestion() {
		return this.question;
	}

	@Override
	public String getAnswer() {
		return this.answer;
	}
}
