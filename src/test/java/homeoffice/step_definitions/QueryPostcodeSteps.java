package homeoffice.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.*;

public class QueryPostcodeSteps {

    Response response;

    @Given("the application is running")
    public void the_application_is_running() {
        //assertThat(theApplication.currentStatus()).isEqualTo(RUNNING);
        System.out.println("===== No app to start");
    }

    @When("^I send a get request to (.*?)?")
    public void iSendARequestToURL(String url) {
        response = getResponse(url);
    }

    @Then("I get a {int} response")
    public void iGetAResponse(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals("The returned expected Status Code of '" + expectedStatusCode +
                "', does not match the actual returned status code of '" +
                actualStatusCode + "'.", expectedStatusCode,actualStatusCode );
    }

    private Response getResponse(String url){
        return response = given().get(fixURL(url));
    }

    private String fixURL(String fixURL){
        StringBuilder stringBuilder = new StringBuilder(fixURL);
        String textToAppend = "http://";
        if(!fixURL.toLowerCase().startsWith(textToAppend)){
            stringBuilder.insert(0, textToAppend);
            fixURL = stringBuilder.toString();
        }
        return fixURL;
    }
}
