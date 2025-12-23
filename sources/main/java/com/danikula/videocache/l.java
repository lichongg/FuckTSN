package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class l extends ProxySelector {

    /* renamed from: d, reason: collision with root package name */
    private static final List<Proxy> f32216d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a, reason: collision with root package name */
    private final ProxySelector f32217a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32218b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32219c;

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f32217a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.f32218b.equals(uri.getHost()) && this.f32219c == uri.getPort()) ? f32216d : this.f32217a.select(uri);
    }

    l(ProxySelector proxySelector, String str, int i6) {
        this.f32217a = (ProxySelector) n.d(proxySelector);
        this.f32218b = (String) n.d(str);
        this.f32219c = i6;
    }

    static void a(String str, int i6) {
        ProxySelector.setDefault(new l(ProxySelector.getDefault(), str, i6));
    }
}
