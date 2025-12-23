package com.jg.ids;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: D:\Downloads\app\classes10.dex */
final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ a f35511a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a aVar, Looper looper) {
        super(looper);
        this.f35511a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            this.f35511a.a(message);
        } catch (Throwable th) {
        }
    }
}
