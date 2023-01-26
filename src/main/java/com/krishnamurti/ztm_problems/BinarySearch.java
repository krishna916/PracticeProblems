package com.krishnamurti.ztm_problems;

public class BinarySearch {

    // search sorted array of positive ints
    public static int search(int[] sortedArray, int target) {
        return search(sortedArray, 0, sortedArray.length -1, target);
    }

    
    private static  int search(int[] arr, int left, int right, int target) {
        if (left == right) {
            if (arr[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left+right)/2;
        if(arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return search(arr, mid + 1, right, target);
        } else if(arr[mid] > target) {
            return search(arr, left, mid -1, target);
        }
        return -1;
    }

    private static int searchInt(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static int searchIt(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        return searchInt(arr, left, right, target);
    }

    public static int[] searchRangeBinary(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
         int firstPos =searchInt(nums, 0, nums.length - 1, target);
        if (firstPos == -1) {
            return new int[] {-1, -1};
        }

        int startPos = firstPos;
        int endPos = firstPos;
        int temp1 =-1, temp2 = -1;
        while (startPos != -1) {
            temp1 = startPos;
            startPos = searchInt(nums, 0, startPos - 1, target);
        }
        startPos = temp1;
        while(endPos != -1) {
            temp2 = endPos;
            endPos = searchInt(nums, endPos + 1, nums.length -1, target);
        }
        endPos = temp2;

        return new int[] {startPos, endPos};
    }


    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int[] result = new int[]{-1, -1};
        int targetIndex = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                targetIndex = result[0] = result[1] = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (targetIndex != -1) {
            // check left of found index
            for (int i = targetIndex - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    result[0] = i;
                } else {
                    break;
                }
            }

            for(int i = targetIndex + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    result[1] = i;
                } else {
                    break;
                }
            }

        }

        return result;
    }

}
