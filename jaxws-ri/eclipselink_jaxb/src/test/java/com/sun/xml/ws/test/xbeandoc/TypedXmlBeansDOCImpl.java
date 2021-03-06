/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.xml.ws.test.xbeandoc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://www.openuri.org/")
public class TypedXmlBeansDOCImpl {
    /**
     *
     * @param param1
     * @param countries
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://www.openuri.org/getCountryName")
    @WebResult(name = "name", targetNamespace = "http://www.openuri.org/")
    @RequestWrapper(localName = "getCountryName", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryName")
    @ResponseWrapper(localName = "getCountryNameResponse", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryNameResponse")
    public String getCountryName(
//        @WebParam(name = "Countries", targetNamespace = "http://www.bea.com/wli/sb/transports/ejb/test/xbean")
        Countries countries,
//        @WebParam(name = "param1", targetNamespace = "http://www.openuri.org/")
        String param1) {
        return param1+countries.getCountry().size();
    }

    /**
     *
     * @param param0
     * @param param1
     * @return
     *     returns com.sun.xml.ws.test.xbeandoc.CountryInfoType
     */
    @WebMethod(action = "http://www.openuri.org/getCountryInfo")
    @WebResult(name = "CountryInfoType", targetNamespace = "http://www.openuri.org/")
    @RequestWrapper(localName = "getCountryInfo", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryInfo")
    @ResponseWrapper(localName = "getCountryInfoResponse", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryInfoResponse")
    public CountryInfoType getCountryInfo(
        @WebParam(name = "param0", targetNamespace = "http://www.openuri.org/")
        String param0,
        @WebParam(name = "param1", targetNamespace = "http://www.openuri.org/")
        String param1) {
        CountryInfoType ci = new CountryInfoType();
        ci.setCode(param0);
        ci.setName(param1);
        return ci;
    }

    /**
     *
     * @param param1
     * @param countries
     */
    @WebMethod(action = "http://www.openuri.org/addCountry")
    @RequestWrapper(localName = "addCountry", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.AddCountry")
    @ResponseWrapper(localName = "addCountryResponse", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.AddCountryResponse")
    public void addCountry(
//        @WebParam(mode = WebParam.Mode.INOUT)
        Holder<Countries> countries,
//        @WebParam(name = "param1", targetNamespace = "http://www.openuri.org/")
        CountryInfoType param1) {
        countries.value.getCountry().add(param1);
    }

    /**
     *
     * @param param1
     * @param countries
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://www.openuri.org/getCountryNameXml")
    @WebResult(name = "name", targetNamespace = "http://www.openuri.org/")
    @RequestWrapper(localName = "getCountryNameXml", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryNameXml")
    @ResponseWrapper(localName = "getCountryNameXmlResponse", targetNamespace = "http://www.openuri.org/", className = "com.sun.xml.ws.test.xbeandoc.GetCountryNameXmlResponse")
    public String getCountryNameXml(
//        @WebParam(name = "Countries", targetNamespace = "http://www.bea.com/wli/sb/transports/ejb/test/xbean")
        Countries countries,
        @WebParam(name = "param1", targetNamespace = "http://www.openuri.org/")
        String param1) {
        return param1;
    }
}
