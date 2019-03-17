package sorting;

import java.util.LinkedList;
import java.util.List;

public class SortingClass<T extends Number & Comparable<T> > {

	private void changeIndex(List<T> list, int index1, int index2) {
		T buffer = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, buffer);
	}

	private int calculateMiddle(int a, int b) {
		return (a + b) / 2;
	}

	private void mergeSortMethod(List<T> list, int begin, int middle, int end) {
		List<T> firstPart = new LinkedList<>();
		List<T> secondPart = new LinkedList<>();
		for (int i = begin; i <= middle; i++) {
			firstPart.add(list.get(i));
		}
		for (int i = middle + 1; i <= end; i++) {
			secondPart.add(list.get(i));
		}
		int firstPartIndex = 0, secondPartIndex = 0, listIndex = begin;
		while (firstPartIndex < firstPart.size() && secondPartIndex < secondPart.size()) {
			if (firstPart.get(firstPartIndex).compareTo(secondPart.get(secondPartIndex)) < 0) {
				list.set(listIndex, firstPart.get(firstPartIndex));
				firstPartIndex++;
				listIndex++;
			} else {
				list.set(listIndex, secondPart.get(secondPartIndex));
				secondPartIndex++;
				listIndex++;
			}
		}
		if (firstPartIndex > firstPart.size() - 1) {
			while (secondPartIndex <= secondPart.size() - 1) {
				list.set(listIndex, secondPart.get(secondPartIndex));
				secondPartIndex++;
				listIndex++;
			}
		} else if (secondPartIndex > secondPart.size() - 1) {
			while (firstPartIndex <= firstPart.size() - 1) {
				list.set(listIndex, firstPart.get(firstPartIndex));
				listIndex++;
				firstPartIndex++;
			}
		}
	}

	private void mergeSort(List<T> list, int begin, int end) {
		if (begin < end) {
			int middle = calculateMiddle(begin, end);
			mergeSort(list, begin, middle);
			mergeSort(list, middle + 1, end);
			mergeSortMethod(list, begin, middle, end);
		}
	}

	public void mergeSort(List<T> list) {
		mergeSort(list, 0, list.size() - 1);
	}

	private void quickSort(List<T> list, int begin, int end) {
		if (begin < end) {
			int i = DivideTable(list, begin, end);
			quickSort(list, begin, i - 1);
			quickSort(list, i + 1, end);
		}
	}

	public void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);
	}

	private int DivideTable(List<T> list, int begin, int end) {
		int middle = calculateMiddle(begin, end);
		T indexMiddleValue = list.get(middle);
		changeIndex(list, middle, end);

		int pointer = begin;
		for (int i = begin; i < end; i++) {
			if (indexMiddleValue.compareTo(list.get(i)) > 0) {
				changeIndex(list, pointer, i);
				pointer++;
			}
		}
		changeIndex(list, pointer, end);
		return pointer;
	}

	public void bubbleSort(List<T> list) {
		for (int i = list.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					changeIndex(list, j, j + 1);
				}
			}
		}
	}

	public void selectionSort(List<T> list) {
		int minIndex, maxIndex;
		for (int i = 0, j=list.size()-1; i < list.size()/2; i++, j--) {
			minIndex = i;
			maxIndex = i;
			for (int k = i+1; k <= j; k++) {
				if (list.get(k).compareTo(list.get(minIndex)) < 0) {
					minIndex = k;
				}
				if (list.get(k).compareTo(list.get(maxIndex)) > 0) {
					maxIndex = k;
				}
			}
			if(maxIndex==i && minIndex==j) {
				changeIndex(list, maxIndex, j);
			}else if(maxIndex==i) {
				changeIndex(list, maxIndex, j);
				changeIndex(list, minIndex, i);
			}else {
				changeIndex(list, minIndex, i);
				changeIndex(list, maxIndex, j);
			}
		}
	}

}
