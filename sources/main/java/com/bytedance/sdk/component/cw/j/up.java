package com.bytedance.sdk.component.cw.j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface up extends mi, ReadableByteChannel {
    byte[] ae(long j6) throws IOException;

    String av() throws IOException;

    @Deprecated
    cw cw();

    m cw(long j6) throws IOException;

    short g() throws IOException;

    byte[] i() throws IOException;

    long j(byte b6) throws IOException;

    String j(Charset charset) throws IOException;

    void j(long j6) throws IOException;

    void j(byte[] bArr) throws IOException;

    boolean j(long j6, m mVar) throws IOException;

    long jy() throws IOException;

    InputStream m();

    int oq() throws IOException;

    short qv() throws IOException;

    byte tl() throws IOException;

    void tl(long j6) throws IOException;

    String up(long j6) throws IOException;

    boolean up() throws IOException;

    int vl() throws IOException;
}
