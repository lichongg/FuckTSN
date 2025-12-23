package io.netty.handler.ssl;

import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    private static void validateSupported(PrivateKey privateKey, String str) throws SSLException {
        if (privateKey == null) {
            return;
        }
        long j6 = 0;
        try {
            try {
                long bio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey);
                try {
                    long parsePrivateKey = SSL.parsePrivateKey(bio, str);
                    SSL.freeBIO(bio);
                    if (parsePrivateKey != 0) {
                        SSL.freePrivateKey(parsePrivateKey);
                    }
                } catch (Exception e6) {
                    e = e6;
                    throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
                } catch (Throwable th) {
                    th = th;
                    j6 = bio;
                    SSL.freeBIO(j6);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    io.netty.handler.ssl.OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator r17, java.lang.String r18) throws java.lang.Exception {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.cert.X509Certificate[] r9 = r3.getCertificateChain(r2)
            if (r9 == 0) goto L80
            int r3 = r9.length
            if (r3 != 0) goto L13
            goto L80
        L13:
            javax.net.ssl.X509KeyManager r3 = r1.keyManager
            java.security.PrivateKey r2 = r3.getPrivateKey(r2)
            r3 = 1
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r0, r3, r9)
            r10 = 0
            io.netty.handler.ssl.PemEncoded r4 = r3.retain()     // Catch: java.lang.Throwable -> L63
            long r12 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r4)     // Catch: java.lang.Throwable -> L63
            long r5 = io.netty.internal.tcnative.SSL.parseX509Chain(r12)     // Catch: java.lang.Throwable -> L5f
            boolean r4 = r2 instanceof io.netty.handler.ssl.OpenSslPrivateKey     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L3b
            io.netty.handler.ssl.OpenSslPrivateKey r2 = (io.netty.handler.ssl.OpenSslPrivateKey) r2     // Catch: java.lang.Throwable -> L37
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r2.newKeyMaterial(r5, r9)     // Catch: java.lang.Throwable -> L37
            goto L50
        L37:
            r0 = move-exception
            r7 = r10
        L39:
            r14 = r7
            goto L68
        L3b:
            long r14 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r2)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L43
            r7 = r10
            goto L49
        L43:
            java.lang.String r0 = r1.password     // Catch: java.lang.Throwable -> L5c
            long r7 = io.netty.internal.tcnative.SSL.parsePrivateKey(r14, r0)     // Catch: java.lang.Throwable -> L5c
        L49:
            io.netty.handler.ssl.DefaultOpenSslKeyMaterial r4 = new io.netty.handler.ssl.DefaultOpenSslKeyMaterial     // Catch: java.lang.Throwable -> L5a
            r4.<init>(r5, r7, r9)     // Catch: java.lang.Throwable -> L5a
            r0 = r4
            r10 = r14
        L50:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r10)
            r3.release()
            return r0
        L5a:
            r0 = move-exception
            goto L68
        L5c:
            r0 = move-exception
            r7 = r10
            goto L68
        L5f:
            r0 = move-exception
            r5 = r10
            r7 = r5
            goto L39
        L63:
            r0 = move-exception
            r5 = r10
            r7 = r5
            r12 = r7
            r14 = r12
        L68:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r14)
            int r2 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r2 == 0) goto L75
            io.netty.internal.tcnative.SSL.freeX509Chain(r5)
        L75:
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 == 0) goto L7c
            io.netty.internal.tcnative.SSL.freePrivateKey(r7)
        L7c:
            r3.release()
            throw r0
        L80:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.chooseKeyMaterial(io.netty.buffer.ByteBufAllocator, java.lang.String):io.netty.handler.ssl.OpenSslKeyMaterial");
    }

    X509KeyManager keyManager() {
        return this.keyManager;
    }

    OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(X509Certificate[] x509CertificateArr) throws SSLException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            return;
        }
        long j6 = 0;
        PemEncoded pemEncoded = null;
        try {
            try {
                UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
                pemEncoded = PemX509Certificate.toPEM(unpooledByteBufAllocator, true, x509CertificateArr);
                long bio = ReferenceCountedOpenSslContext.toBIO(unpooledByteBufAllocator, pemEncoded.retain());
                try {
                    long parseX509Chain = SSL.parseX509Chain(bio);
                    SSL.freeBIO(bio);
                    if (parseX509Chain != 0) {
                        SSL.freeX509Chain(parseX509Chain);
                    }
                    pemEncoded.release();
                } catch (Exception e6) {
                    e = e6;
                    throw new SSLException("Certificate type not supported", e);
                } catch (Throwable th) {
                    th = th;
                    j6 = bio;
                    SSL.freeBIO(j6);
                    if (pemEncoded != null) {
                        pemEncoded.release();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    void destroy() {
    }
}
