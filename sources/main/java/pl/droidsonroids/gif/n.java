package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51856a = "pl_droidsonroids_gif";

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f51857b;

    static void b() {
        try {
            System.loadLibrary(f51856a);
        } catch (UnsatisfiedLinkError unused) {
            pl.droidsonroids.relinker.c.b(getContext(), f51856a);
        }
    }

    private static Context getContext() {
        if (f51857b == null) {
            try {
                f51857b = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
            } catch (Exception e6) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e6);
            }
        }
        return f51857b;
    }

    private n() {
    }

    public static void a(@NonNull Context context) {
        f51857b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
