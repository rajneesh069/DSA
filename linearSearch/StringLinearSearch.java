package linearSearch;

public class StringLinearSearch {
    public static void main(String[] args) {
        String[] arr = { "apple", "banana", "cherry", "date", "elderberry" };
        System.out.println(stringLinearSearch(arr, "banana"));
    }

    static int stringLinearSearch(String[] arr, String element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
