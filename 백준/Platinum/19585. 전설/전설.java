import java.io.*;
import java.util.*;

public class Main {
    static int minNickLen = Integer.MAX_VALUE;
    static int maxNickLen = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for(int i = 0; i < C; i++){
            trie.insert(br.readLine());
        }

        Set<String> nicknames = new HashSet<>();
        for(int i = 0; i < N; i++){
            String nick = br.readLine();
            nicknames.add(nick);

            minNickLen = Math.min(minNickLen, nick.length());
            maxNickLen = Math.max(maxNickLen, nick.length());
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++){
            String word = br.readLine();
            if(solve(word, trie, nicknames)){
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }
    
    public static boolean solve(String word, Trie trie, Set<String> nicknames) {
        Node node = trie.root;
        int len = word.length();

        for(int i = 0; i < len; i++){
            int idx = word.charAt(i) - 'a';
            
            if(node.next[idx] == null) return false;

            node = node.next[idx];
            
            if(node.endOfWord){
                int restLen = len - (i + 1);
                
                if(restLen >= minNickLen && restLen <= maxNickLen) {
                    if(nicknames.contains(word.substring(i + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class Node {
        Node[] next = new Node[26];
        boolean endOfWord;
    }

    public static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                int idx = word.charAt(i) - 'a';
                if(node.next[idx] == null){
                    node.next[idx] = new Node();
                }
                node = node.next[idx];
            }
            node.endOfWord = true;
        }
    }
}