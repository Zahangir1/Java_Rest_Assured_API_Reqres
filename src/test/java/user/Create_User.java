package user;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Create_User {

    @Test
    public void create_new_user () {
        JSONObject request = new JSONObject();

        request.put("name", "zahangir");
        request.put("job", "sqa engineer");

        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                post("https://reqres.in/api/users").

        then().
                statusCode(201).
                body("name", equalTo("zahangir")).
                body("job", equalTo("sqa engineer")).
                log().all();
    }
}

