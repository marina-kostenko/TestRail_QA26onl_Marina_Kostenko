package models;

import lombok.Builder;

import java.util.Objects;


@Builder(setterPrefix = "set")
public class Milestone {
    private final String name;
    private String references;
    private String description;
    private String startDate;
    private String endDate;
    private boolean milestoneCompleted;

    public String getName()
    {
        return name;
    }

    public String getReferences()
    {
        return references;
    }

    public String getDescription()
    {
        return description;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public boolean isMilestoneCompleted()
    {
        return milestoneCompleted;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(name, milestone.name) && Objects.equals(description, milestone.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description);
    }
}
