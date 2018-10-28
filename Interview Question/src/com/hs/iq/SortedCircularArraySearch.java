package com.hs.iq;

public class SortedCircularArraySearch {
	private int search(int arr[], int value) {
		int lenght = arr.length;
		int low = 0, high = lenght - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid]) {
				return mid;
			} else if (arr[mid] <= arr[high]) {// right half is sorted
				if (value > arr[mid] && value <= arr[high]) {
					low = mid + 1; // searching in right sorted half
				} else {
					high = mid - 1; // searching in left
				}
			} else { // left half is sorted
				if (value < arr[mid] && value >= arr[low]) { // searching in
																// left sorted
																// half
					high = mid - 1; // searching in left
				} else {
					low = mid + 1; // searching in right
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 34, 45, 2, 4, 5, 7 };
		SortedCircularArraySearch search = new SortedCircularArraySearch();
		int index = search.search(arr, 45);
		System.out.println("value found at index " + index);
	}
}