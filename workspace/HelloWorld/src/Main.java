//import java.util.ArrayList;
//import java.util.HashMap;
//
//class Email{
//    String name;
//    String address;
//
//    public Email(String name, String address){
//        this.name = name;
//        this.address = address;
//    }
//}
//
//public class Jtest {
//    public static void main(String[] args) {
//
//        //map email address as Email object
//        HashMap<String, ArrayList<Email>> emailAddress = new HashMap<>();
//
//        // John -> [new array Email("personal",   "jj@usa.net")]
//        //create array
//        ArrayList<Email> emaillist = new ArrayList();
//
//        //add a new Email type to list
//        emaillist.add(new Email("personal", "jj@usa.net"));
//        emaillist.add(new Email("work", "jj@ironyard.net"));
//        emailAddress.put("John", emaillist);
//        //
//
//
//    }
//
//    String sentence = "This is my test I test so I know my code is working test";
//    //
//    String[] words = sentence.split(" ");
//    HashMap<String, Integer> frequencies = new HashMap<>();
//
//    int count  = 1;
//    for (String word : words){
//    //is word alread in list
//    if (frequencies.containsKey(word)){
//       count = frequencies.get(word);
//       frequencies.put(word, ++count);
//        }
//        else {
//            frequencies.put(word, 1);
//
//        }
//        }
//        System.out.println(frequencies);
//
//    //add word to list
//    frequencies.put("");
//
//}
//}