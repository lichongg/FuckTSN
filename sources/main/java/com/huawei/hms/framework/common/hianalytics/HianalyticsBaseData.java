package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class HianalyticsBaseData {
    public static final String EVENT_ID = "url_request";
    public static final int FALSE = 0;
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    public static final int TRUE = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final String f33364b = "HianalyticsBaseData";

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f33365a;

    public HianalyticsBaseData put(String str, String str2) {
        if (str != null && str2 != null) {
            this.f33365a.put(str, str2);
            return this;
        }
        Logger.v(f33364b, "key = " + str + " : value = " + str2);
        return this;
    }

    public LinkedHashMap<String, String> get() {
        return this.f33365a;
    }

    public HianalyticsBaseData putIfNotDefault(String str, long j6, long j7) {
        return j6 == j7 ? this : put(str, j6);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : get().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e6) {
            Logger.w(f33364b, "catch JSONException", e6);
        }
        return jSONObject.toString();
    }

    public HianalyticsBaseData() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        this.f33365a = linkedHashMap;
        linkedHashMap.put("sdk_type", "UxPP");
        this.f33365a.put(SDK_NAME, "networkkit");
    }

    public HianalyticsBaseData put(String str, long j6) {
        if (str == null) {
            Logger.v(f33364b, "key = null : value = " + j6);
            return this;
        }
        this.f33365a.put(str, "" + j6);
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            this.f33365a.putAll(linkedHashMap);
            return this;
        }
        Logger.v(f33364b, "data is null");
        return this;
    }
}
