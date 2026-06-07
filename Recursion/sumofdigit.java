package Recursion;

 public class sumofdigit {
    public static void main(String[] args) {
        int ans = sum(111);
        System.out.println(ans);

    }
    static int sum(int n){
        if(n==0){
            return n;
        }
        return sum(n/10)+n%10;

    }

 {
    
}}
