package TesteApi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TstIcarros_GET_Request {

	
	@Test
	public void getIcarros() {
		
		//Especificação Base da URL
		RestAssured.baseURI="https://www.icarros.com.br";
		
		//Setar o Obrjeto (REquest) 
		RequestSpecification httRequest=RestAssured.given();
		
		//Response Objeto (pegar o objeto)
		Response response=httRequest.request(Method.GET,"/ache/listaanuncios.jsp?bid=0&opcaocidade=1&foa=1&anunciosNovos=1&anunciosUsados=1&marca1=0&modelo1=0&anomodeloinicial=0&anomodelofinal=0&precominimo=0&precomaximo=0&cidadeaberto=&escopo=2&locationSop=est_SP.1_-cid_9668.1_-esc_2.1_-rai_50.1_");
		
		//imprimir pra ver o q retornou
		String responseBody = response.getBody().asString();
		System.out.print(responseBody);
		
		//Validar Header
		String contentType= response.header("Content-Type");//capture detailes
		System.out.print(contentType);
		assertEquals("text/html;charset=utf-8", contentType);

		
	
	}

}
