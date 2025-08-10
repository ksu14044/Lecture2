package Solutions;

import java.util.*;
class 같은빈도수만들기 {
    public int[] solution(String s){
        int[] answer = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < 5 ; i++){
            map.put((char)('a' + i), 0);
        }
        for(char x : s.toCharArray()){
            map.put(x, map.get(x) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int x : map.values()){
            max = Math.max(max, x);
        }
        for(int i = 0 ; i < 5 ; i++){
            answer[i] = max - map.get((char)('a' + i));
        }
        return answer;
    }

    public static void main(String[] args){
        같은빈도수만들기 T = new 같은빈도수만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}

