class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int x = 0;
        int y = 0;
        boolean fromR = false;
        boolean fromL = true;
        boolean fromU = false;
        boolean fromD = false;
        res[0][0] = 1;
        while(true){
            index += 1;
            if(fromR){
                if(x-1 >= 0 && res[y][x-1] == 0){
                    res[y][x-1] = index;
                    y = y;
                    x = x-1;
                }
                else if(y-1 >= 0 && res[y-1][x] == 0){
                    res[y-1][x] = index;
                    fromR = false;
                    fromD = true;
                    y = y-1;
                    x = x;
                }
                else
                    break;
            }
            else if(fromL){
                if(x+1 < n && res[y][x+1] == 0){
                    res[y][x+1] = index;
                    y = y;
                    x = x+1;
                }
                else if(y+1 < n && res[y+1][x] == 0){
                    res[y+1][x] = index;
                    fromL = false;
                    fromU = true;
                    y = y + 1;
                    x = x;
                }
                else
                    break;
            }
            else if(fromU){
                if(y+1 < n && res[y+1][x] == 0){
                    res[y+1][x] = index;
                    y = y + 1;
                    x = x;
                }
                else if(x-1 >= 0 && res[y][x-1] == 0){
                    res[y][x-1] = index;
                    fromU = false;
                    fromR = true;
                    y = y;
                    x = x-1;
                }
                else
                    break;
            }
            else{
                if(y-1 >= 0 && res[y-1][x] == 0){
                    res[y-1][x] = index;
                    y = y-1;
                }
                else if(x+1 < n && res[y][x+1] == 0){
                    res[y][x+1] = index;
                    fromD = false;
                    fromL = true;
                    x = x + 1;
                }
                else
                    break;
            }
        }
        return res;
    }
}