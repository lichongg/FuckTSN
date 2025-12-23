package com.beizi.ad.internal.e.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.i;
import com.beizi.ad.internal.f;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.d;
import com.beizi.ad.internal.h.e;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public c f11827a;

    /* renamed from: b, reason: collision with root package name */
    f f11828b;

    /* renamed from: c, reason: collision with root package name */
    com.beizi.ad.internal.d.a f11829c;

    /* renamed from: f, reason: collision with root package name */
    int f11832f;

    /* renamed from: d, reason: collision with root package name */
    boolean f11830d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f11831e = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11833g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f11834h = new b(this);

    /* renamed from: i, reason: collision with root package name */
    private long f11835i = -1;

    /* renamed from: j, reason: collision with root package name */
    private long f11836j = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.e.a.a$1, reason: invalid class name */
    class AnonymousClass1 implements com.beizi.ad.internal.f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f11837a;

        @Override // com.beizi.ad.internal.f.b
        public boolean b() {
            return true;
        }

        @Override // com.beizi.ad.internal.f.b
        public com.beizi.ad.internal.view.c c() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public String g() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public boolean i() {
            return false;
        }

        @Override // com.beizi.ad.internal.f.b
        public c j() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public String k() {
            return null;
        }

        @Override // com.beizi.ad.internal.f.b
        public k a() {
            return k.NATIVE;
        }

        @Override // com.beizi.ad.internal.f.b
        public i d() {
            return this.f11837a;
        }

        @Override // com.beizi.ad.internal.f.b
        public String e() {
            return "";
        }

        @Override // com.beizi.ad.internal.f.b
        public String f() {
            return this.f11837a.f();
        }

        @Override // com.beizi.ad.internal.f.b
        public void h() {
            this.f11837a.h();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.e.a.a$a, reason: collision with other inner class name */
    private class AsyncTaskC0106a extends d {

        /* renamed from: a, reason: collision with root package name */
        f f11838a;

        /* renamed from: b, reason: collision with root package name */
        final int f11839b;

        /* renamed from: d, reason: collision with root package name */
        private final String f11841d;

        /* renamed from: e, reason: collision with root package name */
        private final HashMap<String, Object> f11842e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f11843f;

        /* renamed from: g, reason: collision with root package name */
        private final long f11844g;

        /* renamed from: h, reason: collision with root package name */
        private final long f11845h;

        /* synthetic */ AsyncTaskC0106a(a aVar, f fVar, String str, int i6, HashMap hashMap, boolean z5, long j6, long j7, AnonymousClass1 anonymousClass1) {
            this(fVar, str, i6, hashMap, z5, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.beizi.ad.internal.h.d, android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            f fVar;
            c cVar;
            if (this.f11843f || (fVar = this.f11838a) == null) {
                return;
            }
            if (eVar == null || !eVar.a()) {
                cVar = null;
            } else {
                cVar = new c(eVar, k.NATIVE);
                if (this.f11842e.containsKey("ORIENTATION")) {
                    cVar.a("ORIENTATION", this.f11842e.get("ORIENTATION"));
                }
            }
            fVar.a(cVar);
        }

        private AsyncTaskC0106a(f fVar, String str, int i6, HashMap<String, Object> hashMap, boolean z5, long j6, long j7) {
            super(true, true);
            this.f11838a = fVar;
            this.f11841d = str;
            this.f11839b = i6;
            this.f11842e = hashMap;
            this.f11843f = z5;
            this.f11844g = j6;
            this.f11845h = j7;
        }

        @Override // com.beizi.ad.internal.h.d
        protected String a() {
            StringBuilder sb = new StringBuilder(this.f11841d);
            sb.append("&reason=");
            sb.append(this.f11839b);
            sb.append("&uid=");
            sb.append(Uri.encode(com.beizi.ad.internal.h.a.a().d()));
            if (this.f11844g > 0) {
                sb.append("&latency=");
                sb.append(Uri.encode(String.valueOf(this.f11844g)));
            }
            if (this.f11845h > 0) {
                sb.append("&total_latency=");
                sb.append(Uri.encode(String.valueOf(this.f11845h)));
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<a> f11846a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f11846a.get();
            if (aVar == null || aVar.f11831e) {
                return;
            }
            try {
                aVar.a(0);
            } catch (IllegalArgumentException unused) {
            } finally {
                aVar.f11829c = null;
            }
        }

        public b(a aVar) {
            this.f11846a = new WeakReference<>(aVar);
        }
    }

    public static a a(com.beizi.ad.internal.d.a aVar, f fVar, c cVar) {
        return new a(aVar, fVar, cVar);
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    private void b(int i6) {
        if (this.f11831e) {
            return;
        }
        f fVar = this.f11828b;
        com.beizi.ad.internal.d.a aVar = this.f11829c;
        if (aVar == null || o.a(aVar.f())) {
            if (i6 == -1 || fVar == null) {
                return;
            }
            fVar.a((c) null);
            return;
        }
        boolean z5 = i6 == -1 ? true : (fVar == null || fVar.b() == null || fVar.b().size() <= 0) ? false : true;
        try {
            new AsyncTaskC0106a(this, fVar, this.f11829c.f(), i6, this.f11829c.g(), z5, f(), a(fVar), null).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
        } catch (RejectedExecutionException | Exception unused) {
        }
        if (!z5 || i6 == -1 || fVar == null) {
            return;
        }
        fVar.a((c) null);
    }

    private void a(Throwable th, String str) {
        if (!o.a(str)) {
            h.a().a(k.NATIVE, str);
        }
        this.f11832f = 3;
    }

    private long f() {
        long j6 = this.f11835i;
        if (j6 <= 0) {
            return -1L;
        }
        long j7 = this.f11836j;
        if (j7 > 0) {
            return j7 - j6;
        }
        return -1L;
    }

    void c() {
        this.f11834h.removeMessages(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a(com.beizi.ad.internal.d.a r7, com.beizi.ad.internal.f r8, com.beizi.ad.internal.f.c r9) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.f11830d = r0
            r6.f11831e = r0
            r6.f11833g = r0
            com.beizi.ad.internal.e.a.a$b r0 = new com.beizi.ad.internal.e.a.a$b
            r0.<init>(r6)
            r6.f11834h = r0
            r0 = -1
            r6.f11835i = r0
            r6.f11836j = r0
            if (r7 != 0) goto L1f
            r7 = 3
            r6.f11832f = r7
            r4 = r6
            goto La4
        L1f:
            r6.f11828b = r8
            r6.f11829c = r7
            r6.f11827a = r9
            r6.b()
            r6.d()
            java.lang.String r9 = r7.a()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            java.lang.Object r9 = r9.newInstance()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            r0 = r9
            com.beizi.ad.internal.e.a.b r0 = (com.beizi.ad.internal.e.a.b) r0     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            com.beizi.ad.internal.e r9 = r8.c()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            if (r9 == 0) goto L78
            com.beizi.ad.internal.e r9 = r8.c()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            android.content.Context r1 = r9.b()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            java.lang.String r2 = r7.e()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            java.lang.String r3 = r7.b()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            com.beizi.ad.b.a r5 = r8.d()     // Catch: java.lang.IllegalAccessException -> L69 java.lang.InstantiationException -> L6c java.lang.LinkageError -> L6f java.lang.ClassCastException -> L72 java.lang.ClassNotFoundException -> L75
            r4 = r6
            r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.IllegalAccessException -> L5a java.lang.InstantiationException -> L5d java.lang.LinkageError -> L60 java.lang.ClassCastException -> L63 java.lang.ClassNotFoundException -> L66
            goto La4
        L5a:
            r0 = move-exception
        L5b:
            r8 = r0
            goto L7d
        L5d:
            r0 = move-exception
        L5e:
            r8 = r0
            goto L85
        L60:
            r0 = move-exception
        L61:
            r8 = r0
            goto L8d
        L63:
            r0 = move-exception
        L64:
            r8 = r0
            goto L95
        L66:
            r0 = move-exception
        L67:
            r8 = r0
            goto L9d
        L69:
            r0 = move-exception
            r4 = r6
            goto L5b
        L6c:
            r0 = move-exception
            r4 = r6
            goto L5e
        L6f:
            r0 = move-exception
            r4 = r6
            goto L61
        L72:
            r0 = move-exception
            r4 = r6
            goto L64
        L75:
            r0 = move-exception
            r4 = r6
            goto L67
        L78:
            r4 = r6
            r8 = 1
            r4.f11832f = r8     // Catch: java.lang.IllegalAccessException -> L5a java.lang.InstantiationException -> L5d java.lang.LinkageError -> L60 java.lang.ClassCastException -> L63 java.lang.ClassNotFoundException -> L66
            goto La4
        L7d:
            java.lang.String r7 = r7.a()
            r6.a(r8, r7)
            goto La4
        L85:
            java.lang.String r7 = r7.a()
            r6.a(r8, r7)
            goto La4
        L8d:
            java.lang.String r7 = r7.a()
            r6.a(r8, r7)
            goto La4
        L95:
            java.lang.String r7 = r7.a()
            r6.a(r8, r7)
            goto La4
        L9d:
            java.lang.String r7 = r7.a()
            r6.a(r8, r7)
        La4:
            int r7 = r4.f11832f
            r8 = -1
            if (r7 == r8) goto Lac
            r6.a(r7)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.e.a.a.<init>(com.beizi.ad.internal.d.a, com.beizi.ad.internal.f, com.beizi.ad.internal.f.c):void");
    }

    protected void d() {
        this.f11835i = System.currentTimeMillis();
    }

    protected void e() {
        this.f11836j = System.currentTimeMillis();
    }

    protected void a() {
        this.f11829c = null;
    }

    public void a(int i6) {
        if (this.f11830d || this.f11831e) {
            return;
        }
        e();
        c();
        b(i6);
        this.f11831e = true;
        a();
    }

    private long a(f fVar) {
        if (fVar == null) {
            return -1L;
        }
        long j6 = this.f11836j;
        if (j6 > 0) {
            return fVar.a(j6);
        }
        return -1L;
    }

    void b() {
        if (this.f11830d || this.f11831e) {
            return;
        }
        this.f11834h.sendEmptyMessageDelayed(0, 15000L);
    }

    public void a(boolean z5) {
        this.f11833g = z5;
        if (z5) {
            a();
        }
    }
}
