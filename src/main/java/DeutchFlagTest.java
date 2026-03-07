import java.util.ArrayList;
import java.util.List;

public class DeutchFlagTest {
    public static void main(String[] args) {
        var resultList = sortArr(new ArrayList<>(List.of(0, 1, 2, 0, 1, 2)));
        System.out.println(resultList);
    }

    public static List<Integer> sortArr(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }

        System.out.println(list);

        List<Integer> resultList = sortArr(list.subList(1, list.size()));

        var currentElement = list.get(0);
        if (resultList.isEmpty()) {
            resultList.add(currentElement);
        } else {
            if (currentElement == 0) {
                resultList.add(0, currentElement);
            } else if (currentElement == 2) {
                resultList.add(currentElement);

            } else if (currentElement == 1) {

                int lastZeroIdx = resultList.lastIndexOf(0);
                int firstTwoIdx = resultList.indexOf(2);

                if (lastZeroIdx != -1) {
                    resultList.add(lastZeroIdx + 1, currentElement);
                } else if (firstTwoIdx != -1) {
                    resultList.add(firstTwoIdx, currentElement);
                } else {
                    resultList.add(currentElement);
                }
            }

        }
        return resultList;

    }
}
