package enums;

import java.util.Arrays;

public enum TypeTestCase {
    ACCESSIBILITY("Accessibility"),
    AUTOMATED("Automated"),
    COMPATIBILITY("Compatibility"),
    DESTRUCTIVE("Destructive"),
    FUNCTIONAL("Functional"),
    OTHER("Other"),
    PERFORMANCE("Performance"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    SMOKE_AND_SANITY("Smoke & Sanity"),
    USABILITY("Usability");

    private final String name;

    TypeTestCase(String name)
    {
        this.name = name;
    }

    public static TypeTestCase getFromName(String name)
    {
        return Arrays.stream(TypeTestCase.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return this.name;
    }
}
