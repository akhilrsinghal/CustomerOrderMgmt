package com.org.controller;

import java.util.ArrayList;

public class Example {
	
	static int pow(int a, int b){
		int c=1;
		for(int i = 0;i<b;i++){
			c=c*a;
		}
		System.out.println(c);
		return c;
	}
	
	public static int missingNumber(int[] arr)
	 {
	  int n=arr.length+1;
	  int sum=n*(n+1)/2;
	  int restSum=0;
	  for (int i = 0; i < arr.length; i++) {
	   restSum+=arr[i];
	  }
	  int missingNumber=sum-restSum;
	  return missingNumber;
	 }
	
	static void digit(int n){
		try{
		int digit  = 0, number, temp;
		ArrayList<Integer> l = new ArrayList<>();
		for(int i = 1;i<100;i++){
			if(i<10){
				number = digit + i;
				l.add(number);
			}
			else{
				temp = i;
				int a = temp%10;
				int b = temp/0;
				if(b<a){
					l.add(i);
				}
			}
		}
		
		System.out.println(l);
		}
		catch(RuntimeException e){
			System.out.println("catch1");
		}
		catch(Exception a){
			System.out.println("catch2");
		}
		finally {
			System.out.println("fiunally");
		}
		System.out.println("out");
	}
	
	static void duplicateElement(int arr[]){
		int i, j;
		int size = arr.length;
        System.out.println("Repeated Elements are :");
        for (i = 0; i < size; i++) 
        {
            for (j = i + 1; j < size; j++) 
            {
                if (arr[i] == arr[j]) 
                    System.out.print(arr[i] + " ");
            }
        }
	}
	 public static int getMax(int[] inputArray){ 
		    int maxValue = inputArray[0]; 
		    for(int i=1;i < inputArray.length;i++){ 
		      if(inputArray[i] > maxValue){ 
		         maxValue = inputArray[i]; 
		      } 
		    } 
		    return maxValue; 
		  }
		 
		  // Method for getting the minimum value
		  public static int getMin(int[] inputArray){ 
		    int minValue = inputArray[0]; 
		    for(int i=1;i<inputArray.length;i++){ 
		      if(inputArray[i] < minValue){ 
		        minValue = inputArray[i]; 
		      } 
		    } 
		    return minValue; 
		  } 
		  public static void temp(){
			  System.out.println("Hiiiiiiiiiii");
		  }
	
		  public static void main(String[] args) {
			//pow(0,2);
			//int[] arr1={7,5,6,1,4,2,2};
			//duplicateElement(arr1);
			 // System.out.println("Missing number from array arr1: "+missingNumber(arr1));
			  //digit(2);
			Example e ;
			e= null;
			e.temp();
		}

	
	
	
	
}
