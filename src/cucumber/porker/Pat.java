package cucumber.porker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Pat {
    public static final Pat NO_PAIR = new NoPair();
    public static Pat make(Hands hands) {
        HashMap<Card.Suit, Integer> suits
        		= new HashMap<Card.Suit, Integer>(5);
        HashMap<Integer, Integer> nums
        	= new HashMap<Integer, Integer>(5);
        List<Integer> noList = new ArrayList<Integer>();
        boolean straightFlg = true;
        for (Card card : hands) {
		    Integer countSuits = suits.get(card.suit);
	     	Integer countNums = nums.get(card.no);
	     	if (countSuits == null) countSuits = 0;
	     	if (countNums  == null) countNums = 0;
	     	countSuits++;
	     	countNums++;
		    suits.put(card.suit, countSuits);
        	nums.put (card.no  , countNums );
        	noList.add(card.no);
		}
        Collections.sort(noList, new Comparator<Integer>() {
        	public int compare(Integer num1, Integer num2) {
        		return num1.compareTo(num2);
        	}
		});
        for(int i=0; i<noList.size()-1; i++) {
        	if(noList.get(i) != noList.get(i+1)-1) {
        		straightFlg = false;
        		break;
        	}
        }
        for (Entry<Card.Suit, Integer> entry : suits.entrySet()) {
            if (entry.getValue() == 5) {
        		if(isRoyalStraightFlash(noList))
        			return new RoyalStraightFlash();
            	if(straightFlg)
            		return new StraightFlash();
                return new Flash();
            }
        }
        if(straightFlg) {
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

    public static class NoPair extends Pat {
    }
    public static class OnePair extends Pat {
        public final int no;

        OnePair(int no) {
            this.no = no;
        }
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + no;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            OnePair other = (OnePair) obj;
            if (no != other.no) return false;
            return true;
        }

    }
    public static class TwoPairs extends Pat {
        public final int no1;
        public final int no2;

        TwoPairs(int no1, int no2) {
            this.no1 = no1;
            this.no2 = no2;
        }
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + no1 + no2;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            TwoPairs other = (TwoPairs) obj;
            if (no1 != other.no1) return false;
            if (no2 != other.no2) return false;
            return true;
        }
    }
    public static class ThreeCards extends Pat {
        public final int no;

        ThreeCards(int no) {
            this.no = no;
        }
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + no;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            ThreeCards other = (ThreeCards) obj;
            if (no != other.no) return false;
            return true;
        }
    }
    public static class Straight extends Pat {
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + 30;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            return true;
        }
    }
    public static class Flash extends Pat {
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + 40;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            return true;
        }
    }
    public static class Fullhouse extends Pat {
        public final int no1;
        public final int no2;

        Fullhouse(int no1, int no2) {
            this.no1 = no1;
            this.no2 = no2;
        }
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + no1 + no2;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Fullhouse other = (Fullhouse) obj;
            if (no1 != other.no1) return false;
            if (no2 != other.no2) return false;
            return true;
        }
    }
    public static class FourCards extends Pat {
        public final int no;

        FourCards(int no) {
            this.no = no;
        }
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + no;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            FourCards other = (FourCards) obj;
            if (no != other.no) return false;
            return true;
        }
    }
    public static class StraightFlash extends Pat {
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + 50;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            return true;
        }
    }
    public static class RoyalStraightFlash extends Pat {
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + 60;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            return true;
        }
    }
    private static Pat isOnePairs(Set<Entry<Integer, Integer>> nums, Entry<Integer, Integer> onePair) {
        for (Entry<Integer, Integer> entry : nums) {
        	if(entry.getKey() == onePair.getKey())
        		continue;
            if (entry.getValue() == 2)
            	return new TwoPairs(onePair.getKey(), entry.getKey());
            if (entry.getValue() == 3)
        		return new Fullhouse(onePair.getKey(), entry.getKey());
        }
    	return new OnePair(onePair.getKey());
    }
    private static Pat isThreeCards(Set<Entry<Integer, Integer>> nums, Entry<Integer, Integer> onePair) {
        for (Entry<Integer, Integer> entry : nums) {
        	if(entry.getKey() == onePair.getKey())
        		continue;
            if (entry.getValue() == 2)
        		return new Fullhouse(onePair.getKey(), entry.getKey());
        }
    	return new ThreeCards(onePair.getKey());
    }
    private static boolean isRoyalStraightFlash(List<Integer> noList) {
    	boolean isRoyalStraightFlash = true;
    	for(int i=0; i<noList.size(); i++) {
    		if(noList.get(i) == 1 ||
    				noList.get(i) == 10 ||
    				noList.get(i) == 11 ||
    	    		noList.get(i) == 12 ||
    				noList.get(i) == 13 ) {
    			// doNothing
    		} else {
    			return false;
    		}
    	}
    	return isRoyalStraightFlash;
    }
}
