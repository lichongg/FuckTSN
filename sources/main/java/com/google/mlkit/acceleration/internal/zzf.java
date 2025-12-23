package com.google.mlkit.acceleration.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.util.AtomicFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzf {
    private static final Lock zza = new ReentrantLock();
    private final Context zzb;
    private final String zzc;

    @Nullable
    private File zzd;

    @Nullable
    private File zze;
    private boolean zzf;

    @Nullable
    private FileOutputStream zzg;

    @Nullable
    final File zza() {
        if (!this.zzf) {
            File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
            if ((noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) && (noBackupFilesDir = this.zzb.getFilesDir()) != null && !noBackupFilesDir.isDirectory()) {
                try {
                } catch (SecurityException unused) {
                    if (Log.isLoggable("LockableAtomicFile", 5)) {
                        "mkdirs threw an exception: ".concat(noBackupFilesDir.toString());
                    }
                }
                if (!noBackupFilesDir.mkdirs()) {
                    if (Log.isLoggable("LockableAtomicFile", 5)) {
                        noBackupFilesDir.toString();
                    }
                    noBackupFilesDir = null;
                }
            }
            if (noBackupFilesDir == null) {
                this.zzd = null;
                this.zze = null;
            } else {
                this.zzd = new File(noBackupFilesDir, this.zzc);
                this.zze = new File(noBackupFilesDir, String.valueOf(this.zzc).concat(".lock"));
            }
            this.zzf = true;
            if (Log.isLoggable("LockableAtomicFile", 3)) {
                "file initialized: ".concat(String.valueOf(this.zzd));
            }
        }
        return this.zzd;
    }

    zzf(Context context, String str) {
        this.zzb = context;
        this.zzc = str;
    }

    final void zzb() {
        if (zza() == null) {
            return;
        }
        zza.lock();
        try {
            File file = this.zze;
            if (file != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.zzg = fileOutputStream;
                fileOutputStream.getChannel().lock();
                return;
            }
            throw null;
        } catch (IOException e6) {
            zzd();
            throw new IllegalStateException(e6);
        }
    }

    final void zzc(byte[] bArr) {
        if (zza() != null) {
            File zza2 = zza();
            zza2.getClass();
            AtomicFile atomicFile = new AtomicFile(zza2);
            try {
                FileOutputStream startWrite = atomicFile.startWrite();
                try {
                    startWrite.write(bArr);
                    atomicFile.finishWrite(startWrite);
                    if (Log.isLoggable("LockableAtomicFile", 3)) {
                        String.valueOf(this.zzd);
                    }
                } catch (Throwable th) {
                    atomicFile.failWrite(startWrite);
                    String.valueOf(this.zzd);
                    throw th;
                }
            } catch (IOException unused) {
                "Failed to save to ".concat(String.valueOf(this.zzd));
            }
        }
    }

    final void zzd() {
        if (zza() == null) {
            return;
        }
        try {
            try {
                FileOutputStream fileOutputStream = this.zzg;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e6) {
                throw new IllegalStateException(e6);
            }
        } finally {
            this.zzg = null;
            zza.unlock();
        }
    }

    @Nullable
    final byte[] zze() {
        if (zza() == null) {
            return null;
        }
        try {
            File zza2 = zza();
            if (zza2 != null) {
                FileInputStream fileInputStream = new FileInputStream(zza2);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    int i6 = 0;
                    while (true) {
                        int length = bArr.length;
                        int read = fileInputStream.read(bArr, i6, length - i6);
                        if (read <= 0) {
                            fileInputStream.close();
                            return bArr;
                        }
                        i6 += read;
                        int available = fileInputStream.available();
                        if (available > length - i6) {
                            byte[] bArr2 = new byte[available + i6];
                            System.arraycopy(bArr, 0, bArr2, 0, i6);
                            bArr = bArr2;
                        }
                    }
                } finally {
                }
            } else {
                throw null;
            }
        } catch (IOException unused) {
            "Failed to read from file: ".concat(String.valueOf(this.zzd));
            return null;
        }
    }
}
