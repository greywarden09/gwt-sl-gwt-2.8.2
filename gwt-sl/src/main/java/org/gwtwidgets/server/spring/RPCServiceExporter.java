/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtwidgets.server.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Interface for RPC exporters.
 *
 * @author George Georgovassilis, g.georgovassilis[at]gmail.com
 */
public interface RPCServiceExporter extends Controller, InitializingBean, ServletContextAware, ServletConfigAware {

    /**
     * Set the service object to which RPCs should be delegated.
     *
     * @param service Service object to delegate to
     */
    void setService(Object service);

    /**
     * Declare Interfaces that will be bound to RPC
     *
     * @param interfaces Array of Interfaces
     */
    void setServiceInterfaces(Class<RemoteService>[] interfaces);

    /**
     * Set state of response caching
     *
     * @param caching caching
     */
    void setResponseCachingDisabled(boolean caching);

    /**
     * When enabled will throw exceptions which originate from the service and have not been
     * declared in the RPC interface back to the servlet container.
     *
     * @param throwUndeclaredExceptionToServletContainer True or false
     */
    void setThrowUndeclaredExceptionToServletContainer(boolean throwUndeclaredExceptionToServletContainer);

    /**
     * Specify whether {@link RemoteServiceServlet#checkPermutationStrongName} should be invoked
     * for the current request. Disabled by default for backwards compatibility with older SL versions.
     *
     * @param shouldCheckPermutationStrongName true or false
     */
    void setShouldCheckPermutationStrongName(boolean shouldCheckPermutationStrongName);

}
