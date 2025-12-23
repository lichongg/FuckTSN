package com.bytedance.sdk.openadsdk.core.component.reward.j.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.up.r.r;
import com.bytedance.sdk.openadsdk.core.v;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile xt f28292j;
    private final cw cw;

    /* renamed from: r, reason: collision with root package name */
    private long f28293r;
    private final Context xt;

    public static xt j() {
        if (f28292j == null) {
            synchronized (xt.class) {
                try {
                    if (f28292j == null) {
                        f28292j = new xt(v.getContext());
                    }
                } finally {
                }
            }
        }
        return f28292j;
    }

    public void xt() {
        File[] listFiles;
        r.j(7).j();
        r.j(8).j();
        File cw = (("mounted".equals(com.bytedance.sdk.openadsdk.l.cw.j()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.xt.cw(this.xt) != null) ? com.bytedance.sdk.openadsdk.api.plugin.xt.cw(this.xt) : com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.xt);
        if (cw == null || !cw.exists() || !cw.isDirectory() || (listFiles = cw.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            try {
                m.cw(file);
            } catch (Throwable unused) {
            }
        }
    }

    private xt(Context context) {
        Context origApplicationContext;
        if (context == null) {
            origApplicationContext = v.getContext();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.xt = origApplicationContext;
        this.cw = new cw();
    }

    public String j(boolean z5, String str) {
        long cw = v.xt().cw(str);
        if (cw > 0 && System.currentTimeMillis() - this.f28293r < cw) {
            return "1";
        }
        int i6 = z5 ? 7 : 8;
        n xt = xt(z5, str);
        if (xt == null) {
            return "0";
        }
        if (xt.c() + xt.ch() < System.currentTimeMillis()) {
            r.j(i6).j(str);
            return "1";
        }
        JSONObject j6 = j(xt);
        if (j6 != null) {
            this.f28293r = System.currentTimeMillis();
            return j6.toString();
        }
        return "0";
    }

    public void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j(xtVar, str);
    }

    public synchronized n xt(boolean z5, String str) {
        n j6 = com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(z5, false).j(str, 0L);
        if (j6 == null) {
            return null;
        }
        if (tj.cw(j6)) {
            if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                return j6;
            }
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(j6)) {
            return j6;
        }
        if (ln.ws(j6) == null) {
            return null;
        }
        return j6;
    }

    private JSONObject j(n nVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", nVar.la());
            jSONObject.put(CommonNetImpl.AID, Long.valueOf(nVar.so()));
            jSONObject.put("cid", Long.valueOf(nVar.fs()));
            jSONObject.put("price", nVar.ed());
            jSONObject.put("material_key", nVar.wq());
            jSONObject.put("s_send_ts", nVar.c());
            jSONObject.put("cache_time", nVar.ch());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, nVar.s());
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        this.cw.j(str, xtVar);
    }

    public com.bytedance.sdk.openadsdk.i.cw.cw.xt j(String str) {
        return this.cw.j(str);
    }
}
