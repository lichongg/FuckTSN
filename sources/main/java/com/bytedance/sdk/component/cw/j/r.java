package com.bytedance.sdk.component.cw.j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface r extends w, WritableByteChannel {
    r ae(int i6) throws IOException;

    cw cw();

    r cw(byte[] bArr) throws IOException;

    r cw(byte[] bArr, int i6, int i7) throws IOException;

    @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
    void flush() throws IOException;

    r g(int i6) throws IOException;

    r qv(long j6) throws IOException;

    r tj() throws IOException;

    r tl(int i6) throws IOException;

    r vl(long j6) throws IOException;

    r xt(m mVar) throws IOException;

    r xt(String str) throws IOException;
}
