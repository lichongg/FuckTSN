package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.util.Pair;
import com.google.android.gms.common.Scopes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i {
    public static List<File> l(Context context, String str, String str2, int i6, int i7, Integer num, float f6, Integer num2) throws Exception {
        int i8 = (int) (i6 * f6);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        LinkedList<Pair> linkedList = new LinkedList();
        int i9 = 0;
        while (true) {
            if (parseInt <= 0) {
                break;
            }
            parseInt -= i8;
            if (parseInt < i7) {
                linkedList.add(new Pair(Integer.valueOf(i9), Integer.valueOf(i9 + i8 + parseInt)));
                break;
            }
            Integer valueOf = Integer.valueOf(i9);
            i9 += i8;
            linkedList.add(new Pair(valueOf, Integer.valueOf(i9)));
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        for (Pair pair : linkedList) {
            File file = new File(str2, pair.first + ".mp4");
            h.f(context).v(str).y(file.getAbsolutePath()).C(((Integer) pair.first).intValue()).s(((Integer) pair.second).intValue()).B(f6).p(num.intValue()).u(num2.intValue()).z();
            arrayList.add(file);
        }
        return arrayList;
    }

    static long a(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i6, Integer num, Integer num2, long j6, int i7, int i8, boolean z5, boolean z6) throws Exception {
        int k6 = k(mediaExtractor, false);
        mediaExtractor.selectTrack(k6);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(k6);
        int integer = trackFormat.getInteger("width");
        int integer2 = trackFormat.getInteger("height");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d dVar = new d(mediaExtractor, mediaMuxer, i7, integer, integer2, i8, k6, atomicBoolean, j6, z5, z6, i6);
        e eVar = new e(dVar, mediaExtractor, Integer.valueOf(num3.intValue() / 1000), num2 == null ? null : Integer.valueOf(num2.intValue() / 1000), null, null, null, false, k6, atomicBoolean);
        eVar.start();
        dVar.start();
        try {
            eVar.join();
            dVar.join();
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        try {
            mediaExtractor.release();
        } catch (Exception e7) {
            com.hw.videoprocessor.util.c.g(e7);
        }
        if (dVar.c() != null) {
            throw dVar.c();
        }
        if (eVar.b() == null) {
            return dVar.d();
        }
        throw eVar.b();
    }

    public static void b(List<File> list, String str, Integer num, Integer num2) throws Exception {
        MediaMuxer mediaMuxer;
        List<File> list2 = list;
        if (list2 == null || list2.size() == 0) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(list2.get(0).getAbsolutePath());
        int parseInt = num == null ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)) : num.intValue();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(list2.get(0).getAbsolutePath());
        int k6 = k(mediaExtractor, false);
        boolean z5 = true;
        int k7 = k(mediaExtractor, true);
        MediaMuxer mediaMuxer2 = new MediaMuxer(str, 0);
        int addTrack = mediaMuxer2.addTrack(mediaExtractor.getTrackFormat(k6));
        boolean z6 = k7 >= 0;
        int addTrack2 = z6 ? mediaMuxer2.addTrack(mediaExtractor.getTrackFormat(k7)) : 0;
        mediaMuxer2.start();
        long j6 = 0;
        long j7 = 0;
        int i6 = 0;
        while (i6 < list2.size()) {
            if (i6 > 0) {
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(list2.get(i6).getAbsolutePath());
                k7 = k(mediaExtractor, z5);
            }
            MediaExtractor mediaExtractor2 = mediaExtractor;
            int i7 = k7;
            if (z6) {
                mediaMuxer = mediaMuxer2;
                j6 = com.hw.videoprocessor.util.b.t(mediaExtractor2, mediaMuxer, addTrack2, null, null, j7, null);
                mediaExtractor2.unselectTrack(i7);
            } else {
                mediaMuxer = mediaMuxer2;
            }
            int i8 = addTrack;
            long j8 = j6;
            int i9 = i6;
            long a6 = a(mediaExtractor2, mediaMuxer, i8, null, null, j7, parseInt, num2.intValue(), i6 == 0, false);
            long j9 = a6 > j8 ? a6 : j8;
            com.hw.videoprocessor.util.c.k("片段" + i9 + "已合成,audioFrameTime:" + (j8 / 1000.0f) + " videoFrameTime:" + (a6 / 1000.0f), new Object[0]);
            long j10 = j9 + 33000;
            mediaExtractor2.release();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(list2.get(i9).getAbsolutePath());
            sb.append(".rev");
            String sb2 = sb.toString();
            h.h(list2.get(i9).getAbsolutePath(), sb2, true);
            com.hw.videoprocessor.util.c.f("reverseVideoNoDecode:" + (System.currentTimeMillis() - currentTimeMillis) + "ms", new Object[0]);
            MediaExtractor mediaExtractor3 = new MediaExtractor();
            mediaExtractor3.setDataSource(sb2);
            if (z6) {
                i7 = k(mediaExtractor3, true);
                long t5 = com.hw.videoprocessor.util.b.t(mediaExtractor3, mediaMuxer, addTrack2, null, null, j10, null);
                mediaExtractor3.unselectTrack(i7);
                j8 = t5;
            }
            int i10 = i7;
            MediaMuxer mediaMuxer3 = mediaMuxer;
            long a7 = a(mediaExtractor3, mediaMuxer3, i8, null, null, j10, parseInt, num2.intValue(), false, i9 == list2.size() - 1);
            long j11 = a7 > j8 ? a7 : j8;
            com.hw.videoprocessor.util.c.k("反序片段" + i9 + "已合成,audioFrameTime:" + (j8 / 1000.0f) + " videoFrameTime:" + (a7 / 1000.0f), new Object[0]);
            j7 = j11 + 33000;
            mediaExtractor3.release();
            new File(sb2).delete();
            i6 = i9 + 1;
            list2 = list;
            mediaExtractor = mediaExtractor3;
            addTrack = i8;
            j6 = j8;
            z5 = true;
            mediaMuxer2 = mediaMuxer3;
            k7 = i10;
        }
        mediaMuxer2.release();
    }

    public static float c(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i6 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        long j6 = 0;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                mediaExtractor.release();
                return i6 / ((j6 / 1000.0f) / 1000.0f);
            }
            i6++;
            mediaExtractor.advance();
            j6 = sampleTime;
        }
    }

    public static int d(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i6 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        int i7 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i6++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                break;
            }
            i7++;
            mediaExtractor.advance();
        }
        mediaExtractor.release();
        float f6 = ((i7 - i6) / i6) + 1.0f;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        return i7 == i6 ? parseInt : (int) (f6 * parseInt);
    }

    public static int e(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k(mediaExtractor, false));
            return trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1;
        } catch (IOException e6) {
            com.hw.videoprocessor.util.c.g(e6);
            return -1;
        } finally {
            mediaExtractor.release();
        }
    }

    static List<Long> f(MediaExtractor mediaExtractor) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                return arrayList;
            }
            arrayList.add(Long.valueOf(sampleTime));
            mediaExtractor.advance();
        }
    }

    public static File h(Context context) {
        File file = new File(context.getCacheDir(), "video/");
        file.mkdirs();
        return file;
    }

    public static Pair<Integer, Integer> i(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i6 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        int i7 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i6++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                mediaExtractor.release();
                return new Pair<>(Integer.valueOf(i6), Integer.valueOf(i7));
            }
            i7++;
            mediaExtractor.advance();
        }
    }

    public static void j(MediaExtractor mediaExtractor, int i6, int i7) {
        int i8 = i7 * 1000;
        if (mediaExtractor.getSampleTrackIndex() != i6) {
            mediaExtractor.selectTrack(i6);
        }
        mediaExtractor.seekTo(i8, 0);
        while (i8 > 0 && mediaExtractor.getSampleTrackIndex() != i6) {
            i8 -= 10000;
            mediaExtractor.seekTo(i8, 0);
        }
    }

    public static int g(MediaCodec mediaCodec, String str) {
        try {
            return mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper().intValue();
        } catch (Exception e6) {
            com.hw.videoprocessor.util.c.g(e6);
            return -1;
        }
    }

    public static int k(MediaExtractor mediaExtractor, boolean z5) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i6 = 0; i6 < trackCount; i6++) {
            String string = mediaExtractor.getTrackFormat(i6).getString(IMediaFormat.KEY_MIME);
            if (z5) {
                if (string.startsWith("audio/")) {
                    return i6;
                }
            } else {
                if (string.startsWith("video/")) {
                    return i6;
                }
            }
        }
        return -5;
    }

    public static boolean m(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i6, int i7) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i6 && codecProfileLevel.level == i7) {
                mediaFormat.setInteger(Scopes.PROFILE, i6);
                mediaFormat.setInteger("level", i7);
                return true;
            }
        }
        return false;
    }
}
