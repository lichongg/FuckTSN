package com.beizi.ad.internal.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f12235a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final String f12236b;

    /* renamed from: c, reason: collision with root package name */
    private volatile e f12237c;

    /* renamed from: d, reason: collision with root package name */
    private final List<b> f12238d;

    /* renamed from: e, reason: collision with root package name */
    private final b f12239e;

    /* renamed from: f, reason: collision with root package name */
    private final c f12240f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a extends Handler implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f12241a;

        /* renamed from: b, reason: collision with root package name */
        private final List<b> f12242b;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.f12242b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f12241a, message.arg1);
            }
        }

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f12241a = str;
            this.f12242b = list;
        }

        @Override // com.beizi.ad.internal.i.b
        public void a(File file, String str, int i6) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i6;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    private synchronized void b() {
        if (this.f12235a.decrementAndGet() <= 0) {
            this.f12237c.a();
            this.f12237c = null;
        }
    }

    public void a(d dVar, Socket socket) throws m, IOException {
        a();
        try {
            this.f12235a.incrementAndGet();
            this.f12237c.a(dVar, socket);
        } finally {
            b();
        }
    }

    private e c() throws m {
        e eVar = new e(new h(this.f12236b, this.f12240f.f12210d), new com.beizi.ad.internal.i.a.b(this.f12240f.a(this.f12236b), this.f12240f.f12209c));
        eVar.a(this.f12239e);
        return eVar;
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f12238d = copyOnWriteArrayList;
        this.f12236b = (String) k.a(str);
        this.f12240f = (c) k.a(cVar);
        this.f12239e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void a() throws m {
        try {
            this.f12237c = this.f12237c == null ? c() : this.f12237c;
        } catch (Throwable th) {
            throw th;
        }
    }
}
