package day2;

import apcs.Window;

public class Bubble {

	public static void main(String[] args) {
		Window.size(500, 600);

		int[] arr = new int[50];
		setup(arr);
		
		int element = 30;

		bubble_sort(arr);
		
		int found_index = binary_search(arr, element);
		System.out.println(element + " is found at the index " + found_index);

	
//		// Driver
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
		
		Window.out.color("red");
		Window.out.rectangle(5 + 10 * found_index, Window.height() - arr[found_index]/2, 10, arr[found_index]);
		

	}

	private static void setup(int[] arr) {
		// Sets up the array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Window.random(0, 100);

		}

	}

	private static void visualize(int[] arr) {
		Window.frame(10);
		
		int x = 5;
		
		for (int i = 0; i <= arr.length - 1; i++) {
			Window.out.rectangle(x, Window.height() - arr[i] / 2, 10, arr[i] * 5);
			x += 10;
		}

	}

	private static void bubble_sort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - i - 1; j++) {
				Window.sleep(5);
				visualize(arr);

				// SWAP
				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
			
			//visualize(arr);
		}
		// return arr;
	}
	
	
	private static int binary_search(int[] array, int elem){
		
		//  [ 1,   2,   4,   5,   6,    9,   12 ]
		//    ^								  ^
		
		int first = 0;
		int last = array.length - 1;
		
		while(first <= last){
			int mid = (first + last)/2;
			
			if(array[mid] == elem){
				return mid;
			}else if(elem > array[mid]){
				first = mid + 1;
			}else{
				last = mid - 1;
			}
		}
		
		return -1;
	}
	
	

}
