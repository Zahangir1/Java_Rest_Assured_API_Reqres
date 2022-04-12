package user;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Update_User {

    @Test
    public void update_user() {
        JSONObject request = new JSONObject();

        request.put("name", "zahangir");
        request.put("job", "qa");

        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                put("https://reqres.in/api/users/2").

        then().
                statusCode(200).
                body("name", equalTo("zahangir")).
                body("job", equalTo("qa")).
                log().all();
    }
}

