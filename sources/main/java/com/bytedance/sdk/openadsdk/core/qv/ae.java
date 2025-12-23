package com.bytedance.sdk.openadsdk.core.qv;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.qv.r.az;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements r {

    /* renamed from: j, reason: collision with root package name */
    private cw f29875j;

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(String str, String str2, String str3, String str4, int i6, String str5, String str6) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(final String str, final String str2, final String str3, final int i6, final String str4, String str5, int i7, final String str6, final String str7) {
        if (!this.f29875j.cw()) {
            return false;
        }
        long r5 = this.f29875j.r();
        final TTAdInteractionListener j6 = az.j();
        if (j6 == null || !j(1440L, this.f29875j.ae())) {
            return false;
        }
        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.ae.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("app_name", str);
                hashMap.put("app_icon_url", str2);
                hashMap.put("event_id", Integer.valueOf(i6));
                hashMap.put(bi.f40972o, str3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", str7);
                    jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str4);
                    jSONObject.putOpt(CommonNetImpl.TAG, str6);
                } catch (Exception unused) {
                }
                boolean cw = uf.cw(v.getContext(), str3);
                hashMap.put("event_token", com.bytedance.sdk.component.utils.j.xt(jSONObject.toString()));
                j6.onAdEvent(cw ? 102 : 101, hashMap);
            }
        }, r5 * 1000);
        return true;
    }

    public ae(cw cwVar) {
        this.f29875j = cwVar;
    }

    public boolean j(long j6, int i6) {
        try {
            Long l6 = -1L;
            boolean z5 = true;
            try {
                l6 = Long.valueOf(j6 * 60000);
            } catch (Exception e6) {
                vl.xt("notification", "error", e6.getMessage());
                i6 = -1;
            }
            if (l6.longValue() >= 0 && i6 >= 0 && l6.longValue() != 0 && i6 != 0) {
                String j7 = j();
                StringBuilder sb = new StringBuilder();
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(j7)) {
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
                String[] split = j7.split("_");
                int length = split.length;
                if (length < i6) {
                    Long.parseLong(split[length - 1]);
                    for (String str : split) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
                int i7 = length - i6;
                if (currentTimeMillis - Long.parseLong(split[i7]) <= l6.longValue()) {
                    z5 = false;
                }
                for (int i8 = i7; i8 < length; i8++) {
                    String str2 = split[i8];
                    if (i8 != i7 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append("_");
                    }
                }
                sb.append(currentTimeMillis);
                j(sb.toString());
                return z5;
            }
            return false;
        } catch (Exception e7) {
            vl.j(e7);
            return false;
        }
    }

    public static String j() {
        return com.bytedance.sdk.openadsdk.core.xt.j().xt("notification_b", "");
    }

    public static void j(String str) {
        com.bytedance.sdk.openadsdk.core.xt.j().j("notification_b", str);
    }
}
