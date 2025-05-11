import java.util.*;
public class SelectionSort {
	static class Pair {
        String value;
        int rank;

        Pair(String value, int rank) {
            this.value = value;
            this.rank = rank;
        }
    }

	public static ArrayList<String> selectionSort(ArrayList<String> listA, ArrayList<Integer> listB) {
		if (listA == null || listB == null || listA.size() != listB.size()) return null;

		int n = listB.size();

		List<Pair> loPairs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			loPairs.add(new Pair(listA.get(i), listB.get(i)));
		}

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (loPairs.get(j).rank < loPairs.get(min).rank) {
					min = j;
				}
			}

			if (i != min) {
				Pair tmp = loPairs.get(i);
				loPairs.set(i, loPairs.get(min));
				loPairs.set(min, tmp);
			}

		}

		ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < loPairs.size(); i++) {
            output.add(loPairs.get(i).value);
        }

        return output;
	}
}
