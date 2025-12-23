package com.bytedance.sdk.component.cw.xt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class tl {
    public static final tl ae;
    public static final tl av;
    public static final tl az;
    public static final tl cw;

    /* renamed from: g, reason: collision with root package name */
    public static final tl f26371g;

    /* renamed from: j, reason: collision with root package name */
    static final Comparator<String> f26372j;
    public static final tl jy;

    /* renamed from: m, reason: collision with root package name */
    public static final tl f26373m;
    public static final tl oq;
    public static final tl qv;

    /* renamed from: r, reason: collision with root package name */
    public static final tl f26374r;
    public static final tl tl;
    public static final tl up;
    public static final tl vl;

    /* renamed from: w, reason: collision with root package name */
    private static final Map<String, tl> f26375w;
    public static final tl ws;
    public static final tl xt;

    /* renamed from: i, reason: collision with root package name */
    final String f26376i;

    public static synchronized tl j(String str) {
        tl tlVar;
        synchronized (tl.class) {
            Map<String, tl> map = f26375w;
            tlVar = map.get(str);
            if (tlVar == null) {
                tlVar = new tl(str);
                map.put(str, tlVar);
            }
        }
        return tlVar;
    }

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.cw.xt.tl.1
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int min = Math.min(str.length(), str2.length());
                for (int i6 = 4; i6 < min; i6++) {
                    char charAt = str.charAt(i6);
                    char charAt2 = str2.charAt(i6);
                    if (charAt != charAt2) {
                        if (charAt < charAt2) {
                            return -1;
                        }
                        return 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    if (length < length2) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
        };
        f26372j = comparator;
        f26375w = new TreeMap(comparator);
        xt = j("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        cw = j("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        f26374r = j("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        up = j("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f26373m = j("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        ae = j("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        tl = j("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        f26371g = j("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        oq = j("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        qv = j("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        vl = j("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        jy = j("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        ws = j("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        az = j("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        av = j("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public String toString() {
        return this.f26376i;
    }

    private tl(String str) {
        str.getClass();
        this.f26376i = str;
    }

    static List<tl> j(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(j(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static tl j(String str, int i6) {
        return j(str);
    }

    public String j() {
        return this.f26376i;
    }
}
