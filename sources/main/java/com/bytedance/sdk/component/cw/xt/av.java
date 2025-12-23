package com.bytedance.sdk.component.cw.xt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class av {

    /* renamed from: j, reason: collision with root package name */
    public static final av f26119j = new av() { // from class: com.bytedance.sdk.component.cw.xt.av.1
    };

    public interface j {
        av j(up upVar);
    }

    public void j(up upVar, IOException iOException) {
    }

    public void j(up upVar, InetSocketAddress inetSocketAddress, Proxy proxy, x xVar, IOException iOException) {
    }

    static j j(av avVar) {
        return new j() { // from class: com.bytedance.sdk.component.cw.xt.av.2
            @Override // com.bytedance.sdk.component.cw.xt.av.j
            public av j(up upVar) {
                return av.this;
            }
        };
    }
}
