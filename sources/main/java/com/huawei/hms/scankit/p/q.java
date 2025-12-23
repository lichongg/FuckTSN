package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class q extends i7 {

    /* renamed from: c, reason: collision with root package name */
    private final short f34687c;

    /* renamed from: d, reason: collision with root package name */
    private final short f34688d;

    @Override // com.huawei.hms.scankit.p.i7
    public void a(r rVar, byte[] bArr) {
        int i6 = 0;
        while (true) {
            short s5 = this.f34688d;
            if (i6 >= s5) {
                return;
            }
            if (i6 == 0 || (i6 == 31 && s5 <= 62)) {
                rVar.a(31, 5);
                short s6 = this.f34688d;
                if (s6 > 62) {
                    rVar.a(s6 - 31, 16);
                } else if (i6 == 0) {
                    rVar.a(Math.min((int) s6, 31), 5);
                } else {
                    rVar.a(s6 - 31, 5);
                }
            }
            rVar.a(bArr[this.f34687c + i6], 8);
            i6++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append((int) this.f34687c);
        sb.append("::");
        sb.append((this.f34687c + this.f34688d) - 1);
        sb.append(kotlin.text.v0.f47962f);
        return sb.toString();
    }

    q(i7 i7Var, int i6, int i7) {
        super(i7Var);
        this.f34687c = (short) i6;
        this.f34688d = (short) i7;
    }
}
