package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class g {
    private final c aLd;
    private final AtomicInteger aLh = new AtomicInteger(0);
    private volatile e aLi;
    private final List<b> aLj;
    private final b aLk;
    private final String url;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Handler implements b {
        private final List<b> aLj;
        private final String url;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.aLj.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aLj = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i6) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i6;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    private synchronized void Kp() {
        try {
            if (this.aLd.aKP == 1 && isOkHttpSupported()) {
                this.aLi = this.aLi == null ? Ks() : this.aLi;
            } else {
                this.aLi = this.aLi == null ? Kr() : this.aLi;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void Kq() {
        if (this.aLh.decrementAndGet() <= 0) {
            this.aLi.shutdown();
            this.aLi = null;
        }
    }

    private e Kr() {
        String str = this.url;
        c cVar = this.aLd;
        e eVar = new e(new h(str, cVar.aKN, cVar.aKO), new com.kwad.sdk.core.videocache.a.b(this.aLd.eG(this.url), this.aLd.aKM));
        eVar.a(this.aLk);
        return eVar;
    }

    private e Ks() {
        String str = this.url;
        c cVar = this.aLd;
        e eVar = new e(new j(str, cVar.aKN, cVar.aKO), new com.kwad.sdk.core.videocache.a.b(this.aLd.eG(this.url), this.aLd.aKM));
        eVar.a(this.aLk);
        return eVar;
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int Km() {
        return this.aLh.get();
    }

    public final void shutdown() {
        this.aLj.clear();
        e eVar = this.aLi;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aLi = null;
        this.aLh.set(0);
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.aLj = copyOnWriteArrayList;
        this.url = ax.hh(str);
        this.aLd = (c) ax.checkNotNull(cVar);
        this.aLk = new a(str, copyOnWriteArrayList);
    }

    public final void a(d dVar, Socket socket) {
        Kp();
        try {
            this.aLh.incrementAndGet();
            this.aLi.a(dVar, socket);
        } finally {
            Kq();
        }
    }
}
