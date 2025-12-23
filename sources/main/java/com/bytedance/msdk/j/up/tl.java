package com.bytedance.msdk.j.up;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<j> f25149j;

    public interface j {
        void j(Message message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar = this.f25149j.get();
        if (jVar == null || message == null) {
            return;
        }
        jVar.j(message);
    }

    public tl(Looper looper, j jVar) {
        super(looper);
        this.f25149j = new WeakReference<>(jVar);
    }
}
