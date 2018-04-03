/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamie Thompson
 * Ingredient Class
 */
import java.util.Scanner;

/**
 *
 * @author Jamie Thompson
 * Ingredient Class - with temp main() for testing
 *
 */

public class Ingredient {
    //      Declare class variables
    String nameOfIngredient = "";      // String variable initialized empty
    double ingredientAmount = 0.0;     // Double variable initialized to 0.0 to store fractions of units
    int numberCaloriesPerUnit = 0;      // Integer variable initialized at 0 for whole numbers
    double totalCalories = 0.0;        // Double variable initialized to 0.0 to store fractions of calories
    String unitMeasurement = "";       // String variable to store units of measurement (cups, ounces, quarts
    int unitOption = 0;                // Integer variable initialized to 0 for switch options
    public final int MAX_CALORIES = 2000;     // Constant integer variable equal to max daily recommended calories 

//    Constructor
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.numberCaloriesPerUnit = 0;
        this.totalCalories = 0.0;
        this.unitMeasurement = "";
    }

//    Overloaded Constructor
    public Ingredient(String nameOfIngredient, double ingredientAmount, int numberCaloriesPerUnit,
                      double totalCalories, String unitMeasurement) {

        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
        this. totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurement;
    }


    /**
     * @return nameOfIngredient name of the ingredient
     */
    public String getNameOfIngredient() {

        return nameOfIngredient;
    }

    /**
     * @param nameOfIngredient String value name of the ingredient
     */
    public String setNameOfIngredient(String nameOfIngredient) {

        this.nameOfIngredient = nameOfIngredient;
        return nameOfIngredient;
    }

    /**
     * @return ingredientAmount the amount of the ingredient in the recipe
     */
    public double getIngredientAmount() {

        return ingredientAmount;
    }

    /**
     * @param ingredientAmount double value of the amount of the ingredient
     */
    public void setIngredientAmount(double ingredientAmount) {

        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return the numberCaloriesPerUnit calories per unit
     */
    public int getNumberCaloriesPerUnit() {

        return numberCaloriesPerUnit;
    }

    /**
     * @param numberCaloriesPerUnit  integer value for setting value of calories per unit
     */
    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) {

        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    /**
     * @return totalCalories - Gets Total calories of the ingredient
     */
    public double getTotalCalories() {

        return totalCalories;
    }

    /**
     * @param totalCalories - Total calories of the ingredient
     */
    public void setTotalCalories(double totalCalories) {

        this.totalCalories = totalCalories;
    }

    /**
     * @return unitMeasurement - Gets the unit of measurement specified for the ingredient
     */
    public String getUnitMeasurement() {

        return unitMeasurement;
    }

    /**
     * @param unitMeasurement string value for setting what type of measurement the ingredient has
     */
    public void setUnitMeasurement(String unitMeasurement) {

        this.unitMeasurement = unitMeasurement;
    }

//    @Override
//    public String toString() {
//        return "" + this.nameOfIngredient + "\t" + this.ingredientAmount + " " + this.unitMeasurement +
//                "\t" + this.numberCaloriesPerUnit + " Cals \t" + this.totalCalories + " Total Calories";
//    }


    /**
     *
     *
     * @return 
     */
    public Ingredient createIngredient() {

        //        Instantiate new Ingredient object


//        boolean
        //    Instantiate new Scanner object
        Scanner scnr = new Scanner(System.in);


        System.out.println("Please enter the name of the ingredient: ");

        // set ingredient name with scanner
        String nameOfIngredient =  scnr.nextLine();

        // call setter using the name of ingredient
        setNameOfIngredient(nameOfIngredient);

//        variable for ending the loop
        boolean boolAmount = true;
//        Being do/while loop for getting ingredient amount.
        do {
            System.out.println("Please enter the amount of " + nameOfIngredient + " that we'll need: ");
//            Nested loop beings, checks if input is a type of double
            if (scnr.hasNextDouble()) {

                ingredientAmount = scnr.nextDouble();
//                If the input is between 1 and 20 consider it valid and exit the loop at the end.
                if ((ingredientAmount >= 1) && (ingredientAmount <= 20)) {
                    setIngredientAmount(ingredientAmount); // calls method to set value of ingredientAmount
                    System.out.println("Valid entry - You entered: " + ingredientAmount);
                    boolAmount = false; // will cause the while statement to break out of the loop
                } else {
                    System.out.println("The number entered was not between 1 and 20, please enter a valid amount.");
                }
            } else {
                System.out.println("Error: That is not a number. Try again.");
                scnr.next(); // Clears the scanner to accept a new input.
            }
        } while (boolAmount);


        boolean boolUnitMeasure = true; // variable used for satisfying the do/while loop below
        do {
//        Menu for selecting a unit of measure
            System.out.println("Please enter the unit of measure for " + nameOfIngredient + ":");
            System.out.println();
            System.out.println("1.  teaspoon(s)");
            System.out.println("2.  tablespoon(s)");
            System.out.println("3.  cup(s)");
            System.out.println("4.  ounce(s)");
            System.out.println("5.  pound(s)");
            System.out.println();
            System.out.println("Enter the number of your choice: ");

            if (scnr.hasNextInt()) {

                unitOption = scnr.nextInt(); // sets to the int grabbed from the scanner

//                Switch for choosing unit of measure
                switch (unitOption) {
                    case 1:
//                        If check in each case makes a check to see if the ingredientAmount is not equaled to 1. If
//                        it doesn't equal, it will make the unit plural. If it does, it will make the unit singular.
                        if (ingredientAmount != 1.0) {
                            unitMeasurement = "teaspoons";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        } else {
                            unitMeasurement = "teaspoon";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        }
                        break;
                    case 2:
                        if (ingredientAmount != 1.0) {
                            unitMeasurement = "tablespoons";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        } else {
                            unitMeasurement = "tablespoon";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        }
                        break;
                    case 3:
                        if (ingredientAmount != 1.0) {
                            unitMeasurement = "cups";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        } else {
                            unitMeasurement = "cup";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        }
                        break;
                    case 4:
                        if (ingredientAmount != 1.0) {
                            unitMeasurement = "ounces";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        } else {
                            unitMeasurement = "ounce";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        }
                        break;
                    case 5:
                        if (ingredientAmount != 1.0) {
                            unitMeasurement = "pounds";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        } else {
                            unitMeasurement = "pound";
                            System.out.println("Valid entry - You entered: " + unitMeasurement);
                            setUnitMeasurement(unitMeasurement);
                            boolUnitMeasure = false;
                        }
                        break;
                    default:
                        System.out.println("Illegal option selected. Exiting.");
                } // End Switch
            } else {
                System.out.println("Error: That is not a number. Try again.");
                scnr.next();
            }
        } while (boolUnitMeasure);


        boolean boolCalAmount = true;                   // variable for ending the loop
//        Being do/while loop for getting calories per unit of measure.
        do {
            System.out.println("Please enter the number of calories per " + unitMeasurement + ":");
//            Nested loop beings, checks if input is a type of integer.
            if (scnr.hasNextInt()) {

                numberCaloriesPerUnit = scnr.nextInt();
//                If the input is between 1 and MAX_CALORIES consider it valid and exit the loop at the end.
                if ((numberCaloriesPerUnit >= 0) && (numberCaloriesPerUnit <= MAX_CALORIES)) {
                    setNumberCaloriesPerUnit(numberCaloriesPerUnit);
                    System.out.println("Valid entry - You entered: " + numberCaloriesPerUnit);
                    boolCalAmount = false;  // breaks the do/while
                } else {
                    System.out.println("The number entered was not between 1 and " + MAX_CALORIES +
                            ", please try again.");
                }
            } else {
                System.out.println("Error: That is not a number. Try again.");
                scnr.next();
            }
        } while (boolCalAmount);

        /**
         * @param getIngredientAmount() getNumberCaloriesPerUnit()
         * Calls the getter methods for ingredient amount and number of calories per unit and multiplies them.
         * The solution is then passed a parameter to the total calories setter method.
         */
        setTotalCalories(getIngredientAmount() * getNumberCaloriesPerUnit());

//        Print completed line. Using the getters from the class to pull the information from the object.
        System.out.println(getNameOfIngredient() + " uses " + getIngredientAmount()
                + " " + getUnitMeasurement() + " and has " + getTotalCalories() + " calories.");

//        Create the instance of the class using the overloaded constructor
       Ingredient newIngredient = new Ingredient(getNameOfIngredient(), getIngredientAmount(), getNumberCaloriesPerUnit(),
                getTotalCalories(), getUnitMeasurement());

//       Return the object that has been created.
       return newIngredient;
    }
}
