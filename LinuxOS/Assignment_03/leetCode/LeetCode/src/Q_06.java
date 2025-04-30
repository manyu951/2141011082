import java.util.*;

public class Q_06 {
    public  int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create a min-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Step 3: Extract top K elements from min-heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q_06 ans = new Q_06();
        int[] result = ans.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
