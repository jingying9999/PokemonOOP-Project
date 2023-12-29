public class Pokemon {
    private int grade;
    private String name;
    private String type; // Change the type to PokemonType enum
    private int hp;
    private int initialHp;
    private boolean canZMove;

    // Constructors...
    public Pokemon(int grade, String name, String type, int hp, boolean canZMove) {
        this.grade = grade;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.initialHp = hp;
        this.canZMove = canZMove;
    }

    public Pokemon(int grade, String name, String type, int hp) {
        this(grade, name, type, hp, false);
    }

    // Getter and Setter methods for grade
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter methods for hp
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Getter and Setter methods for canZMove
    public boolean isCanZMove() {
        return canZMove;
    }

    public void setCanZMove(boolean canZMove) {
        this.canZMove = canZMove;
    }

    // Display information about the Pokémon
    public void displayPokemonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type); // Display type as a string
        System.out.println("HP: " + hp);
        System.out.println("Can Z-Move: " + canZMove);
        System.out.println();
    }
    
    //Intitalize for the BattleDamages

    	public int calculateDamage(Pokemon opponent) {
    	    // Default damage
    	    int baseDamage = 30;

    	    // Default effectiveness message
    	    String effectivenessMessage = "Normal effective.";

    	    // Type-specific logic (can be overridden by subclasses)
    	    if (opponent.getType().equalsIgnoreCase("water") ||
    	            opponent.getType().equalsIgnoreCase("grass") ||
    	            opponent.getType().equalsIgnoreCase("fire")) {
    	        baseDamage = 40;
    	        effectivenessMessage = "It's super effective!";
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


    // Decrease Hp
    public void decreaseHp(int amount) {
        if (amount > 0) {
            hp -= amount;
            if (hp < 0) {
                hp = 0;
            }
        }
    }
    
    //reset HP
    public void resetHP() {
        this.hp = this.initialHp;
    }
}
