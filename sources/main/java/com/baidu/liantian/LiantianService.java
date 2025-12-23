package com.baidu.liantian;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LiantianService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f10327a = 0;

    static /* synthetic */ void a(LiantianService liantianService) {
        try {
            liantianService.f10327a--;
            if (liantianService.f10327a <= 0) {
                liantianService.f10327a = 0;
                b.a();
                liantianService.stopSelf();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i6, int i7) {
        try {
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i6, i7);
        }
        this.f10327a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        intent.getAction();
        b.a();
        r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    System.currentTimeMillis();
                    intent.getAction();
                    b.a();
                    if ("s".equals(intent.getStringExtra(bi.aL))) {
                        String stringExtra2 = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra(bi.aL, "s");
                        intent2.putExtra("c", stringExtra2);
                        a.a(StubApp.getOrigApplicationContext(LiantianService.this.getApplicationContext()), intent2);
                    }
                    b.a();
                    if (TextUtils.isEmpty(stringExtra)) {
                        LiantianService.a(LiantianService.this);
                        return;
                    }
                    if (LiantianService.this.getPackageName().equals(stringExtra)) {
                        LiantianService liantianService = LiantianService.this;
                        LiantianService.a(liantianService, liantianService.getClassLoader(), intent);
                        LiantianService.a(LiantianService.this);
                        return;
                    }
                    g a6 = g.a();
                    if (a6 == null) {
                        LiantianService.a(LiantianService.this);
                        return;
                    }
                    ApkInfo d6 = a6.d(stringExtra);
                    Objects.toString(d6);
                    b.a();
                    if (d6 == null) {
                        LiantianService.a(LiantianService.this);
                        return;
                    }
                    LiantianService.a(LiantianService.this, d6.classLoader, intent);
                    System.currentTimeMillis();
                    intent.toString();
                    b.a();
                    LiantianService.a(LiantianService.this);
                } catch (Throwable unused2) {
                    com.baidu.liantian.b.e.a();
                    LiantianService.a(LiantianService.this);
                }
            }
        });
        return super.onStartCommand(intent, i6, i7);
    }

    static /* synthetic */ void a(LiantianService liantianService, ClassLoader classLoader, Intent intent) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            Object newInstance = loadClass.newInstance();
            Objects.toString(newInstance);
            b.a();
            String stringExtra = intent.getStringExtra("target_method");
            b.a();
            loadClass.getDeclaredMethod(stringExtra, Context.class, Intent.class).invoke(newInstance, StubApp.getOrigApplicationContext(liantianService.getApplicationContext()), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }
}
