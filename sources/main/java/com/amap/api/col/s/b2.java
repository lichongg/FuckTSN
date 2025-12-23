package com.amap.api.col.s;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b2 {
    private static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2, String str3) throws Exception {
        return d(e(str3 + ContainerUtils.FIELD_DELIMITER, str.toUpperCase() + "&%2F&" + a(str2))).replace(ContainerUtils.KEY_VALUE_DELIMITER, "%3D");
    }

    public static String c(Map<String, String> map, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("AccessKeyId", str);
        treeMap.put("SignatureMethod", "HMAC-SHA1");
        treeMap.put("SignatureVersion", "1.0");
        treeMap.put("SignatureNonce", UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        treeMap.put(RtspHeaders.Names.TIMESTAMP, simpleDateFormat.format(date));
        treeMap.putAll(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + a((String) entry.getValue()));
        }
        StringBuilder sb = new StringBuilder("");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        return sb.toString().substring(0, r3.length() - 1);
    }

    private static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    private static byte[] e(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "UTF-8"));
        return mac.doFinal(str2.getBytes("UTF-8"));
    }
}
