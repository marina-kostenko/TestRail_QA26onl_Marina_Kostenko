package enums;

import java.util.Arrays;

public enum PriorityTestCase {

    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String name;

    PriorityTestCase(String name)
    {
        this.name = name;
    }

    public static PriorityTestCase getFromName(String name)
    {
        return Arrays.stream(PriorityTestCase.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return this.name;
    }
}
