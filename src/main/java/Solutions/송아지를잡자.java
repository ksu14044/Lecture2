package Solutions;

import java.util.*;
class 송아지를잡자 {
    public int solution(int s, int e){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int[][] ch = new int[200001][2];
        ch[s][0] = 1;
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            L++;
            for(int i = 0 ; i < len ; i++){
                int x = q.poll();
                for(int nx : new int[]{x + 1, x - 1, x * 2}){
                    if(nx >= 0 && nx <= 200000 && ch[nx][L % 2] == 0){
                        ch[nx][L%2] = 1;
                        q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[e][L%2] == 1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        송아지를잡자 T = new 송아지를잡자();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
