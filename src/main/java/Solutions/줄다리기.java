package Solutions;

import java.util.*;
class 줄다리기 {
    int answer;
    List<List<Integer>> list;

    public int solution(int[][] fight){

        answer = 0;
        list = new ArrayList<>();

        boolean[][] hates = new boolean[8][8];

        for(int[] f : fight){
            hates[f[0]][f[1]] = true;
            hates[f[1]][f[0]] = true;
        }

        boolean[] visited = new boolean[8];
        dfs(visited, hates, new ArrayList<>(), 0);

        return answer;

    }

    public void dfs(boolean[] visited, boolean[][] hates, List<Integer> cur, int prev){
        if(cur.size() == 7){
            answer++;
            return;
        }
        for(int i = 1 ; i <= 7 ; i++){
            if(!visited[i] && !hates[i][prev]){
                visited[i] = true;
                cur.add(i);
                dfs(visited, hates, cur, i);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        줄다리기 T = new 줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

