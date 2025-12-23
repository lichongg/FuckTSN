package com.acse.ottn;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class v<T> extends t<T, w> {
    @Override // com.acse.ottn.o1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w a(ViewGroup viewGroup, int i6) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new w(imageView);
    }

    public v(List<T> list) {
        super(list);
    }
}
