package com.kwad.sdk.core.imageloader.cache.disc.naming;

import com.kwad.sdk.core.imageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    private byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e6) {
            L.e(e6);
            return null;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return new BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }
}
