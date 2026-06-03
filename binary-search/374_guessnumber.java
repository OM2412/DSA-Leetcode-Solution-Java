/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
/* Approach
The Strategy:
Start with start = 1 and end = n (full range)
Calculate middle: mid = start + (end - start) / 2
Why start + (end - start) / 2? To avoid integer overflow!
Call guess(mid) and get feedback:
If result == 0 → Found it! ✅ Return mid
If result == -1 → Your guess is too high, search LEFT (lower numbers)
Move end = mid - 1
If result == 1 → Your guess is too low, search RIGHT (higher numbers)
Move start = mid + 1
Repeat until you find the number */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
     int start=1;
     int end=n;
     while(start<=end){
        int mid=start+(end-start)/2;
        int result=guess(mid);
        if(result==0){
            return mid;
        } else if(result == -1){
            end=mid-1;
        
        }else{
            start=mid+1;
        }
     }   
 return start ;  }
}