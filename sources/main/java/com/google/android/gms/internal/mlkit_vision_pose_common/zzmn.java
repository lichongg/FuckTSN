package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.umeng.ccg.a;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzmn implements ObjectEncoder {
    static final zzmn zza = new zzmn();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zzci zzciVar = new zzci();
        zzciVar.zza(1);
        zzb = builder.withProperty(zzciVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzci zzciVar2 = new zzci();
        zzciVar2.zza(2);
        zzc = builder2.withProperty(zzciVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzci zzciVar3 = new zzci();
        zzciVar3.zza(3);
        zzd = builder3.withProperty(zzciVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzci zzciVar4 = new zzci();
        zzciVar4.zza(4);
        zze = builder4.withProperty(zzciVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzci zzciVar5 = new zzci();
        zzciVar5.zza(5);
        zzf = builder5.withProperty(zzciVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder(a.f41544t);
        zzci zzciVar6 = new zzci();
        zzciVar6.zza(6);
        zzg = builder6.withProperty(zzciVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(NotificationCompat.CATEGORY_STATUS);
        zzci zzciVar7 = new zzci();
        zzciVar7.zza(7);
        zzh = builder7.withProperty(zzciVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzci zzciVar8 = new zzci();
        zzciVar8.zza(8);
        zzi = builder8.withProperty(zzciVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzci zzciVar9 = new zzci();
        zzciVar9.zza(9);
        zzj = builder9.withProperty(zzciVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzci zzciVar10 = new zzci();
        zzciVar10.zza(10);
        zzk = builder10.withProperty(zzciVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzci zzciVar11 = new zzci();
        zzciVar11.zza(11);
        zzl = builder11.withProperty(zzciVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzci zzciVar12 = new zzci();
        zzciVar12.zza(12);
        zzm = builder12.withProperty(zzciVar12.zzb()).build();
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzuu zzuuVar = (zzuu) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzuuVar.zzb());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zzuuVar.zzc());
        objectEncoderContext2.add(zze, zzuuVar.zze());
        objectEncoderContext2.add(zzf, zzuuVar.zzd());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, zzuuVar.zzg());
        objectEncoderContext2.add(zzi, zzuuVar.zza());
        objectEncoderContext2.add(zzj, zzuuVar.zzf());
        objectEncoderContext2.add(zzk, zzuuVar.zzh());
        objectEncoderContext2.add(zzl, zzuuVar.zzj());
        objectEncoderContext2.add(zzm, zzuuVar.zzi());
    }

    private zzmn() {
    }
}
