package cn.bluemobi.dylan.photoview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.photoview.library.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageDetailFragment extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    private String f1277c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f1278d;

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f1279e;

    /* renamed from: f, reason: collision with root package name */
    private d f1280f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d.f {
        a() {
        }

        @Override // cn.bluemobi.dylan.photoview.library.d.f
        public void a(View view, float f6, float f7) {
            ImageDetailFragment.this.getActivity().finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements g<Drawable> {
        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, p<Drawable> pVar, boolean z5) {
            return false;
        }

        b() {
        }

        @Override // com.bumptech.glide.request.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean c(Drawable drawable, Object obj, p<Drawable> pVar, DataSource dataSource, boolean z5) {
            ImageDetailFragment.this.f1278d.setImageDrawable(drawable);
            ImageDetailFragment.this.f1279e.setVisibility(8);
            ImageDetailFragment.this.f1280f.update();
            return false;
        }
    }

    public static ImageDetailFragment e(String str) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.image_detail_fragment, viewGroup, false);
        this.f1278d = (ImageView) inflate.findViewById(R.id.image);
        d dVar = new d(this.f1278d);
        this.f1280f = dVar;
        dVar.setOnPhotoTapListener(new a());
        this.f1279e = (ProgressBar) inflate.findViewById(R.id.loading);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.bumptech.glide.b.D(getContext()).a(this.f1277c).t(j.f15240b).I0(true).n().u().o1(new b()).m1(this.f1278d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getArguments() != null) {
            str = getArguments().getString("url");
        } else {
            str = null;
        }
        this.f1277c = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
