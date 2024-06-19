package enums;

import java.util.Arrays;

public enum AutomationTypeTestCase {
    NONE("None"),
    RANOREX("Ranorex");

    private final String name;

    AutomationTypeTestCase(String name)
    {
        this.name = name;
    }

    public static AutomationTypeTestCase getFromName(String name)
    {
        return Arrays.stream(AutomationTypeTestCase.values()).filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName()
    {
        return name;
    }
}

