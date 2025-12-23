package com.jg.ids;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class a extends f {

    /* renamed from: b, reason: collision with root package name */
    private static Handler f35507b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private Handler f35508c;

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f35509d;

    protected abstract void a(Message message);

    protected abstract void b();

    public a(Context context, String str) {
        super(context);
        this.f35508c = null;
        this.f35509d = null;
        try {
            this.f35509d = new HandlerThread(str);
            this.f35509d.start();
            this.f35508c = new b(this, this.f35509d.getLooper());
            if (c() && d()) {
                b();
            }
        } catch (Throwable th) {
        }
    }

    protected final void b(Message message) {
        this.f35508c.sendMessage(message);
    }

    protected final Message a() {
        return this.f35508c.obtainMessage();
    }

    protected static void a(Runnable runnable) {
        f35507b.post(runnable);
    }

    protected void a(int i6, String str) {
        switch (i6) {
            case 0:
                a(new c(this, str));
                break;
            case 1:
                a(new d(this, str));
                break;
            case 2:
                a(new e(this, str));
                break;
        }
    }
}
