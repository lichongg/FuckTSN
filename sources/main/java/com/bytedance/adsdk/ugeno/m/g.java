package com.bytedance.adsdk.ugeno.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<j> f23708j;

    public interface j {
        void j(Message message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar = this.f23708j.get();
        if (jVar == null || message == null) {
            return;
        }
        jVar.j(message);
    }

    public g(Looper looper, j jVar) {
        super(looper);
        this.f23708j = new WeakReference<>(jVar);
    }
}
