package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.stub.StubApp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class Storage {
    private static final Lock zaa = new ReentrantLock();

    @Nullable
    @GuardedBy("sLk")
    private static Storage zab;
    private final Lock zac = new ReentrantLock();

    @GuardedBy("mLk")
    private final SharedPreferences zad;

    private static final String zae(String str, String str2) {
        return str + ":" + str2;
    }

    @KeepForSdk
    public void clear() {
        this.zac.lock();
        try {
            this.zad.edit().clear().apply();
        } finally {
            this.zac.unlock();
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zaa3) && (zaa2 = zaa(zae("googleSignInAccount", zaa3))) != null) {
            try {
                return GoogleSignInAccount.zab(zaa2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zaa3) && (zaa2 = zaa(zae("googleSignInOptions", zaa3))) != null) {
            try {
                return GoogleSignInOptions.zab(zaa2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    @KeepForSdk
    public String getSavedRefreshToken() {
        return zaa("refreshToken");
    }

    @Nullable
    protected final String zaa(@NonNull String str) {
        this.zac.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            this.zac.unlock();
        }
    }

    protected final void zab(@NonNull String str) {
        this.zac.lock();
        try {
            this.zad.edit().remove(str).apply();
        } finally {
            this.zac.unlock();
        }
    }

    public final void zac() {
        String zaa2 = zaa("defaultGoogleSignInAccount");
        zab("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa2)) {
            return;
        }
        zab(zae("googleSignInAccount", zaa2));
        zab(zae("googleSignInOptions", zaa2));
    }

    protected final void zad(@NonNull String str, @NonNull String str2) {
        this.zac.lock();
        try {
            this.zad.edit().putString(str, str2).apply();
        } finally {
            this.zac.unlock();
        }
    }

    @VisibleForTesting
    Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    @KeepForSdk
    public static Storage getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Lock lock = zaa;
        lock.lock();
        try {
            if (zab == null) {
                zab = new Storage(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            Storage storage = zab;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            zaa.unlock();
            throw th;
        }
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zad("defaultGoogleSignInAccount", googleSignInAccount.zac());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zac = googleSignInAccount.zac();
        zad(zae("googleSignInAccount", zac), googleSignInAccount.zad());
        zad(zae("googleSignInOptions", zac), googleSignInOptions.zaf());
    }
}
