package d2;

import android.annotation.SuppressLint;
import android.os.Build;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f42983b = "RootKeyUtil";

    /* renamed from: a, reason: collision with root package name */
    private byte[] f42984a = null;

    @SuppressLint({"NewApi"})
    private void b(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            g.e(f42983b, "initRootKey: sha1");
            this.f42984a = a.i(str, str2, str3, bArr, false);
        } else {
            g.e(f42983b, "initRootKey: sha256");
            this.f42984a = a.i(str, str2, str3, bArr, true);
        }
    }

    public static d e(String str, String str2, String str3, String str4) {
        d dVar = new d();
        dVar.a(str, str2, str3, str4);
        return dVar;
    }

    public static d f(String str, String str2, String str3, byte[] bArr) {
        d dVar = new d();
        dVar.b(str, str2, str3, bArr);
        return dVar;
    }

    public byte[] c() {
        return (byte[]) this.f42984a.clone();
    }

    public String d() {
        return c.b(this.f42984a);
    }

    private d() {
    }

    private void a(String str, String str2, String str3, String str4) {
        b(str, str2, str3, c.c(str4));
    }
}
