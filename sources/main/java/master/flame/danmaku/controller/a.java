package master.flame.danmaku.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import tv.cjump.jni.NativeBitmapFactory;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a extends e {
    private static final int C = 3;
    static final /* synthetic */ boolean D = false;
    private final Object A;
    private int B;

    /* renamed from: x, reason: collision with root package name */
    private int f49746x;

    /* renamed from: y, reason: collision with root package name */
    private b f49747y;

    /* renamed from: z, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.f f49748z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.controller.a$a, reason: collision with other inner class name */
    class RunnableC0963a implements Runnable {
        RunnableC0963a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f49883g.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements k {

        /* renamed from: k, reason: collision with root package name */
        private static final String f49750k = "CacheManager";

        /* renamed from: l, reason: collision with root package name */
        public static final byte f49751l = 0;

        /* renamed from: m, reason: collision with root package name */
        public static final byte f49752m = 1;

        /* renamed from: n, reason: collision with root package name */
        public static final byte f49753n = 2;

        /* renamed from: a, reason: collision with root package name */
        public HandlerThread f49754a;

        /* renamed from: b, reason: collision with root package name */
        master.flame.danmaku.danmaku.model.android.e f49755b = new master.flame.danmaku.danmaku.model.android.e();

        /* renamed from: c, reason: collision with root package name */
        master.flame.danmaku.danmaku.model.android.h f49756c;

        /* renamed from: d, reason: collision with root package name */
        master.flame.danmaku.danmaku.model.objectpool.b<master.flame.danmaku.danmaku.model.android.f> f49757d;

        /* renamed from: e, reason: collision with root package name */
        private int f49758e;

        /* renamed from: f, reason: collision with root package name */
        private int f49759f;

        /* renamed from: g, reason: collision with root package name */
        private int f49760g;

        /* renamed from: h, reason: collision with root package name */
        private e f49761h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f49762i;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: master.flame.danmaku.controller.a$b$a, reason: collision with other inner class name */
        class C0964a extends m.c<master.flame.danmaku.danmaku.model.d> {
            C0964a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                b.this.s(true, dVar, null);
                return 0;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: master.flame.danmaku.controller.a$b$b, reason: collision with other inner class name */
        class C0965b extends m.c<master.flame.danmaku.danmaku.model.d> {
            C0965b() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.s()) {
                    b.this.s(true, dVar, null);
                    return 2;
                }
                return 0;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c extends m.c<master.flame.danmaku.danmaku.model.d> {
            c() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (!dVar.w()) {
                    return 1;
                }
                o<?> oVar = dVar.f50078y;
                if (a.this.f49879c.E.f49992c != -1 || oVar == null || oVar.hasReferences() || oVar.size() / a.this.f49746x >= a.this.f49879c.E.f49993d) {
                    synchronized (a.this.A) {
                        try {
                            a.this.A.wait(30L);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                            return 1;
                        }
                    }
                    b.this.s(false, dVar, null);
                    return 2;
                }
                return 0;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class d extends m.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> {

            /* renamed from: e, reason: collision with root package name */
            int f49767e = 0;

            /* renamed from: f, reason: collision with root package name */
            master.flame.danmaku.danmaku.model.d f49768f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f49769g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ master.flame.danmaku.danmaku.model.d f49770h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f49771i;

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ int f49772j;

            d(int i6, master.flame.danmaku.danmaku.model.d dVar, boolean z5, int i7) {
                this.f49769g = i6;
                this.f49770h = dVar;
                this.f49771i = z5;
                this.f49772j = i7;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                int i6 = this.f49767e;
                this.f49767e = i6 + 1;
                if (i6 >= this.f49769g) {
                    return 1;
                }
                o<?> e6 = dVar.e();
                if (e6 != null && e6.get() != null) {
                    float f6 = dVar.f50069p;
                    master.flame.danmaku.danmaku.model.d dVar2 = this.f49770h;
                    if (f6 == dVar2.f50069p && dVar.f50070q == dVar2.f50070q && dVar.f50064k == dVar2.f50064k && dVar.f50066m == dVar2.f50066m && dVar.f50060g == dVar2.f50060g && dVar.f50056c.equals(dVar2.f50056c) && dVar.f50059f == this.f49770h.f50059f) {
                        this.f49768f = dVar;
                        return 1;
                    }
                    if (this.f49771i) {
                        return 0;
                    }
                    if (!dVar.w()) {
                        return 1;
                    }
                    if (e6.hasReferences()) {
                        return 0;
                    }
                    float e7 = e6.e() - this.f49770h.f50069p;
                    float a6 = e6.a() - this.f49770h.f50070q;
                    if (e7 >= 0.0f) {
                        int i7 = this.f49772j;
                        if (e7 <= i7 && a6 >= 0.0f && a6 <= i7) {
                            this.f49768f = dVar;
                            return 1;
                        }
                    }
                }
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public master.flame.danmaku.danmaku.model.d d() {
                return this.f49768f;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class e extends Handler {

            /* renamed from: f, reason: collision with root package name */
            private static final int f49774f = 1;

            /* renamed from: g, reason: collision with root package name */
            public static final int f49775g = 2;

            /* renamed from: h, reason: collision with root package name */
            public static final int f49776h = 3;

            /* renamed from: i, reason: collision with root package name */
            public static final int f49777i = 4;

            /* renamed from: j, reason: collision with root package name */
            public static final int f49778j = 5;

            /* renamed from: k, reason: collision with root package name */
            public static final int f49779k = 6;

            /* renamed from: l, reason: collision with root package name */
            public static final int f49780l = 7;

            /* renamed from: m, reason: collision with root package name */
            public static final int f49781m = 8;

            /* renamed from: n, reason: collision with root package name */
            public static final int f49782n = 9;

            /* renamed from: o, reason: collision with root package name */
            public static final int f49783o = 16;

            /* renamed from: p, reason: collision with root package name */
            public static final int f49784p = 17;

            /* renamed from: q, reason: collision with root package name */
            public static final int f49785q = 18;

            /* renamed from: a, reason: collision with root package name */
            private boolean f49786a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f49787b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f49788c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f49789d;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: master.flame.danmaku.controller.a$b$e$a, reason: collision with other inner class name */
            class C0966a extends m.c<master.flame.danmaku.danmaku.model.d> {
                C0966a() {
                }

                @Override // master.flame.danmaku.danmaku.model.m.b
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public int a(master.flame.danmaku.danmaku.model.d dVar) {
                    master.flame.danmaku.danmaku.model.d dVar2;
                    if (e.this.f49786a || e.this.f49789d) {
                        return 1;
                    }
                    if (dVar.m()) {
                        dVar2 = dVar;
                    } else {
                        DanmakuContext danmakuContext = a.this.f49879c;
                        dVar2 = dVar;
                        danmakuContext.C.b(dVar2, 0, 0, null, true, danmakuContext);
                    }
                    if (dVar2.n()) {
                        return 0;
                    }
                    if (!dVar2.q()) {
                        dVar2.z(a.this.f49880d, true);
                    }
                    if (!dVar2.u()) {
                        dVar2.A(a.this.f49880d, true);
                    }
                    return 0;
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: master.flame.danmaku.controller.a$b$e$b, reason: collision with other inner class name */
            class C0967b extends m.c<master.flame.danmaku.danmaku.model.d> {

                /* renamed from: e, reason: collision with root package name */
                int f49792e = 0;

                /* renamed from: f, reason: collision with root package name */
                int f49793f = 0;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ master.flame.danmaku.danmaku.model.d f49794g;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f49795h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f49796i;

                /* renamed from: j, reason: collision with root package name */
                final /* synthetic */ long f49797j;

                /* renamed from: k, reason: collision with root package name */
                final /* synthetic */ long f49798k;

                /* renamed from: l, reason: collision with root package name */
                final /* synthetic */ long f49799l;

                C0967b(master.flame.danmaku.danmaku.model.d dVar, boolean z5, int i6, long j6, long j7, long j8) {
                    this.f49794g = dVar;
                    this.f49795h = z5;
                    this.f49796i = i6;
                    this.f49797j = j6;
                    this.f49798k = j7;
                    this.f49799l = j8;
                }

                @Override // master.flame.danmaku.danmaku.model.m.b
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public int a(master.flame.danmaku.danmaku.model.d dVar) {
                    master.flame.danmaku.danmaku.model.d dVar2;
                    if (e.this.f49786a || e.this.f49789d || this.f49794g.b() < a.this.f49885i.f50080a) {
                        return 1;
                    }
                    o<?> e6 = dVar.e();
                    if (e6 != null && e6.get() != null) {
                        return 0;
                    }
                    if (!this.f49795h && (dVar.w() || !dVar.s())) {
                        return 0;
                    }
                    if (dVar.m()) {
                        dVar2 = dVar;
                    } else {
                        DanmakuContext danmakuContext = a.this.f49879c;
                        dVar2 = dVar;
                        danmakuContext.C.b(dVar2, this.f49792e, this.f49796i, null, true, danmakuContext);
                    }
                    if (dVar2.f50068o == 0 && dVar2.n()) {
                        return 0;
                    }
                    if (dVar2.getType() == 1) {
                        int b6 = (int) ((dVar2.b() - this.f49797j) / a.this.f49879c.D.f50009e);
                        if (this.f49793f == b6) {
                            this.f49792e++;
                        } else {
                            this.f49792e = 0;
                            this.f49793f = b6;
                        }
                    }
                    if (!this.f49795h && !e.this.f49787b) {
                        try {
                            synchronized (a.this.A) {
                                a.this.A.wait(this.f49798k);
                            }
                        } catch (InterruptedException e7) {
                            e7.printStackTrace();
                            return 1;
                        }
                    }
                    e.this.g(dVar2, false);
                    if (!this.f49795h) {
                        long b7 = w4.c.b() - this.f49799l;
                        master.flame.danmaku.danmaku.model.android.d dVar3 = a.this.f49879c.D;
                        if (b7 >= r11.f49760g * master.flame.danmaku.danmaku.model.android.d.f50001p) {
                            return 1;
                        }
                    }
                    return 0;
                }
            }

            public void f() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.f49879c.D.f50009e);
            }

            public void l() {
                this.f49786a = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void p(long j6) {
                removeMessages(3);
                this.f49788c = true;
                sendEmptyMessage(18);
                a.this.f49748z.update(a.this.f49885i.f50080a + j6);
                sendEmptyMessage(3);
            }

            public void q() {
                this.f49789d = true;
            }

            public e(Looper looper) {
                super(looper);
            }

            private long i() {
                long j6 = a.this.f49748z.f50080a;
                b bVar = b.this;
                a aVar = a.this;
                long j7 = aVar.f49885i.f50080a;
                DanmakuContext danmakuContext = aVar.f49879c;
                if (j6 <= j7 - danmakuContext.D.f50009e) {
                    if (danmakuContext.E.f49992c != -1) {
                        bVar.u();
                    }
                    a.this.f49748z.update(a.this.f49885i.f50080a);
                    sendEmptyMessage(3);
                    return 0L;
                }
                float x5 = bVar.x();
                master.flame.danmaku.danmaku.model.d first = b.this.f49755b.first();
                long b6 = first != null ? first.b() - a.this.f49885i.f50080a : 0L;
                a aVar2 = a.this;
                long j8 = aVar2.f49879c.D.f50009e;
                long j9 = 2 * j8;
                if (x5 < 0.6f && b6 > j8) {
                    aVar2.f49748z.update(a.this.f49885i.f50080a);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                }
                if (x5 > 0.4f && b6 < (-j9)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    return 0L;
                }
                if (x5 >= 0.9f) {
                    return 0L;
                }
                long j10 = aVar2.f49748z.f50080a - a.this.f49885i.f50080a;
                if (first != null && first.w()) {
                    a aVar3 = a.this;
                    if (j10 < (-aVar3.f49879c.D.f50009e)) {
                        aVar3.f49748z.update(a.this.f49885i.f50080a);
                        sendEmptyMessage(8);
                        sendEmptyMessage(3);
                        return 0L;
                    }
                }
                if (j10 > j9) {
                    return 0L;
                }
                removeMessages(3);
                sendEmptyMessage(3);
                return 0L;
            }

            private void m() {
                m mVar;
                try {
                    a aVar = a.this;
                    long j6 = aVar.f49885i.f50080a;
                    long j7 = aVar.f49879c.D.f50009e;
                    mVar = aVar.f49881e.i(j6 - j7, (2 * j7) + j6);
                } catch (Exception unused) {
                    mVar = null;
                }
                if (mVar == null || mVar.isEmpty()) {
                    return;
                }
                mVar.f(new C0966a());
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
            
                r23.f49790e.f49763j.f49748z.update(r11);
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
            
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private long n(boolean r24) {
                /*
                    Method dump skipped, instructions count: 218
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.a.b.e.n(boolean):long");
            }

            private void o(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.android.f fVar) {
                if (fVar == null) {
                    fVar = (master.flame.danmaku.danmaku.model.android.f) dVar.f50078y;
                }
                dVar.f50078y = null;
                if (fVar == null) {
                    return;
                }
                fVar.destroy();
                b.this.f49757d.a(fVar);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i6 = message.what;
                switch (i6) {
                    case 1:
                        b.this.u();
                        for (int i7 = 0; i7 < 300; i7++) {
                            b.this.f49757d.a(new master.flame.danmaku.danmaku.model.android.f());
                        }
                        break;
                    case 2:
                        e((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        a aVar = a.this;
                        boolean z5 = !(aVar.f49883g == null || aVar.f49890n) || this.f49788c;
                        n(z5);
                        if (z5) {
                            this.f49788c = false;
                        }
                        a aVar2 = a.this;
                        h.a aVar3 = aVar2.f49883g;
                        if (aVar3 == null || aVar2.f49890n) {
                            return;
                        }
                        aVar3.c();
                        a.this.f49890n = true;
                        return;
                    case 4:
                        b.this.q();
                        return;
                    case 5:
                        Long l6 = (Long) message.obj;
                        if (l6 != null) {
                            long longValue = l6.longValue();
                            long j6 = a.this.f49748z.f50080a;
                            a.this.f49748z.update(longValue);
                            this.f49788c = true;
                            long w5 = b.this.w();
                            if (longValue <= j6) {
                                long j7 = w5 - longValue;
                                b bVar = b.this;
                                if (j7 <= a.this.f49879c.D.f50009e) {
                                    bVar.q();
                                    n(true);
                                    r();
                                    return;
                                }
                            }
                            b.this.u();
                            n(true);
                            r();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.f49786a = true;
                        b.this.t();
                        b.this.o();
                        getLooper().quit();
                        return;
                    case 7:
                        b.this.t();
                        master.flame.danmaku.danmaku.model.f fVar = a.this.f49748z;
                        a aVar4 = a.this;
                        fVar.update(aVar4.f49885i.f50080a - aVar4.f49879c.D.f50009e);
                        this.f49788c = true;
                        return;
                    case 8:
                        b.this.u();
                        a.this.f49748z.update(a.this.f49885i.f50080a);
                        return;
                    case 9:
                        b.this.u();
                        a.this.f49748z.update(a.this.f49885i.f50080a);
                        a.this.i();
                        return;
                    default:
                        switch (i6) {
                            case 17:
                                master.flame.danmaku.danmaku.model.d dVar = (master.flame.danmaku.danmaku.model.d) message.obj;
                                if (dVar != null) {
                                    o<?> e6 = dVar.e();
                                    if ((dVar.J & 1) == 0 && e6 != null && e6.get() != null && !e6.hasReferences()) {
                                        a aVar5 = a.this;
                                        dVar.f50078y = w4.a.a(dVar, aVar5.f49880d, (master.flame.danmaku.danmaku.model.android.f) dVar.f50078y, aVar5.f49879c.E.f49990a);
                                        b.this.C(dVar, 0, true);
                                        break;
                                    } else if (dVar.f50079z) {
                                        b.this.n(dVar);
                                        h(dVar);
                                        break;
                                    } else {
                                        if (e6 != null && e6.hasReferences()) {
                                            e6.destroy();
                                        }
                                        b.this.s(true, dVar, null);
                                        e(dVar);
                                        break;
                                    }
                                }
                                break;
                            case 18:
                                this.f49789d = false;
                                break;
                        }
                        return;
                }
                long i8 = i();
                if (i8 <= 0) {
                    i8 = a.this.f49879c.D.f50009e / 2;
                }
                sendEmptyMessageDelayed(16, i8);
            }

            public boolean j() {
                return this.f49786a;
            }

            public void k(boolean z5) {
                this.f49787b = !z5;
            }

            public void r() {
                sendEmptyMessage(18);
                this.f49786a = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, a.this.f49879c.D.f50009e);
            }

            private final void e(master.flame.danmaku.danmaku.model.d dVar) {
                if (!dVar.w()) {
                    if (dVar.b() <= a.this.f49748z.f50080a + a.this.f49879c.D.f50009e || dVar.f50079z) {
                        if (dVar.f50068o != 0 || !dVar.n()) {
                            o<?> e6 = dVar.e();
                            if (e6 == null || e6.get() == null) {
                                g(dVar, true);
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public byte g(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
                master.flame.danmaku.danmaku.model.android.f fVar;
                if (!dVar.q()) {
                    dVar.z(a.this.f49880d, true);
                }
                master.flame.danmaku.danmaku.model.android.f fVar2 = null;
                try {
                    b bVar = b.this;
                    master.flame.danmaku.danmaku.model.d v5 = bVar.v(dVar, true, a.this.f49879c.E.f49995f);
                    if (v5 != null) {
                        fVar = (master.flame.danmaku.danmaku.model.android.f) v5.f50078y;
                    } else {
                        fVar = null;
                    }
                    try {
                        if (fVar != null) {
                            fVar.j();
                            dVar.f50078y = fVar;
                            a.this.f49747y.C(dVar, 0, z5);
                            return (byte) 0;
                        }
                        b bVar2 = b.this;
                        master.flame.danmaku.danmaku.model.d v6 = bVar2.v(dVar, false, a.this.f49879c.E.f49996g);
                        if (v6 != null) {
                            fVar = (master.flame.danmaku.danmaku.model.android.f) v6.f50078y;
                        }
                        if (fVar != null) {
                            v6.f50078y = null;
                            a aVar = a.this;
                            dVar.f50078y = w4.a.a(dVar, aVar.f49880d, fVar, aVar.f49879c.E.f49990a);
                            a.this.f49747y.C(dVar, 0, z5);
                            return (byte) 0;
                        }
                        int f6 = w4.a.f((int) dVar.f50069p, (int) dVar.f50070q, a.this.f49879c.E.f49990a / 8);
                        if (f6 * 2 > a.this.f49746x) {
                            return (byte) 1;
                        }
                        if (!z5 && b.this.f49759f + f6 > b.this.f49758e) {
                            a.this.f49747y.p(f6, false);
                            return (byte) 1;
                        }
                        master.flame.danmaku.danmaku.model.android.f acquire = b.this.f49757d.acquire();
                        a aVar2 = a.this;
                        master.flame.danmaku.danmaku.model.android.f a6 = w4.a.a(dVar, aVar2.f49880d, acquire, aVar2.f49879c.E.f49990a);
                        dVar.f50078y = a6;
                        boolean C = a.this.f49747y.C(dVar, b.this.J(dVar), z5);
                        if (!C) {
                            o(dVar, a6);
                        }
                        return !C ? (byte) 1 : (byte) 0;
                    } catch (Exception unused) {
                        fVar2 = fVar;
                        o(dVar, fVar2);
                        return (byte) 1;
                    } catch (OutOfMemoryError unused2) {
                        fVar2 = fVar;
                        o(dVar, fVar2);
                        return (byte) 1;
                    }
                } catch (Exception unused3) {
                } catch (OutOfMemoryError unused4) {
                }
            }

            public boolean h(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.f fVar;
                if (!dVar.q()) {
                    dVar.z(a.this.f49880d, true);
                }
                try {
                    fVar = b.this.f49757d.acquire();
                } catch (Exception unused) {
                    fVar = null;
                } catch (OutOfMemoryError unused2) {
                    fVar = null;
                }
                try {
                    a aVar = a.this;
                    fVar = w4.a.a(dVar, aVar.f49880d, fVar, aVar.f49879c.E.f49990a);
                    dVar.f50078y = fVar;
                    return true;
                } catch (Exception unused3) {
                    if (fVar != null) {
                        b.this.f49757d.a(fVar);
                    }
                    dVar.f50078y = null;
                    return false;
                } catch (OutOfMemoryError unused4) {
                    if (fVar != null) {
                        b.this.f49757d.a(fVar);
                    }
                    dVar.f50078y = null;
                    return false;
                }
            }
        }

        public void m() {
            this.f49762i = false;
            if (this.f49754a == null) {
                HandlerThread handlerThread = new HandlerThread("DFM Cache-Building Thread");
                this.f49754a = handlerThread;
                handlerThread.start();
            }
            if (this.f49761h == null) {
                this.f49761h = new e(this.f49754a.getLooper());
            }
            this.f49761h.f();
        }

        public void r() {
            this.f49762i = true;
            synchronized (a.this.A) {
                a.this.A.notifyAll();
            }
            e eVar = this.f49761h;
            if (eVar != null) {
                eVar.l();
                this.f49761h = null;
            }
            HandlerThread handlerThread = this.f49754a;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
                this.f49754a.quit();
                this.f49754a = null;
            }
        }

        public b(int i6, int i7) {
            master.flame.danmaku.danmaku.model.android.h hVar = new master.flame.danmaku.danmaku.model.android.h();
            this.f49756c = hVar;
            this.f49757d = master.flame.danmaku.danmaku.model.objectpool.e.a(hVar, 800);
            this.f49762i = false;
            this.f49759f = 0;
            this.f49758e = i6;
            this.f49760g = i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean C(master.flame.danmaku.danmaku.model.d dVar, int i6, boolean z5) {
            if (i6 > 0) {
                p(i6, z5);
            }
            this.f49755b.j(dVar);
            this.f49759f += i6;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long n(master.flame.danmaku.danmaku.model.d dVar) {
            o<?> oVar = dVar.f50078y;
            if (oVar == null) {
                return 0L;
            }
            if (oVar.hasReferences()) {
                oVar.c();
                dVar.f50078y = null;
                return 0L;
            }
            long J = J(dVar);
            oVar.destroy();
            dVar.f50078y = null;
            return J;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.f acquire = this.f49757d.acquire();
                if (acquire == null) {
                    return;
                } else {
                    acquire.destroy();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i6, boolean z5) {
            master.flame.danmaku.danmaku.model.d first = this.f49755b.first();
            while (this.f49759f + i6 > this.f49758e && first != null) {
                if (first.w() || first.n()) {
                    s(false, first, null);
                    this.f49755b.e(first);
                    first = this.f49755b.first();
                } else if (z5) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            this.f49755b.f(new c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            master.flame.danmaku.danmaku.model.android.e eVar = this.f49755b;
            if (eVar != null) {
                eVar.f(new C0964a());
                this.f49755b.clear();
            }
            this.f49759f = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            master.flame.danmaku.danmaku.model.android.e eVar = this.f49755b;
            if (eVar != null) {
                eVar.f(new C0965b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public master.flame.danmaku.danmaku.model.d v(master.flame.danmaku.danmaku.model.d dVar, boolean z5, int i6) {
            d dVar2 = new d(i6, dVar, z5, (!z5 ? a.this.f49880d.n() * 2 : 0) + a.this.f49879c.E.f49994e);
            this.f49755b.f(dVar2);
            return dVar2.d();
        }

        public void A(int i6) {
            e eVar = this.f49761h;
            if (eVar != null) {
                eVar.k(i6 == 1);
            }
        }

        public void B(Runnable runnable) {
            e eVar = this.f49761h;
            if (eVar == null) {
                return;
            }
            eVar.post(runnable);
        }

        public void D(long j6) {
            e eVar = this.f49761h;
            if (eVar != null) {
                eVar.p(j6);
            }
        }

        public void E() {
            e eVar = this.f49761h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(3);
            this.f49761h.removeMessages(18);
            this.f49761h.q();
            this.f49761h.removeMessages(7);
            this.f49761h.sendEmptyMessage(7);
        }

        public void F() {
            e eVar = this.f49761h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(4);
            this.f49761h.sendEmptyMessage(4);
        }

        public void G() {
            e eVar = this.f49761h;
            if (eVar == null) {
                return;
            }
            eVar.removeMessages(9);
            this.f49761h.sendEmptyMessage(9);
        }

        public void H() {
            e eVar = this.f49761h;
            if (eVar != null) {
                eVar.r();
            } else {
                m();
            }
        }

        public void I(long j6) {
            e eVar = this.f49761h;
            if (eVar == null) {
                return;
            }
            eVar.q();
            this.f49761h.removeMessages(3);
            this.f49761h.obtainMessage(5, Long.valueOf(j6)).sendToTarget();
        }

        protected int J(master.flame.danmaku.danmaku.model.d dVar) {
            o<?> oVar = dVar.f50078y;
            if (oVar == null || oVar.hasReferences()) {
                return 0;
            }
            return dVar.f50078y.size();
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            e eVar = this.f49761h;
            if (eVar != null) {
                if (!dVar.f50079z || !dVar.A) {
                    eVar.obtainMessage(2, dVar).sendToTarget();
                } else {
                    if (dVar.w()) {
                        return;
                    }
                    this.f49761h.h(dVar);
                }
            }
        }

        public long w() {
            master.flame.danmaku.danmaku.model.d first;
            master.flame.danmaku.danmaku.model.android.e eVar = this.f49755b;
            if (eVar == null || eVar.size() <= 0 || (first = this.f49755b.first()) == null) {
                return 0L;
            }
            return first.b();
        }

        public float x() {
            int i6 = this.f49758e;
            if (i6 == 0) {
                return 0.0f;
            }
            return this.f49759f / i6;
        }

        public void y(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
            e eVar = this.f49761h;
            if (eVar != null) {
                eVar.q();
                this.f49761h.obtainMessage(17, dVar).sendToTarget();
            }
        }

        public boolean z() {
            return this.f49759f + 5120 >= this.f49758e;
        }

        protected void s(boolean z5, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            o<?> e6 = dVar.e();
            if (e6 != null) {
                long n6 = n(dVar);
                if (dVar.w()) {
                    a.this.f49879c.g().t().g(dVar);
                }
                if (n6 > 0) {
                    this.f49759f = (int) (this.f49759f - n6);
                    this.f49757d.a((master.flame.danmaku.danmaku.model.android.f) e6);
                }
            }
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        b bVar = this.f49747y;
        if (bVar == null) {
            super.b(dVar, z5);
        } else {
            bVar.y(dVar, z5);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void prepare() {
        s(this.f49882f);
        this.f49747y.m();
    }

    @Override // master.flame.danmaku.controller.e
    protected void r(master.flame.danmaku.danmaku.model.f fVar) {
        this.f49885i = fVar;
        master.flame.danmaku.danmaku.model.f fVar2 = new master.flame.danmaku.danmaku.model.f();
        this.f49748z = fVar2;
        fVar2.update(fVar.f50080a);
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        super(fVar, danmakuContext, aVar);
        this.f49746x = 2;
        this.A = new Object();
        NativeBitmapFactory.g();
        int max = (int) Math.max(4194304.0f, Runtime.getRuntime().maxMemory() * danmakuContext.E.f49991b);
        this.f49746x = max;
        b bVar = new b(max, 3);
        this.f49747y = bVar;
        this.f49884h.e(bVar);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        b bVar = this.f49747y;
        if (bVar == null) {
            return;
        }
        bVar.a(dVar);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void c(boolean z5) {
        super.c(z5);
        b bVar = this.f49747y;
        if (bVar != null) {
            bVar.E();
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void h(long j6, long j7, long j8) {
        super.h(j6, j7, j8);
        b bVar = this.f49747y;
        if (bVar != null) {
            bVar.I(j7);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void k() {
        super.k();
        reset();
        this.f49884h.e(null);
        b bVar = this.f49747y;
        if (bVar != null) {
            bVar.r();
            this.f49747y = null;
        }
        NativeBitmapFactory.i();
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public a.c l(master.flame.danmaku.danmaku.model.b bVar) {
        b bVar2;
        a.c l6 = super.l(bVar);
        synchronized (this.A) {
            this.A.notify();
        }
        if (l6 != null && (bVar2 = this.f49747y) != null && l6.f54723k - l6.f54724l < -20) {
            bVar2.F();
            this.f49747y.D(-this.f49879c.D.f50009e);
        }
        return l6;
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void onPlayStateChanged(int i6) {
        super.onPlayStateChanged(i6);
        b bVar = this.f49747y;
        if (bVar != null) {
            bVar.A(i6);
        }
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void seek(long j6) {
        super.seek(j6);
        if (this.f49747y == null) {
            start();
        }
        this.f49747y.I(j6);
    }

    @Override // master.flame.danmaku.controller.e, master.flame.danmaku.controller.h
    public void start() {
        super.start();
        NativeBitmapFactory.g();
        b bVar = this.f49747y;
        if (bVar == null) {
            b bVar2 = new b(this.f49746x, 3);
            this.f49747y = bVar2;
            bVar2.m();
            this.f49884h.e(this.f49747y);
            return;
        }
        bVar.H();
    }

    @Override // master.flame.danmaku.controller.e
    public boolean t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        b bVar;
        Object obj;
        b bVar2;
        if (!super.q(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.f49880d.a(this.f49879c.f49917c);
                i();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && ((!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && (bVar2 = this.f49747y) != null)) {
                    bVar2.D(0L);
                }
                i();
            } else if (!DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                b bVar3 = this.f49747y;
                if (bVar3 != null) {
                    bVar3.G();
                    this.f49747y.D(0L);
                }
            } else {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.f49880d.a(this.f49879c.f49917c);
                }
                b bVar4 = this.f49747y;
                if (bVar4 != null) {
                    bVar4.E();
                    this.f49747y.D(-this.f49879c.D.f50009e);
                }
            }
        }
        if (this.f49883g != null && (bVar = this.f49747y) != null) {
            bVar.B(new RunnableC0963a());
            return true;
        }
        return true;
    }

    @Override // master.flame.danmaku.controller.e
    protected void u(master.flame.danmaku.danmaku.model.d dVar) {
        super.u(dVar);
        b bVar = this.f49747y;
        if (bVar != null) {
            int i6 = this.B + 1;
            this.B = i6;
            if (i6 > 5) {
                bVar.F();
                this.B = 0;
                return;
            }
            return;
        }
        o<?> e6 = dVar.e();
        if (e6 != null) {
            if (e6.hasReferences()) {
                e6.c();
            } else {
                e6.destroy();
            }
            dVar.f50078y = null;
        }
    }
}
