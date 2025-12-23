package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ThreadLocalCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<>();
    private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<>();
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();

    private static char[] allocate(int i6) {
        if (i6 > 131072) {
            return new char[i6];
        }
        char[] cArr = new char[getAllocateLengthExp(10, 17, i6)];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    private static byte[] allocateBytes(int i6) {
        if (i6 > 131072) {
            return new byte[i6];
        }
        byte[] bArr = new byte[getAllocateLengthExp(10, 17, i6)];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    private static int getAllocateLengthExp(int i6, int i7, int i8) {
        return (i8 >>> i6) <= 0 ? 1 << i6 : 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
    }

    public static byte[] getBytes(int i6) {
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference == null) {
            return allocateBytes(i6);
        }
        byte[] bArr = softReference.get();
        return bArr == null ? allocateBytes(i6) : bArr.length < i6 ? allocateBytes(i6) : bArr;
    }

    public static char[] getChars(int i6) {
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference == null) {
            return allocate(i6);
        }
        char[] cArr = softReference.get();
        return cArr == null ? allocate(i6) : cArr.length < i6 ? allocate(i6) : cArr;
    }

    public static CharsetDecoder getUTF8Decoder() {
        ThreadLocal<CharsetDecoder> threadLocal = decoderLocal;
        CharsetDecoder charsetDecoder = threadLocal.get();
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        UTF8Decoder uTF8Decoder = new UTF8Decoder();
        threadLocal.set(uTF8Decoder);
        return uTF8Decoder;
    }
}
