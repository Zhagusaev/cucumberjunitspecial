package API;

import Pojo.Posts;
import Pojo.Reques;
import Utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.jsoup.helper.HttpConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class restAssuredPractice {

    @Before
    public void setUp(){
        baseURI="https://www.techtorial.dev.cc";
        basePath= "/wp-json/wp/v2/";
    }

    @Test
    public void test1(){

        when().
                get("https://reqres.in/api/users/2").
                then().log().all().
                statusCode(200);

    }

    @Test
    public void test2(){

        when().
                get("https://reqres.in/api/users/100").
                then().log().all().
                statusCode(404);

    }

    @Test
    public void test3(){

        given().relaxedHTTPSValidation().
                get("posts").
                then().log().all().
                statusCode(200).
                body("[0].id",equalTo(10)).body("[0].title.rendered",equalTo("NEW POST FROM POSTMAN"));

    }

    @Test
    public void test4(){

        given().relaxedHTTPSValidation().
                get("posts/5").
                then().log().all().
                statusCode(200).
                body("status",equalTo("publish")).body("sticky",equalTo(false));
    }

//Post
//body

    @Test
    public void test5(){
        given().relaxedHTTPSValidation()
                        //It will
                        //try again
                        //again
                .auth().preemptive().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body("{\n" +
                    "\t\"title\": \"NEW POST FROM POSTMAN122\",\n" +
                    "\t\"content\": \"This is the post created by api\",\n" +
                    "\t\"status\": \"publish\"\n" +
                    "}")
                .post("posts")
                .then().log().all()
                .statusCode(201).body("status",equalTo("publish"))
                .body("title.raw", equalTo("NEW POST FROM POSTMAN122"));
    }

    @Test
    public void test6(){
        given().relaxedHTTPSValidation()
                //It will
                //try again
                //again
                .auth().preemptive().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\":\"Update from API\"\n" +
                        "\t\n" +
                        "}").pathParam("id",21)
                .put("posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("title.raw",equalToIgnoringCase("Update from API"));
    }

    @Test
    public void test7(){
        given().relaxedHTTPSValidation()
                //It will
                //try again
                //again
                .auth().preemptive().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\": \"REST_Assured LIBRARY\",\n" +
                        "\t\"content\": \"This is the post created by api\",\n" +
                        "\t\"status\": \"publish\"\n" +
                        "}")
                .post("posts")
                .then().log().all()
                .statusCode(201)
                .body("title.raw",equalToIgnoringCase("Rest_Assured LIBRARY"));
    }

    @Test
    public void test8(){
        given().relaxedHTTPSValidation()
                //It will
                //try again
                //again
                .auth().preemptive().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\":\"Update PRACTICE REST2\"\n" +
                        "\t\n" +
                        "}").pathParam("id",25)
                .put("posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("title.raw",equalToIgnoringCase("Update PRACTICE REST2"));
    }

    @Test
    public void test9(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin","admin")
                .pathParam("newID",31)
                .queryParam("force",true)
                .delete("posts/{newID}")
                .then()
                .statusCode(200)
                .body("deleted",is(true));
    }

    @Test
    public void test10(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin","admin")
                .pathParam("id",18)
                .queryParam("force",true)
                .delete("posts/{id}")
                .then().log().all()
                .statusCode(200).statusCode(HttpStatus.SC_OK)
                .body("deleted", is(true));
    }

  @Test
    public void test11(){
        given().get("https://reqres.in/api/users/2").then().statusCode(200)
                .body(equalTo("{\"data\":{\"id\": 2,\"email\": \"janet.weaver@reqres.in\",\"first_name\": \"Janet\", \"last_name\": \"Weaver\", \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"}}"));
  }

  //Java --> JSON is called serialization
    //JSON --> JAVA is called deserialization

    //Once we get the Java object (Student object)
    //when we wanna send this student object as a body
    //we need to convert Java to JSON

    //Once we get the response from api we wanna convert to Java object to be able make the comparison with UI or DB

    @Test
    public void test13(){
      Response response = given().relaxedHTTPSValidation() //For ssl certificate verification
                .auth().preemptive().basic("admin", "admin")
                .pathParam("id",17)
                .get("https://www.techtorial.dev.cc/wp-json/wp/v2/posts/{id}");

        int id = response.jsonPath().getInt("id");

        System.out.println("id is equals to "+id);

        String expected = response.jsonPath().getString("title.rendered");

        System.out.println("title.rendered "+expected);

        Driver.getDriver().get("https://www.techtorial.dev.cc");

        Driver.getDriver().manage().window().maximize();

        String actual = Driver.getDriver().findElement(By.linkText("NEW POST FROM POSTMAN12")).getText();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void test14(){
        Response response = given().relaxedHTTPSValidation() //For ssl certificate verification
                .auth().preemptive().basic("admin", "admin")
                .pathParam("id",17)
                .get("https://www.techtorial.dev.cc/wp-json/wp/v2/posts/{id}");

        int id = response.jsonPath().getInt("id");

        System.out.println("id is equals to "+id);

        String expected = response.jsonPath().getString("content.rendered").replace("<p>","").replace("</p>","").trim();

        System.out.println("content.rendered "+expected);

        Driver.getDriver().get("https://www.techtorial.dev.cc");

        Driver.getDriver().manage().window().maximize();

        String actual = Driver.getDriver().findElement(By.xpath("//*[@id='post-17']/div/p")).getText();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void test15(){

        Response response = given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin")
                .get("/posts");

        System.out.println(response.jsonPath().getList("title.rendered"));

        List<String> expectedPosts = response.jsonPath().getList("title.rendered",String.class);

        System.out.println(expectedPosts);

        Driver.getDriver().get("https://www.techtorial.dev.cc");

        List<WebElement> titles= Driver.getDriver().findElements(By.xpath("//h3[@class='entry-title']"));

        List<String>actualPosts = new ArrayList<String>();

        for (WebElement element: titles){
            actualPosts.add(element.getText());
        }

        Assert.assertEquals(expectedPosts,actualPosts);

    }

    @Test
    public void test16(){
        Reques obj = new Reques("morpheus", "leader");

        given()
                .body(obj)
                .post("https://reqres.in/api/users")
                .then().statusCode(201);
    }

    //POJO ---> Plain object old

    @Test
    public void test17(){

        Posts obj = new Posts("POJO CLASS OBJECT","This is post request using pojo classes","publish");
        obj.setTitle("changing Title with LOMBOK getters and setter");
        System.out.println(obj);

        given().relaxedHTTPSValidation().auth().preemptive().basic("admin","admin")
                .contentType(ContentType.JSON)         //to check number         to check word created of status code
                .body(obj).post("/posts").then().statusCode(201).statusCode(HttpStatus.SC_CREATED)
                .body("status",equalTo("publish"));
    }

    @Test
    public void test18(){


        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
                .get("/posts/35");

        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");

        Map<String, String> links = jsonPath.getMap("_links.self[0]",String.class,String.class);

        System.out.println(links.keySet());

        System.out.println(links.values());



    }

}
