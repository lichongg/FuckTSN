package com.bytedance.sdk.component.cw.xt.j.m;

import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.j.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface j {

    /* renamed from: j, reason: collision with root package name */
    public static final j f26213j = new j() { // from class: com.bytedance.sdk.component.cw.xt.j.m.j.1
        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public mi j(File file) throws FileNotFoundException {
            return vl.j(file);
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public void j(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public w cw(File file) throws FileNotFoundException {
            try {
                return vl.cw(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return vl.cw(file);
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public void m(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        m(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public boolean r(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public long up(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.m.j
        public w xt(File file) throws FileNotFoundException {
            try {
                return vl.xt(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return vl.xt(file);
            }
        }
    };

    w cw(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    mi j(File file) throws FileNotFoundException;

    void j(File file, File file2) throws IOException;

    void m(File file) throws IOException;

    boolean r(File file);

    long up(File file);

    w xt(File file) throws FileNotFoundException;
}
