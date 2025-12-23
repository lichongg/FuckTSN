package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.util.AtomicFile;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvu {
    private static final Object zza;
    private final Context zzb;

    static {
        Component.builder(zzvu.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzvt
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzvu((Context) componentContainer.get(Context.class));
            }
        }).build();
        zza = new Object();
    }

    @Nullable
    public final zzvv zza(zzvr zzvrVar) {
        zzvv zzvvVar;
        synchronized (zza) {
            try {
                File zzb = zzb(zzvrVar);
                zzvvVar = null;
                try {
                    String str = new String(new AtomicFile(zzb).readFully(), Charset.forName("UTF-8"));
                    try {
                        zzcv zzb2 = zzda.zzb(str);
                        if (zzb2 instanceof zzcy) {
                            zzcy zzb3 = zzb2.zzb();
                            try {
                                zzvvVar = new zzvv(new zzvk(zzb3.zzc("fid").zze()), zzb3.zzc("refreshToken").zze(), zzb3.zzc("temporaryToken").zze(), zzb3.zzc("temporaryTokenExpiryTimestamp").zzc());
                            } catch (ClassCastException | IllegalStateException | NullPointerException unused) {
                                zzvrVar.zzc(zztd.FILE_READ_RETURNED_INVALID_DATA);
                                zzb3.toString();
                            }
                        } else {
                            "Error parsing installation info JSON element:\n".concat(String.valueOf(zzb2));
                            zzvrVar.zzc(zztd.FILE_READ_RETURNED_MALFORMED_DATA);
                        }
                    } catch (zzdc unused2) {
                        "Error parsing installation info JSON object:\n".concat(str);
                        zzvrVar.zzc(zztd.FILE_READ_RETURNED_MALFORMED_DATA);
                    }
                } catch (IOException unused3) {
                    if (!zzb.exists()) {
                        zzb.toString();
                        return null;
                    }
                    zzvrVar.zzc(zztd.FILE_READ_FAILED);
                    zzb.toString();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzvvVar;
    }

    @VisibleForTesting
    final File zzb(zzvr zzvrVar) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
        if ((noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) && (noBackupFilesDir = this.zzb.getFilesDir()) != null && !noBackupFilesDir.isDirectory()) {
            try {
                if (!noBackupFilesDir.mkdirs()) {
                    noBackupFilesDir.toString();
                    zzvrVar.zzd(zztd.DIRECTORY_CREATION_FAILED);
                }
            } catch (SecurityException unused) {
                "mkdirs threw an exception: ".concat(noBackupFilesDir.toString());
                zzvrVar.zzd(zztd.DIRECTORY_CREATION_FAILED);
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.InstallationId");
    }

    public zzvu(Context context) {
        this.zzb = context;
    }

    public final void zzc(zzvv zzvvVar, zzvr zzvrVar) {
        File file;
        String format = String.format("{\n \"fid\": \"%s\",\n \"refreshToken\": \"%s\",\n \"temporaryToken\": \"%s\",\n \"temporaryTokenExpiryTimestamp\": \"%d\"\n}\n", zzvvVar.zzb().zza(), zzvvVar.zzc(), zzvvVar.zzd(), Long.valueOf(zzvvVar.zza()));
        synchronized (zza) {
            try {
                try {
                    file = zzb(zzvrVar);
                    try {
                        file.toString();
                        AtomicFile atomicFile = new AtomicFile(file);
                        FileOutputStream startWrite = atomicFile.startWrite();
                        try {
                            PrintWriter printWriter = new PrintWriter(startWrite);
                            printWriter.println(format);
                            printWriter.flush();
                            atomicFile.finishWrite(startWrite);
                            file.toString();
                        } catch (Throwable th) {
                            atomicFile.failWrite(startWrite);
                            throw th;
                        }
                    } catch (IOException unused) {
                        zzvrVar.zzc(zztd.FILE_WRITE_FAILED);
                        String.valueOf(file);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (IOException unused2) {
                file = null;
            }
        }
    }
}
