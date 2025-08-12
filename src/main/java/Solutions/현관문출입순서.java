package Solutions;

import java.util.*;
class 현관문출입순서 {
    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];
        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();
        int prev = 1;
        int n = arrival.length;
        for(int i = 0, cnt = 0, t = 0; ; t++){
            // 줄을 서 있는 사람이 아무도 없고
            if(in.isEmpty() && out.isEmpty() && i < n){
                // 현재 시간이 제일 빨리 오는 사람보다 작다면
                if(t < arrival[i]){
                    // 현재 시간을 제일 빨리 오는 사람의 시간으로 점프
                    t = arrival[i];
                    // 그 동안 안썼으니까 나가는 사람이 우선
                    prev = 1;
                }
            }
            // 현재 시간까지 와야하는 모든 사람들을
            while(i < n && arrival[i] <= t){
                if(state[i] == 1){
                    out.offer(i);
                } else in.offer(i);
                // 인덱스 번호를 증가시키면서 부르기
                i++;
            }
            // 1초 전에 나가는 사람이 이용했다면
            if(prev == 1){
                // 나가는 대기줄에서 poll() 시키면서 answer에 현재 시간 대입
                if(!out.isEmpty()){
                    answer[out.poll()] = t;
                } else {
                    // 나가는 대기줄이 비어있다면 들어오는 대기줄에서 실행하고 1초전의 상황을 들어오는 대기줄로 바꿈
                    answer[in.poll()] = t;
                    prev = 0;
                }
            } else if(prev == 0){
                if(!in.isEmpty()){
                    answer[in.poll()] = t;
                } else {
                    answer[out.poll()] = t;
                    prev = 1;
                }
            }

            // n번만큼 반복
            cnt++;
            if(cnt == n) break;
        }



        return answer;
    }

    public static void main(String[] args){
        현관문출입순서 T = new 현관문출입순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}