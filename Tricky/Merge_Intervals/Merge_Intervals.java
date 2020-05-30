package LeetCode_Java.Tricky.Merge_Intervals;

import LeetCode_Java.buildinClass.Interval;

import java.util.*;

public class Merge_Intervals {

    // right method
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (h1, h2)-> h1[0] - h2[0]);

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
    // right method 2: just update int end
    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() == 1 || intervals.size() == 0) return intervals;
        Collections.sort(intervals, (h1, h2)-> Integer.compare(h1.start, h2.start));

        int start = intervals.get(0).start;
        int maxEnd = intervals.get(0).end;
        List<Interval> ans = new ArrayList<>();
        for (int i = 1; i < intervals.size();i++){
            if (intervals.get(i).start > maxEnd){//non-overlapping
                ans.add(new Interval(start, maxEnd));
                start = intervals.get(i).start;
            }else {
                maxEnd = Math.max(intervals.get(i).end, maxEnd);
            }

        }
        return ans;
    }


    //wrong method:
    public List<Interval> merge1(List<Interval> intervals) {
        if (intervals.size() == 1 || intervals.size() == 0) return intervals;

        Collections.sort(intervals, (h1, h2)-> Integer.compare(h1.start, h2.start));
        int start = intervals.get(0).start;

        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size() -1;i++){
            if ( intervals.get(i).end< intervals.get(i+1).start) {//non-overlapping
                Interval temp = new Interval(start, intervals.get(i).end);
                ans.add(temp);
                start = intervals.get(i+1).start;
            }

        }

        if (intervals.get(intervals.size() - 1).start < intervals.get(intervals.size() - 2).end){ //overlapping
            Interval temp = new Interval(start, intervals.get(intervals.size() - 1).end);
            ans.add(temp);
        }else{
            Interval temp = new Interval(intervals.get(intervals.size() - 1).start, intervals.get(intervals.size() - 1).end);
            ans.add(temp);
        }
        return ans;

    }
}
