public class ElectricPokemon extends Pokemon {
    // Constructors...

    public ElectricPokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "electric", hp, canZMove);
    }

    public ElectricPokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to ElectricPokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        // Default effectiveness message
        String effectivenessMessage = "Normal effective.";

        // Type-specific logic for ElectricPokemon
        if (opponent.getType().equalsIgnoreCase("psychic")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("grass")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 20;
        } else if (opponent.getType().equalsIgnoreCase("fire")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("ghost")) {
            effectivenessMessage = "Normal effective.";
        } else if (opponent.getType().equalsIgnoreCase("water")) {
            effectivenessMessage = "Super effective!";
            baseDamage = 40;
        } else if (opponent.getType().equalsIgnoreCase("electric")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 20;
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
