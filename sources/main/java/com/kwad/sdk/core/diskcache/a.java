package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static PackageInfo a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getPath(), 65);
                    if (y.getPackageInfo(context, packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e6) {
                c.printStackTrace(e6);
            }
        }
        return null;
    }

    public static void bu(final Context context) {
        h.schedule(new bg() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                File dF;
                d AC;
                synchronized (a.class) {
                    try {
                        dF = be.dF(context);
                    } catch (Throwable th) {
                        c.printStackTrace(th);
                    }
                    if (dF.exists()) {
                        for (File file : a.n(dF)) {
                            if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.Em().di(file.getAbsolutePath()) != null && a.a(context, file) != null && (AC = com.kwad.sdk.c.AA().AC()) != null) {
                                AC.g(file);
                            }
                        }
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        z(arrayList);
        return arrayList;
    }

    private static void z(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }

            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    if (file.lastModified() == file2.lastModified()) {
                        return 0;
                    }
                    return 1;
                }
                return -1;
            }
        });
    }
}
