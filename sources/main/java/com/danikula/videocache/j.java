package com.danikula.videocache;

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
/* loaded from: D:\Downloads\app\classes4.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f32202a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final String f32203b;

    /* renamed from: c, reason: collision with root package name */
    private volatile h f32204c;

    /* renamed from: d, reason: collision with root package name */
    private final List<e> f32205d;

    /* renamed from: e, reason: collision with root package name */
    private final e f32206e;

    /* renamed from: f, reason: collision with root package name */
    private final f f32207f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a extends Handler implements e {

        /* renamed from: a, reason: collision with root package name */
        private final String f32208a;

        /* renamed from: b, reason: collision with root package name */
        private final List<e> f32209b;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<e> it = this.f32209b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f32208a, message.arg1);
            }
        }

        public a(String str, List<e> list) {
            super(Looper.getMainLooper());
            this.f32208a = str;
            this.f32209b = list;
        }

        @Override // com.danikula.videocache.e
        public void a(File file, String str, int i6) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i6;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    private synchronized void a() {
        if (this.f32202a.decrementAndGet() <= 0) {
            this.f32204c.m();
            this.f32204c = null;
        }
    }

    private synchronized void g() throws ProxyCacheException {
        try {
            this.f32204c = this.f32204c == null ? c() : this.f32204c;
        } catch (Throwable th) {
            throw th;
        }
    }

    private h c() throws ProxyCacheException {
        h hVar = new h(new k(this.f32203b, this.f32207f.f32161d), new com.danikula.videocache.file.b(this.f32207f.a(this.f32203b), this.f32207f.f32160c));
        hVar.t(this.f32206e);
        return hVar;
    }

    public int b() {
        return this.f32202a.get();
    }

    public void e(e eVar) {
        this.f32205d.add(eVar);
    }

    public void f() {
        this.f32205d.clear();
        if (this.f32204c != null) {
            this.f32204c.t(null);
            this.f32204c.m();
            this.f32204c = null;
        }
        this.f32202a.set(0);
    }

    public void h(e eVar) {
        this.f32205d.remove(eVar);
    }

    public j(String str, f fVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f32205d = copyOnWriteArrayList;
        this.f32203b = (String) n.d(str);
        this.f32207f = (f) n.d(fVar);
        this.f32206e = new a(str, copyOnWriteArrayList);
    }

    public void d(g gVar, Socket socket) throws ProxyCacheException, IOException {
        g();
        try {
            this.f32202a.incrementAndGet();
            this.f32204c.s(gVar, socket);
        } finally {
            a();
        }
    }
}
