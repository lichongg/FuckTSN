package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d extends com.bumptech.glide.load.resource.drawable.b<GifDrawable> implements q {
    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<GifDrawable> a() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return ((GifDrawable) this.f15689a).j();
    }

    @Override // com.bumptech.glide.load.resource.drawable.b, com.bumptech.glide.load.engine.q
    public void initialize() {
        ((GifDrawable) this.f15689a).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        ((GifDrawable) this.f15689a).stop();
        ((GifDrawable) this.f15689a).m();
    }

    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }
}
