package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    static final List<String> DEFAULT_CIPHERS;
    private static final boolean IS_BORINGSSL;
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger;

    private static boolean doesSupportProtocol(int i6, int i7) {
        if (i7 == 0) {
            return false;
        }
        try {
            long make = SSLContext.make(i6, 2);
            if (make != -1) {
                SSLContext.free(make);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x028d A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0297 A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x029e A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a5 A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02cc A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d3 A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02da A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e1 A[Catch: all -> 0x0291, TryCatch #22 {all -> 0x0291, blocks: (B:99:0x0286, B:101:0x028d, B:104:0x0297, B:107:0x029e, B:110:0x02a5, B:55:0x02c5, B:57:0x02cc, B:60:0x02d3, B:63:0x02da, B:66:0x02e1, B:67:0x02e4), top: B:29:0x0152 }] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.lang.Object[], java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [long] */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [long] */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.Collection, java.util.LinkedHashSet, java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Class, java.lang.Class<io.netty.handler.ssl.OpenSslEngine>] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    static {
        /*
            Method dump skipped, instructions count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.<clinit>():void");
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    private static boolean initializeTcNative(String str) throws Exception {
        return Library.initialize("provided", str);
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    static boolean isBoringSSL() {
        return IS_BORINGSSL;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str, IS_BORINGSSL);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    static boolean isTlsv13Supported() {
        return TLSV13_SUPPORTED;
    }

    static X509Certificate selfSignedCertificate() throws CertificateException {
        return (X509Certificate) SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream(CERT.getBytes(CharsetUtil.US_ASCII)));
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    private OpenSsl() {
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    private static boolean doesSupportOcsp() {
        long j6;
        if (version() >= 268443648) {
            try {
                j6 = SSLContext.make(16, 1);
            } catch (Exception unused) {
                j6 = -1;
            } catch (Throwable th) {
                th = th;
                j6 = -1;
            }
            try {
                SSLContext.enableOcsp(j6, false);
                if (j6 != -1) {
                    SSLContext.free(j6);
                }
                return true;
            } catch (Exception unused2) {
                if (j6 != -1) {
                    SSLContext.free(j6);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (j6 != -1) {
                    SSLContext.free(j6);
                }
                throw th;
            }
        }
        return false;
    }

    public static boolean isAlpnSupported() {
        if (version() >= 268443648) {
            return true;
        }
        return false;
    }

    private static void loadTcNative() throws Exception {
        String normalizedOs = PlatformDependent.normalizedOs();
        String normalizedArch = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet = new LinkedHashSet(4);
        linkedHashSet.add("netty_tcnative_" + normalizedOs + '_' + normalizedArch);
        if ("linux".equalsIgnoreCase(normalizedOs)) {
            linkedHashSet.add("netty_tcnative_" + normalizedOs + '_' + normalizedArch + "_fedora");
        }
        linkedHashSet.add("netty_tcnative_" + normalizedArch);
        linkedHashSet.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(SSL.class.getClassLoader(), (String[]) linkedHashSet.toArray(new String[0]));
    }

    static long memoryAddress(ByteBuf byteBuf) {
        if (byteBuf.hasMemoryAddress()) {
            return byteBuf.memoryAddress();
        }
        return Buffer.address(byteBuf.nioBuffer());
    }

    static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }

    @Deprecated
    public static boolean supportsHostnameValidation() {
        return isAvailable();
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }
}
