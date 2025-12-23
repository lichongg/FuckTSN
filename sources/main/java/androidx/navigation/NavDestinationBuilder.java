package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;

    @Nullable
    private CharSequence label;

    @NotNull
    private final Navigator<? extends D> navigator;

    public final void deepLink(@NotNull String uriPattern) {
        g0.q(uriPattern, "uriPattern");
        this.deepLinks.add(new NavDeepLink(uriPattern));
    }

    public NavDestinationBuilder(@NotNull Navigator<? extends D> navigator, @IdRes int i6) {
        g0.q(navigator, "navigator");
        this.navigator = navigator;
        this.id = i6;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    public final void action(int i6, @NotNull Function1<? super NavActionBuilder, n1> actionBuilder) {
        g0.q(actionBuilder, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(i6);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        actionBuilder.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_ktx_release());
    }

    public final void argument(@NotNull String name, @NotNull Function1<? super NavArgumentBuilder, n1> argumentBuilder) {
        g0.q(name, "name");
        g0.q(argumentBuilder, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        argumentBuilder.invoke(navArgumentBuilder);
        map.put(name, navArgumentBuilder.build());
    }

    @NotNull
    public D build() {
        D createDestination = this.navigator.createDestination();
        createDestination.setId(this.id);
        createDestination.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            createDestination.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.deepLinks.iterator();
        while (it.hasNext()) {
            createDestination.addDeepLink((NavDeepLink) it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            createDestination.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        return createDestination;
    }

    public final void deepLink(@NotNull Function1<? super NavDeepLinkDslBuilder, n1> navDeepLink) {
        g0.q(navDeepLink, "navDeepLink");
        List<NavDeepLink> list = this.deepLinks;
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        navDeepLink.invoke(navDeepLinkDslBuilder);
        list.add(navDeepLinkDslBuilder.build$navigation_common_ktx_release());
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.label;
    }

    @NotNull
    protected final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.label = charSequence;
    }
}
