
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
    private static List<RedeemItem> redeemableItems = new ArrayList<>();
    private static List<Pokemon> pokemonList = new ArrayList<>();
    private static ArrayList<Score> scoreList = new ArrayList<>();
    private static Player_Pokemon currentPlayer;
    

    public static void main(String[] args) {
        initializeGame();
        runGameLoop();
        
    }
    private static void initializeGame() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("-----------------------Welcome to Pokemon Game-----------------------");
    	 
        System.out.println("               ⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿⡿");
        System.out.println("               ⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿⡿⣿");
        System.out.println("               ⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⡿⣿");
        System.out.println("               ⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡿⣿");
        System.out.println("");
        System.out.println("");
        
        System.out.print("こんにちは ,Please Enter your name: ");
    	    String playerName = scanner.nextLine();
  
    	currentPlayer = new Player_Pokemon(playerName);
       
        
        addWaterPokemon();
        addGrassPokemon();
        addFirePokemon();
        addGhostPokemon();
        addElectricPokemon();
        addPsychicPokemon();
        
        addRedeemableItems();

    }
    
    private static void runGameLoop() {
        Scanner scanner = new Scanner(System.in); 
 
        while (true) {
            System.out.println("-----------------------Ϟ(๑⚈ ․̫ ⚈๑)⋆-----------------------");
            // Ask if the player wants to continue with the same name or enter a new name
                 System.out.println("\nDo you want to continue with the same name? (y/n)\n");
                 System.out.println("-----------------------Ϟ(๑⚈ ․̫ ⚈๑)⋆-----------------------");
                 String continueWithSameName = scanner.next().toLowerCase();

                 if (!continueWithSameName.equals("y")) {
                     // If not, ask for a new name and update currentPlayer
                     System.out.print("Enter your new name: ");
                     String newName = scanner.next();
                     currentPlayer.setPlayerName(newName);
                 }
            printMainMenu();
            
            try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    catchPokemon();
                    break;
                case 2:
                    battlePokemon(currentPlayer,scanner);
                    break;
                case 3:
                    displayPokemonInfo();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Hello " + currentPlayer.getPlayerName() + " Please Select an Option:\n");
        System.out.println("1. Catch Pokemon\n");
        System.out.println("2. Battle and Catch Mode\n");
        System.out.println("3. Display Pokemon Info\n");
        System.out.println("4. Quit Game\n");
    }

    private static void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }
    

    private static void addWaterPokemon() {
        addPokemon(new WaterPokemon(1, "Popillo", 68, false));
        addPokemon(new WaterPokemon(3, "Blastoise", 119, false));
        addPokemon(new WaterPokemon(4, "Suicune", 161, false));
        addPokemon(new WaterPokemon(4, "Primarina", 132, true));
    }

    private static void addGrassPokemon() {
        addPokemon(new GrassPokemon(1, "Bulbasaur", 68, false));
        addPokemon(new GrassPokemon(3, "Venusaur", 118, false));
       
    }

    private static void addFirePokemon() {
        addPokemon(new FirePokemon(1, "Litten", 68, false));
        addPokemon(new FirePokemon(2, "Torracat", 88, false));
        addPokemon(new FirePokemon(3, "Charizard", 117, false));
        addPokemon(new FirePokemon(4, "Bewear", 186, true));
        addPokemon(new FirePokemon(4, "Entei", 166, false));
        addPokemon(new FirePokemon(4, "Ho-oh", 178, false));
        
    }

    private static void addGhostPokemon() {
        addPokemon(new GhostPokemon(4, "Mismagius", 87, false));
        addPokemon(new GhostPokemon(4, "Lunala", 200, true));
        
    }

    private static void addElectricPokemon() {
        addPokemon(new ElectricPokemon(4, "Pikachu", 91, true));
        addPokemon(new ElectricPokemon(4, "Raikou", 159, false));
       
    }

    private static void addPsychicPokemon() {
        addPokemon(new PsychicPokemon(4, "Solgaleo", 200, true));
        addPokemon(new PsychicPokemon(5, "Mewtwo", 200, false));
        
    }

   private static void addScore(Score score) {
	   scoreList.add(score);
   }
   
   
  
   

    private static void catchPokemon() {
        System.out.println("-----------------WELCOME TO CATCH MODE-----------------");
        // Generate 3 random Pokemon
        List<Integer> randomIndices = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(pokemonList.size());
            randomIndices.add(randomIndex);
        }

        System.out.println("Choose a Pokemon to catch:");
        for (int i = 0; i < randomIndices.size(); i++) {
            int index = randomIndices.get(i);
            if (index < pokemonList.size()) {
                Pokemon randomPokemon = pokemonList.get(index);
                System.out.println((i + 1) + ". " + randomPokemon.getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        int selectedPokemonIndex = scanner.nextInt();

        // Validate user input
        if (selectedPokemonIndex < 1 || selectedPokemonIndex > randomIndices.size()) {
            System.out.println("Invalid selection. Please choose a valid Pokemon to catch.");
            catchPokemon(); // Prompt the user to try again
            return;
        }

        int selectedPokemonListIndex = randomIndices.get(selectedPokemonIndex - 1);
        Pokemon selectedPokemon = pokemonList.get(selectedPokemonListIndex);

        // Generate a random pokeball type
        String[] pokeballTypes = {"Pokeball", "Greatball", "Ultraball", "Masterball"};
        int randomPokeballIndex = random.nextInt(pokeballTypes.length);
        String randomPokeballType = pokeballTypes[randomPokeballIndex];

        // Create a Pokeball instance
        Pokeball pokeball = new Pokeball(randomPokeballType);
        
        // Try to Catch the Selected Pokemon
        
        boolean isCaught = pokeball.catchPokemon(selectedPokemon);
        
        //Update the existing goldchip
        int goldChipsEarned = currentPlayer.calculateGoldChips(selectedPokemon.getGrade());
        currentPlayer.addGoldChips(goldChipsEarned);
        
        if (isCaught) {
            System.out.println("Congratulations! You caught " + selectedPokemon.getName() + "!");
            
            // Prompt to enter Battle Mode
            String battleChoice;
            do {
                System.out.println("Do you want to enter Battle Mode? (y/n)");
                battleChoice = scanner.next().toLowerCase();

                if (!battleChoice.equals("y") && !battleChoice.equals("n")) {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } while (!battleChoice.equals("y") && !battleChoice.equals("n"));

            if (battleChoice.equals("y")) {
                System.out.println("Entering Battle Mode...");
                battlePokemon(currentPlayer,scanner);
            } else {
                catchPokemon();
            }
        } else {
            System.out.println("Gold Chips Earned: " + goldChipsEarned);
            System.out.println(currentPlayer.getPlayerName()+ " Gold Chips: " + currentPlayer.getGoldChips());

            // Prompt to redeem gold chips for an item
            System.out.println("Do you wish to redeem your gold chips for an item? (y/n)");
            String redeemChoice = scanner.next().toLowerCase();

            if (redeemChoice.equals("y")) {
                redeemGoldChipsForItem();
            } else {

            	runGameLoop();
            }   
        }
    }
    
    private static void addRedeemableItems() {
        // Create RedeemItem objects for each item
        RedeemItem attackCapsule = new RedeemItem(
                "Attack Capsule",
                "Increases Attack and boosts Pokemon’s Attack Power",
                20
        );

        RedeemItem defenseCapsule = new RedeemItem(
                "Defense Capsule",
                "Increases Defense and boosts Pokemon’s Defense Power",
                20
        );

        RedeemItem quickMovingDrink = new RedeemItem(
                "Quick Moving Drink",
                "Increases 'Speed' for faster movement",
                30
        );

        RedeemItem spiritDrink = new RedeemItem(
                "Spirit Drink",
                "Enables you to start a battle with 'Spirit' stored up",
                40
        );

        RedeemItem targetScope = new RedeemItem(
                "Target Scope",
                "Enables moves to hit more easily",
                60
        );

        RedeemItem pokeBallPower = new RedeemItem(
                "Poke Ball Power",
                "When you catch Pokemon after battle, the balls you throw will upgrade",
                100
        );

        // Add items to the redeemable items list
        redeemableItems.add(attackCapsule);
        redeemableItems.add(defenseCapsule);
        redeemableItems.add(quickMovingDrink);
        redeemableItems.add(spiritDrink);
        redeemableItems.add(targetScope);
        redeemableItems.add(pokeBallPower);
        
    }
    
    private static void redeemGoldChipsForItem() {
        Scanner scanner = new Scanner(System.in);
     // Display available items for redemption
            System.out.println("Available Items for Redemption:");
            for (int i = 0; i < redeemableItems.size(); i++) {
                RedeemItem item = redeemableItems.get(i);
                System.out.println((i + 1) + ". " + item.getItemName() + " - " +
                        item.getItemDesc() + " (Cost: " + item.getGoldChipCost() + " Gold Chips)");
            }

            // Prompt the user to choose an item for redemption
            System.out.println("Enter the number of the redeemed item you want to use (or enter 0 to Return):");
            int choice = scanner.nextInt();

            // Validate user input
            if (choice < 0 || choice > redeemableItems.size()) {
                System.out.println("Invalid selection. Please choose a valid item to redeem.");
                redeemGoldChipsForItem();
                return;
            }

            // Check if the user wants to cancel
            if (choice == 0) {
                System.out.println("Redemption skipped. Returning to Catch Mode.");
                catchPokemon();
                return;
            }

            // Get the selected item
            RedeemItem selectedItem = redeemableItems.get(choice - 1);

            // Check if the user has enough gold chips to redeem the item
            if (currentPlayer.getGoldChips() < selectedItem.getGoldChipCost()) {
                System.out.println("You don't have enough Gold Chips to redeem this item. Catch more Pokemon!");
                catchPokemon();
                return;
            }
        // Deduct gold chip cost from the player's total
        currentPlayer.subtractGoldChips(selectedItem.getGoldChipCost(), selectedItem);
        }  
    
    private static void promptForBattle(Scanner scanner) {
        System.out.println("Do you want to battle with your new Pokemon? (Y/N)");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("Y")) {
            battlePokemon(currentPlayer,scanner);
        } else {
            promptForMainMenu(scanner);
        }
    }
    
    
    private static List<Integer> generateRandomPokemonIndices(int count) {
        List<Integer> indices = new ArrayList<>();
        Random random = new Random();

        while (indices.size() < count) {
            int randomIndex = random.nextInt(pokemonList.size());
            if (!indices.contains(randomIndex)) {
                indices.add(randomIndex);
            }
        }

        return indices;
    }
    private static void promptForMainMenu(Scanner scanner) {
        System.out.println("Do you want to return to the main menu? (Y/N)");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("Y")) {
            runGameLoop();
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    private static void promptForBattle(Player_Pokemon currentPlayer,Scanner scanner) {
        System.out.println("Do you want to battle with your new Pokemon? (Y/N)");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("Y")) {
            battlePokemon(currentPlayer,scanner);
        } else {
            promptForMainMenu(scanner);
        }
    }


    ///------------------------------ENTER BATTLE MODE------------------------------///


    private static void battlePokemon(Player_Pokemon currentPlayer,Scanner scanner) {
        System.out.println("-----------------WELCOME TO BATTLE MODE----------------");
        List<Integer> randomIndices = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(pokemonList.size());
            randomIndices.add(randomIndex);
        }

        // Display information for the randomly selected Pokémon
        for (int index : randomIndices) {
            if (index < pokemonList.size()) {
                Pokemon randomPokemon = pokemonList.get(index);
                System.out.println("Random Pokemon That Will Appear:");
                randomPokemon.displayPokemonInfo();
                System.out.println("-------------------------\n");
            }
        }

        System.out.println("Pokemon List:");
        for (int i = 0; i < pokemonList.size(); i++) {
            Pokemon pokemon = pokemonList.get(i);
            System.out.println((i + 1) + ". " + pokemon.getName());
        }
        
        // Generate two new random Pokémon for the actual battle
        int randomIndex1 = random.nextInt(pokemonList.size());
        int randomIndex2 = random.nextInt(pokemonList.size());

        // Ensure that the two random indices are different
        while (randomIndex2 == randomIndex1) {
            randomIndex2 = random.nextInt(pokemonList.size());
        }

        // Get the two randomly selected Pokémon for the battle
        Pokemon randomPokemon1 = pokemonList.get(randomIndex1);
        Pokemon randomPokemon2 = pokemonList.get(randomIndex2);

        System.out.println("-------------------------");
        // Display information for the randomly selected Pokémon for the battle
        System.out.println("Random Pokemon to Battle:");
        randomPokemon1.displayPokemonInfo();
        System.out.println("-------------------------");
        System.out.println("Random Pokemon to Battle:");
        randomPokemon2.displayPokemonInfo();
        // Allow the user to select 2 Pokémon for battle
        System.out.println("Do you want to use a redeemable item before selecting Pokemon? (y/n)");
        String useItemChoice = scanner.next().toLowerCase();
        

        while (!useItemChoice.equals("y") && !useItemChoice.equals("n")) {
        	System.out.println("Invalid input. Please enter 'y' or 'n'.");
        	System.out.println("Do you want to use a redeemable item before selecting Pokemon? (y/n)");
        	useItemChoice = scanner.next().toLowerCase();}

        
        if (useItemChoice.equals("y")) {
            useRedeemableItem(currentPlayer);
        }


        System.out.println("Select 2 Pokemon for battle:");
        int selectedPokemon1 = scanner.nextInt();

        // Validate user input
        if (selectedPokemon1 < 1 || selectedPokemon1 > pokemonList.size()) {
            System.out.println("Invalid selection. Please choose a valid Pokémon.");
            return;
        }

        // Get the selected Pokémon
        Pokemon pokemon1 = pokemonList.get(selectedPokemon1 - 1);
        
        //Vaidate if the user select the same pokemon
        while (pokemon1 == randomPokemon1 || pokemon1 == randomPokemon2) {
            System.out.println("You cannot select the same Pokémon as randomPokemon1 or randomPokemon2. Please choose a different Pokémon:");
            int newSelectedPokemon1 = scanner.nextInt();
            
            // Validate user input
            if (newSelectedPokemon1 < 1 || newSelectedPokemon1 > pokemonList.size()) {
                System.out.println("Invalid selection. Please choose a valid Pokémon.");
                continue; // Continue the loop to ask for input again
            }

            // Update selectedPokemon1 and get the corresponding Pokemon object
            selectedPokemon1 = newSelectedPokemon1;
            pokemon1 = pokemonList.get(selectedPokemon1 - 1);
        }

        System.out.println("Select 2nd Pokémon for battle:");
        int selectedPokemon2 = scanner.nextInt();

        // Validate user input
        while (selectedPokemon2 < 1 || selectedPokemon2 > pokemonList.size() || selectedPokemon2 == selectedPokemon1) {
            System.out.println("Invalid selection. Please choose a valid and different Pokémon:");
            selectedPokemon2 = scanner.nextInt();
        }

        // Get the second selected Pokémon
        Pokemon pokemon2 = pokemonList.get(selectedPokemon2 - 1);

        // Display information for the selected Pokémon
        System.out.println("Selected Pokemon for Battle:");
        System.out.println("1. " + pokemon1.getName());
        pokemon1.displayPokemonInfo();
        System.out.println("-------------------------");
        System.out.println("2. " + pokemon2.getName());
        pokemon2.displayPokemonInfo();
        System.out.println("-------------------------");

    
       //Inform user that the battle has started
        System.out.println("-------------------------");
        System.out.println("Battle Start!");
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println("");

        System.out.println(pokemon1.getName() + " VS " + randomPokemon1.getName());
        System.out.println("");
        System.out.println("");

        int round = 1;
        
     // Reset HP for the next battle before entering the loop
        pokemon1.resetHP();
        randomPokemon1.resetHP();

     // Main battle loop
        while (true) {
            System.out.println("\nRound " + round + "!");
            System.out.println(pokemon1.getName() + " VS " + randomPokemon1.getName());

            // pokemon1's turn to attack
            battleTurn(pokemon1, randomPokemon1, scanner);

            // Check if randomPokemon1 is still alive
            if (randomPokemon1.getHp() <= 0) {
                System.out.println(randomPokemon1.getName() + " is down!");

                // Check if there is another Pokemon for the player
                if (randomPokemon2.getHp() <= 0) {
                    System.out.println("\nHealth after Final Round:");
                    System.out.println(randomPokemon1.getName() + ": " + randomPokemon1.getHp());
                    System.out.println(pokemon1.getName() + ": " + pokemon1.getHp());
                    int battleScore = calculateBattleScore(randomPokemon1.getHp(), randomPokemon2.getHp(), false);
                    System.out.println("Battle Score: " + battleScore);
                    addScore(new Score(currentPlayer.getPlayerName(), battleScore));

                    // Update Top 5 Scorer
                    updateTopScores(scoreList);

                    System.out.println("You have no more Pokemon left! It's time to catch a new Pokemon.");
                    catchPokemon();
                    break;
                } else {
                    // Switch to the second Pokemon
                    System.out.println(randomPokemon1.getName() + " is down");
                    System.out.println("Switching to " + randomPokemon2.getName() + "!");
                    Pokemon temp = randomPokemon1;
                    randomPokemon1 = randomPokemon2;
                    randomPokemon2 = temp;

                    // Reset HP for the next battle
                    pokemon1.resetHP();
                    randomPokemon1.resetHP();
                }
            }

            // randomPokemon1's turn to attack
            battleTurn(randomPokemon1, pokemon1, scanner);

            // Check if pokemon1 is still alive
            if (pokemon1.getHp() <= 0) {
                System.out.println("");

                // Check if there is another Pokemon for the player
                if (pokemon2.getHp() <= 0) {
                    System.out.println("\nHealth after Final Round:");
                    System.out.println(randomPokemon1.getName() + ": " + randomPokemon1.getHp());
                    int battleScore = calculateBattleScore(pokemon1.getHp(), pokemon2.getHp(), false);
                    System.out.println(pokemon1.getName() + ": " + pokemon1.getHp());
                    System.out.println("Battle Score: " + battleScore);
                    addScore(new Score(currentPlayer.getPlayerName(), battleScore));

                    // Update Top 5 Scorer
                    updateTopScores(scoreList);

                    System.out.println("You have no more Pokemon left! It's time to catch a new Pokemon.");
                    catchPokemon();
                    return;
                } else {
                    // Switch to the second Pokemon
                    System.out.println(pokemon1.getName() + " is down");
                    System.out.println("Switching to " + pokemon2.getName() + "!");
                    Pokemon temp = pokemon1;
                    pokemon1 = pokemon2;
                    pokemon2 = temp;
                }
            }

            // Display health after each round
            System.out.println("\nHealth after Round " + round + ":");
            System.out.println(pokemon1.getName() + ": " + pokemon1.getHp());
            System.out.println(randomPokemon1.getName() + ": " + randomPokemon1.getHp());

            round++;

            // Check if both Pokemon are defeated before continuing the loop
            if (pokemon1.getHp() <= 0 && randomPokemon1.getHp() <= 0) {
                // Player's Pokémon and randomPokemon1 are defeated
                System.out.println("Your Pokemon and " + randomPokemon1.getName() + " both fainted!");
                System.out.println("\nTime to Catch");
                int battleScore = calculateBattleScore(pokemon1.getHp(), randomPokemon1.getHp(), false);
                System.out.println("Battle Score: " + battleScore);

                addScore(new Score(currentPlayer.getPlayerName(), battleScore));

                // Update Top 5 Scorer
                updateTopScores(scoreList);
                catchPokemon();
         
            }
        }

        // Reset HP for the next battle
        pokemon1.resetHP();
        randomPokemon1.resetHP();

        // Check the outcome of the battle after the loop
        int battleScore = calculateBattleScore(pokemon1.getHp(), randomPokemon1.getHp(), false);
        System.out.println("Battle Score: " + battleScore);

        addScore(new Score(currentPlayer.getPlayerName(), battleScore));

        // Update Top 5 Scorer
        updateTopScores(scoreList);
        }
    // Calculate battle score
    private static int calculateBattleScore(int playerPokemonHp, int opponentPokemonHp, boolean isPlayerPokemonDefeated) {
        int playerPokemonCount = 2;
        int opponentPokemonCount = 2; 

        if (isPlayerPokemonDefeated) {
            // If player's Pokemon is defeated
            if (opponentPokemonCount > playerPokemonCount) {
                return 15000;
            } else if (opponentPokemonCount == playerPokemonCount) {
                if (opponentPokemonHp > 70) {
                    return 14000;
                } else if (opponentPokemonHp > 50) {
                    return 13000;
                } else {
                    return 12000;
                }
            } else {
                return 11000;
            }
        } else {
            // If player's Pokémon is not defeated
            if (playerPokemonCount > opponentPokemonCount) {
                return 18000;
            } else if (playerPokemonCount == opponentPokemonCount) {
                if (playerPokemonHp > 70 && opponentPokemonHp > 70) {
                    return 17000;
                } else if (playerPokemonHp > 50 && opponentPokemonHp > 50) {
                    return 16000;
                } else if (playerPokemonHp > 0 && opponentPokemonHp > 0) {
                    return 15000;
                } else {
                    // If both Pokémon fainted
                    return 14000;
                }
            } else {
                return 13000;
            }
        }
    }
    
    private static void updateTopScores(ArrayList<Score> scoreArrayList) {
        List<Integer> scoreList = new ArrayList<Integer>();

        // Extract battle scores from Score objects
        for (Score score : scoreArrayList) {
            scoreList.add(score.getBattleScore());
        }

        // Sort the score list in descending order
        Collections.sort(scoreList, Collections.reverseOrder());

        // Keep only the top 5 scores
        if (scoreList.size() > 5) {
            scoreList = scoreList.subList(0, 5);
        }

        // Display the top 5 scores
        System.out.println("Top 5 Highest Scores:");
        for (int i = 0; i < scoreList.size(); i++) {
            int battleScore = scoreList.get(i);

            // Find the corresponding Score object with the battle score
            Score score = scoreArrayList.stream()
                    .filter(s -> s.getBattleScore() == battleScore)
                    .findFirst()
                    .orElse(null);

            if (score != null) {
                System.out.println((i + 1) + ". " + currentPlayer.getPlayerName() + ": " + score.getBattleScore());
            }
        }

        // Update the top scores in the file
        ScoreFile.updateTopScoresToFile(scoreArrayList);
    }




    private static void battleTurn(Pokemon attacker, Pokemon defender, Scanner scanner) {
        System.out.println("It's " + attacker.getName() + "'s turn!");
        // Assuming you have a method to get the attack used by the attacker
        int damage = attacker.calculateDamage(defender);

      

        // Decrease defender's Hn
        defender.decreaseHp(damage);

        // Print the damage dealt
        System.out.println(attacker.getName() + " dealt " + damage + " damage to " + defender.getName() + "!");
        // Check if the user wants to attack 
        boolean isAttacking = promptForAttack(scanner);
}
    
    



    private static void useRedeemableItem(Player_Pokemon currentPlayer) {
        Scanner scanner = new Scanner(System.in);

        List<RedeemItem> playerRedeemableItems = currentPlayer.getRedeemedItems();

        // Display available redeemable items for the player
        System.out.println("Your Redeemed Items:");
        for (int i = 0; i < playerRedeemableItems.size(); i++) {
            RedeemItem item = playerRedeemableItems.get(i);
            System.out.println((i + 1) + ". " + item.getItemName() + " - " + item.getItemDesc());
        }

        // Prompt the user to choose a redeemed item
        System.out.println("Enter the number of the redeemed item you want to use (or enter 0 to skip):");
        int choice = scanner.nextInt();

        // Validate user input
        if (choice < 0 || choice > playerRedeemableItems.size()) {
            System.out.println("Invalid selection. Please choose a valid item or enter 0 to skip.");
            useRedeemableItem(currentPlayer);
            return;
        }

        // Check if the user wants to skip using a redeemed item
        if (choice == 0) {
            System.out.println("Skipping redeemed item usage.");
            return;
        }

        RedeemItem selectedRedeemItem = playerRedeemableItems.get(choice - 1);

      
        // Remove the used redeemed item from the player's list
        playerRedeemableItems.remove(selectedRedeemItem);

        System.out.println("Congratulations! You have used " + selectedRedeemItem.getItemName());
        // Ask if the user wants to go back to the main menu or continue to battle
        System.out.println("\nDo you want to go back to the main menu? (1. Main Menu");
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                break;

            default:
                System.out.println("Invalid choice. Going back to the main menu.");
        }
    }
    
    private static boolean promptForAttack(Scanner scanner) {
        System.out.println("Press A to attack");
        String choice = scanner.next().toLowerCase();

        while (!choice.equals("a")) {
            System.out.println("Invalid input.");
            System.out.println("Press A to attack");
            choice = scanner.next().toLowerCase();
        }

        boolean isAttacking = choice.equals("a");
        if (isAttacking) {
            System.out.println("Attacking!");
        } else {
            System.out.println("Skipping attack.");
        }

        return isAttacking;
    }
    ///------------------------------ENTER DISPLAY POKEMON MODE------------------------------///

    private static void displayPokemonInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Pokemon to display info:");
        String pokemonName = scanner.nextLine();

        // Search for the Pokemon in the list
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                // If found, display Pokemon info
                pokemon.displayPokemonInfo();
                return;
            }
        }

        // If not found, inform the user
        System.out.println("Pokemon not found: " + pokemonName);
    }
}
