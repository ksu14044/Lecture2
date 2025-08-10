package Solutions;

class 과일가져가기 {
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < fruit.length ; i++){
            if(!isUnique(fruit[i])) continue;
            if(visited[i]) continue;
            for(int j = i + 1 ; j < n ; j++){
                if(!isUnique(fruit[j])) continue;
                if(visited[j]) continue;
                int a = getMinIdx(fruit[i]);
                int b = getMinIdx(fruit[j]);
                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0){
                    if(fruit[i][a] + 1 < fruit[i][b] - 1 && fruit[j][a] - 1 > fruit[j][b] + 1){
                        fruit[i][a] ++;
                        fruit[i][b] --;
                        fruit[j][a] --;
                        fruit[j][b] ++;
                        visited[i] = true;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        for(int[] a : fruit){
            answer += getMin(a);
        }
        return answer;
    }

    public int getMin(int[] arr){
        int answer = Integer.MAX_VALUE;
        for(int x : arr){
            answer = Math.min(x, answer);
        }
        return answer;
    }

    public boolean isUnique(int[] arr){
        int cnt = 0;
        int min = getMin(arr);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == min) cnt++;
        }
        return cnt == 1;
    }

    public int getMinIdx(int[] arr){
        int min = getMin(arr);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == min) return i;
        }
        return 0;
    }

    public static void main(String[] args){
        과일가져가기 T = new 과일가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}