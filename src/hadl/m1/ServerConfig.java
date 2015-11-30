package hadl.m1;

import hadl.m2.composant.Configuration;
import hadl.m2.liens.LienAttachmentFourniFrom;
import hadl.m2.liens.LienAttachmentToRequis;
import hadl.m2.liens.LienBindingRequis;
import hadl.m2.ports.PortConfigRequis;

public class ServerConfig extends Configuration {

	public ServerConfig() {
		addPortRequis(recReq);
		
		new LienBindingRequis(recReq, coMgr.getPortRequis("ExternalSocket"));
		
		new LienAttachmentFourniFrom(coMgr.getPortFourni("DBQuery"), sqlQuery.getRoleFrom("Caller"));
		new LienAttachmentToRequis(sqlQuery.getRoleTo("Called"), database.getPortRequis("QueryD"));
		
		new LienAttachmentFourniFrom(coMgr.getPortFourni("SecurityCheck"), clrReq.getRoleFrom("Caller"));
		new LienAttachmentToRequis(clrReq.getRoleTo("Called"), secMgr.getPortRequis("SecurityAuth"));
		
		new LienAttachmentFourniFrom(secMgr.getPortFourni("CheckQuery"), secQuery.getRoleFrom("Caller"));
		new LienAttachmentToRequis(secQuery.getRoleTo("Called"), database.getPortRequis("SecurityManagement"));
	}
	private PortConfigRequis recReq = new PortConfigRequis("ReceiveRequest");
	
	private Database database = new Database();
	private SecurityManager secMgr = new SecurityManager();
	private ConnectionManager coMgr = new ConnectionManager();
	
	private SecurityQuery secQuery = new SecurityQuery();
	private ClearanceRequest clrReq = new ClearanceRequest();
	private SQLQuery sqlQuery = new SQLQuery();
}
