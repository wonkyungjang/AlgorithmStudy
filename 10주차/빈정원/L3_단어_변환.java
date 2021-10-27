import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        dfs(0, begin, new boolean[words.length], target, words);
        return answer;
    }
    
    public void dfs(int cnt, String str, boolean[] v, String target, String[] words) {
        if (str.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (v[i] || !check(str, words[i])) continue;
            v[i] = true;
            dfs(cnt + 1, words[i], v, target, words);
            v[i] = false;
        }
    }
    
    public boolean check(String begin, String word) {
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        // 한 글자만 다르면 true, 아니면 false
        return diff == 1 ? true : false;
    }
}
