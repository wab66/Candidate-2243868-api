import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UT_TestAPI {

    @Test
    public void test_1(){
        //String answer = given().get("http://api.postcodes.io/postcodes/SW1P4JA").toString();
        System.out.println("test_1 - START ==========================================================================");
        Response response = given().get("http://api.postcodes.io/postcodes/SW1P4JA");
        //Response response = given().get("api.postcodes.io/postcodes/SW1P4JA");
        System.out.println("========================= This is my GET RESPONSE : " + response.asString());
        System.out.println("========================= This is my GET BODY : " + response.getBody().asString());
        int code = response.getStatusCode();
        System.out.println("========================= This is my GET STATUS CODE : " + code);
        System.out.println("========================= This is my GET HEADER (content-Type) : " + response.getHeader("content-type"));
        System.out.println("test_1 - END ==========================================================================");
        Assert.assertEquals("",200 , code);
    }

    @Test
    public void test_2(){
        given().
            get("http://api.postcodes.io/postcodes/SW1P4JA").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void test_3(){
        given().
            get("http://api.postcodes.io/postcodes/SW1P4JA").
        then().statusCode(201);
    }

    @Test
    public void test_4() {
        Response response = given().get("http://api.postcodes.io/postcodes/SW1P4JA");
        ResponseBody body = response.getBody();
        String bodyStr = body.asString();
        System.out.println("=============================> Body String: " + bodyStr);
    }
//    This assessment will require you to create your own project on GitLab, called “Candidate 2243868”.
//    If you are not yet registered on GitLab, please follow the link below.
//
//https://gitlab.com/users/sign_in#register-pane
//
//    During this time you will need to create a new public GitLab project. You will be expected to use Maven
//    to pull in Serenity dependencies – there are some good example cucumber Serenity POM files on GitHub.
//
//    Please create a feature branch and work from this, when you have completed all scenarios, raise a
//    pull request to Master branch for review.
}
