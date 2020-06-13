package TesteApi;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Teste2_Post_Request {
	
	@SuppressWarnings("unchecked")
	@Test
	public void postInserirDados() throws Exception {
		
		//Especificação Base da URL 
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		
		//Setar o Obrjeto (REquest) 
		RequestSpecification httRequest=RestAssured.given();
		
		
		//Montar o json pra inserir
		JSONObject requestParam =new JSONObject();
				
		requestParam.put("FirstName", "pedro1314");
		requestParam.put("LastName", "pedro1314");
		requestParam.put("UserName", "pedro1314");
		requestParam.put("Password", "pedro1314");
		requestParam.put("Email", "pedro1314@gmail.com");
		
		 httRequest.header("Content-Type","application/json");
		 
		 httRequest.body(requestParam.toJSONString());
		 
		 //Response objeto
		 Response response=httRequest.request(Method.POST,"/register");
		
		 
		 //validar o retorno corpo e argumento pra validar
		 String corpo= response.getBody().asString();
		 System.out.print("\n"+corpo);
		 
		 String sucessoCode= response.jsonPath().getString("SuccessCode");
		 assertEquals("OPERATION_SUCCESS", sucessoCode);
		 System.out.print("\n"+sucessoCode);
	
	}
}
