package effectivejava.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CardGood {
	private final Suit suit;
	private final Rank rank;

	// 버그를 찾아보자.
	enum Suit {
		CLUB, DIAMOND, HEART, SPADE
	}

	enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	static Collection<Suit> suits = Arrays.asList(Suit.values());
	static Collection<Rank> ranks = Arrays.asList(Rank.values());

	CardGood(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "CardGood [suit=" + suit + ", rank=" + rank + "]";
	}

	public static void main(String[] args) {
		List<CardGood> deck = new ArrayList<>();

		// 코드 58-7 컬렉션이나 배열의 중첩 반복을 위한 권장 관용구 (349쪽)
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				deck.add(new CardGood(suit, rank));
			}
		}
		// 출력도 예쁘게 하자
		for (CardGood e : deck) {
			System.out.println(e.toString());
		}

	}
}
