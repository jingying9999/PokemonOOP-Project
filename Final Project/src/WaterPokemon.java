public class WaterPokemon extends Pokemon {
    // Constructors...

    public WaterPokemon(int grade, String name, int hp, boolean canZMove) {
        super(grade, name, "water", hp, canZMove);
    }

    public WaterPokemon(int grade, String name, int hp) {
        this(grade, name, hp, false);
    }

    // Additional methods specific to WaterPokemon...

    @Override
    public int calculateDamage(Pokemon opponent) {
        int baseDamage = 30; // Default damage

        if (opponent.getType().equalsIgnoreCase("water") ||
                opponent.getType().equalsIgnoreCase("grass") ||
                opponent.getType().equalsIgnoreCase("fire")) {
            System.out.println("It's super effective!");
            baseDamage = 40;
        } else if (opponent.getType().equalsIgnoreCase("ghost") ||
                opponent.getType().equalsIgnoreCase("electric") ||
                opponent.getType().equalsIgnoreCase("psychic")) {
            System.out.println("Normal effective.");
        }

        // If canZMove is true, double the damage
        if (isCanZMove()) {
            baseDamage *= 2;
            setCanZMove(false); // Disable canZMove after the first round
        }

        return baseDamage;
    }
}
