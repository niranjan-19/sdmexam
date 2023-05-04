package com.sunbeam;

import java.util.Scanner;

public class Demo01Main {
	
	public static int binarySearch(int[] arr, int key, int left, int right) {
		//0. return -1 if partition is invalid
		if(left > right)
			return -1;
		//1. find mid of array
		int mid = (left + right)/2;
		//2. Compare key with middle element
		if(key == arr[mid])
			return mid;	// if key is equal, then return mid
		//3. check if key is less
		else if(key < arr[mid])
			return binarySearch(arr, key, left, mid - 1);	// searching key into left partition
		//4. check if key is greater
		else
			return binarySearch(arr, key, mid + 1, right);	// searching key into right partition
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		//0. Take key from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = binarySearch(arr, key, 0, arr.length-1);
		if(index == -1)
			System.out.println("Key is not found\n");
		else
			System.out.println("Key is found at index" + index);
		sc.close();
	}

}
