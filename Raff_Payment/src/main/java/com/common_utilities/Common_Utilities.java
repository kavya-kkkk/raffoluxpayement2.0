package com.common_utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common_Utilities {

	
	//To compare raffle and home page title
	public static boolean compareText(String value1, String value2) { //homePageRaffleTitle,rafflePageRaffleTitle
		// Remove leading and trailing spaces using trim()
		value1 = value1.trim();
		value2 = value2.trim();

		if (value1.equals(value2))
			return true;
		return false;
	}
	//To compare raffle and home page prize

	public static boolean comparePrice(String price1, String price2) { //homepageRaffleprice,rafflePageRaffleprice
		price1 = price1.replaceAll("[\\£ ]", "");
		price2 = price1.replaceAll("[\\£ ]", "");
		double value1 = Double.parseDouble(price1);
		double value2 = Double.parseDouble(price2);
		if (value1 == value2)
			return true;
		return false;
	}

	
	//validate raffle page enteries and cost is correct or not 
	public static boolean compare_entries_with_price(String entries, String price, String totalPrice) {//(rafflePageSelectentries, rafflePageRaffleprice, rafflePageTotalPrice)
		int entry = Integer.parseInt(entries);
		price = price.replaceAll("[\\£ ]", "");
		double value = Double.parseDouble(price);

		totalPrice = totalPrice.replaceAll("[\\£ ]", "");
		double total_amount = Double.parseDouble(totalPrice);

		if ((entry * value) == total_amount)
			return true;
		return false;
	}
	
	public static int extract_entries(String str) {
        // Split the string by '|'
        String[] parts = str.split("\\|");

        // Extract the number from the second part
        String numberPart = parts[1].trim(); // Remove leading/trailing spaces
        String[] numberWords = numberPart.split(" ");

        // The number is the first word after splitting
        int number = Integer.parseInt(numberWords[0]);

        return number;
    }
	
	 public static double extract_cost(String str) {

	        // Split the string by spaces
	        String[] parts = str.split(" ");

	        // Find the part containing the decimal value
	        String decimalPart = null;
	        for (String part : parts) {
	            if (part.contains(".")) {
	                decimalPart = part;
	                break;
	            }
	        }

	        // Extract the decimal value
	        double value = Double.parseDouble(decimalPart.substring(1));

	        return value;
	    }

	public static void main(String[] args) {
		String str = "£100.15 per entry | 4 entries";

        // Split the string by spaces
        String[] parts = str.split(" ");

        // Find the part containing the decimal value
        String decimalPart = null;
        for (String part : parts) {
            if (part.contains(".")) {
                decimalPart = part;
                break;
            }
        }

        // Extract the decimal value
        double value = Double.parseDouble(decimalPart.substring(1));

        System.out.println(value); // Output: 0.5
	}
	
	
	//In cart to validate points and check value 
	 public static String extractNumber(String input) {
	        // Regular expression to find the first sequence of digits
	        Pattern pattern = Pattern.compile("\\d+");
	        Matcher matcher = pattern.matcher(input);

	        if (matcher.find()) {
	            return matcher.group(); // Return the first matched number
	        }
	        return ""; // Return an empty string if no number is found
	    }
	 
		public static boolean compareStringsAsIntegers(String a, String b) {
		    // Remove the dollar sign and parse the string to a double first
		    double valueA = Double.parseDouble(a.replace("£", ""));
		    
		    // Parse the second string to an integer
		    int valueB = Integer.parseInt(b);
		    
		    // Compare the integer part of the double with the integer
		    return (int) valueA == valueB;
		}
		
		
		//to check points get for the purchase
		
		public static boolean compareStringsAsIntegers1(String Afterpurchasingpoints,String Beforepurchasingpoints,String points) {
		    // Remove the dollar sign and parse the string to a double first
			
		        // Remove all non-numeric characters
		        String numericOnly =  Afterpurchasingpoints.replaceAll("[^0-9]", "");
	                   System.out.println(numericOnly);
		        // Convert the numeric string to an integer (optional)
		        int valueA = Integer.parseInt(numericOnly);

		        // Print the result
		        System.out.println("Extracted number: " +  valueA);
		        System.out.println("Points " + points);
		        String numericOnly1 =  Beforepurchasingpoints.replaceAll("[^0-9]", "");

		        // Convert the numeric string to an integer (optional)
		        int valueB = Integer.parseInt(numericOnly1);

		        // Print the result
		        System.out.println("Extracted number: " +  valueB);
		    int valueC =  Integer.parseInt(points);
		    
		    int totalpointget = valueB +valueC;
		    System.out.println(totalpointget);
		    // Compare the integer part of the double with the integer
		    return  totalpointget == valueA;
		}
		

		//after appliying credit validating 
		public static boolean validateCheckoutCost(String cartTotalCost, String cartAppliedCreditValue, String afterAppliedCreditCheckoutCost) {
	        // Remove currency symbols and spaces, then convert the strings to double
	        double totalCost = Double.parseDouble(cartTotalCost.replace("£", "").trim());
	        double appliedCredit = Double.parseDouble(cartAppliedCreditValue.replace("£", "").replace(" ", "").trim());
	        double expectedCostAfterCredit = Double.parseDouble(afterAppliedCreditCheckoutCost.replace("£", "").trim());
	        System.out.println(totalCost+ " totalCost");
	        System.out.println( appliedCredit+ " appliedCredit");
	        System.out.println(expectedCostAfterCredit+ "expectedCostAfterCredit");
	        // Calculate the expected cost after applying credit
	        double calculatedCostAfterCredit = totalCost + appliedCredit; // Add since appliedCredit is negative
	        System.out.println(calculatedCostAfterCredit+ "calculatedCostAfterCredit");
	        // Round the calculated cost to 2 decimal places
	        BigDecimal roundedCalculatedCost = new BigDecimal(calculatedCostAfterCredit).setScale(2, RoundingMode.HALF_UP);
	        System.out.println(roundedCalculatedCost+ "roundedCalculatedCost");
	        // Compare the rounded calculated cost with the expected cost
	        return roundedCalculatedCost.compareTo(BigDecimal.valueOf(expectedCostAfterCredit)) == 0;
	    }
	    //Tovalidate credit balance after purchasing ticekts
	    
	    public static boolean validateCreditApplication(String beforeUsingCreditValue, String cartAppliedCreditValue, String afterUsingCreditValue) {
	        // Remove currency symbols and spaces, then convert the strings to double
	        double beforeCredit = Double.parseDouble(beforeUsingCreditValue.replace("£", "").trim());
	        double appliedCredit = Double.parseDouble(cartAppliedCreditValue.replace("£", "").replace("-", "").trim());
	        double afterCredit = Double.parseDouble(afterUsingCreditValue.replace("£", "").trim());

	        // Calculate the expected value after applying credit
	        double calculatedAfterCredit = beforeCredit - appliedCredit;

	        // Compare the calculated value with the expected value
	        return Double.compare(calculatedAfterCredit, afterCredit) == 0;
	    }
		
	    
	    //To check the promocode and credit , card
	    public static boolean validateFinalCost(String cartTotalCost, String cartAppliedCreditValue, String appliedPromoCodeValue, String afterAppliedPromoCreditCheckoutCost) {
	        // Remove currency symbols and spaces, then convert the strings to double
	        double totalCost = Double.parseDouble(cartTotalCost.replace("£", "").trim());
	        double appliedCredit = Double.parseDouble(cartAppliedCreditValue.replace("£", "").replace("-", "").trim());
	        double promoCodeValue = Double.parseDouble(appliedPromoCodeValue.replace("£", "").replace("-", "").trim());
	        double expectedFinalCost = Double.parseDouble(afterAppliedPromoCreditCheckoutCost.replace("£", "").trim());

	        // Calculate the final cost after applying promo code and credit
	        double calculatedFinalCost = promoCodeValue + appliedCredit - totalCost;

	        // Compare the calculated final cost with the expected final cost
	        return Double.compare(calculatedFinalCost, expectedFinalCost) == 0;
	    }
		
}
