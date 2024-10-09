package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class RestfulBaseUrl {

    protected RequestSpecification specRestfull;


    @BeforeTest
    public void setUp(){
        specRestfull = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
