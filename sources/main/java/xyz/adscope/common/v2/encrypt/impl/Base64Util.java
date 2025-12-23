package xyz.adscope.common.v2.encrypt.impl;

import android.util.Base64;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Base64Util implements IBaseEncrypt {
    private static final int BASE64_FLAG = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.encrypt.impl.Base64Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static Base64Util instance = new Base64Util(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ Base64Util(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static byte[] decodeToByteArray(String str) {
        try {
            return Base64.decode(str, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String decodeToString(byte[] bArr) {
        try {
            return new String(Base64.decode(bArr, 2));
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static byte[] encodeToByteArray(String str) {
        try {
            return Base64.encode(str.getBytes(), 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String encodeToString(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] decode(byte[] bArr) {
        try {
            return Base64.decode(bArr, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    @Override // xyz.adscope.common.v2.encrypt.impl.IBaseEncrypt
    public byte[] encode(byte[] bArr) {
        try {
            return Base64.encode(bArr, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    private Base64Util() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static byte[] decodeToByteArray(byte[] bArr) {
        try {
            return Base64.decode(bArr, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String decodeToString(String str) {
        try {
            return new String(Base64.decode(str, 2));
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static byte[] encodeToByteArray(byte[] bArr) {
        try {
            return Base64.encode(bArr, 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public static String encodeToString(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    static Base64Util getInstance() {
        return InstanceHolder.instance;
    }
}
