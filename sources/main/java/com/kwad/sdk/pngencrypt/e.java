package com.kwad.sdk.pngencrypt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    final k aUF;
    private int aUH;
    private int aUI;
    int aUJ;
    int aUK;
    int aUL;
    int aUM;
    int aUN;
    int aUO;
    private int aUG = 0;
    private int aUP = -1;
    private int aUQ = -1;
    private int aUR = 0;
    private boolean aUT = false;
    int aUS = 0;

    private static byte[] ei(int i6) {
        switch (i6) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i6);
        }
    }

    private void eg(int i6) {
        this.aUP = i6;
        int i7 = (i6 * this.aUJ) + this.aUL;
        this.aUQ = i7;
        if (i7 < 0 || i7 >= this.aUF.aUH) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void eh(int i6) {
        if (this.aUG == i6) {
            return;
        }
        this.aUG = i6;
        byte[] ei = ei(i6);
        byte b6 = ei[0];
        this.aUK = b6;
        byte b7 = ei[1];
        this.aUJ = b7;
        byte b8 = ei[2];
        this.aUM = b8;
        byte b9 = ei[3];
        this.aUL = b9;
        k kVar = this.aUF;
        int i7 = kVar.aUH;
        this.aUH = i7 > b9 ? (((i7 + b7) - 1) - b9) / b7 : 0;
        int i8 = kVar.aUI;
        int i9 = i8 > b8 ? (((i8 + b6) - 1) - b8) / b6 : 0;
        this.aUI = i9;
        if (i9 == 0) {
            this.aUH = 0;
        }
        int i10 = kVar.aVb;
        this.aUO = b6 * i10;
        this.aUN = b8 * i10;
    }

    final boolean Oh() {
        int i6;
        while (true) {
            this.aUR++;
            int i7 = this.aUH;
            if (i7 != 0 && (i6 = this.aUP) < i7 - 1) {
                eg(i6 + 1);
                break;
            }
            int i8 = this.aUG;
            if (i8 != 7) {
                eh(i8 + 1);
                if (this.aUH != 0) {
                    eg(0);
                    break;
                }
                this.aUR--;
            } else {
                this.aUT = true;
                return false;
            }
        }
        return true;
    }

    final int Oi() {
        return this.aUP;
    }

    final int Oj() {
        return this.aUQ;
    }

    final int Ok() {
        return this.aUG;
    }

    final int Ol() {
        return this.aUH;
    }

    final int Om() {
        return this.aUI;
    }

    public final int Oo() {
        return ((this.aUF.aVg * On()) + 7) / 8;
    }

    public e(k kVar) {
        this.aUF = kVar;
        eh(1);
        eg(0);
    }

    private int On() {
        return Om();
    }
}
