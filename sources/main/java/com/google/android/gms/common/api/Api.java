package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Api<O extends ApiOptions> {
    private final AbstractClientBuilder zaa;
    private final ClientKey zab;
    private final String zac;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @NonNull
        @KeepForSdk
        @Deprecated
        public T buildClient(@NonNull Context context, @NonNull Looper looper, @NonNull ClientSettings clientSettings, @NonNull O o5, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, (ClientSettings) o5, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        @NonNull
        @KeepForSdk
        public T buildClient(@NonNull Context context, @NonNull Looper looper, @NonNull ClientSettings clientSettings, @NonNull O o5, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface AnyClient {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ApiOptions {

        @NonNull
        public static final NoOptions NO_OPTIONS = new NoOptions(null);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            @NonNull
            Account getAccount();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            @Nullable
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }

            /* synthetic */ NoOptions(zaa zaaVar) {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    @KeepForSdk
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {

        @KeepForSdk
        public static final int API_PRIORITY_GAMES = 1;

        @KeepForSdk
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;

        @KeepForSdk
        public static final int API_PRIORITY_PLUS = 2;

        @NonNull
        @KeepForSdk
        public List<Scope> getImpliedScopes(@Nullable O o5) {
            return Collections.EMPTY_LIST;
        }

        @KeepForSdk
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void disconnect(@NonNull String str);

        @KeepForSdk
        void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr);

        @NonNull
        @KeepForSdk
        Feature[] getAvailableFeatures();

        @NonNull
        @KeepForSdk
        String getEndpointPackageName();

        @Nullable
        @KeepForSdk
        String getLastDisconnectMessage();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set);

        @NonNull
        @KeepForSdk
        Feature[] getRequiredFeatures();

        @NonNull
        @KeepForSdk
        Set<Scope> getScopesForConnectionlessNonSignIn();

        @Nullable
        @KeepForSdk
        IBinder getServiceBrokerBinder();

        @NonNull
        @KeepForSdk
        Intent getSignInIntent();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean providesSignIn();

        @KeepForSdk
        boolean requiresAccount();

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    @NonNull
    public final AbstractClientBuilder zaa() {
        return this.zaa;
    }

    @NonNull
    public final AnyClientKey zab() {
        return this.zab;
    }

    @NonNull
    public final BaseClientBuilder zac() {
        return this.zaa;
    }

    @NonNull
    public final String zad() {
        return this.zac;
    }

    @KeepForSdk
    public <C extends Client> Api(@NonNull String str, @NonNull AbstractClientBuilder<C, O> abstractClientBuilder, @NonNull ClientKey<C> clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }
}
