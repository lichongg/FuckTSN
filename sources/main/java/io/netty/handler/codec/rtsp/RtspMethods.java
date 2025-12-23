package io.netty.handler.codec.rtsp;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.http.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RtspMethods {
    public static final HttpMethod ANNOUNCE;
    public static final HttpMethod DESCRIBE;
    public static final HttpMethod GET_PARAMETER;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PAUSE;
    public static final HttpMethod PLAY;
    public static final HttpMethod RECORD;
    public static final HttpMethod REDIRECT;
    public static final HttpMethod SETUP;
    public static final HttpMethod SET_PARAMETER;
    public static final HttpMethod TEARDOWN;
    private static final Map<String, HttpMethod> methodMap;

    static {
        HttpMethod httpMethod = HttpMethod.OPTIONS;
        OPTIONS = httpMethod;
        HttpMethod valueOf = HttpMethod.valueOf("DESCRIBE");
        DESCRIBE = valueOf;
        HttpMethod valueOf2 = HttpMethod.valueOf("ANNOUNCE");
        ANNOUNCE = valueOf2;
        HttpMethod valueOf3 = HttpMethod.valueOf("SETUP");
        SETUP = valueOf3;
        HttpMethod valueOf4 = HttpMethod.valueOf("PLAY");
        PLAY = valueOf4;
        HttpMethod valueOf5 = HttpMethod.valueOf("PAUSE");
        PAUSE = valueOf5;
        HttpMethod valueOf6 = HttpMethod.valueOf("TEARDOWN");
        TEARDOWN = valueOf6;
        HttpMethod valueOf7 = HttpMethod.valueOf("GET_PARAMETER");
        GET_PARAMETER = valueOf7;
        HttpMethod valueOf8 = HttpMethod.valueOf("SET_PARAMETER");
        SET_PARAMETER = valueOf8;
        HttpMethod valueOf9 = HttpMethod.valueOf("REDIRECT");
        REDIRECT = valueOf9;
        HttpMethod valueOf10 = HttpMethod.valueOf("RECORD");
        RECORD = valueOf10;
        HashMap hashMap = new HashMap();
        methodMap = hashMap;
        hashMap.put(valueOf.toString(), valueOf);
        hashMap.put(valueOf2.toString(), valueOf2);
        hashMap.put(valueOf7.toString(), valueOf7);
        hashMap.put(httpMethod.toString(), httpMethod);
        hashMap.put(valueOf5.toString(), valueOf5);
        hashMap.put(valueOf4.toString(), valueOf4);
        hashMap.put(valueOf10.toString(), valueOf10);
        hashMap.put(valueOf9.toString(), valueOf9);
        hashMap.put(valueOf3.toString(), valueOf3);
        hashMap.put(valueOf8.toString(), valueOf8);
        hashMap.put(valueOf6.toString(), valueOf6);
    }

    public static HttpMethod valueOf(String str) {
        if (str == null) {
            throw new NullPointerException(CommonNetImpl.NAME);
        }
        String upperCase = str.trim().toUpperCase();
        if (upperCase.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        HttpMethod httpMethod = methodMap.get(upperCase);
        return httpMethod != null ? httpMethod : HttpMethod.valueOf(upperCase);
    }

    private RtspMethods() {
    }
}
