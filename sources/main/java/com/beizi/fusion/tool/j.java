package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class j extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f13717a;

    public Context a() {
        WeakReference<Context> weakReference = this.f13717a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f13717a.get();
    }

    public abstract void a(Message message);

    public j(Context context) {
        super(Looper.getMainLooper());
        this.f13717a = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        WeakReference<Context> weakReference = this.f13717a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        a(message);
    }
}
