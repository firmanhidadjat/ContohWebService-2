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

public class ClientWS2 {
	public static void main(String[] ssdaf) throws IOException {
		int jumlahRecordYangDikirim = 100;

		List<String> lsd = new ArrayList<String>();
		for (int i = 0; i < jumlahRecordYangDikirim; i++) {
			lsd.add("JOJON" + i);
		}
		
		new ClientWS2().PostData(lsd);

	}

	public void PostData(List<String> node) throws IOException {
		int rowCount = node.size();
		System.out.println("ukuran list = " + node.size());

		try {
			// Nilai nameSpace ini disamakan dengan nilai
			// targetNamespace di kelas WSServer
			String nameSpace = "http://apaajadech.com/";

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
			SOAPElement element0_1 = soapElement.addChildElement("eventId")
					.addTextNode("eventIDBEybeh");

			for (int i = 0; i < rowCount; i++) {
				SOAPElement element0 = soapElement.addChildElement("eventData")
						.addTextNode(i + node.get(i));
			}

			SOAPElement element0_2 = soapElement.addChildElement("timeout")
					.addTextNode("3000");

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
