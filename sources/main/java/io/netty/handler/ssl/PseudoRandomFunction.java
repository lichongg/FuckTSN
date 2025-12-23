package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PseudoRandomFunction {
    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    static byte[] hash(byte[] bArr, byte[] bArr2, byte[] bArr3, int i6, String str) {
        if (i6 < 0) {
            throw new IllegalArgumentException("You must provide a length greater than zero.");
        }
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(bArr, str));
            int ceil = (int) Math.ceil(i6 / mac.getMacLength());
            byte[] bArr4 = EmptyArrays.EMPTY_BYTES;
            byte[] concat = concat(bArr2, bArr3);
            byte[] bArr5 = concat;
            for (int i7 = 0; i7 < ceil; i7++) {
                bArr5 = mac.doFinal(bArr5);
                bArr4 = concat(bArr4, mac.doFinal(concat(bArr5, concat)));
            }
            return Arrays.copyOf(bArr4, i6);
        } catch (GeneralSecurityException e6) {
            throw new IllegalArgumentException("Could not find algo: " + str, e6);
        }
    }

    private PseudoRandomFunction() {
    }
}
