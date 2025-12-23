package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f10290a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            try {
                List<a> list = this.f10290a;
                if (list != null) {
                    list.add(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                this.f10290a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String g() {
        String stringBuffer;
        synchronized (b.class) {
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (a aVar : this.f10290a) {
                    if (aVar != null) {
                        String a6 = aVar.a();
                        if (!TextUtils.isEmpty(a6)) {
                            stringBuffer2.append(a6);
                            if (!a6.endsWith(";")) {
                                stringBuffer2.append(";");
                            }
                        }
                    }
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            try {
                Iterator<a> it = this.f10290a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object j() {
        Object b6;
        synchronized (b.class) {
            try {
                for (a aVar : this.f10290a) {
                    if (aVar != null && (b6 = aVar.b()) != null) {
                        return b6;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
