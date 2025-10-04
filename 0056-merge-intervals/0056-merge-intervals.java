class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList();

        int[] current = intervals[0];
        merged.add(current);

        for(int[] interval : intervals){
            int currEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currEnd >= nextStart){
                current[1] = Math.max(currEnd, nextEnd);
            }
            else{
                merged.add(interval); 
                current = interval;
            }
        }

        return merged.toArray(new int [0][]);
    }
}