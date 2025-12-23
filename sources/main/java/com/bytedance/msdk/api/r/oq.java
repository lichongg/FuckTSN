package com.bytedance.msdk.api.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class oq {
    private static long cw = -1;

    /* renamed from: j, reason: collision with root package name */
    private static Context f24385j = null;

    /* renamed from: r, reason: collision with root package name */
    private static long f24386r = -1;
    private static j xt;

    public static long cw() {
        return f24386r;
    }

    public static void j(final Activity activity, final List<jy> list, final int i6, final int i7) {
        j(new av() { // from class: com.bytedance.msdk.api.r.oq.1
            @Override // com.bytedance.msdk.api.r.av
            public void j() {
                com.bytedance.msdk.core.up.xt.r.j().j(activity, list, i6, i7);
            }
        });
    }

    public static boolean m() {
        return com.bytedance.msdk.core.j.qv().az();
    }

    public static void r() {
        if (f24385j == null || xt == null) {
            return;
        }
        if (f24386r == -1) {
            f24386r = System.currentTimeMillis();
            com.bytedance.msdk.j.up.cw.xt("TMe", "call start up time " + f24386r);
        }
        xt(f24385j, xt);
        com.bytedance.msdk.m.r.xt();
    }

    public static String up() {
        return com.bytedance.msdk.xt.xt.xt();
    }

    public static long xt() {
        return cw;
    }

    @Nullable
    public static String cw(String str) {
        str.getClass();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.bytedance.msdk.tl.r.r.cw();
            case "tt_pangle_preview_creative_id":
                return com.bytedance.msdk.tl.r.r.xt();
            case "tt_pangle_preview_ad_id":
                return com.bytedance.msdk.tl.r.r.j();
            default:
                return null;
        }
    }

    public static void j(av avVar) {
        com.bytedance.msdk.core.xt.xt().j(avVar);
    }

    @Nullable
    @Deprecated
    public static com.bytedance.msdk.j.j.r m(String str) {
        return com.bytedance.msdk.m.xt.xt.j().j(str);
    }

    @Nullable
    @Deprecated
    public static com.bytedance.msdk.api.r.j.xt.m.j up(String str) {
        return com.bytedance.msdk.m.xt.j.j(str);
    }

    private static void xt(@NonNull Context context, @NonNull j jVar) {
        com.bytedance.msdk.core.j.qv().cw(jVar.j());
        com.bytedance.msdk.core.j.qv().cw(jVar.av());
        com.bytedance.msdk.ae.xt.j.j().m();
        com.bytedance.msdk.m.cw.j(jVar, StubApp.getOrigApplicationContext(context.getApplicationContext()));
        com.bytedance.msdk.ae.xt.j.j().ae();
    }

    @Nullable
    public static String ae() {
        return com.bytedance.msdk.core.j.qv().av();
    }

    public static boolean g() {
        return com.bytedance.msdk.core.j.qv().ch();
    }

    public static boolean j() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.j.qv().vl())) {
            return false;
        }
        return com.bytedance.msdk.core.xt.xt().p();
    }

    @Nullable
    public static Map<String, Object> jy() {
        return com.bytedance.msdk.core.j.qv().rh();
    }

    @Nullable
    public static String oq() {
        return com.bytedance.msdk.core.j.qv().tj();
    }

    @Nullable
    public static String qv() {
        return com.bytedance.msdk.core.j.qv().vl();
    }

    @Nullable
    public static Map<String, String> tl() {
        return com.bytedance.msdk.core.j.qv().i();
    }

    @Deprecated
    public static void vl() {
        com.bytedance.msdk.core.xt.xt().cw(com.bytedance.msdk.ae.j.j().cw("if_test"));
    }

    public static void j(@NonNull Context context, @NonNull j jVar) {
        if (cw == -1) {
            cw = System.currentTimeMillis();
            if (jVar != null && jVar.cw()) {
                com.bytedance.msdk.j.up.cw.j();
                com.bytedance.sdk.component.g.j.j();
            }
            com.bytedance.msdk.j.up.cw.xt("TMe", "call init time " + cw);
            f24385j = context;
            xt = jVar;
        }
    }

    public static void xt(String str) {
        com.bytedance.msdk.core.j.qv().up(str);
    }

    @Deprecated
    public static boolean r(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.bytedance.msdk.core.j.qv().vl())) {
            return false;
        }
        return com.bytedance.msdk.core.xt.xt().cw(str);
    }

    @Nullable
    public static String xt(Context context) {
        return x.xt();
    }

    public static boolean xt(String str, String str2) {
        return com.bytedance.msdk.m.j.xt(str, str2);
    }

    @Deprecated
    public static void xt(int i6) {
        com.bytedance.msdk.core.xt.xt().cw(i6);
    }

    public static void j(m mVar) {
        com.bytedance.msdk.core.j.qv().j(mVar, false);
    }

    public static void j(String str) {
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.bytedance.msdk.core.j.qv().r(str);
    }

    public static void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar) {
        com.bytedance.msdk.core.j.qv().xt().xt(com.bytedance.msdk.m.xt.up.j(rVar));
        com.bytedance.msdk.core.j.qv().h();
        com.bytedance.msdk.m.cw.j(com.bytedance.msdk.m.xt.up.j(rVar));
    }

    public static void j(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        com.bytedance.msdk.tl.r.j(context, intent, null);
    }

    public static void j(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permissions", iArr);
        if (context != null) {
            com.bytedance.msdk.tl.r.j(context, intent, null);
        }
    }

    public static void j(int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.bytedance.msdk.j.j.j.up, Integer.valueOf(i6));
        Map<String, com.bytedance.msdk.j.j.r> xt2 = com.bytedance.msdk.m.xt.xt.j().xt();
        if (xt2 == null || xt2.size() == 0) {
            return;
        }
        for (com.bytedance.msdk.j.j.r rVar : com.bytedance.msdk.m.xt.xt.j().cw()) {
            if (rVar != null) {
                rVar.j(hashMap);
            }
        }
    }

    public static int j(cw cwVar) {
        com.bytedance.msdk.j.j.r j6 = com.bytedance.msdk.m.xt.xt.j().j(MediationConstant.ADN_GDT);
        if (j6 == null) {
            return 0;
        }
        return j6.j(cwVar);
    }

    public static boolean j(String str, String str2) {
        return com.bytedance.msdk.m.j.j(str, str2);
    }

    public static void j(com.bytedance.msdk.api.r.j.g.j jVar) {
        if (!com.bytedance.msdk.m.cw.xt()) {
            com.bytedance.msdk.core.j.qv().j(jVar);
        } else if (jVar != null) {
            jVar.j();
        }
    }
}
