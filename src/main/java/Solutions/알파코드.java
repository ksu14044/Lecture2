package Solutions;

class 알파코드 {
//    int answer;
//    public int solution(String s){
//        answer = 0;
//        dfs(0, s);
//        return answer;
//    }
//
//    public void dfs(int start, String s){
//        if(start == s.length()){
//            answer++;
//            return;
//        }
//        for(int i = start ; i < s.length() ; i++){
//            String num = s.substring(start, i + 1);
//            if(Integer.parseInt(num) < 1 || Integer.parseInt(num) > 26) return;
//            dfs(i + 1, s);
//        }
//    }
    int[] dy;

    public int solution(String s){
        dy = new int[101];
        int answer = dfs(0, s);
        return answer;
    }

    public int dfs(int start, String s){
        if(dy[start] > 0) return dy[start];
        if(start < s.length() && s.charAt(start) == '0') return 0;
        if(start == s.length() - 1 || start == s.length()) return 1;
        int res = dfs(start + 1, s);
        int num = Integer.parseInt(s.substring(start, start + 2));
        if(num <= 26) res += dfs(start + 2, s);
        return dy[start] = res;
    }

    public static void main(String[] args){
        알파코드 T = new 알파코드();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}