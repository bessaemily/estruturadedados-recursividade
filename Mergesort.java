package estruturaDeDados;

public class Mergesort {
	
	public static void main(String[] args) {
		String[] books = { "Harry Potter", "O senhor dos aneis", "Animais feiaticos", "Percy Jackson",
				"Michael Jackson", "Avengers", "Jogos vorazes" };

		System.out.println("Antes de ordenar:");
		for (String book : books) {
			System.out.println(book);
		}

		mergeSort(books);

		System.out.println("\nDepois de ordenar:");
		for (String book : books) {
			System.out.println(book);
		}
	}

	public static void mergeSort(String[] arr) {
		if (arr == null) {
			return;
		}
 		if (arr.length > 1) {
			int mid = arr.length / 2;
			String[] leftArr = new String[mid];
			String[] rightArr = new String[arr.length - mid];
			for (int i = 0; i < mid; i++) {
				leftArr[i] = arr[i];
			}
			for (int i = mid; i < arr.length; i++) {
				rightArr[i - mid] = arr[i];
			}
			mergeSort(leftArr);
 			mergeSort(rightArr);
			merge(arr, leftArr, rightArr);
		}
	}

	public static void merge(String[] arr, String[] leftArr, String[] rightArr) {
		int i = 0, j = 0, k = 0;
		//i lado esquerdo
		//j lado direito
		//k contagem do array
		while (i < leftArr.length && j < rightArr.length) {
//			System.out.println(leftArr[i].compareTo(rightArr[j]));
			if (leftArr[i].compareTo(rightArr[j]) < 0) { //A letra da esquerda vem antes da direita
				arr[k++] = leftArr[i++]; 
			} else { //A letra da direita vem antes da esquerda
				arr[k++] = rightArr[j++]; 
			}
		}
		while (i < leftArr.length) {
			arr[k++] = leftArr[i++];
		}
		while (j < rightArr.length) {
			arr[k++] = rightArr[j++];
		}
	}

}