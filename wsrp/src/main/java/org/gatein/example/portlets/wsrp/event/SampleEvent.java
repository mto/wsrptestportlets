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
package org.gatein.example.portlets.wsrp.event;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 2/17/11
 */
@XmlRootElement
public class SampleEvent implements Serializable
{
   private String wrappedValue;

   public SampleEvent()
   {
   }

   public void setWrappedValue(String _wrappedValue)
   {
      this.wrappedValue = _wrappedValue;
   }
   public String getWrappedValue()
   {
      return this.wrappedValue;
   }
}
