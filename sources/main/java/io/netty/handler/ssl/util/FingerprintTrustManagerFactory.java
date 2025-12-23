package io.netty.handler.ssl.util;

import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class FingerprintTrustManagerFactory extends SimpleTrustManagerFactory {
    private static final int SHA1_BYTE_LEN = 20;
    private static final int SHA1_HEX_LEN = 40;
    private final byte[][] fingerprints;
    private final TrustManager tm;
    private static final Pattern FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
    private static final Pattern FINGERPRINT_STRIP_PATTERN = Pattern.compile(":");
    private static final FastThreadLocal<MessageDigest> tlmd = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException e6) {
                throw new Error(e6);
            }
        }
    };

    public FingerprintTrustManagerFactory(Iterable<String> iterable) {
        this(toFingerprintArray(iterable));
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(KeyStore keyStore) throws Exception {
    }

    public FingerprintTrustManagerFactory(String... strArr) {
        this(toFingerprintArray(Arrays.asList(strArr)));
    }

    private static byte[][] toFingerprintArray(Iterable<String> iterable) {
        String next;
        if (iterable == null) {
            throw new NullPointerException("fingerprints");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!FINGERPRINT_PATTERN.matcher(next).matches()) {
                throw new IllegalArgumentException("malformed fingerprint: " + next);
            }
            String replaceAll = FINGERPRINT_STRIP_PATTERN.matcher(next).replaceAll("");
            if (replaceAll.length() != 40) {
                throw new IllegalArgumentException("malformed fingerprint: " + replaceAll + " (expected: SHA1)");
            }
            arrayList.add(StringUtil.decodeHexDump(replaceAll));
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.tm};
    }

    @Override // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }

    public FingerprintTrustManagerFactory(byte[]... bArr) {
        this.tm = new X509TrustManager() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.2
            private void checkTrusted(String str, X509Certificate[] x509CertificateArr) throws CertificateException {
                X509Certificate x509Certificate = x509CertificateArr[0];
                byte[] fingerprint = fingerprint(x509Certificate);
                for (byte[] bArr2 : FingerprintTrustManagerFactory.this.fingerprints) {
                    if (Arrays.equals(fingerprint, bArr2)) {
                        return;
                    }
                }
                throw new CertificateException(str + " certificate with unknown fingerprint: " + x509Certificate.getSubjectDN());
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                checkTrusted("client", x509CertificateArr);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                checkTrusted("server", x509CertificateArr);
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }

            private byte[] fingerprint(X509Certificate x509Certificate) throws CertificateEncodingException {
                MessageDigest messageDigest = (MessageDigest) FingerprintTrustManagerFactory.tlmd.get();
                messageDigest.reset();
                return messageDigest.digest(x509Certificate.getEncoded());
            }
        };
        if (bArr != null) {
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte[] bArr2 : bArr) {
                if (bArr2 == null) {
                    break;
                }
                if (bArr2.length == 20) {
                    arrayList.add(bArr2.clone());
                } else {
                    throw new IllegalArgumentException("malformed fingerprint: " + ByteBufUtil.hexDump(Unpooled.wrappedBuffer(bArr2)) + " (expected: SHA1)");
                }
            }
            this.fingerprints = (byte[][]) arrayList.toArray(new byte[0][]);
            return;
        }
        throw new NullPointerException("fingerprints");
    }
}
