package com.qq.e.comm;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class GDTFileProvider extends ContentProvider {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f36719b = {"_display_name", "_size"};

    /* renamed from: c, reason: collision with root package name */
    private static final File f36720c = new File(File.separator);

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, a> f36721d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private a f36722a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final String f36723a;

        /* renamed from: b, reason: collision with root package name */
        private final HashMap<String, File> f36724b = new HashMap<>();

        void a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f36724b.put(str, file.getCanonicalFile());
            } catch (IOException e6) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e6);
            }
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f36724b.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        b(String str) {
            this.f36723a = str;
        }

        @Override // com.qq.e.comm.GDTFileProvider.a
        public Uri a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f36724b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                boolean endsWith = path2.endsWith("/");
                int length = path2.length();
                if (!endsWith) {
                    length++;
                }
                return new Uri.Builder().scheme("content").authority(this.f36723a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(canonicalPath.substring(length), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    private static Object[] a(Object[] objArr, int i6) {
        Object[] objArr2 = new Object[i6];
        System.arraycopy(objArr, 0, objArr2, 0, i6);
        return objArr2;
    }

    private static a b(Context context, String str) {
        a aVar;
        synchronized (f36721d) {
            try {
                aVar = f36721d.get(str);
                if (aVar == null) {
                    try {
                        aVar = c(context, str);
                        f36721d.put(str, aVar);
                    } catch (IOException e6) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e6);
                    } catch (XmlPullParserException e7) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e7);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private static a c(Context context, String str) throws IOException, XmlPullParserException {
        b bVar = new b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                loadXmlMetaData.close();
                return bVar;
            }
            if (next == 2) {
                String name = loadXmlMetaData.getName();
                File file = null;
                String attributeValue = loadXmlMetaData.getAttributeValue(null, CommonNetImpl.NAME);
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = f36720c;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] a6 = a(context, (String) null);
                    if (a6.length > 0) {
                        file = a6[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        file = externalMediaDirs[0];
                    }
                }
                if (file != null) {
                    bVar.a(attributeValue, a(file, attributeValue2));
                }
            }
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        try {
            return b(context, str).a(file);
        } catch (Throwable unused) {
            return Uri.EMPTY;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f36722a.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a6 = this.f36722a.a(uri);
        int lastIndexOf = a6.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a6.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f36722a.a(uri), a(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i6;
        File a6 = this.f36722a.a(uri);
        if (strArr == null) {
            strArr = f36719b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i7 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i7] = "_display_name";
                i6 = i7 + 1;
                objArr[i7] = a6.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i7] = "_size";
                i6 = i7 + 1;
                objArr[i7] = Long.valueOf(a6.length());
            }
            i7 = i6;
        }
        String[] a7 = a(strArr3, i7);
        Object[] a8 = a(objArr, i7);
        MatrixCursor matrixCursor = new MatrixCursor(a7, 1);
        matrixCursor.addRow(a8);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static String[] a(String[] strArr, int i6) {
        String[] strArr2 = new String[i6];
        System.arraycopy(strArr, 0, strArr2, 0, i6);
        return strArr2;
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                this.f36722a = b(context, providerInfo.authority);
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    private static File[] a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    private static int a(String str) {
        if (t.f36150k.equals(str)) {
            return 268435456;
        }
        if (IAdInterListener.AdReqParam.WIDTH.equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }
}
