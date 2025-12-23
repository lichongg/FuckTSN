package com.bykv.vk.openvk.component.video.j.xt;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.openvk.component.video.j.xt.ae;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: r, reason: collision with root package name */
    private static volatile m f23070r;
    private volatile com.bykv.vk.openvk.component.video.j.xt.j.xt ae;
    private final AtomicInteger cw = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private final ae.cw f23071g;

    /* renamed from: j, reason: collision with root package name */
    private volatile ServerSocket f23072j;
    private final AtomicBoolean jy;

    /* renamed from: m, reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.j.xt.j.cw f23073m;
    private volatile cw oq;
    private volatile cw qv;
    private final SparseArray<Set<ae>> tl;
    private volatile com.bykv.vk.openvk.component.video.j.xt.xt.cw up;
    private final Runnable vl;
    private volatile int xt;

    private static final class j implements Callable<Boolean> {

        /* renamed from: j, reason: collision with root package name */
        private final String f23078j;
        private final int xt;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.f23078j, this.xt);
            } catch (Throwable th2) {
                socket = null;
                th = th2;
            }
            try {
                socket.setSoTimeout(2000);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.j.cw.j.f22978j));
                outputStream.flush();
                if (ca.f10845k.equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    return Boolean.TRUE;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "call: ", th);
                    m.j("ping error", Log.getStackTraceString(th));
                    return Boolean.FALSE;
                } finally {
                    com.bykv.vk.openvk.component.video.j.cw.j.j(socket);
                }
            }
            return Boolean.FALSE;
        }

        j(String str, int i6) {
            this.f23078j = str;
            this.xt = i6;
        }
    }

    static /* synthetic */ void j(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ae() {
        com.bytedance.sdk.component.oq.tl tlVar = new com.bytedance.sdk.component.oq.tl(new j(g(), this.xt), 5, 1);
        com.bytedance.sdk.component.oq.ae.j().submit(tlVar);
        tl();
        try {
            if (!((Boolean) tlVar.get()).booleanValue()) {
                com.bytedance.sdk.component.utils.vl.r("ProxyServer", "Ping error");
                up();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "pingTest: ");
            if (up.cw) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            Log.getStackTraceString(th);
            up();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.tl) {
            try {
                int size = this.tl.size();
                for (int i6 = 0; i6 < size; i6++) {
                    SparseArray<Set<ae>> sparseArray = this.tl;
                    Set<ae> set = sparseArray.get(sparseArray.keyAt(i6));
                    if (set != null) {
                        arrayList.addAll(set);
                        set.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ae) it.next()).j();
        }
    }

    private void tl() {
        Socket socket = null;
        try {
            try {
                socket = this.f23072j.accept();
                socket.setSoTimeout(2000);
                if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.j.cw.j.f22978j));
                    outputStream.flush();
                }
            } catch (IOException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                Log.getStackTraceString(e6);
            }
            com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "answerPing: ");
        } finally {
            com.bykv.vk.openvk.component.video.j.cw.j.j(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        if (this.cw.compareAndSet(1, 2) || this.cw.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.j.cw.j.j(this.f23072j);
            m();
        }
    }

    cw cw() {
        return this.qv;
    }

    public void r() {
        if (this.jy.compareAndSet(false, true)) {
            com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(this.vl, "r/ProxyServer");
            cwVar.setName("csj_proxy_server");
            cwVar.start();
        }
    }

    cw xt() {
        return this.oq;
    }

    private m() {
        SparseArray<Set<ae>> sparseArray = new SparseArray<>(2);
        this.tl = sparseArray;
        this.f23071g = new ae.cw() { // from class: com.bykv.vk.openvk.component.video.j.xt.m.1
            @Override // com.bykv.vk.openvk.component.video.j.xt.ae.cw
            public void j(ae aeVar) {
                synchronized (m.this.tl) {
                    try {
                        Set set = (Set) m.this.tl.get(aeVar.m());
                        if (set != null) {
                            set.add(aeVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.j.xt.ae.cw
            public void xt(ae aeVar) {
                boolean z5 = up.cw;
                int m6 = aeVar.m();
                synchronized (m.this.tl) {
                    try {
                        Set set = (Set) m.this.tl.get(m6);
                        if (set != null) {
                            set.remove(aeVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.vl = new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.m.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i6 = 0;
                    m.this.f23072j = new ServerSocket(0, 50, InetAddress.getByName(m.this.g()));
                    m mVar = m.this;
                    mVar.xt = mVar.f23072j.getLocalPort();
                    if (m.this.xt == -1) {
                        m.j("socket not bound", "");
                        m.this.up();
                        return;
                    }
                    oq.j(m.this.g(), m.this.xt);
                    if (m.this.ae()) {
                        com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "run:  state = ", m.this.cw);
                        if (m.this.cw.compareAndSet(0, 1)) {
                            com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "run:  state = ", m.this.cw);
                            if (up.cw) {
                                com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "proxy server start!");
                            }
                            while (m.this.cw.get() == 1) {
                                try {
                                    try {
                                        Socket accept = m.this.f23072j.accept();
                                        com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar = m.this.up;
                                        if (cwVar != null) {
                                            final ae j6 = new ae.j().j(cwVar).j(accept).j(m.this.f23071g).j();
                                            com.bytedance.sdk.component.oq.ae.j().execute(new com.bytedance.sdk.component.oq.g("ProxyTask", 10) { // from class: com.bykv.vk.openvk.component.video.j.xt.m.2.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    j6.run();
                                                }
                                            });
                                        } else {
                                            com.bykv.vk.openvk.component.video.j.cw.j.j(accept);
                                        }
                                    } catch (IOException e6) {
                                        com.bytedance.sdk.component.utils.vl.j(e6);
                                        m.j("accept error", Log.getStackTraceString(e6));
                                        i6++;
                                        if (i6 > 3) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    String stackTraceString = Log.getStackTraceString(th);
                                    com.bytedance.sdk.component.utils.vl.r("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                    m.j("error", stackTraceString);
                                }
                            }
                            if (up.cw) {
                                com.bykv.vk.openvk.component.video.api.m.cw.j("ProxyServer", "proxy server closed!");
                            }
                            m.this.up();
                        }
                    }
                } catch (IOException e7) {
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.r("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e7));
                    }
                    m.j("create ServerSocket error", Log.getStackTraceString(e7));
                    m.this.up();
                }
            }
        };
        this.jy = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    boolean j(int i6, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.tl) {
            try {
                Set<ae> set = this.tl.get(i6);
                if (set != null) {
                    for (ae aeVar : set) {
                        if (aeVar != null && str.equals(aeVar.tl)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static m j() {
        if (f23070r == null) {
            synchronized (m.class) {
                try {
                    if (f23070r == null) {
                        f23070r = new m();
                    }
                } finally {
                }
            }
        }
        return f23070r;
    }

    void j(com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar) {
        this.up = cwVar;
    }

    void j(com.bykv.vk.openvk.component.video.j.xt.j.cw cwVar) {
        this.f23073m = cwVar;
    }

    public String j(boolean z5, boolean z6, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.up == null) {
            return strArr[0];
        }
        if ((z5 ? this.ae : this.f23073m) == null) {
            return strArr[0];
        }
        if (this.cw.get() != 1) {
            return strArr[0];
        }
        List<String> j6 = com.bykv.vk.openvk.component.video.j.cw.j.j(strArr);
        if (j6 == null) {
            return strArr[0];
        }
        String j7 = g.j(str, z6 ? str : com.bykv.vk.openvk.component.video.api.m.xt.j(str), j6);
        if (j7 == null) {
            return strArr[0];
        }
        if (z5) {
            str2 = JPushConstants.HTTPS_PRE + g() + ":" + this.xt + "?f=1&" + j7;
        } else {
            str2 = JPushConstants.HTTPS_PRE + g() + ":" + this.xt + "?" + j7;
        }
        return str2.replaceFirst("s", "");
    }
}
