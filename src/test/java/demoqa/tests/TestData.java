package demoqa.tests;

import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.Collections;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String gender = setRandomValue("Male", "Female", "Other");
    String email = faker.internet().emailAddress();
    String number = faker.number().numberBetween(7926000000L,7926999999L) + "";
    String subject = setRandomValue("English", "Arts", "History", "Hindi");
    String address = faker.address().streetAddress();
    String month = setRandomValue("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String year = faker.number().numberBetween(1940,2005) + "";
    String day = setRandomDay();
    String dateBirth = String.format("%s %s,%s",day, month, year);
    String hobbies = setRandomValue("Sports", "Reading", "Music");
    String pictureName = "testing.jpg";
    String state = setRandomValue("Uttar Pradesh", "NCR", "Haryana", "Rajasthan");
    String city = setRandomCity(state);

    public String setRandomValue (String ... strings){
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values,strings);
        String item = values.get(faker.random().nextInt(0,values.size()-1));
        return item;
    }

    public String setRandomDay(){
        int day = faker.number().numberBetween(1,28);
        if (day < 10) {
            return "0" + day;
        }
        else {
            return day + "";
        }
    }

    public String setRandomCity (String state){
        String item = null;
        ArrayList<String> values = new ArrayList<>();
        if (state.equals("NCR")){
            Collections.addAll(values,"Delhi", "Gurgaon", "Noida");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if (state.equals("Uttar Pradesh")){
            Collections.addAll(values,"Agra", "Lucknow", "Merrut");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if (state.equals("Haryana")){
            Collections.addAll(values,"Karnal", "Panipat");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if  (state.equals("Rajasthan")){
            Collections.addAll(values,"Jaipur", "Jaiselmer");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        return item;
    }
}
