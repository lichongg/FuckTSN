package io.netty.handler.ssl;

import io.netty.internal.tcnative.SessionTicketKey;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslSessionTicketKey {
    public static final int AES_KEY_SIZE = 16;
    public static final int HMAC_KEY_SIZE = 16;
    public static final int NAME_SIZE = 16;
    public static final int TICKET_KEY_SIZE = 48;
    final SessionTicketKey key;

    public byte[] aesKey() {
        return (byte[]) this.key.getAesKey().clone();
    }

    public byte[] hmacKey() {
        return (byte[]) this.key.getHmacKey().clone();
    }

    public byte[] name() {
        return (byte[]) this.key.getName().clone();
    }

    public OpenSslSessionTicketKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.key = new SessionTicketKey((byte[]) bArr.clone(), (byte[]) bArr2.clone(), (byte[]) bArr3.clone());
    }
}
