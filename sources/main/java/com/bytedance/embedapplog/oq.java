package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\Downloads\app\classes3.dex */
final class oq<SERVICE, RESULT> {
    private final xt<SERVICE, RESULT> cw;

    /* renamed from: j, reason: collision with root package name */
    private final CountDownLatch f24022j = new CountDownLatch(1);

    /* renamed from: r, reason: collision with root package name */
    private final Context f24023r;
    private final Intent xt;

    class j implements ServiceConnection {
        private final CountDownLatch cw;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        SERVICE f24024j;

        /* renamed from: r, reason: collision with root package name */
        private final xt<SERVICE, RESULT> f24025r;

        j(CountDownLatch countDownLatch, xt<SERVICE, RESULT> xtVar) {
            this.cw = countDownLatch;
            this.f24025r = xtVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            uc.j("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.f24024j = this.f24025r.j(iBinder);
            } catch (Throwable th) {
                try {
                    uc.cw("ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.cw.countDown();
                    } catch (Exception e6) {
                        uc.j(e6);
                    }
                } finally {
                    try {
                        this.cw.countDown();
                    } catch (Exception e7) {
                        uc.j(e7);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            uc.j("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.cw.countDown();
            } catch (Exception e6) {
                uc.j(e6);
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }
    }

    interface xt<T, RESULT> {
        T j(IBinder iBinder);

        RESULT j(T t5);
    }

    RESULT j() {
        oq<SERVICE, RESULT>.j jVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            uc.cw("Don't do this in ui thread.", null);
            return null;
        }
        try {
            jVar = new j(this.f24022j, this.cw);
            this.f24023r.bindService(this.xt, jVar, 1);
            this.f24022j.await();
        } catch (Throwable th) {
            th = th;
            jVar = null;
        }
        try {
            return this.cw.j((xt<SERVICE, RESULT>) jVar.f24024j);
        } catch (Throwable th2) {
            th = th2;
            try {
                uc.j(th);
                return null;
            } finally {
                j(jVar);
            }
        }
    }

    oq(Context context, Intent intent, xt<SERVICE, RESULT> xtVar) {
        this.f24023r = context;
        this.xt = intent;
        this.cw = xtVar;
    }

    private void j(oq<SERVICE, RESULT>.j jVar) {
        if (jVar != null) {
            try {
                this.f24023r.unbindService(jVar);
            } catch (Throwable th) {
                uc.j(th);
            }
        }
    }
}
