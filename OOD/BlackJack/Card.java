
public class Card {
	private int faceValue;
	private Suit suit;
	
	Card(Suit suit, int faceValue) {
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public Suit getSuit(){
		return suit;
	}
}
