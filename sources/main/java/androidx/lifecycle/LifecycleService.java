package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import kotlin.Deprecated;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {

    @NotNull
    private final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.dispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @CallSuper
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        g0.p(intent, "intent");
        this.dispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.dispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.dispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @Deprecated(message = "Deprecated in Java")
    @CallSuper
    public void onStart(@Nullable Intent intent, int i6) {
        this.dispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i6);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        return super.onStartCommand(intent, i6, i7);
    }
}
