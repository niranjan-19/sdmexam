package com.sunbeam;


import java.util.Arrays;

public class SelectionSortMain {

	public static void selectionSort(int[] arr, int size) {
		//1. count number of passes
		for(int i = 0 ; i < size - 1 ; i++) {
			//2. select the position - i
			//3. count number of comparisions
			for(int j = i + 1 ; j < size ; j++) {
				//4. compare selected position element with other element
				if(arr[i] > arr[j])
				{
					//5. if selected position element is greater than other element then swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {44, 11, 55, 22, 66, 33};
		
		System.out.println("Before sort : " + Arrays.toString(arr));
		selectionSort(arr, arr.length);
		System.out.println("After sort : " + Arrays.toString(arr));
	}

}
