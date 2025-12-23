package com.tencent.bugly.crashreport.crash.anr;

import com.snail.antifake.deviceid.e;
import com.tencent.bugly.proguard.al;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TraceFileHelper {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f39661a;

        /* renamed from: b, reason: collision with root package name */
        public String f39662b;

        /* renamed from: c, reason: collision with root package name */
        public long f39663c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f39664d;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean a(long j6);

        boolean a(long j6, long j7, String str);

        boolean a(String str, int i6, String str2, String str3);
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    public static a readFirstDumpInfo(String str, final boolean z5) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i6, String str3, String str4) {
                al.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f39664d == null) {
                    aVar2.f39664d = new HashMap();
                }
                a.this.f39664d.put(str2, new String[]{str3, str4, String.valueOf(i6)});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j6, long j7, String str2) {
                al.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f39661a = j6;
                aVar2.f39662b = str2;
                aVar2.f39663c = j7;
                return z5;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j6) {
                al.c("process end %d", Long.valueOf(j6));
                return false;
            }
        });
        if (aVar.f39661a > 0 && aVar.f39663c > 0 && aVar.f39662b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.f39661a + " " + aVar.f39663c + " " + aVar.f39662b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z5) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i6, String str4, String str5) {
                    al.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.f39661a > 0 && aVar2.f39663c > 0 && aVar2.f39662b != null) {
                        if (aVar2.f39664d == null) {
                            aVar2.f39664d = new HashMap();
                        }
                        a.this.f39664d.put(str3, new String[]{str4, str5, String.valueOf(i6)});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j6, long j7, String str3) {
                    al.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = a.this;
                    aVar2.f39661a = j6;
                    aVar2.f39662b = str3;
                    aVar2.f39663c = j7;
                    return z5;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j6) {
                    al.c("process end %d", Long.valueOf(j6));
                    a aVar2 = a.this;
                    return aVar2.f39661a <= 0 || aVar2.f39663c <= 0 || aVar2.f39662b == null;
                }
            });
            if (aVar.f39661a > 0 && aVar.f39663c > 0 && aVar.f39662b != null) {
                return aVar;
            }
        }
        return null;
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + e.f37542d);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0152, code lost:
    
        if (r17.a(java.lang.Long.parseLong(r1[1].toString().split("\\s")[2])) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0154, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0157, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0158, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x015d, code lost:
    
        if (com.tencent.bugly.proguard.al.a(r0) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readTraceFile(java.lang.String r16, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r17) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < 3; i6++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + e.f37542d);
        }
        return stringBuffer.toString();
    }
}
