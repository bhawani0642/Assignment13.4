import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Anagrams {
    public static void main(String[] args){
        
        //Input strings
        String[] input = new String[]{"listen", "pot", "part", "opt", "trap",
                                    "silent", "top", "this", "hello", "hits",
                                    "what", "shit"};

        //List to keep track of which words are already used in group on Anagrams
        List<Integer> used = new ArrayList<>();

        
        for (int i = 0; i < input.length; i++) {
            List<String> listOfAnagrams = findAnagrams(i, input, used);
            if(listOfAnagrams.size() > 0){
                System.out.println(listOfAnagrams.toString());
            }
        }


    }

    //method to find string at 'pos' in 'list' anagrams. This method returns list of anagrams. This also takes
    //the used Integer list to find which words are already used to find anagrams.
    
    public static List<String> findAnagrams(int pos, String[] list, List<Integer> used){
        List<String> listOfAnagrams = new ArrayList<>();
        
        //This for loops compares string at pos in list with every string after pos in list to check if they are
        //anagrams. If they are, then it adds the word to the above listOnAnagrams
        for (int i = pos + 1; i < list.length; i++)
            if(used.indexOf(i) == -1)
               if(areAnagrams(list[pos], list[i])) {
                   used.add(i);
                   listOfAnagrams.add(list[i]);
               }

        //If anagrams were found then add our string at pos in list to the list(as it is also anagram)
        if(listOfAnagrams.size() > 0)
            listOfAnagrams.add(list[pos]);
        
        //finally return the list
        return listOfAnagrams;
    }

    
    //This method checks if two words are anagrams or not
    public static boolean areAnagrams(String word1, String word2){
        //This works by
        
        //Converting strings to char array
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        //Checking if lengths are arrays are equal.
        //If they aren't, it implies that the words are not anagrams and thus it returns false
        if (word1Arr.length != word2Arr.length)
            return false;

        
        //Sorting both arrays
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);

        

        //Now checking each char in both arrays at same position
        //If each chars are same it implies that the words are anagrams
        for (int i = 0; i < word1Arr.length; i++) {
            
            //If even one char is different, then the words are not anagrams
            if(word1Arr[i] != word2Arr[i])
                return false;
        }

        //return true if every char is same (words are anagrams)
        return true;
    }

}
// code ends here