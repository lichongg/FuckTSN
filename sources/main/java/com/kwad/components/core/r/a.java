package com.kwad.components.core.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static volatile a XX;
    private int Uc;
    private int XY;
    private boolean XZ;
    private boolean Ya;
    private int Yb;
    private boolean Yc;

    public final void aN(boolean z5) {
        this.XZ = true;
    }

    public final void clear() {
        this.Ya = false;
        this.XZ = false;
        this.Yb = 0;
        this.Yc = false;
        this.XY = -1;
        this.Uc = 0;
    }

    public static a sF() {
        if (XX == null) {
            synchronized (a.class) {
                try {
                    if (XX == null) {
                        XX = new a();
                    }
                } finally {
                }
            }
        }
        return XX;
    }

    public final void aO(boolean z5) {
        this.Ya = z5;
    }

    public final void aP(boolean z5) {
        this.Yc = z5;
    }

    public final void aW(int i6) {
        this.XY = i6;
    }

    public final void aX(int i6) {
        this.Yb = i6;
    }

    public final void aY(int i6) {
        this.Uc = i6;
    }

    public final int sG() {
        return this.XY;
    }

    public final boolean sH() {
        return this.XZ;
    }

    public final boolean sI() {
        return this.Ya;
    }

    public final boolean sJ() {
        int i6 = this.Yb;
        return i6 == 1 || i6 == 3;
    }

    public final int sK() {
        return this.Yb;
    }

    public final boolean sL() {
        return this.Yc;
    }

    public final int sM() {
        return this.Uc;
    }

    private a() {
    }
}
