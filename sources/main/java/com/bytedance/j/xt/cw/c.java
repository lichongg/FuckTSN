package com.bytedance.j.xt.cw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.j.xt.tl.d;
import com.bytedance.j.xt.tl.e;
import com.bytedance.j.xt.tl.g;
import com.bytedance.j.xt.tl.i;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f24177c = {"version_code", "manifest_version_code", CommonNetImpl.AID, "update_version_code"};

    /* renamed from: a, reason: collision with root package name */
    private Context f24178a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f24179b = new JSONObject();

    private void a(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f24178a.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(bi.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private String b() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private void c(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.f24178a.getResources().getDisplayMetrics();
            int i6 = displayMetrics.densityDpi;
            String str = i6 != 120 ? i6 != 240 ? i6 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i6);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    public static c d(Context context) {
        c cVar = new c(context);
        JSONObject e6 = cVar.e();
        cVar.h(e6);
        cVar.c(e6);
        cVar.j(e6);
        cVar.k(e6);
        cVar.i(e6);
        cVar.a(e6);
        cVar.n(e6);
        return cVar;
    }

    @SuppressLint({"MissingPermission"})
    private void h(JSONObject jSONObject) {
        int i6;
        try {
            ApplicationInfo applicationInfo = this.f24178a.getPackageManager().getPackageInfo(this.f24178a.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null && (i6 = applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.f24178a.getString(i6));
            }
            jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.17-cloud");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", b());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(bi.F, Build.BRAND);
            jSONObject.put(bi.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", l());
        } catch (Exception unused) {
        }
    }

    private void i(JSONObject jSONObject) {
        try {
            jSONObject.put(bi.Q, e.b(this.f24178a));
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    private void j(JSONObject jSONObject) {
        try {
            String language = this.f24178a.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put(AgConnectInfo.AgConnectKey.REGION, country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put(bi.M, rawOffset);
        } catch (Exception unused) {
        }
    }

    private void k(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (d.a()) {
                sb.append("MIUI-");
            } else if (d.d()) {
                sb.append("FLYME-");
            } else {
                String b6 = d.b();
                if (d.c(b6)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(b6)) {
                    sb.append(b6);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", g.d());
        } catch (Throwable unused) {
        }
    }

    private String l() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                int i6 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    sb.append(strArr[i6]);
                    if (i6 != strArr.length - 1) {
                        sb.append(", ");
                    }
                    i6++;
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e6) {
            i.c(e6);
            return "unknown";
        }
    }

    public JSONObject e() {
        return this.f24179b;
    }

    public JSONObject f(String str) {
        try {
            this.f24179b.put("device_id", str);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        return this.f24179b;
    }

    public JSONObject g(@Nullable Map<String, Object> map) {
        if (map == null) {
            return this.f24179b;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.f24179b.has(entry.getKey())) {
                this.f24179b.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f24177c) {
            if (map.containsKey(str)) {
                try {
                    this.f24179b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.f24179b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.f24179b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.f24179b.put("udid", map.get("iid"));
            this.f24179b.remove("iid");
        }
        return this.f24179b;
    }

    public c(Context context) {
        this.f24178a = context;
    }

    private void n(JSONObject jSONObject) {
        Map<String, Object> f6;
        Object obj;
        com.bytedance.j.xt.up.c d6 = com.bytedance.j.xt.e.d();
        if (d6 != null && jSONObject != null && (f6 = d6.f()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : f6.keySet()) {
                    if (!TextUtils.isEmpty(str) && (obj = f6.get(str)) != null) {
                        jSONObject2.put(str, obj);
                    }
                }
                jSONObject.put("custom", jSONObject2);
            } catch (Exception e6) {
                i.c(e6);
            }
        }
    }

    public JSONObject m(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f24179b.put(SocializeConstants.TENCENT_UID, str);
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        return this.f24179b;
    }
}
