package com.bytedance.sdk.component.cw.xt;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class la {
    final InetSocketAddress cw;

    /* renamed from: j, reason: collision with root package name */
    final j f26326j;
    final Proxy xt;

    public InetSocketAddress cw() {
        return this.cw;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof la)) {
            return false;
        }
        la laVar = (la) obj;
        return laVar.f26326j.equals(this.f26326j) && laVar.xt.equals(this.xt) && laVar.cw.equals(this.cw);
    }

    public int hashCode() {
        return ((((this.f26326j.hashCode() + 527) * 31) + this.xt.hashCode()) * 31) + this.cw.hashCode();
    }

    public j j() {
        return this.f26326j;
    }

    public boolean r() {
        return this.f26326j.f26145g != null && this.xt.type() == Proxy.Type.HTTP;
    }

    public String toString() {
        return "Route{" + this.cw + "}";
    }

    public Proxy xt() {
        return this.xt;
    }

    public la(j jVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (jVar != null) {
            if (proxy != null) {
                if (inetSocketAddress != null) {
                    this.f26326j = jVar;
                    this.xt = proxy;
                    this.cw = inetSocketAddress;
                    return;
                }
                throw new NullPointerException("inetSocketAddress == null");
            }
            throw new NullPointerException("proxy == null");
        }
        throw new NullPointerException("address == null");
    }
}
