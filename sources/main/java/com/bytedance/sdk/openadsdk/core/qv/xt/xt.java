package com.bytedance.sdk.openadsdk.core.qv.xt;

import android.os.Looper;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends g {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30005j;

    /* renamed from: m, reason: collision with root package name */
    private String f30006m;

    /* renamed from: r, reason: collision with root package name */
    private long f30007r;
    private String up;
    private com.bytedance.sdk.openadsdk.core.qv.xt.j xt;

    static class j {
        private long cw;

        /* renamed from: j, reason: collision with root package name */
        private String f30008j;

        /* renamed from: m, reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.core.qv.xt.j f30009m;

        /* renamed from: r, reason: collision with root package name */
        private String f30010r;
        private String up;
        private long xt;

        public j j(String str) {
            this.f30008j = str;
            return this;
        }

        public j xt(long j6) {
            this.cw = j6;
            return this;
        }

        public j cw(String str) {
            this.up = str;
            return this;
        }

        public j j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
            this.f30009m = jVar;
            return this;
        }

        public j xt(String str) {
            this.f30010r = str;
            return this;
        }

        j() {
        }

        public j j(long j6) {
            this.xt = j6;
            return this;
        }

        public void j() {
            xt xtVar = new xt("tt_csj_download_thread");
            xtVar.f30006m = this.up;
            xtVar.up = this.f30010r;
            xtVar.f30007r = this.cw;
            xtVar.cw = this.xt;
            xtVar.f30005j = this.f30008j;
            xtVar.xt = this.f30009m;
            xt.xt(xtVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.xt == null) {
            return;
        }
        String str = this.f30005j;
        str.getClass();
        switch (str) {
            case "onIdle":
                this.xt.j();
                break;
            case "onInstalled":
                this.xt.j(this.up, this.f30006m);
                break;
            case "onDownloadActive":
                this.xt.j(this.cw, this.f30007r, this.up, this.f30006m);
                break;
            case "onDownloadFailed":
                this.xt.cw(this.cw, this.f30007r, this.up, this.f30006m);
                break;
            case "onDownloadPaused":
                this.xt.xt(this.cw, this.f30007r, this.up, this.f30006m);
                break;
            case "onDownloadFinished":
                this.xt.j(this.cw, this.up, this.f30006m);
                break;
        }
    }

    public xt(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            tj.m().post(runnable);
        } else {
            runnable.run();
        }
    }
}
