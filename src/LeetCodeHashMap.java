import java.util.*;

public class LeetCodeHashMap {

    //compare 2 array using HashMap
    public static boolean itemsInCommon(int [] array1, int [] array2){
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for (int i : array1){
            hashMap.put(i,true);
        }
        for (int j : array2){
            if (hashMap.containsKey(j)){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findDuplicates(int [] myArray){
        Map<Integer, Boolean> hashMapList = new HashMap<>();
        List<Integer> duplicateValues = new ArrayList<>();

        for (int i : myArray){
            if (null != hashMapList.get(i)){
                duplicateValues.add(i);
            }
            hashMapList.put(i,true);
        }
        return duplicateValues;
    }


    public static Character firstNonRepeatingChar(String input){
        char[] charArray = input.toCharArray();
        Map<Character , Integer> mapValue = new LinkedHashMap<>();
        for (char ch : charArray){
            mapValue.put(ch,mapValue.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character, Integer> mapped : mapValue.entrySet()){
            if (mapped.getValue()==1){
                return mapped.getKey();
            }

        }
        return null;
    }

    public static Character SecondNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        boolean isSecond = false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (charCounts.get(c) == 1) {
                if (isSecond){
                    return c;
                }
                isSecond=true;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        System.out.println("Commen elments exists? : "+itemsInCommon(new int []{1,2,3},new int []{4,5,6}));

        System.out.println("Duplicates : "+ findDuplicates(new int []{1,2,3,2,4,5,6,8,5}));

        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        System.out.println(SecondNonRepeatingChar("leetcode"));


    }
}