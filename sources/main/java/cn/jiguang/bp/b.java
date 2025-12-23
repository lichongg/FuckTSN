package cn.jiguang.bp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    public enum a {
        LANDSCAPE,
        PORTRAIT
    }

    public static a a(int i6) {
        if (i6 == 1) {
            return a.PORTRAIT;
        }
        if (i6 != 2) {
            return null;
        }
        return a.LANDSCAPE;
    }
}
