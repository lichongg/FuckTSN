package m2;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface h {
    h A(int i6, boolean z5, boolean z6);

    h B(int i6);

    h C(View view, int i6, int i7);

    h D(n2.e eVar);

    h E(float f6);

    boolean F();

    h G(boolean z5);

    h H(Interpolator interpolator);

    h I(n2.c cVar);

    h J(d dVar, int i6, int i7);

    h K(boolean z5);

    boolean L();

    h M(int i6, boolean z5);

    h N(int i6, boolean z5);

    h O(View view);

    boolean P();

    h Q();

    boolean R(int i6, int i7, float f6);

    h S(int i6);

    boolean T();

    boolean U();

    h V(boolean z5);

    boolean W(int i6, int i7, float f6);

    h X();

    h Y();

    h Z(int i6);

    h a(i iVar);

    h a0(boolean z5);

    @Deprecated
    h b(boolean z5);

    h b0(n2.b bVar);

    h c(boolean z5);

    h c0(float f6);

    h d(boolean z5);

    h d0(boolean z5);

    boolean e();

    h e0(boolean z5);

    h f(float f6);

    h f0(float f6);

    h g(boolean z5);

    boolean g0();

    ViewGroup getLayout();

    @Nullable
    d getRefreshFooter();

    @Nullable
    e getRefreshHeader();

    RefreshState getState();

    h h(float f6);

    h h0(boolean z5);

    h i(boolean z5);

    h i0(d dVar);

    boolean isLoading();

    h j(int i6);

    boolean j0(int i6);

    h k();

    boolean k0();

    h l(e eVar);

    h l0(float f6);

    h m(e eVar, int i6, int i7);

    h n(float f6);

    h o(boolean z5);

    h p(n2.d dVar);

    h q(@ColorRes int... iArr);

    h r(boolean z5);

    h s(boolean z5);

    h setPrimaryColors(int... iArr);

    h t(boolean z5);

    boolean u(int i6);

    h v(boolean z5);

    h w(boolean z5);

    boolean x();

    h y(int i6);

    boolean z();
}
