import java.util.*;

class Solution {
    
    static LinkedList<String> list = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        // adjList (알파벳 순서로 정렬하기 위해 TreeMap 사용)
        HashMap<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (map.containsKey(start)) {
            	map.get(start).put(end, map.get(start).getOrDefault(end, 0) + 1);
            } else {
                TreeMap<String, Integer> treeMap = new TreeMap<>();
                treeMap.put(end, 1);
                map.put(start, treeMap);
            }
        }
        
        list.add("ICN");
        dfs(0, "ICN", map, tickets.length);
        
        return list.toArray(new String[tickets.length + 1]);
    }
    
    public boolean dfs(int cnt, String cur, HashMap<String, TreeMap<String, Integer>> map, int size) {
        if (cnt == size) {
            return true;
        }
        
        TreeMap<String, Integer> adjMap = map.get(cur);
        if (adjMap == null) return false;
        for (String key : adjMap.keySet()) {
            if (adjMap.get(key) == 0) continue;
            adjMap.put(key, adjMap.get(key) - 1);
            list.addLast(key);
            if (dfs(cnt + 1, key, map, size)) return true;
            list.removeLast();
            adjMap.put(key, adjMap.get(key) + 1);
        }
        
        return false;
    }
}
