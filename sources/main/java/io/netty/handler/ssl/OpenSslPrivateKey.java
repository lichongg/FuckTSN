package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.EmptyArrays;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class OpenSslPrivateKey extends AbstractReferenceCounted implements PrivateKey {
    private long privateKeyAddress;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class OpenSslPrivateKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
        long certificateChain;
        private final X509Certificate[] x509CertificateChain;

        OpenSslPrivateKeyMaterial(long j6, X509Certificate[] x509CertificateArr) {
            this.certificateChain = j6;
            this.x509CertificateChain = x509CertificateArr == null ? EmptyArrays.EMPTY_X509_CERTIFICATES : x509CertificateArr;
            OpenSslPrivateKey.this.retain();
        }

        private void releaseChain() {
            SSL.freeX509Chain(this.certificateChain);
            this.certificateChain = 0L;
        }

        @Override // io.netty.handler.ssl.OpenSslKeyMaterial
        public X509Certificate[] certificateChain() {
            return (X509Certificate[]) this.x509CertificateChain.clone();
        }

        @Override // io.netty.handler.ssl.OpenSslKeyMaterial
        public long certificateChainAddress() {
            if (refCnt() > 0) {
                return this.certificateChain;
            }
            throw new IllegalReferenceCountException();
        }

        @Override // io.netty.util.AbstractReferenceCounted
        protected void deallocate() {
            releaseChain();
            OpenSslPrivateKey.this.release();
        }

        @Override // io.netty.handler.ssl.OpenSslKeyMaterial
        public long privateKeyAddress() {
            if (refCnt() > 0) {
                return OpenSslPrivateKey.this.privateKeyAddress();
            }
            throw new IllegalReferenceCountException();
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial retain() {
            super.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial touch(Object obj) {
            OpenSslPrivateKey.this.touch(obj);
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial retain(int i6) {
            super.retain(i6);
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial touch() {
            OpenSslPrivateKey.this.touch();
            return this;
        }
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // io.netty.util.ReferenceCounted
    public OpenSslPrivateKey touch(Object obj) {
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SSL.freePrivateKey(this.privateKeyAddress);
        this.privateKeyAddress = 0L;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "unknown";
    }

    OpenSslKeyMaterial newKeyMaterial(long j6, X509Certificate[] x509CertificateArr) {
        return new OpenSslPrivateKeyMaterial(j6, x509CertificateArr);
    }

    OpenSslPrivateKey(long j6) {
        this.privateKeyAddress = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long privateKeyAddress() {
        if (refCnt() > 0) {
            return this.privateKeyAddress;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        release(refCnt());
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        if (refCnt() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public OpenSslPrivateKey retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public OpenSslPrivateKey retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public OpenSslPrivateKey touch() {
        super.touch();
        return this;
    }
}
