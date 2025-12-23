package com.amap.api.col.p0003l;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x9 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f7673a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Charset> f7674b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<CharBuffer> f7675c = new ThreadLocal<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends ThreadLocal<CharsetDecoder> {
        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        a() {
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends ThreadLocal<Charset> {
        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        b() {
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    }
}
