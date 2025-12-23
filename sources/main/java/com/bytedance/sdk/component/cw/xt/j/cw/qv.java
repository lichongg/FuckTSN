package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.x;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class qv {
    public final String cw;

    /* renamed from: j, reason: collision with root package name */
    public final x f26175j;
    public final int xt;

    public static qv j(String str) throws IOException {
        x xVar;
        int i6;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i6 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                xVar = x.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                xVar = x.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            xVar = x.HTTP_1_0;
            i6 = 4;
        }
        int i7 = i6 + 3;
        if (str.length() < i7) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i6, i7));
            if (str.length() <= i7) {
                str2 = "";
            } else {
                if (str.charAt(i7) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i6 + 4);
            }
            return new qv(xVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26175j == x.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.xt);
        if (this.cw != null) {
            sb.append(' ');
            sb.append(this.cw);
        }
        return sb.toString();
    }

    public qv(x xVar, int i6, String str) {
        this.f26175j = xVar;
        this.xt = i6;
        this.cw = str;
    }
}
