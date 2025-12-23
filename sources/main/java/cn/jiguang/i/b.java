package cn.jiguang.i;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bz.q;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends a {
    private cn.jiguang.common.app.entity.a a(Context context, String str) {
        Path path;
        BasicFileAttributes readAttributes;
        FileTime lastModifiedTime;
        long millis;
        if (!cn.jiguang.bz.a.h(context, str) || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            path = Paths.get(b(context, str), new String[0]);
            readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) g.a(), new LinkOption[0]);
            lastModifiedTime = readAttributes.lastModifiedTime();
            if (lastModifiedTime != null) {
                cn.jiguang.common.app.entity.a aVar = new cn.jiguang.common.app.entity.a();
                aVar.f2820a = str;
                List<Long> list = aVar.f2824e;
                millis = lastModifiedTime.toMillis();
                list.add(Long.valueOf(millis));
                aVar.f2823d.add(8);
                return aVar;
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // cn.jiguang.i.a
    @TargetApi(16)
    public HashMap<String, cn.jiguang.common.app.entity.a> a(Context context, List<String> list) {
        HashMap<String, cn.jiguang.common.app.entity.a> hashMap = new HashMap<>();
        try {
            HashMap<String, List<String>> a6 = e.a(e.b(context));
            boolean z5 = false;
            boolean z6 = (list == null || list.isEmpty()) ? false : true;
            if (!z6) {
                list = a(context);
                if (list != null && !list.isEmpty()) {
                    z5 = true;
                }
                z6 = z5;
            }
            if (!z6 && a6.isEmpty()) {
                cn.jiguang.an.a.a(context, "app_active", 1);
                cn.jiguang.bb.f.i("CollectByFileModifyDate", "Exception pkgName lst and folder map are empty.");
                return hashMap;
            }
            if (!z6) {
                list = new ArrayList<>(a6.keySet());
            }
            for (String str : list) {
                cn.jiguang.common.app.entity.a a7 = a(context, str);
                if (a7 != null) {
                    hashMap.put(str, a7);
                }
            }
            cn.jiguang.bb.f.c("CollectByFileModifyDate", "collect active data by file completed, appActive size: " + hashMap.size() + ", packageSize: " + list.size());
            return hashMap;
        } catch (Throwable th) {
            cn.jiguang.an.a.a(context, "app_active", -1);
            cn.jiguang.bb.f.i("CollectByFileModifyDate", "collect active failed by modify time, error: " + th.getMessage());
            return hashMap;
        }
    }

    private List<String> a(Context context) {
        if (!cn.jiguang.g.a.a().e(1110)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT <= 28 && (q.a(context, com.kuaishou.weapon.p0.g.f36049i) || q.a(context, com.kuaishou.weapon.p0.g.f36050j))) {
            String o5 = cn.jiguang.d.a.o(context);
            if (!TextUtils.isEmpty(o5)) {
                String[] list = new File(o5).list(new FilenameFilter() { // from class: cn.jiguang.i.b.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        if (!TextUtils.isEmpty(str) && str.matches("^([A-Za-z]{1}[A-Za-z\\d_]*\\.)+[A-Za-z][A-Za-z\\d_]*$")) {
                            return true;
                        }
                        return false;
                    }
                });
                if (list != null && list.length > 0) {
                    arrayList.addAll(Arrays.asList(list));
                }
                cn.jiguang.bb.f.c("CollectByFileModifyDate", "Jpl dataDir is " + o5 + ", pkgNames: " + Arrays.toString(list));
            }
        }
        return arrayList;
    }

    private String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String o5 = cn.jiguang.d.a.o(context);
        if (!TextUtils.isEmpty(o5)) {
            String str2 = o5 + File.separator + str;
            if (new File(str2).exists()) {
                return str2;
            }
        }
        return "";
    }
}
