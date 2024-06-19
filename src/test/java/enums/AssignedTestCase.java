package enums;

import java.util.Arrays;

public enum AssignedTestCase {
    NONE("None"),
    ME("Me");

    private final String name;

    AssignedTestCase(String name)
    {
        this.name = name;
    }

    public static AssignedTestCase getFromName(String name)
    {
        return Arrays.stream(AssignedTestCase.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return name;
    }
}
