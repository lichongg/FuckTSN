package com.bytedance.sdk.openadsdk.ats;

import a1.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class AutoService implements Function<Class, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static List<Function> f27605j = new ArrayList();

    public static Function init(Function function) {
        if (function != null) {
            f27605j.add(function);
        }
        return new AutoService();
    }

    public static <T> T j(Class<T> cls) {
        Object apply;
        T t5 = (T) j.j().j(cls);
        if (t5 == null && f27605j.size() > 0) {
            Iterator<Function> it = f27605j.iterator();
            while (it.hasNext()) {
                apply = b.a(it.next()).apply(cls);
                t5 = (T) apply;
                if (t5 != null) {
                    break;
                }
            }
        }
        return t5;
    }

    @Override // java.util.function.Function
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public Object apply(Class cls) {
        return j.j().j(cls);
    }
}
