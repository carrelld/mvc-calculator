import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> commonSubstrings = new HashSet<String>();
        
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s2.contains(s1)) {
                    commonSubstrings.add(s1);
                }
            }
        }
        String[] result = commonSubstrings.toArray(new String[commonSubstrings.size()]);
        Arrays.sort(result);
        return result;
    }
    
}
