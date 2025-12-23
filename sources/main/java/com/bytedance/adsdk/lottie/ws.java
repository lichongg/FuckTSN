package com.bytedance.adsdk.lottie;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws<K, V> {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<K, V> f23569j;

    /* renamed from: m, reason: collision with root package name */
    private int f23570m;

    /* renamed from: r, reason: collision with root package name */
    private int f23571r;
    private int tl;
    private int up;
    private int xt;

    public final V j(K k6) {
        V put;
        if (k6 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v5 = this.f23569j.get(k6);
                if (v5 != null) {
                    this.ae++;
                    return v5;
                }
                this.tl++;
                V xt = xt(k6);
                if (xt == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.up++;
                        put = this.f23569j.put(k6, xt);
                        if (put != null) {
                            this.f23569j.put(k6, put);
                        } else {
                            this.xt += cw(k6, xt);
                        }
                    } finally {
                    }
                }
                if (put != null) {
                    return put;
                }
                j(this.cw);
                return xt;
            } finally {
            }
        }
    }

    public final synchronized String toString() {
        int i6;
        int i7;
        try {
            i6 = this.ae;
            i7 = this.tl + i6;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.cw), Integer.valueOf(this.ae), Integer.valueOf(this.tl), Integer.valueOf(i7 != 0 ? (i6 * 100) / i7 : 0));
    }

    protected int xt(K k6, V v5) {
        return 1;
    }

    protected V xt(K k6) {
        return null;
    }

    public ws(int i6) {
        if (i6 > 0) {
            this.cw = i6;
            this.f23569j = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int cw(K k6, V v5) {
        int xt = xt(k6, v5);
        if (xt >= 0) {
            return xt;
        }
        throw new IllegalStateException("Negative size: " + k6 + ContainerUtils.KEY_VALUE_DELIMITER + v5);
    }

    public final V j(K k6, V v5) {
        V put;
        if (k6 != null && v5 != null) {
            synchronized (this) {
                try {
                    this.f23571r++;
                    this.xt += cw(k6, v5);
                    put = this.f23569j.put(k6, v5);
                    if (put != null) {
                        this.xt -= cw(k6, put);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            j(this.cw);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.xt     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<K, V> r0 = r3.f23569j     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.xt     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L51
            goto L14
        L12:
            r4 = move-exception
            goto L70
        L14:
            int r0 = r3.xt     // Catch: java.lang.Throwable -> L12
            if (r0 <= r4) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.f23569j     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L4f
        L21:
            java.util.LinkedHashMap<K, V> r0 = r3.f23569j     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, V> r2 = r3.f23569j     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.xt     // Catch: java.lang.Throwable -> L12
            int r0 = r3.cw(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.xt = r2     // Catch: java.lang.Throwable -> L12
            int r0 = r3.f23570m     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.f23570m = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L51:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r4     // Catch: java.lang.Throwable -> L12
        L70:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.ws.j(int):void");
    }
}
