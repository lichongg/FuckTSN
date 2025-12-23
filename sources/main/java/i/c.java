package i;

import android.util.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements b {
    @Override // i.b
    public int e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // i.b
    public int w(String str, String str2) {
        return Log.w(str, str2);
    }

    @Override // i.b
    public int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    @Override // i.b
    public int w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    @Override // i.b
    public int a(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    @Override // i.b
    public int b(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    @Override // i.b
    public int c(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    @Override // i.b
    public int d(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // i.b
    public int i(String str, String str2) {
        return Log.i(str, str2);
    }

    @Override // i.b
    public int v(String str, String str2) {
        return Log.v(str, str2);
    }
}
