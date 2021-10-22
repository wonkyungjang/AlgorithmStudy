import java.util.*;

class Solution_pro_단어변환 {
    static int cnt;
    static boolean [] visit;
    
    static class Info {
        String str;
        int count;
        
        public Info(String str, int count) {
            super();
            this.str = str;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visit = new boolean[words.length];
        bfs(begin, target, words);
        
        answer = cnt;
        return answer;
    }
    
    public void bfs(String begin, String target, String[] words) {
        Queue<Info> que = new LinkedList<>();
        que.offer(new Info(begin, 0));
        
        while(!que.isEmpty()) {
            Info cur = que.poll();
            
            if(cur.str.equals(target)) {
                cnt = cur.count;
                return;
            }
            
            for(int i=0; i<words.length; i++) {
                if(check(cur.str, words[i]) && !visit[i]) {
                    que.offer(new Info(words[i], cur.count+1));
                    visit[i] = true;
                }
            }
        }
        
        cnt = 0;
    }
    
    public boolean check(String a, String b) {
        int n = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                n++;
            }
        }
        
        if(n == 1) {
            return true;
        }
        return false;
    }
}
