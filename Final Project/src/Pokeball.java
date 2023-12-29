public class Pokeball {
    private String pokeballType;

    public Pokeball(String pokeballType) {
        this.pokeballType = pokeballType;
    }

    // Method to catch a Pokemon using the specified pokeball
    public boolean catchPokemon(Pokemon pokemon) {
        double successRate;

        // Determine success rate based on the Pokemon grade and the type of pokeball
        switch (pokemon.getGrade()) {
            case 1:
                successRate = 1.0; // All pokeballs are successful for grade 1
                break;
            case 2:
                successRate = pokeballType.equalsIgnoreCase("pokeball") ? 0.0 : 1.0;
                break;
            case 3:
                successRate = pokeballType.equalsIgnoreCase("pokeball") || pokeballType.equalsIgnoreCase("greatball") ? 0.0 : 1.0;
                break;
            case 4:
                successRate = pokeballType.equalsIgnoreCase("masterball") ? 1.0 : 0.0;
                break;
            case 5:
                successRate = pokeballType.equalsIgnoreCase("masterball") ? 1.0 : 0.0;
                break;
            default:
                System.out.println("Invalid Pokemon grade.");
                return false;
        }

        // Attempt to catch the Pokemon
        if (Math.random() < successRate) {
            System.out.println("Congratulations! You caught " + pokemon.getName() + " with a " + pokeballType + "!");
            return true;
        } else {
            System.out.println("Oh no! " + pokemon.getName() + " broke free from the " + pokeballType + ".");
            return false;
        }
    }
}
