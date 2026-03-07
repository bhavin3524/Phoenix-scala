import java.util.Arrays;
import java.util.List;

public class MinJumpReachEndOfArray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0);
        int result = minJumpReachEndOfArray(arr, arr.get(0), 0);
        System.out.println(result);
    }

    public static int minJumpReachEndOfArray(List<Integer> inputList, int jump, int countJump) {

        // Base condition: can reach end
        if (jump >= inputList.size() - 1) {
            return countJump + 1;
        }

        // window = all reachable elements from current position
        List<Integer> window = inputList.subList(1, jump + 1);

        // Find next index to jump (using helper)
        int bestIndex = getBestNextIndex(window);

        // Move to that next index (cut list)
        List<Integer> nextList = inputList.subList(bestIndex, inputList.size());
        int nextJump = nextList.get(0);

        return minJumpReachEndOfArray(nextList, nextJump, countJump + 1);
    }

    // -------------------------------
    // Helper method to find best index
    // -------------------------------
    private static int getBestNextIndex(List<Integer> window) {
        int bestReach = -1;
        int bestIndex = 1;  // because window starts at index 1 of original list

        // i = index inside window
        for (int i = 0; i < window.size(); i++) {
            int reach = (i + 1) + window.get(i);  // i+1 = actual index in original list
            if (reach > bestReach) {
                bestReach = reach;
                bestIndex = i + 1;
            }
        }
        return bestIndex;
    }
}
