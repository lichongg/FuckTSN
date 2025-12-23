package com.huawei.hms.hatool;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class k implements v {

    /* renamed from: a, reason: collision with root package name */
    private String f33597a;

    /* renamed from: b, reason: collision with root package name */
    private String f33598b;

    /* renamed from: c, reason: collision with root package name */
    private String f33599c;

    /* renamed from: d, reason: collision with root package name */
    private List<f> f33600d;

    private void a() {
        l.d(y0.q(), "backup_event", q0.e(this.f33597a, this.f33599c, this.f33598b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<f> list = this.f33600d;
        if (list == null || list.size() == 0) {
            j1.j("hmsSdk", "failed events is empty");
            return;
        }
        if (h.c(y0.q(), "cached_v2_1", y0.s() * 1048576)) {
            j1.l("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f33598b);
            return;
        }
        String d6 = q0.d(this.f33597a, this.f33599c);
        List<f> list2 = i.f(y0.q(), "cached_v2_1", d6).get(d6);
        if (list2 != null && list2.size() != 0) {
            this.f33600d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = this.f33600d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().h());
            } catch (JSONException unused) {
                j1.l("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > y0.o() * 1048576) {
            j1.l("hmsSdk", "this failed data is too long,can not writing it");
            this.f33600d = null;
            return;
        }
        j1.j("hmsSdk", "data send failed, write to cache file...reqID:" + this.f33598b);
        l.g(y0.q(), "cached_v2_1", d6, jSONArray2);
        a();
    }

    public k(List<f> list, String str, String str2, String str3) {
        this.f33597a = str;
        this.f33598b = str2;
        this.f33599c = str3;
        this.f33600d = list;
    }
}
