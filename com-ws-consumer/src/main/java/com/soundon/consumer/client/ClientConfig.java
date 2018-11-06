package com.soundon.consumer.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample.ws.service.Hello;

@Configuration
public class ClientConfig {

  @Value("${client.hello.address}")
  private String address;

  @Bean(name = "helloProxy")
  public Hello helloProxy() {
    JaxWsProxyFactoryBean jaxWsProxyFactoryBean =
        new JaxWsProxyFactoryBean();
    jaxWsProxyFactoryBean.setServiceClass(Hello.class);
    jaxWsProxyFactoryBean.setAddress(address);

    return (Hello) jaxWsProxyFactoryBean.create();
  }
}
