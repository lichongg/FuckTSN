package xyz.adscope.ad;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class u implements Application.ActivityLifecycleCallbacks, o3 {

    /* renamed from: b, reason: collision with root package name */
    private int f56006b = 0;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<p3> f56005a = new CopyOnWriteArrayList<>();

    @Override // xyz.adscope.ad.o3
    public Application.ActivityLifecycleCallbacks a() {
        return this;
    }

    private void b() {
        if (this.f56005a.isEmpty()) {
            return;
        }
        Iterator<p3> it = this.f56005a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // xyz.adscope.ad.o3
    public void a(p3 p3Var) {
        this.f56005a.add(p3Var);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        this.f56006b++;
        this.f56005a.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i6 = this.f56006b - 1;
        this.f56006b = i6;
        if (i6 == 0) {
            b();
        }
    }

    u() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
