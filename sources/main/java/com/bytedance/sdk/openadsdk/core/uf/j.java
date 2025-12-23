package com.bytedance.sdk.openadsdk.core.uf;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.oq;
import com.bytedance.sdk.openadsdk.core.tj.st;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final j f30516j = new j();
    private st ae;
    private boolean tl;
    private String xt = "";
    private String cw = "";

    /* renamed from: r, reason: collision with root package name */
    private String f30518r = "";
    private String up = "";

    /* renamed from: m, reason: collision with root package name */
    private JSONArray f30517m = new JSONArray();

    private Long cw() {
        Long valueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.cw = valueOf.toString();
        return valueOf;
    }

    public static j j() {
        return f30516j;
    }

    private String xt() {
        Enumeration<InetAddress> inetAddresses;
        String hostAddress;
        String str = null;
        if (!oq.oq()) {
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null && (inetAddresses = byName.getInetAddresses()) != null) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet6Address) && nextElement.isLinkLocalAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                        str = hostAddress;
                    }
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        this.xt = TextUtils.isEmpty(str) ? "" : str;
        return str;
    }

    public void j(Context context) {
        if (!v.xt().jy()) {
            this.tl = false;
            return;
        }
        if (this.tl) {
            return;
        }
        try {
            xt();
            r();
            cw();
            xt(context);
            cw(context);
            this.ae = com.bytedance.sdk.openadsdk.core.rn.v.g();
            this.tl = true;
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private j() {
    }

    private Long r() {
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.up = String.valueOf(currentTimeMillis);
        return Long.valueOf(currentTimeMillis);
    }

    private JSONArray cw(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("com.ss.android.ugc.aweme", "a");
            hashMap.put("com.ss.android.ugc.aweme.lite", "al");
            hashMap.put("com.dragon.read", t.f36150k);
            hashMap.put("com.ss.android.article.news", "n");
            hashMap.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : hashMap.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j6 = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j6);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.f30517m = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    private ActivityManager.MemoryInfo xt(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.f30518r = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    public void j(st stVar) {
        this.ae = stVar;
    }

    public void j(JSONObject jSONObject) {
        if (v.xt().jy()) {
            try {
                st stVar = this.ae;
                if (stVar != null) {
                    JSONObject cw = stVar.cw();
                    cw.put("sl", 0);
                    jSONObject.put("u_t", cw);
                }
                jSONObject.put("boot_time_sec", this.up);
                jSONObject.put("memory", this.f30518r);
                jSONObject.put("disk", this.cw);
                jSONObject.put("client_tun", this.xt);
                jSONObject.put("pkg_info", this.f30517m);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }
}
