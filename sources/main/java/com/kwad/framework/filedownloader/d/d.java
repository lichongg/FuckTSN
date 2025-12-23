package com.kwad.framework.filedownloader.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static boolean u(int i6, int i7) {
        if ((i6 != 3 && i6 != 5 && i6 == i7) || bY(i6)) {
            return false;
        }
        if (i6 > 0 && i6 <= 6 && i7 >= 10 && i7 <= 11) {
            return false;
        }
        if (i6 == 1) {
            return i7 != 0;
        }
        if (i6 == 2) {
            return (i7 == 0 || i7 == 1 || i7 == 6) ? false : true;
        }
        if (i6 == 3) {
            return (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 6) ? false : true;
        }
        if (i6 == 5) {
            return (i7 == 1 || i7 == 6) ? false : true;
        }
        if (i6 != 6) {
            return true;
        }
        return (i7 == 0 || i7 == 1) ? false : true;
    }

    public static boolean v(int i6, int i7) {
        if ((i6 != 3 && i6 != 5 && i6 == i7) || bY(i6)) {
            return false;
        }
        if (i7 == -2 || i7 == -1) {
            return true;
        }
        if (i6 == 0) {
            return i7 == 10;
        }
        if (i6 == 1) {
            return i7 == 6;
        }
        if (i6 == 2 || i6 == 3) {
            return i7 == -3 || i7 == 3 || i7 == 5;
        }
        if (i6 == 5 || i6 == 6) {
            return i7 == 2 || i7 == 5;
        }
        if (i6 == 10) {
            return i7 == 11;
        }
        if (i6 != 11) {
            return false;
        }
        return i7 == -4 || i7 == -3 || i7 == 1;
    }

    public static boolean bY(int i6) {
        return i6 < 0;
    }

    public static boolean bZ(int i6) {
        return i6 > 0;
    }

    public static boolean f(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.wJ() != 0 && aVar.wJ() != 3) {
            return false;
        }
        return true;
    }
}
