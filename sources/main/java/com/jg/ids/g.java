package com.jg.ids;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class g extends f {

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f35528b;

    protected abstract Intent a();

    protected abstract void a(IBinder iBinder);

    public g(Context context) {
        super(context);
        this.f35528b = new h(this);
        if (c() && d()) {
            try {
                this.f35525a.bindService(a(), this.f35528b, 1);
            } catch (Throwable th) {
            }
        }
    }

    protected final void b() {
        try {
            this.f35525a.unbindService(this.f35528b);
        } catch (Throwable th) {
        }
    }
}
