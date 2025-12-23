package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.encoding.equals(encodedPayload.encoding)) {
            return Arrays.equals(this.bytes, encodedPayload.bytes);
        }
        return false;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        if (encoding != null) {
            if (bArr != null) {
                this.encoding = encoding;
                this.bytes = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }
}
