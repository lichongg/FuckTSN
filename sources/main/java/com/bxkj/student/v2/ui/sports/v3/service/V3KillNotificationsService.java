package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3KillNotificationsService extends Service {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final IBinder f21918a = new a(this, this);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class a extends Binder {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Service f21919a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ V3KillNotificationsService f21920b;

        public a(@NotNull V3KillNotificationsService v3KillNotificationsService, Service service) {
            g0.p(service, "service");
            this.f21920b = v3KillNotificationsService;
            this.f21919a = service;
        }

        @NotNull
        public final Service a() {
            return this.f21919a;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        ComponentName component;
        com.orhanobut.logger.j.d("KillNotificationsService->onTaskRemoved", new Object[0]);
        if (g0.g((intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName(), "com.acse.ottn.activity.TransparentGreenActivity")) {
            com.orhanobut.logger.j.d("来自省钱助手的错误杀进程", new Object[0]);
        } else {
            l.f22009a.b(this);
        }
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@NotNull Intent intent) {
        g0.p(intent, "intent");
        return this.f21918a;
    }

    @Override // android.app.Service
    public void onCreate() {
    }
}
