package Contoh.ClientWebService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import Contoh.ServerWebService.csvObject;

public class ClientWS {
	
	public static void main(String[] dd) throws IOException {

		// Kita kirimkan List yang berisi 100 baris
		int jumlahRecordYangDikirim = 3;

		List<csvObject> lsd = new ArrayList<csvObject>();
		lsd = ngisiListShinobi(jumlahRecordYangDikirim);
			// Kirim satu buah request berupa List yang berisi 100 baris
			new ClientWS().PostData(lsd);	
	}

	// Method ini hanya buat ngisi List saja (untuk keperluan contoh saja)
	// Pada kenyataannya harusnya List diisi di kelas ReadCSV
	private static List<csvObject> ngisiListShinobi(int jumlahRecord) {
		List<csvObject> lsd = new ArrayList<csvObject>();
		for (int i = 0; i < jumlahRecord; i++) {
			lsd.add(new csvObject("a" + i, "b" + i, "c" + i,
					"d" + i, "e" + i, i));
		}
		return lsd;
	}

	public void PostData(List<csvObject> node) throws IOException {
		int rowCount = node.size();
		System.out.println("ukuran list = " + node.size());

		try {
			// Nilai nameSpace ini disamakan dengan nilai
			// targetNamespace di kelas WSServer
			String nameSpace = "http://gogon.com/kirimListShinobi";

			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
					.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory
					.createConnection();

			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

			soapEnvelope.addNamespaceDeclaration("ns1", nameSpace);
			SOAPBody soapBody = soapEnvelope.getBody();
			SOAPElement soapElement = soapBody.addChildElement("sendSync",
					"ns1");

			for (int i = 0; i < rowCount; i++) {
				SOAPElement element0 = soapElement.addChildElement("SHINOBI");
				element0.addChildElement("ID").addTextNode(node.get(i).getId());
				element0.addChildElement("NAMA").addTextNode(
						node.get(i).getNama());
				element0.addChildElement("LEVEL").addTextNode(
						node.get(i).getLevel());
				element0.addChildElement("JUTSU").addTextNode(
						node.get(i).getJutsu());
				element0.addChildElement("DESA").addTextNode(
						node.get(i).getDesa());
				element0.addChildElement("COLUMNCOUNT").addTextNode("1000");

			}

			soapMessage.saveChanges();

			System.out.println("\n");
			System.out.println("----------SOAP Request------------");
			soapMessage.writeTo(System.out);
			//

			// SOAPMessage soapRequest = createSoapRequest();
			SOAPMessage soapRequest = soapMessage;

			// Nilai endpoint ini disamakan dengan
			// nilai endpoint pada kelas "JalankanWebService"
			String endpoint = "http://localhost:7777/WS/kirimListShinobi";
			SOAPMessage soapResponse = soapConnection.call(soapRequest,
					endpoint);
			createSoapResponse(soapResponse);

			soapConnection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void createSoapResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.println("\n");
		System.out.println("\n----------SOAP Response-----------");
		System.out.println("");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
		System.out.println("");
	}
}
