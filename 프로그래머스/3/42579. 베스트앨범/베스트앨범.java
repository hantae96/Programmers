import java.util.*;

class Node{
    int value;
    int idx;
    
    public Node(int value, int idx){
        this.value = value;
        this.idx = idx;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,List<Node>> detail = new HashMap<>();
        
        for(int i = 0; i<genres.length;i++){
            
            String s = genres[i];
            int p = plays[i];
            
            int value = map.getOrDefault(s,0) + p;
            map.put(s,value);
            List<Node> list = detail.getOrDefault(s, new ArrayList<>());
            list.add(new Node(p,i));
            detail.put(s,list);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((o1,o2) -> map.get(o2) - map.get(o1));
        
      
        
        for(String key : keySet){
            List<Node> values = detail.get(key);
            values.sort((o1,o2) -> o2.value - o1.value);
            
            int idx = 0;
            
            while(idx < values.size() && idx < 2){
                answer.add(values.get(idx).idx);
                idx++;
            }
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}