package com.hw.videoprocessor.util;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Pair;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kuaishou.weapon.p0.t;
import com.tencent.bugly.BuglyStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Integer> f35440a;

    /* renamed from: b, reason: collision with root package name */
    static final String f35441b = "VideoProcessor";

    /* renamed from: c, reason: collision with root package name */
    public static int f35442c;

    private static float m(@IntRange(from = 0, to = 100) int i6) {
        return (i6 / 100.0f) * f35442c;
    }

    public static void q(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.f36150k);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    long j6 = 2;
                    byte[] bArr = new byte[2];
                    for (long length = randomAccessFile2.length() - j6; length >= 0; length -= j6) {
                        randomAccessFile2.seek(length);
                        randomAccessFile2.read(bArr);
                        fileOutputStream.write(bArr);
                    }
                    randomAccessFile2.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void r(String str, String str2) throws IOException {
        s(str, str2, 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bd, code lost:
    
        if (r12 > r42.intValue()) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0148 A[Catch: all -> 0x0131, TryCatch #9 {all -> 0x0131, blocks: (B:10:0x0086, B:23:0x0148, B:27:0x015c, B:32:0x0178, B:33:0x0194, B:47:0x01a1, B:49:0x01c8, B:74:0x012a), top: B:9:0x0086 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void v(android.content.Context r37, android.media.MediaExtractor r38, android.media.MediaMuxer r39, int r40, java.lang.Integer r41, java.lang.Integer r42, @androidx.annotation.NonNull java.lang.Float r43, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r44) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.v(android.content.Context, android.media.MediaExtractor, android.media.MediaMuxer, int, java.lang.Integer, java.lang.Integer, java.lang.Float, com.hw.videoprocessor.util.k):void");
    }

    static {
        HashMap hashMap = new HashMap();
        f35440a = hashMap;
        hashMap.put(96000, 0);
        hashMap.put(88200, 1);
        hashMap.put(64000, 2);
        hashMap.put(48000, 3);
        hashMap.put(44100, 4);
        hashMap.put(32000, 5);
        hashMap.put(24000, 6);
        hashMap.put(22050, 7);
        hashMap.put(16000, 8);
        hashMap.put(12000, 9);
        hashMap.put(11025, 10);
        hashMap.put(Integer.valueOf(AVMDLDataLoader.KeyIsLiveSetLoaderType), 11);
        hashMap.put(7350, 12);
        f35442c = 1;
    }

    public static void a(Context context, String str, String str2, @IntRange(from = 0, to = 100) int i6, @Nullable k kVar) throws IOException {
        String name = new File(str).getName();
        File file = new File(com.hw.videoprocessor.i.h(context), name + ".pcm");
        File file2 = new File(com.hw.videoprocessor.i.h(context), name + "_2.pcm");
        File file3 = new File(com.hw.videoprocessor.i.h(context), name + ".wav");
        g(str, file.getAbsolutePath(), null, null);
        b(file.getAbsolutePath(), file2.getAbsolutePath(), i6);
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(com.hw.videoprocessor.i.k(mediaExtractor, true));
        int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        new g(integer, integer2 == 2 ? 12 : 16, integer2, 2).a(file2.getAbsolutePath(), file3.getAbsolutePath());
        h(file3.getPath(), str2, trackFormat, kVar);
    }

    public static void b(String str, String str2, @IntRange(from = 0, to = 100) int i6) throws IOException {
        if (i6 == 100) {
            f(str, str2);
            return;
        }
        float m6 = m(i6);
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        while (fileInputStream.read(bArr) != -1) {
            try {
                for (int i7 = 0; i7 < 2048; i7 += 2) {
                    int i8 = i7 + 1;
                    int i9 = (int) (((short) ((bArr[i7] & 255) | ((bArr[i8] & 255) << 8))) * m6);
                    if (i9 > 32767) {
                        i9 = 32767;
                    } else if (i9 < -32768) {
                        i9 = -32768;
                    }
                    bArr[i7] = (byte) (i9 & 255);
                    bArr[i8] = (byte) ((i9 >>> 8) & 255);
                }
                fileOutputStream.write(bArr);
            } catch (Throwable th) {
                fileInputStream.close();
                fileOutputStream.close();
                throw th;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static Pair<Integer, Integer> c(String str, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i6;
        int i7 = 1;
        int integer = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int integer2 = mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int integer3 = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : 44100;
        int integer4 = mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) ? mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : 44100;
        if (integer == integer2 && integer3 == integer4 && integer <= 2) {
            return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
        }
        File file = new File(str + ".temp");
        File file2 = new File(str2 + ".temp");
        if (integer != integer2 || integer > 2 || integer2 > 2) {
            if (integer > 1) {
                try {
                    try {
                        s(str, file.getAbsolutePath(), integer);
                        File file3 = new File(str);
                        file3.delete();
                        file.renameTo(file3);
                        i6 = 1;
                    } catch (Exception e6) {
                        e = e6;
                        c.g(e);
                        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair;
                    }
                } catch (Throwable th) {
                    file.delete();
                    file2.exists();
                    throw th;
                }
            } else {
                i6 = integer;
            }
            if (integer2 > 1) {
                s(str2, file2.getAbsolutePath(), integer2);
                File file4 = new File(str2);
                file4.delete();
                file2.renameTo(file4);
                integer2 = 1;
            }
            integer = i6;
        } else {
            i7 = integer;
        }
        if (integer3 != integer4) {
            try {
                int min = Math.min(integer3, integer4);
                if (integer3 != min) {
                    try {
                        n(str, file.getAbsolutePath(), integer3, min, integer);
                        File file5 = new File(str);
                        file5.delete();
                        file.renameTo(file5);
                    } catch (Exception e7) {
                        e = e7;
                        integer3 = min;
                        integer = i7;
                        c.g(e);
                        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair2;
                    }
                }
                if (integer4 != min) {
                    n(str2, file2.getAbsolutePath(), integer4, min, integer2);
                    File file6 = new File(str2);
                    file6.delete();
                    file2.renameTo(file6);
                }
                integer3 = min;
            } catch (Exception e8) {
                e = e8;
            }
        }
        Pair<Integer, Integer> pair3 = new Pair<>(Integer.valueOf(i7), Integer.valueOf(integer3));
        file.delete();
        file2.exists();
        return pair3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:36:0x00b4, B:25:0x00bd, B:27:0x00c2, B:29:0x00c7), top: B:35:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c2 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:36:0x00b4, B:25:0x00bd, B:27:0x00c2, B:29:0x00c7), top: B:35:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7 A[Catch: IOException -> 0x00b8, TRY_LEAVE, TryCatch #2 {IOException -> 0x00b8, blocks: (B:36:0x00b4, B:25:0x00bd, B:27:0x00c2, B:29:0x00c7), top: B:35:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc A[Catch: IOException -> 0x00d7, TryCatch #1 {IOException -> 0x00d7, blocks: (B:55:0x00d3, B:42:0x00dc, B:44:0x00e1, B:46:0x00e6), top: B:54:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[Catch: IOException -> 0x00d7, TryCatch #1 {IOException -> 0x00d7, blocks: (B:55:0x00d3, B:42:0x00dc, B:44:0x00e1, B:46:0x00e6), top: B:54:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6 A[Catch: IOException -> 0x00d7, TRY_LEAVE, TryCatch #1 {IOException -> 0x00d7, blocks: (B:55:0x00d3, B:42:0x00dc, B:44:0x00e1, B:46:0x00e6), top: B:54:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File d(java.io.File r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.d(java.io.File, int, int):java.io.File");
    }

    public static void e(MediaFormat mediaFormat, int i6, int i7, int i8) {
        Map<Integer, Integer> map = f35440a;
        int intValue = map.containsKey(Integer.valueOf(i7)) ? map.get(Integer.valueOf(i7)).intValue() : 4;
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i6 << 3) | (intValue >> 1)));
        allocate.put(1, (byte) (((intValue & 1) << 7) | (i8 << 3)));
        mediaFormat.setByteBuffer("csd-0", allocate);
    }

    public static void f(String str, String str2) throws IOException {
        FileChannel channel = new FileOutputStream(str2).getChannel();
        FileChannel channel2 = new FileInputStream(str).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0112 A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:19:0x00a3, B:22:0x0112, B:29:0x011e, B:33:0x013f, B:34:0x0156, B:37:0x017e, B:38:0x015d, B:49:0x008e, B:52:0x009a, B:58:0x00e9), top: B:18:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:19:0x00a3, B:22:0x0112, B:29:0x011e, B:33:0x013f, B:34:0x0156, B:37:0x017e, B:38:0x015d, B:49:0x008e, B:52:0x009a, B:58:0x00e9), top: B:18:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0181 -> B:21:0x0110). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.Integer r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.g(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(java.lang.String r31, java.lang.String r32, android.media.MediaFormat r33, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.h(java.lang.String, java.lang.String, android.media.MediaFormat, com.hw.videoprocessor.util.k):void");
    }

    public static int i(MediaFormat mediaFormat) {
        return mediaFormat.containsKey("bitrate") ? mediaFormat.getInteger("bitrate") : com.hw.videoprocessor.h.f35384e;
    }

    public static int j(MediaFormat mediaFormat) {
        return mediaFormat.containsKey("max-input-size") ? mediaFormat.getInteger("max-input-size") : BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
    }

    public static boolean k(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int trackCount = mediaExtractor.getTrackCount();
        MediaFormat mediaFormat = null;
        for (int i6 = 0; i6 < trackCount; i6++) {
            mediaFormat = mediaExtractor.getTrackFormat(i6);
            if (mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                break;
            }
        }
        mediaExtractor.release();
        return mediaFormat != null && mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) > 1;
    }

    public static boolean n(String str, String str2, int i6, int i7, int i8) {
        try {
            new com.hw.videoprocessor.jssrc.b(new FileInputStream(str), new FileOutputStream(str2), i6, i7, 2, 2, i8, (int) new File(str).length(), 0.0d, 0, true);
            return true;
        } catch (IOException e6) {
            c.g(e6);
            e6.printStackTrace();
            return true;
        }
    }

    public static void o(String str, String str2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        try {
            int k6 = com.hw.videoprocessor.i.k(mediaExtractor, false);
            mediaExtractor.selectTrack(k6);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k6);
            MediaMuxer mediaMuxer = new MediaMuxer(str2, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    mediaMuxer.stop();
                    mediaMuxer.release();
                    return;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack, allocateDirect, bufferInfo);
                mediaExtractor.advance();
            }
        } finally {
            mediaExtractor.release();
        }
    }

    public static void p(String str, String str2, String str3, boolean z5) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str2);
        try {
            int k6 = com.hw.videoprocessor.i.k(mediaExtractor, false);
            int k7 = com.hw.videoprocessor.i.k(mediaExtractor2, true);
            mediaExtractor.selectTrack(k6);
            mediaExtractor2.selectTrack(k7);
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(k7);
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(k6);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            int addTrack2 = mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat2.getInteger("max-input-size"));
            long j6 = 0;
            long j7 = 0;
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    break;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack2, allocateDirect, bufferInfo);
                mediaExtractor.advance();
                j7 = sampleTime;
                j6 = 0;
            }
            int integer = 1024000000 / trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(j(trackFormat));
            long j8 = j6;
            long j9 = j8;
            while (j8 < j7) {
                mediaExtractor2.seekTo(j6, 2);
                while (true) {
                    long sampleTime2 = mediaExtractor2.getSampleTime();
                    if (sampleTime2 == -1) {
                        break;
                    }
                    j8 = sampleTime2 + j9;
                    if (j8 > j7) {
                        break;
                    }
                    int sampleFlags2 = mediaExtractor2.getSampleFlags();
                    int readSampleData2 = mediaExtractor2.readSampleData(allocateDirect2, 0);
                    bufferInfo.presentationTimeUs = j8;
                    bufferInfo.flags = sampleFlags2;
                    bufferInfo.size = readSampleData2;
                    mediaMuxer.writeSampleData(addTrack, allocateDirect2, bufferInfo);
                    mediaExtractor2.advance();
                }
                j9 = j8 + integer;
                if (!z5) {
                    break;
                } else {
                    j6 = 0;
                }
            }
            mediaMuxer.stop();
            mediaMuxer.release();
            mediaExtractor.release();
            mediaExtractor2.release();
        } catch (Throwable th) {
            mediaExtractor.release();
            mediaExtractor2.release();
            throw th;
        }
    }

    public static void s(String str, String str2, @IntRange(from = 2) int i6) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[i6 * 1024];
        byte[] bArr2 = new byte[1024];
        while (fileInputStream.read(bArr) != -1) {
            for (int i7 = 0; i7 < 1024; i7 += 2) {
                int i8 = i6 * i7;
                bArr2[i7] = bArr[i8];
                bArr2[i7 + 1] = bArr[i8 + 1];
            }
            fileOutputStream.write(bArr2);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static long t(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i6, Integer num, Integer num2, long j6, k kVar) throws IOException {
        int k6 = com.hw.videoprocessor.i.k(mediaExtractor, true);
        mediaExtractor.selectTrack(k6);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(k6);
        long j7 = trackFormat.getLong("durationUs");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j8 = j6;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime == -1) {
                break;
            }
            if (sampleTime >= num3.intValue()) {
                if (num2 != null && sampleTime > num2.intValue()) {
                    break;
                }
                if (kVar != null) {
                    float intValue = (sampleTime - num3.intValue()) / (num2 == null ? j7 : num2.intValue() - num3.intValue());
                    if (intValue < 0.0f) {
                        intValue = 0.0f;
                    }
                    if (intValue > 1.0f) {
                        intValue = 1.0f;
                    }
                    kVar.a(intValue);
                }
                bufferInfo.presentationTimeUs = (sampleTime - num3.intValue()) + j6;
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.size = readSampleData;
                if (readSampleData < 0) {
                    break;
                }
                c.k("writeAudioSampleData,time:" + (bufferInfo.presentationTimeUs / 1000.0f), new Object[0]);
                mediaMuxer.writeSampleData(i6, allocateDirect, bufferInfo);
                long j9 = bufferInfo.presentationTimeUs;
                mediaExtractor.advance();
                j8 = j9;
            } else {
                mediaExtractor.advance();
            }
        }
        return j8;
    }

    public static long u(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i6, Integer num, Integer num2, k kVar) throws IOException {
        return t(mediaExtractor, mediaMuxer, i6, num, num2, 0L, kVar);
    }

    public static void l(String str, String str2, String str3, @IntRange(from = 0, to = 100) int i6, @IntRange(from = 0, to = 100) int i7) throws IOException {
        float m6 = m(i6);
        float m7 = m(i7);
        int i8 = 2048;
        byte[] bArr = new byte[2048];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3);
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (z5 && z6) {
                fileInputStream.close();
                fileInputStream2.close();
                fileOutputStream.close();
                return;
            }
            if (!z5) {
                try {
                    if (fileInputStream.read(bArr) == -1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    System.arraycopy(bArr, 0, bArr3, 0, i8);
                } catch (Throwable th) {
                    fileInputStream.close();
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
            if (!z6) {
                if (fileInputStream2.read(bArr2) == -1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    int i11 = (int) ((((short) (((bArr2[i10] & 255) << 8) | (bArr2[i9] & 255))) * m7) + (((short) ((bArr[i9] & 255) | ((bArr[i10] & 255) << 8))) * m6));
                    if (i11 > 32767) {
                        i11 = 32767;
                    } else if (i11 < -32768) {
                        i11 = -32768;
                    }
                    bArr3[i9] = (byte) (i11 & 255);
                    bArr3[i10] = (byte) ((i11 >>> 8) & 255);
                    i9 += 2;
                    i8 = 2048;
                }
            }
            fileOutputStream.write(bArr3);
            i8 = 2048;
        }
    }
}
