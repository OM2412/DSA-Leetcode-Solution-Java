package Recursion.LinearSearch;

public class Target {
    public static void main(String[] args) {
        int[] arr={1,2,9,6};

        System.out.println(target(arr,0,6));
    }
     static int  target(int[] arr,int index,int t){
        if(arr[index]==t){
            return index;
        }
        return target(arr,index+1,t);
        }
            
        }
    

