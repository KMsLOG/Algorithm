import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {

        StringBuilder sb = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (char ch : sb.toString().toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || 
                (ch >= '0' && ch <= '9') || 
                ch == '-' || ch == '_' || ch == '.') {
                sb2.append(ch);
            }
        }

        StringBuilder sb3 = new StringBuilder();
        boolean dotFlag = false;
        for (char ch : sb2.toString().toCharArray()) {
            if (ch == '.') {
                if (!dotFlag) {
                    sb3.append(ch);
                    dotFlag = true;
                }
            } else {
                sb3.append(ch);
                dotFlag = false;
            }
        }

        String result = sb3.toString();
        if (!result.isEmpty() && result.charAt(0) == '.') {
            result = result.substring(1);
        }
        if (!result.isEmpty() && result.charAt(result.length() - 1) == '.') {
            result = result.substring(0, result.length() - 1);
        }

        if (result.isEmpty()) {
            result = "a";
        }

        if (result.length() >= 16) {
            result = result.substring(0, 15);
            if (result.charAt(result.length() - 1) == '.') {
                result = result.substring(0, result.length() - 1);
            }
        }

        while (result.length() < 3) {
            result += result.charAt(result.length() - 1);
        }

        return result;
    }
}
