package TesteApi;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TstIcarros_Post_Request  {
	
	
	
	@Test
	public void postInserirUsuario() {
		//Especificação Base da URL 
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		//Setar o Obrjeto (REquest) 
		RequestSpecification httRequest=RestAssured.given();
		
		//Montar o json pra inserir
		JSONObject requestParam =new JSONObject();		
		requestParam.put("id", "1313");
		requestParam.put("username", "pedro1313");
		requestParam.put("firstName", "pedro1313");
		requestParam.put("lastName", "pedro1313");
		requestParam.put("email", "pedro1313@gmail.com");
		requestParam.put("password", "pedro1313");
		requestParam.put("phone", "998671313");
		requestParam.put("userStatus", "0");
		 httRequest.header("Content-Type","application/json"); 
		 httRequest.body(requestParam.toJSONString());
		 //Response objeto
		 Response response=httRequest.request(Method.POST,"/user");
		 //validar o retorno corpo e argumento pra validar
		 String corpo= response.getBody().asString();
		 System.out.print("\n"+corpo);
		 
		 String sucessoCode= response.jsonPath().getString("code");
		 assertEquals("200", sucessoCode);
		 System.out.print("\n"+sucessoCode);
	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void postInserirPets() {
		//Especificação Base da URL 
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		//Setar o Obrjeto (REquest) 
		RequestSpecification httRequest=RestAssured.given();
		
		//Montar o json pra inserir
		JSONObject requestParam =new JSONObject();		
		requestParam.put("id", "1");
		//requestParam.put("category", "{'id':'0','name':'string'}");
		requestParam.put("name", "Snoopy");
		//requestParam.put("photoUrls", "");
		//requestParam.put("tags", "");
		requestParam.put("status", "disponível");
		httRequest.header("Content-Type","application/json"); 
		httRequest.body(requestParam.toJSONString());
		 //Response objeto
		Response response=httRequest.request(Method.POST,"/pet");
		 //validar o retorno corpo e argumento pra validar
		String corpo= response.getBody().asString();
		System.out.print("\n"+corpo);
		 
		String sucessoCode= response.jsonPath().getString("id");
		assertEquals("1", sucessoCode);
		System.out.print("\n"+sucessoCode);
	
	}
}
