package com.bytedance.msdk.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.tl.x;
import com.bytedance.msdk.up.m;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    private static volatile j cw;

    /* renamed from: j, reason: collision with root package name */
    private static Context f25167j;
    private static volatile j xt;

    private static class j {
        private final JSONObject ae;
        private final String cw;

        /* renamed from: j, reason: collision with root package name */
        private final Handler f25177j;

        /* renamed from: m, reason: collision with root package name */
        private final int f25178m;
        private Map<String, Object> oq;

        /* renamed from: r, reason: collision with root package name */
        private final long f25179r;
        private final long tl;
        private final int up;
        private volatile boolean xt = false;

        /* renamed from: g, reason: collision with root package name */
        private int f25176g = 0;

        static /* synthetic */ int xt(j jVar) {
            int i6 = jVar.f25176g;
            jVar.f25176g = i6 + 1;
            return i6;
        }

        public j(String str, long j6, long j7, int i6, int i7, JSONObject jSONObject, Map<String, Object> map) {
            this.tl = j6 == -1 ? System.currentTimeMillis() : j6;
            this.cw = str;
            this.f25179r = j7;
            this.up = i6;
            this.f25178m = i7;
            this.ae = jSONObject;
            this.oq = map;
            this.f25177j = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.f25177j.postDelayed(new Runnable() { // from class: com.bytedance.msdk.m.r.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.xt(j.this);
                    if (j.this.f25176g >= 5 || r.j()) {
                        j.this.j(1);
                        return;
                    }
                    com.bytedance.msdk.j.up.cw.j("TMe", "--==-- 重试一次 eventType:" + j.this.cw + ", 重试次数：" + j.this.f25176g);
                    j.this.j();
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void j(int i6) {
            try {
                this.f25177j.removeCallbacksAndMessages(null);
                if (this.xt) {
                    return;
                }
                this.xt = true;
                if (i6 == 1) {
                    com.bytedance.msdk.j.up.cw.j("TMe", "--==-- 最终上报：eventType:" + this.cw + ", 重试次数：" + this.f25176g + ", did: " + r.up());
                } else if (i6 == 2) {
                    com.bytedance.msdk.j.up.cw.j("TMe", "--==-- 最终上报：eventType:" + this.cw + ", 从applog回调中上报, did: " + r.up());
                }
                String str = this.cw;
                int hashCode = str.hashCode();
                if (hashCode != -834688111) {
                    if (hashCode == 270071285 && str.equals("sdk_init")) {
                        r.xt(this.tl);
                    }
                } else if (str.equals("sdk_init_end")) {
                    r.j(this.f25179r, this.up, this.f25178m, this.tl, this.ae, this.oq);
                }
            } finally {
            }
        }
    }

    public static void j(Context context) {
        f25167j = context;
    }

    public static void xt() {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_start_up").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.1
            @Override // java.lang.Runnable
            public void run() {
                m.xt();
            }
        });
    }

    public static void cw() {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_mediation_sdk_init").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.2
            @Override // java.lang.Runnable
            public void run() {
                m.j();
            }
        });
    }

    public static void j(long j6) {
        j jVar = new j("sdk_init", j6, 0L, 0, 0, null, null);
        xt = jVar;
        jVar.j();
    }

    public static void xt(final long j6) {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_sdk_init").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.3
            @Override // java.lang.Runnable
            public void run() {
                m.j(j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String up() {
        return x.j();
    }

    public static void j(long j6, int i6, int i7, JSONObject jSONObject, Map<String, Object> map) {
        j jVar = new j("sdk_init_end", -1L, j6, i6, i7, jSONObject, map);
        cw = jVar;
        jVar.j();
    }

    public static boolean j() {
        return !TextUtils.isEmpty(x.j());
    }

    public static void j(final long j6, final int i6, final int i7, final long j7, final JSONObject jSONObject, final Map<String, Object> map) {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_sdk_init_end").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.4
            @Override // java.lang.Runnable
            public void run() {
                m.j(j6, i6, i7, j7, jSONObject, (Map<String, Object>) map);
            }
        });
    }

    public static void j(final boolean z5) {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_get_config_start").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.5
            @Override // java.lang.Runnable
            public void run() {
                m.j(z5);
            }
        });
    }

    public static void j(final int i6, final int i7, final long j6, final boolean z5, final boolean z6, final JSONObject jSONObject, final long j7, final JSONObject jSONObject2) {
        new com.bytedance.sdk.openadsdk.core.r.xt("track_get_config_final").xt(new Runnable() { // from class: com.bytedance.msdk.m.r.6
            @Override // java.lang.Runnable
            public void run() {
                m.j(i6, i7, j6, z5, z6, jSONObject, j7, jSONObject2);
            }
        });
    }
}
