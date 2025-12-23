package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class a {
    public File b(String str) {
        return new File(str);
    }

    a() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long c(File file) {
        return file.length();
    }
}
