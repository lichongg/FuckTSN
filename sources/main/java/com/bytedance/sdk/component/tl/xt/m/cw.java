package com.bytedance.sdk.component.tl.xt.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.component.utils.vl;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements xt {
    private com.bytedance.sdk.component.tl.j.up cw;

    /* renamed from: j, reason: collision with root package name */
    private final Context f26785j;
    private final up xt;

    @SuppressLint({"StaticFieldLeak"})
    private class j extends com.bytedance.sdk.component.tl.xt.up.xt {
        private final String cw;

        /* renamed from: r, reason: collision with root package name */
        private final Map<String, String> f26788r;
        private final r xt;

        boolean j(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
        }

        private j(r rVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.xt = rVar;
            this.cw = str;
            this.f26788r = map;
        }

        private void j(com.bytedance.sdk.component.tl.j.j.up upVar, com.bytedance.sdk.component.tl.j.r rVar, r rVar2, String str, String str2) {
            try {
                rVar.j(this.xt.j(), j(upVar, rVar2, str, str2));
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.tl.j.r r5 = cw.this.cw.r();
            if (r5 == null || cw.this.cw.getContext() == null || !r5.r()) {
                return;
            }
            if (!j(this.xt.cw())) {
                r rVar = this.xt;
                j(null, r5, rVar, rVar.cw(), "not http url");
                return;
            }
            if (this.xt.up() == 0) {
                cw.this.xt.delete(this.xt);
                r rVar2 = this.xt;
                j(null, r5, rVar2, rVar2.cw(), "retry max");
                return;
            }
            try {
                if (this.xt.up() == 5) {
                    cw.this.xt.insert(this.xt);
                }
                if (!r5.j(cw.this.getContext())) {
                    r rVar3 = this.xt;
                    j(null, r5, rVar3, rVar3.cw(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String cw = this.xt.cw();
                if (r5.oq() == 0) {
                    cw = cw(this.xt.cw());
                    if (this.xt.r()) {
                        cw = xt(cw);
                    }
                }
                String str = cw;
                com.bytedance.sdk.component.tl.j.j.xt ae = r5.ae();
                com.bytedance.sdk.component.tl.j.j.up upVar = null;
                if (ae == null) {
                    j(null, this.xt, str, "no executor");
                    return;
                }
                ae.j("User-Agent", r5.up());
                ae.j("csj_client_source_from", "1");
                if (this.f26788r != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f26788r.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    ae.j("csj_extra_info", jSONObject.toString());
                }
                ae.j(str);
                try {
                    upVar = ae.j();
                } catch (Throwable unused) {
                }
                if (upVar == null || !upVar.j()) {
                    if (upVar != null && upVar.cw() == 8848) {
                        upVar.r();
                        cw.this.xt.delete(this.xt);
                    }
                    com.bytedance.sdk.component.tl.j.up unused2 = cw.this.cw;
                    this.xt.j(r0.up() - 1);
                    if (this.xt.up() == 0) {
                        cw.this.xt.delete(this.xt);
                        com.bytedance.sdk.component.tl.j.up unused3 = cw.this.cw;
                    } else {
                        cw.this.xt.update(this.xt);
                    }
                    if (upVar != null) {
                        upVar.r();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                } else {
                    cw.this.xt.delete(this.xt);
                    com.bytedance.sdk.component.tl.j.up unused4 = cw.this.cw;
                    System.currentTimeMillis();
                }
                j(upVar, r5, this.xt, str, null);
            } catch (Throwable unused5) {
            }
        }

        private String cw(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("{TS}") || str.contains("__TS__")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
                }
                if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.cw)) {
                    return str.replace("{UID}", this.cw).replace("__UID__", this.cw);
                }
                return str;
            }
            return str;
        }

        String xt(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return str.replace("[ss_random]", String.valueOf(cw.xt().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            return str;
        }

        private JSONObject j(com.bytedance.sdk.component.tl.j.j.up upVar, r rVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (rVar != null) {
                try {
                    jSONObject.put("retry_count", 5 - rVar.up());
                    JSONObject j6 = rVar.j();
                    if (j6 != null) {
                        jSONObject.put("track_type", j6.optString("track_type", ""));
                    }
                    jSONObject.put("url", str);
                    jSONObject.put("current", System.currentTimeMillis());
                    jSONObject.put("error_msg", str2);
                    if (upVar != null) {
                        jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_CODE, upVar.cw());
                        String xt = upVar.xt();
                        if (!TextUtils.isEmpty(xt)) {
                            if (xt.length() > 5000) {
                                xt = xt.substring(0, 5000);
                            }
                            jSONObject.put("http_response", xt);
                        }
                        jSONObject.put("success", upVar.j() ? 1 : 0);
                    }
                } catch (JSONException unused) {
                }
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random xt() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public Context getContext() {
        Context context = this.f26785j;
        return context == null ? this.cw.getContext() : context;
    }

    public cw(up upVar, com.bytedance.sdk.component.tl.j.up upVar2) {
        this.f26785j = upVar2.getContext();
        this.xt = upVar;
        this.cw = upVar2;
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.xt
    public void j(String str, List<String> list, boolean z5, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.tl.j.r r5 = this.cw.r();
        if (r5 == null || this.cw.getContext() == null || r5.tl() == null || !r5.r() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            r5.tl().execute(new j(new r(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z5, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.m.xt
    public void j(final String str) {
        com.bytedance.sdk.component.tl.j.r r5 = this.cw.r();
        if (r5 == null || this.cw.getContext() == null || !r5.r()) {
            return;
        }
        com.bytedance.sdk.component.tl.xt.up.xt xtVar = new com.bytedance.sdk.component.tl.xt.up.xt("trackFailedUrls") { // from class: com.bytedance.sdk.component.tl.xt.m.cw.1
            @Override // java.lang.Runnable
            public void run() {
                cw.this.j(cw.this.xt.j(), str);
            }
        };
        xtVar.j(1);
        if (r5.tl() != null) {
            r5.tl().execute(xtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<r> list, String str) {
        String str2;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.tl.j.r r5 = this.cw.r();
        for (r rVar : list) {
            if (r5 == null || r5.tl() == null) {
                str2 = str;
            } else {
                str2 = str;
                r5.tl().execute(new j(rVar, str2, null));
            }
            str = str2;
        }
    }
}
