import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int n = 0 ; n<N ; n++) {
            trie.insert(br.readLine());
        }

        Node node = trie.root;
        dfs(node,0);
        System.out.println(sb);
    } // end of main

    public static void dfs(Node node, int depth) {
        String[] keys = node.childNodes.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        for (String k : keys) {
            sb.append("--".repeat(depth))
                    .append(k)
                    .append("\n");
            dfs(node.childNodes.get(k), depth + 1);
        }
    }


    public static class Node{
        Map<String, Node> childNodes = new HashMap<>();
    }

    public static class Trie{
        private Node root;
        Trie(){
            root = new Node();
        }

        public void insert(String words){
            Node node = this.root;
            StringTokenizer st = new StringTokenizer(words);
            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++){
                String w = st.nextToken();
                node.childNodes.putIfAbsent(w, new Node());
                node = node.childNodes.get(w);
            }
        }

    }
}

