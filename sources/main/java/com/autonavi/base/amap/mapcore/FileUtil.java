package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.d3;
import com.amap.api.col.p0003l.v5;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ZipCompressProgressListener {
        void onFinishProgress(long j6);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e6) {
                e6.printStackTrace();
                return false;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) {
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes(str2));
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e6) {
                    e = e6;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.getMessage();
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e = e7;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0L, null);
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i6 = 0; i6 < listFiles.length; i6++) {
                if (listFiles[i6].isFile()) {
                    if (!listFiles[i6].delete()) {
                        return false;
                    }
                } else {
                    if (!deleteFile(listFiles[i6])) {
                        return false;
                    }
                    listFiles[i6].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    public static String getMapBaseStorage(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String str2 = MapsInitializer.sdcardDir;
        if (str2 == null || str2.trim().length() <= 0) {
            String string = sharedPreferences.getString("map_base_path_v44", "");
            String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("map_base_path_v44", str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str5;
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                safelyCloseFile((OutputStream) null);
                safelyCloseFile((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            v5.p(th, TAG, "readFileContents");
                            b3.D(th);
                            d3.l(c3.f5806f, "read file from disk failed " + th.getMessage());
                            return null;
                        } finally {
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                for (String str3 : list) {
                    if (str3 != null && str3.contains(str2)) {
                        return readFileContentsFromAssets(context, str + "/" + str3);
                    }
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void saveFileContents(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            safelyCloseFile(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                v5.p(th, TAG, "saveFileContents");
                b3.D(th);
                d3.l(c3.f5806f, "save file from disk failed " + th.getMessage());
            } finally {
                safelyCloseFile(fileOutputStream2);
            }
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream inputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read < 0) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.getMessage();
                        return null;
                    } finally {
                        safelyCloseFile(inputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        return null;
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (inputStream instanceof ZipInputStream) {
                str = ((ZipInputStream) inputStream).getNextEntry().getName();
                if (!isSafeEntryName(str)) {
                    "gzip name contains ../ ".concat(String.valueOf(str));
                    return null;
                }
            } else {
                str = "";
            }
            if (inputStream != null) {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (read < 0) {
                        return new Pair<>(str, byteArrayOutputStream.toByteArray());
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.getMessage();
                return null;
            } finally {
                safelyCloseFile(inputStream);
            }
        }
        return null;
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr3 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr3);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            try {
                b3.D(th);
                th.printStackTrace();
                return bArr2;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
        return bArr2;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    private static void decompress(InputStream inputStream, String str, long j6, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j6, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j6, long j7, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i6 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i6;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                bufferedOutputStream.close();
                return i6;
            }
            bufferedOutputStream.write(bArr, 0, read);
            i6 += read;
            if (j7 > 0 && zipCompressProgressListener != null) {
                long j8 = ((i6 + j6) * 100) / j7;
                if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                    zipCompressProgressListener.onFinishProgress(j8);
                }
            }
        }
    }

    public static String getExternalStroragePath(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains(FILE_PATH_ENTRY_SEPARATOR1) || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safelyCloseFile(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e6) {
                    throw e6;
                }
            } catch (Throwable th) {
                safelyCloseFile(byteArrayOutputStream);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readFileContentsFromAssets(Context context, String str) {
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        ?? r12 = 0;
        try {
            try {
                inputStream = assets.open(str);
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
            } catch (OutOfMemoryError e7) {
                e = e7;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) r12);
                throw th;
            }
            try {
                int available = inputStream.available();
                if (available == 0) {
                    safelyCloseFile(inputStream);
                    return null;
                }
                byte[] bArr = new byte[available];
                for (int i6 = 0; i6 < available; i6 += inputStream.read(bArr, i6, available - i6)) {
                }
                safelyCloseFile(inputStream);
                return bArr;
            } catch (IOException e8) {
                e = e8;
                d3.l(c3.f5806f, "read file from assets failed " + e.getMessage());
                safelyCloseFile(inputStream);
                return null;
            } catch (OutOfMemoryError e9) {
                e = e9;
                d3.l(c3.f5806f, "read file from assets failed " + e.getMessage());
                safelyCloseFile(inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            r12 = assets;
            safelyCloseFile((InputStream) r12);
            throw th;
        }
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        HashMap hashMap = new HashMap();
        if (bArr != null && bArr.length != 0) {
            InputStream inputStream = null;
            try {
                InputStream zipInputStream = getZipInputStream(bArr);
                try {
                    if (zipInputStream instanceof ZipInputStream) {
                        ZipInputStream zipInputStream2 = (ZipInputStream) zipInputStream;
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            }
                            if (!nextEntry.isDirectory()) {
                                try {
                                    String name = nextEntry.getName();
                                    if (!isSafeEntryName(name)) {
                                        "gzip name contains ../ ".concat(String.valueOf(name));
                                        safelyCloseFile(zipInputStream);
                                        return null;
                                    }
                                    if (strArr == null) {
                                        byte[] readByteByStream = readByteByStream(zipInputStream2);
                                        if (readByteByStream != null) {
                                            hashMap.put(name, readByteByStream);
                                        }
                                    } else {
                                        int length = strArr.length;
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 < length) {
                                                String str = strArr[i6];
                                                if (name.equals(str)) {
                                                    byte[] readByteByStream2 = readByteByStream(zipInputStream2);
                                                    if (readByteByStream2 != null) {
                                                        hashMap.put(str, readByteByStream2);
                                                    }
                                                } else {
                                                    i6++;
                                                }
                                            }
                                        }
                                    }
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            zipInputStream2.closeEntry();
                        }
                    }
                    safelyCloseFile(zipInputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = zipInputStream;
                    try {
                        th.getMessage();
                        return hashMap;
                    } finally {
                        safelyCloseFile(inputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static String uncompressToString(byte[] bArr, String str) {
        InputStream inputStream;
        ?? r02 = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                inputStream = getZipInputStream(bArr);
                if (inputStream != null) {
                    try {
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read < 0) {
                                String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                                safelyCloseFile(inputStream);
                                return byteArrayOutputStream2;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    } catch (IOException e6) {
                        e = e6;
                        e.getMessage();
                        safelyCloseFile(inputStream);
                        return null;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) r02);
                throw th;
            }
            safelyCloseFile(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            r02 = bArr;
            safelyCloseFile((InputStream) r02);
            throw th;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        try {
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream2);
                            return;
                        } catch (Exception e6) {
                            fileOutputStream = fileOutputStream2;
                            e = e6;
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            }
            writeLock.unlock();
            safelyCloseFile((OutputStream) null);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j6, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        int i6 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                zipInputStream.closeEntry();
                return;
            }
            String name = nextEntry.getName();
            if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                break;
            }
            File file3 = new File(file2.getPath() + File.separator + name);
            fileProber(file3);
            if (nextEntry.isDirectory()) {
                file3.mkdirs();
            } else {
                i6 += decompressFile(file3, zipInputStream, i6, j6, zipCompressProgressListener, unZipFileBrake);
            }
            zipInputStream.closeEntry();
        }
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e6) {
                    e = e6;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.getMessage();
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }
}
