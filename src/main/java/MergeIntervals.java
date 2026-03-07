import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        // --- TEST CASES LIST ---
        List<List<List<Integer>>> testCases = new ArrayList<>();

        // 1. Basic overlapping intervals
        testCases.add(List.of(
                List.of(1,3),
                List.of(2,6),
                List.of(8,10),
                List.of(15,18)
        ));

        // 2. Fully contained intervals
        testCases.add(List.of(
                List.of(1,10),
                List.of(2,3),
                List.of(4,8),
                List.of(11,12)
        ));

        // 3. No overlaps
        testCases.add(List.of(
                List.of(1,2),
                List.of(4,5),
                List.of(7,8),
                List.of(10,11)
        ));

        // 4. All overlap into one
        testCases.add(List.of(
                List.of(1,4),
                List.of(2,5),
                List.of(3,6),
                List.of(4,7)
        ));

        // 5. Touching endpoints (should merge)
        testCases.add(List.of(
                List.of(1,3),
                List.of(3,5),
                List.of(5,7),
                List.of(8,10)
        ));

        // LOOP THROUGH ALL TEST CASES
        int tc = 1;
        for (List<List<Integer>> intervals : testCases) {

            // IMPORTANT: Sort intervals by start before merging
            intervals = new ArrayList<>(intervals);
            intervals.sort((a,b) -> Integer.compare(a.get(0), b.get(0)));

            List<List<Integer>> result =
                    mergeIntervals(new ArrayList<>(intervals.subList(0,1)),
                            intervals.subList(1, intervals.size()));

            System.out.println("Test Case " + tc + ":");
            System.out.println("Input:  " + intervals);
            System.out.println("Output: " + result);
            System.out.println("------------------------------------");
            tc++;
        }
    }

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> resultList, List<List<Integer>> inputIntervalList) {

        if(inputIntervalList.isEmpty())
        {
            return resultList;
        }

        // [[1,3],[2,6],[8,10],[15,18]]

        List<Integer> currentInterval = inputIntervalList.get(0);

        var currentFirstElement = currentInterval.get(0);
        var currentSecondElement = currentInterval.get(1);


        List<Integer> previousInterval = resultList.get(resultList.size() - 1);

        var prevFirstElement = previousInterval.get(0);
        var prevSecondElement = previousInterval.get(1);

        List<Integer> newInterval = new ArrayList<>();
        if(currentFirstElement <= prevSecondElement)
        {
            newInterval.add(prevFirstElement);
            newInterval.add(currentSecondElement);

            resultList = resultList.subList(0, resultList.size() - 1);
            resultList.add(newInterval);
        }else {
            newInterval.add(currentFirstElement);
            newInterval.add(currentSecondElement);
            resultList.add(newInterval);
        }




        resultList = mergeIntervals(resultList, inputIntervalList.subList(1, inputIntervalList.size()));


        return resultList;
    }
}
