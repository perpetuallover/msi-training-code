package com.kenny.beans;
import java.util.*;
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        result.add(al);
        getOne(result, al, nums);
        System.out.println(result);
        return result;
    }
    public void getOne(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> al, int[] nums){
        for(int i = 0; i < nums.length; i++){
        	ArrayList<Integer> al2 = new ArrayList<>();
        	al2 = (ArrayList<Integer>) al.clone();
            al2.add(nums[i]);
            result.add(al2);
            System.out.println(al2);
            getOne(result, al2, Arrays.copyOfRange(nums, i + 1, nums.length));
        }
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int nums[] = {1,2,3};
    	s.subsets(nums);
    }
}
