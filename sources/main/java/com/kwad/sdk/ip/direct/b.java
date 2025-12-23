package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bw;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static Handler aRF = new Handler(Looper.getMainLooper());
    static int aRP = 80;
    static int port = 80;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends Thread {
        LinkedList aRR = new LinkedList();
        volatile boolean aRS = false;
        Selector aRQ = Selector.open();

        final void shutdown() {
            this.aRS = true;
            Selector selector = this.aRQ;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }

        private void MN() {
            synchronized (this.aRR) {
                while (this.aRR.size() > 0) {
                    try {
                        C0700b c0700b = (C0700b) this.aRR.removeFirst();
                        try {
                            c0700b.aRW.register(this.aRQ, 8, c0700b);
                        } catch (Throwable th) {
                            c0700b.aRW.close();
                            c0700b.aRX = th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        private void MO() {
            Iterator<SelectionKey> it = this.aRQ.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0700b c0700b = (C0700b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0700b.aSb = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bw.c(socketChannel);
                    c0700b.aRX = th;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aRQ.select() > 0) {
                        MO();
                    }
                    MN();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aRS) {
                    Selector selector = this.aRQ;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        a() {
            setName("Connector");
        }

        final void a(C0700b c0700b) {
            final SocketChannel socketChannel;
            Handler handler;
            Runnable runnable;
            try {
                try {
                    socketChannel = SocketChannel.open();
                    try {
                        socketChannel.configureBlocking(false);
                        boolean connect = socketChannel.connect(c0700b.aRV);
                        c0700b.aRW = socketChannel;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        c0700b.aSa = elapsedRealtime;
                        if (connect) {
                            c0700b.aSb = elapsedRealtime;
                            bw.c(socketChannel);
                        } else {
                            synchronized (this.aRR) {
                                this.aRR.add(c0700b);
                            }
                            Selector selector = this.aRQ;
                            if (selector != null) {
                                try {
                                    selector.wakeup();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        handler = b.aRF;
                        runnable = new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bw.c(socketChannel);
                            }
                        };
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bw.c(socketChannel);
                            c0700b.aRX = th;
                            handler = b.aRF;
                            runnable = new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bw.c(socketChannel);
                                }
                            };
                            handler.postDelayed(runnable, c0700b.aRZ);
                        } catch (Throwable th2) {
                            try {
                                b.aRF.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        bw.c(socketChannel);
                                    }
                                }, c0700b.aRZ);
                            } catch (Throwable unused2) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    socketChannel = null;
                }
                handler.postDelayed(runnable, c0700b.aRZ);
            } catch (Throwable unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    static class C0700b {
        InetSocketAddress aRV;
        SocketChannel aRW;
        Throwable aRX;
        private float aRY;
        long aRZ;
        long aSa;
        long aSb = 0;
        boolean aSc = false;
        private boolean success;

        final void MP() {
            String str;
            if (this.aSb != 0) {
                str = Long.toString(this.aSb - this.aSa) + "ms";
                this.aRY = this.aSb - this.aSa;
                this.success = true;
            } else {
                Throwable th = this.aRX;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.aRV + " : " + str);
            this.aSc = true;
        }

        C0700b(String str) {
            try {
                this.aRV = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aRX = th;
            }
        }
    }

    public static c f(String str, long j6) {
        a aVar;
        long j7 = j6 / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i6 = 0; i6 < cVar.MQ(); i6++) {
                C0700b c0700b = new C0700b(str);
                c0700b.aRZ = j6 + j7;
                linkedList.add(c0700b);
                try {
                    aVar.a(c0700b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j6 + j7);
                try {
                    aVar.shutdown();
                    aVar.join();
                    Iterator it = linkedList.iterator();
                    boolean z5 = true;
                    float f6 = 0.0f;
                    while (it.hasNext()) {
                        C0700b c0700b2 = (C0700b) it.next();
                        c0700b2.MP();
                        z5 &= c0700b2.success;
                        cVar.bJ(z5);
                        f6 += c0700b2.aRY;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f6 + "*size:" + linkedList.size());
                    cVar.k(f6 / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
