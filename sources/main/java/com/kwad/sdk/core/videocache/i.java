package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aLo = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aLp;
    private final String aLq;
    private final int aLr;

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aLp.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this.aLq.equals(uri.getHost()) && this.aLr == uri.getPort()) ? aLo : this.aLp.select(uri);
    }

    private i(ProxySelector proxySelector, String str, int i6) {
        this.aLp = (ProxySelector) ax.checkNotNull(proxySelector);
        this.aLq = ax.hh(str);
        this.aLr = i6;
    }

    static void install(String str, int i6) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i6));
    }
}
