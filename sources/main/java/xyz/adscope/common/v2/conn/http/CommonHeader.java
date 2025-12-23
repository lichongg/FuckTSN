package xyz.adscope.common.v2.conn.http;

import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonHeader extends HashMap<String, String> {
    public static final String HEADER_KEY_ACCEPT = "Accept";
    public static final String HEADER_KEY_ACCEPT_ENCRYPT = "Accept-Encrypt";
    public static final String HEADER_KEY_CONNECTION = "Connection";
    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_KEY_LOCATION = "Location";
    public static final String HEADER_KEY_USER_AGENT = "User-Agent";
    public static final String HEADER_KEY_X_REQUEST = "X-Requested-With";
    public static final String HEADER_VALUE_ACCEPT_ALL = "*/*";
    public static final String HEADER_VALUE_APPLICATION_STREAM = "application/octet-stream";
    public static final String HEADER_VALUE_APPLICATION_URLENCODED = "application/json";
    public static final String HEADER_VALUE_KEEP_ALIVE = "keep-alive";

    public static CommonHeader obtainBasicHeader() {
        return new CommonHeader();
    }

    public CommonHeader() {
        put("Accept", "*/*");
        put("Content-Type", "application/json");
        put("Connection", "keep-alive");
    }
}
