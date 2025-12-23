package xyz.adscope.common.network.secure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SafeSecret implements Secret {
    @Override // xyz.adscope.common.network.secure.Secret
    public String decrypt(String str) {
        return str;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public String encrypt(String str) {
        return str;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] decrypt(byte[] bArr) {
        return bArr;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] encrypt(byte[] bArr) {
        return bArr;
    }
}
