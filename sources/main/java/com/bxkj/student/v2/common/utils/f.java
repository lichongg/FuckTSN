package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.os.Environment;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.b0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDebugUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugUtils.kt\ncom/bxkj/student/v2/common/utils/DebugUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f20884a = new f();

    public final void b(@NotNull final FragmentActivity context, @NotNull final String databaseName) {
        g0.p(context, "context");
        g0.p(databaseName, "databaseName");
        b0.G(context, "读取文件", new Function0() { // from class: com.bxkj.student.v2.common.utils.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 c6;
                c6 = f.c(FragmentActivity.this, databaseName);
                return c6;
            }
        });
    }

    public final void d(@NotNull Context context, @NotNull String preferencesName) {
        g0.p(context, "context");
        g0.p(preferencesName, "preferencesName");
        String str = "/data/data/" + context.getPackageName() + "/shared_prefs/" + preferencesName + ".xml";
        String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + preferencesName + ".xml";
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                throw new IOException("源 SharedPreferences 文件不存在");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    System.out.getClass();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            e6.getMessage();
            System.out.getClass();
        }
    }

    public final void e(@NotNull FragmentActivity context) {
        g0.p(context, "context");
        b(context, "TSNStudent.db");
        d(context, "share_date");
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 c(FragmentActivity fragmentActivity, String str) {
        File file;
        File file2;
        String path = fragmentActivity.getDatabasePath(str).getPath();
        String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + str;
        try {
            file = new File(path);
            file2 = new File(str2);
        } catch (Exception e6) {
            e6.printStackTrace();
            com.orhanobut.logger.j.e("复制数据库文件时出错: " + com.bxkj.base.v2.common.ext.e.a(e6), new Object[0]);
        }
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            com.orhanobut.logger.j.d("数据库文件已成功复制到 " + str2, new Object[0]);
            return n1.f44123a;
        }
        throw new IOException("源数据库文件不存在");
    }
}
