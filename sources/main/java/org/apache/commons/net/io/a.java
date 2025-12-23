package org.apache.commons.net.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a extends BufferedReader {

    /* renamed from: a, reason: collision with root package name */
    private static final char f50835a = '\n';

    /* renamed from: b, reason: collision with root package name */
    private static final char f50836b = '\r';

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        synchronized (((BufferedReader) this).lock) {
            boolean z5 = false;
            while (true) {
                try {
                    int read = read();
                    if (read == -1) {
                        String sb2 = sb.toString();
                        if (sb2.length() == 0) {
                            return null;
                        }
                        return sb2;
                    }
                    if (z5 && read == 10) {
                        return sb.substring(0, sb.length() - 1);
                    }
                    z5 = read == 13;
                    sb.append((char) read);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public a(Reader reader) {
        super(reader);
    }
}
