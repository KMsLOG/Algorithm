import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T ; t++) {
            int N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean flag = true;
            for (int n = 0; n < N; n++) {
                String tel = br.readLine();
                if(flag && !trie.insert(tel)){
                    flag = false;
                }
            }
            
            if(flag){
                sb.append("YES\n");
            } else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    } // end of main

    public static class Node{
        private Map<Character, Node> childNodes = new HashMap<>();
        private boolean isLast;
    }

    public static class Trie{
        private Node root;
        Trie(){
            root = new Node();
        }

        public boolean insert(String word){
            Node node = this.root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);

                if(node.isLast) return false;

                node.childNodes.putIfAbsent(c, new Node());
                node = node.childNodes.get(c);
            }
            
            if(!node.childNodes.isEmpty()) return false;

            node.isLast = true;
            return true;
        }


    }
}

