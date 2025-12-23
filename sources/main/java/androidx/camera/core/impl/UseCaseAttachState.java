package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new LinkedHashMap();
    private final String mCameraId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class UseCaseAttachInfo {

        @NonNull
        private final SessionConfig mSessionConfig;

        @NonNull
        private final UseCaseConfig<?> mUseCaseConfig;
        private boolean mAttached = false;
        private boolean mActive = false;

        boolean getActive() {
            return this.mActive;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean getAttached() {
            return this.mAttached;
        }

        @NonNull
        SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        @NonNull
        UseCaseConfig<?> getUseCaseConfig() {
            return this.mUseCaseConfig;
        }

        void setActive(boolean z5) {
            this.mActive = z5;
        }

        void setAttached(boolean z5) {
            this.mAttached = z5;
        }

        UseCaseAttachInfo(@NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
            this.mSessionConfig = sessionConfig;
            this.mUseCaseConfig = useCaseConfig;
        }
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
        if (useCaseAttachInfo != null) {
            return useCaseAttachInfo;
        }
        UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig, useCaseConfig);
        this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue().getSessionConfig());
            }
        }
        return arrayList;
    }

    private Collection<UseCaseConfig<?>> getUseCaseConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue().getUseCaseConfig());
            }
        }
        return arrayList;
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getActive() && value.getAttached()) {
                String key = entry.getKey();
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(key);
            }
        }
        Logger.d(TAG, "Active and attached use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new AttachStateFilter() { // from class: androidx.camera.core.impl.m0
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                return UseCaseAttachState.c(useCaseAttachInfo);
            }
        }));
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getAttached()) {
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(entry.getKey());
            }
        }
        Logger.d(TAG, "All use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new AttachStateFilter() { // from class: androidx.camera.core.impl.k0
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                boolean attached;
                attached = useCaseAttachInfo.getAttached();
                return attached;
            }
        }));
    }

    @NonNull
    public Collection<UseCaseConfig<?>> getAttachedUseCaseConfigs() {
        return Collections.unmodifiableCollection(getUseCaseConfigs(new AttachStateFilter() { // from class: androidx.camera.core.impl.l0
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                boolean attached;
                attached = useCaseAttachInfo.getAttached();
                return attached;
            }
        }));
    }

    public boolean isUseCaseAttached(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            return this.mAttachedUseCasesToInfoMap.get(str).getAttached();
        }
        return false;
    }

    public void removeUseCase(@NonNull String str) {
        this.mAttachedUseCasesToInfoMap.remove(str);
    }

    public void setUseCaseDetached(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(false);
            if (useCaseAttachInfo.getActive()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void setUseCaseInactive(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setActive(false);
            if (useCaseAttachInfo.getAttached()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void updateUseCase(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig, useCaseConfig);
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(useCaseAttachInfo2.getAttached());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo);
        }
    }

    public UseCaseAttachState(@NonNull String str) {
        this.mCameraId = str;
    }

    public static /* synthetic */ boolean c(UseCaseAttachInfo useCaseAttachInfo) {
        if (useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached()) {
            return true;
        }
        return false;
    }

    public void setUseCaseActive(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig, useCaseConfig).setActive(true);
    }

    public void setUseCaseAttached(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig, useCaseConfig).setAttached(true);
    }
}
