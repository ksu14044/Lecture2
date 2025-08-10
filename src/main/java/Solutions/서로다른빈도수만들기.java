package Solutions;

import java.util.*;
class 서로다른빈도수만들기 {
    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
//        for(int x : map.values()){
//            if(!set.contains(x)){
//                set.add(x);
//            } else {
//                while(set.contains(x) && x > 0){
//                    x--;
//                    answer++;
//                }
//                set.add(x);
//            }
//        }
        for(char x : map.keySet()){
            while(set.contains(map.get(x))){
                answer++;
                map.put(x, map.get(x) - 1);
            }
            if(map.get(x) == 0) continue;
            set.add(map.get(x));
        }
        return answer;
    }

    public static void main(String[] args){
        서로다른빈도수만들기 T = new 서로다른빈도수만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
