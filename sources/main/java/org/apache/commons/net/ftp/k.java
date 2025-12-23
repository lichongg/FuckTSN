package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f50670a;

    /* renamed from: b, reason: collision with root package name */
    private ListIterator<String> f50671b;

    /* renamed from: c, reason: collision with root package name */
    private final f f50672c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f50673d;

    public k(f fVar) {
        this(fVar, null);
    }

    @Deprecated
    public void g(InputStream inputStream) throws IOException {
        h(inputStream, null);
    }

    k(f fVar, d dVar) {
        LinkedList linkedList = new LinkedList();
        this.f50670a = linkedList;
        this.f50671b = linkedList.listIterator();
        this.f50672c = fVar;
        if (dVar != null) {
            this.f50673d = dVar.i();
        } else {
            this.f50673d = false;
        }
    }

    private void i(InputStream inputStream, String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, org.apache.commons.net.util.b.a(str)));
        String b6 = this.f50672c.b(bufferedReader);
        while (b6 != null) {
            this.f50670a.add(b6);
            b6 = this.f50672c.b(bufferedReader);
        }
        bufferedReader.close();
    }

    public FTPFile[] a() throws IOException {
        return b(i.f50668b);
    }

    public FTPFile[] b(h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f50670a) {
            FTPFile a6 = this.f50672c.a(str);
            if (a6 == null && this.f50673d) {
                a6 = new FTPFile(str);
            }
            if (hVar.a(a6)) {
                arrayList.add(a6);
            }
        }
        return (FTPFile[]) arrayList.toArray(new FTPFile[arrayList.size()]);
    }

    public FTPFile[] c(int i6) {
        LinkedList linkedList = new LinkedList();
        while (i6 > 0 && this.f50671b.hasNext()) {
            String next = this.f50671b.next();
            FTPFile a6 = this.f50672c.a(next);
            if (a6 == null && this.f50673d) {
                a6 = new FTPFile(next);
            }
            linkedList.add(a6);
            i6--;
        }
        return (FTPFile[]) linkedList.toArray(new FTPFile[linkedList.size()]);
    }

    public FTPFile[] d(int i6) {
        LinkedList linkedList = new LinkedList();
        while (i6 > 0 && this.f50671b.hasPrevious()) {
            String previous = this.f50671b.previous();
            FTPFile a6 = this.f50672c.a(previous);
            if (a6 == null && this.f50673d) {
                a6 = new FTPFile(previous);
            }
            linkedList.add(0, a6);
            i6--;
        }
        return (FTPFile[]) linkedList.toArray(new FTPFile[linkedList.size()]);
    }

    public boolean e() {
        return this.f50671b.hasNext();
    }

    public boolean f() {
        return this.f50671b.hasPrevious();
    }

    public void h(InputStream inputStream, String str) throws IOException {
        this.f50670a = new LinkedList();
        i(inputStream, str);
        this.f50672c.d(this.f50670a);
        j();
    }

    public void j() {
        this.f50671b = this.f50670a.listIterator();
    }
}
