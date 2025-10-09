import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.append(n%k);
            n = n/k;
        }
        
        String[] numbers = sb.reverse().toString().split("0");
        
        for(String s : numbers){
            if (s == null || s.trim().isEmpty()) continue;
            long number = Long.parseLong(s);
            if(isPrime(number)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static boolean isPrime(long n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n%2 == 0) return false;
        long sqrt = (long) Math.sqrt(n);
        for(long i = 3 ;i<=sqrt ;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}