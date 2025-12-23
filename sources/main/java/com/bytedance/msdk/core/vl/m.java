package com.bytedance.msdk.core.vl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class m {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24766j = "m";
    private Looper xt = Looper.getMainLooper();
    private final Set<String> cw = new HashSet(1);

    public abstract void j();

    public abstract void j(String str);

    protected final synchronized boolean j(@NonNull String str, int i6) {
        if (i6 == 0) {
            return j(str, r.GRANTED);
        }
        return j(str, r.DENIED);
    }

    public synchronized boolean xt(String str) {
        com.bytedance.msdk.j.up.cw.xt(f24766j, "permission not found:".concat(String.valueOf(str)));
        return true;
    }

    /* renamed from: com.bytedance.msdk.core.vl.m$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f24771j;

        static {
            int[] iArr = new int[r.values().length];
            f24771j = iArr;
            try {
                iArr[r.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24771j[r.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24771j[r.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean j(@NonNull final String str, r rVar) {
        this.cw.remove(str);
        int i6 = AnonymousClass5.f24771j[rVar.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                new Handler(this.xt).post(new Runnable() { // from class: com.bytedance.msdk.core.vl.m.2
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.j(str);
                    }
                });
                return true;
            }
            if (i6 == 3) {
                if (xt(str)) {
                    if (this.cw.isEmpty()) {
                        new Handler(this.xt).post(new Runnable() { // from class: com.bytedance.msdk.core.vl.m.3
                            @Override // java.lang.Runnable
                            public void run() {
                                m.this.j();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.xt).post(new Runnable() { // from class: com.bytedance.msdk.core.vl.m.4
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.j(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.cw.isEmpty()) {
            new Handler(this.xt).post(new Runnable() { // from class: com.bytedance.msdk.core.vl.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.j();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void j(@NonNull String[] strArr) {
        Collections.addAll(this.cw, strArr);
    }
}
