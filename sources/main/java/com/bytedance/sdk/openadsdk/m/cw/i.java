package com.bytedance.sdk.openadsdk.m.cw;

import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private long f31585j;

    /* renamed from: r, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.cw.r f31586r;
    private n up;
    private String xt;

    public static class j {
        private Map<String, Object> az;

        /* renamed from: g, reason: collision with root package name */
        private int f31587g;
        private int oq;
        private int qv;
        private int tl;
        private int vl;
        private JSONArray ws;

        /* renamed from: j, reason: collision with root package name */
        private long f31588j = 0;
        private long xt = 0;
        private long cw = 0;

        /* renamed from: r, reason: collision with root package name */
        private boolean f31590r = false;
        private boolean up = false;

        /* renamed from: m, reason: collision with root package name */
        private int f31589m = 0;
        private int ae = 0;
        private boolean jy = false;

        public long cw() {
            return this.xt;
        }

        public void j(JSONArray jSONArray) {
            this.ws = jSONArray;
        }

        public int m() {
            return this.ae;
        }

        public long r() {
            return this.cw;
        }

        public int up() {
            return this.f31589m;
        }

        public long xt() {
            return this.f31588j;
        }

        public int ae() {
            return this.tl;
        }

        public Map<String, Object> av() {
            return this.az;
        }

        public boolean az() {
            return this.up;
        }

        public void cw(long j6) {
            this.cw = j6;
        }

        public int g() {
            long j6 = this.cw;
            if (j6 <= 0) {
                return 0;
            }
            return Math.min((int) ((this.f31588j * 100) / j6), 100);
        }

        public JSONArray j() {
            return this.ws;
        }

        public boolean jy() {
            return this.jy;
        }

        public void m(int i6) {
            this.vl = i6;
        }

        public int oq() {
            return this.oq;
        }

        public int qv() {
            return this.qv;
        }

        public void r(int i6) {
            this.f31587g = i6;
        }

        public int tl() {
            return this.f31587g;
        }

        public void up(int i6) {
            this.oq = i6;
        }

        public int vl() {
            return this.vl;
        }

        public boolean ws() {
            return this.f31590r;
        }

        public void xt(long j6) {
            this.xt = j6;
        }

        public void cw(int i6) {
            this.tl = i6;
        }

        public void j(long j6) {
            this.f31588j = j6;
        }

        public void xt(int i6) {
            this.ae = i6;
        }

        public void cw(boolean z5) {
            this.up = z5;
        }

        public void j(int i6) {
            this.f31589m = i6;
        }

        public void xt(boolean z5) {
            this.f31590r = z5;
        }

        public void j(boolean z5) {
            this.jy = z5;
        }

        public void j(Map<String, Object> map) {
            this.az = map;
        }
    }

    public int cw() {
        return this.cw;
    }

    public long j() {
        return this.f31585j;
    }

    public com.bykv.vk.openvk.component.video.api.cw.r r() {
        return this.f31586r;
    }

    public n up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public i(long j6, String str, int i6, com.bykv.vk.openvk.component.video.api.cw.r rVar, n nVar) {
        this.f31585j = j6;
        this.xt = str;
        this.cw = i6;
        this.f31586r = rVar;
        this.up = nVar;
    }
}
