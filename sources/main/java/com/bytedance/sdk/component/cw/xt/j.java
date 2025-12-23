package com.bytedance.sdk.component.cw.xt;

import com.bytedance.sdk.component.cw.xt.mi;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {
    final ProxySelector ae;
    final SocketFactory cw;

    /* renamed from: g, reason: collision with root package name */
    final SSLSocketFactory f26145g;

    /* renamed from: j, reason: collision with root package name */
    final mi f26146j;

    /* renamed from: m, reason: collision with root package name */
    final List<qv> f26147m;
    final HostnameVerifier oq;
    final ae qv;

    /* renamed from: r, reason: collision with root package name */
    final xt f26148r;
    final Proxy tl;
    final List<x> up;
    final az xt;

    public j(String str, int i6, az azVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ae aeVar, xt xtVar, Proxy proxy, List<x> list, List<qv> list2, ProxySelector proxySelector) {
        this.f26146j = new mi.j().j(sSLSocketFactory != null ? b.f50155b : b.f50154a).r(str).j(i6).cw();
        if (azVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.xt = azVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.cw = socketFactory;
        if (xtVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f26148r = xtVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.up = com.bytedance.sdk.component.cw.xt.j.cw.j(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f26147m = com.bytedance.sdk.component.cw.xt.j.cw.j(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.ae = proxySelector;
        this.tl = proxy;
        this.f26145g = sSLSocketFactory;
        this.oq = hostnameVerifier;
        this.qv = aeVar;
    }

    public mi j() {
        return this.f26146j;
    }

    public ProxySelector ae() {
        return this.ae;
    }

    public SocketFactory cw() {
        return this.cw;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f26146j.equals(jVar.f26146j) && j(jVar);
    }

    public SSLSocketFactory g() {
        return this.f26145g;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f26146j.hashCode() + 527) * 31) + this.xt.hashCode()) * 31) + this.f26148r.hashCode()) * 31) + this.up.hashCode()) * 31) + this.f26147m.hashCode()) * 31) + this.ae.hashCode()) * 31;
        Proxy proxy = this.tl;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f26145g;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.oq;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        ae aeVar = this.qv;
        return hashCode4 + (aeVar != null ? aeVar.hashCode() : 0);
    }

    boolean j(j jVar) {
        return this.xt.equals(jVar.xt) && this.f26148r.equals(jVar.f26148r) && this.up.equals(jVar.up) && this.f26147m.equals(jVar.f26147m) && this.ae.equals(jVar.ae) && com.bytedance.sdk.component.cw.xt.j.cw.j(this.tl, jVar.tl) && com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26145g, jVar.f26145g) && com.bytedance.sdk.component.cw.xt.j.cw.j(this.oq, jVar.oq) && com.bytedance.sdk.component.cw.xt.j.cw.j(this.qv, jVar.qv) && j().tl() == jVar.j().tl();
    }

    public List<qv> m() {
        return this.f26147m;
    }

    public HostnameVerifier oq() {
        return this.oq;
    }

    public ae qv() {
        return this.qv;
    }

    public xt r() {
        return this.f26148r;
    }

    public Proxy tl() {
        return this.tl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.f26146j.ae());
        sb.append(":");
        sb.append(this.f26146j.tl());
        if (this.tl != null) {
            sb.append(", proxy=");
            sb.append(this.tl);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.ae);
        }
        sb.append("}");
        return sb.toString();
    }

    public List<x> up() {
        return this.up;
    }

    public az xt() {
        return this.xt;
    }
}
