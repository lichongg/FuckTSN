package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private TextView Nm;

    @Nullable
    private ImageView Nn;

    @Nullable
    private ImageView No;

    @Nullable
    private InterfaceC0605a Np;
    private ViewGroup vV;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0605a {
        void x(View view);

        void y(View view);
    }

    public final void a(@Nullable InterfaceC0605a interfaceC0605a) {
        this.Np = interfaceC0605a;
    }

    private void initView() {
        this.Nm = (TextView) this.vV.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Nn = (ImageView) this.vV.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.vV.findViewById(R.id.ksad_kwad_web_navi_close);
        this.No = imageView;
        imageView.setOnClickListener(this);
        this.Nn.setOnClickListener(this);
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.vV == null || (textView = this.Nm) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    @MainThread
    public final void aj(boolean z5) {
        ImageView imageView = this.No;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
        }
    }

    public final ViewGroup hP() {
        return this.vV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Np == null) {
            return;
        }
        if (view.equals(this.No)) {
            this.Np.y(view);
        } else if (view.equals(this.Nn)) {
            this.Np.x(view);
        }
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
            this.vV = viewGroup2;
            if (viewGroup2 == null) {
                return;
            }
            initView();
        }
    }
}
