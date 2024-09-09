import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Queue<String[]> queue = new LinkedList<String[]>();
        HashMap<String,String> map = new HashMap<String,String>();
        
        for(String elem : record){
            String[] split = elem.split(" ");
            if(elem.charAt(0) == 'E'|| elem.charAt(0) == 'C'){
                map.put(split[1],split[2]);
            }
            queue.add(new String[]{split[0],split[1]});
        }
        
        
        while(!queue.isEmpty()){
            String [] elem = queue.remove();
            if(elem[0].equals("Enter")){
                answer.add(map.get(elem[1]) + "님이 들어왔습니다.");
            }else if(elem[0].equals("Leave")){
                answer.add(map.get(elem[1]) + "님이 나갔습니다.");
            }
        }

        
        return answer.toArray(new String[0]);    
    }
}