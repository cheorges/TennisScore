public class TennisScoreImpl implements TennisScore {

   private static final String DEUCE = "Deuce";
   private static final String ADVANTAGE = "Advantage";
   private static final String GAME = "Game";

   private int scoreA;
   private int scoreB;

   @Override
   public String getScore() {
      if (hasWinner()) {
         return translate(scoreA, scoreB, GAME);
      } else if (hasAdvantage()) {
         return translate(scoreA, scoreB, ADVANTAGE);
      } else if (isDeuce()) {
         return DEUCE;
      }
      return Score.getDisplayName(scoreA) + "-" + Score.getDisplayName(scoreB);
   }

   private String translate(final int scoreA, final int scoreB, final String state) {
      if (scoreA > scoreB)
         return state + "-";
      return "-" + state;
   }

   @Override
   public void playerAScores() {
      scoreA++;
   }

   @Override
   public void playerBScores() {
      scoreB++;
   }

   boolean isDeuce() {
      return scoreA >= 3 && scoreB == scoreA;
   }

   boolean hasAdvantage() {
      return scoreA >= 4 && scoreA >= scoreB + 1 || scoreB >= 4 && scoreB >= scoreA + 1;
   }

   boolean hasWinner() {
      return  scoreA >= 4 && scoreA >= scoreB + 2 || scoreB >= 4 && scoreB >= scoreA + 2;
   }

   public int getScoreA() {
      return scoreA;
   }

   public int getScoreB() {
      return scoreB;
   }
}
