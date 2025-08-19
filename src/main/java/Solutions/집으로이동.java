package Solutions;

import java.util.*;
class 집으로이동 {
    public int solution(int[] pool, int a, int b, int home){
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        int[][] ch = new int[10001][2];
        ch[0][0] = 1;
        ch[0][1] = 1;
        Set<Integer> set = new HashSet<>();
        for(int p : pool) set.add(p);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int pos = cur[0], prev = cur[1], cnt = cur[2];
            int nf = pos + a;
            int nb = pos - b;
            if(pos == home) return cnt;
//            System.out.println("pos : " + pos + " nf : " + nf + " nb : " + nb + " cnt : " + cnt);
            if(prev == 0){
                if(nf >= 0 && nf <= 10000 && ch[nf][0] == 0 && !set.contains(nf)) {
                    q.offer(new int[]{nf, 0, cnt + 1});
                    ch[nf][0] = 1;
                }
                if(nb >= 0 && nb <= 10000 && ch[nb][1] == 0 && !set.contains(nb)) {
                    q.offer(new int[]{nb, 1, cnt + 1});
                    ch[nb][1] = 1;
                }
            } else if(prev == 1) {
                if(nf >= 0 && nf <= 10000 && ch[nf][0] == 0 && !set.contains(nf)){
                    q.offer(new int[]{nf, 0, cnt + 1});
                    ch[nf][0] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        집으로이동 T = new 집으로이동();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
