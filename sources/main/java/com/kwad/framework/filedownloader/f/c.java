package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context apC;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        int V(long j6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        com.kwad.framework.filedownloader.a.b bo(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    public interface InterfaceC0659c {
        com.kwad.framework.filedownloader.b.a zA();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        int f(String str, String str2, boolean z5);

        int g(String str, String str2, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i6, String str, boolean z5, boolean z6) {
        if (!z5 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.yT().s(com.kwad.framework.filedownloader.message.f.a(i6, file, z6));
                return true;
            }
        }
        return false;
    }

    public static void aI(Context context) {
        apC = context;
    }

    public static Context zz() {
        return apC;
    }

    public static boolean a(int i6, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z5) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.yT().s(com.kwad.framework.filedownloader.message.f.a(i6, cVar.yZ(), cVar.getTotal(), z5));
        return true;
    }

    public static boolean a(int i6, long j6, String str, String str2, y yVar) {
        int o5;
        if (str2 == null || str == null || (o5 = yVar.o(str, i6)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.yT().s(com.kwad.framework.filedownloader.message.f.a(i6, j6, new PathConflictException(o5, str, str2)));
        return true;
    }
}
