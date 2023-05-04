package com.sunbeam;

import java.util.Scanner;

public class Demo01Main {
	
	public static int linearSearch(int[] arr, int key) {
		//1. traverse array from 0 to size-1 index
		for(int i = 0 ; i < arr.length ; i++)
			//2. compare key with current element
			if(arr[i] == key)
				//3. if key is equal to current element then return index
				return i;
		//4. if key is not found then return -1
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 14};
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		//0. Take key from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, key);
		if(index == -1)
			System.out.println("Key is not found\n");
		else
			System.out.println("Key is found at index" + index);
		sc.close();
	}

}
