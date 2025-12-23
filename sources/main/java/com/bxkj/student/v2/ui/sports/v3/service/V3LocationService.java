package com.bxkj.student.v2.ui.sports.v3.service;

import android.content.ComponentName;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3LocationService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3LocationService.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3LocationService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3LocationService extends LifecycleService {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private V3LocationObserver f21951a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private V3SilentMusicObserver f21952b;

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        ComponentName component;
        String str = null;
        com.orhanobut.logger.j.d("StepService->onTaskRemoved " + (intent != null ? intent.toString() : null), new Object[0]);
        if (intent != null && (component = intent.getComponent()) != null) {
            str = component.getClassName();
        }
        if (g0.g(str, "com.acse.ottn.activity.TransparentGreenActivity")) {
            com.orhanobut.logger.j.d("来自省钱助手的错误杀进程", new Object[0]);
            return;
        }
        V3LocationObserver v3LocationObserver = this.f21951a;
        if (v3LocationObserver != null) {
            v3LocationObserver.onDestroy();
        }
        V3LocationObserver v3LocationObserver2 = this.f21951a;
        if (v3LocationObserver2 != null) {
            getLifecycle().removeObserver(v3LocationObserver2);
        }
        V3SilentMusicObserver v3SilentMusicObserver = this.f21952b;
        if (v3SilentMusicObserver != null) {
            getLifecycle().removeObserver(v3SilentMusicObserver);
        }
    }

    public V3LocationService() {
        if (this.f21951a == null) {
            V3LocationObserver v3LocationObserver = new V3LocationObserver(this);
            this.f21951a = v3LocationObserver;
            getLifecycle().addObserver(v3LocationObserver);
            V3SilentMusicObserver v3SilentMusicObserver = new V3SilentMusicObserver();
            this.f21952b = v3SilentMusicObserver;
            getLifecycle().addObserver(v3SilentMusicObserver);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        return 1;
    }
}
