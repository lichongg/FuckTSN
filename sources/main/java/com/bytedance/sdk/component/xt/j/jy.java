package com.bytedance.sdk.component.xt.j;

import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum jy {
    HTTP_1_0("http/1.0"),
    HTTP_1_1(ApplicationProtocolNames.HTTP_1_1),
    SPDY_3(ApplicationProtocolNames.SPDY_3_1),
    HTTP_2(ApplicationProtocolNames.HTTP_2);

    private final String up;

    public static jy j(String str) throws IOException {
        jy jyVar = HTTP_1_0;
        if (str.equals(jyVar.up)) {
            return jyVar;
        }
        jy jyVar2 = HTTP_1_1;
        if (str.equals(jyVar2.up)) {
            return jyVar2;
        }
        jy jyVar3 = HTTP_2;
        if (str.equals(jyVar3.up)) {
            return jyVar3;
        }
        jy jyVar4 = SPDY_3;
        if (str.equals(jyVar4.up)) {
            return jyVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.up;
    }

    jy(String str) {
        this.up = str;
    }
}
