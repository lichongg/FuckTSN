package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class l extends Handler {

    /* renamed from: j, reason: collision with root package name */
    protected WeakReference<j> f26890j;

    public interface j {
        void j(Message message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar;
        WeakReference<j> weakReference = this.f26890j;
        if (weakReference == null || (jVar = weakReference.get()) == null || message == null) {
            return;
        }
        jVar.j(message);
    }

    public l(Looper looper, j jVar) {
        super(looper);
        if (jVar != null) {
            this.f26890j = new WeakReference<>(jVar);
        }
    }
}
