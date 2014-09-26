package Contoh.ServerWebService;

import javax.xml.ws.Endpoint;

public class JalankanWebService {
	public static void main(String[] sbargrgf) {

		String endpoint = "http://localhost:7777/WS/kirimListShinobi";

		System.out.println("Menjalankan WS...");
		Endpoint.publish(endpoint, new WSServer());
		System.out.println("WS jalan...");
	}
}
