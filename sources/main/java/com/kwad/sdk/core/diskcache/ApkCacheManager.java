package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ApkCacheManager {
    private final Callable<Void> aCA;
    private File aCy;
    private final ExecutorService aCz;
    private Future aqB;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager(0);

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    /* synthetic */ ApkCacheManager(byte b6) {
        this();
    }

    private ApkCacheManager() {
        this.aCz = GlobalThreadPools.Jy();
        this.aCA = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: GF, reason: merged with bridge method [inline-methods] */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    try {
                        if (ApkCacheManager.this.aCy != null && ApkCacheManager.this.aCy.exists() && !ApkCacheManager.this.GD()) {
                            ApkCacheManager apkCacheManager = ApkCacheManager.this;
                            for (File file : apkCacheManager.n(apkCacheManager.aCy)) {
                                if (file.getName().endsWith(".apk")) {
                                    ApkCacheManager.this.h(file);
                                    if (ApkCacheManager.this.GD()) {
                                        return null;
                                    }
                                }
                            }
                            return null;
                        }
                        return null;
                    } finally {
                    }
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.aCy = be.dF(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GD() {
        File file = this.aCy;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.aCy.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && l(this.aCy) <= 400;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            for (File file2 : file.listFiles()) {
                h(file2);
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        z(arrayList);
        return arrayList;
    }

    private void z(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
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

    public final void GE() {
        File file = this.aCy;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.aqB;
        if (future == null || future.isDone()) {
            this.aqB = this.aCz.submit(this.aCA);
        }
    }

    private int l(File file) {
        return (int) ((m(file) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j6 = 0;
        if (listFiles != null) {
            int length2 = listFiles.length;
            for (int i6 = 0; i6 < length2; i6++) {
                if (listFiles[i6].isDirectory()) {
                    length = m(listFiles[i6]);
                } else {
                    length = listFiles[i6].length();
                }
                j6 += length;
            }
        }
        return j6;
    }
}
