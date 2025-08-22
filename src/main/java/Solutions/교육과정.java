package Solutions;

import java.util.*;
class 교육과정 {
//    public String[] solution(String[] subjects, String[] course){
//        String[] answer = {};
//        Map<String, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < subjects.length ; i++){
//            map.put(subjects[i], 0);
//        }
//        Map<String, List<String>> graph = new HashMap<>();
//        for(int i = 0 ; i < course.length ; i++){
//            String[] sp = course[i].split(" ");
//            graph.putIfAbsent(sp[0], new ArrayList<>());
//            graph.get(sp[0]).add(sp[1]);
//        }
//        Queue<String> q = new LinkedList<>();
//        for(String c : course){
//            String[] cs = c.split(" ");
//            String need = cs[1];
//            q.offer(need);
//            while(!q.isEmpty()){
//                String cur = q.poll();
//                map.put(cur, map.get(cur) - 1);
//                for(String next : graph.getOrDefault(cur, new ArrayList<>())){
//                    q.offer(next);
//                }
//            }
//        }
//        Arrays.sort(subjects, (a, b) -> map.get(a) - map.get(b));
//        return subjects;
//    }
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        int[] indegree = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(subjects[i], i);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < course.length ; i++){
            String[] cs = course[i].split(" ");
            String sub = cs[0], need = cs[1];
            indegree[map.get(sub)]++;
            graph.putIfAbsent(map.get(need), new ArrayList<>());
            graph.get(map.get(need)).add(map.get(sub));
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<String> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            answer.add(subjects[cur]);
            List<Integer> list = graph.getOrDefault(cur, new ArrayList<>());
            for(int x : list){
                indegree[x]--;
                if(indegree[x] == 0) {
                    q.offer(x);
                }
            }
        }
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args){
        교육과정 T = new 교육과정();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
