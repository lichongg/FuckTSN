package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
    public static boolean isLoad = true;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            mContext = origApplicationContext;
            if (origApplicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = IWeaponInitParams.this;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.3.9";
                            WeaponHI.hostVersionName = bh.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.isLoad = IWeaponInitParams.this.isLoadSo();
                            WeaponHI.cookieData = bh.y(WeaponHI.mContext);
                            try {
                                h a6 = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cm.m());
                                jSONObject.put("d", cm.b(WeaponHI.mContext));
                                jSONObject.put("a", bh.q(WeaponHI.mContext));
                                jSONObject.put("p", bh.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.3.9");
                                jSONObject.put("n", TextUtils.isEmpty(a6.a(df.f35994g)) ? 1 : 0);
                                WeaponHI.encryENV = new bn(WeaponHI.mContext).c(jSONObject.toString());
                                String a7 = a6.a(df.f36008u);
                                if (!TextUtils.isEmpty(a7)) {
                                    WeaponHI.isList = Arrays.asList(a7.split("\\|"));
                                    WeaponHI.ii = a6.c(df.f36009v, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void iD() {
        try {
            iP(mContext);
        } catch (Throwable unused) {
        }
        try {
            db.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            dd.a(mContext).a(100);
            cz.a(mContext).a(100);
            de.a(mContext).a(100);
            da.a(mContext).a();
            cy.a(mContext).a(100);
            dc.a(mContext).a(100);
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long b6 = df.a(context).b();
            long currentTimeMillis = (System.currentTimeMillis() - b6) - (h.a(context, "re_po_rt").c(df.f35995h, 12) * 3600000);
            if (b6 < 1 || currentTimeMillis > 0) {
                n.a().a(new cw(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void setPS(final boolean z5) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h a6 = h.a(context, "re_po_rt");
                        boolean z6 = z5;
                        if (!z6) {
                            a6.a("a1_p_s_p_s_c_b", Boolean.valueOf(z6));
                            return;
                        }
                        if (a6.e("a1_p_s_p_s_c_b")) {
                            return;
                        }
                        a6.a("a1_p_s_p_s_c_b", Boolean.valueOf(z5));
                        try {
                            if (a6.c(df.bq, 1) == 1) {
                                dd.a(WeaponHI.mContext).a(103);
                                db.a(WeaponHI.mContext).a(103, 0);
                                cy.a(WeaponHI.mContext).a(103);
                                dc.a(WeaponHI.mContext).a(103);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void init(String str, String str2, boolean z5) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z5));
            n.a();
            bt.a(mContext);
            bs.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q a6 = q.a(WeaponHI.mContext);
                    if (a6 == null) {
                        return;
                    }
                    a6.a();
                } catch (Exception unused2) {
                }
            }
        });
    }
}
