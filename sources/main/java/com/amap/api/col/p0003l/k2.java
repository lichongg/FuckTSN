package com.amap.api.col.p0003l;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class k2 extends g2 {
    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    private static String e(String str) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(f(str2));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String f(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            v5.p(e6, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e7) {
            v5.p(e7, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ga.f6366c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "3dmap"));
        hashtable.put("x-INFO", h4.b(d.f5883f));
        hashtable.put("key", f4.j(d.f5883f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public k2() {
        setProxy(o4.c(d.f5883f));
        setConnectionTimeout(5000);
        setSoTimeout(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
    }

    protected String appendTsScode(String str) {
        String e6 = e(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a6 = h4.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a6)));
        stringBuffer.append("&scode=" + h4.c(d.f5883f, a6, e6));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getIPV6URL() {
        String url = getURL();
        if (url != null && url.contains("http://restsdk.amap.com/v4/gridmap?")) {
            return b3.y(url);
        }
        return url;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public boolean isSupportIPV6() {
        String url = getURL();
        if (url != null && url.contains("http://restsdk.amap.com/v4/gridmap?")) {
            return true;
        }
        return false;
    }
}
