package pl.droidsonroids.relinker;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, pl.droidsonroids.relinker.d dVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        String a(String str);

        String[] b();

        void c(String str);

        String d(String str);

        void loadLibrary(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: pl.droidsonroids.relinker.c$c, reason: collision with other inner class name */
    public interface InterfaceC1001c {
        void a(Throwable th);

        void success();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void log(String str);
    }

    public static void b(Context context, String str) {
        d(context, str, null, null);
    }

    public static void c(Context context, String str, String str2) {
        d(context, str, str2, null);
    }

    public static void e(Context context, String str, InterfaceC1001c interfaceC1001c) {
        d(context, str, null, interfaceC1001c);
    }

    public static pl.droidsonroids.relinker.d a() {
        return new pl.droidsonroids.relinker.d().c();
    }

    public static void d(Context context, String str, String str2, InterfaceC1001c interfaceC1001c) {
        new pl.droidsonroids.relinker.d().h(context, str, str2, interfaceC1001c);
    }

    public static pl.droidsonroids.relinker.d f(d dVar) {
        return new pl.droidsonroids.relinker.d().k(dVar);
    }

    public static pl.droidsonroids.relinker.d g() {
        return new pl.droidsonroids.relinker.d().n();
    }

    private c() {
    }
}
