package org.apache.commons.net.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509ExtendedKeyManager;
import org.apache.commons.net.io.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51254a = KeyStore.getDefaultType();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final X509Certificate[] f51255a;

        /* renamed from: b, reason: collision with root package name */
        private final PrivateKey f51256b;

        /* renamed from: c, reason: collision with root package name */
        private final String f51257c;

        final String a() {
            return this.f51257c;
        }

        final X509Certificate[] b() {
            return this.f51255a;
        }

        final PrivateKey c() {
            return this.f51256b;
        }

        a(KeyStore keyStore, String str, String str2) throws GeneralSecurityException {
            this.f51257c = str;
            this.f51256b = (PrivateKey) keyStore.getKey(str, str2.toCharArray());
            Certificate[] certificateChain = keyStore.getCertificateChain(str);
            X509Certificate[] x509CertificateArr = new X509Certificate[certificateChain.length];
            for (int i6 = 0; i6 < certificateChain.length; i6++) {
                x509CertificateArr[i6] = (X509Certificate) certificateChain[i6];
            }
            this.f51255a = x509CertificateArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends X509ExtendedKeyManager {

        /* renamed from: a, reason: collision with root package name */
        private final a f51258a;

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String str, Principal[] principalArr) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            return this.f51258a.a();
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String str) {
            return this.f51258a.b();
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String str, Principal[] principalArr) {
            return new String[]{this.f51258a.a()};
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String str) {
            return this.f51258a.c();
        }

        b(a aVar) {
            this.f51258a = aVar;
        }
    }

    public static KeyManager a(File file, String str) throws IOException, GeneralSecurityException {
        return c(f51254a, file, str, null, str);
    }

    public static KeyManager b(File file, String str, String str2) throws IOException, GeneralSecurityException {
        return c(f51254a, file, str, str2, str);
    }

    public static KeyManager d(KeyStore keyStore, String str, String str2) throws GeneralSecurityException {
        if (str == null) {
            str = e(keyStore);
        }
        return new b(new a(keyStore, str, str2));
    }

    private c() {
    }

    public static KeyManager c(String str, File file, String str2, String str3, String str4) throws IOException, GeneralSecurityException {
        return d(f(str, file, str2), str3, str4);
    }

    private static String e(KeyStore keyStore) throws KeyStoreException {
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (keyStore.isKeyEntry(nextElement)) {
                return nextElement;
            }
        }
        throw new KeyStoreException("Cannot find a private key entry");
    }

    private static KeyStore f(String str, File file, String str2) throws KeyStoreException, IOException, GeneralSecurityException {
        FileInputStream fileInputStream;
        KeyStore keyStore = KeyStore.getInstance(str);
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            keyStore.load(fileInputStream, str2.toCharArray());
            l.a(fileInputStream);
            return keyStore;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            l.a(fileInputStream2);
            throw th;
        }
    }
}
