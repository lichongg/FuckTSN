package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f41290b;

    /* renamed from: d, reason: collision with root package name */
    private static Context f41291d;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f41292a;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f41293c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f41294a = new g(null);

        private a() {
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a(Context context) {
        if (f41291d == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f41291d = origApplicationContext;
            f41290b = f.a(origApplicationContext);
        }
        return a.f41294a;
    }

    public synchronized void b() {
        try {
            if (this.f41292a.decrementAndGet() == 0) {
                this.f41293c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.f41292a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        try {
            if (this.f41292a.incrementAndGet() == 1) {
                this.f41293c = f41290b.getWritableDatabase();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f41293c;
    }
}
