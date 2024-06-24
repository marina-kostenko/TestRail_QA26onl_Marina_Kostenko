package enums;

import java.util.Arrays;

public enum TemplateTestCaseType {

    BEHAVIOUR_DRIVEN_DEVELOPMENT("Behaviour Driven Development"),
    EXPLORATORY_SESSION("Exploratory Session"),
    TEST_CASE_STEPS("Test Case (Steps)"),
    TEST_CASE_TEXT("Test Case (Text)");

    private final String name;

    TemplateTestCaseType(String name)
    {
        this.name = name;
    }

    public static TemplateTestCaseType getFromName(String name)
    {
        return Arrays.stream(TemplateTestCaseType.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return this.name;
    }
}
