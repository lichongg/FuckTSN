package com.bxkj.base.runtimepermissions;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class c {

    /* renamed from: c, reason: collision with root package name */
    private static final String f16535c = "c";

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f16536a;

    /* renamed from: b, reason: collision with root package name */
    private Looper f16537b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16539a;

        b(String str) {
            this.f16539a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f16539a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.runtimepermissions.c$c, reason: collision with other inner class name */
    class RunnableC0187c implements Runnable {
        RunnableC0187c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16542a;

        d(String str) {
            this.f16542a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f16542a);
        }
    }

    public c() {
        this.f16536a = new HashSet(1);
        this.f16537b = Looper.getMainLooper();
    }

    public abstract void a(String str);

    public abstract void b();

    @CallSuper
    protected final synchronized boolean c(@NonNull String str, int i6) {
        if (i6 == 0) {
            return d(str, com.bxkj.base.runtimepermissions.a.GRANTED);
        }
        return d(str, com.bxkj.base.runtimepermissions.a.DENIED);
    }

    @CallSuper
    protected final synchronized boolean d(@NonNull String str, com.bxkj.base.runtimepermissions.a aVar) {
        this.f16536a.remove(str);
        if (aVar == com.bxkj.base.runtimepermissions.a.GRANTED) {
            if (this.f16536a.isEmpty()) {
                new Handler(this.f16537b).post(new a());
                return true;
            }
        } else {
            if (aVar == com.bxkj.base.runtimepermissions.a.DENIED) {
                new Handler(this.f16537b).post(new b(str));
                return true;
            }
            if (aVar == com.bxkj.base.runtimepermissions.a.NOT_FOUND) {
                if (!f(str)) {
                    new Handler(this.f16537b).post(new d(str));
                    return true;
                }
                if (this.f16536a.isEmpty()) {
                    new Handler(this.f16537b).post(new RunnableC0187c());
                    return true;
                }
            }
        }
        return false;
    }

    @CallSuper
    protected final synchronized void e(@NonNull String[] strArr) {
        Collections.addAll(this.f16536a, strArr);
    }

    public synchronized boolean f(String str) {
        return true;
    }

    public c(@NonNull Looper looper) {
        this.f16536a = new HashSet(1);
        Looper.getMainLooper();
        this.f16537b = looper;
    }
}
