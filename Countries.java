import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Countries {
    protected static List<Country> countries;
    
    public Countries() {
        countries = new ArrayList<>();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public boolean askQuestion(){
        Country randomCountry = getRandomCountry();
        System.out.println("What is the prefix for " + randomCountry.getName() +"?");

        Scanner scanner = new Scanner(System.in);
        String prefixGuess = scanner.nextLine();
        

        return checkAnswer(randomCountry, prefixGuess);
    }


    private boolean checkAnswer(Country randomCountry, String prefixGuess) {

        if(randomCountry.getPrefix().equals(prefixGuess)){
            System.out.print("Correct - "+ randomCountry.getName()+ " has the prefix: " + prefixGuess + "\n");
            return true;
        }
        System.out.print("Wrong - "+ randomCountry.getName()+ " has the prefix: " + randomCountry.getPrefix() + "\n");
        return false;
    }

    public void makeCountriesList() throws IOException{
        String csvFile = "countriesAndPrefixes.csv";
            
            FileReader reader = new FileReader(csvFile);
            CSVFormat format = CSVFormat.DEFAULT.builder().setHeader("name", "prefix").build();
            CSVParser parser = new CSVParser(reader, format);
    
            for (CSVRecord record : parser) {

                if (record.getRecordNumber() == 1 ) continue;

                String name = record.get("name");
                String prefix = record.get("prefix");
                Country country = new Country(name, prefix);
                countries.add(country);
            }
            
            parser.close();
            reader.close();
     }

     public Country getRandomCountry(){
        Random random = new Random();
        List<Country> countriesList = getCountries();
        return countriesList.get(random.nextInt(countries.size()));
     }
}