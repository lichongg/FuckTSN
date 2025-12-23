package com.bytedance.sdk.component.m.cw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.g;
import com.bytedance.sdk.component.m.kt;
import com.bytedance.sdk.component.m.oq;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.ws;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements g {

    /* renamed from: a, reason: collision with root package name */
    private int f26514a;
    private Bitmap.Config ae;
    private kt av;
    private boolean az;
    private com.bytedance.sdk.component.m.xt ch;
    private String cw;

    /* renamed from: f, reason: collision with root package name */
    private int f26515f;

    /* renamed from: g, reason: collision with root package name */
    private int f26516g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f26517h;

    /* renamed from: i, reason: collision with root package name */
    private int f26518i;

    /* renamed from: j, reason: collision with root package name */
    Future<?> f26519j;
    private volatile boolean jy;
    private boolean kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f26520l;
    private ws la;

    /* renamed from: m, reason: collision with root package name */
    private ImageView.ScaleType f26521m;
    private final Handler mi;
    private com.bytedance.sdk.component.m.tl oq;

    /* renamed from: p, reason: collision with root package name */
    private ExecutorService f26522p;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private String f26523r;

    /* renamed from: s, reason: collision with root package name */
    private int f26524s;
    private com.bytedance.sdk.component.m.ae tj;
    private int tl;
    private av up;

    /* renamed from: v, reason: collision with root package name */
    private m f26525v;
    private WeakReference<ImageView> vl;

    /* renamed from: w, reason: collision with root package name */
    private Queue<com.bytedance.sdk.component.m.r.g> f26526w;
    private boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.component.m.cw.j f26527x;
    private String xt;

    private class j implements av {
        private av xt;

        public j(av avVar) {
            this.xt = avVar;
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(1)
        public void j(final qv qvVar) {
            Bitmap j6;
            final ImageView imageView = (ImageView) cw.this.vl.get();
            if (imageView != null && cw.this.qv != 3 && j(imageView) && (qvVar.cw() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) qvVar.cw();
                cw.this.mi.post(new Runnable() { // from class: com.bytedance.sdk.component.m.cw.cw.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (cw.this.oq != null && (qvVar.cw() instanceof Bitmap) && (j6 = cw.this.oq.j((Bitmap) qvVar.cw())) != null) {
                    qvVar.setResult(j6);
                }
            } catch (Throwable unused) {
            }
            if (cw.this.f26518i == 5) {
                cw.this.mi.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.m.cw.cw.j.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.xt != null) {
                            j.this.xt.j(qvVar);
                        }
                    }
                });
                return;
            }
            av avVar = this.xt;
            if (avVar != null) {
                avVar.j(qvVar);
            }
        }

        private boolean j(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(cw.this.cw)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.m.av
        @ATSMethod(2)
        public void j(final int i6, final String str, final Throwable th) {
            if (cw.this.f26518i == 5) {
                cw.this.mi.post(new Runnable() { // from class: com.bytedance.sdk.component.m.cw.cw.j.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.xt != null) {
                            j.this.xt.j(i6, str, th);
                        }
                    }
                });
                return;
            }
            av avVar = this.xt;
            if (avVar != null) {
                avVar.j(i6, str, th);
            }
        }
    }

    public static class xt implements oq {
        private int ae;
        private m av;
        private com.bytedance.sdk.component.m.xt az;
        private String cw;

        /* renamed from: f, reason: collision with root package name */
        private boolean f26535f;

        /* renamed from: i, reason: collision with root package name */
        private com.bytedance.sdk.component.m.tl f26537i;

        /* renamed from: j, reason: collision with root package name */
        private av f26538j;
        private boolean jy;
        private boolean kt;

        /* renamed from: m, reason: collision with root package name */
        private Bitmap.Config f26539m;
        private int mi;
        private kt qv;

        /* renamed from: r, reason: collision with root package name */
        private String f26540r;
        private ExecutorService tj;
        private int tl;
        private ImageView.ScaleType up;

        /* renamed from: v, reason: collision with root package name */
        private ws f26541v;
        private boolean vl;

        /* renamed from: w, reason: collision with root package name */
        private int f26542w;
        private String ws;
        private ImageView xt;

        /* renamed from: g, reason: collision with root package name */
        private int f26536g = 1;
        private int oq = 5;

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(12)
        public oq cw(int i6) {
            this.f26536g = i6;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(4)
        public oq j(String str) {
            this.f26540r = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(18)
        public oq r(int i6) {
            this.f26542w = i6;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(19)
        public oq up(int i6) {
            this.mi = i6;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(5)
        public oq xt(String str) {
            this.cw = str;
            return this;
        }

        public xt(m mVar) {
            this.av = mVar;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(7)
        public oq cw(String str) {
            this.ws = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(6)
        public oq j(com.bytedance.sdk.component.m.xt xtVar) {
            this.az = xtVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(11)
        public oq xt(int i6) {
            this.tl = i6;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(20)
        public oq cw(boolean z5) {
            this.f26535f = z5;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(8)
        public oq j(ImageView.ScaleType scaleType) {
            this.up = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(15)
        public oq xt(boolean z5) {
            this.jy = z5;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(9)
        public oq j(Bitmap.Config config) {
            this.f26539m = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(10)
        public oq j(int i6) {
            this.ae = i6;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(13)
        public oq j(kt ktVar) {
            this.qv = ktVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(14)
        public oq j(boolean z5) {
            this.vl = z5;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(16)
        public oq j(ExecutorService executorService) {
            this.tj = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(1)
        public g j(av avVar, int i6) {
            this.oq = i6;
            return j(avVar);
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(2)
        public g j(av avVar) {
            this.f26538j = avVar;
            return new cw(this).ch();
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(3)
        public g j(ImageView imageView) {
            this.xt = imageView;
            return new cw(this).ch();
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(17)
        public oq j(com.bytedance.sdk.component.m.tl tlVar) {
            this.f26537i = tlVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.oq
        @ATSMethod(21)
        public oq j(ws wsVar) {
            this.f26541v = wsVar;
            return this;
        }
    }

    private cw(xt xtVar) {
        this.f26526w = new LinkedBlockingQueue();
        this.mi = new Handler(Looper.getMainLooper());
        this.kt = true;
        this.xt = xtVar.f26540r;
        this.up = new j(xtVar.f26538j);
        this.vl = new WeakReference<>(xtVar.xt);
        this.f26521m = xtVar.up;
        this.ae = xtVar.f26539m;
        this.tl = xtVar.ae;
        this.f26516g = xtVar.tl;
        this.qv = xtVar.f26536g;
        this.f26518i = xtVar.oq;
        this.av = xtVar.qv;
        this.ch = j(xtVar);
        if (!TextUtils.isEmpty(xtVar.cw)) {
            xt(xtVar.cw);
            j(xtVar.cw);
        }
        this.ws = xtVar.vl;
        this.az = xtVar.jy;
        this.f26525v = xtVar.av;
        this.oq = xtVar.f26537i;
        this.f26514a = xtVar.mi;
        this.f26524s = xtVar.f26542w;
        this.f26522p = xtVar.tj;
        this.f26520l = xtVar.kt;
        this.f26517h = xtVar.f26535f;
        this.la = xtVar.f26541v;
        this.f26526w.add(new com.bytedance.sdk.component.m.r.cw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g ch() {
        try {
            m mVar = this.f26525v;
            if (mVar == null) {
                av avVar = this.up;
                if (avVar != null) {
                    avVar.j(1005, "not init !", null);
                    return this;
                }
            } else {
                ExecutorService m6 = this.f26522p == null ? mVar.m() : null;
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.m.cw.cw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.m.r.g gVar;
                        while (!cw.this.jy && (gVar = (com.bytedance.sdk.component.m.r.g) cw.this.f26526w.poll()) != null) {
                            try {
                                if (cw.this.av != null) {
                                    cw.this.av.j(gVar.j(), cw.this);
                                }
                                gVar.j(cw.this);
                                if (cw.this.av != null) {
                                    cw.this.av.xt(gVar.j(), cw.this);
                                }
                            } catch (Throwable th) {
                                cw.this.j(2000, th.getMessage(), th);
                                if (cw.this.av != null) {
                                    cw.this.av.xt("exception", cw.this);
                                    return;
                                }
                                return;
                            }
                        }
                        if (cw.this.jy) {
                            cw.this.j(1003, "canceled", null);
                        }
                    }
                };
                if (this.f26517h) {
                    runnable.run();
                    return this;
                }
                ExecutorService executorService = this.f26522p;
                if (executorService != null) {
                    this.f26519j = executorService.submit(runnable);
                    return this;
                }
                if (m6 != null) {
                    this.f26519j = m6.submit(runnable);
                }
            }
            return this;
        } catch (Exception e6) {
            vl.r("ImageRequest", e6.getMessage());
            return this;
        }
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(7)
    public String ae() {
        return this.cw;
    }

    public boolean av() {
        return this.kt;
    }

    public boolean az() {
        return this.az;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(3)
    public int cw() {
        return this.tl;
    }

    public boolean f() {
        return this.f26520l;
    }

    public int g() {
        return this.f26524s;
    }

    public com.bytedance.sdk.component.m.ae i() {
        return this.tj;
    }

    public int jy() {
        return this.qv;
    }

    public m kt() {
        return this.f26525v;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(6)
    public String m() {
        return this.f26523r;
    }

    public com.bytedance.sdk.component.m.cw.j mi() {
        return this.f26527x;
    }

    public int oq() {
        return this.f26514a;
    }

    public av qv() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(4)
    public int r() {
        return this.f26516g;
    }

    public com.bytedance.sdk.component.m.xt tj() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(8)
    public Bitmap.Config tl() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(5)
    public ImageView.ScaleType up() {
        return this.f26521m;
    }

    public ws v() {
        return this.la;
    }

    public Bitmap.Config vl() {
        return this.ae;
    }

    public int w() {
        return this.f26515f;
    }

    public boolean ws() {
        return this.ws;
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(2)
    public String xt() {
        return this.xt;
    }

    private com.bytedance.sdk.component.m.xt j(xt xtVar) {
        if (xtVar.az != null) {
            return xtVar.az;
        }
        if (!TextUtils.isEmpty(xtVar.ws)) {
            return com.bytedance.sdk.component.m.cw.j.j.j(new File(xtVar.ws));
        }
        return com.bytedance.sdk.component.m.cw.j.j.g();
    }

    public String x() {
        return m();
    }

    public void xt(String str) {
        WeakReference<ImageView> weakReference = this.vl;
        if (weakReference != null && weakReference.get() != null) {
            this.vl.get().setTag(1094453505, str);
        }
        this.cw = str;
    }

    public void j(String str) {
        this.f26523r = str;
    }

    public void j(boolean z5) {
        this.kt = z5;
    }

    public void j(com.bytedance.sdk.component.m.ae aeVar) {
        this.tj = aeVar;
    }

    public void j(int i6) {
        this.f26515f = i6;
    }

    public void j(com.bytedance.sdk.component.m.cw.j jVar) {
        this.f26527x = jVar;
    }

    public boolean j(com.bytedance.sdk.component.m.r.g gVar) {
        if (this.jy) {
            return false;
        }
        return this.f26526w.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str, Throwable th) {
        new com.bytedance.sdk.component.m.r.tl(i6, str, th).j(this);
        this.f26526w.clear();
    }

    @Override // com.bytedance.sdk.component.m.g
    @ATSMethod(1)
    public boolean j() {
        this.jy = true;
        Future<?> future = this.f26519j;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }
}
