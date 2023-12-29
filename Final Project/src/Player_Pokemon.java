import java.util.ArrayList;
import java.util.List;

public class Player_Pokemon {
    private String playerName;
    private int battleScore;
    private int goldChips;
    private List<RedeemItem> redeemableItems;
    private List<Score> scoreList;

    public Player_Pokemon(String playerName, int initialBattleScore, int goldChips) {
        this.playerName = playerName;
        this.battleScore = initialBattleScore;
        this.goldChips = goldChips;
        this.redeemableItems = new ArrayList<>();
        this.scoreList = new ArrayList<>();
        this.scoreList.add(new Score(playerName, initialBattleScore));
    }

    public Player_Pokemon(String playerName) {
        this(playerName, 0, 0);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        // Update PlayerName in the scores list
        for (Score score : scoreList) {
            score.setPlayerName(playerName);
        }

        this.playerName = playerName;
    }

    public int getBattleScore() {
        return battleScore;
    }

    public void setBattleScore(int battleScore) {
        this.battleScore = battleScore;
    }

    public List<RedeemItem> getRedeemedItems() {
        return redeemableItems;
    }

    public void setGoldChips(int goldChips) {
        this.goldChips = goldChips;
    }

    public int getGoldChips() {
        return goldChips;
    }

    public void addGoldChips(int chips) {
        this.goldChips += chips;
    }

    public int calculateGoldChips(int grade) {
        switch (grade) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            case 5:
                return 60;
            default:
                return 0;
        }
    }

    public void redeemItem(RedeemItem item) {
        if (goldChips >= item.getGoldChipCost()) {
            goldChips -= item.getGoldChipCost();
            redeemableItems.add(item);
            System.out.println("Congratulations! You have redeemed " + item.getItemName() +
                    ". Remaining Gold Chips: " + goldChips);
        } else {
            System.out.println("Invalid operation: Cannot redeem item. Insufficient Gold Chips.");
        }
    }

    public List<RedeemItem> getRedeemableItems() {
        return redeemableItems;
    }

    public void subtractGoldChips(int amount, RedeemItem redeemedItem) {
        if (amount > 0 && goldChips >= amount) {
            goldChips -= amount;
            redeemableItems.add(redeemedItem);
            System.out.println("Congratulations! You have redeemed " + redeemedItem.getItemName() +
                    ". Remaining Gold Chips: " + goldChips);
        } else {
            System.out.println("Invalid operation: Cannot subtract negative amount or insufficient Gold Chips.");
        }
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    @Override
    public String toString() {
        return "Player Name: " + playerName + "\nBattle Score: " + battleScore;
    }
}
