package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f40289a = null;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f40290d = true;

    /* renamed from: e, reason: collision with root package name */
    private static int f40291e;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f40292b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final String f40293c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IUiListener f40294a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f40295b;

        /* renamed from: c, reason: collision with root package name */
        public String f40296c;
    }

    public static b a() {
        if (f40289a == null) {
            f40289a = new b();
        }
        return f40289a;
    }

    public static int b() {
        int i6 = f40291e + 1;
        f40291e = i6;
        return i6;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < ceil; i6++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b6 = b();
        try {
            this.f40292b.put("" + b6, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b6;
    }
}
