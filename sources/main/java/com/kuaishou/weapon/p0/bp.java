package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bp {
    public static boolean a(Context context, String str) {
        try {
            String str2 = Engine.soPath;
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("/lib");
            sb.append(str);
            return new File(sb.toString()).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static List<File> a(File file, final String str, int i6) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kuaishou.weapon.p0.bp.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    if (file2.isDirectory() || file2.getName().toLowerCase().contains(str)) {
                        return true;
                    }
                    return false;
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                int i7 = 0;
                while (i7 < length) {
                    File file2 = listFiles[i7];
                    if (file2.isFile()) {
                        arrayList.add(file2);
                        return arrayList;
                    }
                    int i8 = i6 + 1;
                    arrayList.addAll(a(file2, str, i6));
                    i7++;
                    i6 = i8;
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static int a(String[] strArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < strArr.length; i7++) {
            try {
                if (new File(strArr[i7]).exists()) {
                    i6 |= 1 << i7;
                }
            } catch (Exception unused) {
            }
        }
        return i6;
    }
}
