package cn.jiguang.bo;

import android.content.Context;
import cn.jiguang.bo.a;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f2410a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f2411b = new Object();

    public static void a(Context context) {
        synchronized (f2411b) {
            a aVar = new a(10000L, false, new a.InterfaceC0035a() { // from class: cn.jiguang.bo.b.1
                @Override // cn.jiguang.bo.a.InterfaceC0035a
                public void a(cn.jiguang.bp.a aVar2) {
                    b.b(aVar2);
                }
            }, context);
            f2410a = aVar;
            aVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(cn.jiguang.bp.a aVar) {
        cn.jiguang.bp.c cVar = new cn.jiguang.bp.c();
        cVar.a("ANR");
        h.a().a(new c(cVar, aVar, aVar.a(), true));
    }
}
