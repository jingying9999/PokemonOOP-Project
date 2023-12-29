import java.util.List;

public class Score implements Comparable<Score> {

    private String playerName;
    private int battleScore;

    public Score(String name, int bs) {
        this.playerName = name;
        this.battleScore = bs;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getBattleScore() {
        return battleScore;
    }

    public void setBattleScore(int battleScore) {
        this.battleScore = battleScore;
    }

    @Override
    public int compareTo(Score other) {
        // Compare scores in reverse order (highest first)
        return Integer.compare(other.battleScore, this.battleScore);
    }

}
