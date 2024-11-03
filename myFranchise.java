package Project1;


import java.util.Scanner;

public class myFranchise{
	

	public static final String ANSI_RESET = "\u001B[0m";   
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";
    
	public static void main(String[] args) throws Exception {
	
		   String country;
		   String franchiseName;
		   int discount=0;
		   String promotion="";
		   int tooHot;
		   int burgerNumber;
		   String newTopping;
		 
		   Scanner input = new Scanner(System.in);	
		   
			System.out.println(SET_BOLD_TEXT + ANSI_RED + "\nProject 1. Burger 211" + " (Spring 2024)"+ ANSI_RESET);		
			boolean run=true;
			while (run) {
				System.out.println(ANSI_GREEN +"\nEnter country code. (Alpha-2 code)"+ANSI_RED);
				country =input.next();
				if (country.equals("0")) {
				   run=false;
				   System.out.println("Bye!");
				   break;
				}
				else 
				{
					input.nextLine();
					System.out.println(ANSI_GREEN +"\nEnter your franchise name."+ANSI_RED);	
					franchiseName = input.nextLine();
						
					input.nextLine();
					System.out.println(ANSI_GREEN +"\nEnter the promotion. If there is no promotion, press Enter."+ANSI_RED);
					promotion =input.nextLine();
									
				
					if (promotion.length()>0) {
					    input.nextLine();
						System.out.println(ANSI_GREEN +"\nEnter the promotion discount rate(%) (0 ~ 99)"+ANSI_RED);	
						discount =input.nextInt();
					}
					
					System.out.println(ANSI_GREEN +"\nEnter a temperature for 'too hot to eat 10% off' promotion"+ANSI_RED);
					tooHot =input.nextInt();
									
					Menu franchise = new Menu(country, franchiseName);			
					
					System.out.println(ANSI_GREEN +"\nWhich burger would you like to change the topping? (enter 0 if not) \n"+ANSI_BLUE);	
				     for (int i=1; i<=franchise.getHowManyBurgers(); i++) {
					       System.out.println(i + ". "+ franchise.getName(i)+ ": "+ franchise.getTopping(i));
					 }
				     System.out.println(ANSI_RED);
				     
				     burgerNumber = input.nextInt();
				     if (burgerNumber>=1) {
				    	 input.nextLine();
				    	 System.out.println(ANSI_GREEN +"\n"+franchise.getName(burgerNumber)+ ": " + franchise.getTopping(burgerNumber) + ANSI_RED);
				    	 System.out.println(ANSI_GREEN +"Enter new toppings of "+franchise.getName(burgerNumber) + ANSI_RED);
				    	 newTopping = input.nextLine();
				    	 franchise.updateTopping(burgerNumber, newTopping);
				     }			     	
				    			     
				     franchise.Promotion((double)discount/100.0, promotion);
				     franchise.PromotionTooHot(tooHot);
				     franchise.printMenu(); 			     				   
				}
					
			}	
		}
	   
	
	
	
	
	
	
	
	
		   /*
			 String country="FR";
			 String franchise="Paris";
			 
		     Burger211 myFranchise = new Menu(country, franchise);
		     
		     myFranchise.Promotion(0.15, "Today's Special: 20% off if you play the squid game with BTS");		     		   
	        
		     for (int i=0; i<myFranchise.getHowManyBurgers(); i++) {
		       System.out.println(i + ". "+ myFranchise.getName(i)+ ": "+myFranchise.getTopping(i));
		     }

		     myFranchise.printMenu();  
		     
		    */
		      
}

