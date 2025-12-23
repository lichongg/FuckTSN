package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private KeyStore f40635a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f40636b;

    private void a(Context context) throws Exception {
        KeyGenParameterSpec.Builder digests;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec build;
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i6 = Build.VERSION.SDK_INT;
        sb.append(i6);
        SLog.d("KEYSTORE", sb.toString());
        if (i6 >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            digests = a2.e.a("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512");
            encryptionPaddings = digests.setEncryptionPaddings("PKCS1Padding");
            build = encryptionPaddings.build();
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
            return;
        }
        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 30);
        keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
        keyPairGenerator2.generateKeyPair();
    }

    private void c(String str) {
        this.f40636b.edit().putString("PREF_KEY_IV", str).apply();
    }

    public String b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, c(), new IvParameterSpec(b()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e6) {
            SLog.e("KEYSTORE", "Exception", e6);
            return "";
        }
    }

    private SecretKeySpec c() throws Exception {
        String string = this.f40636b.getString("PREF_KEY_AES", "");
        PrivateKey privateKey = (PrivateKey) this.f40635a.getKey("KEYSTORE_AES", null);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
    }

    private void d(String str) {
        this.f40636b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public a(Context context) {
        try {
            this.f40636b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f40635a = keyStore;
            keyStore.load(null);
            if (!this.f40635a.containsAlias("KEYSTORE_AES")) {
                c("");
                a(context);
                a();
            }
        } catch (Exception e6) {
            SLog.d("KEYSTORE", "Exception", e6);
        }
    }

    private byte[] b() {
        return Base64.decode(this.f40636b.getString("PREF_KEY_IV", ""), 0);
    }

    public String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, c(), new IvParameterSpec(b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e6) {
            SLog.e("KEYSTORE", "Exception", e6);
            return "";
        }
    }

    private void a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        PublicKey publicKey = this.f40635a.getCertificate("KEYSTORE_AES").getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        d(Base64.encodeToString(cipher.doFinal(bArr), 0));
    }
}
