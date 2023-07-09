package com.krishnamurti.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class start83 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(reader.readLine());
            for (int i = 0 ; i < tc; i++) {
                int length = Integer.parseInt(reader.readLine());
                String s = reader.readLine();
                char[] sArr = s.toCharArray();
                StringBuilder ans =  new StringBuilder("");
                int count = 1;
                char previous = sArr[0];
                for (int j = 1; j < length; j++) {
                    if (previous == sArr[j]) {
                        count++;
                    } else {
                        if (count % 2 != 0) {
                            ans.append(previous);
                        } else {
                            ans.append(previous).append(previous);
                        }
                        previous = sArr[j];
                        count = 1;
                    }
                }
                if (count % 2 != 0) {
                    ans.append(previous);
                } else {
                    ans.append(previous).append(previous);
                }
                System.out.println(ans);
            }
        } finally {
            reader.close();
        }
    }
}
