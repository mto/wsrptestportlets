/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.gatein.example.portlets.wsrp;

import org.gatein.example.portlets.wsrp.event.SampleEvent;
import java.io.IOException;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 2/17/11
 */
public class WSRPSecondPortlet extends GenericPortlet
{
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      PortletRequestDispatcher rqDispatcher = getPortletContext().getRequestDispatcher("/jsp/secondPortlet/view.jsp");
      rqDispatcher.include(request, response);
   }

   @Override
   public void processEvent(EventRequest request, EventResponse response)
   {
      Event event = request.getEvent();
      System.out.println("Processing event on second portlet: " + event.getQName().toString());
      SampleEvent sampleEvent = (SampleEvent)event.getValue();
      //Make the wrapped value available to RenderRequest
      String wrappedValue = sampleEvent.getWrappedValue();
      if(wrappedValue == null || wrappedValue.length() == 0 )
      {
         wrappedValue = "No user input while user fired WSRPSampleEvent";
      }

      response.setRenderParameter("WSRPSampleEventValue", sampleEvent.getWrappedValue());
   }
}
