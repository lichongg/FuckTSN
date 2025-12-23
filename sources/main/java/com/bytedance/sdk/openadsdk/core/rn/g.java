package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.umeng.analytics.pro.bi;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

@ATS(single = true, value = {"device_info"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements com.bytedance.sdk.component.r.j {
    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(11)
    public int oq() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(16)
    public String az() {
        return Build.MANUFACTURER;
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(12)
    public String qv() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(2)
    public String xt() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        return sb.toString();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(28)
    public int a() {
        return oq.j(com.bytedance.sdk.openadsdk.core.v.getContext(), false);
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(8)
    public String ae() {
        return oq.qv();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(17)
    public String av() {
        String str;
        double currentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            str = new Formatter().format("%.6f", Double.valueOf(currentTimeMillis)).toString();
        } catch (Exception unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return new DecimalFormat("#0.000000").format(currentTimeMillis);
            } catch (Exception unused2) {
                return str;
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(26)
    public String ch() {
        return com.bytedance.sdk.openadsdk.core.kt.vl();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(3)
    public int cw() {
        return com.bytedance.sdk.component.utils.ws.cw(com.bytedance.sdk.openadsdk.core.v.getContext());
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(23)
    public String f() {
        return com.bytedance.sdk.openadsdk.core.kt.oq();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(10)
    public String g() {
        return com.bytedance.sdk.openadsdk.core.kt.mi();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(31)
    public int h() {
        return com.bytedance.sdk.openadsdk.core.kt.j.vl();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(18)
    public String i() {
        return com.bytedance.sdk.openadsdk.core.kt.tj();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(1)
    public String j() {
        return com.bytedance.sdk.openadsdk.core.kt.m();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(14)
    public String jy() {
        return String.valueOf(Long.parseLong(uf.vl()) * 1024);
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(21)
    public String kt() {
        return com.bytedance.sdk.openadsdk.core.cw.j.cw();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(29)
    public String l() {
        return uf.m();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(32)
    public String la() {
        return com.bytedance.sdk.openadsdk.core.kt.j.j(ed.tl(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(7)
    public String m() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(20)
    public String mi() {
        return oq.m();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(30)
    public String p() {
        return com.bytedance.sdk.openadsdk.core.kt.j.qv();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(4)
    public String r() {
        return com.bytedance.sdk.openadsdk.core.kt.v();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(27)
    public String s() {
        return com.bytedance.sdk.openadsdk.core.kt.f();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(22)
    public String tj() {
        return com.bytedance.sdk.openadsdk.core.kt.tl();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(9)
    public String tl() {
        return com.bytedance.sdk.openadsdk.core.kt.i();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(5)
    public String up() {
        Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
        if (context == null) {
            return "";
        }
        return Settings.Global.getString(context.getContentResolver(), bi.J);
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(24)
    public String v() {
        return com.bytedance.sdk.openadsdk.core.kt.g();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(13)
    public String vl() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(19)
    public String w() {
        return com.bytedance.sdk.openadsdk.core.kt.ae();
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(15)
    public String ws() {
        return String.valueOf(uf.i());
    }

    @Override // com.bytedance.sdk.component.r.j
    @ATSMethod(25)
    public String x() {
        return com.bytedance.sdk.openadsdk.core.kt.r();
    }
}
