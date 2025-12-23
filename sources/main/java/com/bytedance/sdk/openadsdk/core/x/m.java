package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.openadsdk.core.tj;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class m {

    /* renamed from: j, reason: collision with root package name */
    private static final String f31308j = "m";
    private final Set<String> xt = new HashSet(1);

    public abstract void j();

    public abstract void j(String str);

    protected final synchronized boolean j(String str, int i6) {
        if (i6 == 0) {
            return j(str, r.GRANTED);
        }
        return j(str, r.DENIED);
    }

    public synchronized boolean xt(String str) {
        return true;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.x.m$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f31313j;

        static {
            int[] iArr = new int[r.values().length];
            f31313j = iArr;
            try {
                iArr[r.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31313j[r.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31313j[r.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean j(final String str, r rVar) {
        this.xt.remove(str);
        int i6 = AnonymousClass5.f31313j[rVar.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.m.2
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.j(str);
                    }
                });
                return true;
            }
            if (i6 == 3) {
                if (xt(str)) {
                    if (this.xt.isEmpty()) {
                        tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.m.3
                            @Override // java.lang.Runnable
                            public void run() {
                                m.this.j();
                            }
                        });
                        return true;
                    }
                } else {
                    tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.m.4
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.j(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.xt.isEmpty()) {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.j();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void j(String[] strArr) {
        Collections.addAll(this.xt, strArr);
    }
}
