public class GrassPokemon extends Pokemon {
    // Constructors...

    public GrassPokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "grass", hp, canZMove);
    }

    public GrassPokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to GrassPokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        // Default effectiveness message
        String effectivenessMessage = "Normal effective.";

        // Type-specific logic for GrassPokemon
        if (opponent.getType().equalsIgnoreCase("grass")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 20;
        } else if (opponent.getType().equalsIgnoreCase("water")) {
            effectivenessMessage = "It's super effective!";
            baseDamage = 40;
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
