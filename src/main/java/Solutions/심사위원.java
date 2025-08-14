package Solutions;

import java.util.*;
class 심사위원 {
    public int solution(int[] score, int k){
        int answer = 0;
        Arrays.sort(score);
        for(int i = 0 ; i + k <= score.length ; i++){
            int gap = score[i + k - 1] - score[i];
            if(gap <= 10){
                int sum  = 0;
                for(int j = i ; j < i + k ; j++){
                    sum += score[j];
                }
                return sum / k;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        심사위원 T = new 심사위원();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
