package com.baidu.idl.face.platform.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.snail.antifake.deviceid.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class FileUtils {
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    private static final Pattern RESERVED_CHARS_PATTERN = Pattern.compile("[\\\\/:\\*\\?\\\"<>|]");

    public static void cleanDir(File file) {
        deleteDir(file, false);
    }

    public static void copyFile(String str, String str2) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    IoUtils.copyStream(fileInputStream2, new File(str2));
                    IoUtils.closeQuietly(fileInputStream2);
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    IoUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e = e7;
        }
    }

    public static void deleteDir(String str) {
        deleteDir(new File(str));
    }

    public static boolean deleteFileIfExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static String getExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getExtension(new File(str));
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static String readFileText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileText(new File(str));
    }

    public static void writeToFile(File file, String str) {
        writeToFile(file, str, false, "utf-8");
    }

    public static void writeToFileNio(InputStream inputStream, File file) {
        Throwable th;
        FileChannel fileChannel;
        ReadableByteChannel readableByteChannel;
        IOException iOException;
        int available;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            available = inputStream.available();
            readableByteChannel = Channels.newChannel(inputStream);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileChannel = fileOutputStream.getChannel();
                } catch (IOException e6) {
                    iOException = e6;
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (IOException e7) {
                iOException = e7;
                fileChannel = null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        } catch (IOException e8) {
            iOException = e8;
            fileChannel = null;
            readableByteChannel = null;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            readableByteChannel = null;
        }
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, available);
            IoUtils.closeQuietly(fileOutputStream);
        } catch (IOException e9) {
            iOException = e9;
            fileOutputStream2 = fileOutputStream;
            try {
                iOException.printStackTrace();
                IoUtils.closeQuietly(fileOutputStream2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
            } catch (Throwable th5) {
                th = th5;
                IoUtils.closeQuietly(fileOutputStream2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            IoUtils.closeQuietly(fileOutputStream2);
            IoUtils.closeQuietly(readableByteChannel);
            IoUtils.closeQuietly(fileChannel);
            throw th;
        }
        IoUtils.closeQuietly(readableByteChannel);
        IoUtils.closeQuietly(fileChannel);
    }

    public static void cleanDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, false, filenameFilter);
    }

    public static long computeFolderSize(File file) {
        long computeFolderSize;
        long j6 = 0;
        if (file == null) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    computeFolderSize = file2.length();
                } else if (file2.isDirectory()) {
                    j6 += file2.length();
                    computeFolderSize = computeFolderSize(file2);
                }
                j6 += computeFolderSize;
            }
        }
        return j6;
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static boolean ensureMkdir(File file) {
        if (file == null) {
            return false;
        }
        int i6 = 1;
        File file2 = file;
        while (file2.exists()) {
            file2 = new File(file.getParent(), file.getName() + "(" + i6 + ")");
            i6++;
        }
        return file2.mkdir();
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getUserHome() {
        return new File(System.getProperty("user.home"));
    }

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static Map<String, String> readConfig(File file) {
        HashMap hashMap = new HashMap();
        String readFileText = readFileText(file);
        if (readFileText != null && !TextUtils.isEmpty(readFileText)) {
            for (String str : readFileText.split(e.f37542d)) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim) && !trim.startsWith("#")) {
                    String[] split = trim.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (split.length >= 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    }
                }
            }
        }
        return hashMap;
    }

    public static void writeToFile(File file, String str, boolean z5) {
        writeToFile(file, str, z5, "utf-8");
    }

    private FileUtils() {
    }

    public static void cleanDir(File file, FileFilter fileFilter) {
        deleteDir(file, false, fileFilter);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        if (file.exists()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    if (file3.isDirectory()) {
                        copyDirectory(file3, new File(file2, file3.getName()));
                    } else {
                        copyFile(file3, new File(file2, file3.getName()));
                    }
                }
            }
        }
    }

    public static File createCollectDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile != null && sDRootFile.exists()) {
            File file = new File(sDRootFile, "CollectBest");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static void deleteDir(File file, FileFilter fileFilter) {
        deleteDir(file, true, fileFilter);
    }

    public static void ensureDir(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
                return;
            }
            return;
        }
        file.mkdirs();
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return name.substring(lastIndexOf + 1);
        }
        return "";
    }

    public static String getFileNameWithoutExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static String getFileNameWithoutExtensionByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileNameWithoutExtension(new File(str));
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static boolean isFilenameValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !RESERVED_CHARS_PATTERN.matcher(str).find();
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static FileOutputStream openNewFileOutput(File file) throws IOException {
        deleteFileIfExist(file);
        ensureParent(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static byte[] readAssetFileContent(AssetManager assetManager, String str) throws IOException {
        InputStream open = assetManager.open(str);
        int available = open.available();
        byte[] bArr = new byte[available];
        int read = open.read(bArr);
        if (read == available) {
            open.close();
            return bArr;
        }
        throw new IOException("realSize is not equal to size: " + read + " : " + available);
    }

    public static String readAssetFileUtf8String(AssetManager assetManager, String str) throws IOException {
        return new String(readAssetFileContent(assetManager, str), Charset.forName("UTF-8"));
    }

    public static byte[] readFileBytes(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(fileInputStream2);
                throw th;
            }
            try {
                try {
                    byte[] loadBytes = IoUtils.loadBytes(fileInputStream);
                    IoUtils.closeQuietly(fileInputStream);
                    return loadBytes;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    IoUtils.closeQuietly(fileInputStream2);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream);
                return null;
            }
        }
        return null;
    }

    public static String readFileText(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(fileInputStream2);
                throw th;
            }
            try {
                try {
                    String loadContent = IoUtils.loadContent(fileInputStream);
                    IoUtils.closeQuietly(fileInputStream);
                    return loadContent;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    IoUtils.closeQuietly(fileInputStream2);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream);
                return null;
            }
        }
        return null;
    }

    public static void writeToFile(File file, String str, String str2) {
        writeToFile(file, str, false, str2);
    }

    public static void deleteDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, true, filenameFilter);
    }

    public static void writeToFile(File file, String str, boolean z5, String str2) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        ensureParent(file);
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, z5), str2);
                try {
                    outputStreamWriter2.write(str);
                    IoUtils.closeQuietly(outputStreamWriter2);
                } catch (IOException e6) {
                    e = e6;
                    outputStreamWriter = outputStreamWriter2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(outputStreamWriter);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    IoUtils.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void deleteDir(File file, boolean z5) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z5);
                } else {
                    file2.delete();
                }
            }
        }
        if (z5) {
            file.delete();
        }
    }

    public static boolean deleteFileIfExist(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void copyFile(File file, File file2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        IOException iOException;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileChannel = fileInputStream2.getChannel();
                    try {
                        fileChannel2 = fileOutputStream.getChannel();
                        try {
                            fileChannel.transferTo(0L, fileChannel.size(), fileChannel2);
                            IoUtils.closeQuietly(fileInputStream2);
                        } catch (IOException e6) {
                            iOException = e6;
                            fileInputStream = fileInputStream2;
                            try {
                                iOException.printStackTrace();
                                IoUtils.closeQuietly(fileInputStream);
                                IoUtils.closeQuietly(fileChannel);
                                IoUtils.closeQuietly(fileOutputStream);
                                IoUtils.closeQuietly(fileChannel2);
                            } catch (Throwable th2) {
                                th = th2;
                                IoUtils.closeQuietly(fileInputStream);
                                IoUtils.closeQuietly(fileChannel);
                                IoUtils.closeQuietly(fileOutputStream);
                                IoUtils.closeQuietly(fileChannel2);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            IoUtils.closeQuietly(fileInputStream);
                            IoUtils.closeQuietly(fileChannel);
                            IoUtils.closeQuietly(fileOutputStream);
                            IoUtils.closeQuietly(fileChannel2);
                            throw th;
                        }
                    } catch (IOException e7) {
                        iOException = e7;
                        fileChannel2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileChannel2 = null;
                    }
                } catch (IOException e8) {
                    iOException = e8;
                    fileChannel = null;
                    fileChannel2 = fileChannel;
                    fileInputStream = fileInputStream2;
                    iOException.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel2);
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel = null;
                    fileChannel2 = fileChannel;
                    fileInputStream = fileInputStream2;
                    IoUtils.closeQuietly(fileInputStream);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel2);
                    throw th;
                }
            } catch (IOException e9) {
                iOException = e9;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                fileChannel = null;
            }
        } catch (IOException e10) {
            iOException = e10;
            fileOutputStream = null;
            fileChannel = null;
            fileChannel2 = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            fileChannel = null;
            fileChannel2 = null;
        }
        IoUtils.closeQuietly(fileChannel);
        IoUtils.closeQuietly(fileOutputStream);
        IoUtils.closeQuietly(fileChannel2);
    }

    public static String readFileText(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            IoUtils.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                String loadContent = IoUtils.loadContent(fileInputStream, str2);
                IoUtils.closeQuietly(fileInputStream);
                return loadContent;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                IoUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            IoUtils.closeQuietly(fileInputStream);
            return null;
        }
    }

    public static final void writeToFile(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return;
        }
        ensureParent(file);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    IoUtils.closeQuietly(fileOutputStream2);
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    IoUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public static void deleteDir(File file, boolean z5, FileFilter fileFilter) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z5, fileFilter);
                } else {
                    file2.delete();
                }
            }
        }
        if (z5) {
            file.delete();
        }
    }

    public static void writeToFileNio(File file, byte[] bArr) {
        Throwable th;
        FileChannel fileChannel;
        ReadableByteChannel readableByteChannel;
        IOException iOException;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            readableByteChannel = Channels.newChannel(new ByteArrayInputStream(bArr));
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileChannel = fileOutputStream.getChannel();
                } catch (IOException e6) {
                    iOException = e6;
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (IOException e7) {
                iOException = e7;
                fileChannel = null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        } catch (IOException e8) {
            iOException = e8;
            fileChannel = null;
            readableByteChannel = null;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            readableByteChannel = null;
        }
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, bArr.length);
            IoUtils.closeQuietly(fileOutputStream);
        } catch (IOException e9) {
            iOException = e9;
            fileOutputStream2 = fileOutputStream;
            try {
                iOException.printStackTrace();
                IoUtils.closeQuietly(fileOutputStream2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
            } catch (Throwable th5) {
                th = th5;
                IoUtils.closeQuietly(fileOutputStream2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            IoUtils.closeQuietly(fileOutputStream2);
            IoUtils.closeQuietly(readableByteChannel);
            IoUtils.closeQuietly(fileChannel);
            throw th;
        }
        IoUtils.closeQuietly(readableByteChannel);
        IoUtils.closeQuietly(fileChannel);
    }

    public static void deleteDir(File file, boolean z5, FilenameFilter filenameFilter) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z5, filenameFilter);
                } else {
                    file2.delete();
                }
            }
        }
        if (z5) {
            file.delete();
        }
    }
}
