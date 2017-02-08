import java.util.regex.Pattern;

//An orderly trail of ants is marching across the park picnic area.
//
//It looks something like this:
//
//..ant..ant.ant...ant.ant..ant.ant....ant..ant.ant.ant...ant..
//But suddenly there is a rumour that a dropped chicken sandwich has been spotted on the ground ahead. The ants surge forward! Oh No, it's an ant stampede!!
//
//Some of the slower ants are trampled, and their poor little ant bodies are broken up into scattered bits.
//
//The resulting carnage looks like this:
//
//...ant...ant..nat.ant.t..ant...ant..ant..ant.anant..t
//Can you find how many ants have died?

public class Dinglemouse {

    public static int deadAntCount(final String ants) {
        if (ants == null) {return 0;}
        String carnage = ants.replaceAll("ant", "");
        int deadA = carnage.length() - carnage.replaceAll("a", "").length();
        int deadN = carnage.length() - carnage.replaceAll("n", "").length();
        int deadT = carnage.length() - carnage.replaceAll("t", "").length();
        return deadA > deadN ? deadA > deadT ? deadA : deadN > deadT ? deadN : deadT : deadN > deadT ? deadN : deadT; 
    }
}
