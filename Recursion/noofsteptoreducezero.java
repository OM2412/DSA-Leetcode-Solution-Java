package Recursion;

public class noofsteptoreducezero {
    public static void main(String[] args) {
        int ans = numberofSteps(14);
        System.out.println(ans);
    }
    static int numberofSteps(int n){
        return helper(n,0);
    }
    private static int helper(int n,int nos){
        if(n==0){
            return nos;
        }
        if(n%2==0){

            return helper(n/2,nos+1);


            }else{

            return helper(n-1,nos+1);
        }


}}


