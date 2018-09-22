import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        ArrayList<Integer> aList = new ArrayList<>();
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            aList.add(A[i]);
        }
        
        Collections.sort(aList);
        
        for(int i = 0; i < aList.size(); i++)
            map.put(aList.get(i), i);
        
        long[] DP = new long[A.length];
        DP[0] = 1;
        
        for(int i = 1; i < aList.size(); i++){
            for(int j = 0; j < i; j++)
                    if(aList.get(i) % aList.get(j) == 0 && map.containsKey(aList.get(i)/aList.get(j))){
                        DP[i] += DP[j] * DP[map.get(aList.get(i)/aList.get(j))];
                    }
            DP[i] += 1;
        }
        
        long sum = 0;
        for(int i = 0; i < DP.length; i++)
            sum += DP[i];
        
        return (int)(sum%1000000007);
    }
}