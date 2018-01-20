import java.util.List;
import java.util.ArrayList;

public class BlackJackHand extends Hand {
	@Override
	public int score() {
		List<Integer> scores = possibleScore();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score: scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE? minOver : maxUnder;
	}
	
	private List<Integer> possibleScore() {
		List<Integer> scores = new ArrayList<>();
		for (Card card: cards) {
			updateScore(card, scores);
		}
		return scores;
	}
	
	private void updateScore(Card card, List<Integer> scores) {
		final int[] toAdd = getScores(card);
		if (scores.isEmpty()) {
			for(int score : toAdd) {
				scores.add(score);
			}
		} else {
			final int length = scores.size(); 
			for(int i = 0; i < length; i++) {
				int oldScore = scores.get(i);
				scores.set(i, oldScore + toAdd[0]);
				for (int j = 1; j < toAdd.length; j++) {
					scores.add(oldScore + toAdd[j]);
				}
			}
		}
	}
	
	private int[] getScores(Card card) {
		if (card.getFaceValue() > 1) {
			return new int[] {Math.min(card.getFaceValue(), 10)};
		} else {
			return new int[]{1,11};
		}
	}
	
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean isBlackJack() {
		if (cards.size()!=2) {
			return false;
		} 
		Card first = cards.get(0);
		Card second = cards.get(1);
		return (isAce(first) && isFaceCard(second) || isFaceCard(first) && isAce(first));
	}
	
	private static boolean isAce(Card c) {
		return c.getFaceValue() == 1;
	}
	
	private static boolean isFaceCard(Card c) {
		return c.getFaceValue() >= 11 && c.getFaceValue()<= 13;
	}
}
