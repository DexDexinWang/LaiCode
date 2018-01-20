
public enum FaceValue {
	ACE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NIGHT (9),
	TEN (10),
	JACK (10),
	QUEEN (10),
	KIND (10);
	
	private int value;
	FaceValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
