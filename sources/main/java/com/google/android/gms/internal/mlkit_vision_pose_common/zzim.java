package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.tencent.open.SocialConstants;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzim implements ObjectEncoder {
    static final zzim zza = new zzim();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SocialConstants.PARAM_SOURCE);
        zzci zzciVar = new zzci();
        zzciVar.zza(1);
        builder.withProperty(zzciVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appliedFilter");
        zzci zzciVar2 = new zzci();
        zzciVar2.zza(2);
        builder2.withProperty(zzciVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isAutoCaptureManuallyTriggered");
        zzci zzciVar3 = new zzci();
        zzciVar3.zza(3);
        builder3.withProperty(zzciVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("isRotated");
        zzci zzciVar4 = new zzci();
        zzciVar4.zza(4);
        builder4.withProperty(zzciVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hasLowConfidenceProposedCorners");
        zzci zzciVar5 = new zzci();
        zzciVar5.zza(5);
        builder5.withProperty(zzciVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("autoCaptureTriggerLatencyMs");
        zzci zzciVar6 = new zzci();
        zzciVar6.zza(6);
        builder6.withProperty(zzciVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("galleryImportProcessingMs");
        zzci zzciVar7 = new zzci();
        zzciVar7.zza(7);
        builder7.withProperty(zzciVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("imageWidth");
        zzci zzciVar8 = new zzci();
        zzciVar8.zza(8);
        builder8.withProperty(zzciVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("imageHeight");
        zzci zzciVar9 = new zzci();
        zzciVar9.zza(9);
        builder9.withProperty(zzciVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("proposedCorners");
        zzci zzciVar10 = new zzci();
        zzciVar10.zza(10);
        builder10.withProperty(zzciVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("adjustedCorners");
        zzci zzciVar11 = new zzci();
        zzciVar11.zza(11);
        builder11.withProperty(zzciVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isShadowRemoved");
        zzci zzciVar12 = new zzci();
        zzciVar12.zza(12);
        builder12.withProperty(zzciVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("numOfAppliedCleanUpStrokes");
        zzci zzciVar13 = new zzci();
        zzciVar13.zza(13);
        builder13.withProperty(zzciVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("numOfAttemptedCleanUpStrokes");
        zzci zzciVar14 = new zzci();
        zzciVar14.zza(14);
        builder14.withProperty(zzciVar14.zzb()).build();
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }

    private zzim() {
    }
}
