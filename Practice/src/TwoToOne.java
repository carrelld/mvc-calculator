import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible, containing distinct letters, - each taken only once - coming from s1 or s2.
//
//Examples:
//
//a = "xyaabbbccccdefww"
//b = "xxxxyyyyabklmopq"
//longest(a, b) -> "abcdefklmopqwxy"
//
//a = "abcdefghijklmnopqrstuvwxyz"
//longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

public class TwoToOne {
    public static String longest(String s1, String s2) {
        return Arrays.toString(s1.concat(s2).codePoints().distinct().sorted().toArray()).replaceAll(", ", "").replaceAll("\\[", "").replaceAll("\\]", "");
    }
    public static void main(String[] args) {
        System.out.println(longest("abcdey", "zyxwvedcba"));
    }
}
