package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import sorting.SortingClass;

public class SortingClassTest {
	List<Integer> integerList;
	List<Float> floatList;
	SortingClass<Integer> integerSorting;
	SortingClass<Float> floatSorting;
	
	
	@Before
	public void setup() {
		integerList = Arrays.asList(5, -15, 28, 10, 40);
		floatList = Arrays.asList(0.5f, 0.39f, 12.5f, -0.29f);
		integerSorting = new SortingClass<>();
		floatSorting = new SortingClass<>();
	}

	@Test
	public void bubbleSortIntegerFloatShouldBeTrue() {
		integerSorting.bubbleSort(integerList);
		assertArrayEquals(integerList.toArray(), Arrays.asList(-15, 5, 10, 28, 40).toArray());
		floatSorting.bubbleSort(floatList);
		assertArrayEquals(floatList.toArray(), Arrays.asList(-0.29f, 0.39f, 0.5f, 12.5f).toArray());
	}
	
	@Test
	public void selectionSortIntegerFloatShouldBeTrue() {
		integerSorting.selectionSort(integerList);
		assertArrayEquals(integerList.toArray(), Arrays.asList(-15, 5, 10, 28, 40).toArray());
		floatSorting.selectionSort(floatList);
		assertArrayEquals(floatList.toArray(), Arrays.asList(-0.29f, 0.39f, 0.5f, 12.5f).toArray());
	}
	
	@Test
	public void mergeSortIntegerFloatShouldBeTrue() {
		integerSorting.mergeSort(integerList);
		assertArrayEquals(integerList.toArray(), Arrays.asList(-15, 5, 10, 28, 40).toArray());
		floatSorting.mergeSort(floatList);
		assertArrayEquals(floatList.toArray(), Arrays.asList(-0.29f, 0.39f, 0.5f, 12.5f).toArray());
	}
	
	@Test
	public void quickSortIntegerFloatShouldBeTrue() {
		integerSorting.quickSort(integerList);
		assertArrayEquals(integerList.toArray(), Arrays.asList(-15, 5, 10, 28, 40).toArray());
		floatSorting.quickSort(floatList);
		assertArrayEquals(floatList.toArray(), Arrays.asList(-0.29f, 0.39f, 0.5f, 12.5f).toArray());
	}
	

}
