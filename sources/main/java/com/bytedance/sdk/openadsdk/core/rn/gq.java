package com.bytedance.sdk.openadsdk.core.rn;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class gq {

    /* renamed from: j, reason: collision with root package name */
    public static final int f30074j = com.bytedance.sdk.component.utils.kt.m(com.bytedance.sdk.openadsdk.core.v.getContext(), "tt_shake_tag_key");
    private static final ConcurrentHashMap<ViewGroup, Object> xt = new ConcurrentHashMap<>();
    private static final Object cw = new Object();

    /* renamed from: r, reason: collision with root package name */
    private static volatile boolean f30075r = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        if (r0.top < r1.top) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cw() {
        /*
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.rn.gq.xt
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto La
            goto Lb4
        La:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.v.getContext()
            int r1 = com.bytedance.sdk.openadsdk.core.rn.ed.up(r1)
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r5 = r3
            r6 = r5
            r4 = 2147483647(0x7fffffff, float:NaN)
        L23:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r0.next()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L23
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            boolean r9 = r7.getGlobalVisibleRect(r8)
            if (r9 != 0) goto L42
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.rn.gq.xt
            r8.remove(r7)
            goto L23
        L42:
            boolean r9 = com.bytedance.sdk.openadsdk.core.uf.j(r7)
            if (r9 != 0) goto L4e
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.rn.gq.xt
            r8.remove(r7)
            goto L23
        L4e:
            int r9 = r1 / 2
            int r10 = r8.bottom
            if (r10 > r9) goto L57
            int r11 = r9 - r10
            goto L5a
        L57:
            r11 = 2147483647(0x7fffffff, float:NaN)
        L5a:
            int r8 = r8.top
            if (r8 < r9) goto L61
            int r12 = r8 - r9
            goto L64
        L61:
            r12 = 2147483647(0x7fffffff, float:NaN)
        L64:
            if (r10 <= r9) goto L6a
            if (r8 >= r9) goto L6a
            r5 = r7
            goto L77
        L6a:
            int r8 = java.lang.Math.min(r12, r11)
            if (r8 >= r4) goto L73
            r5 = r7
            r4 = r8
            goto L23
        L73:
            if (r8 != r4) goto L23
            r6 = r7
            goto L23
        L77:
            if (r5 != 0) goto L7a
            goto Lb4
        L7a:
            if (r6 == 0) goto L93
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.getGlobalVisibleRect(r1)
            int r0 = r0.top
            int r1 = r1.top
            if (r0 >= r1) goto L93
            goto L94
        L93:
            r6 = r5
        L94:
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.rn.gq.xt
            java.lang.Object r1 = r0.get(r6)
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.xt.cw
            if (r1 == 0) goto La5
            java.lang.Object r1 = r0.get(r6)
            r3 = r1
            com.bytedance.sdk.openadsdk.core.xt.cw r3 = (com.bytedance.sdk.openadsdk.core.xt.cw) r3
        La5:
            r1 = 1
            j(r6, r1)
            r0.clear()
            r0 = 0
            com.bytedance.sdk.openadsdk.core.rn.gq.f30075r = r0
            if (r3 == 0) goto Lb4
            r3.j()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.gq.cw():void");
    }

    public static void j(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.xt.cw cwVar) {
        if (weakReference == null || cwVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.uf.j(viewGroup)) {
            j(viewGroup, false);
            return;
        }
        xt.put(viewGroup, cwVar);
        if (f30075r) {
            j(viewGroup, false);
            return;
        }
        synchronized (gq.class) {
            try {
                if (f30075r) {
                    j(viewGroup, false);
                } else {
                    f30075r = true;
                    com.bytedance.sdk.openadsdk.core.tj.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.gq.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gq.cw();
                        }
                    }, 50L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
    
        if (r0.top < r1.top) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd A[LOOP:1: B:32:0x0097->B:40:0x00dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void r() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.gq.r():void");
    }

    private gq() {
    }

    public static boolean j(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(f30074j);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void j(ViewGroup viewGroup, boolean z5) {
        if (viewGroup == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_shake_efficient", Boolean.valueOf(z5));
        int i6 = f30074j;
        Object tag = viewGroup.getTag(i6);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("TTShakeChecker", th.getMessage());
                j(f30074j, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(i6, hashMap);
    }

    public static void j(final int i6, final String str) {
        com.bytedance.sdk.openadsdk.core.kt.xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.gq.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i6);
                    jSONObject.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_shake_tag_key").xt(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void j(WeakReference<ViewGroup> weakReference, float f6, float f7, long j6) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.uf.j(viewGroup) && j(f6, f7, j6)) {
            xt.put(viewGroup, cw);
            if (f30075r) {
                return;
            }
            synchronized (gq.class) {
                try {
                    if (f30075r) {
                        return;
                    }
                    f30075r = true;
                    com.bytedance.sdk.openadsdk.core.tj.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.gq.3
                        @Override // java.lang.Runnable
                        public void run() {
                            gq.r();
                        }
                    }, 50L);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean j(float f6, float f7, long j6) {
        if (f6 == -1.0f) {
            return true;
        }
        if (f6 < 0.0f) {
            return false;
        }
        if (f6 == 0.0f && f7 == 2.1474836E9f) {
            return true;
        }
        if (f7 <= f6) {
            return false;
        }
        float currentTimeMillis = (System.currentTimeMillis() - j6) / 1000.0f;
        return currentTimeMillis >= f6 && currentTimeMillis <= f7;
    }
}
