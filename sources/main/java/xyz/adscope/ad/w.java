package xyz.adscope.ad;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class w implements r3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56030a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, q3> f56031b = a();

    private Map<String, q3> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("AttentionListUpdater", new e1(this.f56030a));
        hashMap.put("InvokeRequestByUpdate", new p4(this.f56030a));
        hashMap.put("LocalTemplateUpdater", new q4(this.f56030a));
        return hashMap;
    }

    w(Context context) {
        this.f56030a = context;
    }

    @Override // xyz.adscope.ad.r3
    public void a(String str) {
        if (str.equals("plugins_all")) {
            Map<String, q3> map = this.f56031b;
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator<q3> it = this.f56031b.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            return;
        }
        Map<String, q3> map2 = this.f56031b;
        if (map2 == null || map2.get(str) == null) {
            return;
        }
        q3 q3Var = this.f56031b.get(str);
        Objects.requireNonNull(q3Var);
        q3Var.a();
    }
}
