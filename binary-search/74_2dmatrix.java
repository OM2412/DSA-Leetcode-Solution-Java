/* Approach
We'll use a top-right corner elimination strategy:

Starting position: Begin at top-right corner (row=0, col=n-1)
Target found: If current element equals target, return true
Move down: If target > current, eliminate current row (move down: i++)
Move left: If target < current, eliminate current column (move left: j--)
Boundary termination: Stop when we go out of bounds (no valid position remains)
This approach works because from top-right, smaller values are to the left and larger values are below.

Complexity
Time complexity: O(m+n)
Where m is rows and n is columns, as we move at most m steps down and n steps left.

Space complexity: O(1)
We only use constant extra space for position variables i and j. */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int row=0;
      int col=matrix[0].length-1;
      while(row<matrix.length && col>=0) {
        
        if(matrix[row][col]==target){
return true;
        }else if(matrix[row][col]<target){
            row++;
        }else{
            col--;
        }
      } 
  return false;  }
}