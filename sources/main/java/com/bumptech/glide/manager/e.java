package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.c;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class e implements c {

    /* renamed from: f, reason: collision with root package name */
    private static final String f15793f = "ConnectivityMonitor";

    /* renamed from: a, reason: collision with root package name */
    private final Context f15794a;

    /* renamed from: b, reason: collision with root package name */
    final c.a f15795b;

    /* renamed from: c, reason: collision with root package name */
    boolean f15796c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15797d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f15798e = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z5 = eVar.f15796c;
            eVar.f15796c = eVar.a(context);
            if (z5 != e.this.f15796c) {
                if (Log.isLoggable(e.f15793f, 3)) {
                    boolean z6 = e.this.f15796c;
                }
                e eVar2 = e.this;
                eVar2.f15795b.a(eVar2.f15796c);
            }
        }
    }

    private void c() {
        if (this.f15797d) {
            return;
        }
        this.f15796c = a(this.f15794a);
        try {
            this.f15794a.registerReceiver(this.f15798e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f15797d = true;
        } catch (SecurityException unused) {
            Log.isLoggable(f15793f, 5);
        }
    }

    private void e() {
        if (this.f15797d) {
            this.f15794a.unregisterReceiver(this.f15798e);
            this.f15797d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.util.k.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable(f15793f, 5);
            return true;
        }
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f15794a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f15795b = aVar;
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        c();
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
        e();
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }
}
