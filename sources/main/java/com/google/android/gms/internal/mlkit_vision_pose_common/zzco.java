package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzco implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final ObjectEncoder zzd;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final ObjectEncoder zzh;
    private final zzcs zzi = new zzcs(this);

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d6) throws IOException {
        zza(fieldDescriptor, d6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("key");
        zzci zzciVar = new zzci();
        zzciVar.zza(1);
        zzb = builder.withProperty(zzciVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzci zzciVar2 = new zzci();
        zzciVar2.zza(2);
        zzc = builder2.withProperty(zzciVar2.zzb()).build();
        zzd = new ObjectEncoder() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzcn
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
                zzco.zzg((Map.Entry) obj, objectEncoderContext);
            }
        };
    }

    static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzcm zzcmVar = (zzcm) fieldDescriptor.getProperty(zzcm.class);
        if (zzcmVar != null) {
            return zzcmVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long zzi(ObjectEncoder objectEncoder, Object obj) throws IOException {
        zzcj zzcjVar = new zzcj();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzcjVar;
            try {
                objectEncoder.encode(obj, this);
                this.zze = outputStream;
                long zza2 = zzcjVar.zza();
                zzcjVar.close();
                return zza2;
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzcjVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static zzcm zzj(FieldDescriptor fieldDescriptor) {
        zzcm zzcmVar = (zzcm) fieldDescriptor.getProperty(zzcm.class);
        if (zzcmVar != null) {
            return zzcmVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final zzco zzl(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z5) throws IOException {
        this.zzi.zza(fieldDescriptor, z5);
        valueEncoder.encode(obj, this.zzi);
        return this;
    }

    private final void zzn(int i6) throws IOException {
        while (true) {
            int i7 = i6 & 127;
            if ((i6 & (-128)) == 0) {
                this.zze.write(i7);
                return;
            } else {
                this.zze.write(i7 | 128);
                i6 >>>= 7;
            }
        }
    }

    private final void zzo(long j6) throws IOException {
        while (true) {
            int i6 = ((int) j6) & 127;
            if (((-128) & j6) == 0) {
                this.zze.write(i6);
                return;
            } else {
                this.zze.write(i6 | 128);
                j6 >>>= 7;
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f6) throws IOException {
        zzb(fieldDescriptor, f6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    final ObjectEncoderContext zza(@NonNull FieldDescriptor fieldDescriptor, double d6, boolean z5) throws IOException {
        if (z5 && d6 == 0.0d) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d6).array());
        return this;
    }

    final ObjectEncoderContext zzb(@NonNull FieldDescriptor fieldDescriptor, float f6, boolean z5) throws IOException {
        if (z5 && f6 == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f6).array());
        return this;
    }

    final ObjectEncoderContext zzc(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z5) throws IOException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z5 || charSequence.length() != 0) {
                    zzn((zzh(fieldDescriptor) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(zza);
                    zzn(bytes.length);
                    this.zze.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    zzc(fieldDescriptor, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    zzk(zzd, fieldDescriptor, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    zza(fieldDescriptor, ((Double) obj).doubleValue(), z5);
                    return this;
                }
                if (obj instanceof Float) {
                    zzb(fieldDescriptor, ((Float) obj).floatValue(), z5);
                    return this;
                }
                if (obj instanceof Number) {
                    zze(fieldDescriptor, ((Number) obj).longValue(), z5);
                    return this;
                }
                if (obj instanceof Boolean) {
                    zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z5);
                    return this;
                }
                if (!(obj instanceof byte[])) {
                    ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
                    if (objectEncoder != null) {
                        zzk(objectEncoder, fieldDescriptor, obj, z5);
                        return this;
                    }
                    ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
                    if (valueEncoder != null) {
                        zzl(valueEncoder, fieldDescriptor, obj, z5);
                        return this;
                    }
                    if (obj instanceof zzck) {
                        zzd(fieldDescriptor, ((zzck) obj).zza(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    zzk(this.zzh, fieldDescriptor, obj, z5);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z5 || bArr.length != 0) {
                    zzn((zzh(fieldDescriptor) << 3) | 2);
                    zzn(bArr.length);
                    this.zze.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    final zzco zzd(@NonNull FieldDescriptor fieldDescriptor, int i6, boolean z5) throws IOException {
        if (!z5 || i6 != 0) {
            zzcm zzj = zzj(fieldDescriptor);
            int ordinal = zzj.zzb().ordinal();
            if (ordinal == 0) {
                zzn(zzj.zza() << 3);
                zzn(i6);
                return this;
            }
            if (ordinal == 1) {
                zzn(zzj.zza() << 3);
                zzn((i6 + i6) ^ (i6 >> 31));
                return this;
            }
            if (ordinal == 2) {
                zzn((zzj.zza() << 3) | 5);
                this.zze.write(zzm(4).putInt(i6).array());
                return this;
            }
        }
        return this;
    }

    final zzco zze(@NonNull FieldDescriptor fieldDescriptor, long j6, boolean z5) throws IOException {
        if (!z5 || j6 != 0) {
            zzcm zzj = zzj(fieldDescriptor);
            int ordinal = zzj.zzb().ordinal();
            if (ordinal == 0) {
                zzn(zzj.zza() << 3);
                zzo(j6);
                return this;
            }
            if (ordinal == 1) {
                zzn(zzj.zza() << 3);
                zzo((j6 >> 63) ^ (j6 + j6));
                return this;
            }
            if (ordinal == 2) {
                zzn((zzj.zza() << 3) | 1);
                this.zze.write(zzm(8).putLong(j6).array());
                return this;
            }
        }
        return this;
    }

    final zzco zzf(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        objectEncoder.encode(obj, this);
        return this;
    }

    zzco(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    private final zzco zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z5) throws IOException {
        long zzi = zzi(objectEncoder, obj);
        if (z5 && zzi == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(zzi);
        objectEncoder.encode(obj, this);
        return this;
    }

    private static ByteBuffer zzm(int i6) {
        return ByteBuffer.allocate(i6).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i6) throws IOException {
        zzd(fieldDescriptor, i6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j6) throws IOException {
        zze(fieldDescriptor, j6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z5) throws IOException {
        zzd(fieldDescriptor, z5 ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, double d6) throws IOException {
        zza(FieldDescriptor.of(str), d6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, int i6) throws IOException {
        zzd(FieldDescriptor.of(str), i6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, long j6) throws IOException {
        zze(FieldDescriptor.of(str), j6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, boolean z5) throws IOException {
        zzd(FieldDescriptor.of(str), z5 ? 1 : 0, true);
        return this;
    }
}
