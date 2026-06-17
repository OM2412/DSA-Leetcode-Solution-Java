package Recursion;
import java.util.Arrays;

public class quick {
    public static void main(String[] args){
int[] nums={5,4,6,7,8,2};
sort(nums,0,nums.length-1);
System.out.println(Arrays.toString(nums));
    }
    static void sort(int[] nums,int low , int high){
        if(low>=high){
            return;
        }
        int s= low;
        int e=high;
        int m=s+(e-s)/2;
        int p=nums[m];
        while(s<=e){
          while(nums[s]<p)  {
            s++;
          }
          while(nums[e]>p){
            e--;
          }
          if(s<=e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
          }
        }
        sort(nums,low,e);
        sort(nums,s,high);
    }
}
