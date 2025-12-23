package com.bxkj.student.run.app.drift;

import android.os.Environment;
import java.io.File;
import java.io.RandomAccessFile;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    File f19785a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile();

    /* renamed from: b, reason: collision with root package name */
    String f19786b = "体适能跑步";

    /* renamed from: c, reason: collision with root package name */
    private String f19787c = new File(this.f19785a, this.f19786b).getPath();

    /* renamed from: d, reason: collision with root package name */
    private String f19788d;

    private void b(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e6) {
            e6.toString();
        }
    }

    public void c(String textContent) {
        a(this.f19787c, this.f19788d);
        String str = this.f19787c + "/" + this.f19788d;
        String str2 = textContent + g.f50795q;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str2.getBytes());
            randomAccessFile.close();
        } catch (Exception e6) {
            e6.toString();
        }
    }

    public b(String fileName) {
        this.f19788d = fileName;
    }

    private File a(String filePath, String fileName) {
        b(filePath);
        File file = null;
        try {
            File file2 = new File(filePath + fileName);
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                    return file2;
                }
                return file2;
            } catch (Exception e6) {
                e = e6;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }
}
