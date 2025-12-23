package com.bytedance.sdk.component.xt.j.j.j;

import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.x;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends av {
    private j xt;

    @Override // com.bytedance.sdk.component.cw.xt.av
    public void j(com.bytedance.sdk.component.cw.xt.up upVar, InetSocketAddress inetSocketAddress, Proxy proxy, x xVar, IOException iOException) {
        super.j(upVar, inetSocketAddress, proxy, xVar, iOException);
        j jVar = this.xt;
        if (jVar != null) {
            jVar.j(upVar, inetSocketAddress, proxy, xVar, iOException);
        }
    }

    public cw(j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.sdk.component.cw.xt.av
    public void j(com.bytedance.sdk.component.cw.xt.up upVar, IOException iOException) {
        super.j(upVar, iOException);
        j jVar = this.xt;
        if (jVar != null) {
            jVar.j(upVar, iOException);
        }
    }
}
