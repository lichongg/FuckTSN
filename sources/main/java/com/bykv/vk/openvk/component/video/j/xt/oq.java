package com.bykv.vk.openvk.component.video.j.xt;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class oq extends ProxySelector {

    /* renamed from: j, reason: collision with root package name */
    private static final List<Proxy> f23085j = Collections.singletonList(Proxy.NO_PROXY);
    private final String cw;

    /* renamed from: r, reason: collision with root package name */
    private final int f23086r;
    private final ProxySelector xt = ProxySelector.getDefault();

    static void j(String str, int i6) {
        ProxySelector.setDefault(new oq(str, i6));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.xt.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.cw.equalsIgnoreCase(uri.getHost()) && this.f23086r == uri.getPort()) ? f23085j : this.xt.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    private oq(String str, int i6) {
        this.cw = str;
        this.f23086r = i6;
    }
}
