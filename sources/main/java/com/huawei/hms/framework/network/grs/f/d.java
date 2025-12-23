package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d extends a {
    public d(Context context, String str, boolean z5) {
        this.f33428d = z5;
        if (a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.f33427c = true;
        }
    }

    public d(boolean z5, boolean z6) {
        this.f33428d = z6;
        this.f33427c = z5;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int i(String str) {
        this.f33425a = new u1.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f33425a.e(jSONObject.getString(CommonNetImpl.NAME));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    l(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e6) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int m(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.f33426b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                    u1.b bVar = new u1.b();
                    bVar.e(jSONObject2.getString("id"));
                    bVar.f(jSONObject2.getString(CommonNetImpl.NAME));
                    bVar.b(jSONObject2.getString(SocialConstants.PARAM_COMMENT));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                            hashSet.add((String) jSONArray2.get(i7));
                        }
                        bVar.c(hashSet);
                        this.f33426b.add(bVar);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e6) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int q(String str) {
        return p(str);
    }
}
