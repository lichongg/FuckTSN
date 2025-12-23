package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private int f11072a;

    /* renamed from: b, reason: collision with root package name */
    private String f11073b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    n a6 = a(jSONArray.getJSONObject(i6));
                    if (a6 != null) {
                        arrayList.add(new CpuChannelResponse(a6));
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f11073b;
    }

    private static n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString(CommonNetImpl.NAME, "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        n nVar = new n();
        nVar.f11072a = optInt;
        nVar.f11073b = optString;
        return nVar;
    }

    public int a() {
        return this.f11072a;
    }
}
