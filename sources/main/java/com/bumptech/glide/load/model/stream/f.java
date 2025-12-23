package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f<DataT> implements n<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15497a;

    /* renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f15498b;

    /* renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f15499c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<DataT> f15500d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15501a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<DataT> f15502b;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public final n<Uri, DataT> c(@NonNull r rVar) {
            return new f(this.f15501a, rVar.d(File.class, this.f15502b), rVar.d(Uri.class, this.f15502b), this.f15502b);
        }

        a(Context context, Class<DataT> cls) {
            this.f15501a = context;
            this.f15502b = cls;
        }

        @Override // com.bumptech.glide.load.model.o
        public final void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: k, reason: collision with root package name */
        private static final String[] f15503k = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f15504a;

        /* renamed from: b, reason: collision with root package name */
        private final n<File, DataT> f15505b;

        /* renamed from: c, reason: collision with root package name */
        private final n<Uri, DataT> f15506c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f15507d;

        /* renamed from: e, reason: collision with root package name */
        private final int f15508e;

        /* renamed from: f, reason: collision with root package name */
        private final int f15509f;

        /* renamed from: g, reason: collision with root package name */
        private final com.bumptech.glide.load.f f15510g;

        /* renamed from: h, reason: collision with root package name */
        private final Class<DataT> f15511h;

        /* renamed from: i, reason: collision with root package name */
        private volatile boolean f15512i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        private volatile com.bumptech.glide.load.data.d<DataT> f15513j;

        @NonNull
        private File g(Uri uri) throws FileNotFoundException {
            try {
                Cursor query = this.f15504a.getContentResolver().query(uri, f15503k, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    query.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } finally {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f15512i = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f15513j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        private boolean f() {
            int checkSelfPermission;
            checkSelfPermission = this.f15504a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            return checkSelfPermission == 0;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.f15511h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f15513j;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i6, int i7, com.bumptech.glide.load.f fVar, Class<DataT> cls) {
            this.f15504a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f15505b = nVar;
            this.f15506c = nVar2;
            this.f15507d = uri;
            this.f15508e = i6;
            this.f15509f = i7;
            this.f15510g = fVar;
            this.f15511h = cls;
        }

        @Nullable
        private n.a<DataT> d() throws FileNotFoundException {
            boolean isExternalStorageLegacy;
            Uri uri;
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return this.f15505b.a(g(this.f15507d), this.f15508e, this.f15509f, this.f15510g);
            }
            if (f()) {
                uri = MediaStore.setRequireOriginal(this.f15507d);
            } else {
                uri = this.f15507d;
            }
            return this.f15506c.a(uri, this.f15508e, this.f15509f, this.f15510g);
        }

        @Nullable
        private com.bumptech.glide.load.data.d<DataT> e() throws FileNotFoundException {
            n.a<DataT> d6 = d();
            if (d6 != null) {
                return d6.f15458c;
            }
            return null;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> e6 = e();
                if (e6 == null) {
                    aVar.e(new IllegalArgumentException("Failed to build fetcher for: " + this.f15507d));
                    return;
                }
                this.f15513j = e6;
                if (this.f15512i) {
                    cancel();
                } else {
                    e6.c(priority, aVar);
                }
            } catch (FileNotFoundException e7) {
                aVar.e(e7);
            }
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<DataT> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(uri), new d(this.f15497a, this.f15498b, this.f15499c, uri, i6, i7, fVar, this.f15500d));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.data.mediastore.b.b(uri);
    }

    f(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f15497a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f15498b = nVar;
        this.f15499c = nVar2;
        this.f15500d = cls;
    }
}
