package com.orhanobut.logger;

import android.os.Environment;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bu;
import com.orhanobut.logger.e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c implements f {

    /* renamed from: e, reason: collision with root package name */
    private static final String f36466e = System.getProperty("line.separator");

    /* renamed from: f, reason: collision with root package name */
    private static final String f36467f = " <br> ";

    /* renamed from: g, reason: collision with root package name */
    private static final String f36468g = ",";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Date f36469a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final SimpleDateFormat f36470b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final h f36471c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f36472d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final int f36473e = 512000;

        /* renamed from: a, reason: collision with root package name */
        Date f36474a;

        /* renamed from: b, reason: collision with root package name */
        SimpleDateFormat f36475b;

        /* renamed from: c, reason: collision with root package name */
        h f36476c;

        /* renamed from: d, reason: collision with root package name */
        String f36477d;

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f36477d = "PRETTY_LOGGER";
        }

        @NonNull
        public c a() {
            if (this.f36474a == null) {
                this.f36474a = new Date();
            }
            if (this.f36475b == null) {
                this.f36475b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.f36476c == null) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + bu.f10800a;
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.f36476c = new e(new e.a(handlerThread.getLooper(), str, 512000));
            }
            return new c(this, null);
        }

        @NonNull
        public b b(@Nullable Date date) {
            this.f36474a = date;
            return this;
        }

        @NonNull
        public b c(@Nullable SimpleDateFormat simpleDateFormat) {
            this.f36475b = simpleDateFormat;
            return this;
        }

        @NonNull
        public b d(@Nullable h hVar) {
            this.f36476c = hVar;
            return this;
        }

        @NonNull
        public b e(@Nullable String str) {
            this.f36477d = str;
            return this;
        }
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    private c(@NonNull b bVar) {
        n.a(bVar);
        this.f36469a = bVar.f36474a;
        this.f36470b = bVar.f36475b;
        this.f36471c = bVar.f36476c;
        this.f36472d = bVar.f36477d;
    }

    @NonNull
    public static b c() {
        return new b(null);
    }

    @Nullable
    private String b(@Nullable String str) {
        if (!n.d(str) && !n.b(this.f36472d, str)) {
            return this.f36472d + "-" + str;
        }
        return this.f36472d;
    }

    @Override // com.orhanobut.logger.f
    public void a(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        String b6 = b(str);
        this.f36469a.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f36469a.getTime()));
        sb.append(f36468g);
        sb.append(this.f36470b.format(this.f36469a));
        sb.append(f36468g);
        sb.append(n.e(i6));
        sb.append(f36468g);
        sb.append(b6);
        String str3 = f36466e;
        if (str2.contains(str3)) {
            str2 = str2.replaceAll(str3, f36467f);
        }
        sb.append(f36468g);
        sb.append(str2);
        sb.append(str3);
        this.f36471c.a(i6, b6, sb.toString());
    }
}
