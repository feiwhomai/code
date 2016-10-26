/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 */
package leetcode;

public class LeetCode134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int currGas = 0;
        int totalGas = 0;

        int start = 0;
        for (int i = start; i < gas.length; i++) {
            currGas = currGas + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];

            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        if (totalGas >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
