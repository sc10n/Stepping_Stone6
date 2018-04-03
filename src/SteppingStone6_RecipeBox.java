import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;


public class SteppingStone6_RecipeBox {

//    Instance variables
    private ArrayList<SteppingStone5_Recipe> listOfRecipes = new ArrayList<>();

    /**
     *
     * @return arrayList of recipes
     */
    public ArrayList<SteppingStone5_Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    /**
     *
     * @param listOfRecipes
     */
    public void setListOfRecipes(ArrayList<SteppingStone5_Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

//    Constructor
    public SteppingStone6_RecipeBox() {
        this.listOfRecipes = new ArrayList<>();
    }

//    Overloaded Constructor
    public SteppingStone6_RecipeBox(ArrayList<SteppingStone5_Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

//    Custom methods

//    Print all recipe details for each recipe in the list
    public void printAllRecipeDetails(SteppingStone5_Recipe selectedRecipe) {

        for (SteppingStone5_Recipe recipe : listOfRecipes) {

            if (recipe.equals(selectedRecipe)) {

                recipe.printRecipe();

                return;
            }
        }
    }

//    Print all recipe names in the list
    public void printAllRecipeNames() {

        for (int i = 0; i < listOfRecipes.size(); i++) {

            SteppingStone5_Recipe tmpRecipe2 = new SteppingStone5_Recipe();

            tmpRecipe2 = listOfRecipes.get(i);

            System.out.println(tmpRecipe2.getRecipeName());
        }
    }

//    Add new recipe to the Array List
    public void addNewRecipe() {
        SteppingStone5_Recipe newRecipe = new SteppingStone5_Recipe();

        listOfRecipes.add(newRecipe.createNewRecipe());
    }




//    Driver
    public static void  main(String[] args) {

        SteppingStone6_RecipeBox newRecipeBox = new SteppingStone6_RecipeBox();

        Scanner menuScnr = new Scanner(System.in);

//        Variable for breaking the do/while loop
        boolean menuActive = true;

//        Main menu loop
        do {
//            Construct the menu
            System.out.println("Welcome to the Recipe Box Main Menu.");
            System.out.println(" ");
            System.out.println("1. Add a Recipe to the Box ");
            System.out.println("2. Print details of a Recipe ");
            System.out.println("3. List all Recipe Names in the Box ");
            System.out.println(" ");
            System.out.println("Please make a selection.");

            int menuOption = -1;

            if (menuScnr.hasNextInt()) {
                menuOption = menuScnr.nextInt(); // sets the option to number entered

//                Begin switch
                switch (menuOption) {
                    case 1:
                        newRecipeBox.addNewRecipe();
                        break;

                    case 2:
                        System.out.println("Which recipe?");
//                        TODO: add logic for picking a recipe if list isnt empty

                        break;

                    case 3:
                        newRecipeBox.printAllRecipeNames();
//                        TODO: format the list
                        break;

                    default:
                        System.out.println("Illegal option selected.");

                }
            } else {
                System.out.println("Error: That is not a number. Try again.");
                menuScnr.next();
            }  // End Switch
        } while (menuActive);
    }


}