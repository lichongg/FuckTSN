package xyz.adscope.ad;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class a2 {

    /* renamed from: a, reason: collision with root package name */
    protected final String f54773a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f54774b;

    /* renamed from: c, reason: collision with root package name */
    protected final float[] f54775c;

    /* renamed from: d, reason: collision with root package name */
    protected final long f54776d;

    /* renamed from: e, reason: collision with root package name */
    protected final c f54777e;

    /* renamed from: f, reason: collision with root package name */
    protected final r5 f54778f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a<T extends a2> {

        /* renamed from: a, reason: collision with root package name */
        private String f54779a;

        /* renamed from: b, reason: collision with root package name */
        private int f54780b;

        /* renamed from: c, reason: collision with root package name */
        private float[] f54781c = {0.0f, 0.0f};

        /* renamed from: d, reason: collision with root package name */
        private long f54782d;

        /* renamed from: e, reason: collision with root package name */
        private String f54783e;

        protected abstract c a();

        protected abstract T f(a<T> aVar);

        protected a<T> setExpressSizePixel(float f6, float f7) {
            this.f54781c = new float[]{f6, f7};
            return this;
        }

        public T build(String str) {
            this.f54779a = str;
            return f(this);
        }

        protected a<T> setAdCount(int i6) {
            this.f54780b = i6;
            return this;
        }

        public a<T> setS2SAdImpl(String str) {
            this.f54783e = str;
            return this;
        }

        protected a<T> setTimeoutMillion(long j6) {
            this.f54782d = j6;
            return this;
        }
    }

    public int getAdCount() {
        int i6 = this.f54774b;
        if (i6 > 0) {
            return i6;
        }
        return 1;
    }

    public c getAdType() {
        return this.f54777e;
    }

    public float[] getExpressViewSizePixel() {
        return this.f54775c;
    }

    public r5 getS2SAdImpl() {
        return this.f54778f;
    }

    public String getSpaceID() {
        return this.f54773a;
    }

    public long getTimeoutMillion() {
        return this.f54776d;
    }

    protected a2(a<?> aVar) {
        this.f54773a = ((a) aVar).f54779a;
        this.f54774b = ((a) aVar).f54780b;
        this.f54775c = ((a) aVar).f54781c;
        this.f54776d = ((a) aVar).f54782d;
        this.f54777e = aVar.a();
        if (!TextUtils.isEmpty(((a) aVar).f54783e)) {
            this.f54778f = new r5(((a) aVar).f54783e);
        } else {
            this.f54778f = null;
        }
    }

    public String getApiKey() {
        return f0.a();
    }
}
