package TesteApi;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Teste1_GET_Request {

	
	@org.junit.Test
	public void getPraPegarDetalhes() {
		
		//Especificação Base da URL
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		
		//Setar o Obrjeto (REquest) 
		RequestSpecification httRequest=RestAssured.given();
		
		//Response Objeto (pegar o objeto)
		Response response=httRequest.request(Method.GET,"/Hyderabad");
		
		//imprimir pra ver o q retornou
		String responseBody = response.getBody().asString();
		System.out.print(responseBody);
		
		//validar codigo Validation
		int statusCodode = response.getStatusCode();
		System.out.print("\n Status: "+statusCodode);
		assertEquals(200, statusCodode);
		
		//validar codigo Validation
		String statusLine = response.getStatusLine();
		System.out.print("\n Status de line: "+statusLine);
		assertEquals(200, statusCodode);
		
	
	}

}
