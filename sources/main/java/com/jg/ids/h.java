package com.jg.ids;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: D:\Downloads\app\classes10.dex */
final class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ g f35530a;

    h(g gVar) {
        this.f35530a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f35530a.a(iBinder);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
