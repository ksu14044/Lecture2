package Solutions;

import java.util.*;
class 가장많이사용된회의실 {
//    public int solution(int n, int[][] meetings){
//        int answer = 0;
//        int m = meetings.length;
//        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
//        List<List<Integer>> graph = new ArrayList<>();
//        for(int i = 0 ; i < n; i++){
//            graph.add(new ArrayList<>());
//        }
//        for(int i = 0 ; i < n ; i++){
//            graph.get(i).add(0);
//        }
//        Queue<Integer> q = new LinkedList<>();
//        int ft = 0;
//        for(int t = 0, cnt = 0, i = 0 ; ;t++){
//            if(q.isEmpty() && i < m && meetings[i][0] > t){
//                t = meetings[i][0];
//            }
//            while(i < m && meetings[i][0] <= t){
//                q.offer(i);
//                i++;
//            }
//            if(!q.isEmpty()){
//                for(int j = 0 ; j < graph.size() ; j++){
//                    if(graph.get(j).get(graph.get(j).size()-1) <= t){
//                        int idx = q.poll();
//                        graph.get(j).add(t + meetings[idx][1] - meetings[idx][0]);
//                        cnt++;
//                        break;
//                    } else continue;
//                }
//            }
//            if(cnt == m) break;
//        }
//        int max = 0;
//        for(List<Integer> l : graph){
//            max = Math.max(l.size(), max);
//        }
//        for(int i = 0 ; i < graph.size() ; i++){
//            if(graph.get(i).size() == max) {
//                answer = i;
//                break;
//            }
//        }
//        return answer;
//    }
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i = 0 ; i < n ; i++) rooms.add(i);
        for(int[] m : meetings){
            int start = m[0], end = m[1];
            // ends가 비어있지 않고 ends의 첫 회의가 끝날 시간이 지났다면
            // 회의실을 다시 rooms로 추가해서 사용할 수 있게 만들기
            while(!ends.isEmpty() && ends.peek()[0] <= start) rooms.add(ends.poll()[1]);
            // 빈 회의실이 존재한다면
            if(!rooms.isEmpty()){
                // 첫번째 회의실 빼서
                int room = rooms.pollFirst();
                // 사용했다고 기록하고
                res[room]++;
                // 사용중인 회의에 끝나는 시간과 회의실 번호 추가
                ends.add(new int[]{end, room});
                // 빈 회의실이 없다면
            } else {
                // 회의중인 회의 꺼내서 강제 종료
                int[] e = ends.poll();
                // 그 회의실 그대로 사용
                res[e[1]]++;
                // 전 회의가 끝난 시간 + 우리 회의 시간과 회의실 번호 추가
                ends.add(new int[]{e[0] + end - start, e[1]});
            }
        }
        int maxi = 0;
        for(int i = 0 ; i < n ; i++){
            if(res[i] > maxi){
                maxi = res[i];
                answer = i;
            }
        }
        return answer;
    }


    public static void main(String[] args){
        가장많이사용된회의실 T = new 가장많이사용된회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}