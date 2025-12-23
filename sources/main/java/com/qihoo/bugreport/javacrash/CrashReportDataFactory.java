package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.os.Process;
import com.qihoo.jiagu.a;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import com.snail.antifake.deviceid.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes10.dex */
public class CrashReportDataFactory {

    /* renamed from: a, reason: collision with root package name */
    final Calendar f36518a;

    public native String interface9();

    public CrashReportDataFactory(Context context, Calendar calendar) {
        this.f36518a = calendar;
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split(e.f37542d);
        for (int i6 = 0; i6 < split.length; i6++) {
            if (!split[i6].contains(b.f36534b)) {
                stringBuffer.append(split[i6]).append(e.f37542d);
            }
        }
        return stringBuffer.toString();
    }

    static String a(String str, ArrayList<String> arrayList) {
        int i6;
        int i7 = 0;
        if (str == null || arrayList == null) {
            return null;
        }
        String[] split = str.split(e.f37542d);
        int i8 = 0;
        while (true) {
            i6 = i7;
            if (i8 >= split.length - 1) {
                break;
            }
            i7 = split[i8].replaceAll("\t", "").trim().startsWith("Caused by:") ? i8 : i6;
            i8++;
        }
        for (int i9 = i6 + 1; i9 < split.length; i9++) {
            String trim = split[i9].replaceAll("\t", "").trim();
            if (trim.startsWith("at")) {
                trim = trim.substring(2).trim();
            }
            if (arrayList.contains(trim)) {
                return trim;
            }
        }
        return null;
    }

    static HashMap<String, String> a() {
        String readLine;
        HashMap<String, String> hashMap = new HashMap<>();
        int myPid = Process.myPid();
        hashMap.put("ed", Integer.toString(myPid));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + myPid + "/status"))));
            try {
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                        break;
                    } catch (IOException e6) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                        }
                        throw th;
                    }
                } while (!readLine.startsWith("PPid:"));
                break;
                bufferedReader.close();
            } catch (IOException e9) {
            }
            hashMap.put("epd", readLine.substring(readLine.indexOf(":") + 1).replaceFirst("^\\s*", ""));
        } catch (FileNotFoundException e10) {
        }
        return hashMap;
    }

    String b() {
        try {
            return interface9();
        } catch (Throwable th) {
            return null;
        }
    }

    static String c() {
        int indexOf;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + Process.myPid() + "/cmdline"))));
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
                if (readLine != null && (indexOf = readLine.indexOf("\u0000")) >= 0) {
                    return readLine.substring(0, indexOf);
                }
                return null;
            } catch (IOException e7) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e8) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e9) {
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            return null;
        }
    }

    String a(String str, String str2, ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        if (str2 != null) {
            stringBuffer.append(str2);
        }
        List asList = Arrays.asList(a.f36532a);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < arrayList.size()) {
                String str3 = arrayList.get(i7);
                if (!a((List<String>) asList, str3)) {
                    stringBuffer.append(str3);
                }
                i6 = i7 + 1;
            } else {
                return c.a(stringBuffer.toString().getBytes());
            }
        }
    }

    private static boolean a(List<String> list, String str) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (str.startsWith(list.get(i6))) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<String> a(Throwable th) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                arrayList.add(stackTraceElement.toString());
            }
            th = th.getCause();
        }
        return arrayList;
    }

    static String a(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(Long.valueOf(calendar.getTimeInMillis()));
    }
}
