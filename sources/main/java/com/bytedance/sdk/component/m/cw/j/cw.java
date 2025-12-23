package com.bytedance.sdk.component.m.cw.j;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw<K, V> {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<K, SoftReference<V>> f26544j;

    /* renamed from: m, reason: collision with root package name */
    private int f26545m;

    /* renamed from: r, reason: collision with root package name */
    private int f26546r;
    private int tl;
    private int up;
    private int xt;

    public final V j(K k6) {
        V v5;
        if (k6 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.f26544j.get(k6);
                if (softReference != null) {
                    v5 = softReference.get();
                    if (v5 != null) {
                        this.ae++;
                        return v5;
                    }
                    this.f26544j.remove(k6);
                } else {
                    v5 = null;
                }
                this.tl++;
                V xt = xt(k6);
                if (xt == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.up++;
                        SoftReference<V> put = this.f26544j.put(k6, new SoftReference<>(xt));
                        if (put != null) {
                            v5 = put.get();
                        }
                        if (v5 != null) {
                            this.f26544j.put(k6, put);
                        } else {
                            this.xt += cw(k6, xt);
                        }
                    } finally {
                    }
                }
                if (v5 != null) {
                    return v5;
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.cw), Integer.valueOf(this.ae), Integer.valueOf(this.tl), Integer.valueOf(i7 != 0 ? (i6 * 100) / i7 : 0));
    }

    protected int xt(K k6, V v5) {
        return 1;
    }

    protected V xt(K k6) {
        return null;
    }

    public cw(int i6) {
        if (i6 > 0) {
            this.cw = i6;
            this.f26544j = new LinkedHashMap<>(0, 0.75f, true);
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
        V v6;
        if (k6 != null && v5 != null) {
            synchronized (this) {
                try {
                    this.f26546r++;
                    this.xt += cw(k6, v5);
                    SoftReference<V> put = this.f26544j.put(k6, new SoftReference<>(v5));
                    if (put != null) {
                        v6 = put.get();
                        if (v6 != null) {
                            this.xt -= cw(k6, v6);
                        }
                    } else {
                        v6 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            j(this.cw);
            return v6;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
    
        com.bytedance.sdk.component.utils.vl.r("LruCache", "oom maybe occured, clear cache. size= " + r3.xt + ", maxSize: " + r4);
        r3.xt = 0;
        r3.f26544j.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
    
        return;
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
            if (r0 < 0) goto L54
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.f26544j     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.xt     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            goto L54
        L12:
            r4 = move-exception
            goto L7b
        L14:
            int r0 = r3.xt     // Catch: java.lang.Throwable -> L12
            if (r0 > r4) goto L1a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L1a:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.f26544j     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L2e
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L2e:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.f26544j     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L12
            int r2 = r3.xt     // Catch: java.lang.Throwable -> L12
            int r0 = r3.cw(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.xt = r2     // Catch: java.lang.Throwable -> L12
        L4c:
            int r0 = r3.f26545m     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.f26545m = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L54:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.xt     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            r1.append(r4)     // Catch: java.lang.Throwable -> L12
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L12
            com.bytedance.sdk.component.utils.vl.r(r0, r4)     // Catch: java.lang.Throwable -> L12
            r4 = 0
            r3.xt = r4     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.f26544j     // Catch: java.lang.Throwable -> L12
            r4.clear()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L7b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.m.cw.j.cw.j(int):void");
    }

    public final void j() {
        j(-1);
    }
}
