package Contoh.ServerWebService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(serviceName = "LVOWebServiceSend", targetNamespace = "http://gogon.com/kirimListShinobi")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class WSServer {
	// @WebMethod
	// public List<csvObject> sendSync(
	// @WebParam(name = "SHINOBI") List<csvObject> o) {
	//
	// for (Iterator<csvObject> iterator = o.iterator(); iterator.hasNext();) {
	// csvObject csvObject = (csvObject) iterator.next();
	// csvObject.setNama("BERHASIL");
	// }
	// return o;
	// }

	// ===========================================================================

	// @WebMethod(action = "sendSync")
	// @WebResult(targetNamespace = "")
	// @RequestWrapper(localName = "sendSync", targetNamespace =
	// "http://apaajadech.com/", className =
	// "com.apaajah.webservice.server.SendSync")
	// @ResponseWrapper(localName = "sendSyncResponse", targetNamespace =
	// "http://server.webservice.gelo.test.com/", className =
	// "com.convergys.lvo.webservice.server.SendSyncResponse")
	// public LvoWebSyncCallbackReply sendSync(
	// @WebParam(name = "eventId", targetNamespace = "") String eventId,
	// @WebParam(name = "eventData", targetNamespace = "") List<String>
	// eventData,
	// @WebParam(name = "timeout", targetNamespace = "") long timeout) {
	//
	// return new LvoWebSyncCallbackReply(eventId, eventData, timeout);
	// }

	// ==============================================================================

	@WebMethod(action = "sendSync")
	@WebResult(targetNamespace = "")
	// @RequestWrapper(localName = "sendSync", targetNamespace =
	// "http://apaajadech.com/", className =
	// "com.apaajah.webservice.server.SendSync")
	@RequestWrapper(localName = "sendSync", targetNamespace = "http://apaajadech.com/")
	@ResponseWrapper(localName = "sendSyncResponse", targetNamespace = "http://server.webservice.gelo.test.com/", className = "com.convergys.lvo.webservice.server.SendSyncResponse")
	public List<LvoWebSyncCallbackReply> sendSync(
	// public String sendSync(
			@WebParam(name = "ShinobiRequest", targetNamespace = "") List<ShinobiRequest> lsr) {

		// ====================================================
		List<LvoWebSyncCallbackReply> jojon = new ArrayList<LvoWebSyncCallbackReply>();
		for (Iterator iterator = lsr.iterator(); iterator.hasNext();) {
			ShinobiRequest aa = (ShinobiRequest) iterator.next();
			jojon.add(new LvoWebSyncCallbackReply(aa.getEventId(), aa.getId(),
					aa.getNama(), aa.getLevel(), aa.getJutsu(), aa.getDesa(),
					aa.getTimeout()));
		}
		// ====================================================

		return jojon;
	}

}
