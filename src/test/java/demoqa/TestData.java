package demoqa;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = faker.options().option("Male","Female","Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String birthYear = faker.number().numberBetween(1900, 2022) + "";
    String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    String subject = faker.options().option("Physics", "Hindi", "Social Studies", "Data Science");
    String hobby = faker.options().option("Sports", "Music");
    String picture = "picture.jpg";
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
}
