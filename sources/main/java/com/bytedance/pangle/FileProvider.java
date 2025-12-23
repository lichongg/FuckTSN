package com.bytedance.pangle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class FileProvider extends ContentProvider {
    private static j cw;

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f25364j = {"_display_name", "_size"};
    private static final File xt = new File("/");

    interface j {
        Uri j(File file);

        File j(Uri uri);
    }

    public static void j(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            j(plugin.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName), (xt) cw, xmlResourceParser);
        } catch (IOException | XmlPullParserException e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static class xt implements j {

        /* renamed from: j, reason: collision with root package name */
        private final String f25365j;
        private final HashMap<String, File> xt = new HashMap<>();

        void j(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.xt.put(str, file.getCanonicalFile());
            } catch (IOException e6) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)), e6);
            }
        }

        xt(String str) {
            this.f25365j = str;
        }

        @Override // com.bytedance.pangle.FileProvider.j
        public Uri j(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.xt.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f25365j).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.j
        public File j(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.xt.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
        }
    }

    @Keep
    public static Uri getUriForFile(@NonNull File file) {
        return cw.j(file);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return cw.j(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        File j6 = cw.j(uri);
        int lastIndexOf = j6.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(j6.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(cw.j(uri), j(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i6;
        File j6 = cw.j(uri);
        if (strArr == null) {
            strArr = f25364j;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i7 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i7] = "_display_name";
                i6 = i7 + 1;
                objArr[i7] = j6.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i7] = "_size";
                i6 = i7 + 1;
                objArr[i7] = Long.valueOf(j6.length());
            }
            i7 = i6;
        }
        String[] j7 = j(strArr3, i7);
        Object[] j8 = j(objArr, i7);
        MatrixCursor matrixCursor = new MatrixCursor(j7, 1);
        matrixCursor.addRow(j8);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static void j(String str, Context context, xt xtVar, XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                File file = null;
                String attributeValue = xmlResourceParser.getAttributeValue(null, CommonNetImpl.NAME);
                String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = xt;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-files-path".equals(name)) {
                    File[] j6 = j(context, (String) null);
                    if (j6.length > 0) {
                        file = j6[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] j7 = j(context);
                    if (j7.length > 0) {
                        file = j7[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        file = externalMediaDirs[0];
                    }
                }
                if (file != null) {
                    xtVar.j(str + "_" + attributeValue, j(file, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                if (cw == null) {
                    cw = new xt(providerInfo.authority);
                    return;
                }
                throw new SecurityException("仅允许定义一个FileProvider");
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @NonNull
    public static File[] j(@NonNull Context context, @Nullable String str) {
        return context.getExternalFilesDirs(str);
    }

    @NonNull
    public static File[] j(@NonNull Context context) {
        return context.getExternalCacheDirs();
    }

    private static int j(String str) {
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
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
    }

    private static File j(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] j(String[] strArr, int i6) {
        String[] strArr2 = new String[i6];
        System.arraycopy(strArr, 0, strArr2, 0, i6);
        return strArr2;
    }

    private static Object[] j(Object[] objArr, int i6) {
        Object[] objArr2 = new Object[i6];
        System.arraycopy(objArr, 0, objArr2, 0, i6);
        return objArr2;
    }
}
