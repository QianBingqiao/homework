package com.qbq.javasework;

import java.util.Arrays;

public class TestArrays {
	
	public boolean isSymmetricArr(int[] arr){
		  
		int[] arrs = new int[arr.length];
		
		for(int i=0,j=arr.length-1;i<arr.length;i++,j--){
		   arrs[i] =arr[j];
		}
		if(TestArraysEquals(arrs, arr)){
			return true;
		}
	     return false;			
	}
	/**
	 * 
	 * @param a
	 * @param a2
	 * @return
	 */
	public static boolean TestArraysEquals(int[] a, int[] a2) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;

        return true;
    }
	public static void main(String[] args) {
		TestArrays  t= new TestArrays();
		int[] arrs ={1,4,5,6,8,6,5,4,1};
		t.isSymmetricArr(arrs);
		System.out.println(t.isSymmetricArr(arrs));
	}

}
