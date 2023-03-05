package com.krishnamurti.codestudio;

import java.util.LinkedList;
import java.util.Queue;

public class Contest1 {

    static int isPossible(int w, int h, long n) {
        // Write your code here.
        int pieces = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] { w, h });

        while(!queue.isEmpty()) {
            Integer[] piece = queue.poll();
            int width = piece[0];
            int height = piece[1];
            if ( width > 1 && width % 2 == 0) {
                int c = (int)Math.floor(width/2);
                Integer[] q = new Integer[] { c, height };

                queue.add(q);
                queue.add(q);
                pieces++;
            } else if ( height > 1 && height % 2 == 0) {
                int c = (int)Math.floor(height/2);
                Integer[] q = new Integer[] { width, c };
                queue.add(q);
                queue.add(q);
                pieces++;
            }

            if(pieces == n) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(5, 10, 2));
//        System.out.println(isPossible(4, 1, 2));
    }

}
