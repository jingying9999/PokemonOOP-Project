public class FirePokemon extends Pokemon {
    // Constructors...

    public FirePokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "fire", hp, canZMove);
    }

    public FirePokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to FirePokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        // Default effectiveness message
        String effectivenessMessage = "Normal effective.";

        // Type-specific logic for FirePokemon
        if (opponent.getType().equalsIgnoreCase("grass")) {
            effectivenessMessage = "Super effective!";
            baseDamage = 40;
        } else if (opponent.getType().equalsIgnoreCase("water")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 20;
        } else if (opponent.getType().equalsIgnoreCase("fire")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 20;
        } else if (opponent.getType().equalsIgnoreCase("ghost") ||
                opponent.getType().equalsIgnoreCase("electric") ||
                opponent.getType().equalsIgnoreCase("psychic")) {
            // No change to base damage, use default message
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
