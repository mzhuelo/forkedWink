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
package org.apache.wink.server.internal.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;

import jakarta.servlet.ServletContext;

import org.apache.wink.common.internal.utils.FileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletFileLoader extends FileLoader {

    private static final Logger logger = LoggerFactory.getLogger(ServletFileLoader.class);

    public static InputStream loadFileAsStream(ServletContext servletContext, String fileName)
        throws FileNotFoundException {
        if (fileName == null || fileName.trim().equals("")) { //$NON-NLS-1$
            throw new NullPointerException("fileName"); //$NON-NLS-1$
        }

        if (servletContext != null) {
            logger.trace("Searching for {} using servlet context.", fileName); //$NON-NLS-1$

            if (fileName.startsWith("/")) {  // protect against MalformedURLException //$NON-NLS-1$
                InputStream is = servletContext.getResourceAsStream(fileName);
                if (is != null) {
                    return is;
                }
            }
        }

        return FileLoader.loadFileAsStream(fileName);
    }
}
