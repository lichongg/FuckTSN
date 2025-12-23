package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f40624a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f40625b;

    public int a(String str) {
        int length = str.length();
        this.f40624a.add(str);
        return this.f40625b.addAndGet(length);
    }

    public void b() {
        this.f40624a.clear();
        this.f40625b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f40624a.iterator();
    }

    public f() {
        this.f40624a = null;
        this.f40625b = null;
        this.f40624a = new ConcurrentLinkedQueue<>();
        this.f40625b = new AtomicInteger(0);
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i6 = length;
        int i7 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i8 = 0;
            while (length2 > 0) {
                int i9 = i6 > length2 ? length2 : i6;
                int i10 = i8 + i9;
                next.getChars(i8, i10, cArr, i7);
                i6 -= i9;
                i7 += i9;
                length2 -= i9;
                if (i6 == 0) {
                    try {
                        writer.write(cArr, 0, length);
                    } catch (Exception unused) {
                    }
                    i6 = length;
                    i8 = i10;
                    i7 = 0;
                } else {
                    i8 = i10;
                }
            }
        }
        if (i7 > 0) {
            try {
                writer.write(cArr, 0, i7);
            } catch (Exception unused2) {
            }
        }
        try {
            writer.flush();
        } catch (Exception unused3) {
        }
    }

    public int a() {
        return this.f40625b.get();
    }
}
