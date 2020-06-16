import java.util.Arrays;

class CTCEChapter1 {

    // given two strings, write a method to decide if one is a permutation of the other
    // case sensitive, whitespcae sensitive
    // {'god  ' != 'dog'} {'God' == 'doG'}
    public boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }


    // does string have all unique characters?
    // ASCII vs Extended ASCII vs Unicode
    public boolean isUniqueChars(String mStr){

        boolean[] indexed = new boolean[128];

        if(mStr.length() > 128){
            return false;
        }

        for(int i = 0; i < mStr.length(); i++){
            int charInd = mStr.charAt(i);
            if(indexed[charInd]){
                return false;
            }
            else{
                indexed[charInd] = true;
            }
        }
        return true;
    }

    public static void main(String[] args){
        CTCEChapter1 classObj = new CTCEChapter1();
        // System.out.println(classObj.isUniqueChars("Test"));
        // System.out.println(classObj.isUniqueChars("test"));
        System.out.println(classObj.isPermutation("god   ", "dog"));
        System.out.println(classObj.isPermutation("Dog", "goD"));
    }
}