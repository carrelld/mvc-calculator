public class Practice {
    public static void main(String[] args) {
        //System.out.println(gcd(20, 16));
        
        char vowel0 = 'a';
        final char vowel1 = vowel0;

        String vowel2 = vowel1 + "eiou";
        final String vowel3 = vowel2;

        char[] vowel4 = new char[] { vowel0, 'e', 'i', 'o', 'u' };
        final char[] vowel5 = vowel4;
        
        vowel0 = vowel1;
//        vowel1 = vowel0;
//        vowel2 = vowel3;
//        vowel3 = vowel2;
//        //vowel2[0] = 'x';
//        //vowel3[0] = 'x';
//        vowel4 = vowel5;
//        vowel5 = vowel4;
//        vowel4[0] = 'x';
        vowel5[0] = 'x';
        
    }
    
}
