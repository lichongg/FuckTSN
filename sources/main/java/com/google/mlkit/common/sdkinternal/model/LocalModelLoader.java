package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import com.kuaishou.weapon.p0.t;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    @NonNull
    @KeepForSdk
    public LocalModel getLocalModel() {
        return this.zzc;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer load() throws MlKitException {
        FileChannel channel;
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        LocalModel localModel = this.zzc;
        String absoluteFilePath = localModel.getAbsoluteFilePath();
        String assetFilePath = localModel.getAssetFilePath();
        Uri uri = localModel.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, t.f36150k);
                try {
                    FileChannel channel2 = randomAccessFile.getChannel();
                    try {
                        this.zza = channel2.map(FileChannel.MapMode.READ_ONLY, 0L, channel2.size());
                        channel2.close();
                        randomAccessFile.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e6) {
                throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.zzc.getAbsoluteFilePath())), 14, e6);
            }
        } else if (assetFilePath != null) {
            try {
                AssetFileDescriptor openFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    channel = new FileInputStream(openFd.getFileDescriptor()).getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                        channel.close();
                        openFd.close();
                    } finally {
                        if (channel == null) {
                            throw th;
                        }
                        try {
                            channel.close();
                            throw th;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                } finally {
                }
            } catch (IOException e7) {
                throw new MlKitException("Can not load the file from asset: " + assetFilePath + ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression", 14, e7);
            }
        } else {
            if (uri == null) {
                throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
            }
            try {
                AssetFileDescriptor zza = zzi.zza(this.zzb, uri, t.f36150k);
                try {
                    channel = zza.createInputStream().getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, zza.getStartOffset(), zza.getLength());
                        channel.close();
                        zza.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e8) {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e8);
            }
        }
        return this.zza;
    }

    @KeepForSdk
    public LocalModelLoader(@NonNull Context context, @NonNull LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }
}
