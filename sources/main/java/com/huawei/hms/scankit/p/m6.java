package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m6 extends p4 {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f34571c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34572d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34573e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34574f;

    /* renamed from: g, reason: collision with root package name */
    private final int f34575g;

    public m6(int i6, int i7, ByteBuffer byteBuffer) {
        super(i6, i7);
        this.f34572d = i6;
        this.f34573e = i7;
        this.f34574f = 0;
        this.f34575g = 0;
        byte[] array = byteBuffer.array();
        int i8 = i6 * i7;
        this.f34571c = new byte[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9 * 4;
            if ((array[i10 + 3] & 255) == 0) {
                this.f34571c[i9] = -1;
            } else {
                this.f34571c[i9] = (byte) ((((((array[i10] & 255) * MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY) + ((array[i10 + 1] & 255) * MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE)) + ((array[i10 + 2] & 255) * 117)) + 512) >> 10);
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] a(int i6, byte[] bArr) {
        if (i6 < 0 || i6 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i6);
        }
        int c6 = c();
        if (bArr == null || bArr.length < c6) {
            bArr = new byte[c6];
        }
        System.arraycopy(this.f34571c, ((i6 + this.f34575g) * this.f34572d) + this.f34574f, bArr, 0, c6);
        return bArr;
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] b() {
        int c6 = c();
        int a6 = a();
        int i6 = this.f34572d;
        if (c6 == i6 && a6 == this.f34573e) {
            return this.f34571c;
        }
        int i7 = c6 * a6;
        byte[] bArr = new byte[i7];
        int i8 = (this.f34575g * i6) + this.f34574f;
        if (c6 == i6) {
            System.arraycopy(this.f34571c, i8, bArr, 0, i7);
            return bArr;
        }
        for (int i9 = 0; i9 < a6; i9++) {
            System.arraycopy(this.f34571c, i8, bArr, i9 * c6, c6);
            i8 += this.f34572d;
        }
        return bArr;
    }

    @Override // com.huawei.hms.scankit.p.p4
    public p4 a(int i6, int i7, int i8, int i9) {
        return new m6(this.f34571c, this.f34572d, this.f34573e, this.f34574f + i6, this.f34575g + i7, i8, i9);
    }

    private m6(byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11) {
        super(i10, i11);
        if (i10 + i8 <= i6 && i11 + i9 <= i7) {
            this.f34571c = bArr;
            this.f34572d = i6;
            this.f34573e = i7;
            this.f34574f = i8;
            this.f34575g = i9;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
