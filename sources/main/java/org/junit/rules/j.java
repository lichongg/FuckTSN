package org.junit.rules;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j extends e {

    /* renamed from: a, reason: collision with root package name */
    private final File f51472a;

    /* renamed from: b, reason: collision with root package name */
    private File f51473b;

    public j() {
        this(null);
    }

    private boolean h(int i6, String[] strArr) {
        return i6 == strArr.length - 1;
    }

    public File i() throws IOException {
        return File.createTempFile("junit", null, g());
    }

    public j(File file) {
        this.f51472a = file;
    }

    private File f(File file) throws IOException {
        File createTempFile = File.createTempFile("junit", "", file);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    private void o(String str) throws IOException {
        if (new File(str).getParent() != null) {
            throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
        }
    }

    public void delete() {
        File file = this.f51473b;
        if (file != null) {
            n(file);
        }
    }

    public void e() throws IOException {
        this.f51473b = f(this.f51472a);
    }

    public File g() {
        File file = this.f51473b;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public File j(String str) throws IOException {
        File file = new File(g(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    private void n(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                n(file2);
            }
        }
        file.delete();
    }

    @Override // org.junit.rules.e
    protected void b() {
        delete();
    }

    @Override // org.junit.rules.e
    protected void c() throws Throwable {
        e();
    }

    public File k() throws IOException {
        return f(g());
    }

    public File l(String str) throws IOException {
        return m(str);
    }

    public File m(String... strArr) throws IOException {
        File g6 = g();
        int i6 = 0;
        while (i6 < strArr.length) {
            String str = strArr[i6];
            o(str);
            File file = new File(g6, str);
            if (!file.mkdir() && h(i6, strArr)) {
                throw new IOException("a folder with the name '" + str + "' already exists");
            }
            i6++;
            g6 = file;
        }
        return g6;
    }
}
