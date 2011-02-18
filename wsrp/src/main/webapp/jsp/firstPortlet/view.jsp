<%@ page import="java.io.PrintWriter" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<portlet:defineObjects/>

<c:set var="fireSampleEventAction">
	<portlet:actionURL>
		<portlet:param name="javax.portlet.action" value="FireSampleEvent" />
	</portlet:actionURL>
</c:set>

<div>The First WSRP Portlet</div>
<hr/>
<br/>
<div>Fire SampleEvent event, with wrapped value is from user input</div>
<br/>

<form action="${fireSampleEventAction}" method="POST">
 Event Object Value:
 <input type="text" name="SampleEventValue" />
 <input type="submit" name="FireEvent" value="FireEvent"/>
</form>
<br/>

<hr/>
<br/>
<div>Inject Public Render Parameters, the name of PRP is sharedPRPs. We expecte that the PRP value
inject in InjectPRP Action Request is available to RenderRequest of both test portets</div>
<br/>

<c:set var="injectPRPAction">
	<portlet:actionURL>
		<portlet:param name="javax.portlet.action" value="InjectPRP" />
	</portlet:actionURL>
</c:set>


<form action="${injectPRPAction}" method="POST">
 PRP value:
 <input type="text" name="PRPValue"/>
 <input type="submit" name="InjectPRP" value="InjectPRP"/>
</form>

<hr/>
<br/>
<div>Display Public Render Parameters </div>
<br/>
<%
	String[] sharedPRPs = renderRequest.getPublicParameterMap().get("sharedPRPs");

  out.println("Value of PRPs available to current RenderRequest");

  if(sharedPRPs != null && sharedPRPs.length > 0)
  {
  	for(String sharedPRP : sharedPRPs)
  	{
    	out.println(sharedPRP);
  	}
  }
  else
  {
    out.println("Nothing is available");
  }
%>