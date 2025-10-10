import java.util.*;

class Solution {
    void merge(int[] nums, int l, int mid, int h){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l;
        int right = mid + 1;
        while( left <= mid && right <= h){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= h){
            temp.add(nums[right]);
            right++;
        }
        for(int i = l; i <= h; i++){
            nums[i] = temp.get(i-l);
        }
    }

    void mergeSort(int[] nums, int l, int h){
        if(l == h){
            return;
        }
        int mid = ( l + h) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid +1, h);
        merge(nums, l, mid, h);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length -1);
        return nums;
    }
}