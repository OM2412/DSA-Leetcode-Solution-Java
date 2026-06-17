package Recursion;
import java.util.Arrays;


public class selection {
    public static void main(String[] args){
        int[] arr={1,4,3,5};
        selections(arr,arr.length,0,0);
        System.out.print(Arrays.toString(arr));

    }static void selections(int[] arr,int r,int c,int max){
        if(r==0){
            return;
        }if(r>c)
            {if(arr[c]>arr[max]){
            selections(arr,r,c+1,c);
        }else{
            selections(arr,r,c+1,max);
        }


        }else{
            int temp=arr[max];
            arr[max]=arr[r-1];
            arr[r-1]=temp;
            selections(arr,r-1,0,0);
        }
    }
}
