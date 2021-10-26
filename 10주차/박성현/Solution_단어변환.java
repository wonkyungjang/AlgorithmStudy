import java.util.*;

class Solution {
    
    public int dnum(String s, String t) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) num++;
        }
        return num;
    }
    
    public boolean[] visited;
    public int answer;
    
    public void dfs(String cs, String target, String[] words, int num) {
        if (cs.equals(target)) {
            if (answer > num) answer = num;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && dnum(cs, words[i]) == 1) {
                visited[i] = true;
                dfs(words[i], target, words, num+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        answer = 100;
        dfs(begin, target, words, 0);
        
        if (answer == 100) return 0;
        return answer;
    }
}
