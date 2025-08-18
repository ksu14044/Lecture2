package Solutions;

import java.util.*;

class IP주소 {
//    int n;
//    List<List<String>> list;
//
//    public String[] solution(String s){
//
//        n = s.length();
//        list = new ArrayList<>();
//        dfs(new ArrayList<>(), s);
//        String[] answer = new String[list.size()];
//        for(int i = 0 ; i < list.size() ; i++){
//            List<String> cur = list.get(i);
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0 ; j < cur.size() ; j++){
//                if(j < cur.size() - 1){
//                    sb.append(cur.get(j));
//                    sb.append(".");
//                } else sb.append(cur.get(j));
//            }
//            answer[i] = sb.toString();
//        }
//        return answer;
//    }
//
//    public int sum(List<Integer> l){
//        int sum = 0;
//        for(int x : l){
//            sum += x;
//        }
//        return sum;
//    }
//    public boolean isValid(String s){
//        int len = s.length();
//        if(len > 1 && s.startsWith("0")) return false;
//        int sInt = Integer.parseInt(s);
//        if(sInt < 0 || sInt > 255) return false;
//        return true;
//    }
//
//    public void dfs(List<Integer> cur, String s){
//        if(cur.size() == 4){
//            if(sum(cur) == n){
//                int start = 0;
//                List<String> sList = new ArrayList<>();
//                for(int i = 0 ; i < 4 ; i++){
//                    String st = s.substring(start, start + cur.get(i));
//                    if(!isValid(st)) return;
//                    start += cur.get(i);
//                    sList.add(st);
//                }
//                list.add(new ArrayList<>(sList));
//            }
//            return;
//        }
//        for(int i = 1 ; i <= 3 ; i++){
//            cur.add(i);
//            dfs(cur, s);
//            cur.remove(cur.size() - 1);
//        }
//    }
    List<String> tmp;
    List<String> res;
    public String[] solution(String s){
        tmp = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, s);
        String[] answer = new String[res.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public void dfs(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String ts = "";
            for(String t : tmp){
                ts += t + ".";
            }
            res.add(ts.substring(0, ts.length() - 1));
            return;
        }
        for(int i = start ; i < s.length() ; i++){
            if(s.charAt(start) == '0' && i > start) return;
            String num = s.substring(start, i + 1);
            if(Integer.parseInt(num) > 255) return;
            tmp.add(num);
            dfs(i + 1, s);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
        IP주소 T = new IP주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
