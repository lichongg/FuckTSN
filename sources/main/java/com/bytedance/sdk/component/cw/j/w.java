package com.bytedance.sdk.component.cw.j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface w extends Closeable, Flushable {
    void a_(cw cwVar, long j6) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    kt j();
}
