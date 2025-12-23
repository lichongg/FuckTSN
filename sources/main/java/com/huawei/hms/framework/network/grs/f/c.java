package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c extends a {
    private List<u1.b> u(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                u1.b bVar = new u1.b();
                bVar.e(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.f(jSONObject2.getString(CommonNetImpl.NAME));
                bVar.b(jSONObject2.getString(SocialConstants.PARAM_COMMENT));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        hashSet.add((String) jSONArray.get(i6));
                    }
                    bVar.c(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e6) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return new ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int i(String str) {
        this.f33425a = new u1.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(CommonNetImpl.NAME);
            long j6 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f33425a.e(string);
            this.f33425a.c(j6);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e6) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int m(String str) {
        JSONObject jSONObject;
        this.f33426b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.f33426b.addAll(u(jSONObject));
            }
            return 0;
        } catch (JSONException e6) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:20:0x008f, B:21:0x00a5, B:23:0x00ab, B:25:0x00bf, B:32:0x00c5, B:36:0x00d8, B:47:0x0088, B:50:0x00ec, B:52:0x00f9, B:53:0x0108, B:54:0x0112, B:56:0x0119, B:57:0x0120, B:61:0x00fe, B:63:0x0104, B:64:0x010d), top: B:19:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0119 A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:20:0x008f, B:21:0x00a5, B:23:0x00ab, B:25:0x00bf, B:32:0x00c5, B:36:0x00d8, B:47:0x0088, B:50:0x00ec, B:52:0x00f9, B:53:0x0108, B:54:0x0112, B:56:0x0119, B:57:0x0120, B:61:0x00fe, B:63:0x0104, B:64:0x010d), top: B:19:0x008f }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int q(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.q(java.lang.String):int");
    }

    public List<u1.b> t(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : u(jSONObject);
    }

    public c(Context context, boolean z5) {
        this.f33428d = z5;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f33427c = true;
        }
    }
}
