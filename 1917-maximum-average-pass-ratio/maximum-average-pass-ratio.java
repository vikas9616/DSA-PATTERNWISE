

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0]) 
        );
        
        for (int[] cls : classes) {
            int passed = cls[0], total = cls[1];
            double gain = calculateGain(passed, total);
            maxHeap.offer(new double[] {gain, passed, total});
        }
        
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll(); 
            double gain = top[0];
            int passed = (int) top[1];
            int total = (int) top[2];
            
            passed++;
            total++;
            
            gain = calculateGain(passed, total);
            maxHeap.offer(new double[] {gain, passed, total});
        }
        
        double totalRatio = 0.0;
        for (double[] cls : maxHeap) {
            totalRatio += (cls[1] / cls[2]);
        }
        
        return totalRatio / classes.length;
    }
    
    private double calculateGain(int passed, int total) {
        double currentRatio = (double) passed / total;
        double newRatio = (double) (passed + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
