package leedCode;

public class ReverseVowels {
    public static void main(String[] args) {
        ReverseVowels re = new ReverseVowels();
        String s = "aA";
        String s1 = re.reverseVowels(s);
        System.out.println(s1);
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int m=0;
        int n=s.length()-1;
        char tem ;
        while(m<n){
            while(!isVowel(chars[m])&&m<n){
                m++;
            }
            while(!isVowel(chars[n])&&m<n){
                n--;
            }
            if(m<n){
                tem=chars[m];
                chars[m]=chars[n];
                chars[n]=tem;
                m++;
                n--;
            }
        }
        return new String(chars);

    }
    private boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            return true;
        else
            return false;
    }
}
