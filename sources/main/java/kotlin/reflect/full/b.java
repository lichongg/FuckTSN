package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KAnnotatedElements")
@SourceDebugExtension({"SMAP\nKAnnotatedElements.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/KAnnotatedElements\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n20#1:105\n295#2,2:103\n295#2,2:106\n295#2,2:108\n*S KotlinDebug\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/KAnnotatedElements\n*L\n29#1:105\n20#1:103,2\n29#1:106,2\n62#1:108,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @SinceKotlin(version = "1.1")
    public static final /* synthetic */ <T extends Annotation> T a(kotlin.reflect.b bVar) {
        Object obj;
        g0.p(bVar, "<this>");
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            g0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (androidx.activity.k.a((Annotation) obj)) {
                break;
            }
        }
        g0.y(1, "T?");
        return (T) obj;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> List<T> b(kotlin.reflect.b bVar) {
        g0.p(bVar, "<this>");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return c(bVar, o0.d(Annotation.class));
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Annotation> List<T> c(@NotNull kotlin.reflect.b bVar, @NotNull kotlin.reflect.d<T> klass) {
        Object obj;
        g0.p(bVar, "<this>");
        g0.p(klass, "klass");
        List<T> h12 = f0.h1(bVar.getAnnotations(), l3.a.e(klass));
        if (!h12.isEmpty()) {
            return h12;
        }
        Class<? extends Annotation> b6 = a.f44214a.b(l3.a.e(klass));
        if (b6 != null) {
            Iterator<T> it = bVar.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (g0.g(l3.a.e(l3.a.a((Annotation) obj)), b6)) {
                    break;
                }
            }
            Annotation annotation = (Annotation) obj;
            if (annotation != null) {
                Object invoke = annotation.getClass().getMethod("value", null).invoke(annotation, null);
                g0.n(invoke, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
                return n.t((Annotation[]) invoke);
            }
        }
        return f0.J();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> boolean d(kotlin.reflect.b bVar) {
        Object obj;
        g0.p(bVar, "<this>");
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            g0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (androidx.activity.k.a((Annotation) obj)) {
                break;
            }
        }
        g0.y(1, "T?");
        return ((Annotation) obj) != null;
    }
}
