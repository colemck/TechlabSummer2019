package day1;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {3, 5, 7, 8, 11, 13, 17};
		
		
		System.out.println(binary(arr, 11));
		
		

	}

	private static int binary(int[] arr, int elem) {
		
		int left = 0;
		int right = arr.length - 1;
		
		while(right >= left){
			
			int mid = left + (right-1)/2;
			
			if(arr[mid] == elem){
				return mid;
			}else if(elem > arr[mid]){
				left = mid + 1;
			}else{
				right = mid - 1;
				
			}
			
		}
		
		return -1;
	}

}
