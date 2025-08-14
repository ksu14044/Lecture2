package Solutions;

import java.util.*;
class 멀티태스킹 {
    public int solution(int[] tasks, long k) {
        int n = tasks.length;
        List<Integer> l = new ArrayList<>();
        l.add(0);
        for(int t : tasks) l.add(t);
        Collections.sort(l);
        int rest = n;
        for(int i = 1 ; i < l.size() ; i++){
            long need = (long)(l.get(i) - l.get(i - 1)) * rest;
            if(k < need){
                long idx = k % rest;
                int cnt = 0;
                for(int j = 0 ; j < tasks.length ; j++){
                    if(tasks[j] >= l.get(i)){
                        if(cnt == idx) return j + 1;
                        cnt++;
                    }
                }
            } else {
                k -= need;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        멀티태스킹 T = new 멀티태스킹();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

