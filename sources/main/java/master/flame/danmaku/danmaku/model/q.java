package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class q extends d {

    /* renamed from: c0, reason: collision with root package name */
    protected static final long f50114c0 = 100;

    /* renamed from: d0, reason: collision with root package name */
    protected static final long f50115d0 = 40;
    protected int Y;

    /* renamed from: a0, reason: collision with root package name */
    protected float f50116a0;

    /* renamed from: b0, reason: collision with root package name */
    protected long f50117b0;
    protected float W = 0.0f;
    protected float X = -1.0f;
    protected float[] Z = null;

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
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
            long j6 = fVar.f50080a;
            long b6 = j6 - b();
            if (b6 > 0 && b6 < this.f50071r.f50084c) {
                this.W = H(nVar, j6);
                if (!v()) {
                    this.X = f7;
                    G(true);
                }
                this.f50117b0 = j6;
                return;
            }
            this.f50117b0 = j6;
        }
        G(false);
    }

    public q(g gVar) {
        this.f50071r = gVar;
    }

    protected float H(n nVar, long j6) {
        long b6 = j6 - b();
        if (b6 >= this.f50071r.f50084c) {
            return -this.f50069p;
        }
        return nVar.getWidth() - (b6 * this.f50116a0);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j6) {
        if (!q()) {
            return null;
        }
        float H = H(nVar, j6);
        if (this.Z == null) {
            this.Z = new float[4];
        }
        float[] fArr = this.Z;
        fArr[0] = H;
        float f6 = this.X;
        fArr[1] = f6;
        fArr[2] = H + this.f50069p;
        fArr[3] = f6 + this.f50070q;
        return fArr;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void z(n nVar, boolean z5) {
        super.z(nVar, z5);
        int width = (int) (nVar.getWidth() + this.f50069p);
        this.Y = width;
        this.f50116a0 = width / this.f50071r.f50084c;
    }
}
