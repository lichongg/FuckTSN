package com.hw.videoprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.util.j;
import com.hw.videoprocessor.util.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(21)
/* loaded from: D:\Downloads\app\classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    static final String f35380a = "VideoProcessor";

    /* renamed from: b, reason: collision with root package name */
    static final String f35381b = "video/avc";

    /* renamed from: c, reason: collision with root package name */
    public static int f35382c = 15;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35383d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35384e = 192000;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f35385f = true;

    /* renamed from: g, reason: collision with root package name */
    static final int f35386g = 2500;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35387a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f35388b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f35389c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Integer f35390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f35391e;

        a(String str, File file, Integer num, Integer num2, CountDownLatch countDownLatch) {
            this.f35387a = str;
            this.f35388b = file;
            this.f35389c = num;
            this.f35390d = num2;
            this.f35391e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    com.hw.videoprocessor.util.b.g(this.f35387a, this.f35388b.getAbsolutePath(), this.f35389c, this.f35390d);
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            } finally {
                this.f35391e.countDown();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35392a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f35393b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f35394c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f35395d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f35396e;

        b(String str, File file, int i6, int i7, CountDownLatch countDownLatch) {
            this.f35392a = str;
            this.f35393b = file;
            this.f35394c = i6;
            this.f35395d = i7;
            this.f35396e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    String str = this.f35392a;
                    String absolutePath = this.f35393b.getAbsolutePath();
                    int i6 = this.f35394c;
                    int i7 = this.f35395d;
                    com.hw.videoprocessor.util.b.g(str, absolutePath, 0, Integer.valueOf(i6 > i7 ? i7 * 1000 : i6 * 1000));
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            } finally {
                this.f35396e.countDown();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private Context f35397a;

        /* renamed from: b, reason: collision with root package name */
        private String f35398b;

        /* renamed from: c, reason: collision with root package name */
        private String f35399c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private Integer f35400d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private Integer f35401e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Integer f35402f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        private Integer f35403g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private Float f35404h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        private Boolean f35405i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        private Integer f35406j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        private Integer f35407k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        private Integer f35408l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private k f35409m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f35410n = true;

        public c A(k kVar) {
            this.f35409m = kVar;
            return this;
        }

        public c r(boolean z5) {
            this.f35410n = z5;
            return this;
        }

        public c v(String str) {
            this.f35398b = str;
            return this;
        }

        public c y(String str) {
            this.f35399c = str;
            return this;
        }

        public void z() throws Exception {
            h.e(this.f35397a, this);
        }

        public c(Context context) {
            this.f35397a = context;
        }

        public c B(float f6) {
            this.f35404h = Float.valueOf(f6);
            return this;
        }

        public c C(int i6) {
            this.f35402f = Integer.valueOf(i6);
            return this;
        }

        public c p(int i6) {
            this.f35406j = Integer.valueOf(i6);
            return this;
        }

        public c q(boolean z5) {
            this.f35405i = Boolean.valueOf(z5);
            return this;
        }

        public c s(int i6) {
            this.f35403g = Integer.valueOf(i6);
            return this;
        }

        public c t(int i6) {
            this.f35407k = Integer.valueOf(i6);
            return this;
        }

        public c u(int i6) {
            this.f35408l = Integer.valueOf(i6);
            return this;
        }

        public c w(int i6) {
            this.f35401e = Integer.valueOf(i6);
            return this;
        }

        public c x(int i6) {
            this.f35400d = Integer.valueOf(i6);
            return this;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(5:(3:167|168|(17:170|171|172|(2:174|175)(1:202)|176|177|178|(2:180|181)(1:198)|182|183|184|185|186|187|188|189|190))|187|188|189|190)|207|(0)(0)|176|177|178|(0)(0)|182|183|184|185|186) */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x06ec, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x06ed, code lost:
    
        r7 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x06f1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0475 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x067f A[Catch: all -> 0x057b, TRY_LEAVE, TryCatch #12 {all -> 0x057b, blocks: (B:83:0x0572, B:172:0x0659, B:174:0x067f, B:180:0x06a5), top: B:82:0x0572 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06a5 A[Catch: all -> 0x057b, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x057b, blocks: (B:83:0x0572, B:172:0x0659, B:174:0x067f, B:180:0x06a5), top: B:82:0x0572 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x053c A[Catch: all -> 0x0531, TRY_LEAVE, TryCatch #8 {all -> 0x0531, blocks: (B:69:0x0503, B:71:0x050d, B:73:0x053c, B:78:0x0561), top: B:68:0x0503 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0561 A[Catch: all -> 0x0531, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0531, blocks: (B:69:0x0503, B:71:0x050d, B:73:0x053c, B:78:0x0561), top: B:68:0x0503 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0566  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.content.Context r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Integer r42, java.lang.Integer r43, @androidx.annotation.IntRange(from = 0, to = 100) int r44, @androidx.annotation.IntRange(from = 0, to = 100) int r45, float r46, float r47) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.d(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, int, float, float):void");
    }

    public static void h(String str, String str2, boolean z5) throws IOException {
        i(str, str2, z5, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03fb A[Catch: all -> 0x03eb, TryCatch #4 {all -> 0x03eb, blocks: (B:144:0x03c2, B:137:0x03fb, B:138:0x0419, B:140:0x041e, B:141:0x0420), top: B:143:0x03c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041e A[Catch: all -> 0x03eb, TryCatch #4 {all -> 0x03eb, blocks: (B:144:0x03c2, B:137:0x03fb, B:138:0x0419, B:140:0x041e, B:141:0x0420), top: B:143:0x03c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02f0 A[Catch: all -> 0x02e6, TRY_LEAVE, TryCatch #3 {all -> 0x02e6, blocks: (B:63:0x02b8, B:65:0x02c2, B:67:0x02f0, B:72:0x0315), top: B:62:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0315 A[Catch: all -> 0x02e6, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x02e6, blocks: (B:63:0x02b8, B:65:0x02c2, B:67:0x02f0, B:72:0x0315), top: B:62:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r35, java.lang.String r36, java.lang.String r37, @androidx.annotation.IntRange(from = 0, to = 100) int r38, float r39, float r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1143
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.a(android.content.Context, java.lang.String, java.lang.String, int, float, float):void");
    }

    public static void e(@NonNull Context context, @NonNull c cVar) throws Exception {
        int i6;
        int i7;
        boolean z5;
        int i8;
        int i9;
        Integer num;
        int i10;
        Integer num2;
        Integer valueOf;
        long j6;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(cVar.f35398b);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        int parseInt4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int parseInt5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        if (cVar.f35406j == null) {
            cVar.f35406j = Integer.valueOf(parseInt4);
        }
        if (cVar.f35408l == null) {
            cVar.f35408l = 1;
        }
        if (cVar.f35400d != null) {
            parseInt = cVar.f35400d.intValue();
        }
        if (cVar.f35401e != null) {
            parseInt2 = cVar.f35401e.intValue();
        }
        if (parseInt % 2 != 0) {
            parseInt++;
        }
        if (parseInt2 % 2 != 0) {
            parseInt2++;
        }
        if (parseInt3 == 90 || parseInt3 == 270) {
            i6 = parseInt;
            i7 = parseInt2;
        } else {
            i7 = parseInt;
            i6 = parseInt2;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(cVar.f35398b);
        int k6 = i.k(mediaExtractor, false);
        int k7 = i.k(mediaExtractor, true);
        MediaMuxer mediaMuxer = new MediaMuxer(cVar.f35399c, 0);
        boolean booleanValue = cVar.f35405i == null ? true : cVar.f35405i.booleanValue();
        Integer num3 = cVar.f35403g;
        if (k7 >= 0) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k7);
            int i11 = com.hw.videoprocessor.util.b.i(trackFormat);
            int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
            int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            int j7 = com.hw.videoprocessor.util.b.j(trackFormat);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer2, integer);
            createAudioFormat.setInteger("bitrate", i11);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("max-input-size", j7);
            if (booleanValue) {
                if (cVar.f35402f == null && cVar.f35403g == null && cVar.f35404h == null) {
                    z5 = booleanValue;
                } else {
                    long j8 = trackFormat.getLong("durationUs");
                    if (cVar.f35402f == null || cVar.f35403g == null) {
                        z5 = booleanValue;
                        j6 = j8;
                    } else {
                        z5 = booleanValue;
                        j6 = (cVar.f35403g.intValue() - cVar.f35402f.intValue()) * 1000;
                    }
                    if (cVar.f35404h != null) {
                        j6 = (long) (j6 / cVar.f35404h.floatValue());
                    }
                    createAudioFormat.setLong("durationUs", j6);
                }
                i8 = parseInt5;
                num2 = num3;
            } else {
                z5 = booleanValue;
                i8 = parseInt5;
                num2 = num3;
                long j9 = parseInt5 * 1000;
                long j10 = trackFormat.getLong("durationUs");
                if (cVar.f35402f != null || cVar.f35403g != null || cVar.f35404h != null) {
                    if (cVar.f35402f != null && cVar.f35403g != null) {
                        j9 = (cVar.f35403g.intValue() - cVar.f35402f.intValue()) * 1000;
                    }
                    if (cVar.f35404h != null) {
                        j9 = (long) (j9 / cVar.f35404h.floatValue());
                    }
                    if (j9 < j10) {
                        j10 = j9;
                    }
                    createAudioFormat.setLong("durationUs", j10);
                    valueOf = Integer.valueOf((cVar.f35402f == null ? 0 : cVar.f35402f.intValue()) + ((int) (j10 / 1000)));
                    i9 = 2;
                    com.hw.videoprocessor.util.b.e(createAudioFormat, 2, integer2, integer);
                    i10 = mediaMuxer.addTrack(createAudioFormat);
                    num = valueOf;
                }
            }
            valueOf = num2;
            i9 = 2;
            com.hw.videoprocessor.util.b.e(createAudioFormat, 2, integer2, integer);
            i10 = mediaMuxer.addTrack(createAudioFormat);
            num = valueOf;
        } else {
            z5 = booleanValue;
            i8 = parseInt5;
            i9 = 2;
            num = num3;
            i10 = 0;
        }
        mediaExtractor.selectTrack(k6);
        if (cVar.f35402f != null) {
            mediaExtractor.seekTo(cVar.f35402f.intValue() * 1000, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        j jVar = new j(cVar.f35409m);
        jVar.d(cVar.f35404h);
        jVar.e(cVar.f35402f == null ? 0 : cVar.f35402f.intValue());
        jVar.c(cVar.f35403g == null ? i8 : cVar.f35403g.intValue());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        g gVar = new g(mediaExtractor, mediaMuxer, cVar.f35406j.intValue(), i7, i6, cVar.f35408l.intValue(), cVar.f35407k == null ? f35382c : cVar.f35407k.intValue(), k6, atomicBoolean, countDownLatch);
        boolean z6 = z5;
        int e6 = i.e(cVar.f35398b);
        if (e6 <= 0) {
            e6 = (int) Math.ceil(i.c(cVar.f35398b));
        }
        e eVar = new e(gVar, mediaExtractor, cVar.f35402f, cVar.f35403g, Integer.valueOf(e6), Integer.valueOf(cVar.f35407k == null ? f35382c : cVar.f35407k.intValue()), cVar.f35404h, cVar.f35410n, k6, atomicBoolean);
        com.hw.videoprocessor.a aVar = new com.hw.videoprocessor.a(context, cVar.f35398b, mediaMuxer, cVar.f35402f, num, z6 ? cVar.f35404h : null, i10, countDownLatch);
        gVar.e(jVar);
        aVar.d(jVar);
        eVar.start();
        gVar.start();
        aVar.start();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            eVar.join();
            gVar.join();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.join();
            long currentTimeMillis3 = System.currentTimeMillis();
            Long valueOf2 = Long.valueOf(currentTimeMillis2 - currentTimeMillis);
            Long valueOf3 = Long.valueOf(currentTimeMillis3 - currentTimeMillis);
            Object[] objArr = new Object[i9];
            objArr[0] = valueOf2;
            objArr[1] = valueOf3;
            com.hw.videoprocessor.util.c.t(String.format("编解码:%dms,音频:%dms", objArr), new Object[0]);
        } catch (InterruptedException e7) {
            e7.printStackTrace();
        }
        try {
            mediaMuxer.release();
            mediaExtractor.release();
        } catch (Exception e8) {
            com.hw.videoprocessor.util.c.g(e8);
        }
        if (gVar.c() != null) {
            throw gVar.c();
        }
        if (eVar.b() != null) {
            throw eVar.b();
        }
        if (aVar.c() != null) {
            throw aVar.c();
        }
    }

    public static c f(Context context) {
        return new c(context);
    }

    public static void g(Context context, String str, String str2, boolean z5, @Nullable k kVar) throws Exception {
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp");
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp2");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            mediaExtractor.selectTrack(i.k(mediaExtractor, false));
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                    i6++;
                }
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    break;
                }
                arrayList.add(Long.valueOf(sampleTime));
                i7++;
                mediaExtractor.advance();
            }
            mediaExtractor.release();
            if (i7 != i6 && i7 != i6 + 1) {
                com.hw.videoprocessor.util.i iVar = new com.hw.videoprocessor.util.i(new float[]{0.45f, 0.1f, 0.45f}, kVar);
                iVar.b(0);
                float f6 = i6;
                float f7 = 1.0f + ((i7 - i6) / f6);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                try {
                    f(context).v(str).y(file.getAbsolutePath()).p((int) (parseInt * f7)).u(0).A(iVar).z();
                } catch (MediaCodec.CodecException e6) {
                    com.hw.videoprocessor.util.c.g(e6);
                    f(context).v(str).y(file.getAbsolutePath()).p((int) (parseInt * f7)).u(-1).A(iVar).z();
                }
                int i8 = 1;
                iVar.b(1);
                i(file.getAbsolutePath(), file2.getAbsolutePath(), z5, null, iVar);
                int i9 = (int) (f6 / (parseInt2 / 1000.0f));
                if (i9 != 0) {
                    i8 = i9;
                }
                iVar.b(2);
                f(context).v(file2.getAbsolutePath()).y(str2).p(parseInt).u(i8).A(iVar).z();
            }
            i(str, str2, z5, arrayList, kVar);
        } finally {
            file.delete();
            file2.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x013c A[Catch: all -> 0x00e0, Exception -> 0x00e3, TryCatch #1 {Exception -> 0x00e3, blocks: (B:83:0x0081, B:85:0x0087, B:87:0x0095, B:90:0x00b3, B:30:0x013c, B:32:0x0147, B:34:0x0155, B:37:0x016c, B:39:0x0182, B:41:0x0187, B:44:0x0194, B:46:0x019e, B:52:0x01a3, B:53:0x01ab, B:55:0x01b4, B:57:0x01c8, B:59:0x01cd, B:62:0x01d8, B:64:0x01df, B:71:0x01e5, B:92:0x00ca, B:94:0x00cf, B:97:0x00da, B:99:0x00e6, B:12:0x00fa, B:15:0x0107, B:17:0x011d, B:19:0x0122, B:22:0x012d, B:23:0x0132, B:26:0x01f6), top: B:82:0x0081, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e5 A[Catch: all -> 0x00e0, Exception -> 0x00e3, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e3, blocks: (B:83:0x0081, B:85:0x0087, B:87:0x0095, B:90:0x00b3, B:30:0x013c, B:32:0x0147, B:34:0x0155, B:37:0x016c, B:39:0x0182, B:41:0x0187, B:44:0x0194, B:46:0x019e, B:52:0x01a3, B:53:0x01ab, B:55:0x01b4, B:57:0x01c8, B:59:0x01cd, B:62:0x01d8, B:64:0x01df, B:71:0x01e5, B:92:0x00ca, B:94:0x00cf, B:97:0x00da, B:99:0x00e6, B:12:0x00fa, B:15:0x0107, B:17:0x011d, B:19:0x0122, B:22:0x012d, B:23:0x0132, B:26:0x01f6), top: B:82:0x0081, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void i(java.lang.String r30, java.lang.String r31, boolean r32, java.util.List<java.lang.Long> r33, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.i(java.lang.String, java.lang.String, boolean, java.util.List, com.hw.videoprocessor.util.k):void");
    }

    public static void b(Context context, String str, String str2, float f6) throws Exception {
        f(context).v(str).y(str2).B(f6).z();
    }

    public static void c(Context context, String str, String str2, int i6, int i7) throws Exception {
        f(context).v(str).y(str2).C(i6).s(i7).z();
    }

    public static void j(Context context, String str, String str2, int i6, int i7) throws Exception {
        f(context).v(str).y(str2).x(i6).w(i7).z();
    }
}
