package interviewSpiral;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestAPI {
	
	String url="https://jsonplaceholder.typicode.com/posts";
	
	@Test
	public void getResponseBody() {
		
//		given().when().get(url).then().log().all();
		
		given().queryParam("id", "1")
		.queryParam("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
		.when().get(url).then().log().body();
		
	}
	
	@Test
	public void getResponseStatus() {
		
		int statusCode=given().queryParam("id", "1")
		.queryParam("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
		
		.when().get(url).getStatusCode();
		
		System.out.println("The response status is "+statusCode);

		   given().when().get(url).then().assertThat().statusCode(200);
	}
	
	@Test
	public void getResponseHeaders(){
		   System.out.println("The headers in the response "+
		                   get(url).then().extract()
		           .headers());
		}
	
	@Test
	public void getResponseTime(){
		  System.out.println("The time taken to fetch the response "+get(url)
		         .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
		}
	
	@Test
	public void getResponseContentType(){
		   System.out.println("The content type of response "+
		           get(url).then().extract()
		              .contentType());
		}
			
}
