package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f10674a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<a> f10675b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f10674a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.bi.az);
            if (optInt == 1) {
                String optString = jSONObject.optString(com.umeng.analytics.pro.bi.az);
                if (!TextUtils.isEmpty(optString)) {
                    String b6 = i.b(optString);
                    if (!TextUtils.isEmpty(b6)) {
                        optJSONArray = new JSONArray(b6);
                    }
                }
            }
            bVar.f10675b = a.a(optJSONArray);
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.f10675b;
    }
}
