package com.baidu.liantian.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.stub.StubApp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static Lock f10352b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    private static f f10353c = null;

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.liantian.rp.f.a f10354a;

    public static f a(Context context) {
        f fVar = f10353c;
        if (fVar != null) {
            return fVar;
        }
        try {
            f10352b.lock();
            if (f10353c == null) {
                f10353c = new f(context);
            }
            return f10353c;
        } finally {
            f10352b.unlock();
        }
    }

    public final void b() {
        com.baidu.liantian.rp.f.a aVar = this.f10354a;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f10354a.a(message);
    }

    private f(Context context) {
        this.f10354a = new com.baidu.liantian.rp.f.a(context);
    }

    public final void a() {
        com.baidu.liantian.rp.f.a aVar = this.f10354a;
        if (aVar.f10497d == null) {
            aVar.f10497d = new com.baidu.liantian.rp.e.a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        StubApp.getOrigApplicationContext(aVar.f10495b.getApplicationContext()).registerReceiver(aVar.f10497d, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}
