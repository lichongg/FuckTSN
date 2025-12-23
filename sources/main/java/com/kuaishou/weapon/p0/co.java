package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.connect.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes6.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    private Context f35911a;

    public String a(String str) {
        JSONObject a6;
        JSONObject a7;
        try {
            cm cmVar = new cm(str, ck.f35879l);
            String a8 = dl.a(cu.f35929a);
            String b6 = b(a8);
            if (TextUtils.isEmpty(b6) || (a6 = cmVar.a(this.f35911a)) == null) {
                return null;
            }
            String str2 = cu.f35936h + "?" + cv.a(this.f35911a);
            if (cu.a() && cu.f35929a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, b6);
            jSONObject.put("host", a8);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put("head", a6);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(ck.f35875h) && (a7 = a()) != null) {
                jSONObject.put("sjd", a7);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    public co(Context context) {
        this.f35911a = context;
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a6 = h.a(this.f35911a, "re_po_rt");
            a6.e("a1_p_s_p_s");
            a6.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f35911a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, ajVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f35911a) ? 1 : 0);
            Object a7 = ai.a(this.f35911a);
            if (a7 != null) {
                jSONObject.put("4", a7);
            }
            a6.b(df.ac, 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a8 = acVar.a(this.f35911a);
            jSONObject.put("8", a8 ? 1 : 0);
            if (a8) {
                jSONObject.put("61", acVar.b(this.f35911a));
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, acVar.e(this.f35911a));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, acVar.c(this.f35911a));
            ae aeVar = new ae();
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b6 = aoVar.b();
            jSONObject.put("66", b6 ? 1 : 0);
            if (b6) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f35911a));
            jSONObject2.put("03014", bh.g(this.f35911a));
            jSONObject2.put("03020", bv.b(this.f35911a));
            jSONObject2.put("03030", bg.d(this.f35911a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new an().d());
            jSONObject.put("60", ab.b(this.f35911a) ? 1 : 0);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
