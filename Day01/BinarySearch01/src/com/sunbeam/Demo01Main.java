package com.sunbeam;

import java.util.Scanner;

public class Demo01Main {
	
		
	public static int binarySearch(int[] arr, int key) {
		int left = 0, right = arr.length-1, mid;
		while(left <= right)
		{
			//1. find middle of the array
			mid = (left + right)/2;
			//2. compare key with middle element
			if(key == arr[mid])
				//3. if key is matching, return mid
				return mid;
			//4. if key is less than middle element, 
			else if(key < arr[mid])	
				right = mid - 1;//search key into left sub array
			//5. if key is greater than middle element,
			else
				left = mid + 1;//search key into right sub array
		}	//6. repeat above steps till valid partition
		//7. if key is not found, return -1
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		//0. Take key from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = binarySearch(arr, key);
		if(index == -1)
			System.out.println("Key is not found\n");
		else
			System.out.println("Key is found at index" + index);
		sc.close();
	}

}
