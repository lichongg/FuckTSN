package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v extends a3<String, String> {

    /* renamed from: t, reason: collision with root package name */
    private String f8548t;

    @Override // com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    private static String i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String v5 = r4.v(jSONObject, "code");
            String v6 = r4.v(jSONObject, CrashHianalyticsData.MESSAGE);
            if ("1".equals(v5)) {
                return r4.v(jSONObject, "transfer_url");
            }
            if ("0".equals(v5)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, v6);
            }
            if ("2".equals(v5)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, v6);
            }
            if ("3".equals(v5)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, v6);
            }
            if ("4".equals(v5)) {
                throw new AMapException("用户签名未通过", 0, v6);
            }
            if ("5".equals(v5)) {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, v6);
            }
            return null;
        } catch (JSONException e6) {
            j4.i(e6, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.f8548t));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.f8548t);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a6 = g1.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a6.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = g0.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e6) {
            j4.i(e6, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", d1.f(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    public v(Context context, String str) {
        super(context, str);
        this.f8548t = str;
    }

    @Override // com.amap.api.col.s.a3
    protected final /* synthetic */ String I(String str) throws AMapException {
        return i(str);
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.h();
    }
}
