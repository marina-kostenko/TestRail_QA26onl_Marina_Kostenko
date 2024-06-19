package models;

import enums.*;

import java.util.Objects;

public class TestCase {
    private final String caseTitle;
    private final TemplateTestCaseType templateTestCaseType;
    private final TypeTestCase typeTestCase;
    private final PriorityTestCase priorityTestCase;
    private final StatusTestCase statusTestCase;
    private final AssignedTestCase assignedTestCase;
    private final String estimate;
    private final String references;
    private final AutomationTypeTestCase automationTypeTestCase;
    private final String preconditions;
    private final String steps;
    private final String expectedResults;

    private TestCase(TestCaseBuilder testCaseBuilder)
    {
        this.caseTitle = testCaseBuilder.caseTitle;
        this.templateTestCaseType = testCaseBuilder.templateTestCaseType;
        this.typeTestCase = testCaseBuilder.typeTestCase;
        this.priorityTestCase = testCaseBuilder.priorityTestCase;
        this.statusTestCase = testCaseBuilder.statusTestCase;
        this.assignedTestCase = testCaseBuilder.assignedTestCase;
        this.estimate = testCaseBuilder.estimate;
        this.references = testCaseBuilder.references;
        this.automationTypeTestCase = testCaseBuilder.automationTypeTestCase;
        this.preconditions = testCaseBuilder.preconditions;
        this.steps = testCaseBuilder.steps;
        this.expectedResults = testCaseBuilder.expectedResults;
    }

    public String getCaseTitle()
    {
        return caseTitle;
    }

    public TemplateTestCaseType getTemplateTestCaseType()
    {
        return templateTestCaseType;
    }

    public TypeTestCase getTypeTestCase()
    {
        return typeTestCase;
    }

    public PriorityTestCase getPriorityTestCase()
    {
        return priorityTestCase;
    }

    public StatusTestCase getStatusTestCase()
    {
        return statusTestCase;
    }

    public AssignedTestCase getAssignedTestCase()
    {
        return assignedTestCase;
    }

    public String getEstimate()
    {
        return estimate;
    }

    public String getReferences()
    {
        return references;
    }

    public AutomationTypeTestCase getAutomationTypeTestCase()
    {
        return automationTypeTestCase;
    }

    public String getPreconditions()
    {
        return preconditions;
    }

    public String getSteps()
    {
        return steps;
    }

    public String getExpectedResults()
    {
        return expectedResults;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(caseTitle, testCase.caseTitle) && typeTestCase == testCase.typeTestCase && priorityTestCase == testCase.priorityTestCase && statusTestCase == testCase.statusTestCase && assignedTestCase == testCase.assignedTestCase && Objects.equals(estimate, testCase.estimate) && Objects.equals(references, testCase.references) && automationTypeTestCase == testCase.automationTypeTestCase && Objects.equals(preconditions, testCase.preconditions) && Objects.equals(steps, testCase.steps) && Objects.equals(expectedResults, testCase.expectedResults);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(caseTitle, templateTestCaseType, typeTestCase, priorityTestCase, statusTestCase, assignedTestCase, estimate, references, automationTypeTestCase, preconditions, steps, expectedResults);
    }

    public static class TestCaseBuilder {
        private final String caseTitle;
        private TemplateTestCaseType templateTestCaseType;
        private TypeTestCase typeTestCase;
        private PriorityTestCase priorityTestCase;
        private StatusTestCase statusTestCase;
        private AssignedTestCase assignedTestCase;
        private String estimate;
        private String references;
        private AutomationTypeTestCase automationTypeTestCase;
        private String preconditions;
        private String steps;
        private String expectedResults;

        public TestCaseBuilder(String caseTitle)
        {
            this.caseTitle = caseTitle;
        }

        public TestCaseBuilder setTemplateTestCaseType(TemplateTestCaseType templateTestCaseType)
        {
            this.templateTestCaseType = templateTestCaseType;
            return this;
        }

        public TestCaseBuilder setTypeTestCase(TypeTestCase typeTestCase)
        {
            this.typeTestCase = typeTestCase;
            return this;
        }

        public TestCaseBuilder setPriorityTestCase(PriorityTestCase priorityTestCase)
        {
            this.priorityTestCase = priorityTestCase;
            return this;
        }

        public TestCaseBuilder setStatusTestCase(StatusTestCase statusTestCase)
        {
            this.statusTestCase = statusTestCase;
            return this;
        }

        public TestCaseBuilder setAssignedTestCase(AssignedTestCase assignedTestCase)
        {
            this.assignedTestCase = assignedTestCase;
            return this;
        }

        public TestCaseBuilder setEstimate(String estimate)
        {
            this.estimate = estimate;
            return this;
        }

        public TestCaseBuilder setReferences(String references)
        {
            this.references = references;
            return this;
        }

        public TestCaseBuilder setAutomationTypeTestCase(AutomationTypeTestCase automationTypeTestCase)
        {
            this.automationTypeTestCase = automationTypeTestCase;
            return this;
        }

        public TestCaseBuilder setPreconditions(String preconditions)
        {
            this.preconditions = preconditions;
            return this;
        }

        public TestCaseBuilder setSteps(String steps)
        {
            this.steps = steps;
            return this;
        }

        public TestCaseBuilder setExpectedResults(String expectedResults)
        {
            this.expectedResults = expectedResults;
            return this;
        }


        public TestCase build()
        {
            return new TestCase(this);
        }
    }
}
