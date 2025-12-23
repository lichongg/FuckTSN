package xyz.adscope.common.v2.cache2;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache2.IBaseLruCache2;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.persistent.file.FileUtils;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.date.DateUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseLruCache2 implements IResourceLruCache2 {
    private final long M2BYTE = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    protected final Object lock = new Object();
    private final long mMaxCacheSizeByte = maxCacheSizeM() * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    private final Map<String, ResourceCacheTask<?>> cacheTaskHolder = new HashMap();
    private final Map<String, List<IResourceCacheCallback>> callbackHolder = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.cache2.IBaseLruCache2$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CacheResDelTask implements Runnable {
        private final File mCacheDir;
        private final int mExpireDays;
        private final long mMaxCacheSizeByte;

        /* synthetic */ CacheResDelTask(File file, long j6, AnonymousClass1 anonymousClass1) {
            this(file, j6);
        }

        private void deleteExpire() {
            File[] filterFileByExpire = FileUtils.filterFileByExpire(this.mCacheDir, DateUtil.getTimeMillisBeforeDay(7));
            if (filterFileByExpire == null || filterFileByExpire.length <= 0) {
                return;
            }
            deleteFiles(filterFileByExpire);
        }

        private CacheResDelTask(File file, long j6) {
            this.mExpireDays = 7;
            this.mCacheDir = file;
            this.mMaxCacheSizeByte = j6;
        }

        private void deleteFiles(File[] fileArr) {
            if (fileArr != null) {
                for (File file : fileArr) {
                    file.delete();
                }
            }
        }

        private void deleteOverMemory() {
            if (FileUtils.getFolderSizeByte(this.mCacheDir) > this.mMaxCacheSizeByte) {
                ArrayList arrayList = new ArrayList();
                File[] listFiles = this.mCacheDir.listFiles();
                if (listFiles != null) {
                    Collections.addAll(arrayList, listFiles);
                    Collections.sort(arrayList, new Comparator() { // from class: xyz.adscope.common.v2.cache2.a
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return IBaseLruCache2.CacheResDelTask.a((File) obj, (File) obj2);
                        }
                    });
                    int size = arrayList.size() / 2;
                    if (size > 0) {
                        File[] fileArr = new File[size];
                        for (int i6 = 0; i6 < size; i6++) {
                            fileArr[i6] = (File) arrayList.get(i6);
                        }
                        deleteFiles(fileArr);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = this.mCacheDir;
            if (file != null && file.exists() && this.mCacheDir.isDirectory()) {
                deleteExpire();
                deleteOverMemory();
            }
        }

        public static /* synthetic */ int a(File file, File file2) {
            if (file.lastModified() < file2.lastModified()) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected interface LruCacheHttpRespCallback<T> {
        void onCacheException(String str);

        void onCacheReady(String str, T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static abstract class ResourceCacheTask<T> implements Runnable {
        protected final File mCacheFile;
        protected LruCacheHttpRespCallback<T> mHttpRespCallback;
        protected final String mTaskKey;
        protected final String mURL;

        protected void setHttpResponseCallback(LruCacheHttpRespCallback<T> lruCacheHttpRespCallback) {
            this.mHttpRespCallback = lruCacheHttpRespCallback;
        }

        protected ResourceCacheTask(String str, File file, String str2) {
            this.mURL = str;
            this.mCacheFile = file;
            this.mTaskKey = str2;
        }
    }

    protected abstract File getCacheDir(Context context, LruCacheModel lruCacheModel);

    protected abstract ResourceCacheTask<?> getResourceCacheTask(String str, File file, String str2);

    protected abstract int maxCacheSizeM();

    private void clearResource(Context context, File file) {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(StubApp.getOrigApplicationContext(context.getApplicationContext())).executeResourceCacheTask(new CacheResDelTask(file, this.mMaxCacheSizeByte, null));
    }

    private boolean isCaching(String str) {
        boolean containsKey;
        synchronized (this.cacheTaskHolder) {
            containsKey = this.cacheTaskHolder.containsKey(getCacheTaskKey(str));
        }
        return containsKey;
    }

    private void putCacheTask(String str, ResourceCacheTask<?> resourceCacheTask) {
        synchronized (this.cacheTaskHolder) {
            this.cacheTaskHolder.put(str, resourceCacheTask);
        }
    }

    private void saveResCallback(String str, IResourceCacheCallback iResourceCacheCallback) {
        synchronized (this.callbackHolder) {
            try {
                List<IResourceCacheCallback> list = this.callbackHolder.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(iResourceCacheCallback);
                this.callbackHolder.put(str, list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void callbackResource(String str, File file) {
        ArrayList<IResourceCacheCallback> arrayList;
        synchronized (this.callbackHolder) {
            try {
                List<IResourceCacheCallback> list = this.callbackHolder.get(str);
                if (list != null) {
                    arrayList = new ArrayList(list);
                    list.clear();
                } else {
                    arrayList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            for (IResourceCacheCallback iResourceCacheCallback : arrayList) {
                if (iResourceCacheCallback != null) {
                    if (file == null || !file.exists()) {
                        iResourceCacheCallback.onCacheException(str);
                    } else {
                        iResourceCacheCallback.onCacheFile(str, file);
                    }
                }
            }
        }
    }

    protected void callbackResourceInputStream(String str, InputStream inputStream, File file) {
        ArrayList<IResourceCacheCallback> arrayList;
        synchronized (this.callbackHolder) {
            try {
                List<IResourceCacheCallback> list = this.callbackHolder.get(str);
                if (list != null) {
                    arrayList = new ArrayList(list);
                    list.clear();
                } else {
                    arrayList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            for (IResourceCacheCallback iResourceCacheCallback : arrayList) {
                if (iResourceCacheCallback != null) {
                    if (inputStream != null) {
                        iResourceCacheCallback.onCacheInputStream(str, inputStream, file);
                    } else {
                        iResourceCacheCallback.onCacheException(str);
                    }
                }
            }
        }
    }

    @Override // xyz.adscope.common.v2.cache2.IResourceLruCache2
    public void releaseCacheDirMemory(Context context) {
        File cacheDir = getCacheDir(context, LruCacheModel.TEMPORARY);
        if (cacheDir != null) {
            clearResource(context, cacheDir);
        }
    }

    protected void removeCacheTask(String str) {
        synchronized (this.cacheTaskHolder) {
            this.cacheTaskHolder.remove(str);
        }
    }

    IBaseLruCache2() {
    }

    private boolean hasCache(Context context, String str, LruCacheModel lruCacheModel) {
        File cacheDir = getCacheDir(context, lruCacheModel);
        if (cacheDir != null && cacheDir.exists()) {
            return FileUtils.hasFile(cacheDir, getCacheFileName(str));
        }
        return false;
    }

    @Override // xyz.adscope.common.v2.cache2.IResourceLruCache2
    public void cacheResource(Context context, String str, LruCacheModel lruCacheModel) {
        if (!TextUtils.isEmpty(str) && !hasCache(context, str, lruCacheModel) && !isCaching(str)) {
            String cacheFileName = getCacheFileName(str);
            File cacheDir = getCacheDir(context, lruCacheModel);
            if (cacheDir != null) {
                String cacheTaskKey = getCacheTaskKey(str);
                ResourceCacheTask<?> resourceCacheTask = getResourceCacheTask(str, new File(cacheDir, cacheFileName), cacheTaskKey);
                putCacheTask(cacheTaskKey, resourceCacheTask);
                ScopeThreadPoolManager.getInstance().getOrCreateImplement(StubApp.getOrigApplicationContext(context.getApplicationContext())).executeResourceCacheTask(resourceCacheTask);
            }
        }
    }

    protected String getCacheFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String fileSuffixFromURL = StringUtil.getFileSuffixFromURL(str);
            if (!TextUtils.isEmpty(fileSuffixFromURL)) {
                return MD5Util.md5(str) + "." + fileSuffixFromURL;
            }
            return "";
        }
        return "";
    }

    @Override // xyz.adscope.common.v2.cache2.IResourceLruCache2
    public void getCacheResource(Context context, String str, LruCacheModel lruCacheModel, IResourceCacheCallback iResourceCacheCallback) {
        String cacheTaskKey = getCacheTaskKey(str);
        synchronized (this.lock) {
            try {
                if (isCaching(str)) {
                    saveResCallback(cacheTaskKey, iResourceCacheCallback);
                } else {
                    File cacheDir = getCacheDir(context, lruCacheModel);
                    if (cacheDir != null) {
                        File file = new File(cacheDir, getCacheFileName(str));
                        if (file.exists()) {
                            if (iResourceCacheCallback != null) {
                                iResourceCacheCallback.onCacheFile(cacheTaskKey, file);
                            }
                        } else {
                            saveResCallback(cacheTaskKey, iResourceCacheCallback);
                            cacheResource(context, str, lruCacheModel);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected String getCacheTaskKey(String str) {
        return MD5Util.md5(str);
    }
}
