package Solutions;

import java.util.*;
class 전투게임 {
    public static class Student {
        String team;
        int num, power;
        public Student(String team, int num, int power){
            this.team = team;
            this.num = num;
            this.power = power;
        }
    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        List<Student> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String[] ts = students[i].split(" ");
            String team = ts[0];
            int power = Integer.parseInt(ts[1]);
            list.add(new Student(team, i, power));
        }
        list.sort((a, b) -> a.power - b.power);
        int j = 0, total = 0;
        for(int i = 0 ; i < n ; i++){
            while(j < i && list.get(j).power < list.get(i).power){
                map.put(list.get(j).team, map.getOrDefault(list.get(j).team, 0) + list.get(j).power);
                total += list.get(j).power;
                j++;
            }
            answer[list.get(i).num] = total - map.getOrDefault(list.get(i).team, 0);
        }
        return answer;
    }

    public static void main(String[] args){
        전투게임 T = new 전투게임();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
