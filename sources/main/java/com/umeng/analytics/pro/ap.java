package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.UMUtils;
import com.uyumao.sdk.UYMManager;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ap {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : UMEnvelopeBuild.imprintProperty(context, str, str2);
    }

    public static void a(Context context, String str) {
        try {
            Method declaredMethod = UYMManager.class.getDeclaredMethod("processEvent", Context.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.invoke(UYMManager.class, context, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(bi.bd, com.umeng.commonsdk.internal.a.f41751e);
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
            hashMap.put(bi.be, UMUtils.VALUE_ANALYTICS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
            hashMap.put(bi.bf, UMUtils.VALUE_GAME_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
            hashMap.put(bi.bg, UMUtils.VALUE_PUSH_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
            hashMap.put(bi.bh, UMUtils.VALUE_SHARE_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
            hashMap.put(bi.bi, UMUtils.VALUE_APM_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
            hashMap.put(bi.bj, UMUtils.VALUE_VERIFY_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
            hashMap.put(bi.bk, UMUtils.VALUE_SMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
            hashMap.put(bi.bl, UMUtils.VALUE_REC_VERSION_NAME);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
            hashMap.put(bi.bm, UMUtils.VALUE_VISUAL_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
            hashMap.put(bi.bn, UMUtils.VALUE_ASMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
            hashMap.put(bi.bo, UMUtils.VALUE_LINK_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
            hashMap.put(bi.bp, UMUtils.VALUE_ABTEST_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
            hashMap.put(bi.bq, UMUtils.VALUE_ANTI_VERSION);
        }
        return hashMap;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        String str;
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String valueOf = String.valueOf(keys.next());
                if (!TextUtils.isEmpty(valueOf) && (str = (String) jSONObject.get(valueOf)) != null) {
                    hashMap.put(valueOf, str);
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }
}
