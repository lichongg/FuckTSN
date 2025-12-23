package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\Downloads\app\classes8.dex */
final class f1 implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f50289a;

    f1(String str) {
        this.f50289a = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f50289a);
    }
}
