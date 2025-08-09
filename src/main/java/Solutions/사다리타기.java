package Solutions;

import java.util.*;
class 사다리타기 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        char[] first = new char[n];
        for(int i = 0 ; i < n ; i++){
            first[i] = (char)(65 + i);
        }
        for(int i = 0 ; i < n ; i++){
            char cur = first[i];
            int line = i + 1;
            for(int j = 0 ; j < ladder.length ; j++){
                int[] curLine = ladder[j];
                for(int k = 0 ; k < curLine.length ; k++){
                    if(curLine[k] == line){
                        line++;
                        continue;
                    } else if(curLine[k] == line - 1){
                        line--;
                        continue;
                    }
                }
            }
            answer[line - 1] = cur;
        }
        return answer;
    }

    public static void main(String[] args){
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}