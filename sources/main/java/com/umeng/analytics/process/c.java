package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f41516a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f41517b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Context f41518c;

    static c a(Context context) {
        if (f41516a == null) {
            synchronized (c.class) {
                try {
                    if (f41516a == null) {
                        f41516a = new c();
                    }
                } finally {
                }
            }
        }
        c cVar = f41516a;
        cVar.f41518c = context;
        return cVar;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f41519a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f41520b;

        /* renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f41521c;

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f41520b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f41519a.decrementAndGet() == 0) {
                    this.f41521c.close();
                }
            } catch (Throwable unused) {
            }
        }

        private a() {
        }

        synchronized SQLiteDatabase a() {
            try {
                if (this.f41519a.incrementAndGet() == 1) {
                    this.f41521c = this.f41520b.getWritableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f41521c;
        }
    }

    private a c(String str) {
        if (this.f41517b.get(str) != null) {
            return this.f41517b.get(str);
        }
        a a6 = a.a(this.f41518c, str);
        this.f41517b.put(str, a6);
        return a6;
    }

    private c() {
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
