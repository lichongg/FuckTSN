package com.bytedance.sdk.openadsdk.core.ws;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f31301j;
    private static volatile long xt;
    private final Queue<j> cw = new LinkedList();

    /* renamed from: r, reason: collision with root package name */
    private Handler f31302r;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private final long f31304j;
        private final String xt;

        private j(long j6, String str) {
            this.f31304j = j6;
            this.xt = str;
        }
    }

    private synchronized boolean xt(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int xt2 = xt();
        long cw = cw();
        if (this.cw.size() <= 0 || this.cw.size() < xt2) {
            this.cw.offer(new j(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - this.cw.peek().f31304j);
            if (abs <= cw) {
                xt(cw - abs);
                return true;
            }
            this.cw.poll();
            this.cw.offer(new j(currentTimeMillis, str));
        }
        return false;
    }

    protected abstract long cw();

    public synchronized String up() {
        String str;
        try {
            HashMap hashMap = new HashMap();
            for (j jVar : this.cw) {
                if (hashMap.containsKey(jVar.xt)) {
                    hashMap.put(jVar.xt, Integer.valueOf(((Integer) hashMap.get(jVar.xt)).intValue() + 1));
                } else {
                    hashMap.put(jVar.xt, 1);
                }
            }
            str = "";
            int i6 = Integer.MIN_VALUE;
            for (String str2 : hashMap.keySet()) {
                int intValue = ((Integer) hashMap.get(str2)).intValue();
                if (i6 < intValue) {
                    str = str2;
                    i6 = intValue;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    protected abstract int xt();

    public synchronized boolean j(String str) {
        try {
            if (xt(str)) {
                j(true);
                j(xt);
            } else {
                j(false);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f31301j;
    }

    public boolean r() {
        return f31301j;
    }

    protected xt() {
    }

    private void j(long j6) {
        if (this.f31302r == null) {
            this.f31302r = new Handler(Looper.getMainLooper());
        }
        this.f31302r.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ws.xt.1
            @Override // java.lang.Runnable
            public void run() {
                xt.this.j(false);
            }
        }, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(boolean z5) {
        f31301j = z5;
    }

    private synchronized void xt(long j6) {
        xt = j6;
    }
}
