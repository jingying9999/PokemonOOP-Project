public class GhostPokemon extends Pokemon {
    // Constructors...

    public GhostPokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "ghost", hp, canZMove);
    }

    public GhostPokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to GhostPokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        // Default effectiveness message
        String effectivenessMessage = "Normal effective.";

        // Type-specific logic for GhostPokemon
        if (opponent.getType().equalsIgnoreCase("water")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("grass")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("ghost")) {
            effectivenessMessage = "Super effective!";
            baseDamage = 40;
        } else if (opponent.getType().equalsIgnoreCase("fire")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("electric")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("psychic")) {
            effectivenessMessage = "Normal effective.";
        }

        // Print effectiveness message
        System.out.println(effectivenessMessage);

        // If canZMove is true, double the damage
        if (isCanZMove()) {
            baseDamage *= 2;
            setCanZMove(false); // Disable canZMove after the first round
        }

        return baseDamage;
    }
}
