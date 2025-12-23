package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.b;
import com.ss.android.socialbase.downloader.ae.cw;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    public static String e(cw cwVar) {
        if (cwVar == null) {
            return null;
        }
        try {
            String h6 = cwVar.h();
            if (!TextUtils.isEmpty(h6)) {
                return new JSONObject(h6).optString("notification_jump_url", null);
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        return null;
    }

    public static boolean f(int i6) {
        return i6 == 0 || i6 == 1;
    }

    public static boolean k(int i6) {
        return i6 == 2 || i6 == 1;
    }

    public static int b(@NonNull o.i iVar, boolean z5, com.ss.android.socialbase.appdownloader.e eVar) {
        int i6;
        if (eVar == null || TextUtils.isEmpty(eVar.M()) || eVar.getContext() == null) {
            return 0;
        }
        try {
            i6 = c(eVar, eVar.M());
        } catch (Throwable th) {
            m.w().j(th, "redirectSavePathIfPossible");
            i6 = 4;
        }
        eVar.N(i6);
        if (i6 == 0) {
            eVar.G(new b.f());
        }
        if (!eVar.Q()) {
            eVar.G(new b.k());
        }
        int h6 = com.ss.android.socialbase.appdownloader.f.L().h(eVar);
        com.ss.android.xt.j.xt.b d6 = d(iVar, h6);
        o.f.c().l(d6);
        d6.b(h6);
        d6.C0(System.currentTimeMillis());
        d6.z(0L);
        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(eVar.R());
        if (!i(eVar, j6, h6) && iVar.f37961b.qv()) {
            String gx = iVar.f37961b.gx();
            if (TextUtils.isEmpty(gx)) {
                gx = j6.cw("download_start_toast_text");
            }
            if (TextUtils.isEmpty(gx)) {
                gx = z5 ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            m.d().j(2, eVar.getContext(), iVar.f37961b, gx, null, 0);
        }
        return h6;
    }

    private static com.ss.android.xt.j.xt.b d(o.i iVar, int i6) {
        com.ss.android.xt.j.xt.b bVar = new com.ss.android.xt.j.xt.b(iVar.f37961b, iVar.f37962c, iVar.f37963d, i6);
        boolean z5 = true;
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("download_event_opt", 1) > 1) {
            try {
                String s5 = iVar.f37961b.s();
                if (!TextUtils.isEmpty(s5)) {
                    if (m.getContext().getPackageManager().getPackageInfo(s5, 0) == null) {
                        z5 = false;
                    }
                    bVar.E0(z5);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    private static boolean i(com.ss.android.socialbase.appdownloader.e eVar, @NonNull com.ss.android.socialbase.downloader.jy.j jVar, int i6) {
        String optString;
        JSONArray up = jVar.up("ah_plans");
        if (up != null && up.length() != 0) {
            int length = up.length();
            JSONObject jSONObject = null;
            for (int i7 = 0; i7 < length; i7++) {
                JSONObject optJSONObject = up.optJSONObject(i7);
                if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.m.b.f(optJSONObject))) {
                    optString.getClass();
                    switch (optString) {
                        case "plan_a":
                        case "plan_b":
                        case "plan_e":
                        case "plan_f":
                            if (com.ss.android.socialbase.appdownloader.j.d(optJSONObject, jVar).f38360b == 0) {
                                break;
                            } else {
                                break;
                            }
                        case "plan_c":
                            jSONObject = optJSONObject;
                            break;
                        case "plan_g":
                            if (com.ss.android.socialbase.appdownloader.j.A(optJSONObject, jVar).f38360b == 0) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            if (jSONObject != null && jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                return com.ss.android.socialbase.appdownloader.j.q(com.ss.android.socialbase.downloader.downloader.cw.nd(), null, jSONObject, i6, new com.ss.android.socialbase.appdownloader.d());
            }
        }
        return false;
    }

    public static boolean l(com.ss.android.j.j.cw.b bVar) {
        return bVar != null && bVar.la() == 2;
    }

    public static String a(com.ss.android.j.j.cw.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.ch())) {
                return new JSONObject(bVar.ch()).optString("clickid");
            }
            return null;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    private static int c(com.ss.android.socialbase.appdownloader.e eVar, String str) {
        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(eVar.R());
        JSONObject r5 = j6.r("download_dir");
        if (r5 != null && !TextUtils.isEmpty(r5.optString("dir_name"))) {
            String R0 = eVar.R0();
            String x5 = eVar.x();
            if (TextUtils.isEmpty(x5)) {
                x5 = com.ss.android.socialbase.appdownloader.b.t(str, R0, eVar.G0(), true);
            }
            if (x5.length() > 255) {
                x5 = x5.substring(x5.length() - 255);
            }
            if (TextUtils.isEmpty(R0)) {
                R0 = x5;
            }
            String o5 = eVar.o();
            if (TextUtils.isEmpty(o5)) {
                o5 = com.ss.android.socialbase.appdownloader.b.L();
            }
            String str2 = o5 + File.separator + com.ss.android.socialbase.appdownloader.b.s(R0, j6);
            cw j7 = com.ss.android.socialbase.appdownloader.f.L().j(eVar.getContext(), str);
            if (j7 != null && j7.ag()) {
                eVar.m(j7.qv());
                try {
                    eVar.K(new JSONObject(j7.hl()));
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            }
            if (j7 == null && "application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.f.L().m(x5, eVar.G0()))) {
                int c6 = com.ss.android.socialbase.appdownloader.j.c(j6);
                if (c6 == 0) {
                    eVar.m(str2);
                }
                return c6;
            }
            if (j7 != null) {
                return 8;
            }
            return 9;
        }
        return -1;
    }

    public static boolean g(com.ss.android.j.j.cw.b bVar) {
        if (bVar.x() && (bVar instanceof com.ss.android.xt.j.j.a) && bVar.la() == 1) {
            return true;
        }
        return false;
    }

    public static boolean h(com.ss.android.j.j.cw.b bVar, w2.h hVar) {
        if (bVar.x() && hVar != null) {
            return true;
        }
        return false;
    }

    public static String j(com.ss.android.j.j.cw.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.ch())) {
                return new JSONObject(bVar.ch()).optString("intent_extra");
            }
            return null;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }
}
