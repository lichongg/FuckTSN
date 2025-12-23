package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzlc {
    public static final zzlc zza;
    public static final zzlc zzb;
    public static final zzlc zzc;
    public static final zzlc zzd;
    public static final zzlc zze;
    public static final zzlc zzf;
    public static final zzlc zzg;
    public static final zzlc zzh;
    public static final zzlc zzi;
    public static final zzlc zzj;
    private static final /* synthetic */ zzlc[] zzk;
    private final Class zzl;

    static {
        zzlc zzlcVar = new zzlc("VOID", 0, Void.class, Void.class, null);
        zza = zzlcVar;
        Class cls = Integer.TYPE;
        zzlc zzlcVar2 = new zzlc("INT", 1, cls, Integer.class, 0);
        zzb = zzlcVar2;
        zzlc zzlcVar3 = new zzlc("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzlcVar3;
        zzlc zzlcVar4 = new zzlc("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzlcVar4;
        zzlc zzlcVar5 = new zzlc("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzlcVar5;
        zzlc zzlcVar6 = new zzlc("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzlcVar6;
        zzlc zzlcVar7 = new zzlc("STRING", 6, String.class, String.class, "");
        zzg = zzlcVar7;
        zzlc zzlcVar8 = new zzlc("BYTE_STRING", 7, zzjo.class, zzjo.class, zzjo.zzb);
        zzh = zzlcVar8;
        zzlc zzlcVar9 = new zzlc("ENUM", 8, cls, Integer.class, null);
        zzi = zzlcVar9;
        zzlc zzlcVar10 = new zzlc("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzlcVar10;
        zzk = new zzlc[]{zzlcVar, zzlcVar2, zzlcVar3, zzlcVar4, zzlcVar5, zzlcVar6, zzlcVar7, zzlcVar8, zzlcVar9, zzlcVar10};
    }

    public static zzlc[] values() {
        return (zzlc[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }

    private zzlc(String str, int i6, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }
}
