package com.sun.mail.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    protected int mode;
    protected String name;
    private boolean wrotePrefix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        for (int i8 = 0; i8 < i7; i8++) {
            write(bArr[i6 + i8]);
        }
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS);
    }

    private void encode() throws IOException {
        byte b6;
        ((FilterOutputStream) this).out.write((this.bufsize & 63) + 32);
        int i6 = 0;
        while (true) {
            int i7 = this.bufsize;
            if (i6 >= i7) {
                ((FilterOutputStream) this).out.write(10);
                return;
            }
            byte[] bArr = this.buffer;
            int i8 = i6 + 1;
            byte b7 = bArr[i6];
            byte b8 = 1;
            if (i8 < i7) {
                int i9 = i6 + 2;
                byte b9 = bArr[i8];
                if (i9 < i7) {
                    i6 += 3;
                    b6 = bArr[i9];
                    b8 = b9;
                    int i10 = (b7 >>> 2) & 63;
                    int i11 = ((b7 << 4) & 48) | ((b8 >>> 4) & 15);
                    int i12 = ((b8 << 2) & 60) | ((b6 >>> 6) & 3);
                    int i13 = b6 & Utf8.REPLACEMENT_BYTE;
                    ((FilterOutputStream) this).out.write(i10 + 32);
                    ((FilterOutputStream) this).out.write(i11 + 32);
                    ((FilterOutputStream) this).out.write(i12 + 32);
                    ((FilterOutputStream) this).out.write(i13 + 32);
                } else {
                    b8 = b9;
                    i6 = i9;
                }
            } else {
                i6 = i8;
            }
            b6 = 1;
            int i102 = (b7 >>> 2) & 63;
            int i112 = ((b7 << 4) & 48) | ((b8 >>> 4) & 15);
            int i122 = ((b8 << 2) & 60) | ((b6 >>> 6) & 3);
            int i132 = b6 & Utf8.REPLACEMENT_BYTE;
            ((FilterOutputStream) this).out.write(i102 + 32);
            ((FilterOutputStream) this).out.write(i112 + 32);
            ((FilterOutputStream) this).out.write(i122 + 32);
            ((FilterOutputStream) this).out.write(i132 + 32);
        }
    }

    private void writePrefix() throws IOException {
        if (this.wrotePrefix) {
            return;
        }
        new PrintStream(((FilterOutputStream) this).out).flush();
        this.wrotePrefix = true;
    }

    private void writeSuffix() throws IOException {
        new PrintStream(((FilterOutputStream) this).out).flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.bufsize > 0) {
            writePrefix();
            encode();
        }
        writeSuffix();
        ((FilterOutputStream) this).out.flush();
    }

    public void setNameMode(String str, int i6) {
        this.name = str;
        this.mode = i6;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i6) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.name = str;
        this.mode = i6;
        this.buffer = new byte[45];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        byte[] bArr = this.buffer;
        int i7 = this.bufsize;
        int i8 = i7 + 1;
        this.bufsize = i8;
        bArr[i7] = (byte) i6;
        if (i8 == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }
}
