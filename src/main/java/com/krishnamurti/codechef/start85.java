package com.krishnamurti.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class start85 {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(reader.readLine());
            for (int i = 0 ; i < tc; i++) {
                int N = Integer.parseInt(reader.readLine());
                String[] in = reader.readLine().split(" ");
                int count = 0;
                int runs = 0;
                int balls = 0;
                while (balls < N) {
                    int run =  Integer.parseInt(in[balls]);
                    runs = runs + run;
                    balls++;
                    if( runs == balls )
                        count++;
                }
                System.out.println(count);
            }
        } finally {
            reader.close();
        }
    }
}
