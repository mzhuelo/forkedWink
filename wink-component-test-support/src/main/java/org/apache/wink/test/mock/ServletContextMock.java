/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *  
 *******************************************************************************/
package org.apache.wink.test.mock;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletRegistration.Dynamic;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.descriptor.JspConfigDescriptor;

@SuppressWarnings( {"deprecation", "rawtypes"})
public class ServletContextMock implements ServletContext {

    private final ServletContext servletContext;

    public ServletContextMock(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Object getAttribute(String arg0) {
        return servletContext.getAttribute(arg0);
    }

    public Enumeration getAttributeNames() {
        return servletContext.getAttributeNames();
    }

    public ServletContext getContext(String arg0) {
        return servletContext.getContext(arg0);
    }

    public String getInitParameter(String arg0) {
        return servletContext.getInitParameter(arg0);
    }

    public Enumeration getInitParameterNames() {
        return servletContext.getInitParameterNames();
    }

    public int getMajorVersion() {
        return servletContext.getMajorVersion();
    }

    public String getMimeType(String arg0) {
        return servletContext.getMimeType(arg0);
    }

    public int getMinorVersion() {
        return servletContext.getMinorVersion();
    }

    public RequestDispatcher getNamedDispatcher(String arg0) {
        return servletContext.getNamedDispatcher(arg0);
    }

    public String getRealPath(String arg0) {
        return servletContext.getRealPath(arg0);
    }

    public RequestDispatcher getRequestDispatcher(String arg0) {
        return servletContext.getRequestDispatcher(arg0);
    }

    public URL getResource(String arg0) throws MalformedURLException {
        return servletContext.getResource(arg0);
    }

    public InputStream getResourceAsStream(String arg0) {
        return servletContext.getResourceAsStream(arg0);
    }

    public Set getResourcePaths(String arg0) {
        return servletContext.getResourcePaths(arg0);
    }

    public String getServerInfo() {
        return servletContext.getServerInfo();
    }

    public Servlet getServlet(String arg0) throws ServletException {
        return servletContext.getServlet(arg0);
    }

    public String getServletContextName() {
        return servletContext.getServletContextName();
    }

    public Enumeration getServletNames() {
        return servletContext.getServletNames();
    }

    public Enumeration getServlets() {
        return servletContext.getServlets();
    }

    public void log(Exception arg0, String arg1) {
        servletContext.log(arg0, arg1);
    }

    public void log(String arg0, Throwable arg1) {
        servletContext.log(arg0, arg1);
    }

    public void log(String arg0) {
        servletContext.log(arg0);
    }

    public void removeAttribute(String arg0) {
        servletContext.removeAttribute(arg0);
    }

    public void setAttribute(String arg0, Object arg1) {
        servletContext.setAttribute(arg0, arg1);
    }
    
    public String getContextPath() {
        return servletContext.getContextPath();
    }

	public int getEffectiveMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEffectiveMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean setInitParameter(String name, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Dynamic addServlet(String servletName, String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dynamic addServlet(String servletName, Servlet servlet) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dynamic addJspFile(String servletName, String jspFile) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Servlet> T createServlet(Class<T> clazz) throws ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletRegistration getServletRegistration(String servletName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, ? extends ServletRegistration> getServletRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	public jakarta.servlet.FilterRegistration.Dynamic addFilter(String filterName, String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public jakarta.servlet.FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public jakarta.servlet.FilterRegistration.Dynamic addFilter(String filterName,
			Class<? extends Filter> filterClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Filter> T createFilter(Class<T> clazz) throws ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public FilterRegistration getFilterRegistration(String filterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionCookieConfig getSessionCookieConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
		// TODO Auto-generated method stub
		
	}

	public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addListener(String className) {
		// TODO Auto-generated method stub
		
	}

	public <T extends EventListener> void addListener(T t) {
		// TODO Auto-generated method stub
		
	}

	public void addListener(Class<? extends EventListener> listenerClass) {
		// TODO Auto-generated method stub
		
	}

	public <T extends EventListener> T createListener(Class<T> clazz) throws ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public JspConfigDescriptor getJspConfigDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void declareRoles(String... roleNames) {
		// TODO Auto-generated method stub
		
	}

	public String getVirtualServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSessionTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSessionTimeout(int sessionTimeout) {
		// TODO Auto-generated method stub
		
	}

	public String getRequestCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRequestCharacterEncoding(String encoding) {
		// TODO Auto-generated method stub
		
	}

	public String getResponseCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setResponseCharacterEncoding(String encoding) {
		// TODO Auto-generated method stub
		
	}

}
