package com.bytedance.sdk.component.tl.xt.ae;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.tl.j.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static int cw = 3000;

    /* renamed from: r, reason: collision with root package name */
    private static volatile j f26756r;

    /* renamed from: j, reason: collision with root package name */
    private volatile HandlerThread f26757j;
    private Looper up;
    private volatile Handler xt = null;

    public static j j(up upVar) {
        if (f26756r == null) {
            synchronized (j.class) {
                try {
                    if (f26756r == null) {
                        f26756r = new j(upVar);
                    }
                } finally {
                }
            }
        }
        return f26756r;
    }

    public int xt() {
        if (cw <= 0) {
            cw = 3000;
        }
        return cw;
    }

    private j(up upVar) {
        this.f26757j = null;
        this.up = null;
        if (upVar != null && upVar.r() != null && upVar.r().az() != null) {
            this.up = upVar.r().az();
        } else {
            this.f26757j = new HandlerThread("csj_ad_log", 10);
            this.f26757j.start();
        }
    }

    public Handler j() {
        if (this.up != null) {
            if (this.xt == null) {
                synchronized (j.class) {
                    try {
                        if (this.xt == null) {
                            this.xt = new Handler(this.up);
                        }
                    } finally {
                    }
                }
            }
        } else if (this.f26757j != null && this.f26757j.isAlive()) {
            if (this.xt == null) {
                synchronized (j.class) {
                    try {
                        if (this.xt == null) {
                            this.xt = new Handler(this.f26757j.getLooper());
                        }
                    } finally {
                    }
                }
            }
        } else {
            synchronized (j.class) {
                try {
                    if (this.f26757j != null) {
                        if (!this.f26757j.isAlive()) {
                        }
                    }
                    this.f26757j = new HandlerThread("csj_init_handle", -1);
                    this.f26757j.start();
                    this.xt = new Handler(this.f26757j.getLooper());
                } finally {
                }
            }
        }
        return this.xt;
    }
}
