package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n1563#2:150\n1634#2,3:151\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n134#1:150\n134#1:151,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class j {
    @NotNull
    public static final File a(@NotNull File file) {
        g0.p(file, "<this>");
        return new File(c(file));
    }

    private static final int b(String str) {
        int G3;
        char c6 = File.separatorChar;
        int G32 = kotlin.text.u.G3(str, c6, 0, false, 4, null);
        if (G32 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c6 || (G3 = kotlin.text.u.G3(str, c6, 2, false, 4, null)) < 0) {
                return 1;
            }
            int G33 = kotlin.text.u.G3(str, c6, G3 + 1, false, 4, null);
            return G33 >= 0 ? G33 + 1 : str.length();
        }
        if (G32 > 0 && str.charAt(G32 - 1) == ':') {
            return G32 + 1;
        }
        if (G32 == -1 && kotlin.text.u.q3(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    @NotNull
    public static final String c(@NotNull File file) {
        g0.p(file, "<this>");
        String path = file.getPath();
        g0.o(path, "getPath(...)");
        String path2 = file.getPath();
        g0.o(path2, "getPath(...)");
        String substring = path.substring(0, b(path2));
        g0.o(substring, "substring(...)");
        return substring;
    }

    public static final boolean d(@NotNull File file) {
        g0.p(file, "<this>");
        String path = file.getPath();
        g0.o(path, "getPath(...)");
        return b(path) > 0;
    }

    @NotNull
    public static final File e(@NotNull File file, int i6, int i7) {
        g0.p(file, "<this>");
        return f(file).j(i6, i7);
    }

    @NotNull
    public static final g f(@NotNull File file) {
        List list;
        g0.p(file, "<this>");
        String path = file.getPath();
        g0.m(path);
        int b6 = b(path);
        String substring = path.substring(0, b6);
        g0.o(substring, "substring(...)");
        String substring2 = path.substring(b6);
        g0.o(substring2, "substring(...)");
        if (substring2.length() == 0) {
            list = f0.J();
        } else {
            List l52 = kotlin.text.u.l5(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(f0.d0(l52, 10));
            Iterator it = l52.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new g(new File(substring), list);
    }
}
