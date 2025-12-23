package com.huawei.agconnect;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f33004a = new HashMap();

    public interface a {
        String a(e eVar);
    }

    public static Map<String, a> a() {
        return f33004a;
    }

    public static void b(String str, a aVar) {
        f33004a.put(str, aVar);
    }
}
