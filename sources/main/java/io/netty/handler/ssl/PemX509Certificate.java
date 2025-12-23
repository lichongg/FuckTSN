package io.netty.handler.ssl;

import com.bytedance.pangle.tl.av;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT;
    private static final byte[] END_CERT;
    private final ByteBuf content;

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z5, PemEncoded pemEncoded, int i6, ByteBuf byteBuf) {
        ByteBuf content = pemEncoded.content();
        if (byteBuf == null) {
            byteBuf = newBuffer(byteBufAllocator, z5, content.readableBytes() * i6);
        }
        byteBuf.writeBytes(content.slice());
        return byteBuf;
    }

    public static PemX509Certificate valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        throw new UnsupportedOperationException();
    }

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(charset);
        END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(charset);
    }

    private static ByteBuf newBuffer(ByteBufAllocator byteBufAllocator, boolean z5, int i6) {
        return z5 ? byteBufAllocator.directBuffer(i6) : byteBufAllocator.buffer(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z5, X509Certificate... x509CertificateArr) throws CertificateEncodingException {
        if (x509CertificateArr == 0 || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("X.509 certificate chain can't be null or empty");
        }
        if (x509CertificateArr.length == 1) {
            Object[] objArr = x509CertificateArr[0];
            if (objArr instanceof PemEncoded) {
                return ((PemEncoded) objArr).retain();
            }
        }
        ByteBuf byteBuf = null;
        try {
            for (av avVar : x509CertificateArr) {
                if (avVar == 0) {
                    throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(x509CertificateArr));
                }
                byteBuf = avVar instanceof PemEncoded ? append(byteBufAllocator, z5, (PemEncoded) avVar, x509CertificateArr.length, byteBuf) : append(byteBufAllocator, z5, avVar, x509CertificateArr.length, byteBuf);
            }
            return new PemValue(byteBuf, false);
        } catch (Throwable th) {
            if (0 != 0) {
                byteBuf.release();
            }
            throw th;
        }
    }

    public static PemX509Certificate valueOf(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PemX509Certificate) {
            return this.content.equals(((PemX509Certificate) obj).content);
        }
        return false;
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.content.release(i6);
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.content.toString(CharsetUtil.UTF_8);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        throw new UnsupportedOperationException();
    }

    private PemX509Certificate(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(refCnt);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate replace(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z5, X509Certificate x509Certificate, int i6, ByteBuf byteBuf) throws CertificateEncodingException {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
        try {
            ByteBuf base64 = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            if (byteBuf == null) {
                try {
                    byteBuf = newBuffer(byteBufAllocator, z5, (BEGIN_CERT.length + base64.readableBytes() + END_CERT.length) * i6);
                } catch (Throwable th) {
                    base64.release();
                    throw th;
                }
            }
            byteBuf.writeBytes(BEGIN_CERT);
            byteBuf.writeBytes(base64);
            byteBuf.writeBytes(END_CERT);
            base64.release();
            return byteBuf;
        } finally {
            wrappedBuffer.release();
        }
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate retain(int i6) {
        this.content.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
