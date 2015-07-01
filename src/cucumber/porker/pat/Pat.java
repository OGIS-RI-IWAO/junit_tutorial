package cucumber.porker.pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cucumber.porker.Card;
import cucumber.porker.Hands;

public abstract class Pat {
	public static final Pat NO_PAIR = new NoPair();

	public static Pat make(Hands hands) {
		HashMap<Card.Suit, Integer> suits = new HashMap<Card.Suit, Integer>(5);
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>(5);
		List<Integer> noList = new ArrayList<Integer>();
		boolean straightFlg = true;
		Integer countSuits = 0;
		Integer countNums = 0;
		for (Card card : hands) {
			countSuits = suits.get(card.suit);
			countNums = nums.get(card.no);
			if (countSuits == null)
				countSuits = 0;
			if (countNums == null)
				countNums = 0;
			countSuits++;
			countNums++;
			suits.put(card.suit, countSuits);
			nums.put(card.no, countNums);
			noList.add(card.no);
		}
		Collections.sort(noList, new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2);
			}
		});
		for (int i = 0; i < noList.size() - 1; i++) {
			if (noList.get(i) != noList.get(i + 1) - 1) {
				straightFlg = false;
				break;
			}
		}
		for (Entry<Card.Suit, Integer> entry : suits.entrySet()) {
			if (entry.getValue() == 5) {
				if (isRoyalStraight(noList))
					return new RoyalStraightFlash();
				if (straightFlg)
					return new StraightFlash();
				return new Flash();
			}
		}
		if (straightFlg || isRoyalStraight(noList)) {
			return new Straight();
		}
		for (Entry<Integer, Integer> entry : nums.entrySet()) {
			if (entry.getValue() == 2) {
				return isOnePairs(nums.entrySet(), entry);
			}
			if (entry.getValue() == 3) {
				return isThreeCards(nums.entrySet(), entry);
			}
			if (entry.getValue() == 4)
				return new FourCards(entry.getKey());
		}
		return NO_PAIR;
	}

	private static Pat isOnePairs(Set<Entry<Integer, Integer>> nums,
			Entry<Integer, Integer> onePair) {
		for (Entry<Integer, Integer> entry : nums) {
			if (entry.getKey() == onePair.getKey())
				continue;
			if (entry.getValue() == 2)
				return new TwoPairs(onePair.getKey(), entry.getKey());
			if (entry.getValue() == 3)
				return new Fullhouse(onePair.getKey(), entry.getKey());
		}
		return new OnePair(onePair.getKey());
	}

	private static Pat isThreeCards(Set<Entry<Integer, Integer>> nums,
			Entry<Integer, Integer> onePair) {
		for (Entry<Integer, Integer> entry : nums) {
			if (entry.getKey() == onePair.getKey())
				continue;
			if (entry.getValue() == 2)
				return new Fullhouse(onePair.getKey(), entry.getKey());
		}
		return new ThreeCards(onePair.getKey());
	}

	private static boolean isRoyalStraight(List<Integer> noList) {
		boolean isRoyalStraight = true;
		for (int i = 0; i < noList.size(); i++) {
			if (noList.get(i) == 1 || noList.get(i) == 10
					|| noList.get(i) == 11 || noList.get(i) == 12
					|| noList.get(i) == 13) {
				// doNothing
			} else {
				return false;
			}
		}
		return isRoyalStraight;
	}
}
