/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.soundon.provider.ws.service.impl;

import com.soundon.provider.model.dto.Greeting;
import com.soundon.provider.model.dto.Person;
import com.soundon.provider.ws.service.Hello;

//1	 @WebService 注释用于将 Java 类标记为实现 Web Service 或者将服务端点接口 (SEI) 标记为实现 Web Service 接口。
//2  name  wsdl:portType 的名称。缺省值为 Java 类或接口的非限定名称。（字符串）
//3  targetNamespace  指定从 Web Service 生成的 WSDL 和 XML 元素的 XML 名称空间。缺省值为从包含该 Web Service 的包名映射的名称空间。（字符串）
//4  serviceName  指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。（字符串）
//5  endpointInterface  指定用于定义服务的抽象 Web Service 约定的服务端点接口的限定名。如果指定了此限定名，那么会使用该服务端点接口来确定抽象 WSDL 约定。（字符串）
//6  portName  wsdl:portName。缺省值为 WebService.name+Port。（字符串）
//7  wsdlLocation  指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对地址或绝对地址。（字符串）

@javax.jws.WebService(serviceName = "HelloService", portName = "HelloPort", targetNamespace = "http://service.ws.sample/", endpointInterface = "com.soundon.provider.ws.service.Hello")
public class HelloPortImpl implements Hello {

	// private static final Logger LOG =
	// Logger.getLogger(HelloPortImpl.class.getName());

	public Greeting sayHello(Person person) {

		try {
			String greeting = "Hello " + person.getFirstName() + " " + person.getLastName() + "!";

			Greeting response = new Greeting();

			response.setGreeting(greeting);

			return response;

		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
