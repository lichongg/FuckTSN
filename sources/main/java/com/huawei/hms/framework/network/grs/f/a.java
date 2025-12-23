package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected u1.a f33425a;

    /* renamed from: b, reason: collision with root package name */
    protected List<u1.b> f33426b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f33427c = false;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f33428d = false;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f33429e = new HashSet(16);

    public String b(Context context, o1.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z5) {
        Map<String, String> e6 = e(context, aVar, grsBaseInfo, str, z5);
        if (e6 != null) {
            return e6.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public abstract int i(String str);

    public abstract int m(String str);

    public int p(String str) {
        try {
            l(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e6) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    public abstract int q(String str);

    private Map<String, String> f(List<u1.b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (u1.b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.d());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.d());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.d());
            }
            if (bVar.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.d());
            }
        }
        return concurrentHashMap;
    }

    int a(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(GrsApp.getInstance().getBrand("/"));
        sb.append(str);
        return j(sb.toString(), context) != 0 ? -1 : 0;
    }

    public List<u1.b> d(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                u1.b bVar = new u1.b();
                bVar.e(jSONObject.getString("id"));
                bVar.f(jSONObject.getString(CommonNetImpl.NAME));
                bVar.b(jSONObject.getString(SocialConstants.PARAM_COMMENT));
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                        hashSet.add((String) jSONArray2.get(i7));
                    }
                    bVar.c(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e6) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return new ArrayList();
        }
    }

    public Map<String, String> e(Context context, o1.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z5) {
        u1.a aVar2 = this.f33425a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        u1.c b6 = aVar2.b(str);
        if (b6 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b7 = e.b(context, aVar, b6.e(), grsBaseInfo, z5);
        if (b7 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", b6.e());
            return null;
        }
        List<u1.b> a6 = b6.a();
        u1.d b8 = b6.b((a6 == null || a6.size() == 0) ? c(b7) : f(a6, grsBaseInfo, b7).get(b7));
        if (b8 == null) {
            return null;
        }
        return b8.a();
    }

    public u1.a g() {
        return this.f33425a;
    }

    public void h(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            Logger.d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + str);
            if (TextUtils.isEmpty(str) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", str);
            } else {
                if (s(r1.c.a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.w("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public Set<String> k() {
        return this.f33429e;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void l(org.json.JSONArray r15) {
        /*
            r14 = this;
            if (r15 == 0) goto Lf6
            int r0 = r15.length()
            if (r0 != 0) goto La
            goto Lf6
        La:
            r0 = 0
            r1 = 0
        Lc:
            int r2 = r15.length()
            if (r1 >= r2) goto Lf6
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            u1.c r3 = new u1.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.f(r4)
            java.util.Set<java.lang.String> r5 = r14.f33429e
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto Lf2
            java.util.Set<java.lang.String> r5 = r14.f33429e
            r5.add(r4)
            boolean r5 = r14.f33428d
            if (r5 == 0) goto Lf2
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.g(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = 0
        L45:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto Lbf
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            u1.d r9 = new u1.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L65
        L60:
            java.lang.String r8 = r7.getString(r10)
            goto L7a
        L65:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L6e
            goto L60
        L6e:
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r0] = r4
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L7a:
            r9.b(r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L8e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb2
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L8e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L8e
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L8e
        Lb2:
            r9.c(r8)
            java.lang.String r7 = r9.d()
            r3.c(r7, r9)
            int r6 = r6 + 1
            goto L45
        Lbf:
            java.lang.String r5 = "countryOrAreaGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto Ld0
        Lc7:
            org.json.JSONArray r2 = r2.getJSONArray(r5)
            java.util.List r2 = r14.d(r2)
            goto Ldf
        Ld0:
            java.lang.String r5 = "countryGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto Ld9
            goto Lc7
        Ld9:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.i(r8, r2)
            r2 = 0
        Ldf:
            r3.d(r2)
            u1.a r2 = r14.f33425a
            if (r2 != 0) goto Led
            u1.a r2 = new u1.a
            r2.<init>()
            r14.f33425a = r2
        Led:
            u1.a r2 = r14.f33425a
            r2.d(r4, r3)
        Lf2:
            int r1 = r1 + 1
            goto Lc
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.l(org.json.JSONArray):void");
    }

    public boolean n() {
        return this.f33427c;
    }

    public int o(String str) {
        JSONArray jSONArray;
        this.f33426b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f33426b.addAll(d(jSONArray));
            return 0;
        } catch (JSONException e6) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e6.getMessage()));
            return -1;
        }
    }

    private int j(String str, Context context) {
        if (r(r1.c.a(str, context)) == 0) {
            Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
            return 0;
        }
        return -1;
    }

    private int r(String str) {
        int m6;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f33428d && (m6 = m(str)) != 0) {
            return m6;
        }
        int i6 = i(str);
        if (i6 != 0) {
            return i6;
        }
        return q(str);
    }

    private int s(String str) {
        List<u1.b> list;
        int o5;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f33428d && (((list = this.f33426b) == null || list.isEmpty()) && (o5 = o(str)) != 0)) {
            return o5;
        }
        return p(str);
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<u1.b> list = this.f33426b;
        if (list != null && !list.isEmpty()) {
            for (u1.b bVar : this.f33426b) {
                if (bVar.a().contains(str)) {
                    return bVar.d();
                }
            }
        }
        return null;
    }
}
