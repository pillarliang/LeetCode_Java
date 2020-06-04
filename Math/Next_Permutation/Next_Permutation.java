package LeetCode_Java.Math.Next_Permutation;

import java.util.Arrays;
import java.util.Collections;

public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        //find  the first non-descending number
        int exchangeIndex1 = nums.length - 2;
        while(exchangeIndex1 >= 0 && nums[exchangeIndex1] >= nums[exchangeIndex1+1]){
            exchangeIndex1--;
        }

        // If such arrangement is not possible,
        // it must rearrange it as the lowest possible order (ie, sorted in ascending order).
        if (exchangeIndex1 == -1){
            Arrays.sort(nums);
            return;
        }

        int exchangeIndex2 = nums.length -1;
        while(exchangeIndex2 > exchangeIndex1 && nums[exchangeIndex2] <= nums[exchangeIndex1]){
            exchangeIndex2--;
        }

        //swap nums[exchangeIndex1] with nums[exchangeIndex2]
        int temp = nums[exchangeIndex1];
        nums[exchangeIndex1] = nums[exchangeIndex2];
        nums[exchangeIndex2] = temp;

        // reverse the elements after the index of exchangeIndex2
        int left = exchangeIndex1 + 1, right = nums.length -1;
        while (left < right){
            int tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;
            left++;
            right--;
        }


    }
}
