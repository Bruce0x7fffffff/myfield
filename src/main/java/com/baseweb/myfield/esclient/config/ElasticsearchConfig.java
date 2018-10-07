package com.baseweb.myfield.esclient.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;

public class ElasticsearchConfig {
    public final static Client client = build();

    private static Client build() {
        if(null != client){
            return client;
        }
        Client client = null;
        try {
            // 创建配置对象 myClusterName处为es集群名称
            Settings settings = Settings.settingsBuilder().put("cluster.name", "myClusterName").build();
            // 创建客户端 host1,host2处为es集群节点的ip地址
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("118.24.78.36"), 9300));
        } catch (Exception e) {
            System.out.println("创建客户端异常" + e);
        }
        return client;
    }

    public static void close() {
        if (null != client) {
            try {
                client.close();
            } catch (Exception e) {
            }
        }
    }
}