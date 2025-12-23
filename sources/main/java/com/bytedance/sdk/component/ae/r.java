package com.bytedance.sdk.component.ae;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    public static class j {
        private volatile int cw;

        /* renamed from: j, reason: collision with root package name */
        private volatile Context f26077j;

        /* renamed from: m, reason: collision with root package name */
        private volatile int f26078m;

        /* renamed from: r, reason: collision with root package name */
        private volatile boolean f26079r;
        private volatile boolean up;
        private volatile String xt;

        public j j(Context context) {
            if (context == null) {
                return this;
            }
            this.f26077j = StubApp.getOrigApplicationContext(context.getApplicationContext());
            cw.j(this.f26077j);
            return this;
        }

        public j xt(int i6) {
            this.f26078m = i6;
            return this;
        }

        private com.bytedance.sdk.component.r.j.xt cw() {
            com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.component.ae.xt.j.j.j(this.f26077j, this.xt, this.f26079r, this.f26078m);
            this.up = true;
            if (j6 != null) {
                return j6;
            }
            this.up = false;
            return xt();
        }

        private com.bytedance.sdk.component.r.j.xt xt() {
            return this.f26079r ? com.bytedance.sdk.component.ae.cw.j.j.xt(this.xt) : ((com.bytedance.sdk.component.r.r) AutoService.j(com.bytedance.sdk.component.r.r.class)).j(this.xt);
        }

        public j j(String str) {
            this.xt = str;
            return this;
        }

        public j j(int i6) {
            this.cw = i6;
            return this;
        }

        public j j(boolean z5) {
            this.f26079r = z5;
            return this;
        }

        public com.bytedance.sdk.component.r.j.xt j() {
            if (this.cw != 2) {
                return xt();
            }
            return cw();
        }
    }
}
