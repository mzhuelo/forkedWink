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
package org.apache.wink.osgi;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.wink.server.internal.DeploymentConfiguration;
import org.apache.wink.server.internal.registry.ResourceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * This <code>Filter</code> handles request URIs for which
 * there is a matching Root Resource Class registered with the  
 * Apache Wink RequestProcessor and delegates the others to the chain.
 */
@Component(immediate = true, metatype = false)
@Service(value = jakarta.servlet.Filter.class)
@Properties({
	@Property(name ="pattern", value=".*")
})
public class JaxRsFilter implements Filter {

	private final static Logger log = LoggerFactory.getLogger(JaxRsFilter.class);
	
	@Reference
	private WinkRequestProcessor winkProvider;



	private boolean accepts(HttpServletRequest request) {
		DeploymentConfiguration deploymentConfiguration = winkProvider.getRequestProcessor().getConfiguration();
		ResourceRegistry resourceRegistry = deploymentConfiguration.getResourceRegistry();
		//FIXME: fix this to comply with externalization requirements
		//log.info("Checking acceptance of {}.", request.getRequestURI());
		return resourceRegistry.getMatchingRootResources(request.getRequestURI()).size() > 0;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//no initialization needed
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (((request instanceof HttpServletRequest) && accepts((HttpServletRequest)request))) {
			log.debug("processing request");
			winkProvider.handleRequest((HttpServletRequest)request, (HttpServletResponse)response);
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void destroy() {
		//not
	}


}
