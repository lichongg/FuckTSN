package com.acse.ottn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k4 extends n4 {
    public a N;
    public long O = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(k4 k4Var, long j6, long j7);
    }

    @Override // com.acse.ottn.n4
    public void a(float f6) {
    }

    public void a(a aVar) {
        this.N = aVar;
    }

    @Override // com.acse.ottn.n4
    public boolean c(long j6) {
        if (this.f4945i == 0) {
            this.f4945i = 1;
            long j7 = this.f4939c;
            if (j7 < 0) {
                this.f4938b = j6;
            } else {
                this.f4938b = j6 - j7;
                this.f4939c = -1L;
            }
        }
        a aVar = this.N;
        if (aVar == null) {
            return false;
        }
        long j8 = j6 - this.f4938b;
        long j9 = this.O;
        long j10 = j9 >= 0 ? j6 - j9 : 0L;
        this.O = j6;
        aVar.a(this, j8, j10);
        return false;
    }

    @Override // com.acse.ottn.n4
    public void D() {
    }
}
