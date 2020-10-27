package homework_4.task_2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.start();
    }

    void start() {
        List<Integer> numbers = generateNumbers();
        //System.out.println(numbers.size());
        //System.out.println(checkUnique(numbers));
        numbers = insertElementInRandomPosition(numbers, 42);
        //System.out.println(numbers);
        //System.out.println(checkUnique(numbers));
        Map<Integer,List<Integer>> map = sortListByDivider(numbers);
        //printMap(map);
    }

    List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int count = 0;
        while (count < 100000) {
            numbers.add(count++);
        }
        return numbers;
    }

    List<Integer> insertElementInRandomPosition(List<Integer> listForInsert, Integer element) {
        Random random = new Random();
        int index = random.nextInt(listForInsert.size() - 1);
        listForInsert.add(index, element);
        return listForInsert;
    }

    boolean checkUnique(List<Integer> collection) {
        Set<Integer> setWithUniqueElements = new LinkedHashSet<>(collection);
        return setWithUniqueElements.size() == collection.size();
    }

    Map<Integer, List<Integer>> sortListByDivider(List<Integer> list) {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        List<Integer> divider2 = new ArrayList<>();
        List<Integer> divider3 = new ArrayList<>();
        List<Integer> divider5 = new ArrayList<>();
        List<Integer> divider7 = new ArrayList<>();
        resultMap.put(2, divider2);
        resultMap.put(3, divider3);
        resultMap.put(5, divider5);
        resultMap.put(7, divider7);

        for (Integer element : list) {
            if (element % 2 == 0) {
                divider2.add(element);
            } else if (element % 3 == 0) {
                divider3.add(element);
            } else if (element % 5 == 0) {
                divider5.add(element);
            } else if (element % 7 == 0) {
                divider7.add(element);
            }
        }
    return resultMap;
    }

    void printMap(Map<Integer,List<Integer>> map){
        for (Integer key:map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
    }
}
