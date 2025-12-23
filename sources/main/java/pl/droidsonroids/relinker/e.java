package pl.droidsonroids.relinker;

import android.os.Build;
import pl.droidsonroids.relinker.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class e implements c.b {
    @Override // pl.droidsonroids.relinker.c.b
    public String[] b() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // pl.droidsonroids.relinker.c.b
    public String d(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    e() {
    }

    @Override // pl.droidsonroids.relinker.c.b
    public String a(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // pl.droidsonroids.relinker.c.b
    public void c(String str) {
        System.load(str);
    }

    @Override // pl.droidsonroids.relinker.c.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
