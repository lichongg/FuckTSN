package com.google.android.gms.internal.mlkit_acceleration;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
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
public final class zzgt {
    public static final zzgt zza;
    public static final zzgt zzb;
    public static final zzgt zzc;
    public static final zzgt zzd;
    public static final zzgt zze;
    public static final zzgt zzf;
    public static final zzgt zzg;
    public static final zzgt zzh;
    public static final zzgt zzi;
    public static final zzgt zzj;
    public static final zzgt zzk;
    public static final zzgt zzl;
    public static final zzgt zzm;
    public static final zzgt zzn;
    public static final zzgt zzo;
    public static final zzgt zzp;
    public static final zzgt zzq;
    public static final zzgt zzr;
    private static final /* synthetic */ zzgt[] zzs;
    private final zzgu zzt;

    static {
        zzgt zzgtVar = new zzgt("DOUBLE", 0, zzgu.DOUBLE, 1);
        zza = zzgtVar;
        zzgt zzgtVar2 = new zzgt("FLOAT", 1, zzgu.FLOAT, 5);
        zzb = zzgtVar2;
        zzgu zzguVar = zzgu.LONG;
        zzgt zzgtVar3 = new zzgt("INT64", 2, zzguVar, 0);
        zzc = zzgtVar3;
        zzgt zzgtVar4 = new zzgt("UINT64", 3, zzguVar, 0);
        zzd = zzgtVar4;
        zzgu zzguVar2 = zzgu.INT;
        zzgt zzgtVar5 = new zzgt("INT32", 4, zzguVar2, 0);
        zze = zzgtVar5;
        zzgt zzgtVar6 = new zzgt("FIXED64", 5, zzguVar, 1);
        zzf = zzgtVar6;
        zzgt zzgtVar7 = new zzgt("FIXED32", 6, zzguVar2, 5);
        zzg = zzgtVar7;
        zzgt zzgtVar8 = new zzgt("BOOL", 7, zzgu.BOOLEAN, 0);
        zzh = zzgtVar8;
        zzgt zzgtVar9 = new zzgt("STRING", 8, zzgu.STRING, 2);
        zzi = zzgtVar9;
        zzgu zzguVar3 = zzgu.MESSAGE;
        zzgt zzgtVar10 = new zzgt("GROUP", 9, zzguVar3, 3);
        zzj = zzgtVar10;
        zzgt zzgtVar11 = new zzgt("MESSAGE", 10, zzguVar3, 2);
        zzk = zzgtVar11;
        zzgt zzgtVar12 = new zzgt("BYTES", 11, zzgu.BYTE_STRING, 2);
        zzl = zzgtVar12;
        zzgt zzgtVar13 = new zzgt("UINT32", 12, zzguVar2, 0);
        zzm = zzgtVar13;
        zzgt zzgtVar14 = new zzgt("ENUM", 13, zzgu.ENUM, 0);
        zzn = zzgtVar14;
        zzgt zzgtVar15 = new zzgt("SFIXED32", 14, zzguVar2, 5);
        zzo = zzgtVar15;
        zzgt zzgtVar16 = new zzgt("SFIXED64", 15, zzguVar, 1);
        zzp = zzgtVar16;
        zzgt zzgtVar17 = new zzgt("SINT32", 16, zzguVar2, 0);
        zzq = zzgtVar17;
        zzgt zzgtVar18 = new zzgt("SINT64", 17, zzguVar, 0);
        zzr = zzgtVar18;
        zzs = new zzgt[]{zzgtVar, zzgtVar2, zzgtVar3, zzgtVar4, zzgtVar5, zzgtVar6, zzgtVar7, zzgtVar8, zzgtVar9, zzgtVar10, zzgtVar11, zzgtVar12, zzgtVar13, zzgtVar14, zzgtVar15, zzgtVar16, zzgtVar17, zzgtVar18};
    }

    public static zzgt[] values() {
        return (zzgt[]) zzs.clone();
    }

    public final zzgu zza() {
        return this.zzt;
    }

    private zzgt(String str, int i6, zzgu zzguVar, int i7) {
        this.zzt = zzguVar;
    }
}
