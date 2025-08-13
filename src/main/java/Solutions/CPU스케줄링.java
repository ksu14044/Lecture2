package Solutions;

//CPU 스케쥴링
import java.util.*;
class CPU스케줄링 {
    public static class Work{
        int st, rt, num;
        public Work(int st, int rt, int num){
            this.st = st;
            this.rt = rt;
            this.num = num;
        }
    }
//    public int[] solution(int[][] tasks){
//        int n = tasks.length;
//        int[] answer = new int[n];
//        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator<Work>() {
//            @Override
//            public int compare(Work o1, Work o2) {
//                if(o1.rt != o2.rt) return o1.rt - o2.rt;
//                return o1.num - o2.num;
//            }
//        });
//        List<Work> list = new ArrayList<>();
//        for(int i = 0 ; i < n ; i++){
//            list.add(new Work(tasks[i][0], tasks[i][1], i));
//        }
//        list.sort((a, b) -> a.st - b.st);
//        int idx = 0;
//        for(Work w : list) System.out.print(w.num + " ");
//        System.out.println();
//        for(int i = 0 , cnt = 0, t = 0 ; ; ){
//            if(i < n && pq.isEmpty() && t < list.get(i).st){
//                t = list.get(i).st;
//            }
//            while(i < n && list.get(i).st <= t){
//                pq.offer(list.get(i));
//                i++;
//            }
////            System.out.println("-------------------------");
////            for(Work w : pq){
////                System.out.println(w.st + " " + w.rt + " " + w.num);
////            }
////            System.out.println("-------------------------");
//            if(!pq.isEmpty()){
//                Work cur = pq.poll();
//                t += cur.rt;
//                cnt++;
//                answer[idx++] = cur.num;
//            }
//            if(cnt == n) break;
//        }
//        return answer;
//    }

    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0 ; i < n ; i++){
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        int ft = 0, idx = 0;
        // 문제) pq가 비어있을 때도 실행될 수 있는데
        // 1. pq가 비어있다고 가정
        // 2. programs가 비었다고 가정
        while(!programs.isEmpty() || !pq.isEmpty()){
            // 1-1. 여기서 ft는 반드시 다음 작업의 시작시간보다 커짐
            if(pq.isEmpty()) ft = Math.max(ft, programs.peek()[0]);
            // 1-2. pq가 비었음에도 반복문이 실행된건 programs가 비어있지 않다는 뜻
            while(!programs.isEmpty() && programs.peek()[0] <= ft){
                int[] x = programs.pollFirst();
                // 1-3. pq에 반드시 요소 추가 -> pq는 비어있을 수 없다.
                pq.offer(new int[]{x[1], x[2]});
            }
            // 문제) 여기서 nullPointerException 안뜨는 이유
            // 2-1. 반복문이 실행된건 pq가 비어있지 않기 때문
            int[] ex = pq.poll();
            ft += ex[0];
            answer[idx++] = ex[1];
        }

        return answer;
    }

    public static void main(String[] args){
        CPU스케줄링 T = new CPU스케줄링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
