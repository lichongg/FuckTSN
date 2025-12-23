package com.huawei.agconnect.core.a;

import com.huawei.agconnect.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes5.dex */
public class a extends com.huawei.agconnect.a {

    /* renamed from: b, reason: collision with root package name */
    private static final List<a.InterfaceC0537a> f32960b = new CopyOnWriteArrayList();

    public static void c() {
        Iterator<a.InterfaceC0537a> it = f32960b.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    @Override // com.huawei.agconnect.a
    public void a(a.InterfaceC0537a interfaceC0537a) {
        if (interfaceC0537a != null) {
            f32960b.add(interfaceC0537a);
        }
    }
}
