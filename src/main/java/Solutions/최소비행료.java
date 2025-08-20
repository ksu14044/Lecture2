package Solutions;

import java.util.*;
class 최소비행료 {
//    class Node {
//        int end, cost;
//        public Node(int end, int cost){
//            this.end = end;
//            this.cost = cost;
//        }
//    }
//    List<List<Node>> graph;
//    boolean[] visited;
//    int answer;
//    public int solution(int n, int[][] flights, int s, int e, int k){
//        answer = Integer.MAX_VALUE;
//        graph = new ArrayList<>();
//        for(int i = 0 ; i < n ; i++){
//            graph.add(new ArrayList<>());
//        }
//        for(int[] f : flights){
//            int start = f[0], end = f[1], c = f[2];
//            graph.get(start).add(new Node(end, c));
//        }
//        visited = new boolean[n];
//        dfs(s, e, 0, k);
//        return answer == Integer.MAX_VALUE ? -1 : answer;
//    }
//
//    public void dfs(int pos, int end, int cost, int k){
//        if(pos == end){
//            answer = Math.min(answer, cost);
//        }
//        for(Node next : graph.get(pos)){
//            if(!visited[next.end]){
//                visited[next.end] = true;
//                if(next.end == end){
//                    dfs(next.end, end, cost + next.cost, k);
//                } else {
//                    if(k > 0){
//                        dfs(next.end, end, cost + next.cost, k - 1);
//                    }
//                }
//                visited[next.end] = false;
//            }
//        }
//    }
    List<List<int[]>> graph;
    boolean[] visited;
    public int solution(int n , int[][] flights, int s, int e, int k){
        int answer = 0;
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
        for(int[] f : flights){
            int start = f[0], end = f[1], cost = f[2];
            graph.get(start).add(new int[]{end, cost});
        }
        visited = new boolean[n];
        visited[s] = true;
        costs[s] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                int[] cur = q.poll();
                int pos = cur[0], cost = cur[1];
                for(int[] next : graph.get(pos)){
                    int nextPos = next[0];
                    int nextCost = next[1];
                    if(costs[nextPos] > nextCost + cost){
                        costs[nextPos] = nextCost + cost;
                        q.offer(new int[]{nextPos, nextCost + cost});
                    }
                }
            }
            L++;
            if(L > k) break;
        }
        return costs[e] == Integer.MAX_VALUE ? -1 : costs[e];
    }

    public static void main(String[] args){
        최소비행료 T = new 최소비행료();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}