package Solutions;

import java.util.*;
class 피부과 {
//    public int solution(int[] laser, String[] enter){
//        int answer = 0;
//        int n = enter.length;
//        int[][] enterInt = new int[n][2];
//        for(int i = 0 ; i < n ; i++){
//            String[] es = enter[i].split(" ");
//            enterInt[i][0] = convertTime(es[0]);
//            enterInt[i][1] = laser[Integer.parseInt(es[1])];
//        }
//        int time = 0;
//        for(int i = 0 ; i < n ; i++){
//            int[] cur = enterInt[i];
//            time = Math.max(time, cur[0] + cur[1]);
//            int cnt = 0;
//            for(int j = i + 1 ; j < n ; j++){
//                int[] wait = enterInt[j];
//                if(wait[0] < time) cnt++;
//            }
//            answer = Math.max(cnt, answer);
//        }
//        return answer;
//    }

//    public int solution(int[] laser, String[] enter){
//        int answer = 0;
//        int n = enter.length;
//        int[][] inList = new int[n][2];
//        for(int i = 0 ; i < n ; i++){
//            String[] es = enter[i].split(" ");
//            inList[i][0] = convertTime(es[0]);
//            inList[i][1] = laser[Integer.parseInt(es[1])];
//        }
//        int ft = inList[0][0] + inList[0][1];
//        Queue<Integer> q = new LinkedList<>();
//        for(int i = 0, cnt = 0, t = inList[0][0] ; t <= 1200 ; t++){
//            if(q.isEmpty() && ft < inList[i][0]){
//                t = inList[i][0];
//                ft = inList[i][0] + inList[i][1];
//            }
//            while(i < n && inList[i][0] < ft){
//                q.offer(i);
//                i++;
//            }
//            if(!q.isEmpty()){
//                if( t == inList[q.peek()][0]){
//                    ft = t + inList[q.poll()][1];
//                    cnt++;
//                }
//            }
//            answer = Math.max(answer, q.size());
//
//            if(cnt == n) break;
//        }
//        return answer;
//    }

    public int solution(int[] laser, String[] enter){
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            int a = convertTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        int ft = inList[0][0];
        int pos = 1;
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(inList[0][1]);
        for(int t = ft ; t <= 1200 ; t++){
            // 도착할 시간이 됐는데
            if(pos < n && t == inList[pos][0]){
                // 대기실엔 아무도 없고 도착할 시간이 마지막 시술이 끝난 시점 이후라면
                // 도착할 시간으로 점프
                if(q.isEmpty() && inList[pos][0] > ft) ft = t;
                // 대기실에 레이저 시술 번호 추가
                q.offer(inList[pos][1]);
                pos++;
            }
            // 마지막 시술이 끝나고 && 대기실에 누군가 있다면
            if(ft == t && !q.isEmpty()){
                // 대기실에서 꺼내고
                int idx = q.poll();
                // 시술 시간만큼 끝나는 시간 추가
                ft += laser[idx];
            }
            answer = Math.max(answer, q.size());
        }
        return answer;
    }

    public int convertTime(String time){
        String[] ts = time.split(":");
        return Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);
    }

    public static void main(String[] args){
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}