package cn.jiguang.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.b> f3001a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3002b;

    /* renamed from: cn.jiguang.h.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3003a = new d(null);
    }

    private d() {
    }

    public static d a() {
        return a.f3003a;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(1300)) {
            return;
        }
        this.f3001a = cn.jiguang.common.app.helper.b.a(context, true, false);
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3002b = context;
        return "JAppPermission";
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        cn.jiguang.bb.f.c("JAppPermission", "for googlePlay:false");
        return cn.jiguang.g.a.a().e(1300);
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        ArrayList<JSONArray> a6;
        if (!cn.jiguang.g.a.a().g(1300)) {
            List<cn.jiguang.common.app.entity.b> list = this.f3001a;
            if (list != null && list.size() != 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<cn.jiguang.common.app.entity.b> it = this.f3001a.iterator();
                    while (it.hasNext()) {
                        JSONObject b6 = it.next().b(128);
                        if (b6 != null) {
                            jSONArray.put(b6);
                        }
                    }
                    a6 = cn.jiguang.common.app.helper.b.a(jSONArray);
                } catch (Throwable unused) {
                }
                if (a6 != null && !a6.isEmpty()) {
                    int size = a6.size();
                    int i6 = 0;
                    while (i6 < size) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray2 = a6.get(i6);
                        i6++;
                        jSONObject.put("slice_index", i6);
                        jSONObject.put("slice_count", size);
                        jSONObject.put("pers_data", jSONArray2);
                        cn.jiguang.be.b.a(context, jSONObject, "android_permissions");
                        super.d(context, str);
                    }
                    this.f3001a = null;
                    return;
                }
                return;
            }
            cn.jiguang.bb.f.i("JAppPermission", "there are no data to report");
        }
    }
}
