import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(mergeTwoSortedArrays(new ArrayList<>(List.of(1,2,9,10)),new ArrayList<>( List.of(3,4,5,6)), new ArrayList<>()));
    }

    public static List<Integer> mergeTwoSortedArrays(List<Integer> list1, List<Integer> list2, List<Integer> resultList) {
//       A = [1,2,9,10]
//
//B = [3,4,5,6]
        if (list1.isEmpty()) {
            resultList.addAll(list2);

            return resultList;
        }

        if (list2.isEmpty()) {
            resultList.addAll(list1);

            return resultList;
        }

        if (list2.get(0) > list1.get(0)) {
            resultList.add(list1.get(0));

            var result1 = mergeTwoSortedArrays(list1.subList(1, list1.size()), list2, resultList);
//            resultList.addAll(result1);
        } else {
            resultList.add(list2.get(0));
            var result2 = mergeTwoSortedArrays(list1, list2.subList(1, list2.size()), resultList);
//            resultList.addAll(result2);
        }

        return resultList;
    }

}
