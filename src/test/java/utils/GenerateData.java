package utils;

import com.github.javafaker.Faker;

public class GenerateData {

    private final static Faker faker = new Faker();

    public static String generateProjectName()
    {
        return faker.name() + faker.number().digit();
    }

    public static String generateAnnouncementText()
    {
        return faker.lorem().sentence();
    }
}
