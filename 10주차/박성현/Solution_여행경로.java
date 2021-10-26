import java.util.*;

class Solution {
    
    public Ticket[] ts;
    public String[] answer;
    public boolean[] visited;
    
    public class Ticket implements Comparable<Ticket> {
        String s;
        String d;
        
        public Ticket(String s, String d) {
            this.s = s;
            this.d = d;
        }
        
        @Override
        public int compareTo(Ticket t) {
            return d.compareTo(t.d);
        }
    }
    
    public boolean dfs(String cs, int cnt) {
        answer[cnt] = cs;
        if (cnt == ts.length) {
            return true;
        }
        for (int i = 0; i < ts.length; i++) {
            if (!visited[i] && ts[i].s.equals(cs)) {
                visited[i] = true;
                if (dfs(ts[i].d, cnt+1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
    
    public String[] solution(String[][] tickets) {
        ts = new Ticket[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            ts[i] = new Ticket(tickets[i][0], tickets[i][1]);
        }
        Arrays.sort(ts);
        visited = new boolean[ts.length];
        answer = new String[ts.length+1];
        dfs("ICN", 0);
        
        return answer;
    }
}
