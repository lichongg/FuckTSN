package com.bytedance.pangle.up;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static Class f25536j;
    private static Object xt;

    public static final Object j() {
        if (xt == null) {
            try {
                synchronized (j.class) {
                    try {
                        if (xt == null) {
                            if (f25536j == null) {
                                f25536j = Class.forName("android.app.ActivityThread");
                            }
                            xt = MethodUtils.invokeStaticMethod(f25536j, "currentActivityThread", new Object[0]);
                        }
                        if (xt == null && Looper.myLooper() != Looper.getMainLooper()) {
                            final Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.up.j.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        try {
                                            Object unused = j.xt = MethodUtils.invokeStaticMethod(j.f25536j, "currentActivityThread", new Object[0]);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        } catch (Exception e6) {
                                            ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e6);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        synchronized (obj) {
                                            obj.notify();
                                            throw th;
                                        }
                                    }
                                }
                            });
                            if (xt == null) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(5000L);
                                    } catch (InterruptedException e6) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e6);
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Exception e7) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e7);
            }
        }
        return xt;
    }
}
