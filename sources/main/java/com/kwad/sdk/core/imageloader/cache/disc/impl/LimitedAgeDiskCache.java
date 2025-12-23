package com.kwad.sdk.core.imageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DefaultConfigurationFactory;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LimitedAgeDiskCache extends BaseDiskCache {
    private final Map<File, Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiskCache(File file, long j6) {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), j6);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        boolean save = super.save(str, inputStream, copyListener);
        rememberUsage(str);
        return save;
    }

    public LimitedAgeDiskCache(File file, File file2, long j6) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator(), j6);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        this.loadingDates.remove(getFile(str));
        return super.remove(str);
    }

    public LimitedAgeDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j6) {
        super(file, file2, fileNameGenerator);
        this.loadingDates = Collections.synchronizedMap(new HashMap());
        this.maxFileAge = j6 * 1000;
    }

    private void rememberUsage(String str) {
        File file = getFile(str);
        long currentTimeMillis = System.currentTimeMillis();
        file.setLastModified(currentTimeMillis);
        this.loadingDates.put(file, Long.valueOf(currentTimeMillis));
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        super.clear();
        this.loadingDates.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        boolean z5;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l6 = this.loadingDates.get(file);
            if (l6 == null) {
                l6 = Long.valueOf(file.lastModified());
                z5 = false;
            } else {
                z5 = true;
            }
            if (System.currentTimeMillis() - l6.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
                return file;
            }
            if (!z5) {
                this.loadingDates.put(file, l6);
            }
        }
        return file;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        boolean save = super.save(str, bitmap);
        rememberUsage(str);
        return save;
    }
}
