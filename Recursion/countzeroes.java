package Recursion;

public class countzeroes {
    
   public static void main(String[] args) {
      int ans=  fnc(10);
System.out.println(ans);

    }
    static int fnc(int n){
        return helper( n, 0);

        }
        private static int helper(int n, int c){
        if(n==0){
            return 1;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }return helper(n/10,c);


}

}
