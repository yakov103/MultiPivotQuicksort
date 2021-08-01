package Ex1.MultiPivotQuicksort;

public class Ex1 {

	static void multiquicksort(int[] A, int low, int high) {
		if (low < high) {
			int[] pivots;
			pivots = partition2pivots(A, low, high);
			multiquicksort(A, low, pivots[0] - 1);
			multiquicksort(A, pivots[1] + 1, high);
			multiquicksort(A, pivots[0] + 1, pivots[1] - 1);

		}
	}

	static int[] partition2pivots(int[] A, int low, int high) {
		if (A[low] > A[high])
			swap(A, low, high);
		int lowSearch = low + 1;
		int highSearch = high - 1;
		int secLow = low + 1;
		int pivot1 = A[low];
		int pivot2 = A[high];
		while (secLow <= highSearch) {
			if (A[secLow] < pivot1) {
				swap(A, secLow, lowSearch);
				lowSearch = lowSearch + 1;
			} else if (A[secLow] >= pivot2) {
				while (A[highSearch] > pivot2 && secLow < highSearch) {
					highSearch--;
				}
				swap(A, secLow, highSearch);
				highSearch = highSearch - 1;

				if (A[secLow] < pivot1) {
					swap(A, secLow, lowSearch);
					lowSearch = lowSearch + 1;
				}
			}
			secLow++;

		}
		lowSearch = lowSearch - 1;
		highSearch = highSearch + 1;
		swap(A, low, lowSearch);
		swap(A, high, highSearch);
		int[] pivots = new int[2];
		pivots[0] = lowSearch;
		pivots[1] = highSearch;
		return pivots;
	}

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 212, 3, 100, 24, 8, 42, 75, 29, 77, 38, 57 };

		multiquicksort(arr, 0, 7);

		System.out.print("Sorted array: ");
		for (int i = 0; i < 8; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

}
