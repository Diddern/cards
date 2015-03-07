package gamedata.poker;

import card.structure.deck.Card;

import com.badlogic.gdx.utils.Array;

public class QuickSort {

	private Array<Card> cards;
	private int number;

	public void sort(Array<Card> card) {
		// check for empty or null array
		if (card == null || card.size == 0)
			return;
		cards = card;
		number = card.size;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = cards.get(low + (high - low) / 2).getNumber();

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (cards.get(i).getNumber() < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (cards.get(j).getNumber() > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j) {
			quicksort(low, j);
		}
		if (i < high) {
			quicksort(i, high);
		}
	}

	private void exchange(int i, int j) {
		Card c = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, c);
	}

}
