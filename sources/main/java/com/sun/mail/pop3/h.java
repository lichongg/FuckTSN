package com.sun.mail.pop3;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.mail.util.SharedByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class h extends ByteArrayOutputStream {
    public InputStream a() {
        return new SharedByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }

    public h(int i6) {
        super(i6);
    }
}
