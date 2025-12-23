package com.bxkj.student.v2.ai.fitness.camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f20542a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20543b;

    /* renamed from: c, reason: collision with root package name */
    private final int f20544c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f20545a;

        /* renamed from: b, reason: collision with root package name */
        private int f20546b;

        /* renamed from: c, reason: collision with root package name */
        private int f20547c;

        public f a() {
            return new f(this.f20545a, this.f20546b, this.f20547c, null);
        }

        public a b(int height) {
            this.f20546b = height;
            return this;
        }

        public a c(int rotation) {
            this.f20547c = rotation;
            return this;
        }

        public a d(int width) {
            this.f20545a = width;
            return this;
        }
    }

    /* synthetic */ f(int i6, int i7, int i8, g gVar) {
        this(i6, i7, i8);
    }

    private f(int width, int height, int rotation) {
        this.f20542a = width;
        this.f20543b = height;
        this.f20544c = rotation;
    }

    public int a() {
        return this.f20543b;
    }

    public int b() {
        return this.f20544c;
    }

    public int c() {
        return this.f20542a;
    }
}
