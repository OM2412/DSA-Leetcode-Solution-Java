
package Bits;

public class factor {
    
public static void main(String[] args){
factor1(20);
}
static void factor1(int n){
    for(int i=1;i<=n;i++){
        if(n%i==0){
            System.out.print(i+" ,");
        }

    }
}
    
}
