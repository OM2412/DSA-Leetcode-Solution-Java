package Recursion.LinearSearch;
import java.util.ArrayList;

public class targetindex{
    public static void main(String[] args){
        int[] arr={1,2,3,4,4,5};
        System.out.println(findallindex(arr,4,0,new ArrayList<>()));
        
    }
    static ArrayList<Integer> findallindex(int[] arr,int target,int index, ArrayList<Integer> list){
if(index==arr.length){
    return list;
}if(arr[index]==target){
    list.add(index);
}
return findallindex(arr,target,index+1,list);
    }
}
