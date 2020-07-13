import org.junit.Assert;
import org.junit.Test;

public class TennisScoreImplTest {

   @Test
   public void newGame() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("0-0", score);
   }

   @Test
   public void score0And30() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerBScores(sut, 2);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("0-30", score);
   }

   @Test
   public void playerAWinVsPlayerB() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerAScores(sut, 4);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("Game-", score);
   }

   @Test
   public void playerBWinVsPlayerA() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerBScores(sut, 4);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("-Game", score);
   }

   @Test
   public void playerAAdvantageVsPlayerB() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerAScores(sut, 5);
      playerBScores(sut, 4);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("Advantage-", score);
   }

   @Test
   public void playerBAdvantageVsPlayerA() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerBScores(sut, 5);
      playerAScores(sut, 4);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("-Advantage", score);
   }

   @Test
   public void playerAAndPlayerBDeuce() {
      // Given
      TennisScore sut = new TennisScoreImpl();
      playerAScores(sut, 4);
      playerBScores(sut, 4);
      // When
      String score = sut.getScore();
      // Then
      Assert.assertEquals("Deuce", score);
   }

   @Test
   public void incrementScoreA() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      // When
      sut.playerAScores();
      // Then
      Assert.assertEquals(1, sut.getScoreA());
   }

   @Test
   public void incrementScoreB() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      // When
      sut.playerBScores();
      // Then
      Assert.assertEquals(1, sut.getScoreB());
   }

   @Test
   public void noWinner() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertFalse(hasWinner);
   }

   @Test
   public void noWinnerPlayerAAndPlayerBLessThan40() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 3);
      playerBScores(sut, 3);
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertFalse(hasWinner);
   }

   @Test
   public void playerAWin() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 4);
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertTrue(hasWinner);
   }

   @Test
   public void noWinnerPlayerADifferenceLessThanTwo() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 4);
      playerBScores(sut, 3);
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertFalse(hasWinner);
   }

   @Test
   public void playerBWin() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerBScores(sut, 4);
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertTrue(hasWinner);
   }

   @Test
   public void noWinnerPlayerBDifferenceLessThanTwo() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 3);
      playerBScores(sut, 4);
      // When
      boolean hasWinner = sut.hasWinner();
      // Then
      Assert.assertFalse(hasWinner);
   }

   @Test
   public void playerAAdvantage() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 5);
      playerBScores(sut, 4);
      // When
      boolean hasAdvantage = sut.hasAdvantage();
      // Then
      Assert.assertTrue(hasAdvantage);
   }

   @Test
   public void playerBAdvantage() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 4);
      playerBScores(sut, 5);
      // When
      boolean hasAdvantage = sut.hasAdvantage();
      // Then
      Assert.assertTrue(hasAdvantage);
   }

   @Test
   public void isDeuce() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 3);
      playerBScores(sut, 3);
      // When
      boolean isDeuce = sut.isDeuce();
      // Then
      Assert.assertTrue(isDeuce);
   }

   @Test
   public void noDeuce() {
      // Given
      TennisScoreImpl sut = new TennisScoreImpl();
      playerAScores(sut, 3);
      playerBScores(sut, 4);
      // When
      boolean isDeuce = sut.isDeuce();
      // Then
      Assert.assertFalse(isDeuce);
   }

   private void playerAScores(final TennisScore sut, final int times) {
      for (int it = 0; it < times; it++) {
         sut.playerAScores();
      }
   }

   private void playerBScores(final TennisScore sut, final int times) {
      for (int it = 0; it < times; it++) {
         sut.playerBScores();
      }
   }

}
