package com.bytedance.sdk.component.cw.xt;

import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum x {
    HTTP_1_0("http/1.0"),
    HTTP_1_1(ApplicationProtocolNames.HTTP_1_1),
    SPDY_3(ApplicationProtocolNames.SPDY_3_1),
    HTTP_2(ApplicationProtocolNames.HTTP_2);

    private final String up;

    public static x j(String str) throws IOException {
        x xVar = HTTP_1_0;
        if (str.equals(xVar.up)) {
            return xVar;
        }
        x xVar2 = HTTP_1_1;
        if (str.equals(xVar2.up)) {
            return xVar2;
        }
        x xVar3 = HTTP_2;
        if (str.equals(xVar3.up)) {
            return xVar3;
        }
        x xVar4 = SPDY_3;
        if (str.equals(xVar4.up)) {
            return xVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.up;
    }

    x(String str) {
        this.up = str;
    }
}
