package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    @SafeParcelable.VersionField(id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private final int zzc;

    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zze;

    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String zzf;

    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final List zzh;

    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String zzi;

    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long zzj;

    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private final int zzk;

    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String zzl;

    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzm;

    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long zzn;

    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzo;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) long j6, @SafeParcelable.Param(id = 11) int i7, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i8, @SafeParcelable.Param(id = 6) @Nullable List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j7, @SafeParcelable.Param(id = 14) int i9, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f6, @SafeParcelable.Param(id = 16) long j8, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z5) {
        this.zza = i6;
        this.zzb = j6;
        this.zzc = i7;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i8;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j7;
        this.zzk = i9;
        this.zzl = str4;
        this.zzm = f6;
        this.zzn = j8;
        this.zzo = z5;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzc() {
        List list = this.zzh;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i6 = this.zzk;
        String str = this.zze;
        String str2 = this.zzl;
        float f6 = this.zzm;
        String str3 = this.zzf;
        int i7 = this.zzg;
        String str4 = this.zzd;
        boolean z5 = this.zzo;
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(i7);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i6);
        sb.append("\t");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("\t");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("\t");
        sb.append(f6);
        sb.append("\t");
        sb.append(str3 != null ? str3 : "");
        sb.append("\t");
        sb.append(z5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
