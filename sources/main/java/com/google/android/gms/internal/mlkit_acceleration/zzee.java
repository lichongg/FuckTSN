package com.google.android.gms.internal.mlkit_acceleration;

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
public final class zzee {
    public static final zzee zza;
    public static final zzee zzb;
    public static final zzee zzc;
    public static final zzee zzd;
    public static final zzee zze;
    public static final zzee zzf;
    public static final zzee zzg;
    public static final zzee zzh;
    public static final zzee zzi;
    public static final zzee zzj;
    private static final /* synthetic */ zzee[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzee zzeeVar = new zzee("VOID", 0, Void.class, Void.class, null);
        zza = zzeeVar;
        Class cls = Integer.TYPE;
        zzee zzeeVar2 = new zzee("INT", 1, cls, Integer.class, 0);
        zzb = zzeeVar2;
        zzee zzeeVar3 = new zzee("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzeeVar3;
        zzee zzeeVar4 = new zzee("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzeeVar4;
        zzee zzeeVar5 = new zzee("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzeeVar5;
        zzee zzeeVar6 = new zzee("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzeeVar6;
        zzee zzeeVar7 = new zzee("STRING", 6, String.class, String.class, "");
        zzg = zzeeVar7;
        zzee zzeeVar8 = new zzee("BYTE_STRING", 7, zzcs.class, zzcs.class, zzcs.zzb);
        zzh = zzeeVar8;
        zzee zzeeVar9 = new zzee("ENUM", 8, cls, Integer.class, null);
        zzi = zzeeVar9;
        zzee zzeeVar10 = new zzee("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzeeVar10;
        zzk = new zzee[]{zzeeVar, zzeeVar2, zzeeVar3, zzeeVar4, zzeeVar5, zzeeVar6, zzeeVar7, zzeeVar8, zzeeVar9, zzeeVar10};
    }

    public static zzee[] values() {
        return (zzee[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }

    private zzee(String str, int i6, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }
}
