package binarySearch;

import java.util.Arrays;

public class ImportantReversePair {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 7, 8, 1, 6, 3, 5};
		ImportantReversePair importantReversePair = new ImportantReversePair();
		System.out.println(importantReversePair.reversePairs(nums));
	}

	public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
}