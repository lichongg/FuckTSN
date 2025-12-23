package com.bxkj.student.v2.ai.fitness.camera;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f20559a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f20560b = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        if (this.f20560b.get()) {
            return;
        }
        runnable.run();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull final Runnable command) {
        if (this.f20560b.get()) {
            return;
        }
        this.f20559a.execute(new Runnable() { // from class: com.bxkj.student.v2.ai.fitness.camera.j
            @Override // java.lang.Runnable
            public final void run() {
                k.this.b(command);
            }
        });
    }

    public void shutdown() {
        this.f20560b.set(true);
    }

    public k(@NonNull Executor executor) {
        this.f20559a = executor;
    }
}
