package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final Socket f50855a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i6, i7);
    }

    public i(Socket socket, OutputStream outputStream) {
        super(outputStream);
        this.f50855a = socket;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.f50855a.close();
    }
}
