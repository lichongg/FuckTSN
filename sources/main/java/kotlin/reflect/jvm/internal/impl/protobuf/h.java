package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f46502a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f46503b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        int getNumber();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T extends a> {
        T a(int i6);
    }

    static {
        byte[] bArr = new byte[0];
        f46502a = bArr;
        f46503b = ByteBuffer.wrap(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("UTF-8 not supported?", e6);
        }
    }

    public static boolean a(byte[] bArr) {
        return u.e(bArr);
    }
}
