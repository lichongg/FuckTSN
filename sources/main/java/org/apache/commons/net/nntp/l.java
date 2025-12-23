package org.apache.commons.net.nntp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class l implements Iterator<String>, Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedReader f50943a;

    /* renamed from: b, reason: collision with root package name */
    private String f50944b;

    /* renamed from: c, reason: collision with root package name */
    private Exception f50945c;

    l(BufferedReader bufferedReader, boolean z5) throws IOException {
        bufferedReader = z5 ? new org.apache.commons.net.io.d(bufferedReader) : bufferedReader;
        this.f50943a = bufferedReader;
        String readLine = bufferedReader.readLine();
        this.f50944b = readLine;
        if (readLine == null) {
            org.apache.commons.net.io.l.a(bufferedReader);
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() throws NoSuchElementException {
        if (this.f50945c != null) {
            throw new NoSuchElementException(this.f50945c.toString());
        }
        String str = this.f50944b;
        if (str == null) {
            throw new NoSuchElementException();
        }
        try {
            String readLine = this.f50943a.readLine();
            this.f50944b = readLine;
            if (readLine != null) {
                return str;
            }
            org.apache.commons.net.io.l.a(this.f50943a);
            return str;
        } catch (IOException e6) {
            this.f50945c = e6;
            org.apache.commons.net.io.l.a(this.f50943a);
            return str;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f50945c == null) {
            return this.f50944b != null;
        }
        throw new NoSuchElementException(this.f50945c.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    l(BufferedReader bufferedReader) throws IOException {
        this(bufferedReader, true);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this;
    }
}
