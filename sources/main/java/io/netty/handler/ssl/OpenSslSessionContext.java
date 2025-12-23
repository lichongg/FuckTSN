package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SessionTicketKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class OpenSslSessionContext implements SSLSessionContext {
    private static final Enumeration<byte[]> EMPTY = new EmptyEnumeration(null);
    final ReferenceCountedOpenSslContext context;
    private final OpenSslKeyMaterialProvider provider;
    private final OpenSslSessionStats stats;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ssl.OpenSslSessionContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyEnumeration implements Enumeration<byte[]> {
        private EmptyEnumeration() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        /* synthetic */ EmptyEnumeration(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Enumeration
        public byte[] nextElement() {
            throw new NoSuchElementException();
        }
    }

    public abstract boolean isSessionCacheEnabled();

    public abstract void setSessionCacheEnabled(boolean z5);

    @Deprecated
    public void setTicketKeys(byte[] bArr) {
        if (bArr.length % 48 != 0) {
            throw new IllegalArgumentException("keys.length % 48 != 0");
        }
        int length = bArr.length / 48;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 17) {
            int i8 = i6 + 16;
            i6 += 32;
            sessionTicketKeyArr[i7 + 16] = new SessionTicketKey(Arrays.copyOfRange(bArr, i6, 16), Arrays.copyOfRange(bArr, i8, 16), Arrays.copyOfRange(bArr, i8, 16));
        }
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
        } finally {
            writeLock.unlock();
        }
    }

    final void destroy() {
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = this.provider;
        if (openSslKeyMaterialProvider != null) {
            openSslKeyMaterialProvider.destroy();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public Enumeration<byte[]> getIds() {
        return EMPTY;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        if (bArr != null) {
            return null;
        }
        throw new NullPointerException("bytes");
    }

    public OpenSslSessionStats stats() {
        return this.stats;
    }

    OpenSslSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.context = referenceCountedOpenSslContext;
        this.provider = openSslKeyMaterialProvider;
        this.stats = new OpenSslSessionStats(referenceCountedOpenSslContext);
    }

    public void setTicketKeys(OpenSslSessionTicketKey... openSslSessionTicketKeyArr) {
        ObjectUtil.checkNotNull(openSslSessionTicketKeyArr, "keys");
        int length = openSslSessionTicketKeyArr.length;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        for (int i6 = 0; i6 < length; i6++) {
            sessionTicketKeyArr[i6] = openSslSessionTicketKeyArr[i6].key;
        }
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
        } finally {
            writeLock.unlock();
        }
    }
}
