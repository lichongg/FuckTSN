package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.nativeexpress.av;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.aq;
import com.bytedance.sdk.openadsdk.core.tj.ch;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    private static AtomicInteger f30761j = new AtomicInteger();
    private static final HashSet<String> xt;

    public static boolean ae(n nVar) {
        return (nVar == null || nVar.l() != 1 || kt.j(nVar)) ? false : true;
    }

    public static boolean g(n nVar) {
        return nVar != null && hh.xt(nVar) == 7;
    }

    public static int j(n nVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.g.j h6;
        JSONObject cw;
        int optInt;
        if (nVar == null || (h6 = nVar.h()) == null || (cw = h6.cw()) == null || (optInt = cw.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return optInt;
    }

    public static boolean m(n nVar) {
        if (nVar == null) {
            return false;
        }
        return ae(nVar) || tl(nVar);
    }

    public static boolean oq(n nVar) {
        return nVar != null && hh.xt(nVar) == 10;
    }

    public static boolean r(n nVar) {
        if (nVar == null) {
            return false;
        }
        int l6 = nVar.l();
        com.bytedance.sdk.openadsdk.core.ugeno.m.j p5 = nVar.p();
        return p5 != null && l6 == 1 && p5.r() == 3;
    }

    public static boolean tl(n nVar) {
        return nVar != null && nVar.kt() > 0;
    }

    public static boolean up(n nVar) {
        if (nVar == null) {
            return false;
        }
        int l6 = nVar.l();
        com.bytedance.sdk.openadsdk.core.ugeno.m.j p5 = nVar.p();
        return p5 != null && l6 == 1 && p5.r() == 2;
    }

    public static boolean vl(n nVar) {
        return (nVar == null || nVar.qn() == null) ? false : true;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        xt = hashSet;
        hashSet.add("1473");
        hashSet.add("3682");
        hashSet.add("4760");
    }

    public static boolean cw(n nVar) {
        if (nVar == null) {
            return false;
        }
        int l6 = nVar.l();
        com.bytedance.sdk.openadsdk.core.ugeno.m.j p5 = nVar.p();
        return p5 != null && l6 == 1 && p5.r() == 4;
    }

    public static boolean xt(n nVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.g.j h6;
        JSONObject cw;
        return (nVar == null || (h6 = nVar.h()) == null || (cw = h6.cw()) == null || cw.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean qv(n nVar) {
        if (hh.m(nVar) == null || xt(hh.m(nVar).oq(), hh.m(nVar).g()) == null) {
            return false;
        }
        return true;
    }

    public static JSONObject j(n nVar, View view, boolean z5) {
        int i6;
        JSONObject tv2 = nVar.tv();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.p.j w5 = v.xt().w(String.valueOf(uf.g(nVar)));
            if (com.bytedance.sdk.openadsdk.core.component.reward.r.r.j(nVar) == 4) {
                i6 = w5.cw;
            } else {
                i6 = w5.qv;
            }
            if (uf.up(nVar)) {
                i6 = w5.cw;
            }
            boolean z6 = false;
            jSONObject.put("voice_control", i6 == 1);
            Context context = v.getContext();
            jSONObject3.put("width", ed.r(context, ed.r(context)));
            jSONObject3.put("height", ed.r(context, ed.up(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", ed.r(context, width) * 1.0f);
                jSONObject4.put("height", ed.r(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            tv2.put("env_info", jSONObject2);
            tv2.put("setting", jSONObject);
            tv2.put("meta_hashcode", nVar.ae());
            if (z5 && v.xt().xw()) {
                z6 = true;
            }
            tv2.put("gesture_through_enable", z6);
            return tv2;
        } catch (JSONException e6) {
            vl.j(e6);
            return tv2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.g.xt.cw cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        if (cw == null) {
            return;
        }
        cw.j(str2);
        cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.2
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar != null) {
                    try {
                        if (!xtVar.tl() || xtVar.r() == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.xt.j().j(str, xtVar.r());
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(String str, String str2, av avVar) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.g.xt.cw cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        if (cw == null) {
            if (avVar != null) {
                avVar.xt();
                return;
            }
            return;
        }
        cw.j(str2);
        com.bytedance.sdk.component.g.xt j6 = cw.j();
        if (j6 != null) {
            try {
                if (j6.tl() && j6.r() != null) {
                    com.bytedance.sdk.openadsdk.core.xt.j().j(str, j6.r());
                    if (avVar != null) {
                        avVar.j();
                        return;
                    }
                    return;
                }
            } catch (Exception e6) {
                vl.j(e6);
                if (avVar != null) {
                    avVar.xt();
                    return;
                }
                return;
            }
        }
        if (avVar != null) {
            avVar.xt();
        }
    }

    public static JSONObject xt(String str, String str2) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        if (j6 == null) {
            return null;
        }
        try {
            return new JSONObject(j6.xt(str, ""));
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static int xt(Context context, n nVar, String str) {
        if (nVar == null) {
            return -1;
        }
        ch qn = nVar.qn();
        if (qn == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String xt2 = qn.xt();
        if (xt(qn.cw(), xt2) == null) {
            return TextUtils.isEmpty(xt2) ? 2 : 3;
        }
        return 1;
    }

    public static void j(List<n> list, av avVar) {
        if (list == null || list.size() <= 0) {
            if (avVar != null) {
                avVar.xt();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (hh.m(nVar) != null && g(nVar) && (!TextUtils.isEmpty(hh.m(nVar).g()) || !TextUtils.isEmpty(hh.m(nVar).oq()))) {
                arrayList.add(hh.m(nVar));
            }
        }
        if (arrayList.size() <= 0) {
            avVar.xt();
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            j((aq) it.next(), avVar);
        }
    }

    public static void j(aq aqVar) {
        com.bytedance.sdk.component.r.j.xt j6;
        if (aqVar == null) {
            return;
        }
        final String g6 = aqVar.g();
        final String oq = aqVar.oq();
        if ((TextUtils.isEmpty(g6) && TextUtils.isEmpty(oq)) || (j6 = com.bytedance.sdk.openadsdk.core.xt.j()) == null) {
            return;
        }
        if (TextUtils.isEmpty(oq) || TextUtils.isEmpty(j6.xt(oq, ""))) {
            com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.component.oq.g("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.1
                @Override // java.lang.Runnable
                public void run() {
                    oq.r(oq, g6);
                }
            }, 10);
        }
    }

    public static void j(String str, String str2) {
        com.bytedance.sdk.component.r.j.xt j6;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (j6 = com.bytedance.sdk.openadsdk.core.xt.j()) == null) {
            return;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(j6.xt(str2, ""))) {
            r(str2, str);
        }
    }

    public static void j(final String str, String str2, final cw cwVar) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.g.xt.cw cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        if (cw == null) {
            return;
        }
        cw.j(str2);
        cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.3
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                String str3 = "tt_ugen_tpl";
                if (xtVar != null) {
                    try {
                        if (xtVar.tl() && xtVar.r() != null) {
                            com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
                            final String r5 = xtVar.r();
                            j6.j(str, r5);
                            com.bytedance.sdk.component.utils.tl.xt().post(new com.bytedance.sdk.component.oq.g(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cwVar.j(r5);
                                }
                            });
                            return;
                        }
                    } catch (Exception unused) {
                        com.bytedance.sdk.component.utils.tl.xt().post(new com.bytedance.sdk.component.oq.g(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.3.3
                            @Override // java.lang.Runnable
                            public void run() {
                            }
                        });
                        return;
                    }
                }
                com.bytedance.sdk.component.utils.tl.xt().post(new com.bytedance.sdk.component.oq.g(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                com.bytedance.sdk.component.utils.tl.xt().post(new com.bytedance.sdk.component.oq.g("tt_ugen_tpl") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.3.4
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
    }

    private static void j(aq aqVar, av avVar) {
        String g6 = aqVar.g();
        String oq = aqVar.oq();
        if (TextUtils.isEmpty(g6) && TextUtils.isEmpty(oq)) {
            if (avVar != null) {
                avVar.xt();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(oq)) {
            oq = g6;
        }
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        if (j6 == null) {
            if (avVar != null) {
                avVar.xt();
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(j6.xt(oq, ""))) {
                if (TextUtils.isEmpty(g6)) {
                    avVar.xt();
                }
                j(oq, g6, avVar);
            } else if (avVar != null) {
                avVar.j();
            }
        } catch (Exception e6) {
            vl.j(e6);
            if (avVar != null) {
                avVar.xt();
            }
        }
    }

    public static void j(final String str, final String str2, final av avVar) {
        if (com.bytedance.sdk.openadsdk.core.xt.j() == null) {
            avVar.xt();
        } else {
            com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.component.oq.g("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.oq.4
                @Override // java.lang.Runnable
                public void run() {
                    oq.cw(str, str2, avVar);
                }
            }, 10);
        }
    }

    public static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", FaceEnvironment.OS);
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    public static boolean j(Context context, n nVar, String str) {
        return xt(context, nVar, str) == 1;
    }

    public static String j(Context context, String str, n nVar, String str2) {
        ch qn = nVar.qn();
        JSONObject ar = nVar.ar();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String zk = nVar.zk();
            if (!TextUtils.isEmpty(zk)) {
                jSONObject.put(SocialConstants.PARAM_COMMENT, zk);
            }
            if (ar != null) {
                jSONObject.put("easy_pl_material", ar.toString());
            }
            if (qn != null) {
                jSONObject.put("ugen_dialog_url", qn.xt());
                jSONObject.put("ugen_dialog_md5", qn.cw());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }
}
