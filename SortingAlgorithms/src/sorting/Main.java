package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(10));
		}
		System.out.println("Unsorted: " + list);
		SortingClass<Integer> sort = new SortingClass<>();
		sort.quickSort(list);
		System.out.println("Sorted: " + list);

	}
}
