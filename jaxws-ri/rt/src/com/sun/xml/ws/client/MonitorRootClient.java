/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
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

package com.sun.xml.ws.client;

import com.sun.xml.ws.api.server.Container;
import com.sun.xml.ws.model.wsdl.WSDLServiceImpl;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.glassfish.external.amx.AMXGlassfish;
import org.glassfish.gmbal.AMXMetadata;
import org.glassfish.gmbal.Description;
import org.glassfish.gmbal.InheritedAttribute;
import org.glassfish.gmbal.InheritedAttributes;
import org.glassfish.gmbal.ManagedAttribute;
import org.glassfish.gmbal.ManagedData;
import org.glassfish.gmbal.ManagedObject;
import org.glassfish.gmbal.ManagedObjectManager;
import org.glassfish.gmbal.ManagedObjectManagerFactory;
import java.net.URL;

/**
 * @author Harold Carr
 */
@ManagedObject
@Description("Metro Web Service client")
@AMXMetadata(type="WSClient")
public final class MonitorRootClient extends com.sun.xml.ws.server.MonitorBase {

    private final Stub stub;

    MonitorRootClient(final Stub stub) {
        this.stub = stub;
    }

    /*
    private static final Logger logger = Logger.getLogger(
        com.sun.xml.ws.util.Constants.LoggingDomain + ".client.stub");
    */

    //
    // From WSServiceDelegate
    //

    @ManagedAttribute
    private Container getContainer() { return stub.owner.getContainer(); }

    @ManagedAttribute        
    private Map<QName, PortInfo> qnameToPortInfoMap() { return stub.owner.getQNameToPortInfoMap(); }

    @ManagedAttribute
    private QName serviceName() { return stub.owner.getServiceName(); }
        
    @ManagedAttribute
    private Class serviceClass() { return stub.owner.getServiceClass(); }
        
    @ManagedAttribute
    private URL wsdlDocumentLocation() { return stub.owner.getWSDLDocumentLocation(); }

    @ManagedAttribute
    private WSDLServiceImpl wsdlService() { return stub.owner.getWsdlService(); }

    
        
}