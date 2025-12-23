package xyz.adscope.common.cache;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.cache.model.CacheModel;
import xyz.adscope.common.db.DataBaseManager;
import xyz.adscope.common.imageloader.StorageUtils;
import xyz.adscope.common.tool.security.MD5Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CacheManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f56289c = "image_cache" + File.separator;

    /* renamed from: d, reason: collision with root package name */
    private static CacheManager f56290d;

    /* renamed from: a, reason: collision with root package name */
    private DataBaseManager f56291a;

    /* renamed from: b, reason: collision with root package name */
    private Context f56292b;

    private long a(File file) {
        File[] listFiles;
        long j6 = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                j6 += file2.length();
            }
        }
        return j6;
    }

    private List<CacheModel> b() {
        DataBaseManager dataBaseManager = this.f56291a;
        if (dataBaseManager != null) {
            List query = dataBaseManager.query(null);
            int size = (query == null || query.size() <= 0) ? 0 : query.size() / 2;
            List<CacheModel> query2 = this.f56291a.query("lastUsedTime", size + "");
            if (query2 != null && query2.size() > 0) {
                return query2;
            }
        }
        return null;
    }

    private String c() {
        return f56289c + "no_delete";
    }

    public static CacheManager getInstance(Context context) {
        if (f56290d == null) {
            synchronized (CacheManager.class) {
                try {
                    if (f56290d == null) {
                        f56290d = new CacheManager(context);
                    }
                } finally {
                }
            }
        }
        return f56290d;
    }

    public Bitmap getBitmapByFileName(String str, boolean z5) {
        if (z5 && this.f56291a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("fileName", MD5Util.md5(str));
            ContentValues contentValues = new ContentValues();
            contentValues.put("lastUsedTime", Long.valueOf(System.currentTimeMillis()));
            this.f56291a.update((Object) hashMap, contentValues);
        }
        File a6 = a(z5, MD5Util.md5(str));
        if (!a6.exists() || a6.length() <= 0) {
            return null;
        }
        return BitmapFactory.decodeFile(a6.getAbsolutePath());
    }

    public CacheManager(Context context) {
        this.f56292b = context;
        DataBaseManager dataBaseManager = new DataBaseManager(context);
        this.f56291a = dataBaseManager;
        dataBaseManager.setTableNameAndModel("cache_image_video_table", CacheModel.class);
        File filesCacheDirectory = StorageUtils.getFilesCacheDirectory(context, f56289c);
        if (!filesCacheDirectory.exists()) {
            filesCacheDirectory.mkdirs();
        }
    }

    public void performCacheCleanup() {
        List<CacheModel> b6;
        if (a(StorageUtils.getFilesCacheDirectory(this.f56292b, a())) > 209715200 && (b6 = b()) != null && b6.size() > 0) {
            Iterator<CacheModel> it = b6.iterator();
            while (it.hasNext()) {
                a(it.next().getFileName());
            }
        }
    }

    public void saveImage(String str, Bitmap bitmap, boolean z5) {
        File a6 = a(z5, MD5Util.md5(str));
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(a6));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (z5) {
            CacheModel cacheModel = new CacheModel();
            cacheModel.setFileSize(a6.length());
            cacheModel.setFileName(MD5Util.md5(str));
            cacheModel.setCanDelete(!z5 ? 1 : 0);
            cacheModel.setLastUsedTime(System.currentTimeMillis());
            DataBaseManager dataBaseManager = this.f56291a;
            if (dataBaseManager != null) {
                dataBaseManager.insert(cacheModel);
            }
        }
    }

    private void a(String str) {
        File a6 = a(true, str);
        if (a6.exists()) {
            a6.delete();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        DataBaseManager dataBaseManager = this.f56291a;
        if (dataBaseManager != null) {
            dataBaseManager.delete(hashMap);
        }
    }

    private File a(boolean z5, String str) {
        File filesCacheDirectory = StorageUtils.getFilesCacheDirectory(this.f56292b, z5 ? a() : c());
        if (!filesCacheDirectory.exists()) {
            filesCacheDirectory.mkdirs();
        }
        return new File(filesCacheDirectory.getPath(), str);
    }

    private String a() {
        return f56289c + "can_delete";
    }
}
