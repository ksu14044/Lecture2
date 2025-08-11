package Solutions;

import java.util.*;
class 경고메일 {
    public String[] solution(String[] reports, int time){
        String[] answer = {};
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        for(String r : reports){
            String[] rs = r.split(" ");
            String name = rs[0];
            int t = getTime(rs[1]);
            String mod = rs[2];
            if(mod.equals("in")){
                inTime.put(name, t);
            } else {
                totalTime.put(name, totalTime.getOrDefault(name, 0) + t - inTime.get(name));
            }
        }
        List<String> res = new ArrayList<>();
        for(String name : totalTime.keySet()){
            if(totalTime.get(name) > time){
                res.add(name);
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + min;
    }

    public static void main(String[] args){
        경고메일 T = new 경고메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
