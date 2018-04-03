import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jamie Thompson
 * Recipe Class
 */
public class SteppingStone5_Recipe {

    //    Initialize class variables
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList();
    private double totalRecipeCalories;

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories() {

        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }


    //    Constructor
    public SteppingStone5_Recipe() {
        this.recipeName = "";
        this.servings = 0; //<--- assignment value with appropriate data type
        this.recipeIngredients = new ArrayList<>(); //<-- assignment value for empty ArrayList
        this.totalRecipeCalories = 0.0;
    }
    //    Overloaded Constructor that brings in assigned variables to create an instance of the class.
    public SteppingStone5_Recipe(String recipeName, int servings,
                                 ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories)
    //<-- use appropriate data type for the ArrayList and the servings arguments
    {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    public void addInstructions() {
//        TODO: Add in custom instructions for each recipe.
    }

    /**
     * This method will print the recipe to the console with the format of
     * Recipe:
     * Serves:
     * Ingredients:
     * name     amount      unit/measure    Calories    Total Calories
     *
     * Each serving has x Calories for a total of x Calories.
     */
    public void printRecipe() {

//        takes the double totalRecipeCalories casts it to an int, then divides by servings
        int singleServingCalories = ((int)(getTotalRecipeCalories()) / getServings());

//         Print recipe information
        System.out.println("Recipe: " + getRecipeName());
        System.out.println("Serves: " + getServings());
        System.out.println("Ingredients: ");

//         For loop: print each ingredient in the arrayList
        for (int i = 0; i < getRecipeIngredients().size(); i++) {

//             Uses the accessor to to the ingredient list at the index of i
            Ingredient ingredientList = getRecipeIngredients().get(i);
//             Build a printable list of the ingredients for easier printing
            String list = ingredientList.nameOfIngredient + "\t" + ingredientList.ingredientAmount +
                    "\t" + ingredientList.unitMeasurement + "\t" + ingredientList.numberCaloriesPerUnit +
                    " Cals \t" + ingredientList.totalCalories + " Total Calories";

//             Print out the aforementioned list of ingredients that has been semi-formatted
            System.out.println(list);
        }

//         Final printed statement of the recipe, uses accessors from the class to get the values
        System.out.println("Each serving has " + singleServingCalories + " Calories for a total of " +
                (int)getTotalRecipeCalories() + " Calories.");
    }


    /**
     *
     * @return recipe object
     */
    public SteppingStone5_Recipe createNewRecipe() {

//        Instantiate new Ingredient ArrayList
        ArrayList <Ingredient> recipeIngredients = new ArrayList();
//
//        SteppingStone5_Recipe recipe = new SteppingStone5_Recipe();

//        initialize an integer value of 0 for the servings variable
        int servings = 0;

//        Instantiate a new scanner object
        Scanner scnr = new Scanner(System.in);

//        Instantiate a new Ingredient object from the constructor values
        Ingredient newIngredient = new Ingredient();

//        Prompt for recipe name
        System.out.println("Please enter the recipe name: ");

        setRecipeName(scnr.nextLine());

        System.out.println("Please enter the number of servings: ");
        //correct data type & Scanner assignment method for servings variable

//        If/else nested loop for ensuring the input is an integer
        if (scnr.hasNextInt()) {
            servings = scnr.nextInt();

//            As long as servers are more than 0
            if (servings >= 1) {
                setServings(servings); // calls setter for servings
                System.out.println("Valid entry - You entered: " + servings);
            } else { // If the serving size input is 0 or less
                System.out.println("Please enter a serving size of 1 or greater");
            }
//            If its NaN, print the error
        } else {
            System.out.println("Error: That is not a number. Try again.");
            scnr.next();
        }
        boolean addMoreIngredients = true; // Boolean for clearing the while loop
        do {
            System.out.println("Would you like to enter an ingredient? (y or n)");

            String reply = scnr.next().toLowerCase();// Store scanner input to reply, change input to lower case

//            Switch case for entering ingredients
            switch (reply) {
//                Yes case, adds the new ingredient that is returned from the createIngredient method
                case "y":
                    recipeIngredients.add(newIngredient.createIngredient());
//                    Sets the total recipe calories using the accessor times totalCalories from the object
                    setTotalRecipeCalories(getTotalRecipeCalories() + newIngredient.totalCalories); // keep adding up the calories
//                    Mutator to set the recipe ingredients
                    setRecipeIngredients(recipeIngredients);
                    break;
//                    No case, uses the boolean to break out of the while loop
                case "n":
                    addMoreIngredients = false;
                    break;
                default:
                    System.out.println("Valid answers are 'y' or 'n'"); // prompt if input doesn't equal y or n
                    break;
            }
        } while (addMoreIngredients); // Will break out when set to false

//        Create the new object based on all the methods inputs from the accessors
        SteppingStone5_Recipe newRecipe = new SteppingStone5_Recipe(getRecipeName(), getServings(), recipeIngredients,
                getTotalRecipeCalories());
        System.out.println("Recipe for " + getRecipeName() + " saved.");
//        Return the object to the calling method
        return newRecipe;
    }
}
