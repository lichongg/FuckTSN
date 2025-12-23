package com.google.mlkit.common.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzq;
import com.google.android.gms.internal.mlkit_common.zzr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class LocalModel {

    @Nullable
    private final String zza;

    @Nullable
    private final String zzb;

    @Nullable
    private final Uri zzc;
    private final boolean zzd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        @Nullable
        private String zza = null;

        @Nullable
        private String zzb = null;

        @Nullable
        private Uri zzc = null;
        private boolean zzd = false;

        @NonNull
        public LocalModel build() {
            String str = this.zza;
            boolean z5 = true;
            if ((str == null || this.zzb != null || this.zzc != null) && ((str != null || this.zzb == null || this.zzc != null) && (str != null || this.zzb != null || this.zzc == null))) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Set one of filePath, assetFilePath and URI.");
            return new LocalModel(this.zza, this.zzb, this.zzc, this.zzd, null);
        }

        @NonNull
        public Builder setAbsoluteFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            boolean z5 = false;
            if (this.zzb == null && this.zzc == null && !this.zzd) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder setAbsoluteManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            boolean z5 = false;
            if (this.zzb == null && this.zzc == null && (this.zza == null || this.zzd)) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zza = str;
            this.zzd = true;
            return this;
        }

        @NonNull
        public Builder setAssetFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            boolean z5 = false;
            if (this.zza == null && this.zzc == null && !this.zzd) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setAssetManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            boolean z5 = false;
            if (this.zza == null && this.zzc == null && (this.zzb == null || this.zzd)) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzb = str;
            this.zzd = true;
            return this;
        }

        @NonNull
        public Builder setUri(@NonNull Uri uri) {
            boolean z5 = false;
            if (this.zza == null && this.zzb == null) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzc = uri;
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        return Objects.equal(this.zza, localModel.zza) && Objects.equal(this.zzb, localModel.zzb) && Objects.equal(this.zzc, localModel.zzc) && this.zzd == localModel.zzd;
    }

    @Nullable
    @KeepForSdk
    public String getAbsoluteFilePath() {
        return this.zza;
    }

    @Nullable
    @KeepForSdk
    public String getAssetFilePath() {
        return this.zzb;
    }

    @Nullable
    @KeepForSdk
    public Uri getUri() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd));
    }

    @KeepForSdk
    public boolean isManifestFile() {
        return this.zzd;
    }

    /* synthetic */ LocalModel(String str, String str2, Uri uri, boolean z5, zzc zzcVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzd = z5;
    }

    @NonNull
    public String toString() {
        zzq zza = zzr.zza(this);
        zza.zza("absoluteFilePath", this.zza);
        zza.zza("assetFilePath", this.zzb);
        zza.zza(ContentProviderManager.PROVIDER_URI, this.zzc);
        zza.zzb("isManifestFile", this.zzd);
        return zza.toString();
    }
}
