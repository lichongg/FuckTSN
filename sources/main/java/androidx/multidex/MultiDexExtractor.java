package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            this.dexDir.getPath();
            return;
        }
        for (File file : listFiles) {
            file.getPath();
            file.length();
            if (file.delete()) {
                file.getPath();
            } else {
                file.getPath();
            }
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i6 = multiDexPreferences.getInt(str + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i6 + (-1));
        int i7 = 2;
        while (i7 <= i6) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str2 + i7 + EXTRACTED_SUFFIX);
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.crc = getZipCrc(extractedDex);
            long j6 = multiDexPreferences.getLong(str + KEY_DEX_CRC + i7, -1L);
            long j7 = multiDexPreferences.getLong(str + KEY_DEX_TIME + i7, -1L);
            long lastModified = extractedDex.lastModified();
            if (j7 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = multiDexPreferences;
                if (j6 == extractedDex.crc) {
                    arrayList.add(extractedDex);
                    i7++;
                    multiDexPreferences = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j7 + ", modification time: " + lastModified + ", expected crc: " + j6 + ", file crc: " + extractedDex.crc);
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        String str = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(DEX_PREFIX);
            int i6 = 2;
            sb.append(2);
            sb.append(DEX_SUFFIX);
            ZipEntry entry = zipFile.getEntry(sb.toString());
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str + i6 + EXTRACTED_SUFFIX);
                arrayList.add(extractedDex);
                extractedDex.toString();
                int i7 = 0;
                boolean z5 = false;
                while (i7 < 3 && !z5) {
                    i7++;
                    extract(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = getZipCrc(extractedDex);
                        z5 = true;
                    } catch (IOException unused) {
                        extractedDex.getAbsolutePath();
                        z5 = false;
                    }
                    extractedDex.getAbsolutePath();
                    extractedDex.length();
                    if (!z5) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            extractedDex.getPath();
                        }
                    }
                }
                if (!z5) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i6 + ")");
                }
                i6++;
                entry = zipFile.getEntry(DEX_PREFIX + i6 + DEX_SUFFIX);
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    List<? extends File> load(Context context, String str, boolean z5) throws IOException {
        List<ExtractedDex> performExtractions;
        List<ExtractedDex> list;
        this.sourceApk.getPath();
        if (!this.cacheLock.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z5 && !isModified(context, this.sourceApk, this.sourceCrc, str)) {
            try {
                list = loadExistingExtractions(context, str);
            } catch (IOException unused) {
                performExtractions = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            }
            list.size();
            return list;
        }
        performExtractions = performExtractions();
        putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
        list = performExtractions;
        list.size();
        return list;
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        file.getPath();
        file2.getPath();
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.lockChannel = channel;
            try {
                file3.getPath();
                this.cacheLock = channel.lock();
                file3.getPath();
            } catch (IOException e6) {
                e = e6;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e7) {
                e = e7;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e8) {
                e = e8;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException e9) {
            e = e9;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (Error e10) {
            e = e10;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (RuntimeException e11) {
            e = e11;
            closeQuietly(this.lockRaf);
            throw e;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        createTempFile.getPath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    file.getPath();
                    if (createTempFile.renameTo(file)) {
                        closeQuietly(inputStream);
                        createTempFile.delete();
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        if (zipCrc == -1) {
            return zipCrc - 1;
        }
        return zipCrc;
    }

    private static boolean isModified(Context context, File file, long j6, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + KEY_TIME_STAMP, -1L) == getTimeStamp(file)) {
            if (multiDexPreferences.getLong(str + KEY_CRC, -1L) == j6) {
                return false;
            }
            return true;
        }
        return true;
    }

    private static void putStoredApkInfo(Context context, String str, long j6, long j7, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + KEY_TIME_STAMP, j6);
        edit.putLong(str + KEY_CRC, j7);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i6 = 2;
        for (ExtractedDex extractedDex : list) {
            edit.putLong(str + KEY_DEX_CRC + i6, extractedDex.crc);
            edit.putLong(str + KEY_DEX_TIME + i6, extractedDex.lastModified());
            i6++;
        }
        edit.commit();
    }
}
