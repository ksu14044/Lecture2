package Solutions;

import java.util.*;
class 바둑대회 {
//    List<List<Integer>> white;
//    List<List<Integer>> black;
//    public int solution(int[][] cans){
//        int answer = Integer.MAX_VALUE;
//        int n = cans.length;
//        int m = n / 2;
//        white = new ArrayList<>();
//        dfs(new ArrayList<>(), 0, m , n);
//        black = new ArrayList<>();
//        for(int i = 0 ; i < white.size() ; i++){
//            List<Integer> l = new ArrayList<>();
//            for(int j = 0 ; j < n ; j++){
//                if(white.get(i).contains(j)) continue;
//                l.add(j);
//            }
//            black.add(l);
//        }
//        for(int i = 0 ; i < white.size() ; i++){
//            List<Integer> whiteCur = white.get(i);
//            List<Integer> blackCur = black.get(i);
//            int whiteSum = 0;
//            int blackSum = 0;
//            for(int wx : whiteCur){
//                whiteSum += cans[wx][0];
//            }
//            for(int bx : blackCur){
//                blackSum += cans[bx][1];
//            }
//            int gap = Math.abs(whiteSum - blackSum);
//            answer = Math.min(answer, gap);
//        }
//        return answer;
//    }
//
//    public void dfs(List<Integer> cur, int start, int m, int n){
//        if(cur.size() == m){
//            white.add(new ArrayList<>(cur));
//            return;
//        }
//        for(int i = start ; i < n ; i++){
//            cur.add(i);
//            dfs(cur, i + 1, m ,n);
//            cur.remove(cur.size() - 1);
//        }
//    }
    int n;
    int answer;
    boolean[] ch;
    public int solution(int[][] cans){
        n = cans.length;
        ch = new boolean[n];
        answer = Integer.MAX_VALUE;
        dfs(0, 0, cans);
        return answer;
    }

    public void dfs(int L, int s, int[][] cans){
        if(L == n / 2){
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                if(ch[i]) A.add(i);
                else B.add(i);
            }
            int aSum = 0;
            int bSum = 0;
            for(int ax : A) aSum += cans[ax][0];
            for(int bx : B) bSum += cans[bx][1];
            int gap = Math.abs(aSum - bSum);
            answer = Math.min(answer, gap);
        } else {
            for(int i = s ; i < n ; i++){
                ch[i] = true;
                dfs(L + 1, i + 1, cans);
                ch[i] = false;
            }
        }
    }

    public static void main(String[] args){
        바둑대회 T = new 바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}

