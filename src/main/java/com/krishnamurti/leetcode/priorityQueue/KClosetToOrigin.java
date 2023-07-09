package com.krishnamurti.leetcode.priorityQueue;

import com.krishnamurti.Util;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetToOrigin {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            if (i < k) {
                int dist = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
                pq.offer(new int[] { dist, i });
            } else {
                int[] a = pq.peek();
                int dist = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
                if (dist < a[0]) {
                    pq.poll();
                    pq.offer(new int[] { dist, i });
                }

            }
        }
        int[][] ans = new int[k][2];
        for (int i = k - 1 ; i >= 0; i--) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }



    public static void main(String[] args) {
//        int[][] tc1 = new int[][] { {2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9} };
//        Util.convertToJavaArray("[[68,97],[34,-84],[60,100],[2,31],[-27,-38],[-73,-74],[-55,-39],[62,91],[62,92],[-57,-67]]");
        int[][] tc2 = new int[][]{{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
        System.out.println(Arrays.deepToString(kClosest(tc2, 5)));
    }
}
