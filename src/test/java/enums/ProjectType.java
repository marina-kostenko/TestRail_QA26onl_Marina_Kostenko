package enums;

public enum ProjectType {
    SINGLE_REPO_FOR_ALL_CASES("addEditProjectSuiteModeSingle", "Use a single repository for all cases (recommended)"),
    SINGLE_REPO_WITH_BASELINE("addEditProjectSuiteModeSingleBaseline", "Use a single repository with baseline support"),
    MULTIPLY_TEST_SUITES("addEditProjectSuiteModeMulti", "Use multiple test suites to manage cases");


    private final String dataTestId;
    private final String name;

    ProjectType(String dataTestId, String name)
    {
        this.dataTestId = dataTestId;
        this.name = name;
    }

    public String getDataTestId()
    {
        return dataTestId;
    }

    public String getName()
    {
        return name;
    }
}
