package com.bxkj.student.v2.common.utils.safe;

import android.os.Debug;
import com.bxkj.student.App;
import com.orhanobut.logger.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f20937a = new b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        while (true) {
            try {
                Thread.sleep(100L);
                if (Debug.isDebuggerConnected()) {
                    j.d("非Debug 编译，反调试检测", new Object[0]);
                    System.exit(0);
                }
                if (h.f20948a.a()) {
                    j.d("非Debug 编译，反调试检测", new Object[0]);
                    System.exit(0);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void b() {
        if (c.f20938a.d()) {
            j.d("非Debug 编译，反调试检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        new Thread(new Runnable() { // from class: com.bxkj.student.v2.common.utils.safe.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c();
            }
        }, "SafeGuardThread").start();
        if (d.f20939a.a()) {
            j.d("模拟器检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (f.f20946a.c()) {
            j.d("hook检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (h.f20948a.a()) {
            j.d("非Debug 编译，反调试检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (g.f20947a.d()) {
            j.d("root设备，反调试检测", new Object[0]);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (c0.b.f1042a.c(App.f17573d.a())) {
            return;
        }
        j.d("反编译非正版应用", new Object[0]);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private b() {
    }
}
