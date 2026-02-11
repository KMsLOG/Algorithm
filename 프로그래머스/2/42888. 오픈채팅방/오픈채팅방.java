import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String,String> names = new HashMap<>();
        List<String> logs = new ArrayList<>();
        
        for(String r : record){
            String[] rr = r.split(" ");
            String type = rr[0];
            String uuid = rr[1];

            if(type.equals("Enter")){
                String name = rr[2];
                names.put(uuid, name);
                logs.add(uuid + "/님이 들어왔습니다.");
            } else if(type.equals("Leave")){
                logs.add(uuid + "/님이 나갔습니다.");
            } else if(type.equals("Change")){
                String name = rr[2];
                names.put(uuid, name);
            }
        }
        
        for(String l : logs){
            String[] arr = l.split("/");
            answer.add(names.get(arr[0])+arr[1]);
        }
        
        
        return answer;
    }
}