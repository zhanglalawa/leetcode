package union_find;

public class InsertionSort {
	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1;  j > 0 && array[j - 1] > array[j] ; j--) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1,2,3,4,5,0 };

		insertionSort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
