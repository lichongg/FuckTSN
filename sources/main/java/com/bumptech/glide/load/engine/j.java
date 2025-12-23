package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f15239a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j f15240b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final j f15241c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final j f15242d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final j f15243e = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z5 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }

        e() {
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z5, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        b() {
        }
    }
}
