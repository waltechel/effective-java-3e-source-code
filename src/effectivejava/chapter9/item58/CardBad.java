package effectivejava.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CardBad {
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

	CardBad(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public static void main(String[] args) {
		List<CardBad> deck = new ArrayList<>();
		// bad
		// j의 길이가 i의 길이보다 길며, i는 j에 종속되었기 때문에 당연히 문제가 발생
		for (Iterator<Suit> i = suits.iterator(); i.hasNext();)
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();)
				deck.add(new CardBad(i.next(), j.next()));
	}
}
