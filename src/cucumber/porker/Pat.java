package cucumber.porker;

import java.util.HashMap;
import java.util.Map.Entry;

public abstract class Pat {
    public static final Pat NO_PAIR = new NoPair();
    public static Pat make(Hands hands) {
    	// TODO ストレートフラッシュ
    	// TODO ストレート
        HashMap<Card.Suit, Integer> suits
        		= new HashMap<Card.Suit, Integer>(5);
		for (Card card : hands) {
		    Integer count = suits.get(card.suit);
		    if (count == null) count = 0;
		    count++;
		    suits.put(card.suit, count);
		}
        for (Entry<Card.Suit, Integer> entry : suits.entrySet()) {
            if (entry.getValue() == 5) {
            	// TODO ロイヤルストレートフラッシュ
                return new Flash();
            }
        }
        HashMap<Integer, Integer> nums
        = new HashMap<Integer, Integer>(5);
        for (Card card : hands) {
        	Integer count = nums.get(card.no);
        	if (count == null) count = 0;
        	count++;
        	nums.put(card.no, count);
        }
        for (Entry<Integer, Integer> entry : nums.entrySet()) {
            if (entry.getValue() == 2) {
            	// TODO ツーペア
            	// TODO フルハウス
                return new OnePair(entry.getKey());
            }
            if (entry.getValue() == 3) { 
                // TODO フルハウス
                return new ThreeCards(entry.getKey());
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
    public static class Flash extends Pat {
        // hashCode,equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + 20;
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
}
