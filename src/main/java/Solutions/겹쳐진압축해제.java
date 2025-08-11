package Solutions;

import java.util.*;
class 겹쳐진압축해제 {
    public String solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        for(char x : s.toCharArray()){
            // 1. 닫힌 괄호가 나오면
            if(x == ')'){
                String tmp = "";
                // 2. 열린 괄호가 나올 때까지
                while(!stack.isEmpty()){
                    // 3. 하나씩 뽑아서
                    String c = stack.pop();
                    // 5. 열린괄호가 나오면
                    if(c.equals("(")){
                        // 6. 몇 번인지 세야하니까
                        String num = "";
                        // 7. 두 자리수도 있으니까 스택이 비어있지 않고 숫자라면
                        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                            // 8. 먼저나온게 1의 자리 다음에 나오는게 10의 자리니까 앞으로 붙이기
                            num = stack.pop() + num;
                        }
                        // String num -> int cnt 로
                        int cnt = 0;
                        // num 이 비어있으면 1번이니까
                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);
                        String res = "";
                        // 9. 열린괄호가 나올때까지 저장해뒀던 tmp 반복
                        for(int i = 0 ; i < cnt ; i++) res += tmp;
                        // 10. 반복한 뒤 다시 스택에 넣어야됨
                        stack.push(res);
                        // 11. 2에서 열린 괄호가 나올때까지라고 했는데 while 조건문을 스택이 비어있지 않다면으로 줬으니
                        // 열린 괄호가 나오면 break 로 탈출
                        break;
                    }
                    // 4. 열린 괄호가 아니라면 앞에다가 붙이기
                    tmp = c + tmp;
                }
            } else stack.push(String.valueOf(x));
        }
        // ps. stack을 pop() 하지 않고 그냥 사용할 수 있다.
        for(String x : stack){
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args){
        겹쳐진압축해제 T = new 겹쳐진압축해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
