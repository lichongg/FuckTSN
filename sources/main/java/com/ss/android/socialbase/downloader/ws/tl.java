package com.ss.android.socialbase.downloader.ws;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes6.dex */
public class tl extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<j> f39014j;

    public interface j {
        void j(Message message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar = this.f39014j.get();
        if (jVar == null || message == null) {
            return;
        }
        jVar.j(message);
    }

    public tl(Looper looper, j jVar) {
        super(looper);
        this.f39014j = new WeakReference<>(jVar);
    }
}
