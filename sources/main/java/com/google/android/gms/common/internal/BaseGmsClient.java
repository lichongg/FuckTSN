package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @NonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";

    @NonNull
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";

    @Nullable
    private volatile String zzA;

    @Nullable
    private ConnectionResult zzB;
    private boolean zzC;

    @Nullable
    private volatile zzk zzD;

    @VisibleForTesting
    zzv zza;
    final Handler zzb;

    @NonNull
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzc;

    @NonNull
    @VisibleForTesting
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;

    @Nullable
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;

    @Nullable
    @GuardedBy("serviceBrokerLock")
    private IGmsServiceBroker zzr;

    @Nullable
    @GuardedBy("lock")
    private IInterface zzs;
    private final ArrayList zzt;

    @Nullable
    @GuardedBy("lock")
    private zze zzu;

    @GuardedBy("lock")
    private int zzv;

    @Nullable
    private final BaseConnectionCallbacks zzw;

    @Nullable
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;

    @Nullable
    private final String zzz;
    private static final Feature[] zze = new Feature[0];

    @NonNull
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface BaseConnectionCallbacks {

        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;

        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(@NonNull Context context, @NonNull Handler handler, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i6, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i6;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(int i6, @Nullable IInterface iInterface) {
        zzv zzvVar;
        Preconditions.checkArgument((i6 == 4) == (iInterface != 0));
        synchronized (this.zzp) {
            try {
                this.zzv = i6;
                this.zzs = iInterface;
                if (i6 == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.zzn;
                        String zzb = this.zza.zzb();
                        Preconditions.checkNotNull(zzb);
                        gmsClientSupervisor.zzb(zzb, this.zza.zza(), 4225, zzeVar, zze(), this.zza.zzc());
                        this.zzu = null;
                    }
                } else if (i6 == 2 || i6 == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzvVar = this.zza) != null) {
                        zzvVar.zzb();
                        zzvVar.zza();
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String zzb2 = this.zza.zzb();
                        Preconditions.checkNotNull(zzb2);
                        gmsClientSupervisor2.zzb(zzb2, this.zza.zza(), 4225, zzeVar2, zze(), this.zza.zzc());
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    zzv zzvVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzv(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new zzv(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = zzvVar2;
                    if (zzvVar2.zzc() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zzb())));
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String zzb3 = this.zza.zzb();
                    Preconditions.checkNotNull(zzb3);
                    if (!gmsClientSupervisor3.zzc(new zzo(zzb3, this.zza.zza(), 4225, this.zza.zzc()), zzeVar3, zze(), getBindServiceExecutor())) {
                        this.zza.zzb();
                        this.zza.zza();
                        zzl(16, null, this.zzd.get());
                    }
                } else if (i6 == 4) {
                    Preconditions.checkNotNull(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    @Nullable
    @KeepForSdk
    protected abstract T createServiceInterface(@NonNull IBinder iBinder);

    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((zzc) this.zzt.get(i6)).zzf();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    @KeepForSdk
    protected boolean enableLocalFallback() {
        return false;
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @Nullable
    @KeepForSdk
    protected Executor getBindServiceExecutor() {
        return null;
    }

    @Nullable
    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @Nullable
    @KeepForSdk
    protected String getLocalStartServiceAction() {
        return null;
    }

    @NonNull
    @KeepForSdk
    protected abstract String getServiceDescriptor();

    @NonNull
    @KeepForSdk
    protected abstract String getStartServiceAction();

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    static /* bridge */ /* synthetic */ void zzj(BaseGmsClient baseGmsClient, zzk zzkVar) {
        baseGmsClient.zzD = zzkVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.zzd;
            RootTelemetryConfigManager.getInstance().zza(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    static /* bridge */ /* synthetic */ void zzk(BaseGmsClient baseGmsClient, int i6) {
        int i7;
        int i8;
        synchronized (baseGmsClient.zzp) {
            i7 = baseGmsClient.zzv;
        }
        if (i7 == 3) {
            baseGmsClient.zzC = true;
            i8 = 5;
        } else {
            i8 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i8, baseGmsClient.zzd.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int i6, int i7, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            try {
                if (baseGmsClient.zzv != i6) {
                    return false;
                }
                baseGmsClient.zzp(i7, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzo(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.zzC || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(baseGmsClient.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable == 0) {
            connect(new LegacyClientCallbackAdapter());
        } else {
            zzp(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
        }
    }

    @KeepForSdk
    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    @KeepForSdk
    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i6;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i6 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i6 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i6 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i6 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i6 == 4) {
            printWriter.print("CONNECTED");
        } else if (i6 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j6 = this.zzh;
            append.println(j6 + " " + simpleDateFormat.format(new Date(j6)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i7 = this.zzf;
            if (i7 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i7 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i7 != 3) {
                printWriter.append((CharSequence) String.valueOf(i7));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j7 = this.zzg;
            append2.println(j7 + " " + simpleDateFormat.format(new Date(j7)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j8 = this.zzj;
            append3.println(j8 + " " + simpleDateFormat.format(new Date(j8)));
        }
    }

    @NonNull
    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zze;
    }

    @Nullable
    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.zzD;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzb;
    }

    @NonNull
    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        return this.zzy;
    }

    @NonNull
    @KeepForSdk
    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @Nullable
    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    @NonNull
    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @KeepForSdk
    @WorkerThread
    public void getRemoteService(@Nullable IAccountAccessor iAccountAccessor, @NonNull Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i6 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        int i7 = this.zzy;
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i7, i6, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", AccountType.GOOGLE);
            }
            getServiceRequest.zzj = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzj = getAccount();
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzo = true;
        }
        try {
            try {
                synchronized (this.zzq) {
                    try {
                        IGmsServiceBroker iGmsServiceBroker = this.zzr;
                        if (iGmsServiceBroker != null) {
                            iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                        }
                    } finally {
                    }
                }
            } catch (DeadObjectException unused) {
                triggerConnectionSuspended(3);
            } catch (SecurityException e6) {
                throw e6;
            }
        } catch (RemoteException | RuntimeException unused2) {
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    @NonNull
    @KeepForSdk
    protected Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    @NonNull
    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t5;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                t5 = (T) this.zzs;
                Preconditions.checkNotNull(t5, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    @Nullable
    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return iGmsServiceBroker.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @NonNull
    @KeepForSdk
    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @Nullable
    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzk zzkVar = this.zzD;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzd;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z5;
        synchronized (this.zzp) {
            z5 = this.zzv == 4;
        }
        return z5;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z5;
        synchronized (this.zzp) {
            int i6 = this.zzv;
            z5 = true;
            if (i6 != 2 && i6 != 3) {
                z5 = false;
            }
        }
        return z5;
    }

    @KeepForSdk
    @CallSuper
    protected void onConnectionSuspended(int i6) {
        this.zzf = i6;
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onPostInitHandler(int i6, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i7) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i7, -1, new zzf(this, i6, iBinder, bundle)));
    }

    @KeepForSdk
    public void setAttributionTag(@NonNull String str) {
        this.zzA = str;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i6));
    }

    @KeepForSdk
    @VisibleForTesting
    protected void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i6, @Nullable PendingIntent pendingIntent) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i6, pendingIntent));
    }

    @NonNull
    protected final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    protected final void zzl(int i6, @Nullable Bundle bundle, int i7) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i7, -1, new zzg(this, i6, null)));
    }

    @KeepForSdk
    protected final void checkConnected() {
        if (isConnected()) {
        } else {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @NonNull
    @KeepForSdk
    public String getEndpointPackageName() {
        zzv zzvVar;
        if (isConnected() && (zzvVar = this.zza) != null) {
            return zzvVar.zza();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    protected boolean getUseDynamicLookup() {
        if (getMinApkVersion() >= 211700000) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    @CallSuper
    protected void onConnectedLocked(@NonNull T t5) {
        this.zzh = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    protected void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzi = connectionResult.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected BaseGmsClient(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull android.os.Looper r11, int r12, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks r13, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener r14, @androidx.annotation.Nullable java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.GmsClientSupervisor r3 = com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(r10)
            com.google.android.gms.common.GoogleApiAvailabilityLight r4 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks, com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener, java.lang.String):void");
    }

    @KeepForSdk
    public void disconnect(@NonNull String str) {
        this.zzk = str;
        disconnect();
    }

    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i6, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i6;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }
}
