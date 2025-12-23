package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.la;
import com.bytedance.sdk.component.cw.xt.mi;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m {
    private List<InetSocketAddress> ae;
    private final com.bytedance.sdk.component.cw.xt.up cw;

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.component.cw.xt.j f26314j;

    /* renamed from: m, reason: collision with root package name */
    private int f26315m;

    /* renamed from: r, reason: collision with root package name */
    private final av f26316r;
    private final List<la> tl;
    private List<Proxy> up;
    private final r xt;

    public static final class j {

        /* renamed from: j, reason: collision with root package name */
        private final List<la> f26317j;
        private int xt = 0;

        public List<la> cw() {
            return new ArrayList(this.f26317j);
        }

        public boolean j() {
            return this.xt < this.f26317j.size();
        }

        j(List<la> list) {
            this.f26317j = list;
        }

        public la xt() {
            if (j()) {
                List<la> list = this.f26317j;
                int i6 = this.xt;
                this.xt = i6 + 1;
                return list.get(i6);
            }
            throw new NoSuchElementException();
        }
    }

    public boolean j() {
        return cw() || !this.tl.isEmpty();
    }

    private boolean cw() {
        return this.f26315m < this.up.size();
    }

    public void j(la laVar, IOException iOException) {
        if (laVar.xt().type() != Proxy.Type.DIRECT && this.f26314j.ae() != null) {
            this.f26314j.ae().connectFailed(this.f26314j.j().xt(), laVar.xt().address(), iOException);
        }
        this.xt.j(laVar);
    }

    public m(com.bytedance.sdk.component.cw.xt.j jVar, r rVar, com.bytedance.sdk.component.cw.xt.up upVar, av avVar) throws IOException {
        List list = Collections.EMPTY_LIST;
        this.up = list;
        this.ae = list;
        this.tl = new ArrayList();
        this.f26314j = jVar;
        this.xt = rVar;
        this.cw = upVar;
        this.f26316r = avVar;
        j(jVar.j(), jVar.tl());
    }

    private Proxy r() throws IOException {
        if (cw()) {
            List<Proxy> list = this.up;
            int i6 = this.f26315m;
            this.f26315m = i6 + 1;
            Proxy proxy = list.get(i6);
            j(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f26314j.j().ae() + "; exhausted proxy configurations: " + this.up);
    }

    public j xt() throws IOException {
        if (j()) {
            ArrayList arrayList = new ArrayList();
            while (cw()) {
                Proxy r5 = r();
                int size = this.ae.size();
                for (int i6 = 0; i6 < size; i6++) {
                    la laVar = new la(this.f26314j, r5, this.ae.get(i6));
                    if (this.xt.cw(laVar)) {
                        this.tl.add(laVar);
                    } else {
                        arrayList.add(laVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.tl);
                this.tl.clear();
            }
            return new j(arrayList);
        }
        throw new NoSuchElementException();
    }

    private void j(mi miVar, Proxy proxy) throws IOException {
        List<Proxy> j6;
        if (proxy != null) {
            this.up = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> select = this.f26314j.ae().select(miVar.xt());
                if (select != null && !select.isEmpty()) {
                    j6 = com.bytedance.sdk.component.cw.xt.j.cw.j(select);
                } else {
                    j6 = com.bytedance.sdk.component.cw.xt.j.cw.j(Proxy.NO_PROXY);
                }
                this.up = j6;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.f26315m = 0;
    }

    private void j(Proxy proxy) throws IOException {
        String ae;
        int tl;
        this.ae = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                ae = j(inetSocketAddress);
                tl = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            ae = this.f26314j.j().ae();
            tl = this.f26314j.j().tl();
        }
        if (tl > 0 && tl <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.ae.add(InetSocketAddress.createUnresolved(ae, tl));
                return;
            }
            List<InetAddress> j6 = this.f26314j.xt().j(ae);
            if (j6.isEmpty()) {
                return;
            }
            int size = j6.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.ae.add(new InetSocketAddress(j6.get(i6), tl));
            }
            return;
        }
        throw new SocketException("No route to " + ae + ":" + tl + "; port is out of range");
    }

    static String j(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
