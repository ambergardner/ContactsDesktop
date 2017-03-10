import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class World{


public void loadCountries() throws FileNotFoundException {

        final String filename = "countries.txt";
        File f = new File(FILE_NAME);

        try {
                Scanner scanner = new Scanner(f);

                while (scanner.hasNext()) {

                }catch(FileNotFountException e){
                        System.out.println("No input file found!");
                }}
        }


private void add(Country country) {
        //find the First Letter of the country
        //get associated ArrayList from Map ( First Letter == KEY)
        //create new ArrayList if no list found
        //add country to the list
        //put list into map by key
        }

//get a letter from user and create that single file output
public void printSingleCountryList(){
        //prompt for letter
        //writeCountryList by First Letter

        }

//write to file
private void writeCountryList(String firstLetter){
        //get get ArrayList from Map by First Letter
        //for each country in the list // ust boilerplate FileWriter!
        // .write (country name)
        //applend commma and space
        }

        private class FileNotFountException {
        }
}

