package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i extends d {
    private float W = 0.0f;
    protected float X = -1.0f;
    private float[] Y = null;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f50085a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f50086b0;

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }

    protected float H(n nVar) {
        if (this.f50086b0 == nVar.getWidth() && this.f50085a0 == this.f50069p) {
            return this.Z;
        }
        float width = (nVar.getWidth() - this.f50069p) / 2.0f;
        this.f50086b0 = nVar.getWidth();
        this.f50085a0 = this.f50069p;
        this.Z = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float d() {
        return this.X + this.f50070q;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float g() {
        return this.W;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float i() {
        return this.W + this.f50069p;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float l() {
        return this.X;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void y(n nVar, float f6, float f7) {
        f fVar = this.E;
        if (fVar != null) {
            long b6 = fVar.f50080a - b();
            if (b6 <= 0 || b6 >= this.f50071r.f50084c) {
                G(false);
                this.X = -1.0f;
                this.W = nVar.getWidth();
            } else {
                if (v()) {
                    return;
                }
                this.W = H(nVar);
                this.X = f7;
                G(true);
            }
        }
    }

    public i(g gVar) {
        this.f50071r = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j6) {
        if (!q()) {
            return null;
        }
        float H = H(nVar);
        if (this.Y == null) {
            this.Y = new float[4];
        }
        float[] fArr = this.Y;
        fArr[0] = H;
        float f6 = this.X;
        fArr[1] = f6;
        fArr[2] = H + this.f50069p;
        fArr[3] = f6 + this.f50070q;
        return fArr;
    }
}
