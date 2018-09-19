import java.util.*;

class Solution {
    public ArrayList<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        
        int candidates_num = candidates.length;
        int min = 9999999;
        for(int i = 0; i < candidates_num; i++){
            if(candidates[i] < min)
                min = candidates[i];
        }
        
        boolean hasOne = false;
        
        for (int i = 0; i < candidates_num; i++){
            if(target - candidates[i] == 0){
                ArrayList<List<Integer>> base_res = new ArrayList<List<Integer>>();
                List<Integer> base_list = new ArrayList<Integer>();
                base_list.add(candidates[i]);
                res.add(base_list);
                hasOne = true;
            }
            if(target - candidates[i] >= min){
                hasOne = true;
                ArrayList<List<Integer>> temp = combinationSum(candidates, target - candidates[i]);
                for(int j = 0; j < temp.size(); j++){
                    List<Integer> temp_list = temp.get(j);
                    temp_list.add(candidates[i]);
                    res.add(temp_list);
                }
            }
        }
        if(!hasOne)
            return new ArrayList<List<Integer>>();
        
        HashSet<List<Integer>> unique_res = new HashSet<List<Integer>>();
        for(int i = 0; i < res.size(); i++){
            List<Integer> temp_list = res.get(i);
            Collections.sort(temp_list);
            unique_res.add(temp_list);
        }
        
        return new ArrayList(unique_res);
    }
}