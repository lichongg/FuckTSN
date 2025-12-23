package cn.jiguang.r;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends cn.jiguang.m.a {

    /* renamed from: cn.jiguang.r.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3212a = new d(null);
    }

    private d() {
    }

    public static d a() {
        return a.f3212a;
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        return "JDeviceIdMap";
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        cn.jiguang.bb.f.c("JDeviceIdMap", "doBusiness: " + str);
        super.c(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        cn.jiguang.bb.f.c("JDeviceIdMap", "report: " + str);
        if (cn.jiguang.g.a.a().g(1030)) {
            cn.jiguang.bb.f.c("JDeviceIdMap", "report device id map is not enabled");
            return;
        }
        String E = cn.jiguang.bz.a.a().E(context);
        String F = cn.jiguang.bz.a.a().F(context);
        try {
            if (TextUtils.isEmpty(E) && TextUtils.isEmpty(F)) {
                cn.jiguang.bb.f.i("JDeviceIdMap", "bootId and mediaDrmId is empty, skip reporting device id map");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("boot_id", E);
            jSONObject.put("media_drm_id", F);
            cn.jiguang.bb.f.c("JDeviceIdMap", "report deviceIdMapJson: " + jSONObject);
            cn.jiguang.be.b.a(context, jSONObject, "device_id_map");
            super.d(context, "JDeviceIdMap");
        } catch (Exception e6) {
            e6.printStackTrace();
            cn.jiguang.bb.f.i("JDeviceIdMap", "report device id map failed: " + e6.getMessage());
        }
    }
}
