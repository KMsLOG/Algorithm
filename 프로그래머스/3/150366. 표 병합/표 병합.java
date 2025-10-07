import java.util.*;

class Node {
    String value;
    List<Node> group;
    
    Node(){
        this.value = "EMPTY";
        this.group = new ArrayList<>();
        this.group.add(this);
    }
    
    void merge(Node o){
        if(this.group == o.group) return;
        
        String new_val = "EMPTY";
        for(Node n : this.group){
            if(!n.value.equals("EMPTY")){
                new_val = n.value;
                break;
            }
        }
        
        if(new_val.equals("EMPTY")){
            for(Node n : o.group){
                if(!n.value.equals("EMPTY")){
                    new_val = n.value;
                    break;
                }
            }
        }
        
        for(Node n : o.group){
            n.group = this.group;
            this.group.add(n);
        }
        
        for(Node n : this.group){
            n.value = new_val;
        }
    } // end of merge
    
    void unmerge() {
        String tmp = this.value;
        List<Node> oldGroup = new ArrayList<>(this.group);
        for (Node n : oldGroup) {
            n.group = new ArrayList<>();
            n.group.add(n);
            n.value = "EMPTY";
        }
        this.value = tmp;
    }// end of unmerge
} // end of Node

class Solution {
    static Node[][] table = new Node[51][51];
    public List<String> solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for(int i = 1 ;i<=50;i++){
            for(int j = 1 ; j<=50 ;j++){
                table[i][j] = new Node();
            }
        }
        
        for(String cmd : commands){
            String[] s = cmd.split(" ");
            switch(s[0]){
                case "UPDATE":
                    if(s.length == 4){
                        int r = Integer.parseInt(s[1]);
                        int c = Integer.parseInt(s[2]);
                        String v = s[3];
                        for(Node n : table[r][c].group){
                            n.value = v;
                        }
                    } else {
                        String v1 = s[1];
                        String v2 = s[2];
                        for (int i = 1; i <= 50; i++) {
                            for (int j = 1; j <= 50; j++) {
                                if (table[i][j].value.equals(v1)){
                                    table[i][j].value = v2;
                                }
                            }
                        }
                    }
                    break;
                
                case "MERGE":
                    int r1 = Integer.parseInt(s[1]);
                    int c1 = Integer.parseInt(s[2]);
                    int r2 = Integer.parseInt(s[3]);
                    int c2 = Integer.parseInt(s[4]);
                    table[r1][c1].merge(table[r2][c2]);
                    break;
                
                case "UNMERGE":
                    int r = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    table[r][c].unmerge();
                    break;
                case "PRINT":
                    r = Integer.parseInt(s[1]);
                    c = Integer.parseInt(s[2]);
                    answer.add(table[r][c].value);
                    break;
            }
        }
        
        return answer;
    }
}