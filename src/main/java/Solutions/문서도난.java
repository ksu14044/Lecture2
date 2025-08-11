package Solutions;

import java.util.*;
class 문서도난 {
    public String[] solution(String[] reports, String times){

        Map<String, Integer> map = new HashMap<>();
        for(String r : reports){
            String[] rs = r.split(" ");
            String name = rs[0];
            int time = convertTime(rs[1]);
            map.put(name, time);
        }
        String[] ts = times.split(" ");
        int from = convertTime(ts[0]);
        int to = convertTime(ts[1]);
        List<String> answer = new ArrayList<>();
        for(String name : map.keySet()){
            if(map.get(name) >= from && map.get(name) <= to){
                answer.add(name);
            }
        }
        answer.sort((a, b) -> map.get(a).compareTo(map.get(b)));
        return answer.toArray(new String[0]);
    }

    public int convertTime(String time){
        String[] ts = time.split(":");
        int hour = Integer.parseInt(ts[0]);
        int min = Integer.parseInt(ts[1]);
        return hour * 60 + min;
    }

    public static void main(String[] args){
        문서도난 T = new 문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
