package com.stub.stub09;

import android.annotation.SuppressLint;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mobads.sdk.internal.by;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.net.g;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class FileUtils {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static boolean copyDir(File file, File file2) {
        return copyOrMoveDir(file, file2, false);
    }

    public static boolean copyDir(String str, String str2) {
        return copyDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean copyFile(File file, File file2) {
        return copyOrMoveFile(file, file2, false);
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(getFileByPath(str), getFileByPath(str2));
    }

    private static boolean copyOrMoveDir(String str, String str2, boolean z5) {
        return copyOrMoveDir(getFileByPath(str), getFileByPath(str2), z5);
    }

    private static boolean copyOrMoveFile(String str, String str2, boolean z5) {
        return copyOrMoveFile(getFileByPath(str), getFileByPath(str2), z5);
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean deleteDir(String str) {
        return deleteDir(getFileByPath(str));
    }

    public static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteFile(String str) {
        return deleteFile(getFileByPath(str));
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static long getDirLength(String str) {
        return getDirLength(getFileByPath(str));
    }

    public static String getDirSize(String str) {
        return getDirSize(getFileByPath(str));
    }

    public static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    public static long getFileLength(String str) {
        return getFileLength(getFileByPath(str));
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    public static String getFileMD5ToString(File file) {
        return bytes2HexString(getFileMD5(file));
    }

    public static String getFileSize(String str) {
        return getFileSize(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return isFileExists(file) && file.isDirectory();
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return isFileExists(file) && file.isFile();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(getFileByPath(str));
    }

    public static List<File> listFilesInDir(String str, boolean z5) {
        return listFilesInDir(getFileByPath(str), z5);
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter);
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter, boolean z5) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter, z5);
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2) {
        return listFilesInDirWithFilter(getFileByPath(str), str2);
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2, boolean z5) {
        return listFilesInDirWithFilter(getFileByPath(str), str2, z5);
    }

    public static boolean moveDir(File file, File file2) {
        return copyOrMoveDir(file, file2, true);
    }

    public static boolean moveDir(String str, String str2) {
        return moveDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean moveFile(File file, File file2) {
        return copyOrMoveFile(file, file2, true);
    }

    public static boolean moveFile(String str, String str2) {
        return moveFile(getFileByPath(str), getFileByPath(str2));
    }

    public static byte[] readFile2Bytes(String str) {
        return readFile2Bytes(getFileByPath(str));
    }

    public static List<String> readFile2List(File file, String str) {
        return readFile2List(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> readFile2List(String str, int i6, int i7, String str2) {
        return readFile2List(getFileByPath(str), i6, i7, str2);
    }

    public static List<String> readFile2List(String str, String str2) {
        return readFile2List(getFileByPath(str), str2);
    }

    public static String readFile2String(String str, String str2) {
        return readFile2String(getFileByPath(str), str2);
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static List<File> searchFileInDir(String str, String str2) {
        return searchFileInDir(getFileByPath(str), str2);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z5) {
        return writeFileFromIS(getFileByPath(str), inputStream, z5);
    }

    public static boolean writeFileFromString(String str, String str2, boolean z5) {
        return writeFileFromString(getFileByPath(str), str2, z5);
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && file.isFile() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private static boolean copyOrMoveDir(File file, File file2, boolean z5) {
        if (file == null || file2 == null) {
            return false;
        }
        String str = file.getPath() + File.separator;
        String str2 = file2.getPath() + File.separator;
        if (str2.contains(str) || !file.exists() || !file.isDirectory() || !createOrExistsDir(file2)) {
            return false;
        }
        for (File file3 : file.listFiles()) {
            File file4 = new File(str2 + file3.getName());
            if (file3.isFile()) {
                if (!copyOrMoveFile(file3, file4, z5)) {
                    return false;
                }
            } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, z5)) {
                return false;
            }
        }
        return !z5 || deleteDir(file);
    }

    private static boolean copyOrMoveFile(File file, File file2, boolean z5) {
        if (file == null || file2 == null || !file.exists() || !file.isFile()) {
            return false;
        }
        if ((file2.exists() && file2.isFile()) || !createOrExistsDir(file2.getParentFile())) {
            return false;
        }
        try {
            if (!writeFileFromIS(file2, (InputStream) new FileInputStream(file), false)) {
                return false;
            }
            if (z5) {
                if (!deleteFile(file)) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteFilesInDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<File> listFilesInDir(File file, boolean z5) {
        if (!isDir(file)) {
            return null;
        }
        if (z5) {
            return listFilesInDir(file);
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            Collections.addAll(arrayList, listFiles);
        }
        return arrayList;
    }

    public static List<File> listFilesInDir(File file) {
        List<File> listFilesInDir;
        if (!isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                arrayList.add(file2);
                if (file2.isDirectory() && (listFilesInDir = listFilesInDir(file2)) != null) {
                    arrayList.addAll(listFilesInDir);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, String str, boolean z5) {
        if (z5) {
            return listFilesInDirWithFilter(file, str);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter, boolean z5) {
        if (z5) {
            return listFilesInDirWithFilter(file, filenameFilter);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, filenameFilter));
                }
            }
        }
        return arrayList;
    }

    public static List<File> searchFileInDir(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().equals(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(searchFileInDir(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z5) {
        if (file == null || inputStream == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z5));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            CloseUtils.closeIO(inputStream, bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFileFromString(File file, String str, boolean z5) {
        if (file == null || str == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z5));
                try {
                    bufferedWriter2.write(str);
                    CloseUtils.closeIO(bufferedWriter2);
                    return true;
                } catch (IOException e6) {
                    e = e6;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    CloseUtils.closeIO(bufferedWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CloseUtils.closeIO(bufferedWriter);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> readFile2List(File file, int i6, int i7, String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        if (file == null || i6 > i7) {
            return null;
        }
        try {
            try {
                ArrayList arrayList = new ArrayList();
                bufferedReader = isSpace(str) ? new BufferedReader(new FileReader(file)) : new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
                int i8 = 1;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || i8 > i7) {
                            break;
                        }
                        if (i6 <= i8 && i8 <= i7) {
                            arrayList.add(readLine);
                        }
                        i8++;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        CloseUtils.closeIO(bufferedReader);
                        return null;
                    }
                }
                CloseUtils.closeIO(bufferedReader);
                return arrayList;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                CloseUtils.closeIO(str2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
            CloseUtils.closeIO(str2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String readFile2String(File file, String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                bufferedReader = isSpace(str) ? new BufferedReader(new InputStreamReader(new FileInputStream(file))) : new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            String sb2 = sb.delete(sb.length() - 2, sb.length()).toString();
                            CloseUtils.closeIO(bufferedReader);
                            return sb2;
                        }
                        sb.append(readLine);
                        sb.append(g.f50795q);
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        CloseUtils.closeIO(bufferedReader);
                        return null;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                CloseUtils.closeIO(str2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
            CloseUtils.closeIO(str2);
            throw th;
        }
    }

    public static byte[] readFile2Bytes(File file) {
        if (file == null) {
            return null;
        }
        try {
            return inputStream2Bytes(new FileInputStream(file));
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileCharsetSimple(java.io.File r5) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            int r5 = r3.read()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            int r5 = r5 << 8
            int r2 = r3.read()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            int r5 = r5 + r2
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r0[r1] = r3
            com.stub.stub09.CloseUtils.closeIO(r0)
            goto L37
        L22:
            r5 = move-exception
            r2 = r3
            goto L52
        L25:
            r5 = move-exception
            r2 = r3
            goto L2b
        L28:
            r5 = move-exception
            goto L52
        L2a:
            r5 = move-exception
        L2b:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L28
            java.io.Closeable[] r5 = new java.io.Closeable[r0]
            r5[r1] = r2
            com.stub.stub09.CloseUtils.closeIO(r5)
            r5 = 0
        L37:
            r0 = 61371(0xefbb, float:8.5999E-41)
            if (r5 == r0) goto L4f
            r0 = 65279(0xfeff, float:9.1475E-41)
            if (r5 == r0) goto L4c
            r0 = 65534(0xfffe, float:9.1833E-41)
            if (r5 == r0) goto L49
            java.lang.String r5 = "GBK"
            return r5
        L49:
            java.lang.String r5 = "Unicode"
            return r5
        L4c:
            java.lang.String r5 = "UTF-16BE"
            return r5
        L4f:
            java.lang.String r5 = "UTF-8"
            return r5
        L52:
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r0[r1] = r2
            com.stub.stub09.CloseUtils.closeIO(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stub.stub09.FileUtils.getFileCharsetSimple(java.io.File):java.lang.String");
    }

    public static int getFileLines(File file) {
        int i6;
        Closeable[] closeableArr;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e6) {
            e = e6;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                i6 = 1;
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        int i7 = i6;
                        for (int i8 = 0; i8 < read; i8++) {
                            try {
                                if (bArr[i8] == 10) {
                                    i7++;
                                }
                            } catch (IOException e7) {
                                e = e7;
                                bufferedInputStream2 = bufferedInputStream;
                                i6 = i7;
                                e.printStackTrace();
                                closeableArr = new Closeable[]{bufferedInputStream2};
                                CloseUtils.closeIO(closeableArr);
                                return i6;
                            }
                        }
                        i6 = i7;
                    } catch (IOException e8) {
                        e = e8;
                        bufferedInputStream2 = bufferedInputStream;
                    }
                }
                closeableArr = new Closeable[]{bufferedInputStream};
            } catch (IOException e9) {
                e = e9;
                bufferedInputStream2 = bufferedInputStream;
                i6 = 1;
                e.printStackTrace();
                closeableArr = new Closeable[]{bufferedInputStream2};
                CloseUtils.closeIO(closeableArr);
                return i6;
            }
            CloseUtils.closeIO(closeableArr);
            return i6;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            CloseUtils.closeIO(bufferedInputStream2);
            throw th;
        }
    }

    public static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        return dirLength == -1 ? "" : byte2FitMemorySize(dirLength);
    }

    public static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        return fileLength == -1 ? "" : byte2FitMemorySize(fileLength);
    }

    public static long getDirLength(File file) {
        if (!isDir(file)) {
            return -1L;
        }
        long j6 = 0;
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                j6 = file2.isDirectory() ? j6 + getDirLength(file2) : j6 + file2.length();
            }
        }
        return j6;
    }

    public static long getFileLength(File file) {
        if (isFile(file)) {
            return file.length();
        }
        return -1L;
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(isSpace(str) ? null : new File(str));
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(isSpace(str) ? null : new File(str));
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0045: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:25:0x0045 */
    public static byte[] getFileMD5(File file) {
        DigestInputStream digestInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                digestInputStream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance(by.f10823a));
            } catch (IOException | NoSuchAlgorithmException e6) {
                e = e6;
                digestInputStream = null;
            } catch (Throwable th) {
                th = th;
                CloseUtils.closeIO(closeable2);
                throw th;
            }
            try {
                while (digestInputStream.read(new byte[262144]) > 0) {
                }
                byte[] digest = digestInputStream.getMessageDigest().digest();
                CloseUtils.closeIO(digestInputStream);
                return digest;
            } catch (IOException | NoSuchAlgorithmException e7) {
                e = e7;
                e.printStackTrace();
                CloseUtils.closeIO(digestInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            CloseUtils.closeIO(closeable2);
            throw th;
        }
    }

    public static String getDirName(File file) {
        if (file == null) {
            return null;
        }
        return getDirName(file.getPath());
    }

    public static String getDirName(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf + 1);
    }

    public static String getFileName(File file) {
        if (file == null) {
            return null;
        }
        return getFileName(file.getPath());
    }

    public static String getFileName(String str) {
        int lastIndexOf;
        return (isSpace(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        return lastIndexOf2 == -1 ? lastIndexOf == -1 ? str : str.substring(0, lastIndexOf) : (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) ? str.substring(lastIndexOf2 + 1) : str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    public static String getFileExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    private static byte[] inputStream2Bytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return input2OutputStream(inputStream).toByteArray();
    }

    private static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        CloseUtils.closeIO(inputStream);
                        return byteArrayOutputStream;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                CloseUtils.closeIO(inputStream);
                return null;
            }
        } catch (Throwable th) {
            CloseUtils.closeIO(inputStream);
            throw th;
        }
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i6 + 1;
            cArr[i6] = hexDigits[(bArr[i7] >>> 4) & 15];
            i6 = i8 + 1;
            cArr[i8] = hexDigits[bArr[i7] & 15];
        }
        return new String(cArr);
    }

    @SuppressLint({"DefaultLocale"})
    private static String byte2FitMemorySize(long j6) {
        return j6 < 0 ? "shouldn't be less than zero!" : j6 < 1024 ? String.format("%.3fB", Double.valueOf(j6 + 5.0E-4d)) : j6 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? String.format("%.3fKB", Double.valueOf((j6 / 1024.0d) + 5.0E-4d)) : j6 < IjkMediaMeta.AV_CH_STEREO_RIGHT ? String.format("%.3fMB", Double.valueOf((j6 / 1048576.0d) + 5.0E-4d)) : String.format("%.3fGB", Double.valueOf((j6 / 1.073741824E9d) + 5.0E-4d));
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!Character.isWhitespace(str.charAt(i6))) {
                return false;
            }
        }
        return true;
    }
}
