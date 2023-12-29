public class PsychicPokemon extends Pokemon {
    // Constructors...

    public PsychicPokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "psychic", hp, canZMove);
    }

    public PsychicPokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to PsychicPokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        // Default effectiveness message
        String effectivenessMessage = "Normal effective.";

        // Type-specific logic for PsychicPokemon
        if (opponent.getType().equalsIgnoreCase("water") ||
                opponent.getType().equalsIgnoreCase("grass") ||
                opponent.getType().equalsIgnoreCase("ghost") ||
                opponent.getType().equalsIgnoreCase("fire") ||
                opponent.getType().equalsIgnoreCase("electric")) {
            // No change to base damage, use default message
        } else if (opponent.getType().equalsIgnoreCase("psychic")) {
            effectivenessMessage = "Not very effective.";
            baseDamage = 10;
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
