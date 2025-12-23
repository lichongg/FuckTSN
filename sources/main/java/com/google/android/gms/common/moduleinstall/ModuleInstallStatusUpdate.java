package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "ModuleInstallStatusUpdateCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();

    @SafeParcelable.Field(getter = "getSessionId", id = 1)
    private final int zaa;

    @InstallState
    @SafeParcelable.Field(getter = "getInstallState", id = 2)
    private final int zab;

    @Nullable
    @SafeParcelable.Field(getter = "getBytesDownloaded", id = 3)
    private final Long zac;

    @Nullable
    @SafeParcelable.Field(getter = "getTotalBytesToDownload", id = 4)
    private final Long zad;

    @SafeParcelable.Field(getter = "getErrorCode", id = 5)
    private final int zae;

    @Nullable
    private final ProgressInfo zaf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ProgressInfo {
        private final long zaa;
        private final long zab;

        public long getBytesDownloaded() {
            return this.zaa;
        }

        public long getTotalBytesToDownload() {
            return this.zab;
        }

        ProgressInfo(long j6, long j7) {
            Preconditions.checkNotZero(j7);
            this.zaa = j6;
            this.zab = j7;
        }
    }

    public int getErrorCode() {
        return this.zae;
    }

    @InstallState
    public int getInstallState() {
        return this.zab;
    }

    @Nullable
    public ProgressInfo getProgressInfo() {
        return this.zaf;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallStatusUpdate(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) @InstallState int i7, @Nullable @SafeParcelable.Param(id = 3) Long l6, @Nullable @SafeParcelable.Param(id = 4) Long l7, @SafeParcelable.Param(id = 5) int i8) {
        ProgressInfo progressInfo;
        this.zaa = i6;
        this.zab = i7;
        this.zac = l6;
        this.zad = l7;
        this.zae = i8;
        if (l6 != null && l7 != null && l7.longValue() != 0) {
            progressInfo = new ProgressInfo(l6.longValue(), l7.longValue());
        } else {
            progressInfo = null;
        }
        this.zaf = progressInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeInt(parcel, 2, getInstallState());
        SafeParcelWriter.writeLongObject(parcel, 3, this.zac, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zad, false);
        SafeParcelWriter.writeInt(parcel, 5, getErrorCode());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
