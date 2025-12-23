package xyz.adscope.common.network.secure;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AESSecret implements Secret {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f56661a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f56662b;

    @Override // xyz.adscope.common.network.secure.Secret
    public String decrypt(String str) {
        return new String(decrypt(Encryption.hexToByteArray(str)));
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public String encrypt(String str) {
        return Encryption.byteArrayToHex(encrypt(str.getBytes()));
    }

    private Key a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i6 = 0; i6 < bArr.length && i6 < 8; i6++) {
            bArr2[i6] = bArr[i6];
        }
        return new SecretKeySpec(bArr2, "AES");
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] decrypt(byte[] bArr) {
        return this.f56662b.doFinal(bArr);
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] encrypt(byte[] bArr) {
        return this.f56661a.doFinal(bArr);
    }

    public AESSecret(String str) {
        Key a6 = a(str.getBytes());
        Cipher cipher = Cipher.getInstance("AES");
        this.f56661a = cipher;
        cipher.init(1, a6);
        Cipher cipher2 = Cipher.getInstance("AES");
        this.f56662b = cipher2;
        cipher2.init(2, a6);
    }
}
