import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class CustomSort implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue() - o2.getValue();
    }
}

public class HashingTest {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Abhishek", 7899);
        hashMap.put("Vaibhavi", 3211);
        hashMap.put("Kano", 3244);
        hashMap.put("Oso", 7322);
        hashMap.put("Vijay", 5322);

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);


        Comparator<Map.Entry<String, Integer>> comparator = new CustomSort();

        Collections.sort(entryList,
                (o1, o2) ->
                        o1.getValue() - o2.getValue()

        );


        var sortedLinkedHashMap = entryList
                .stream()
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o, n) -> o, LinkedHashMap::new)
                );

        System.out.println("Sorted HashMap :: -> " + sortedLinkedHashMap);


    }
}
