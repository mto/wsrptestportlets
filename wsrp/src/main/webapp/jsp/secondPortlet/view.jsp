<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects/>

<div>The WSRPSecondPortlet portlet</div>
<br/>
<hr/>
<br/>
<div>Display the Public Render Parameter sharedPRPs</div>
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

<br/>
<hr/>
<br/>
<div>Display the value wrapped in the event fired by WSRPFirstPortlet, this value is available to RenderRequest
under the name WSRPSampleEventValue</div>
<br/>

<%
	String value = renderRequest.getParameter("WSRPSampleEventValue");

	if(value != null)
	{
	  out.println(value);
	}
	else
	{
	  out.println("WSRPSampleEvent was not fired by WSRPFirstPortlet");
  }
%>