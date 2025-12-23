package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fp implements com.kwad.sdk.core.d<HttpDnsInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        a2(httpDnsInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        return b2(httpDnsInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        httpDnsInfo.recommendList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("recommendList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                HttpDnsInfo.IpInfo ipInfo = new HttpDnsInfo.IpInfo();
                ipInfo.parseJson(optJSONArray.optJSONObject(i6));
                httpDnsInfo.recommendList.add(ipInfo);
            }
        }
        httpDnsInfo.backUpList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("backUpList");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                HttpDnsInfo.IpInfo ipInfo2 = new HttpDnsInfo.IpInfo();
                ipInfo2.parseJson(optJSONArray2.optJSONObject(i7));
                httpDnsInfo.backUpList.add(ipInfo2);
            }
        }
        httpDnsInfo.otherList = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("otherList");
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                HttpDnsInfo.IpInfo ipInfo3 = new HttpDnsInfo.IpInfo();
                ipInfo3.parseJson(optJSONArray3.optJSONObject(i8));
                httpDnsInfo.otherList.add(ipInfo3);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "recommendList", httpDnsInfo.recommendList);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "backUpList", httpDnsInfo.backUpList);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "otherList", httpDnsInfo.otherList);
        return jSONObject;
    }
}
