package org.apache.commons.net.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final Socket f50854a;

    public h(Socket socket, InputStream inputStream) {
        super(inputStream);
        this.f50854a = socket;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.f50854a.close();
    }
}
