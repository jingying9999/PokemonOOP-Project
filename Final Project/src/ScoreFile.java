import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreFile {
    public static void updateTopScoresToFile(ArrayList<Score> scoreArrayList) {
        List<Integer> scoreList = new ArrayList<>();

        // Extract battle scores from Score objects
        for (Score score : scoreArrayList) {
            scoreList.add(score.getBattleScore());
        }

        // Sort the score list in descending order
        Collections.sort(scoreList, Collections.reverseOrder());

        // Keep only the top 5 scores
        if (scoreList.size() > 5) {
            scoreList = scoreList.subList(0, 5);
        }

        // Write the top 5 scores to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("top_scores.txt"))) {
            writer.write("Top 5 Highest Scores:\n");
            for (int i = 0; i < scoreList.size(); i++) {
                int battleScore = scoreList.get(i);

                // Find the corresponding Score object with the battle score
                Score score = scoreArrayList.stream()
                        .filter(s -> s.getBattleScore() == battleScore)
                        .findFirst()
                        .orElse(null);

                if (score != null) {
                    String line = (i + 1) + ". " + score.getPlayerName() + ": " + score.getBattleScore() + "\n";
                    writer.write(line);
                }
            }
            System.out.println("Top scores have been updated to 'top_scores.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
