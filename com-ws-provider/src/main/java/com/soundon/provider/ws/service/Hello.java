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
package com.soundon.provider.ws.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.soundon.provider.model.dto.Greeting;
import com.soundon.provider.model.dto.Person;

//--------------------------------------------------------------------------------------------------------------------------
//1	 @WebService 注释用于将 Java 类标记为实现 Web Service 或者将服务端点接口 (SEI) 标记为实现 Web Service 接口。
//2  name  wsdl:portType 的名称。缺省值为 Java 类或接口的非限定名称。（字符串）
//3  targetNamespace  指定从 Web Service 生成的 WSDL 和 XML 元素的 XML 名称空间。缺省值为从包含该 Web Service 的包名映射的名称空间。（字符串）
//4  serviceName  指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。（字符串）
//5  endpointInterface  指定用于定义服务的抽象 Web Service 约定的服务端点接口的限定名。如果指定了此限定名，那么会使用该服务端点接口来确定抽象 WSDL 约定。（字符串）
//6  portName  wsdl:portName。缺省值为 WebService.name+Port。（字符串）
//7  wsdlLocation  指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对地址或绝对地址。（字符串）
//--------------------------------------------------------------------------------------------------------------------------
@WebService(targetNamespace = "http://service.ws.sample/", name = "Hello")
public interface Hello {
	// --------------------------------------------------------------------------------------------------------------------------
	// @WebMethod 注释用于表示作为一项 Web Service 操作的方法。 将此注释应用于客户机或服务器服务端点接口 (SEI)
	// 上的方法，或者应用于服务器端点实现类。
	// - operationName 指定与此方法相匹配的 wsdl:operation 的名称。缺省值为 Java 方法的名称。（字符串）
	// - action 定义此操作的行为。对于 SOAP 绑定，此值将确定 SOAPAction 头的值 ，且必须显式设置 。
	// - exclude 指定是否从 Web Service 中排除某一方法。缺省值为 false。（布尔值）
	// --------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------------------------------------------------
	// @WebParam 注释用于定制从单个参数至 Web Service 消息部分和 XML 元素的映射。	将此注释应用于客户机或服务器服务端点接口 (SEI) 上的方法，或者应用于服务器端点实现类。
	// - name 	参数的名称。如果操作是远程过程调用 (RPC) 类型并且未指定 partName 属性，那么这是用于表示参数的 wsdl:part 属性的名称。如果操作是文档类型或者参数映射到某个头，那么 -name 是用于表示该参数的 XML 元素的局部名称。如果操作是文档类型、参数类型为 BARE 并且方式为 OUT 或 INOUT，那么必须指定此属性。（字符串）
	// - partName 	定义用于表示此参数的 wsdl:part 属性的名称。仅当操作类型为 RPC 或者操作是文档类型并且参数类型为 BARE 时才使用此参数。（字符串）
	// - targetNamespace 	指定参数的 XML 元素的 XML 名称空间。当属性映射到 XML 元素时，仅应用于文档绑定。缺省值为 Web Service 的 targetNamespace。（字符串）
	// - mode 	此值表示此方法的参数流的方向。有效值为 IN、INOUT 和 OUT。（字符串）
	// - header 	指定参数是在消息头还是消息体中。缺省值为 false。（布尔值）
	// --------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------------------------------------------------
	// @WebResult 注释用于定制从返回值至 WSDL 部件或 XML 元素的映射。	将此注释应用于客户机或服务器服务端点接口 (SEI) 上的方法，或者应用于服务器端点实现类。
	// - name 	当返回值列出在 WSDL 文件中并且在连接上的消息中找到该返回值时，指定该返回值的名称。对于 RPC 绑定，这是用于表示返回值的 wsdl:part 属性的名称。对于文档绑定，-name 参数是用于表示返回值的 XML 元素的局部名。对于 RPC 和 DOCUMENT/WRAPPED 绑定，缺省值为 return。对于 DOCUMENT/BARE 绑定，缺省值为方法名 + Response。（字符串）
	// - targetNamespace 			指定返回值的 XML 名称空间。仅当操作类型为 RPC 或者操作是文档类型并且参数类型为 BARE 时才使用此参数。（字符串）
	// - header 			指定头中是否附带结果。缺省值为 false。（布尔值）
	// - partName 			指定 RPC 或 DOCUMENT/BARE 操作的结果的部件名称。缺省值为 @WebResult.name。（字符串）
	// --------------------------------------------------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------------------------------------------------
	// @SOAPBinding 注释用于指定 Web Service 与 SOAP 消息协议之间的映射。	将此注释应用于客户机或服务器服务端点接口 (SEI) 上的类型或方法，或者应用于服务器端点实现类。
	//  方法级别的注释仅限于它可以指定的对象，仅当 style 属性为 DOCUMENT 时才使用该注释。如果未指定方法级别的注释，那么将使用类型的 @SOAPBinding 行为。
	// - style 	定义发送到 Web Service 和来自 Web Service 的消息的编码样式。有效值为 DOCUMENT 和 RPC。缺省值为 DOCUMENT。（字符串）
	// - use 	定义用于发送到 Web Service 和来自 Web Service 的消息的格式。缺省值为 LITERAL。不支持 ENCODED。（字符串）
	// - parameterStyle 	确定方法的参数是否表示整个消息体，或者参数是否是封装在执行操作之后命名的顶级元素中的元素。有效值为 WRAPPED 或 BARE。对于 DOCUMENT 类型的绑定只能使用 BARE 值。缺省值为 WRAPPED。（字符串）
	// --------------------------------------------------------------------------------------------------------------------------

	
	Greeting sayHello(@WebParam(name ="person") Person person);
}
