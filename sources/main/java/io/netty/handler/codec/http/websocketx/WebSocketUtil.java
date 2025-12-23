package io.netty.handler.codec.http.websocketx;

import com.baidu.mobads.sdk.internal.by;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class WebSocketUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<MessageDigest> MD5 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance(by.f10823a);
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("MD5 not supported on this platform - Outdated?");
            }
        }
    };
    private static final FastThreadLocal<MessageDigest> SHA1 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("SHA-1 not supported on this platform - Outdated?");
            }
        }
    };

    static byte[] md5(byte[] bArr) {
        return digest(MD5, bArr);
    }

    static byte[] randomBytes(int i6) {
        byte[] bArr = new byte[i6];
        PlatformDependent.threadLocalRandom().nextBytes(bArr);
        return bArr;
    }

    static byte[] sha1(byte[] bArr) {
        return digest(SHA1, bArr);
    }

    private WebSocketUtil() {
    }

    @SuppressJava6Requirement(reason = "Guarded with java version check")
    static String base64(byte[] bArr) {
        Base64.Encoder encoder;
        String encodeToString;
        if (PlatformDependent.javaVersion() >= 8) {
            encoder = Base64.getEncoder();
            encodeToString = encoder.encodeToString(bArr);
            return encodeToString;
        }
        ByteBuf encode = io.netty.handler.codec.base64.Base64.encode(Unpooled.wrappedBuffer(bArr));
        String byteBuf = encode.toString(CharsetUtil.UTF_8);
        encode.release();
        return byteBuf;
    }

    private static byte[] digest(FastThreadLocal<MessageDigest> fastThreadLocal, byte[] bArr) {
        MessageDigest messageDigest = fastThreadLocal.get();
        messageDigest.reset();
        return messageDigest.digest(bArr);
    }

    static int randomNumber(int i6, int i7) {
        return (int) (i6 + (PlatformDependent.threadLocalRandom().nextDouble() * (i7 - i6)));
    }
}
