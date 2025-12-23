package org.apache.commons.net.telnet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n extends k {

    /* renamed from: j, reason: collision with root package name */
    protected static final int f51181j = 31;

    /* renamed from: h, reason: collision with root package name */
    private int f51182h;

    /* renamed from: i, reason: collision with root package name */
    private int f51183i;

    public n(int i6, int i7, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(31, z5, z6, z7, z8);
        this.f51182h = i6;
        this.f51183i = i7;
    }

    @Override // org.apache.commons.net.telnet.k
    public int[] o() {
        int i6 = this.f51182h;
        int i7 = this.f51183i;
        int i8 = (65536 * i6) + i7;
        int i9 = i6 % 256 == 255 ? 6 : 5;
        if (i6 / 256 == 255) {
            i9++;
        }
        if (i7 % 256 == 255) {
            i9++;
        }
        if (i7 / 256 == 255) {
            i9++;
        }
        int[] iArr = new int[i9];
        iArr[0] = 31;
        int i10 = 24;
        int i11 = 1;
        while (i11 < i9) {
            int i12 = ((255 << i10) & i8) >>> i10;
            iArr[i11] = i12;
            if (i12 == 255) {
                i11++;
                iArr[i11] = 255;
            }
            i11++;
            i10 -= 8;
        }
        return iArr;
    }

    public n(int i6, int i7) {
        super(31, false, false, false, false);
        this.f51182h = i6;
        this.f51183i = i7;
    }
}
