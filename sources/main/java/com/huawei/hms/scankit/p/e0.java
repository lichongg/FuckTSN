package com.huawei.hms.scankit.p;

import android.graphics.Point;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private int f34189a;

    /* renamed from: b, reason: collision with root package name */
    private int f34190b;

    /* renamed from: c, reason: collision with root package name */
    private String f34191c;

    /* renamed from: d, reason: collision with root package name */
    private Point f34192d;

    /* renamed from: e, reason: collision with root package name */
    private int f34193e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34194f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34195g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: e, reason: collision with root package name */
        private Point f34200e;

        /* renamed from: a, reason: collision with root package name */
        private int f34196a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f34197b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f34198c = 0;

        /* renamed from: d, reason: collision with root package name */
        private String f34199d = kotlinx.coroutines.t0.f49654e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f34201f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f34202g = false;

        public b a(int i6) {
            this.f34197b = i6;
            return this;
        }

        public b b(int i6) {
            this.f34198c = i6;
            return this;
        }

        public b a(Point point) {
            this.f34200e = point;
            return this;
        }

        public b b(boolean z5) {
            this.f34201f = z5;
            return this;
        }

        public b a(boolean z5) {
            this.f34202g = z5;
            return this;
        }

        public e0 a() {
            return new e0(this.f34196a, this.f34197b, this.f34198c, this.f34199d, this.f34200e, this.f34201f, null).a(this.f34202g);
        }
    }

    /* synthetic */ e0(int i6, int i7, int i8, String str, Point point, boolean z5, a aVar) {
        this(i6, i7, i8, str, point, z5);
    }

    private e0(int i6, int i7, int i8, String str, Point point, boolean z5) {
        this.f34189a = i6;
        this.f34190b = i7;
        this.f34193e = i8;
        this.f34191c = str;
        this.f34192d = point;
        this.f34194f = z5;
    }

    public void a(int i6) {
        this.f34193e = i6;
    }

    public int b() {
        return this.f34189a;
    }

    public int c() {
        return this.f34190b;
    }

    public int d() {
        return this.f34193e;
    }

    public boolean e() {
        return this.f34194f;
    }

    public String f() {
        return this.f34191c;
    }

    public Point a() {
        return this.f34192d;
    }

    public void a(Point point) {
        this.f34192d = point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e0 a(boolean z5) {
        this.f34195g = z5;
        return this;
    }
}
