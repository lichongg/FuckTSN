package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.os.PowerManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private PowerManager.WakeLock f20218a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f20219b = false;

    public synchronized boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (activity.isDestroyed()) {
            return false;
        }
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870913, "CpuWakeLock");
        this.f20218a = newWakeLock;
        newWakeLock.acquire();
        this.f20219b = true;
        return true;
    }

    public synchronized void c() {
        PowerManager.WakeLock wakeLock = this.f20218a;
        if (wakeLock != null) {
            wakeLock.release();
            this.f20218a = null;
            this.f20219b = false;
        }
    }

    public boolean a() {
        return this.f20219b;
    }
}
