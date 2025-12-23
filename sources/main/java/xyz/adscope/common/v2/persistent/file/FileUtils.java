package xyz.adscope.common.v2.persistent.file;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.apache.commons.net.g;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.file.FileUtils;
import xyz.adscope.common.v2.tool.io.IOUtils;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class FileUtils {
    public static List<File> getAllFile(String str) {
        return getAllFile(new File(str));
    }

    public static void storeToFile(String str, String str2) {
        storeToFile(createNewFile(str), str2);
    }

    public static File createNewFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e6) {
                SDKLog.stack(e6);
            }
        }
        return file;
    }

    public static void deleteDirWithIgnore(File file, Set<String> set) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (set == null || !set.contains(name)) {
                try {
                    file2.delete();
                } catch (Throwable th) {
                    SDKLog.stack(th);
                }
            }
        }
    }

    public static File[] filterFileByExpire(File file, final long j6) {
        if (file != null && file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() { // from class: n5.a
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return FileUtils.a(j6, file2);
                }
            });
        }
        return null;
    }

    public static File[] filterFileByName(File file, final String str) {
        if (file == null || !file.exists() || !file.isDirectory() || TextUtils.isEmpty(str)) {
            return null;
        }
        return file.listFiles(new FilenameFilter() { // from class: n5.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                boolean equals;
                equals = str2.equals(str);
                return equals;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    public static boolean storeCrashFormatFile(String str, long j6, String str2) {
        Throwable th;
        FileWriter fileWriter;
        FileWriter fileWriter2;
        FileWriter fileWriter3;
        BufferedWriter bufferedWriter;
        FileWriter fileWriter4 = null;
        try {
            fileWriter3 = new FileWriter(createNewFile(str), true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter3);
                try {
                    bufferedWriter.write(StringUtil.formatCrashLogDate(j6));
                    bufferedWriter.write(g.f50795q);
                    bufferedWriter.write("------------------crash----------------------");
                    bufferedWriter.write(g.f50795q);
                    bufferedWriter.write(str2);
                    bufferedWriter.write(g.f50795q);
                    bufferedWriter.write("-------------------end-----------------------");
                    bufferedWriter.newLine();
                    IOUtils.closeQuietly(bufferedWriter);
                    IOUtils.closeQuietly(fileWriter3);
                    return true;
                } catch (IOException e6) {
                    e = e6;
                    fileWriter4 = fileWriter3;
                    fileWriter2 = bufferedWriter;
                    try {
                        SDKLog.stack(e);
                        IOUtils.closeQuietly(fileWriter2);
                        IOUtils.closeQuietly(fileWriter4);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        FileWriter fileWriter5 = fileWriter4;
                        fileWriter4 = fileWriter2;
                        fileWriter = fileWriter5;
                        fileWriter3 = fileWriter;
                        IOUtils.closeQuietly(fileWriter4);
                        IOUtils.closeQuietly(fileWriter3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter4 = bufferedWriter;
                    IOUtils.closeQuietly(fileWriter4);
                    IOUtils.closeQuietly(fileWriter3);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedWriter = 0;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e8) {
            e = e8;
            fileWriter2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
            fileWriter3 = fileWriter;
            IOUtils.closeQuietly(fileWriter4);
            IOUtils.closeQuietly(fileWriter3);
            throw th;
        }
    }

    private FileUtils() {
    }

    public static /* synthetic */ boolean a(long j6, File file) {
        if (file.lastModified() < j6) {
            return true;
        }
        return false;
    }

    public static List<File> getAllFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        return Arrays.asList(listFiles);
    }

    public static File getAppRootDir(Context context) {
        return context.getFilesDir();
    }

    public static File getCacheFileDir(Context context) {
        return context.getCacheDir();
    }

    public static long getFolderSizeByte(File file) {
        long folderSizeByte;
        File[] listFiles = file.listFiles();
        long j6 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    folderSizeByte = file2.length();
                } else if (file2.isDirectory()) {
                    folderSizeByte = getFolderSizeByte(file2);
                }
                j6 += folderSizeByte;
            }
        }
        return j6;
    }

    public static boolean hasFile(File file, String str) {
        File[] filterFileByName = filterFileByName(file, str);
        if (filterFileByName != null && filterFileByName.length > 0) {
            return true;
        }
        return false;
    }

    public static String readFileContent(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file.exists() && file.canRead()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
            try {
                String read = IOUtils.read(fileInputStream);
                IOUtils.closeQuietly(fileInputStream);
                return read;
            } catch (IOException e7) {
                e = e7;
                try {
                    SDKLog.stack(e);
                    IOUtils.closeQuietly(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    IOUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        }
        return null;
    }

    public static void storeToFile(File file, String str) {
        FileWriter fileWriter;
        if (file == null) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file, true);
                try {
                    IOUtils.write(fileWriter, str.getBytes(StandardCharsets.UTF_8));
                    IOUtils.closeQuietly(fileWriter);
                } catch (IOException e6) {
                    e = e6;
                    fileWriter2 = fileWriter;
                    SDKLog.stack(e);
                    IOUtils.closeQuietly(fileWriter2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
    }
}
