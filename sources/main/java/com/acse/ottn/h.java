package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static h f4548c;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f4550b = new Handler(Looper.myLooper());

    /* renamed from: a, reason: collision with root package name */
    public final rx.h f4549a = Schedulers.from(this);

    public static synchronized rx.h a() {
        rx.h hVar;
        synchronized (h.class) {
            try {
                if (f4548c == null) {
                    f4548c = new h();
                }
                hVar = f4548c.f4549a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f4550b.post(runnable);
    }
}
