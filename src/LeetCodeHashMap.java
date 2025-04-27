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


//    private static boolean isAnagram(String str1, String str2){
//        Map<Character, Integer> booleanMap = new HashMap<>();
//        if (str1.equals(str2)) return true;
//        if (str1.length() != str2.length()) return false;
//        for (int i=0;i<str2.length();i++){
//            char ch = str1.charAt(i);
//            booleanMap.put(ch, booleanMap.getOrDefault(ch, 0) + 1);
//        }
//        for (int j=0;j<str2.length();j++){
//            char ch = str2.charAt(j);
//            if (!booleanMap.containsKey(ch)){
//                return false;
//            }
//        }
//        return true;
//    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical, group);
            }
        }

        return new ArrayList<>(anagramGroups.values());
    }

    //Problem: Given an array of integers nums and a target integer target,
    // find the indices of two numbers in the array that add up to the target.

    //Input: int[] nums = [2, 7, 11, 15], target = 9
    //Output: [0, 1]
    //Explanation: The numbers at indices 0 and 1 in the array add up to the target 9.
    public static int[] twoSum(int [] array, int target){
        Map<Integer,Integer> integerIntegerMap = new HashMap<>();
        for (int i=0 ;i<array.length;i++){
            //tager = x+y;
            //x = target-y;
            int complement = target - array[i];
            if (integerIntegerMap.containsKey(complement)){
                return new int [] {integerIntegerMap.get(complement),i};
            }
            integerIntegerMap.put(array[i],i);
        }
        return new int[0];
    }




    public static void main(String[] args) {
        System.out.println("Commen elments exists? : "+itemsInCommon(new int []{1,2,3},new int []{4,5,6}));

        System.out.println("Duplicates : "+ findDuplicates(new int []{1,2,3,2,4,5,6,8,5}));

        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        System.out.println(SecondNonRepeatingChar("leetcode"));

        System.out.println("******ANGRAMS******");
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        System.out.println("**************");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}