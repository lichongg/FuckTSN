package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjs implements ObjectEncoder {
    static final zzjs zza = new zzjs();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(CommonNetImpl.NAME);
        zzay zzayVar = new zzay();
        zzayVar.zza(1);
        builder.withProperty(zzayVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("stages");
        zzay zzayVar2 = new zzay();
        zzayVar2.zza(2);
        builder2.withProperty(zzayVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("runMiniBenchmark");
        zzay zzayVar3 = new zzay();
        zzayVar3.zza(3);
        builder3.withProperty(zzayVar3.zzb()).build();
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }

    private zzjs() {
    }
}
