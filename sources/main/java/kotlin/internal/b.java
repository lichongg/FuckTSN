package kotlin.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a f43804a = new kotlin.internal.jdk8.d();

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean a(int i6, int i7, int i8) {
        return p.f44126g.i(i6, i7, i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final /* synthetic */ <T> T b(Object obj) {
        try {
            g0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e6) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (g0.g(classLoader, classLoader2)) {
                throw e6;
            }
            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e6);
        }
    }
}
