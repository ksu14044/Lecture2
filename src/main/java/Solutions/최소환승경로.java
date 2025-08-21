package Solutions;

import java.util.*;
class 최소환승경로 {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = routes.length;

        for(int i = 0 ; i < routes.length; i++){
            for(int j = 0 ; j < routes[i].length; j++){
                List<Integer> list = graph.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                graph.put(routes[i][j], list);
            }
        }
        boolean[] ch = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                int curStop = q.poll();
                for(int line : graph.get(curStop)){
                    if(ch[line]) continue;
                    ch[line] = true;
                    for(int stop : routes[line]){
                        q.offer(stop);
                        if(stop == e) return L;
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        최소환승경로 T = new 최소환승경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
