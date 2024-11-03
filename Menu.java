package Project1;

//Habiba Elswify
//ID number - 202517637
//May 6, 2024
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class Menu extends Burger211 {

	// variables

	String country;
	String franchise;
	double discountRate;
	String promotion;
	String currencyCode;
	String currencySymbol;
	int updatedBurgerKey = -1;
	String updatedTopping;

	static double exchangeRate;
	static double temperature;

	String[] localPrice = new String[getHowManyBurgers() + 1]; 
	String pro = "";

	// Menu Constructor
	Menu(String country, String franchise) throws Exception {

		//superclass, burger 211, constructor
		super(country, exchangeRate, franchise);

		Locale locale = new Locale.Builder().setRegion(country).build();

		currencyCode = Currency.getInstance(locale).getCurrencyCode();
		currencySymbol = Currency.getInstance(locale).getSymbol();

		this.country = country;
		this.franchise = franchise;

		// read the exchange rate of the country

		try {
			exchangeRate = ExchangeRate.getRate(currencyCode); //gets the exchange rate using the currency code we defined earlier using Locale 

		} catch (Exception e) {

			e.printStackTrace();

		}
		try {
			temperature = Weather211.CityWeather(franchise); // reads the weather of the franchise city

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	//setting the promotion with the discount rate
	public void Promotion(double d, String promotion) {
		discountRate += d;
		pro += promotion;

	}
	public void PromotionTooHot(int tooHot) {
		if (temperature >= (double) tooHot) {
			discountRate += 0.1;
			pro += "Extra 10% off! Too hot to eat!";
		}

	}
	@Override
	public void printMenu() {
		
		//formatting
		DecimalFormat df = new DecimalFormat("#, ###, ###.0");


		//using a for loop to multiply each burger price by the discount, if there is one
		for (int i = 1; i <= getHowManyBurgers(); i++) {
			localPrice[i] = df.format(getPrice(i) * (1.0 - discountRate)); 

			//stating the regular price if there is a discount
			if (discountRate > 0.0) {
				localPrice[i] += "(regular: " + currencySymbol + df.format(getPrice(i) + ")");
			}
		}

		// call API
		new MenuGUI(franchise, pro, getName(1), currencySymbol + localPrice[1], getTopping(1), getName(2),currencySymbol + localPrice[2], getTopping(2), getName(3), currencySymbol + localPrice[3], getTopping(3), exchangeRate, temperature);

	}

	// Overridden methods from Burger211
	@Override
	public double getPrice(int i) {
		return (super.getPrice(i) * exchangeRate);

	}

	// Using i, as the key for the HashMap we are getting the BurgerInfo as the value and then we put it into the variable burger. Which we then use to get the name from BurgerInfo
	@Override
	public String getName(int i) {
		BurgerInfo burger = getBurger(i);
		return burger.name;
	}

	// right now updatedBurgerrKey is -1, as we stated above. So if i is equal to any any number from 1 then it updated the toppings, else it returns the original toppings
	@Override
	public String getTopping(int i) {
		if (i == updatedBurgerKey) {
			return (updatedTopping);
		} else {
			return super.getTopping(i);
		}
	}

	//updating toppings of burger
	public void updateTopping(int burgerNumber, String newTopping) {
		updatedBurgerKey = burgerNumber;
		updatedTopping = newTopping;
	}

	
	

	//method to check temperature for additional discount
	

}