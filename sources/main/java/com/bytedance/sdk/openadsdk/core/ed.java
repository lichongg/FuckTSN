package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ed {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f28913j;

    public static boolean j(com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        if (nVar == null) {
            return false;
        }
        String yb = nVar.yb();
        if (TextUtils.isEmpty(yb)) {
            return false;
        }
        return j(yb, nVar, str);
    }

    public static boolean j(String str, com.bytedance.sdk.openadsdk.core.tj.n nVar, String str2) {
        return j(v.getContext(), str, nVar, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str2), str2);
    }

    public static boolean j(Context context, String str, com.bytedance.sdk.openadsdk.core.tj.n nVar, String str2) {
        return j(context, str, nVar, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str2), str2);
    }

    public static boolean j(Context context, String str, com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6, String str2) {
        try {
            return com.bytedance.sdk.component.utils.xt.j(context, j(context, str, nVar, i6, null, str2, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean j(Object obj) {
        if (obj == null || !(obj instanceof j.InterfaceC0466j)) {
            return false;
        }
        try {
            return ((j.InterfaceC0466j) obj).p();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent j(Context context, String str, com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6, Object obj, String str2, boolean z5) {
        Class cls;
        boolean z6 = false;
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.m(nVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.bytedance.sdk.openadsdk.i.cw.xt.g) && com.bytedance.sdk.openadsdk.core.tj.n.xt(nVar) && !f28913j && !j(obj) && com.bytedance.sdk.openadsdk.core.rn.uf.up(nVar) && (nVar == null || !nVar.g())) {
            cls = TTVideoWebPageActivity.class;
            z6 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z6) {
            j(context, nVar, obj, z5, intent);
        }
        j(context, str, nVar, i6, str2, intent);
        return intent;
    }

    private static void j(Context context, com.bytedance.sdk.openadsdk.core.tj.n nVar, Object obj, boolean z5, Intent intent) {
        int i6;
        if (obj != null) {
            r1 = obj instanceof j.InterfaceC0466j ? ((j.InterfaceC0466j) obj).la() : null;
            if (r1 != null) {
                intent.putExtra("multi_process_data", r1.j().toString());
            }
        }
        if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.xt) && (r1 = ((com.bytedance.sdk.openadsdk.core.nativeexpress.xt) obj).qv()) != null) {
            intent.putExtra("multi_process_data", r1.j().toString());
        }
        if (r1 != null) {
            intent.putExtra("video_is_auto_play", r1.f29583r);
            com.bytedance.sdk.component.utils.vl.j("videoDataModel", "videoDataModel=" + r1.j().toString());
        }
        if (r1 != null || z5) {
            try {
                if (r1 != null) {
                    i6 = (int) ((r1.ae / r1.up) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
                    jVar.ae = 100L;
                    jVar.f29581j = true;
                    jVar.f29583r = com.bytedance.sdk.openadsdk.core.rn.uf.tj(nVar);
                    intent.putExtra("multi_process_data", jVar.j().toString());
                    i6 = 100;
                }
                if (nVar.o() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (nVar.o() <= 0 || i6 <= nVar.o() || !com.bytedance.sdk.openadsdk.core.rn.uf.tj(nVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void j(Context context, String str, com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw(context, nVar).r(false)) {
            nVar.cw(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", nVar.el());
        intent.putExtra("title", nVar.hw());
        intent.putExtra("sdk_version", h.xt);
        intent.putExtra(MediationConstant.EXTRA_ADID, nVar.fs());
        intent.putExtra(MediationConstant.EXTRA_LOG_EXTRA, nVar.os());
        intent.putExtra("icon_url", nVar.ig() == null ? null : nVar.ig().j());
        intent.putExtra("event_tag", str2);
        intent.putExtra(SocialConstants.PARAM_SOURCE, i6);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("has_phone_num_status", nVar.cw());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.core.rn.uf.j(intent, nVar);
    }

    public static boolean j(Context context, com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            j(context, null, nVar, i6, str, intent);
            if (com.bytedance.sdk.openadsdk.core.tj.n.xt(nVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.xt.j(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
