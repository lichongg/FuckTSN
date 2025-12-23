package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionCacheSize() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return (int) SSLContext.getSessionCacheSize(this.context.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionTimeout() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return (int) SSLContext.getSessionCacheTimeout(this.context.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public boolean isSessionCacheEnabled() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return SSLContext.getSessionCacheMode(this.context.ctx) == SSL.SSL_SESS_CACHE_SERVER;
        } finally {
            readLock.unlock();
        }
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public void setSessionCacheEnabled(boolean z5) {
        long j6 = z5 ? SSL.SSL_SESS_CACHE_SERVER : SSL.SSL_SESS_CACHE_OFF;
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheMode(this.context.ctx, j6);
        } finally {
            writeLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionCacheSize(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheSize(this.context.ctx, i6);
        } finally {
            writeLock.unlock();
        }
    }

    public boolean setSessionIdContext(byte[] bArr) {
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, bArr);
        } finally {
            writeLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheTimeout(this.context.ctx, i6);
        } finally {
            writeLock.unlock();
        }
    }

    OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        super(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
    }
}
