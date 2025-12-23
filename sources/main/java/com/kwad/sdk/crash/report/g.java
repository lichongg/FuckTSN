package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.utils.w;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends d {
    public static final Pattern aQs = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aQt = Pattern.compile("\\sd+\\spc");

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        r0 = r5.group(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        r4.setSignal(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r0 = r5.group(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        r4.setCode(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        r0 = r5.group(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r4.setFaultAddr(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r0.equals("--------") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        r4.setManuallyKill(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        r0 = r5.group(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        r4.setThreadName(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        r5 = r5.group(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r5 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        r4.setTid(java.lang.Integer.parseInt(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r4, java.io.File r5) {
        /*
            r3 = this;
            boolean r0 = r5.exists()
            if (r0 != 0) goto L8
            goto L7d
        L8:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.io.IOException -> L3b
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.IOException -> L3b
            r1.<init>(r5)     // Catch: java.io.IOException -> L3b
            r0.<init>(r1)     // Catch: java.io.IOException -> L3b
        L12:
            java.lang.String r5 = r0.readLine()     // Catch: java.io.IOException -> L3b
            if (r5 == 0) goto L7d
            java.lang.String r1 = "Fatal signal (\\d+) \\((\\w+)\\), code (-*\\d+) \\((\\w+)\\), fault addr (-*\\w*) in tid (\\d+) \\((.*)\\), pid (\\d+).*"
            java.util.regex.Pattern r1 = r3.fP(r1)     // Catch: java.io.IOException -> L3b
            java.util.regex.Matcher r5 = r1.matcher(r5)     // Catch: java.io.IOException -> L3b
            boolean r1 = r5.lookingAt()     // Catch: java.io.IOException -> L3b
            if (r1 == 0) goto L12
            int r1 = r5.groupCount()     // Catch: java.io.IOException -> L3b
            r2 = 8
            if (r1 < r2) goto L12
            r0 = 2
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L3d
            r4.setSignal(r0)     // Catch: java.io.IOException -> L3b
            goto L3d
        L3b:
            r4 = move-exception
            goto L7e
        L3d:
            r0 = 4
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L47
            r4.setCode(r0)     // Catch: java.io.IOException -> L3b
        L47:
            r0 = 5
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L65
            r4.setFaultAddr(r0)     // Catch: java.io.IOException -> L3b
            java.lang.String r1 = "--------"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L5c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.io.IOException -> L3b
            goto L5e
        L5c:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.io.IOException -> L3b
        L5e:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L3b
            r4.setManuallyKill(r0)     // Catch: java.io.IOException -> L3b
        L65:
            r0 = 7
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L6f
            r4.setThreadName(r0)     // Catch: java.io.IOException -> L3b
        L6f:
            r0 = 6
            java.lang.String r5 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r5 == 0) goto L7d
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.io.IOException -> L3b
            r4.setTid(r5)     // Catch: java.io.IOException -> L3b
        L7d:
            return
        L7e:
            r4.printStackTrace()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r3.mErrorMessage
            r5.append(r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = "\n"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.mErrorMessage = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File):void");
    }

    private NativeExceptionMessage E(File file) {
        String str;
        try {
            str = w.W(file);
        } catch (IOException e6) {
            this.mErrorMessage += e6 + com.snail.antifake.deviceid.e.f37542d;
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e7) {
                this.mErrorMessage += e7 + com.snail.antifake.deviceid.e.f37542d;
            }
        }
        w.U(file);
        return nativeExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) {
        File file6 = new File(file5, "java_backtrace");
        new File(file5, "all_java_backtrace");
        File file7 = new File(file5, "maps");
        NativeExceptionMessage E = E(file2);
        try {
            a(E, file, file6, file7, false);
            if (E.mTid == 0) {
                a(E, new File(file5, "debug"));
            }
            File file8 = new File(file5, ".minfo");
            if (file8.exists()) {
                E.mDumpsys = w.W(file8);
            } else {
                com.kwad.sdk.core.d.c.w("NativeCrashReporter", "memory file not exist:" + file8.getName());
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w("NativeCrashReporter", Log.getStackTraceString(e6));
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            this.mErrorMessage += e6 + com.snail.antifake.deviceid.e.f37542d;
        }
        TextUtils.isEmpty(this.mErrorMessage);
        return E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r17, java.io.File r18, java.io.File r19, java.io.File r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File, java.io.File, java.io.File, boolean):void");
    }

    private void a(String str, BufferedReader bufferedReader, NativeExceptionMessage nativeExceptionMessage) {
        StringBuilder sb = new StringBuilder();
        Backtrace backtrace = new Backtrace();
        StringBuilder sb2 = new StringBuilder();
        Backtrace backtrace2 = new Backtrace();
        boolean startsWith = str.startsWith(SocializeProtocolConstants.PROTOCOL_KEY_DE);
        if (startsWith) {
            sb2.append(str);
            sb2.append(com.snail.antifake.deviceid.e.f37542d);
        } else {
            sb.append(str);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || TextUtils.isEmpty(readLine)) {
                break;
            } else {
                a(readLine, startsWith ? backtrace2 : backtrace);
            }
        }
        if (startsWith) {
            nativeExceptionMessage.setGwpAsanDeallocationThread(sb2.toString());
            nativeExceptionMessage.setGwpAsanDeallocationBacktrace(backtrace2.toJson().toString());
        } else {
            nativeExceptionMessage.setGwpAsanAllocationThread(sb.toString());
            nativeExceptionMessage.setGwpAsanAllocationBacktrace(backtrace.toJson().toString());
        }
    }

    private void a(String str, Backtrace backtrace) {
        String group;
        if (backtrace.mFrame > 256) {
            return;
        }
        NativeBackTraceElement nativeBackTraceElement = new NativeBackTraceElement(str, backtrace.mFrame);
        Matcher matcher = fP(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+\\.so)(?:\\s+\\(offset\\s+\\w+\\))?(?:\\s+\\((.*?)\\+\\d+\\))?(\\s+\\(BuildId:\\s+(\\b\\w+)\\))?").matcher(str);
        Matcher matcher2 = fP(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+)\\s+\\((.*?)\\+\\d+\\)\\s+\\(BuildId:\\s+(\\b\\w+)\\)").matcher(str);
        Matcher matcher3 = fP(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*-cache.*\\(offset\\s+\\w+\\)\\s+\\((.*?)\\+\\d+\\)").matcher(str);
        if (matcher.lookingAt() && matcher.groupCount() >= 5) {
            nativeBackTraceElement.setPc(matcher.group(1));
            nativeBackTraceElement.setFileName(matcher.group(2));
            String group2 = matcher.group(3);
            if (!TextUtils.isEmpty(group2)) {
                if (fP(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*").matcher(group2).lookingAt()) {
                    nativeBackTraceElement.setNeedClustering(false);
                    return;
                }
                Matcher matcher4 = fP("[^\\[(<\\]]+").matcher(group2);
                if (matcher4.lookingAt()) {
                    Matcher matcher5 = fP(".*(\\b\\w+)").matcher(matcher4.group());
                    if (matcher5.lookingAt() && matcher.groupCount() > 0 && (group = matcher5.group(1)) != null) {
                        nativeBackTraceElement.setMethodName(group);
                    }
                }
                if (nativeBackTraceElement.getMethodName() == null) {
                    nativeBackTraceElement.setMethodName(group2);
                }
            }
            String group3 = matcher.group(5);
            if (group3 != null) {
                nativeBackTraceElement.setBuildId(group3);
            }
        } else if (matcher2.lookingAt() && matcher2.groupCount() >= 4) {
            nativeBackTraceElement.setPc(matcher2.group(1));
            nativeBackTraceElement.setFileName(matcher2.group(2));
            String group4 = matcher2.group(3);
            if (group4 != null) {
                nativeBackTraceElement.setMethodName(group4);
            }
            String group5 = matcher2.group(4);
            if (group5 != null) {
                nativeBackTraceElement.setBuildId(group5);
            }
        } else {
            if (!matcher3.lookingAt() || matcher3.groupCount() < 2) {
                return;
            }
            nativeBackTraceElement.setPc(matcher3.group(1));
            nativeBackTraceElement.setFileName("jit-code-cache");
            String group6 = matcher3.group(2);
            if (group6 != null) {
                nativeBackTraceElement.setMethodName(group6);
            }
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(nativeBackTraceElement);
    }

    private static void a(BufferedReader bufferedReader, File file) {
        boolean exists = file.exists();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.startsWith("---")) {
                return;
            }
            if (!exists) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(readLine);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }
    }

    private static void a(BufferedReader bufferedReader, ExceptionMessage exceptionMessage) {
        boolean z5 = false;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (!z5 && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                z5 = true;
            } else if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                if (readLine.contains("dvm_lock_sample")) {
                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                        exceptionMessage.mLockInfo = readLine + com.snail.antifake.deviceid.e.f37542d;
                    } else {
                        exceptionMessage.mLockInfo += readLine + com.snail.antifake.deviceid.e.f37542d;
                    }
                } else if (readLine.contains("Long monitor")) {
                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                        exceptionMessage.mMonitorInfo = readLine + com.snail.antifake.deviceid.e.f37542d;
                    } else {
                        exceptionMessage.mMonitorInfo += readLine + com.snail.antifake.deviceid.e.f37542d;
                    }
                } else if (readLine.contains("Slow Looper")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                        exceptionMessage.mSlowLooper = readLine + com.snail.antifake.deviceid.e.f37542d;
                    } else {
                        exceptionMessage.mSlowLooper += readLine + com.snail.antifake.deviceid.e.f37542d;
                    }
                } else if (readLine.contains("Slow Operation")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                        exceptionMessage.mSlowOperation = readLine + com.snail.antifake.deviceid.e.f37542d;
                    } else {
                        exceptionMessage.mSlowOperation += readLine + com.snail.antifake.deviceid.e.f37542d;
                    }
                }
            } else if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                exceptionMessage.mGCInfo = readLine + com.snail.antifake.deviceid.e.f37542d;
            } else {
                exceptionMessage.mGCInfo += readLine + com.snail.antifake.deviceid.e.f37542d;
            }
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < split.length; i9++) {
                    if ("name:".equals(split[i9])) {
                        i6 = i9;
                    } else if (">>>".equals(split[i9])) {
                        i7 = i9;
                    } else if ("<<<".equals(split[i9])) {
                        i8 = i9;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                int i10 = i6 + 1;
                sb2.append(split[i10]);
                while (true) {
                    i10++;
                    if (i10 >= i7) {
                        break;
                    }
                    sb2.append(" ");
                    sb2.append(split[i10]);
                }
                nativeExceptionMessage.mThreadName = sb2.toString();
                sb2.setLength(0);
                int i11 = i7 + 1;
                sb2.append(split[i11]);
                while (true) {
                    i11++;
                    if (i11 < i8) {
                        sb2.append(" ");
                        sb2.append(split[i11]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb2.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.fV(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.fV(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb.append(str);
            sb.append('\n');
        }
    }
}
