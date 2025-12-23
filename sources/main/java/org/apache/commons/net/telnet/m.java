package org.apache.commons.net.telnet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m extends k {

    /* renamed from: i, reason: collision with root package name */
    protected static final int f51177i = 24;

    /* renamed from: j, reason: collision with root package name */
    protected static final int f51178j = 1;

    /* renamed from: k, reason: collision with root package name */
    protected static final int f51179k = 0;

    /* renamed from: h, reason: collision with root package name */
    private final String f51180h;

    public m(String str, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(24, z5, z6, z7, z8);
        this.f51180h = str;
    }

    @Override // org.apache.commons.net.telnet.k
    public int[] a(int[] iArr, int i6) {
        String str;
        if (iArr == null || i6 <= 1 || (str = this.f51180h) == null) {
            return null;
        }
        if (iArr[0] != 24 || iArr[1] != 1) {
            return null;
        }
        int[] iArr2 = new int[str.length() + 2];
        iArr2[0] = 24;
        iArr2[1] = 0;
        for (int i7 = 0; i7 < this.f51180h.length(); i7++) {
            iArr2[i7 + 2] = this.f51180h.charAt(i7);
        }
        return iArr2;
    }

    public m(String str) {
        super(24, false, false, false, false);
        this.f51180h = str;
    }
}
