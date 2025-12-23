package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzd' uses external variables
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
public final class zzax {
    public static final zzax zza;
    public static final zzax zzb;
    public static final zzax zzc;
    public static final zzax zzd;
    public static final zzax zze;
    public static final zzax zzf;
    public static final zzax zzg;
    public static final zzax zzh;
    public static final zzax zzi;
    public static final zzax zzj;
    private static final zzax[] zzk;
    private static final /* synthetic */ zzax[] zzl;
    private final char zzm;
    private final zzaz zzn;
    private final int zzo;
    private final String zzp;

    static {
        zzax zzaxVar = new zzax("STRING", 0, 's', zzaz.GENERAL, "-#", true);
        zza = zzaxVar;
        zzax zzaxVar2 = new zzax("BOOLEAN", 1, 'b', zzaz.BOOLEAN, "-", true);
        zzb = zzaxVar2;
        zzax zzaxVar3 = new zzax("CHAR", 2, 'c', zzaz.CHARACTER, "-", true);
        zzc = zzaxVar3;
        zzaz zzazVar = zzaz.INTEGRAL;
        zzax zzaxVar4 = new zzax("DECIMAL", 3, 'd', zzazVar, "-0+ ,(", false);
        zzd = zzaxVar4;
        zzax zzaxVar5 = new zzax("OCTAL", 4, 'o', zzazVar, "-#0(", false);
        zze = zzaxVar5;
        zzax zzaxVar6 = new zzax("HEX", 5, 'x', zzazVar, "-#0(", true);
        zzf = zzaxVar6;
        zzaz zzazVar2 = zzaz.FLOAT;
        zzax zzaxVar7 = new zzax("FLOAT", 6, 'f', zzazVar2, "-#0+ ,(", false);
        zzg = zzaxVar7;
        zzax zzaxVar8 = new zzax("EXPONENT", 7, 'e', zzazVar2, "-#0+ (", true);
        zzh = zzaxVar8;
        zzax zzaxVar9 = new zzax("GENERAL", 8, 'g', zzazVar2, "-0+ ,(", true);
        zzi = zzaxVar9;
        zzax zzaxVar10 = new zzax("EXPONENT_HEX", 9, 'a', zzazVar2, "-#0+ ", true);
        zzj = zzaxVar10;
        zzl = new zzax[]{zzaxVar, zzaxVar2, zzaxVar3, zzaxVar4, zzaxVar5, zzaxVar6, zzaxVar7, zzaxVar8, zzaxVar9, zzaxVar10};
        zzk = new zzax[26];
        for (zzax zzaxVar11 : values()) {
            zzk[zzf(zzaxVar11.zzm)] = zzaxVar11;
        }
    }

    public static zzax[] values() {
        return (zzax[]) zzl.clone();
    }

    public static zzax zzc(char c6) {
        zzax zzaxVar = zzk[zzf(c6)];
        if ((c6 & ' ') != 0) {
            return zzaxVar;
        }
        if (zzaxVar == null || (zzaxVar.zzo & 128) == 0) {
            return null;
        }
        return zzaxVar;
    }

    private static int zzf(char c6) {
        return (c6 | ' ') - 97;
    }

    public final char zza() {
        return this.zzm;
    }

    final int zzb() {
        return this.zzo;
    }

    public final zzaz zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzp;
    }

    private zzax(String str, int i6, char c6, zzaz zzazVar, String str2, boolean z5) {
        this.zzm = c6;
        this.zzn = zzazVar;
        this.zzo = zzay.zzd(str2, z5);
        this.zzp = "%" + c6;
    }
}
