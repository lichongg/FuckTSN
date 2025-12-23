package com.kwad.sdk.crash.utils;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = 4424285024471074820L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) {
        if (cArr != null) {
            this.builder.append(cArr, i6, i7);
        }
    }

    public StringBuilderWriter(int i6) {
        this.builder = new StringBuilder(i6);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c6) {
        this.builder.append(c6);
        return this;
    }

    public StringBuilderWriter(StringBuilder sb) {
        this.builder = sb == null ? new StringBuilder() : sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i6, int i7) {
        this.builder.append(charSequence, i6, i7);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
