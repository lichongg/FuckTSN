package u;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.startactivityforresult.EventDispatcherFragment;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private EventDispatcherFragment f54658a;

    /* renamed from: b, reason: collision with root package name */
    private final String f54659b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f54660c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(int i6, @Nullable Intent intent);
    }

    public b(@NotNull FragmentActivity activity) {
        g0.p(activity, "activity");
        this.f54659b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        g0.o(supportFragmentManager, "activity.supportFragmentManager");
        this.f54658a = b(supportFragmentManager);
    }

    private final Fragment a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f54659b);
    }

    public final void c(@NotNull a callBack) {
        g0.p(callBack, "callBack");
        EventDispatcherFragment eventDispatcherFragment = this.f54658a;
        Intent intent = this.f54660c;
        if (intent == null) {
            g0.S("intent");
        }
        eventDispatcherFragment.startActivityForResult(intent, callBack);
    }

    @NotNull
    public final b startActivityForResult(@NotNull Intent intent) {
        g0.p(intent, "intent");
        this.f54660c = intent;
        return this;
    }

    private final EventDispatcherFragment b(FragmentManager fragmentManager) {
        Fragment a6 = a(fragmentManager);
        if (a6 == null) {
            a6 = new EventDispatcherFragment();
            fragmentManager.beginTransaction().add(a6, this.f54659b).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (EventDispatcherFragment) a6;
    }

    public b(@NotNull Fragment fragment) {
        g0.p(fragment, "fragment");
        this.f54659b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        g0.o(childFragmentManager, "fragment.childFragmentManager");
        this.f54658a = b(childFragmentManager);
    }
}
