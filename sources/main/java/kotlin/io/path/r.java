package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.1")
@WasExperimental(markerClass = {ExperimentalPathApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public interface r {
    void a(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);

    void b(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void c(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void d(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);
}
