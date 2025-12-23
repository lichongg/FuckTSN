package com.kwad.sdk.resourceCache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.o.m;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static volatile SharedPreferences Fo;
    private static int aXR;
    private static int aXS;
    private static int aXT;
    public static WarmUpResponse.WarmupVideos warmupVideos = new WarmUpResponse.WarmupVideos();
    public static WarmUpResponse.WarmupImages warmupImages = new WarmUpResponse.WarmupImages();
    public static WarmUpResponse.WarmupZips warmupZips = new WarmUpResponse.WarmupZips();
    private static final Object mLock = new Object();
    private static ConcurrentHashMap<String, WarmUpResponse.ResourceItem> aXQ = new ConcurrentHashMap<>();
    private static boolean aXU = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
    }

    @AnyThread
    public static int a(List<WarmUpResponse.ResourceItem> list, boolean z5, int i6, a aVar) {
        if (list == null || aXU) {
            return -1;
        }
        Iterator<WarmUpResponse.ResourceItem> it = list.iterator();
        int i7 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WarmUpResponse.ResourceItem next = it.next();
            if (next != null) {
                String str = next.url;
                if (aXT < next.downloadSize) {
                    N(new File(m.Ta().getExternalCacheDir() + "/com.ksad.warmup/"));
                    aXU = true;
                    break;
                }
                if (!TextUtils.isEmpty(next.md5) && !TextUtils.isEmpty(str) && (i6 != 1 || (ao.isWifiConnected(ServiceProvider.getContext()) && z5))) {
                    File a6 = a(i6, next);
                    try {
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件开始 " + a6);
                        c.a(next, i6);
                        com.kwad.sdk.core.download.a.a(str, a6, null, false);
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件已下载 " + a6);
                    } catch (IOException e6) {
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件失败 ");
                        c.a(next, i6, 0, e6.getMessage());
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                    }
                    if (TextUtils.equals(al.getFileMD5Digest(a6), next.md5)) {
                        c.c(next, i6);
                        b(next);
                        i7++;
                    } else {
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "save: md5校验失败 " + a6);
                        c.b(next, i6);
                        gJ(a6.getAbsolutePath());
                    }
                }
            }
        }
        if (i6 == 3) {
            try {
                Iterator<WarmUpResponse.ResourceItem> it2 = warmupZips.zips.iterator();
                while (it2.hasNext()) {
                    WarmUpResponse.ResourceItem next2 = it2.next();
                    gK(next2.resourceKey);
                    gJ(next2.cachePath);
                }
            } catch (IOException e7) {
                com.kwad.sdk.core.d.c.printStackTrace(e7);
            }
        }
        return i7;
    }

    public static ArrayList<WarmUpResponse.ResourceItem> b(ArrayList<WarmUpResponse.ResourceItem> arrayList) {
        WarmUpResponse.ResourceItem resourceItem;
        ArrayList<WarmUpResponse.ResourceItem> arrayList2 = new ArrayList<>(arrayList);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (mLock) {
            try {
                Iterator<WarmUpResponse.ResourceItem> it = arrayList2.iterator();
                while (it.hasNext()) {
                    WarmUpResponse.ResourceItem next = it.next();
                    if (next != null && aXQ.containsKey(next.resourceKey) && (resourceItem = aXQ.get(next.resourceKey)) != null && resourceItem.isCached) {
                        long j6 = resourceItem.endTime;
                        if (j6 >= currentTimeMillis && j6 != 0) {
                            it.remove();
                        }
                        String str = resourceItem.cachePath;
                        if (str != null) {
                            if (resourceItem.isZip) {
                                M(new File(resourceItem.zipDir));
                            } else {
                                gJ(str);
                            }
                            aXQ.remove(next.resourceKey);
                        }
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList2, new Comparator<WarmUpResponse.ResourceItem>() { // from class: com.kwad.sdk.resourceCache.b.3
            private static int a(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return Integer.compare(resourceItem3.priority, resourceItem2.priority);
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return a(resourceItem2, resourceItem3);
            }
        });
        return arrayList2;
    }

    private static void M(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    M(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    public static void N(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    N(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    public static void cn(Context context) {
        Fo = context.getSharedPreferences("ksadsdk_warmup_resource", 0);
        initData();
        new l<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.1
            @NonNull
            private static com.kwad.sdk.resourceCache.a Pj() {
                return new com.kwad.sdk.resourceCache.a();
            }

            @NonNull
            private static WarmUpResponse gL(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WarmUpResponse warmUpResponse = new WarmUpResponse();
                warmUpResponse.parseJson(jSONObject);
                return warmUpResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return Pj();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ WarmUpResponse parseData(String str) {
                return gL(str);
            }
        }.request(new o<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.2
            private void a(@NonNull final WarmUpResponse warmUpResponse) {
                try {
                    if (warmUpResponse.cleanResourceWarmup) {
                        b.Fo.edit().clear().apply();
                        b.aXQ.clear();
                        b.N(new File(m.Ta().getExternalCacheDir() + "/com.ksad.warmup/"));
                    }
                    int unused = b.aXR = warmUpResponse.minWarmupDiskSize;
                    int unused2 = b.aXS = (int) (b.m(new File(m.Ta().getExternalCacheDir() + "/com.ksad.warmup/")) / 1048576.0d);
                    int unused3 = b.aXT = b.aXR - b.aXS;
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "剩余空间: " + b.aXT + "MB本地空间: " + b.aXS + "MB可用空间: " + b.aXR + "MB");
                    b(warmUpResponse);
                    h.execute(new bg() { // from class: com.kwad.sdk.resourceCache.b.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            WarmUpResponse warmUpResponse2 = warmUpResponse;
                            if (!warmUpResponse2.disableZipWarmup) {
                                WarmUpResponse.WarmupZips warmupZips2 = warmUpResponse2.warmupZips;
                                b.warmupZips = warmupZips2;
                                b.a(b.b(warmupZips2.zips), true, 3, null);
                            }
                            WarmUpResponse warmUpResponse3 = warmUpResponse;
                            if (!warmUpResponse3.disableImageWarmup) {
                                WarmUpResponse.WarmupImages warmupImages2 = warmUpResponse3.warmupImages;
                                b.warmupImages = warmupImages2;
                                b.a(b.b(warmupImages2.images), true, 2, null);
                            }
                            WarmUpResponse warmUpResponse4 = warmUpResponse;
                            if (!warmUpResponse4.disableVideoWarmup) {
                                WarmUpResponse.WarmupVideos warmupVideos2 = warmUpResponse4.warmupVideos;
                                b.warmupVideos = warmupVideos2;
                                b.a(b.b(warmupVideos2.videos), !b.warmupVideos.wifiOnly, 1, null);
                            }
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "checklist: " + b.aXQ.size() + b.warmupZips.zips.size() + b.warmupImages.images.size() + b.warmupVideos.videos.size());
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            private static void b(WarmUpResponse warmUpResponse) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(warmUpResponse.warmupZips.zips);
                arrayList.addAll(warmUpResponse.warmupImages.images);
                arrayList.addAll(warmUpResponse.warmupVideos.videos);
                b.aXQ.values();
                c.a(arrayList, new ArrayList(b.aXQ.values()), b.aXT);
                arrayList.clear();
            }

            private static void gM(String str) {
                com.kwad.sdk.core.d.c.d("WarmUpManager", "onError: " + str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((WarmUpResponse) baseResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i6, String str) {
                gM(str);
            }
        });
    }

    private static void gJ(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file does not exist: " + str);
        } else if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file deleted: " + str);
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "Failed to delete cache file: " + str);
        }
    }

    private static void gK(String str) {
        if (!str.matches("[a-zA-Z0-9_-]+")) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "Invalid zipname: " + str);
            return;
        }
        String str2 = m.Ta().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str + ".zip";
        String str3 = m.Ta().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str;
        if (!new File(str2).exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "File does not exist: " + str2);
            return;
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str2));
            try {
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    if (nextEntry.getName().startsWith("__MACOSX/") || nextEntry.getName().startsWith("._")) {
                        break;
                    }
                    String str4 = str3 + File.separator + nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        new File(str4).mkdir();
                    } else {
                        a(zipInputStream, str4);
                    }
                    zipInputStream.closeEntry();
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "unzip: 文件已解压 " + str4);
                }
                zipInputStream.close();
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: FileNotFoundException: " + e6.getMessage());
        } catch (IOException e7) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: IOException: " + e7.getMessage());
            com.kwad.sdk.core.d.c.printStackTrace(e7);
        }
    }

    private static void initData() {
        Map<String, ?> all = Fo.getAll();
        ArrayList arrayList = new ArrayList();
        if (all == null || all.isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            WarmUpResponse.ResourceItem resourceItem = new WarmUpResponse.ResourceItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        resourceItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(resourceItem.resourceKey) && !TextUtils.isEmpty(resourceItem.cachePath)) {
                            if ((resourceItem.isZip ? new File(resourceItem.zipDir) : new File(resourceItem.cachePath)).exists()) {
                                synchronized (mLock) {
                                    aXQ.put(str, resourceItem);
                                }
                            } else {
                                arrayList.add(resourceItem.resourceKey);
                                com.kwad.sdk.core.d.c.d("WarmUpManager", "Remove null file list " + resourceItem.resourceKey);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        SharedPreferences.Editor edit = Fo.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    public static long m(File file) {
        long m6;
        long j6 = 0;
        if (file == null) {
            return 0L;
        }
        if (!file.isDirectory()) {
            if (file.isFile()) {
                return file.length();
            }
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    m6 = file2.length();
                } else if (file2.isDirectory()) {
                    m6 = m(file2);
                }
                j6 += m6;
            }
        }
        return j6;
    }

    private static void b(WarmUpResponse.ResourceItem resourceItem) {
        new WarmUpResponse.ResourceItem();
        resourceItem.isCached = true;
        synchronized (mLock) {
            aXQ.put(resourceItem.resourceKey, resourceItem);
        }
        if (Fo != null) {
            SharedPreferences.Editor edit = Fo.edit();
            edit.putString(resourceItem.resourceKey, resourceItem.toJson().toString());
            edit.apply();
        }
    }

    private static File a(int i6, WarmUpResponse.ResourceItem resourceItem) {
        String str;
        File file = new File(m.Ta().getExternalCacheDir(), "/com.ksad.warmup/");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (i6 == 1) {
            str = "video/";
        } else if (i6 == 2) {
            str = "image/";
        } else if (i6 != 3) {
            str = "";
        } else {
            str = "zip/";
        }
        String a6 = a(resourceItem);
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, resourceItem.resourceKey + a6);
        if (!file3.exists()) {
            try {
                File parentFile = file3.getParentFile();
                Objects.requireNonNull(parentFile);
                if (!parentFile.exists()) {
                    file3.getParentFile().mkdirs();
                }
                file3.createNewFile();
            } catch (IOException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        if (i6 == 3) {
            resourceItem.isZip = true;
            resourceItem.zipDir = file2.getAbsolutePath() + "/" + resourceItem.resourceKey;
        }
        resourceItem.cachePath = file3.getAbsolutePath();
        return file3;
    }

    private static String a(WarmUpResponse.ResourceItem resourceItem) {
        if (resourceItem == null || TextUtils.isEmpty(resourceItem.url)) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "warmupItem or url is null");
            return null;
        }
        String str = resourceItem.url;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1 && lastIndexOf < str.length() - 1) {
            return str.substring(lastIndexOf);
        }
        com.kwad.sdk.core.d.c.d("WarmUpManager", "No file extension found in URL: " + str);
        return null;
    }

    private static void a(ZipInputStream zipInputStream, String str) {
        StringBuilder sb;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e6) {
                                e = e6;
                                com.kwad.sdk.core.d.c.printStackTrace(e);
                                sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                                sb.append(e.getMessage());
                                com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                            }
                        }
                    }
                } catch (EOFException e7) {
                    e = e7;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: EOFException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                            e = e8;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            sb.append(e.getMessage());
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: IOException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e10) {
                            e = e10;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            sb.append(e.getMessage());
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e11) {
                            com.kwad.sdk.core.d.c.printStackTrace(e11);
                            com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: FileOutputStream close error: " + e11.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (EOFException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
