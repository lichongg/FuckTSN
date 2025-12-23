package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.content.ComponentName;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import com.orhanobut.logger.j;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3StepService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3StepService.kt\ncom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3StepService extends LifecycleService {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private V3StepObserver f22058a;

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        ComponentName component;
        j.d("StepService->onTaskRemoved", new Object[0]);
        if (g0.g((intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName(), "com.acse.ottn.activity.TransparentGreenActivity")) {
            j.d("来自省钱助手的错误杀进程", new Object[0]);
            return;
        }
        V3StepObserver v3StepObserver = this.f22058a;
        if (v3StepObserver != null) {
            v3StepObserver.onDestroy();
        }
        V3StepObserver v3StepObserver2 = this.f22058a;
        if (v3StepObserver2 != null) {
            getLifecycle().removeObserver(v3StepObserver2);
        }
    }

    public V3StepService() {
        if (this.f22058a == null) {
            V3StepObserver v3StepObserver = new V3StepObserver(this);
            this.f22058a = v3StepObserver;
            getLifecycle().addObserver(v3StepObserver);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        return 1;
    }
}
