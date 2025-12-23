package com.baidu.liantian;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f10457a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f10458b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f10459c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f10460d;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f10461e;

    /* renamed from: f, reason: collision with root package name */
    public SharedPreferences.Editor f10462f;

    /* renamed from: g, reason: collision with root package name */
    private Context f10463g;

    public final void a(long j6) {
        this.f10459c.putLong("npuct", j6);
        this.f10459c.commit();
    }

    public final String b() {
        return this.f10457a.getString("svi_n", "");
    }

    public final String c() {
        return this.f10457a.getString("ses_ic", "");
    }

    public final boolean d() {
        return this.f10457a.getBoolean("bka", true);
    }

    public final String e() {
        try {
            String str = new String(F.getInstance().ad(Base64.decode(this.f10457a.getString("lsl", ""), 0), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)));
            b.a();
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final long f() {
        return this.f10457a.getLong("lslt", 0L);
    }

    public final void g() {
        this.f10459c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.f10459c.commit();
    }

    public final int h() {
        return this.f10457a.getInt("wi_fa_pu_ap", 0);
    }

    public final void b(int i6) {
        this.f10459c.putInt("mo_fa_pu_ap", i6);
        this.f10459c.commit();
    }

    public final void c(int i6) {
        this.f10459c.putInt("mo_ae_fa_ct", i6);
        this.f10459c.commit();
    }

    public final void d(int i6) {
        this.f10459c.putInt("rtqe", i6);
        this.f10459c.commit();
    }

    public final void f(int i6) {
        this.f10459c.putInt("sustfd", i6);
        this.f10459c.commit();
    }

    public final void h(int i6) {
        this.f10462f.putInt("g_r_d_d_n", i6);
        this.f10462f.commit();
    }

    public final int i() {
        return this.f10457a.getInt("mo_fa_pu_ap", 0);
    }

    public final void j() {
        this.f10459c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f10459c.commit();
    }

    public final void k() {
        this.f10459c.putLong("se_ae_fd", System.currentTimeMillis());
        this.f10459c.commit();
    }

    public final int l() {
        return this.f10457a.getInt("wi_fa_pu_cl", 0);
    }

    public final int m() {
        return this.f10457a.getInt("mo_fa_pu_cl", 0);
    }

    public final int n() {
        return this.f10457a.getInt("mo_ae_fa_ct", 0);
    }

    public final boolean o() {
        return this.f10457a.getBoolean("hac", false);
    }

    public final List<Integer> p() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10457a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e6) {
                    e6.getMessage();
                    b.b();
                }
            }
        }
        return arrayList;
    }

    public final List<Integer> q() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10457a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e6) {
                    e6.getMessage();
                    b.b();
                }
            }
        }
        return arrayList;
    }

    public final int r() {
        return this.f10457a.getInt("rtqe", 0);
    }

    public final void s() {
        this.f10459c.putBoolean("lpcf", true);
        this.f10459c.commit();
    }

    public final int t() {
        return this.f10457a.getInt("pdcg", 0);
    }

    public final int u() {
        return this.f10457a.getInt("sustfd", 0);
    }

    public final int v() {
        return this.f10457a.getInt("sufzfd", 0);
    }

    public final List<com.baidu.liantian.rp.a.a> w() {
        com.baidu.liantian.rp.a.a a6;
        String string = this.f10461e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (a6 = com.baidu.liantian.rp.a.a.a(str)) != null) {
                arrayList.add(a6);
            }
        }
        return arrayList;
    }

    public final int x() {
        if ("com.baidu.BaiduMap.meizu".equals(this.f10463g.getPackageName())) {
            return this.f10461e.getInt("re_net_hr", 24);
        }
        int i6 = this.f10461e.getInt("re_net_hr", 3);
        try {
            String[] g6 = com.baidu.liantian.b.e.g(this.f10463g);
            if (g6 != null && g6.length == 2 && !TextUtils.isEmpty(g6[0]) && !TextUtils.isEmpty(g6[1]) && "200080".equals(g6[0])) {
                if ("com.baidu.BaiduMap".equals(this.f10463g.getPackageName()) && i6 < 24) {
                    return 24;
                }
            }
        } catch (Throwable unused) {
        }
        return i6;
    }

    public final int y() {
        return this.f10461e.getInt("up_nu_li", 100);
    }

    public e(Context context) {
        try {
            this.f10463g = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadliantiancfg", 4);
            this.f10457a = sharedPreferences;
            this.f10459c = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("leroadcfg", 4);
            this.f10458b = sharedPreferences2;
            this.f10460d = sharedPreferences2.edit();
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("reliantian_po_rt", 4);
            this.f10461e = sharedPreferences3;
            this.f10462f = sharedPreferences3.edit();
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }

    public final boolean a() {
        return this.f10457a.getBoolean("iio", false);
    }

    public final void g(int i6) {
        this.f10459c.putInt("sufzfd", i6);
        this.f10459c.commit();
    }

    public final void a(String str) {
        this.f10459c.putString("ses_ic", str);
        this.f10459c.commit();
    }

    public final void b(long j6) {
        String str;
        try {
            if (j6 == 0) {
                this.f10459c.putString("pdcgts", "");
                this.f10459c.commit();
                return;
            }
            String string = this.f10457a.getString("pdcgts", "");
            if (TextUtils.isEmpty(string)) {
                str = String.valueOf(j6);
            } else {
                if (string.split("_").length >= 20) {
                    return;
                }
                str = string + "_" + String.valueOf(j6);
            }
            b.a();
            this.f10459c.putString("pdcgts", str);
            this.f10459c.commit();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final void c(long j6) {
        this.f10459c.putLong("slruct", j6);
        this.f10459c.commit();
    }

    public final void d(long j6) {
        this.f10462f.putLong("re_last_ofline_time", j6);
        this.f10462f.commit();
    }

    public final void f(long j6) {
        this.f10462f.putLong("re_day_b_t", j6);
        this.f10462f.commit();
    }

    public final void a(String str, long j6) {
        b.a();
        try {
            this.f10459c.putString("lsl", Base64.encodeToString(F.getInstance().ae(str.getBytes(), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)), 0));
            this.f10459c.putLong("lslt", j6);
            this.f10459c.commit();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final void e(int i6) {
        this.f10459c.putInt("pdcg", i6);
        this.f10459c.commit();
    }

    public final void e(long j6) {
        this.f10462f.putLong("re_day_len", j6);
        this.f10462f.commit();
    }

    public final void a(int i6) {
        this.f10459c.putInt("wi_fa_pu_ap", i6);
        this.f10459c.commit();
    }

    public final void a(int... iArr) {
        if (iArr.length == 0) {
            this.f10459c.putString("hcpk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < iArr.length; i6++) {
                sb.append(iArr[i6]);
                if (i6 != iArr.length - 1) {
                    sb.append("-");
                }
            }
            this.f10459c.putString("hcpk", sb.toString());
        }
        this.f10459c.commit();
    }

    public final String b(String str) {
        return this.f10461e.getString("al_da" + str, "");
    }

    public final void a(List<Integer> list) {
        if (list.size() == 0) {
            this.f10459c.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(list.get(i6));
                if (i6 != list.size() - 1) {
                    sb.append("-");
                }
            }
            this.f10459c.putString("glspk", sb.toString());
        }
        this.f10459c.commit();
    }

    public final void a(int i6, int i7, int i8) {
        String str;
        if (i6 == 0) {
            str = "sustfits";
        } else if (i6 != 1) {
            str = "";
        } else {
            str = "suetfite";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10459c.putInt(str + i7, i8);
        this.f10459c.commit();
    }

    public final int a(int i6, int i7) {
        String str;
        if (i6 == 0) {
            str = "sustfits";
        } else if (i6 != 1) {
            str = "";
        } else {
            str = "suetfite";
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return this.f10457a.getInt(str + i7, 0);
    }

    public final void a(com.baidu.liantian.rp.a.a aVar) {
        String string = this.f10461e.getString("re_con", "");
        this.f10462f.putString("re_con", string + "||" + com.baidu.liantian.rp.a.a.a(aVar));
        this.f10462f.commit();
    }
}
