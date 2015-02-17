package climbingStairs;

public class ClimbingStairsRecur {
    public int climbStairsRecur(int n) {
    	if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairsRecur(n-1) + climbStairsRecur(n-2);
        
    }
 
}