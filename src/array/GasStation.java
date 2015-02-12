package array;

/*
There are N gas stations along a circular route, 
where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] 
of gas to travel from station i to its next station (i+1). You
begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can
travel around the circuit once, otherwise return -1.
 */

/*
Here we maintain two variable sum, total.
1.total is used to check whether the car can travel around the circuit.
2.sum is used to find the start index, when we find the sum is less than 0, 
it means that the last start index can not travel around the circuit,
we need to start from the next index. So the result should be startIndex + 1
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = -1;
        int sum = 0;
        int total = 0;
        for(int i=0; i<n; i++) {
        	sum = sum + (gas[i] - cost[i]);
        	total = total + (gas[i] - cost[i]);
        	if(sum<0) {
        		start = i;
        		sum = 0;
        	}
        }
        return total >= 0 ? start + 1 : -1;    	
    }
}