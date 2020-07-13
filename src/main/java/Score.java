import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Score {
   _0("0", 0),
   _15("15", 1),
   _30("30", 2),
   _40("40", 3);

   private final String displayName;
   private final Integer score;

   Score(final String displayName, final int score) {
      this.displayName = displayName;
      this.score = score;
   }

   private static final Map<Integer, String> values = Arrays.stream(Score.values())
         .collect(Collectors.toMap(Score::getScore, Score::getDisplayName));

   private String getDisplayName() {
      return displayName;
   }

   private int getScore() {
      return score;
   }

   public static String getDisplayName(final int score) {
      return values.get(score);
   }
}
