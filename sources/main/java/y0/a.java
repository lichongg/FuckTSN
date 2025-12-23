package y0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.j.xt.tl.i;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f56774c;

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.j.xt.xt.xt.b f56775a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f56776b;

    public synchronized void c(z0.a aVar) {
        com.bytedance.j.xt.xt.xt.b bVar = this.f56775a;
        if (bVar != null) {
            bVar.insert(this.f56776b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        com.bytedance.j.xt.xt.xt.b bVar = this.f56775a;
        if (bVar == null) {
            return false;
        }
        return bVar.e(this.f56776b, str);
    }

    public static a a() {
        if (f56774c == null) {
            synchronized (a.class) {
                try {
                    if (f56774c == null) {
                        f56774c = new a();
                    }
                } finally {
                }
            }
        }
        return f56774c;
    }

    public void b(Context context) {
        try {
            this.f56776b = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            i.c(th);
        }
        this.f56775a = new com.bytedance.j.xt.xt.xt.b();
    }

    private a() {
    }
}
