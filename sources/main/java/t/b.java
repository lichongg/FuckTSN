package t;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.requestpermission.PermissionDispatcherFragment;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f54607a;

    /* renamed from: b, reason: collision with root package name */
    private PermissionDispatcherFragment f54608b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f54609c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b(@NotNull String[] strArr);

        void c(@NotNull String[] strArr);
    }

    public b(@NotNull FragmentActivity activity) {
        g0.p(activity, "activity");
        this.f54607a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        g0.o(supportFragmentManager, "activity.supportFragmentManager");
        this.f54608b = b(supportFragmentManager);
    }

    private final Fragment a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f54607a);
    }

    @NotNull
    public final b c(@NotNull String... permissions) {
        g0.p(permissions, "permissions");
        this.f54609c = permissions;
        return this;
    }

    @NotNull
    public final b d(@NotNull a permissionCheckCallBack) {
        g0.p(permissionCheckCallBack, "permissionCheckCallBack");
        PermissionDispatcherFragment permissionDispatcherFragment = this.f54608b;
        String[] strArr = this.f54609c;
        if (strArr == null) {
            g0.S("permissions");
        }
        permissionDispatcherFragment.requestPermissions(strArr, permissionCheckCallBack);
        return this;
    }

    private final PermissionDispatcherFragment b(FragmentManager fragmentManager) {
        Fragment a6 = a(fragmentManager);
        if (a6 == null) {
            a6 = new PermissionDispatcherFragment();
            fragmentManager.beginTransaction().add(a6, this.f54607a).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (PermissionDispatcherFragment) a6;
    }

    public b(@NotNull Fragment fragment) {
        g0.p(fragment, "fragment");
        this.f54607a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        g0.o(childFragmentManager, "fragment.childFragmentManager");
        this.f54608b = b(childFragmentManager);
    }
}
