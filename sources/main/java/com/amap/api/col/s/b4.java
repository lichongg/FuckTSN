package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b4<T, V> extends a3<T, V> {
    @Override // com.amap.api.col.s.a3
    protected abstract V I(String str) throws AMapException;

    @Override // com.amap.api.col.s.a3
    protected abstract String M();

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public Map<String, String> o() {
        return null;
    }

    private static String S(String str) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(T(str2));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String T(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            j4.i(e6, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e7) {
            j4.i(e7, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    protected static String i(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            j4.i(e6, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e7) {
            j4.i(e7, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", a1.b(this.f7866q));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public b4(Context context, T t5) {
        super(context, t5);
    }

    @Override // com.amap.api.col.s.dz
    public byte[] q() {
        try {
            String M = M();
            StringBuffer stringBuffer = new StringBuffer();
            if (M != null) {
                stringBuffer.append(M);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String S = S(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a6 = a1.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a6)));
            stringBuffer3.append("&scode=" + a1.c(this.f7866q, a6, S));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            j4.i(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
