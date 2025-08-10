package Solutions;

import java.util.*;
class 회장선거 {
    public String solution(String[] votes, int k){
        String answer = " ";
        Map<String, List<String>> vote = new HashMap<>();
        for(String v : votes){
            String[] cur = v.split(" ");
            List<String> list = vote.getOrDefault(cur[1], new ArrayList<>());
            list.add(cur[0]);
            vote.put(cur[1], list);
        }
        Map<String, Integer> gift = new HashMap<>();
        for(String v : vote.keySet()){
            List<String> l = vote.get(v);
            if(l.size() >= k){
                for(String p : l){
                    gift.put(p, gift.getOrDefault(p, 0) + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(String g : gift.keySet()){
            max = Math.max(max, gift.get(g));
        }
        List<String> p = new ArrayList<>();
        for(String g : gift.keySet()){
            if(gift.get(g) == max){
                p.add(g);
            }
        }

        Collections.sort(p);

        return p.get(0);
    }

    public static void main(String[] args){
        회장선거 T = new 회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
