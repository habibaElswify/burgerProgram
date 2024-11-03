package Project1;



import java.util.ArrayList;
import java.util.HashMap;


public abstract class Burger211{

	
	private static HashMap <Integer, BurgerInfo> burger = new HashMap <> ();
	
	Burger211(String name, double price, String topping){ 
		//burger.put - putting values into the HashMap
		// numbers - key to the HashMap
		//new BurgerInfo is the new instances from the model class 
		burger.put(1, new BurgerInfo("Inheritance Burger", 4.5, "beef patty, tomato, onion, black olive, ranch sauce")); 
		burger.put(2, new BurgerInfo("@Override Burger", 5.5, "beef patty, lime, onion, lettuce, tomato sauce"));
		burger.put(3, new BurgerInfo("Polymorphism Burger", 6.5, "chicken breast, gallo, onion, ranch sauce"));	 	
	  }	  
		
	 abstract void printMenu();    
	
	 //getting burger name, price and toppings 
	 
	 public double getPrice(int i) {
		 return burger.get(i).price;
	 }
	 
	 public String getName(int i) {
		 return burger.get(i).name;
	 }
	 
	 public String getTopping(int i) {
		 return burger.get(i).topping;
	 }
	
	 
	 //method that retrieves the values from the HashMap using the key i 
	 public static BurgerInfo getBurger(int i) {
		 return burger.get(i);
	 }
	 
	 public int getHowManyBurgers() {
		return burger.size();
	}
		

	  
	  
	  //and more if needed  
	  
}