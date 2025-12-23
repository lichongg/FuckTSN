package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bw {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f35820d = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private Context f35821a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35822b;

    /* renamed from: c, reason: collision with root package name */
    private int f35823c;

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0555: RETURN (r16 I:org.json.JSONObject) A[SYNTHETIC], block:B:161:? */
    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            h a6 = h.a(this.f35821a, "re_po_rt");
            boolean e6 = a6.e("a1_p_s_p_s");
            boolean e7 = a6.e("a1_p_s_p_s_c_b");
            jSONObject3.put("11006", e6 ? 1 : 0);
            jSONObject3.put("11029", e7 ? 1 : 0);
            if (a6.b(df.au, 1) == 1 && (e6 || e7)) {
                String a7 = bh.a(this.f35821a);
                if (!TextUtils.isEmpty(a7) && !a7.startsWith("RISK")) {
                    jSONObject3.put("01001", f.a(a7));
                }
                String c6 = bh.c(this.f35821a);
                if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                    jSONObject3.put("01003", c6);
                }
                String b6 = bh.b(this.f35821a, 0);
                if (!TextUtils.isEmpty(b6) && !b6.startsWith("RISK")) {
                    jSONObject3.put("01019", b6);
                }
                String b7 = bh.b(this.f35821a, 1);
                if (!TextUtils.isEmpty(b7) && !b7.startsWith("RISK")) {
                    jSONObject3.put("01004", f.a(b7));
                }
            }
            int b8 = a6.b(df.at, 1);
            if (b8 == 1 && (e6 || e7)) {
                String f6 = bh.f(this.f35821a);
                if (!TextUtils.isEmpty(f6) && !f6.startsWith("RISK")) {
                    jSONObject3.put("01013", f6);
                }
            }
            if (a6.b(df.av, 1) == 1 && (e6 || e7)) {
                String d6 = bh.d(this.f35821a);
                if (!TextUtils.isEmpty(d6) && !d6.startsWith("RISK")) {
                    jSONObject3.put("01007", d6);
                }
            }
            if (a6.b(df.aw, 1) == 1 && (e6 || e7)) {
                jSONObject3.put("01011", bh.e(this.f35821a));
            }
            if (e6 || e7) {
                String h6 = bh.h();
                if (!TextUtils.isEmpty(h6) && !h6.startsWith("RISK")) {
                    jSONObject3.put("07005", h6);
                } else if (h6 == null) {
                    jSONObject3.put("07005", "");
                } else {
                    jSONObject3.put("07005", h6);
                }
                jSONObject3.put("07006", bh.g());
            }
            if (a6.b(df.ay, 1) == 1 && (e6 || e7)) {
                String p5 = bh.p(this.f35821a);
                if (!TextUtils.isEmpty(p5) && !p5.startsWith("RISK")) {
                    jSONObject3.put("01016", p5);
                }
            }
            if (e6 || e7) {
                try {
                    double b9 = bh.b();
                    if (b9 > 0.0d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b9);
                        jSONObject3.put("09002", sb.toString());
                    }
                    double c7 = bh.c();
                    if (c7 > 0.0d) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c7);
                        jSONObject3.put("09003", sb2.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject3.put("11013", Integer.parseInt(bx.a(StubApp.getOrigApplicationContext(this.f35821a.getApplicationContext())), 2));
            jSONObject3.put("11012", bx.b(this.f35821a));
            try {
                jSONObject3.put("11202", bh.b(com.kwad.sdk.e.b.Mo().Md()));
                jSONObject3.put("11204", bh.b(com.kwad.sdk.e.b.Mo().Mk()));
                jSONObject3.put("11205", bh.b(com.kwad.sdk.e.b.Mo().getDeviceId()));
                jSONObject3.put("11206", bh.b(com.kwad.sdk.e.b.Mo().getIccId()));
                jSONObject3.put("11207", bh.b(com.kwad.sdk.e.b.Mo().Mc()));
                jSONObject3.put("11208", bh.b(com.kwad.sdk.e.b.Mo().Mf()));
                jSONObject3.put("11209", bh.b(com.kwad.sdk.e.b.Mo().Mg()));
                jSONObject3.put("11210", bh.b(com.kwad.sdk.e.b.Mo().Mh()));
                jSONObject3.put("11211", bh.b(com.kwad.sdk.e.b.Mo().getIp()));
                jSONObject3.put("11212", bh.b(com.kwad.sdk.e.b.Mo().getLocation()));
                jSONObject3.put("11213", bh.b(com.kwad.sdk.e.b.Mo().getOaid()));
                jSONObject3.put("11214", bh.b(com.kwad.sdk.e.b.Mo().Me()));
                jSONObject3.put("11215", bh.b(com.kwad.sdk.e.b.Mo().Mj()));
                jSONObject3.put("11216", bh.b(com.kwad.sdk.e.b.Mo().Mi()));
                jSONObject3.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                jSONObject3.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                jSONObject3.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
                jSONObject3.put("11104", com.kwad.sdk.e.b.Mo().Mk());
                jSONObject3.put("11105", com.kwad.sdk.e.b.Mo().getDeviceId());
                jSONObject3.put("11106", com.kwad.sdk.e.b.Mo().getIccId());
                jSONObject3.put("11107", com.kwad.sdk.e.b.Mo().Mc());
                jSONObject3.put("11108", com.kwad.sdk.e.b.Mo().Mf());
                jSONObject3.put("11109", com.kwad.sdk.e.b.Mo().Mg());
                jSONObject3.put("11110", com.kwad.sdk.e.b.Mo().Mh());
                jSONObject3.put("11111", com.kwad.sdk.e.b.Mo().getIp());
                jSONObject3.put("11112", com.kwad.sdk.e.b.Mo().getLocation());
                jSONObject3.put("11113", com.kwad.sdk.e.b.Mo().getOaid());
                jSONObject3.put("11114", com.kwad.sdk.e.b.Mo().Me());
                jSONObject3.put("11115", com.kwad.sdk.e.b.Mo().Mj());
                jSONObject3.put("11116", com.kwad.sdk.e.b.Mo().Mi());
            } catch (Throwable unused2) {
            }
            String w5 = bh.w(this.f35821a);
            if (!TextUtils.isEmpty(w5)) {
                jSONObject3.put("01026", w5);
            }
            if (b8 == 1) {
                try {
                    Object a8 = ai.a(this.f35821a);
                    if (a8 != null) {
                        jSONObject3.put("11015", a8);
                    }
                    try {
                        if (Engine.loadSuccess) {
                            jSONObject2 = null;
                            ce ceVar = new ce(this.f35821a);
                            jSONObject3.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                            jSONObject3.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                            jSONObject3.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                            jSONObject3.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                            jSONObject3.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                            jSONObject3.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                            jSONObject3.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                            jSONObject3.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                            jSONObject3.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                            jSONObject3.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                        } else {
                            jSONObject2 = null;
                            jSONObject3.put("02001", bl.a());
                            jSONObject3.put("02002", bl.b());
                            jSONObject3.put("02003", bl.c());
                            jSONObject3.put("02004", bl.d());
                            jSONObject3.put("02005", bl.e());
                            jSONObject3.put("02006", bl.f());
                            jSONObject3.put("02007", bl.g());
                            jSONObject3.put("02018", bl.s());
                            jSONObject3.put("02013", bl.m());
                            jSONObject3.put("02016", bl.q());
                        }
                        jSONObject3.put("02021", bl.d(this.f35821a));
                        jSONObject3.put("02022", bl.c(this.f35821a));
                        jSONObject3.put("02044", bl.t());
                        jSONObject3.put("11009", bs.a(StubApp.getOrigApplicationContext(this.f35821a.getApplicationContext())));
                        if (Engine.loadSuccess) {
                            bz bzVar = new bz(this.f35821a);
                            jSONObject3.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : "");
                            jSONObject3.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : "");
                            jSONObject3.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : "");
                            jSONObject3.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : "");
                        } else {
                            try {
                                bj b10 = bk.b();
                                jSONObject3.put("04001", bk.a());
                                jSONObject3.put("04002", b10.b());
                                jSONObject3.put("04003", b10.c());
                                jSONObject3.put("04004", b10.a());
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        return jSONObject;
                    }
                } catch (Throwable unused5) {
                    return null;
                }
            } else {
                jSONObject2 = null;
            }
            try {
                if (this.f35822b) {
                    jSONObject3.put("20004", 1);
                }
                jSONObject3.put("11017", jSONObject3.toString().length());
                jSONObject3.put("20000", this.f35823c);
                jSONObject3.put("11028", WeaponHI.sKSSdkver);
                return jSONObject3;
            } catch (Throwable unused6) {
                return jSONObject2;
            }
        } catch (Throwable unused7) {
            return null;
        }
    }

    public bw(Context context, int i6, boolean z5) {
        this.f35821a = context;
        this.f35822b = z5;
        this.f35823c = i6;
    }

    public String a(String str) {
        try {
            synchronized (f35820d) {
                try {
                    JSONObject a6 = new cm(str, ck.f35879l).a(this.f35821a);
                    if (a6 == null) {
                        return null;
                    }
                    JSONObject a7 = a();
                    if (a7 == null) {
                        return null;
                    }
                    a6.put("module_section", a7);
                    return a6.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
