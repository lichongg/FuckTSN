package com.bxkj.base.v2.common.ext;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {
    @NotNull
    public static final String a(@NotNull Exception exc) {
        g0.p(exc, "<this>");
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        g0.o(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (r0.code() != 504) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean b(@org.jetbrains.annotations.NotNull java.lang.Exception r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r4, r0)
            boolean r0 = r4 instanceof retrofit2.HttpException
            r1 = 1
            if (r0 == 0) goto L25
            r0 = r4
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0
            int r2 = r0.code()
            r3 = 502(0x1f6, float:7.03E-43)
            if (r2 == r3) goto L37
            int r2 = r0.code()
            r3 = 503(0x1f7, float:7.05E-43)
            if (r2 == r3) goto L37
            int r0 = r0.code()
            r2 = 504(0x1f8, float:7.06E-43)
            if (r0 == r2) goto L37
        L25:
            boolean r0 = r4 instanceof java.util.concurrent.CancellationException
            if (r0 == 0) goto L38
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L38
            java.lang.String r0 = "3秒未请求到接口主动取消"
            boolean r4 = r4.equals(r0)
            if (r4 != r1) goto L38
        L37:
            return r1
        L38:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.ext.e.b(java.lang.Exception):boolean");
    }
}
