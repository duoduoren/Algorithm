import java.util.Arrays;
//1.
public class Assignment2Searching {
	public static void main(String[] args) {
		int[] arr = new int[] {2, 7, 6, 5, 3, 4, 7, 1};
		System.out.println(Assignment2Searching.FindPeakInArray(arr));
		arr = new int[] {9, 8, 7, 6, 4, 9, 7};
		System.out.println(Assignment2Searching.FindPeakInArray(arr));
		arr = new int[] {0, -7, -8, 9, 3, 2, 3};
		int[] res = Assignment2Searching.FindPairSumClosestTo0(arr);
		System.out.println(res[0]);
		System.out.println(res[1]);		
		arr = new int[] {1, -7, -8, 9, 3, 2, 7};
		res = Assignment2Searching.FindPairSumClosestTo0(arr);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	static int FindPeakInArray(int[] arr) {
		return FindPeakInArray(arr, 0, arr.length-1);
	}
	static int FindPeakInArray(int[] arr, int low, int high) {
		if (low == high) {
			return low;
		}
		
		if (low + 1 == high) {
			return arr[low] > arr[high] ? low : high;
		}
		
		int mid = low + (high - low) / 2;
//		
//		if (arr[mid] == arr[low]) {
//			return Math.max(arr[low], arr[high]);
//		}
		
		if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
			return mid;
		} else if (arr[mid] < arr[mid+1]) {
			return FindPeakInArray(arr, mid+1, high);
		} else if (arr[mid] > arr[mid+1]) {
			return FindPeakInArray(arr, low, mid);
		} else {
			return -1;	
		}
	}

//2. 
	public static int[] FindPairSumClosestTo0(int[] arr) {
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr.length - 1;
		int finalLeft = 0;
		int finalRight = arr.length - 1;
		int sum = Integer.MAX_VALUE;
		
		while(start < end) {
			if (start  == end) {
				break;
			}
			int tempSum = arr[start] + arr[end];
//			sum = Math.abs(tempSum);
			if (Math.abs(tempSum) < sum) {
				finalLeft = start;
				finalRight = end;
				sum = Math.abs(tempSum);
			}
			
			if (tempSum == 0) {
				break;	
			}
			
			if (tempSum > 0) {
				end--;
			} else if (tempSum < 0) {
				start++;
			}
		}
		
		return new int[] {arr[finalLeft], arr[finalRight]};
	}
}
