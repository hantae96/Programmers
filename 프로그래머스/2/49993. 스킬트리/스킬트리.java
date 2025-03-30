import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        for(char c : skill.toCharArray()){
            queue.offer(c);
        }
        
        
        for(String tree : skill_trees){
            Queue<Character> copy = new LinkedList<>(queue);
            boolean flag = true;
            for(char c : tree.toCharArray()){
                if(skill.contains(c + "")){
                    if(c != copy.peek()){
                        flag = false;
                        break;
                    }
                    copy.poll();
                }
            }
            if(flag){
                System.out.println(tree);
                answer++;
            }
        }
        return answer;
    }
}