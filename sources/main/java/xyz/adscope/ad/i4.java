package xyz.adscope.ad;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface i4 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static i4 a() {
            return new f7();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f55225a;

        /* renamed from: b, reason: collision with root package name */
        private long f55226b;

        /* renamed from: c, reason: collision with root package name */
        private float f55227c;

        /* renamed from: d, reason: collision with root package name */
        private float f55228d;

        /* renamed from: e, reason: collision with root package name */
        private float f55229e;

        /* renamed from: f, reason: collision with root package name */
        private float f55230f;

        /* renamed from: g, reason: collision with root package name */
        private float f55231g;

        /* renamed from: h, reason: collision with root package name */
        private float f55232h;

        /* renamed from: i, reason: collision with root package name */
        private float f55233i;

        /* renamed from: j, reason: collision with root package name */
        private float f55234j;

        /* renamed from: k, reason: collision with root package name */
        private float f55235k;

        /* renamed from: l, reason: collision with root package name */
        private float f55236l;

        /* renamed from: m, reason: collision with root package name */
        private int f55237m;

        /* renamed from: n, reason: collision with root package name */
        private int f55238n;

        public float a() {
            return this.f55229e;
        }

        public float b() {
            return this.f55230f;
        }

        public long c() {
            return this.f55225a;
        }

        public float d() {
            return this.f55227c;
        }

        void a(float f6, float f7) {
            this.f55229e = f6;
            this.f55230f = f7;
        }

        void b(float f6, float f7) {
            this.f55227c = f6;
            this.f55228d = f7;
        }

        void c(float f6, float f7) {
            this.f55233i = f6;
            this.f55234j = f7;
        }

        void d(float f6, float f7) {
            this.f55231g = f6;
            this.f55232h = f7;
        }

        public float e() {
            return this.f55228d;
        }

        public float f() {
            return this.f55233i;
        }

        public float g() {
            return this.f55234j;
        }

        public long h() {
            return this.f55226b;
        }

        public float i() {
            return this.f55231g;
        }

        public float j() {
            return this.f55232h;
        }

        public int k() {
            return this.f55238n;
        }

        public int l() {
            return this.f55237m;
        }

        public float m() {
            return this.f55235k;
        }

        public float n() {
            return this.f55236l;
        }

        b() {
        }

        void o() {
            this.f55225a = System.currentTimeMillis();
        }

        void p() {
            this.f55226b = System.currentTimeMillis();
        }

        void a(View view) {
            this.f55235k = view.getX();
            this.f55236l = view.getY();
            this.f55237m = view.getMeasuredWidth();
            this.f55238n = view.getMeasuredHeight();
        }
    }

    b a();

    void a(MotionEvent motionEvent);

    void a(View view);

    void a(View view, View view2, MotionEvent motionEvent);
}
