package xyz.adscope.common.v2.cache;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.common.v2.cache.IResourceLruCache;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.conn.http.CommonRequestBuilder;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.persistent.file.FileUtils;
import xyz.adscope.common.v2.thread.pool.CommonThreadPool;
import xyz.adscope.common.v2.tool.date.DateUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseLruCache implements IResourceLruCache {
    private final String TASK_HOLDER_KEY_FORMAT = "%s_%s";
    private final long M2BYTE = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    private final long mMaxCacheSizeByte = maxCacheSizeM() * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    private final Map<String, ResourceCacheTask> cacheTaskHolder = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class ResourceCacheTask implements Runnable {
        private final File mCacheFile;
        private IResourceLruCache.IResourceCacheCallback mCallback;
        private final String mTaskKey;
        private final String mURL;

        abstract void onCacheFinished(String str, File file);

        private ResourceCacheTask(String str, File file, String str2) {
            this.mURL = str;
            this.mCacheFile = file;
            this.mTaskKey = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void injectCacheCallback(IResourceLruCache.IResourceCacheCallback iResourceCacheCallback) {
            this.mCallback = iResourceCacheCallback;
        }

        void callbackCacheDone(File file) {
            IResourceLruCache.IResourceCacheCallback iResourceCacheCallback = this.mCallback;
            if (iResourceCacheCallback != null) {
                iResourceCacheCallback.onCacheDone(file);
            }
        }

        void callbackCacheException() {
            IResourceLruCache.IResourceCacheCallback iResourceCacheCallback = this.mCallback;
            if (iResourceCacheCallback != null) {
                iResourceCacheCallback.onCacheException();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CommonRequestBuilder concern = new CommonRequestBuilder().autoRedirected(true).concern(new IBaseHttpResponseCallback() { // from class: xyz.adscope.common.v2.cache.IBaseLruCache.ResourceCacheTask.1
                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void failCallback(IHttpRequestError iHttpRequestError) {
                    ResourceCacheTask resourceCacheTask = ResourceCacheTask.this;
                    resourceCacheTask.onCacheFinished(resourceCacheTask.mTaskKey, null);
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                    ResourceCacheTask resourceCacheTask = ResourceCacheTask.this;
                    resourceCacheTask.onCacheFinished(resourceCacheTask.mTaskKey, ResourceCacheTask.this.mCacheFile);
                }
            });
            concern.download(this.mURL, this.mCacheFile);
            concern.performLocalIO().run();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ResourceDeleteTask implements Runnable {
        private final File[] mDeleteFiles;

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr = this.mDeleteFiles;
            if (fileArr != null) {
                for (File file : fileArr) {
                    file.delete();
                }
            }
        }

        ResourceDeleteTask(File[] fileArr) {
            this.mDeleteFiles = fileArr;
        }
    }

    protected abstract File getCacheDir(Context context, LruCacheModel lruCacheModel);

    protected abstract int maxCacheSizeM();

    private void clearOutOfMemoryResource(File file) {
        if (file == null || !file.exists() || !file.isDirectory() || FileUtils.getFolderSizeByte(file) <= this.mMaxCacheSizeByte) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Collections.addAll(arrayList, listFiles);
            Collections.sort(arrayList, new Comparator() { // from class: xyz.adscope.common.v2.cache.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return IBaseLruCache.a((File) obj, (File) obj2);
                }
            });
            int size = arrayList.size() / 2;
            if (size > 0) {
                File[] fileArr = new File[size];
                for (int i6 = 0; i6 < size; i6++) {
                    fileArr[i6] = (File) arrayList.get(i6);
                }
                CommonThreadPool.getInstance().executeResourceCacheTask(new ResourceDeleteTask(fileArr));
            }
        }
    }

    private ResourceCacheTask getCacheTask(String str, LruCacheModel lruCacheModel) {
        if (this.cacheTaskHolder == null) {
            return null;
        }
        return this.cacheTaskHolder.get(getCacheTaskKey(str, lruCacheModel));
    }

    private boolean isCaching(String str, LruCacheModel lruCacheModel) {
        Map<String, ResourceCacheTask> map = this.cacheTaskHolder;
        if (map != null) {
            return map.containsKey(getCacheTaskKey(str, lruCacheModel));
        }
        return false;
    }

    @Override // xyz.adscope.common.v2.cache.IResourceLruCache
    public void releaseCacheDirMemory(Context context) {
        File cacheDir = getCacheDir(context, LruCacheModel.TEMPORARY);
        if (cacheDir != null) {
            clearExpireResource(cacheDir, 7);
            clearOutOfMemoryResource(cacheDir);
        }
    }

    IBaseLruCache() {
    }

    public static /* synthetic */ int a(File file, File file2) {
        if (file.lastModified() < file2.lastModified()) {
            return 1;
        }
        return -1;
    }

    private void clearExpireResource(File file, int i6) {
        CommonThreadPool.getInstance().executeResourceCacheTask(new ResourceDeleteTask(FileUtils.filterFileByExpire(file, DateUtil.getTimeMillisBeforeDay(i6))));
    }

    private String getCacheFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String fileSuffixFromURL = StringUtil.getFileSuffixFromURL(str);
            if (!TextUtils.isEmpty(fileSuffixFromURL)) {
                return MD5Util.md5(str) + "." + fileSuffixFromURL;
            }
            return "";
        }
        return "";
    }

    private String getCacheTaskKey(String str, LruCacheModel lruCacheModel) {
        return String.format("%s_%s", getCacheFileName(str), lruCacheModel.name());
    }

    private boolean hasCache(Context context, String str, LruCacheModel lruCacheModel) {
        File cacheDir = getCacheDir(context, lruCacheModel);
        if (cacheDir != null && cacheDir.exists()) {
            return FileUtils.hasFile(cacheDir, getCacheFileName(str));
        }
        return false;
    }

    @Override // xyz.adscope.common.v2.cache.IResourceLruCache
    public void cacheResource(Context context, String str, LruCacheModel lruCacheModel) {
        if (!TextUtils.isEmpty(str) && !hasCache(context, str, lruCacheModel) && !isCaching(str, lruCacheModel)) {
            String cacheFileName = getCacheFileName(str);
            File cacheDir = getCacheDir(context, lruCacheModel);
            if (cacheDir != null) {
                String cacheTaskKey = getCacheTaskKey(str, lruCacheModel);
                ResourceCacheTask resourceCacheTask = new ResourceCacheTask(str, new File(cacheDir, cacheFileName), cacheTaskKey) { // from class: xyz.adscope.common.v2.cache.IBaseLruCache.1
                    @Override // xyz.adscope.common.v2.cache.IBaseLruCache.ResourceCacheTask
                    void onCacheFinished(String str2, File file) {
                        IBaseLruCache.this.cacheTaskHolder.remove(str2);
                        if (file == null || !file.exists()) {
                            callbackCacheException();
                        } else {
                            callbackCacheDone(file);
                        }
                    }
                };
                this.cacheTaskHolder.put(cacheTaskKey, resourceCacheTask);
                CommonThreadPool.getInstance().executeResourceCacheTask(resourceCacheTask);
            }
        }
    }

    @Override // xyz.adscope.common.v2.cache.IResourceLruCache
    public void getCacheResource(Context context, String str, LruCacheModel lruCacheModel, IResourceLruCache.IResourceCacheCallback iResourceCacheCallback) {
        if (isCaching(str, lruCacheModel)) {
            ResourceCacheTask cacheTask = getCacheTask(str, lruCacheModel);
            if (cacheTask != null) {
                cacheTask.injectCacheCallback(iResourceCacheCallback);
                return;
            }
            return;
        }
        File cacheDir = getCacheDir(context, lruCacheModel);
        if (cacheDir != null) {
            File file = new File(cacheDir, getCacheFileName(str));
            if (file.exists()) {
                if (iResourceCacheCallback != null) {
                    iResourceCacheCallback.onCacheDone(file);
                }
            } else {
                cacheResource(context, str, lruCacheModel);
                getCacheResource(context, str, lruCacheModel, iResourceCacheCallback);
            }
        }
    }
}
