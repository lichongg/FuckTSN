package com.google.android.gms.internal.mlkit_acceleration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbz {
    private static final Pattern zza = Pattern.compile("(angle_\\(samsung_xclipse_[0-9]*\\)_on_vulkan).*$");

    public static final boolean zza(zzbw zzbwVar, zzby zzbyVar, zzhv zzhvVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("tflite.android_sdk_version", zzbwVar.zza());
        hashMap.put("tflite.device_model", zzbwVar.zzd());
        hashMap.put("tflite.device_name", zzbwVar.zzb());
        hashMap.put("tflite.manufacturer", zzbwVar.zzc());
        hashMap.put("tflite.gpu_model", zzbyVar.zzc());
        hashMap.put("tflite.opengl_es_version", Integer.toString(zzbyVar.zza(), 10) + "." + Integer.toString(zzbyVar.zzb(), 10));
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            int i6 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String replaceAll = ((String) entry.getValue()).replaceAll("[ -]", "_");
            int length = replaceAll.length();
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (zzj.zza(replaceAll.charAt(i6))) {
                    char[] charArray = replaceAll.toCharArray();
                    while (i6 < length) {
                        char c6 = charArray[i6];
                        if (zzj.zza(c6)) {
                            charArray[i6] = (char) (c6 ^ ' ');
                        }
                        i6++;
                    }
                    replaceAll = String.valueOf(charArray);
                } else {
                    i6++;
                }
            }
            if (((String) entry.getKey()).equals("tflite.gpu_model")) {
                replaceAll = zza.matcher(replaceAll).replaceAll("$1");
            }
            entry.setValue(replaceAll);
        }
        zzbu.zza(hashMap, zzhvVar);
        String str = (String) hashMap.get("tflite.gpu.status");
        return str != null && str.equals("SUPPORTED");
    }
}
