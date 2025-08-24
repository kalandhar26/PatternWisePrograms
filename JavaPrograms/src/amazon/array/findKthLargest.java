package amazon.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class findKthLargest {

    public static void main(String[] args) {

        int[] array = {9, 7, 8, 6, 5, 3, 4, 2};
        System.out.println(findKthLargestNumber(array, 3));
        System.out.println(findKthSmallestNumber(array, 3));

    }

    public static int findKthLargestNumber(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0)
            return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        Integer result = minHeap.peek();
        return result == null ? -1 : result;
    }

    public static int findKthSmallestNumber(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0)
            return -1;

        // Max Heap (largest element on top)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest to keep only k smallest
            }
        }

        Integer result = maxHeap.peek();
        return result == null ? -1 : result;
    }

}
