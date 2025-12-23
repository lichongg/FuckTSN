package com.bytedance.sdk.openadsdk.core.qv.cw.xt;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw;
import com.bytedance.sdk.openadsdk.core.qv.g;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.tj.up;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final Map<String, Object> map, n nVar) {
        g.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.3
            @Override // java.lang.Runnable
            public void run() {
                if (oq.i().gx() != null) {
                    oq.i().gx().apply(r.j().j(12).j(Boolean.class).j(0, map).xt());
                }
            }
        }, nVar);
    }

    public static void j(String str, String str2, n nVar, JSONObject jSONObject, int i6) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        if (nVar == null) {
            j(true, gx, str2, nVar, jSONObject, str, "", null, i6);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            j(true, gx, str2, nVar, jSONObject, str, "", null, i6);
            return;
        }
        String ij = nVar.ij();
        if (TextUtils.isEmpty(ij) && nVar.et() != null) {
            ij = nVar.et().jy();
        }
        j(false, gx, str2, nVar, jSONObject, str, "", ij, i6);
    }

    public static void xt(int i6, int i7) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(30).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(i7)).j("downloadScene", Integer.valueOf(i6))).xt());
    }

    public static void j(String str, n nVar, JSONObject jSONObject, int i6) {
        String str2;
        String str3;
        String str4;
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        if (nVar == null) {
            j(true, gx, str, nVar, jSONObject, null, null, null, i6);
            return;
        }
        up by = nVar.by();
        if (by != null) {
            String xt = by.xt();
            String cw = by.cw();
            str4 = by.r();
            str2 = xt;
            str3 = cw;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        j(false, gx, str, nVar, jSONObject, str2, str3, str4, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(boolean r19, java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r20, java.lang.String r21, com.bytedance.sdk.openadsdk.core.tj.n r22, org.json.JSONObject r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(boolean, java.util.function.Function, java.lang.String, com.bytedance.sdk.openadsdk.core.tj.n, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public static void j(n nVar, int i6, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        int r5 = tj.r(nVar);
        int up = tj.up(nVar);
        if (nVar != null && (!TextUtils.isEmpty(nVar.vm()) || z5)) {
            up = 2;
        }
        if (nVar == null || nVar.yu() == null) {
            z6 = false;
            z7 = false;
            z8 = false;
        } else {
            z7 = nVar.yu().j();
            z6 = nVar.yu().xt();
            z8 = true;
        }
        gx.apply(r.j().j(25).j(Void.class).j(0, new la().j("autoOpen", Integer.valueOf(r5)).j("downloadMode", Integer.valueOf(up)).j("isHaveDownloadSdkConfig", Boolean.valueOf(z8)).j("hashCode", Integer.valueOf(i6)).j("isEnableAH", Boolean.valueOf(z7)).j("isEnableAM", Boolean.valueOf(z6))).xt());
    }

    public static void j(int i6, int i7) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(26).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(i7)).j("downloadMode", Integer.valueOf(i6))).xt());
    }

    public static void j(boolean z5, int i6) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(31).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(i6)).j("isShowToast", Boolean.valueOf(z5))).xt());
    }

    public static int j(Function<SparseArray<Object>, Object> function, int i6) {
        Object apply;
        if (function == null) {
            return 0;
        }
        apply = function.apply(r.j().j(27).j(Integer.class).j(0, new la().j("hashCode", Integer.valueOf(i6))).xt());
        if (apply != null) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    public static void j(boolean z5, com.bytedance.sdk.openadsdk.core.qv.j.r rVar, int i6) {
        try {
            Function<SparseArray<Object>, Object> gx = oq.i().gx();
            if (gx == null) {
                return;
            }
            gx.apply(r.j().j(28).j(Void.class).j(0, new la().j("isEnableOppoAutoDownload", Boolean.valueOf(z5)).j("hashCode", Integer.valueOf(i6)).j("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.i.cw.r.j(rVar))).xt());
        } catch (Throwable th) {
            vl.cw("xgc_dof", "throwable", th);
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.core.qv.j.r rVar, int i6) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(154).j(Void.class).j(0, new la().j("hashCode", Integer.valueOf(i6)).j("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.i.cw.r.j(rVar))).xt());
    }

    public static void j(String str, String str2, String str3, String str4, int i6, int i7, Bitmap bitmap, String str5, String str6, String str7) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(160).j(Void.class).j(0, new la().j("install_app_name", str).j("install_icon_bitmap", bitmap).j("install_action_type", str4).j("install_click_type", Integer.valueOf(i7)).j("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && v.xt().zk() > 0)).j("install_package_name", str5).j("install_tag", str6).j("install_value", str7).j("install_log_extra", str3).j("install_download_id", Integer.valueOf(i6))).xt());
    }

    public static com.bytedance.sdk.openadsdk.core.qv.j.r j(n nVar, final boolean z5) {
        if (nVar == null) {
            return null;
        }
        String uv = nVar.uv();
        if (!TextUtils.isEmpty(uv) && h.xt >= 6400) {
            final String ej = nVar.ej();
            final String so = nVar.so();
            final com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) x.j(uv, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
            if (xtVar != null && !TextUtils.isEmpty(nVar.vm()) && nVar.fx().r() == 1) {
                return new com.bytedance.sdk.openadsdk.core.qv.j.r() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.1
                    @Override // w2.r
                    public Map<String, Object> j(Map<String, Object> map) {
                        if (map == null) {
                            ws j6 = ws.j();
                            Boolean bool = Boolean.FALSE;
                            j6.j(bool, bool, "param is null", ej, so);
                            return map;
                        }
                        if (!z5) {
                            map.put("is_button", Boolean.FALSE);
                        }
                        Object obj = map.get("is_button");
                        xtVar.j(100, map);
                        xt.j(map, obj, ej, so);
                        return map;
                    }
                };
            }
            vl.j("dof", "bridge something invalid");
        }
        return null;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("market") || str.startsWith("mimarket")) {
            return ch.av();
        }
        return false;
    }

    public static boolean j(Uri uri, n nVar, Context context, String str, int i6) {
        if (oq.i().gx() == null || nVar == null) {
            return false;
        }
        j(str, nVar, (JSONObject) null, i6);
        j(nVar, i6, false);
        j(str, i6);
        la<String, Object> j6 = new la().j("hashCode", Integer.valueOf(i6)).j(ContentProviderManager.PROVIDER_URI, uri);
        cw cwVar = new cw(context, nVar);
        cwVar.j(new com.bytedance.sdk.openadsdk.core.qv.cw.cw.up());
        if (j(nVar, str, j6, cwVar)) {
            return true;
        }
        xt(j6, nVar);
        return true;
    }

    private static boolean j(final n nVar, String str, final Map<String, Object> map, cw cwVar) {
        if (!cwVar.r(false)) {
            return false;
        }
        cwVar.j(str, new com.bytedance.sdk.openadsdk.core.qv.cw.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.cw.j.xt
            public void j() {
                xt.xt((Map<String, Object>) map, nVar);
            }
        });
        return true;
    }

    public static void j(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            ws.j().j(obj, obj2, "success", str, str2);
            return;
        }
        ws j6 = ws.j();
        Boolean bool = Boolean.FALSE;
        j6.j(bool, bool, "no intercept result", str, str2);
    }

    public static void j(String str, int i6) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null) {
            return;
        }
        gx.apply(r.j().j(29).j(Void.class).j(0, new la().j("clickButtonTag", str).j("clickItemTag", str).j("hashCode", Integer.valueOf(i6)).j("clickStartLabel", "click_start").j("clickContinueLabel", "click_continue").j("clickPauseLabel", "click_pause").j("storageDenyLabel", "download_failed").j("clickInstallLabel", "click_install").j("isEnableClickEvent", Boolean.TRUE).j("isEnableV3Event", Boolean.FALSE)).xt());
    }

    public static void j(String str, String str2, JSONObject jSONObject, int i6) {
        Function<SparseArray<Object>, Object> gx = oq.i().gx();
        if (gx == null || jSONObject == null) {
            return;
        }
        gx.apply(r.j().j(29).j(Void.class).j(0, new la().j("clickButtonTag", str).j("clickItemTag", str2).j("clickStartLabel", "click_start").j("clickContinueLabel", "click_continue").j("clickPauseLabel", "click_pause").j("storageDenyLabel", "download_failed").j("clickInstallLabel", "click_install").j("isEnableClickEvent", Boolean.TRUE).j("hashCode", Integer.valueOf(i6)).j("isEnableV3Event", Boolean.FALSE).j("extraEventObject", jSONObject)).xt());
    }

    public static void j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar) {
        if (h.xt < 4400 || map == null || xtVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", com.bytedance.sdk.openadsdk.i.cw.r.j(xtVar));
    }
}
