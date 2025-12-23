package com.bytedance.sdk.openadsdk.core.rn;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.av;
import com.bytedance.sdk.openadsdk.core.jy.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, j> f30101j = Collections.synchronizedMap(new HashMap());
    private static com.bytedance.sdk.openadsdk.core.av xt;

    public interface j {
        void onDialogBtnNo();

        void onDialogBtnYes();

        void onDialogCancel();
    }

    public static void cw(final com.bytedance.sdk.openadsdk.core.tj.n nVar, final Context context, final String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        j(context, nVar.fs(), nVar.ov(), new j() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.5
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                m.r(com.bytedance.sdk.openadsdk.core.tj.n.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        });
    }

    public static void r(com.bytedance.sdk.openadsdk.core.tj.n nVar, Context context, String str) {
        int w5 = com.bytedance.sdk.openadsdk.core.tj.tj.w(nVar);
        if (nVar == null || context == null) {
            return;
        }
        if (nVar.jl() == 4 || w5 != 0) {
            com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = com.bytedance.sdk.openadsdk.core.qv.tl.j(context, nVar, str, false);
            if (j6 instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                ((com.bytedance.sdk.openadsdk.core.qv.cw.up) j6).tl().j(false);
            }
            j6.j(nVar, false);
        }
    }

    public static void j(Context context, String str, String str2, String str3, j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.j(context, str, str2, str3);
    }

    public static void xt(final com.bytedance.sdk.openadsdk.core.tj.n nVar, final Context context, final String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        j(context, nVar.fs(), new j() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.4
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                m.r(com.bytedance.sdk.openadsdk.core.tj.n.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        }, nVar.ov());
    }

    public static j up(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f30101j.remove(str);
    }

    public static void cw(String str) {
        j(str, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.av cw() {
        if (xt == null) {
            xt = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(com.bytedance.sdk.openadsdk.core.v.getContext()).j(2));
        }
        return xt;
    }

    public static void j(final Context context, final String str, final String str2, final String str3, final j jVar, final com.bytedance.sdk.openadsdk.core.ugeno.ae.ae aeVar, final com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.1
            @Override // java.lang.Runnable
            public void run() {
                boolean j6 = com.bytedance.sdk.openadsdk.core.oq.i().j(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    if (!m.f30101j.containsKey(str)) {
                        if (!uf.r() && !j6) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                m.j(str, jVar);
                TTDelegateActivity.j(context, str, str2, str3, aeVar, nVar);
            }
        });
    }

    public static void xt(Context context, String str, String str2, j jVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(str2, jVar);
        TTDelegateActivity.cw(context, str2, str);
    }

    public static void r(String str) {
        j(str, 3);
    }

    public static void xt(String str) {
        j(str, 1);
    }

    public static void j(final Context context, final String str, final String str2, final String str3, final j jVar, final com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.2
            @Override // java.lang.Runnable
            public void run() {
                boolean j6 = com.bytedance.sdk.openadsdk.core.oq.i().j(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                    if (!m.f30101j.containsKey(str)) {
                        if (!uf.r() && !j6) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                m.j(str, jVar);
                TTDelegateActivity.j(context, str, str2, str3, nVar);
            }
        });
    }

    public static void j(String str) {
        Map<String, j> map = f30101j;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void j(Context context, String str, j jVar, String str2, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.j(context, str, str2, nVar);
    }

    public static void j(final com.bytedance.sdk.openadsdk.core.tj.n nVar, final Context context, final String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        j(context, nVar.fs(), new j() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.3
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                m.r(com.bytedance.sdk.openadsdk.core.tj.n.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        }, nVar.ov(), nVar);
    }

    public static void j(Context context, String str, j jVar, String str2) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.xt(context, str, str2);
    }

    public static void j(Context context, String str, String str2, j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.j(context, str, str2);
    }

    public static void j(final Context context, final com.bytedance.sdk.openadsdk.core.tj.n nVar, final String str) {
        if (nVar == null) {
            return;
        }
        String fs = nVar.fs();
        if (TextUtils.isEmpty(fs)) {
            return;
        }
        j(fs, new j() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.6
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                m.r(com.bytedance.sdk.openadsdk.core.tj.n.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        });
        com.bytedance.sdk.openadsdk.core.tj.m et = nVar.et();
        if (et == null) {
            return;
        }
        TTDelegateActivity.cw(context, fs, et.g());
    }

    public static void j(Context context, String str) {
        TTDelegateActivity.j(context, str);
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(str);
    }

    public static void j(Context context, String str, String str2, String str3, String str4, String str5, j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.j(context, str, str2, str3, str4, str5);
    }

    public static void j(Context context, String str, boolean z5, j jVar) {
        if (z5) {
            TTDelegateActivity.j(context, str, z5);
        } else {
            if (TextUtils.isEmpty(str) || jVar == null) {
                return;
            }
            j(str, jVar);
            TTDelegateActivity.j(context, str, z5);
        }
    }

    public static void j(final String str, final j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.rn.m.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        m.cw().j(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.j(jVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            f30101j.put(str, jVar);
        }
    }

    private static void j(final String str, final int i6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.rn.m.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        m.cw().j(str, i6);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        j up = up(str);
        if (up == null) {
            return;
        }
        if (i6 == 1) {
            up.onDialogBtnYes();
            return;
        }
        if (i6 == 2) {
            up.onDialogBtnNo();
        } else if (i6 != 3) {
            up.onDialogCancel();
        } else {
            up.onDialogCancel();
        }
    }

    public static void j(Context context, String str, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        TTDelegateActivity.j(context, str, nVar);
    }

    public static void j(Context context, final com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return;
        }
        new j.C0460j().up(nVar.fs()).j("pangle_logo").xt("open_policy").r(nVar.os()).j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.m.9
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", com.bytedance.sdk.openadsdk.core.tj.n.this.fj());
                jSONObject2.put("ad_slot_type", uf.tl(com.bytedance.sdk.openadsdk.core.tj.n.this));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
        TTDelegateActivity.xt(context, nVar.fj());
    }

    public static boolean j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null || nVar.mz() || nVar.fx() == null || com.bytedance.sdk.openadsdk.core.tj.tj.jy(nVar) == 1 || nVar.jl() != 4 || com.bytedance.sdk.openadsdk.core.tj.tj.vl(nVar) == 0) {
            return false;
        }
        int kt = nVar.kt();
        return kt == 4 || kt == 5;
    }
}
