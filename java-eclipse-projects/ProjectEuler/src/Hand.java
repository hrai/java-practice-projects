import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private ArrayList<Character> cards = new ArrayList<Character>();
	private ArrayList<Character> suits = new ArrayList<Character>();
	
	/**
	 * Constructor
	 * 
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 * @param five
	 */
	public Hand(String one, String two, String three, String four, String five) {
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		
		cards.add(one.charAt(0));
		cards.add(two.charAt(0));
		cards.add(three.charAt(0));
		cards.add(four.charAt(0));
		cards.add(five.charAt(0));
		
		suits.add(one.charAt(1));
		suits.add(two.charAt(1));
		suits.add(three.charAt(1));
		suits.add(four.charAt(1));
		suits.add(five.charAt(1));
		
		Collections.sort(cards);
		Collections.sort(suits);
	}

	/*
	 * Getters for the variables
	 */
	public String getOne() {
		return one;
	}

	public String getTwo() {
		return two;
	}

	public String getThree() {
		return three;
	}

	public String getFour() {
		return four;
	}

	public String getFive() {
		return five;
	}
	
	/**
	 * Checks if the hand is a royal flush
	 * @return
	 */
	public boolean isRoyalFlush() {
		if(cards.contains('T') && cards.contains('J') && cards.contains('Q') && 
				cards.contains('K') && cards.contains('A')) {
			if(
					Collections.frequency(suits, "D") == 5 ||
					Collections.frequency(suits, "S") == 5 ||
					Collections.frequency(suits, "H") == 5 ||
					Collections.frequency(suits, "C") == 5
					) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isStraightFlush() {
		if(isFlush()) {
			if(isStraight()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasFourOfAKind() {
		return hasOfKind(4) == 4;
	}
	
	public boolean isFullHouse() {
		return hasThreeOfAKind() && hasOnePair();
	}
	
	public boolean isFlush() {
		if(
				Collections.frequency(suits, "D") == 5 ||
				Collections.frequency(suits, "S") == 5 ||
				Collections.frequency(suits, "H") == 5 ||
				Collections.frequency(suits, "C") == 5
				) {
			return true;
		}
		
		return false;
	}
	
	public boolean isStraight() {
		ldfsajk
	}
	
	public boolean hasThreeOfAKind() {
		return hasOfKind(3) == 3;
	}
	
	/**
	 * Pass the frequency of a particular card to this method.
	 * Returns the card whose frequency is that of the 
	 * card passed to it.
	 * 
	 * @param frequency
	 * @return
	 */
	public char hasOfKind(int frequency) {
		switch(frequency) {
		
		case Collections.frequency(cards, '1'):
			return 1;

		case Collections.frequency(cards, '2'): 
			return 2;

		case Collections.frequency(cards, '3'): 
			return 3;

		case Collections.frequency(cards, '4'): 
			return 4;

		case Collections.frequency(cards, '5'): 
			return 5;

		case Collections.frequency(cards, '6'): 
			return 6;

		case Collections.frequency(cards, '7'): 
			return 7;

		case Collections.frequency(cards, '8'): 
			return 8;

		case Collections.frequency(cards, '9'): 
			return 9;

		case Collections.frequency(cards, 'T'): 
			return 'T';

		case Collections.frequency(cards, 'J'): 
			return 'J';

		case Collections.frequency(cards, 'Q'): 
			return 'Q';

		case Collections.frequency(cards, 'K'): 
			return 'K';

		case Collections.frequency(cards, 'A'): 
			return 'A';
		
		default: 
			return 0;
		}
	}
	
	public boolean hasTwoPairs() {
		int count = 0;
		
		for(int i=0; i<4; i++) {
			if(cards.get(i) == cards.get(4) || 
					cards.get(i) == cards.get(5)) {
				count++;
			}
		}
		
		if(count == 2)
			return true;
		else
			return false;
	}
	
	public boolean hasOnePair() {
		for(int i=0; i<4; i++) {
			if(cards.get(i) == cards.get(4) || 
					cards.get(i) == cards.get(5)) {
				return true;
			}
		}
		
		return false;
	}
	
	public char getHighCard() {
		char result = 0;
		
		index: for(char c: cards) {
			switch(c) {
			
			case 'A':
				result = 'A';
				break index;

			case 'K':
				result = 'K';
				break index;

			case 'J':
				result = 'J';
				break index;

			case 'T':
				result = 'T';
				break index;

			case 9:
				result = 9;
				break index;

			case 8:
				result = 8;
				break index;

			case 7:
				result = 7;
				break index;

			case 6:
				result = 6;
				break index;

			case 5:
				result = 5;
				break index;

			case 4:
				result = 4;
				break index;

			case 3:
				result = 3;
				break index;

			case 2:
				result = 2;
				break index;

			case 1:
				result = 1;
				break index;
			
			default:
				result = 0;
				break index;
				
			}
		}
		
		return result;
	}
	
	
}
