
public class FindKthLargestElement {
	public int findKthLargestElement(int[] array, int startIndex, int endIndex, int k) {
		int position = partition(array, startIndex, endIndex);
		if (position == k-1) {
		    	return array[position];
		} else if (position > k -1) {
			return this.findKthLargestElement(array, startIndex, position-1,k);
		} else {
			return this.findKthLargestElement(array, position+1, endIndex,k);
		}
	}
	
	private void swap(int[] array, int start, int end) {
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
	
	private int partition(int[] array, int startIndex, int endIndex) {
		int candidate = array[startIndex];
		int l = startIndex + 1;
		int r = endIndex;
		while (l < r) {
			if (array[l] > candidate) {
				l++;
			} else if (array[r] < candidate) {
				r--;
			} else {
				this.swap(array, l, r);
				l++;
				r--;
			}
		}
		
		this.swap(array, startIndex, r);
		return r;
	}
}