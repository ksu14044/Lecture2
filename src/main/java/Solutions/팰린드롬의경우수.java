package Solutions;

import java.util.*;
class 팰린드롬의경우수 {
//    Set<String> list;
//    int n;
//    boolean[] visited;
//    public String[] solution(String s){
//        n = s.length();
//        list = new HashSet<>();
//        visited = new boolean[n];
//        dfs(s, new StringBuilder());
//        return list.toArray(new String[0]);
//    }
//    public void dfs(String s, StringBuilder sb){
//        if(sb.length() == n){
//            String cur = sb.toString();
//            if(isPal(cur)) list.add(cur);
//            return;
//        }
//        for(int i = 0 ; i < n ; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                sb.append(s.charAt(i));
//                dfs(s, sb);
//                visited[i] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//    }
//
//    public boolean isPal(String s){
//        for(int i = 0 ; i < s.length() / 2 ; i++){
//            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
//        }
//        return true;
//    }

    public static void main(String[] args){
        팰린드롬의경우수 T = new 팰린드롬의경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
    int n;
    Map<Character, Integer> map;
    ArrayDeque<Character> dq;
    List<String> list;
    public String[] solution(String s){
        n = s.length();
        dq = new ArrayDeque<>();
        map = new HashMap<>();
        list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int cnt = 0;
        for(char x : map.keySet()){
            if(map.get(x) % 2 == 1) {
                dq.add(x);
                map.put(x, map.get(x) - 1);
                cnt++;
            }
            if(cnt > 1) return new String[]{};
        }
        dfs();
        return list.toArray(new String[0]);
    }

    public void dfs(){
        if(dq.size() == n){
            StringBuilder sb = new StringBuilder();
            for(char x : dq){
                sb.append(x);
            }
            list.add(sb.toString());
            return;
        }
        for(char x : map.keySet()){
            if(dq.isEmpty() && map.get(x) % 2 == 1){
                dq.add(x);
                map.put(x, map.get(x) - 1);
            }
        }
        for(char x : map.keySet()){
            if(map.get(x) > 0){
                dq.addFirst(x);
                dq.addLast(x);
                map.put(x, map.get(x) - 2);
                dfs();
                dq.pollFirst();
                dq.pollLast();
                map.put(x, map.get(x) + 2);
            }
        }
    }
}