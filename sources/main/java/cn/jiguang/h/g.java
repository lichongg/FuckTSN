package cn.jiguang.h;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3017a;

    /* renamed from: cn.jiguang.h.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f3018a = new g(null);
    }

    private g() {
    }

    public static g a() {
        return a.f3018a;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3017a = context;
        return "JAppSdk";
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        return cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT);
    }

    private JSONArray a(List<cn.jiguang.common.app.entity.b> list) {
        JSONObject d6;
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.common.app.entity.b bVar : list) {
            if (bVar.f2832f != 0 && (d6 = bVar.d(128)) != null) {
                jSONArray.put(d6);
            }
        }
        return jSONArray;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        String str2;
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT)) {
            return;
        }
        cn.jiguang.bb.f.c("JAppSdk", "doBusiness");
        try {
            List<cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(context, true, false);
            if (a6 != null && !a6.isEmpty()) {
                JSONArray a7 = a(a6);
                if (a7 != null && a7.length() != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", a7);
                    cn.jiguang.be.b.a(context, jSONObject, "app_sdk");
                    super.d(context, str);
                    return;
                }
                str2 = "there are no third applist ";
                cn.jiguang.bb.f.i("JAppSdk", str2);
            }
            str2 = "there are no data to report";
            cn.jiguang.bb.f.i("JAppSdk", str2);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JAppSdk", "package json exception:" + th.getMessage());
        }
    }
}
