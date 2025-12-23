package xyz.adscope.ad;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface z3 extends m2<y3> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a implements l2 {
        SINGLE_VIEW_RENDERED(33, "single_render"),
        RENDER_SUCCESS(34, "render_success"),
        RENDER_FAILED(35, "render_failed");


        /* renamed from: a, reason: collision with root package name */
        private final int f56213a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56214b;

        @Override // xyz.adscope.ad.l2
        public int getEventCode() {
            return this.f56213a;
        }

        a(int i6, String str) {
            this.f56213a = i6;
            this.f56214b = str;
        }
    }

    void a();

    void a(o2 o2Var);

    void renderFailed();
}
