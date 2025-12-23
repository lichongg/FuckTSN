package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzwz {
    private static final Pattern zza = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzxi zzf;

    /* JADX WARN: Can't wrap try/catch for region: R(13:(3:79|80|81)|82|83|84|85|(1:87)|88|89|(1:91)|92|93|80|81) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:63|(1:65)(3:114|(4:117|(2:120|118)|121|115)|122)|66|67|68|(2:69|(1:71)(1:72))|73|74|75|76|77|(3:79|80|81)|82|83|84|85|(1:87)|88|89|(1:91)|92|93|80|81) */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02af, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0085 A[LOOP:0: B:8:0x007f->B:10:0x0085, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0308 A[Catch: all -> 0x0244, TryCatch #1 {all -> 0x0244, blocks: (B:61:0x0201, B:63:0x0208, B:66:0x0248, B:68:0x024e, B:69:0x0263, B:71:0x026a, B:73:0x0277, B:74:0x0280, B:108:0x02e8, B:109:0x02f7, B:112:0x02f8, B:113:0x0307, B:114:0x020f, B:115:0x021b, B:117:0x0221, B:118:0x0231, B:120:0x0237, B:123:0x0308, B:125:0x0317, B:126:0x0323, B:128:0x0329, B:129:0x0339, B:131:0x033f, B:134:0x034c, B:136:0x0353, B:138:0x0359, B:140:0x036a, B:142:0x0377, B:143:0x0380, B:146:0x0382, B:147:0x0389), top: B:60:0x0201, outer: #11, inners: #2, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0208 A[Catch: all -> 0x0244, TryCatch #1 {all -> 0x0244, blocks: (B:61:0x0201, B:63:0x0208, B:66:0x0248, B:68:0x024e, B:69:0x0263, B:71:0x026a, B:73:0x0277, B:74:0x0280, B:108:0x02e8, B:109:0x02f7, B:112:0x02f8, B:113:0x0307, B:114:0x020f, B:115:0x021b, B:117:0x0221, B:118:0x0231, B:120:0x0237, B:123:0x0308, B:125:0x0317, B:126:0x0323, B:128:0x0329, B:129:0x0339, B:131:0x033f, B:134:0x034c, B:136:0x0353, B:138:0x0359, B:140:0x036a, B:142:0x0377, B:143:0x0380, B:146:0x0382, B:147:0x0389), top: B:60:0x0201, outer: #11, inners: #2, #6, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.internal.mlkit_vision_pose_common.zzxa zza(java.net.HttpURLConnection r12, java.lang.String r13, java.lang.String r14, java.util.Map r15, java.lang.String r16, java.util.Map r17, java.util.Date r18, java.lang.String r19, @androidx.annotation.Nullable java.lang.String r20, com.google.android.gms.internal.mlkit_vision_pose_common.zzvr r21) throws com.google.android.gms.internal.mlkit_vision_pose_common.zzxh {
        /*
            Method dump skipped, instructions count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzwz.zza(java.net.HttpURLConnection, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Date, java.lang.String, java.lang.String, com.google.android.gms.internal.mlkit_vision_pose_common.zzvr):com.google.android.gms.internal.mlkit_vision_pose_common.zzxa");
    }

    public final HttpURLConnection zzb() throws zzxh {
        try {
            return (HttpURLConnection) new URL(String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", this.zze, "firebase")).openConnection();
        } catch (IOException e6) {
            throw new zzxh(e6.getMessage());
        }
    }

    public zzwz(Context context, String str, String str2, String str3, long j6, long j7, zzxi zzxiVar) {
        String str4;
        this.zzb = context;
        this.zzc = str;
        this.zzd = str2;
        Matcher matcher = zza.matcher(str);
        if (matcher.matches()) {
            str4 = matcher.group(1);
        } else {
            str4 = null;
        }
        this.zze = str4;
        this.zzf = zzxiVar;
    }
}
