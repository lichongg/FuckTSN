package com.hw.videoprocessor.util;

import android.media.AudioRecord;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private int f35475a;

    /* renamed from: b, reason: collision with root package name */
    private int f35476b;

    /* renamed from: c, reason: collision with root package name */
    private int f35477c;

    /* renamed from: d, reason: collision with root package name */
    private int f35478d;

    /* renamed from: e, reason: collision with root package name */
    private int f35479e;

    public g() {
        this.f35476b = AVMDLDataLoader.KeyIsLiveSetLoaderType;
        this.f35477c = 12;
        this.f35478d = 2;
        this.f35479e = 2;
        this.f35475a = AudioRecord.getMinBufferSize(AVMDLDataLoader.KeyIsLiveSetLoaderType, 12, 2);
    }

    private void b(FileOutputStream fileOutputStream, long j6, long j7, long j8, int i6, long j9) throws IOException {
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j7 & 255), (byte) ((j7 >> 8) & 255), (byte) ((j7 >> 16) & 255), (byte) ((j7 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i6, 0, (byte) (j8 & 255), (byte) ((j8 >> 8) & 255), (byte) ((j8 >> 16) & 255), (byte) ((j8 >> 24) & 255), (byte) (j9 & 255), (byte) ((j9 >> 8) & 255), (byte) ((j9 >> 16) & 255), (byte) ((j9 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (j6 & 255), (byte) ((j6 >> 8) & 255), (byte) ((j6 >> 16) & 255), (byte) ((j6 >> 24) & 255)}, 0, 44);
    }

    public void a(String str, String str2) {
        int i6 = this.f35476b;
        long j6 = i6;
        int i7 = this.f35478d;
        long j7 = ((i6 * 16) * i7) / 8;
        byte[] bArr = new byte[this.f35475a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            b(fileOutputStream, size, size + 36, j6, i7, j7);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public g(int i6, int i7, int i8, int i9) {
        this.f35476b = i6;
        this.f35477c = i7;
        this.f35478d = i8;
        this.f35479e = i9;
        this.f35475a = AudioRecord.getMinBufferSize(i6, i7, i9);
    }
}
