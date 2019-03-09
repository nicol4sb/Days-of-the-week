package org.games.quizzes;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class CapitalsOfTheWorld implements Quizz {

	private static final String WHAT_IS_THE_CAPITAL_OF = "WHAT_IS_THE_CAPITAL_OF_TEMPLATE";

	private String question;
	private String answer;

	public CapitalsOfTheWorld() {

		ResourceBundle messages = ResourceBundle.getBundle("Quizzes", Locale.getDefault());

		//ResourceBundle capitals = ResourceBundle.getBundle("Capitals",
		//		Locale.getDefault());
		
		Map<String, String> countriesToCapital = new HashMap<>();
		countriesToCapital.put("USA", "Washington D.C.");
		countriesToCapital.put("France", "Paris");
		countriesToCapital.put("Italie", "Rome");
		countriesToCapital.put("Allemagne", "Berlin");
		countriesToCapital.put("Suisse", "Bern");

		countriesToCapital.put("Maroc", "Rabat");
		countriesToCapital.put("Singapore", "Singapore");
		countriesToCapital.put("Mexico", "Mexico city");
		countriesToCapital.put("Brazil", "Brasilia");
		countriesToCapital.put("Argentina", "Buenos Aires");
		countriesToCapital.put("Croatia", "Zagreb");
		countriesToCapital.put("Myanmar", "Naypyidaw");

		countriesToCapital.put("Denmark", "Copenhagen");
		countriesToCapital.put("Finland", "Helsinki");
		countriesToCapital.put("Norway", "Oslo");
		countriesToCapital.put("Latvia", "Riga");
		countriesToCapital.put("Lithuania", "Vilnius");
		countriesToCapital.put("Estonia", "Tallinn");
		
        countriesToCapital.put("Russia", "Moscow");
        countriesToCapital.put("Bolivia", "La Paz");
        countriesToCapital.put("RDC", "Kinshasa");
        countriesToCapital.put("Algeria", "Alger");
        countriesToCapital.put("Russia", "Moscow");
        countriesToCapital.put("Russia", "Moscow");
        
        
        countriesToCapital.put("Albania","Tirana");
        countriesToCapital.put("Andorra","Andorra la Vella");
        countriesToCapital.put("Armenia","Yerevan");
        countriesToCapital.put("Austria","Vienna");
        countriesToCapital.put("Azerbaijan","Baku");
        countriesToCapital.put("Belarus","Minsk" );
        countriesToCapital.put("Belgium","Brussels" );
        countriesToCapital.put("Bosnia and Herzegovina","Sarajevo" );
        countriesToCapital.put("Bulgaria","Sofia");
        countriesToCapital.put("Cyprus","Nicosia");
        countriesToCapital.put("Czech Republic","Prague");
        countriesToCapital.put("Georgia","Tbilisi");
        countriesToCapital.put("Greece","Athens");
        countriesToCapital.put("Hungary","Budapest");
        countriesToCapital.put("Iceland","Reykjavík");
        countriesToCapital.put("Ireland","Dublin");
        countriesToCapital.put("Kazakhstan","Astana");
        countriesToCapital.put("Liechtenstein","Vaduz");
        countriesToCapital.put("Luxembourg","Luxembourg");
        countriesToCapital.put("Macedonia","Skopje");
        countriesToCapital.put("Malta","Valletta");
        countriesToCapital.put("Moldova","Chisinau");
        countriesToCapital.put("Monaco","Monaco");
        countriesToCapital.put("Montenegro","Podgorica");
        countriesToCapital.put("Netherlands","Amsterdam");
        countriesToCapital.put("Poland","Warsaw");
        countriesToCapital.put("Portugal","Lisbon");
        countriesToCapital.put("Romania","Bucharest");
        countriesToCapital.put("San Marino","San Marino");
        countriesToCapital.put("Serbia","Belgrade");
        countriesToCapital.put("Slovakia","Bratislava");
        countriesToCapital.put("Slovenia","Ljubljana");
        countriesToCapital.put("Spain","Madrid");
        countriesToCapital.put("Sweden","Stockholm");
        countriesToCapital.put("Turkey","Ankara");
        countriesToCapital.put("Ukraine","Kiev");
        countriesToCapital.put("United Kingdom","London");
        countriesToCapital.put("Vatican City","Vatican City");
        

        countriesToCapital.put("South africa", "Pretoria");

		Random generator = new Random();
		List<String> keys = new ArrayList<String>(countriesToCapital.keySet());
		String randomCapital = keys.get(generator.nextInt(keys.size()));

		this.question = MessageFormat.format(messages.getString(WHAT_IS_THE_CAPITAL_OF),randomCapital);
		this.answer = countriesToCapital.get(randomCapital);
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
