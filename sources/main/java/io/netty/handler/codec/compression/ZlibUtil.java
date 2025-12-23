package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ZlibUtil {
    static void fail(Inflater inflater, String str, int i6) {
        throw inflaterException(inflater, str, i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.ZlibUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.GZIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static JZlib.WrapperType convertWrapperType(ZlibWrapper zlibWrapper) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i6 == 1) {
            return JZlib.W_NONE;
        }
        if (i6 == 2) {
            return JZlib.W_ZLIB;
        }
        if (i6 == 3) {
            return JZlib.W_GZIP;
        }
        if (i6 == 4) {
            return JZlib.W_ANY;
        }
        throw new Error();
    }

    static CompressionException deflaterException(Deflater deflater, String str, int i6) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(i6);
        sb.append(')');
        if (deflater.msg != null) {
            str2 = ": " + deflater.msg;
        } else {
            str2 = "";
        }
        sb.append(str2);
        return new CompressionException(sb.toString());
    }

    static void fail(Deflater deflater, String str, int i6) {
        throw deflaterException(deflater, str, i6);
    }

    static DecompressionException inflaterException(Inflater inflater, String str, int i6) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(i6);
        sb.append(')');
        if (inflater.msg != null) {
            str2 = ": " + inflater.msg;
        } else {
            str2 = "";
        }
        sb.append(str2);
        return new DecompressionException(sb.toString());
    }

    static int wrapperOverhead(ZlibWrapper zlibWrapper) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i6 == 1) {
            return 0;
        }
        if (i6 != 2) {
            if (i6 == 3) {
                return 10;
            }
            if (i6 != 4) {
                throw new Error();
            }
        }
        return 2;
    }

    private ZlibUtil() {
    }
}
