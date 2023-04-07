package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;
    private int input;
    private String opt;
    private double result2;
    @Before
    public void before() {
        calculator = new Calculator();
    }
    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.print(result);
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @Given("^An input value (-?\\d+) and an operation (.+)$")
    public void anInputValuesInputAndAnOperationOpt(int arg0, String arg1) {
        input = arg0;
        opt = arg1;
    }

    @When("^I apply the operation on the input$")
    public void iApplyTheOperationOnTheInput() {
        if (opt.equals("rvs")) {
            result2 = calculator.rvs(input);
        } else if (opt.equals("sqr")) {
            result2 = calculator.sqr(input);
        }
    }

    @Then("^I see the result (.+)$")
    public void iExpectTheResultResult(double arg0) {
        Assert.assertEquals(arg0, result2, 0.001);
    }
}
