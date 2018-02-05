import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String>myWords;
    private ArrayList<Integer>myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public int maxIndex(){
        int max = 0;
        for(int i=0; i<myWords.size(); i++)
            if(myFreqs.get(i) > myFreqs.get(max))
                max = i;
        return max;
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();

        FileResource file = new FileResource();

        for(String word : file.words()){
            String sen = "";

            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);

                //if(Character.isLetter(ch))
                    sen += ch;
            }

            if(sen.length() != 0){
                word = sen.toLowerCase();
                if(myWords.contains(word)){
                    int index = myWords.indexOf(word);
                    int res = myFreqs.get(index);
                    myFreqs.set(index, res + 1);
                }

                else{
                    myWords.add(word);
                    myFreqs.add(1);
                }
            }
        }
    }

    private void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int i=0; i<myWords.size(); i++){
            System.out.println( myFreqs.get(i) + " " + myWords.get(i));
        }
        int index = maxIndex();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(index) + " " + myFreqs.get(index));
    }

    public static void main(String args[]){
        WordFrequencies wordFreq = new WordFrequencies();
        wordFreq.tester();
    }
}
