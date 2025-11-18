public class Anagram {
    public static void main(String args[]) {
        System.out.println(isAnagram("silent","listen")); 
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); 
        System.out.println(isAnagram("Madam Curie","Radium came")); 
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); 

        System.out.println(preProcess("What? No way!!!"));
        
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        
        String str = "1234567";
        Boolean pass = true;
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1);
        str2 = preProcess(str2);
        
        String s1 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != ' ') s1 = s1 + str1.charAt(i);
        }
        
        String s2 = "";
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != ' ') s2 = s2 + str2.charAt(i);
        }

        str1 = s1;
        str2 = s2;

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int index = str2.indexOf(c);
            if (index == -1) {
                return false;
            }
            str2 = str2.substring(0, index) + str2.substring(index + 1);
        }
        return true;
    }
       
    public static String preProcess(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            if (c >= 'a' && c <= 'z') {
                newString = newString + c;
            }
        }
        return newString;
    } 
       
    public static String randomAnagram(String str) {
        str = preProcess(str); 
        String newString = ""; 
        while (str.length() > 0) {
            int randomIndex = (int) (Math.random() * str.length());
            newString = newString + str.charAt(randomIndex);
            str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
        }
        return newString;
    }
}