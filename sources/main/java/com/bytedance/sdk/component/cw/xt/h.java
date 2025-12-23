package com.bytedance.sdk.component.cw.xt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class h implements Closeable {
    public static h j(tj tjVar, byte[] bArr) {
        return j(tjVar, bArr.length, new com.bytedance.sdk.component.cw.j.cw().cw(bArr));
    }

    public abstract com.bytedance.sdk.component.cw.j.up cw();

    public abstract tj j();

    public abstract long xt();

    private Charset ae() {
        tj j6 = j();
        if (j6 != null) {
            return j6.j(com.bytedance.sdk.component.cw.xt.j.cw.up);
        }
        return com.bytedance.sdk.component.cw.xt.j.cw.up;
    }

    public static h j(final tj tjVar, final long j6, final com.bytedance.sdk.component.cw.j.up upVar) {
        if (upVar != null) {
            return new h() { // from class: com.bytedance.sdk.component.cw.xt.h.1
                @Override // com.bytedance.sdk.component.cw.xt.h
                public com.bytedance.sdk.component.cw.j.up cw() {
                    return upVar;
                }

                @Override // com.bytedance.sdk.component.cw.xt.h
                public tj j() {
                    return tj.this;
                }

                @Override // com.bytedance.sdk.component.cw.xt.h
                public long xt() {
                    return j6;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.cw.xt.j.cw.j(cw());
    }

    public final String m() throws IOException {
        com.bytedance.sdk.component.cw.j.up cw = cw();
        try {
            String j6 = cw.j(com.bytedance.sdk.component.cw.xt.j.cw.j(cw, ae()));
            com.bytedance.sdk.component.cw.xt.j.cw.j(cw);
            return j6;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.cw.xt.j.cw.j(cw);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.cw.xt.j.cw.j(cw);
            throw th;
        }
    }

    public final InputStream r() {
        return cw().m();
    }

    public final byte[] up() throws IOException {
        long xt = xt();
        if (xt <= 2147483647L) {
            com.bytedance.sdk.component.cw.j.up cw = cw();
            try {
                byte[] i6 = cw.i();
                com.bytedance.sdk.component.cw.xt.j.cw.j(cw);
                if (xt != -1 && xt != i6.length) {
                    throw new IOException("Content-Length (" + xt + ") and stream length (" + i6.length + ") disagree");
                }
                return i6;
            } catch (Throwable th) {
                com.bytedance.sdk.component.cw.xt.j.cw.j(cw);
                throw th;
            }
        }
        throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(xt)));
    }
}
