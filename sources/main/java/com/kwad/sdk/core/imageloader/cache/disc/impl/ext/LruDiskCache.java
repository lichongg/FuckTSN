package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected a cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j6) {
        this(file, null, fileNameGenerator, j6, 0);
    }

    private void initCache(File file, File file2, long j6, int i6) {
        LruDiskCache lruDiskCache;
        try {
            this.cache = a.a(file, 1, 1, j6, i6);
        } catch (IOException e6) {
            L.e(e6);
            if (file2 != null) {
                lruDiskCache = this;
                lruDiskCache.initCache(file2, null, j6, i6);
            } else {
                lruDiskCache = this;
            }
            if (lruDiskCache.cache == null) {
                throw e6;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th;
        a.c cVar;
        File file = null;
        try {
            cVar = this.cache.dD(getKey(str));
            if (cVar != null) {
                try {
                    try {
                        file = cVar.dv(0);
                    } catch (Throwable th2) {
                        th = th2;
                        b.closeQuietly(cVar);
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    L.e(e);
                    b.closeQuietly(cVar);
                    return null;
                }
            }
            b.closeQuietly(cVar);
            return file;
        } catch (IOException e7) {
            e = e7;
            cVar = null;
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            b.closeQuietly(cVar);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        a.C0678a dE = this.cache.dE(getKey(str));
        if (dE == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dE.ds(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                dE.commit();
                return copyStream;
            }
            dE.abort();
            return copyStream;
        } catch (Throwable th) {
            b.closeQuietly(bufferedOutputStream);
            dE.abort();
            throw th;
        }
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j6, int i6) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j7 = j6 == 0 ? Long.MAX_VALUE : j6;
        int i7 = i6 == 0 ? Integer.MAX_VALUE : i6;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
        initCache(file, file2, j7, i7);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e6) {
            L.e(e6);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.GJ());
        } catch (IOException e7) {
            L.e(e7);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e6) {
            L.e(e6);
            return false;
        }
    }

    public void setBufferSize(int i6) {
        this.bufferSize = i6;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i6) {
        this.compressQuality = i6;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        a.C0678a dE = this.cache.dE(getKey(str));
        if (dE == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dE.ds(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                dE.commit();
                return compress;
            }
            dE.abort();
            return compress;
        } finally {
            b.closeQuietly(bufferedOutputStream);
        }
    }
}
