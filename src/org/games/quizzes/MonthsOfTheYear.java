package org.games.quizzes;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class MonthsOfTheYear implements Quizz {

	private String question;
	private String answer;

	private static final Random RND = new Random();

	private static final String WHAT_MONTH_COMES_BEFORE_TEMPLATE = "WHAT_MONTH_COMES_BEFORE_TEMPLATE";
	private static final String WHAT_MONTH_COMES_AFTER_TEMPLATE = "WHAT_MONTH_COMES_AFTER_TEMPLATE";

	public MonthsOfTheYear() {

		SimpleDateFormat monthOfYear = new SimpleDateFormat("MMMMM");
		ResourceBundle messages = ResourceBundle.getBundle("Quizzes",
				Locale.getDefault());

		// get a random date
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, RND.nextInt(11));

		if (RND.nextDouble() > 0.5) {
			this.question = MessageFormat.format(
					messages.getString(WHAT_MONTH_COMES_AFTER_TEMPLATE),
					monthOfYear.format(cal.getTime()));
			cal.add(Calendar.MONTH, 1);
			this.answer = monthOfYear.format(cal.getTime());
		} else {
			this.question = MessageFormat.format(
					messages.getString(WHAT_MONTH_COMES_BEFORE_TEMPLATE),
					monthOfYear.format(cal.getTime()));
			cal.add(Calendar.MONTH, -1);
			this.answer = monthOfYear.format(cal.getTime());
		}
	}

	@Override
	public String getQuestion() {
		return this.question;
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return this.answer;
	}
}
