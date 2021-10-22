import java.util.*;

class Solution_pro_여행경로 {
    static boolean [] visit;
    static ArrayList<String> list;
    
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visit = new boolean[tickets.length];
        
        dfs(0, tickets, "ICN", "ICN");
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(int cnt, String[][] tickets, String start, String result) {
        if(cnt == tickets.length) {
            list.add(result);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(cnt+1, tickets, tickets[i][1], result+" "+tickets[i][1]);
                visit[i] = false;
            } 
        }
    }
}
