package com.clj.fastble.scan;

import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private UUID[] f32125a = null;

    /* renamed from: b, reason: collision with root package name */
    private String[] f32126b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f32127c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32128d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32129e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f32130f = 10000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private UUID[] f32131a = null;

        /* renamed from: b, reason: collision with root package name */
        private String[] f32132b = null;

        /* renamed from: c, reason: collision with root package name */
        private String f32133c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f32134d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f32135e = false;

        /* renamed from: f, reason: collision with root package name */
        private long f32136f = 10000;

        void a(b bVar) {
            bVar.f32125a = this.f32131a;
            bVar.f32126b = this.f32132b;
            bVar.f32127c = this.f32133c;
            bVar.f32128d = this.f32134d;
            bVar.f32129e = this.f32135e;
            bVar.f32130f = this.f32136f;
        }

        public b b() {
            b bVar = new b();
            a(bVar);
            return bVar;
        }

        public a c(boolean z5) {
            this.f32134d = z5;
            return this;
        }

        public a d(String str) {
            this.f32133c = str;
            return this;
        }

        public a e(boolean z5, String... strArr) {
            this.f32135e = z5;
            this.f32132b = strArr;
            return this;
        }

        public a f(long j6) {
            this.f32136f = j6;
            return this;
        }

        public a g(UUID[] uuidArr) {
            this.f32131a = uuidArr;
            return this;
        }
    }

    public String g() {
        return this.f32127c;
    }

    public String[] h() {
        return this.f32126b;
    }

    public long i() {
        return this.f32130f;
    }

    public UUID[] j() {
        return this.f32125a;
    }

    public boolean k() {
        return this.f32128d;
    }

    public boolean l() {
        return this.f32129e;
    }
}
