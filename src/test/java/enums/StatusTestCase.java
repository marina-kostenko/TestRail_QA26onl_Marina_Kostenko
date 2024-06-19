package enums;

import java.util.Arrays;

public enum StatusTestCase {
    READY("Ready"),
    DESIGN("Design"),
    REVIEW("Review");

    private final String name;

    StatusTestCase(String name)
    {
        this.name = name;
    }

    public static StatusTestCase getFromName(String name)
    {
        return Arrays.stream(StatusTestCase.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return this.name;
    }
}
