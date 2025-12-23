package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.acse.ottn.l3;
import com.snail.antifake.deviceid.e;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzly {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzlw zzlwVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzlwVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i6, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i6, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i6, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i6, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i7 = 1; i7 < str.length(); i7++) {
                char charAt = str.charAt(i7);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzmu.zza(new zzjn(((String) obj).getBytes(zzkz.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzjo) {
            sb.append(": \"");
            sb.append(zzmu.zza((zzjo) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkr) {
            sb.append(" {");
            zzd((zzkr) obj, sb, i6 + 2);
            sb.append(e.f37542d);
            zzc(i6, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i8 = i6 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i8, "key", entry.getKey());
        zzb(sb, i8, "value", entry.getValue());
        sb.append(e.f37542d);
        zzc(i6, sb);
        sb.append("}");
    }

    private static void zzc(int i6, StringBuilder sb) {
        while (i6 > 0) {
            int i7 = 80;
            if (i6 <= 80) {
                i7 = i6;
            }
            sb.append(zza, 0, i7);
            i6 -= i7;
        }
    }

    private static void zzd(zzlw zzlwVar, StringBuilder sb, int i6) {
        int i7;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzlwVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i8 = 0;
        while (true) {
            i7 = 3;
            if (i8 >= length) {
                break;
            }
            Method method3 = declaredMethods[i8];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith(l3.f4738h)) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith(l3.f4736f)) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i8++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i7);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i6, substring.substring(0, substring.length() - 4), zzkr.zzA(method2, zzlwVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i6, substring.substring(0, substring.length() - 3), zzkr.zzA(method, zzlwVar, new Object[0]));
            } else if (hashSet.contains(l3.f4738h.concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey(l3.f4736f.concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzA = zzkr.zzA(method4, zzlwVar, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) zzkr.zzA(method5, zzlwVar, new Object[0])).booleanValue()) {
                        }
                        zzb(sb, i6, substring, zzA);
                    } else if (zzA instanceof Boolean) {
                        if (!((Boolean) zzA).booleanValue()) {
                        }
                        zzb(sb, i6, substring, zzA);
                    } else if (zzA instanceof Integer) {
                        if (((Integer) zzA).intValue() == 0) {
                        }
                        zzb(sb, i6, substring, zzA);
                    } else if (zzA instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) zzA).floatValue()) == 0) {
                        }
                        zzb(sb, i6, substring, zzA);
                    } else if (zzA instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) zzA).doubleValue()) == 0) {
                        }
                        zzb(sb, i6, substring, zzA);
                    } else {
                        if (zzA instanceof String) {
                            equals = zzA.equals("");
                        } else if (zzA instanceof zzjo) {
                            equals = zzA.equals(zzjo.zzb);
                        } else if (zzA instanceof zzlw) {
                            if (zzA == ((zzlw) zzA).zzm()) {
                            }
                            zzb(sb, i6, substring, zzA);
                        } else {
                            if ((zzA instanceof Enum) && ((Enum) zzA).ordinal() == 0) {
                            }
                            zzb(sb, i6, substring, zzA);
                        }
                        if (equals) {
                        }
                        zzb(sb, i6, substring, zzA);
                    }
                }
            }
            i7 = 3;
        }
        if (zzlwVar instanceof zzkn) {
            Iterator zzg = ((zzkn) zzlwVar).zzb.zzg();
            if (zzg.hasNext()) {
                throw null;
            }
        }
        zzmx zzmxVar = ((zzkr) zzlwVar).zzc;
        if (zzmxVar != null) {
            zzmxVar.zzi(sb, i6);
        }
    }
}
