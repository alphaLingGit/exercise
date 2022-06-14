package com.itjoin.pro_netty.constant;

import com.itjoin.pro_netty.util.PropertyUtil;

public class Constants {
    public static final String SERVER_PATH = "/netty";
    public static int PORT;
    public static String ZOOKEEPER_URL;
    public static int WEIGHT;

    static {
        PORT = PropertyUtil.getInt("server.port");
        ZOOKEEPER_URL = PropertyUtil.getString("zookeeper.url");
        WEIGHT = PropertyUtil.getInt("server.weight");
    }
}
