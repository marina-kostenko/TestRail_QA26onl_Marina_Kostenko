package models;

import enums.ProjectType;

import java.util.Objects;

public class Project {
    private final String name;
    private final String announcement;
    private final boolean showAnnouncement;
    private final ProjectType projectType;
    private final boolean enableTestCaseApprovals;

    private Project(ProjectBuilder projectBuilder)
    {
        this.name = projectBuilder.name;
        this.announcement = projectBuilder.announcement;
        this.showAnnouncement = projectBuilder.showAnnouncement;
        this.projectType = projectBuilder.projectType;
        this.enableTestCaseApprovals = projectBuilder.enableTestCaseApprovals;
    }

    public String getName()
    {
        return name;
    }

    public String getAnnouncement()
    {
        return announcement;
    }

    public boolean isShowAnnouncement()
    {
        return showAnnouncement;
    }

    public ProjectType getProjectType()
    {
        return projectType;
    }

    public boolean isEnableTestCaseApprovals()
    {
        return enableTestCaseApprovals;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, announcement, showAnnouncement, projectType, enableTestCaseApprovals);
    }

    public static class ProjectBuilder {
        private final String name;
        private String announcement;
        private boolean showAnnouncement;
        private ProjectType projectType;
        private boolean enableTestCaseApprovals;

        public ProjectBuilder(String name)
        {
            this.name = name;
        }

        public ProjectBuilder withAnnouncement(String announcement)
        {
            this.announcement = announcement;
            return this;
        }

        public ProjectBuilder setShowAnnouncement(boolean showAnnouncement)
        {
            this.showAnnouncement = showAnnouncement;
            return this;
        }

        public ProjectBuilder withProjectType(ProjectType projectType)
        {
            this.projectType = projectType;
            return this;
        }

        public ProjectBuilder setEnableTestCaseApprovals(boolean enableTestCaseApprovals)
        {
            this.enableTestCaseApprovals = enableTestCaseApprovals;
            return this;
        }

        public Project build()
        {
            return new Project(this);
        }
    }
}
