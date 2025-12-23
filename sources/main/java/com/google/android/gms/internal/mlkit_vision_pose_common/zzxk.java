package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import androidx.annotation.Nullable;
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
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzxk {
    private static final Object zza;
    private final Context zzb;

    static {
        Component.builder(zzxk.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzxj
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzxk((Context) componentContainer.get(Context.class));
            }
        }).build();
        zza = new Object();
    }

    private final File zzc() {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
        if ((noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) && (noBackupFilesDir = this.zzb.getFilesDir()) != null && !noBackupFilesDir.isDirectory()) {
            try {
                if (!noBackupFilesDir.mkdirs()) {
                    noBackupFilesDir.toString();
                }
            } catch (SecurityException unused) {
                "mkdirs threw an exception: ".concat(noBackupFilesDir.toString());
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.RemoteConfig");
    }

    @Nullable
    public final zzwy zza(zzvr zzvrVar) {
        zzwy zzwyVar;
        synchronized (zza) {
            File zzc = zzc();
            zzwyVar = null;
            try {
                String str = new String(new AtomicFile(zzc).readFully(), Charset.forName("UTF-8"));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    try {
                        zzwyVar = new zzwy(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
                    } catch (JSONException unused) {
                        zzvrVar.zzc(zztd.FILE_READ_RETURNED_INVALID_DATA);
                        "Error parsing remote config settings JSON object:\n".concat(jSONObject.toString());
                    }
                } catch (JSONException unused2) {
                    zzvrVar.zzc(zztd.FILE_READ_RETURNED_MALFORMED_DATA);
                    "Error parsing remote config settings JSON string:\n".concat(str);
                }
            } catch (IOException unused3) {
                if (!zzc.exists()) {
                    zzc.toString();
                    return null;
                }
                zzvrVar.zzc(zztd.FILE_READ_FAILED);
                zzc.toString();
                return null;
            }
        }
        return zzwyVar;
    }

    public zzxk(Context context) {
        this.zzb = context;
    }

    public final void zzb(zzwy zzwyVar, zzvr zzvrVar) {
        File file;
        String zzwyVar2 = zzwyVar.toString();
        synchronized (zza) {
            try {
                try {
                    file = zzc();
                } catch (IOException unused) {
                    file = null;
                }
                try {
                    file.toString();
                    AtomicFile atomicFile = new AtomicFile(file);
                    FileOutputStream startWrite = atomicFile.startWrite();
                    try {
                        PrintWriter printWriter = new PrintWriter(startWrite);
                        printWriter.println(zzwyVar2);
                        printWriter.flush();
                        atomicFile.finishWrite(startWrite);
                        file.toString();
                    } catch (Throwable th) {
                        atomicFile.failWrite(startWrite);
                        throw th;
                    }
                } catch (IOException unused2) {
                    zzvrVar.zzc(zztd.FILE_WRITE_FAILED);
                    String.valueOf(file);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
