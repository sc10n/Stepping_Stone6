import java.lang.reflect.Array;
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

        for (int i = 0; i < listOfRecipes.size(); i++ ) {
            int bulletNum = i + 1;
            System.out.println("" + bulletNum + ". " + listOfRecipes.get(i).getRecipeName());
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
            System.out.println("4. Exit");
            System.out.println(" ");
            System.out.println("Please make a selection.");

            int menuOption = -1;

            if (menuScnr.hasNextInt()) {
                menuOption = menuScnr.nextInt(); // sets the option to number entered

//                Begin switch
                switch (menuOption) {
                    case 1:
//                        calls the add new recipe method
                        newRecipeBox.addNewRecipe();
                        break;

                    case 2:

//                        Only call the sub-menu if the array has items
                        if (newRecipeBox.listOfRecipes.size() >= 1) {

                                System.out.println("Which recipe would you like to see?");
                                newRecipeBox.printAllRecipeNames();  // print a list of recipe names as a submenu
                                int subMenuOption;

                                if (menuScnr.hasNextInt()) {

                                    subMenuOption = menuScnr.nextInt();

//                                    Selects recipe for display by subtracting 1 from the menu number to get the index
//                                    The selected recipe is passed as a parameter to the print details method.
                                    newRecipeBox.printAllRecipeDetails(
                                            newRecipeBox.listOfRecipes.get(subMenuOption - 1));

                                    } else {

//                                    Catches non-numbers and redirects back to the menu
                                    System.out.println("Illegal option selected.");
                                    menuScnr.next();
                                }


                        } else {
//                            Catch for an empty array list of recipes.
                            System.out.println("There are no recipes in the box, try adding some first.");
                            Helpers.wipeScreen(); // Will wipe screen when ran from terminal outside the IDE
                            break;
                        }

                        break;

                    case 3:

//                        Only show the list of recipes if there are actually recipes in the list.
                        if (newRecipeBox.listOfRecipes.size() >= 1) {

                            newRecipeBox.printAllRecipeNames();

                        } else {
//                            If there aren't any recipes in the list, wipe and return back to the menu
                            System.out.println("There are no recipes in the box, try adding some first.");
                            Helpers.wipeScreen(); // Will wipe screen when ran from terminal outside the IDE
                            break;
                        }
                        break;

                    case 4:
                        menuActive = false; // Breaks the while loop to exit the program
                        break;

                    default:
                        System.out.println("Illegal option selected.");  // For all those non-numbers out there.
                        break;

                }
            } else {
                System.out.println("Error: That is not a number. Try again.");
                menuScnr.next();
            }  // End Switch
        } while (menuActive);
    }


}