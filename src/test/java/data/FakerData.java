package data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class FakerData {
    public Faker faker = new Faker(new Locale("ru"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress("eng");
    public String gender = faker.demographic().sex();
    public String phoneNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    public Date fakerDateOfBirthday = faker.date().birthday();
    public String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public String monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public String yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public String currentAddress = faker.address().streetAddress();
    public String hobbies = faker.options().option("Reading", "Sports", "Music");
    public String picture = "file.jpeg";
    public String subject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    public Map<String, List<String>> stateWithCity = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public String state = faker.options().option(stateWithCity.keySet().toArray()).toString();
    public String city = faker.options().option(stateWithCity.get(state).toArray()).toString();


}
