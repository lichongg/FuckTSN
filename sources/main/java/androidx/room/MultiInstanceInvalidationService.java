package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalRoomApi
/* loaded from: D:\Downloads\app\classes.dex */
public final class MultiInstanceInvalidationService extends Service {
    private int maxClientId;

    @NotNull
    private final Map<Integer, String> clientNames = new LinkedHashMap();

    @NotNull
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService$callbackList$1
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            g0.p(callback, "callback");
            g0.p(cookie, "cookie");
            MultiInstanceInvalidationService.this.getClientNames$room_runtime_release().remove((Integer) cookie);
        }
    };

    @NotNull
    private final IMultiInstanceInvalidationService.Stub binder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i6, String[] tables) {
            g0.p(tables, "tables");
            RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                try {
                    String str = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(i6));
                    if (str == null) {
                        return;
                    }
                    int beginBroadcast = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
                    for (int i7 = 0; i7 < beginBroadcast; i7++) {
                        try {
                            Object broadcastCookie = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(i7);
                            g0.n(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                            Integer num = (Integer) broadcastCookie;
                            int intValue = num.intValue();
                            String str2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(num);
                            if (i6 != intValue && g0.g(str, str2)) {
                                try {
                                    multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(i7).onInvalidation(tables);
                                    n1 n1Var = n1.f44123a;
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                            throw th;
                        }
                    }
                    multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                    n1 n1Var2 = n1.f44123a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String str) {
            g0.p(callback, "callback");
            int i6 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                try {
                    multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() + 1);
                    int maxClientId$room_runtime_release = multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                    if (multiInstanceInvalidationService.getCallbackList$room_runtime_release().register(callback, Integer.valueOf(maxClientId$room_runtime_release))) {
                        multiInstanceInvalidationService.getClientNames$room_runtime_release().put(Integer.valueOf(maxClientId$room_runtime_release), str);
                        i6 = maxClientId$room_runtime_release;
                    } else {
                        multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() - 1);
                        multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i6;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int i6) {
            g0.p(callback, "callback");
            RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister(callback);
                multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(Integer.valueOf(i6));
            }
        }
    };

    @NotNull
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    @NotNull
    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@NotNull Intent intent) {
        g0.p(intent, "intent");
        return this.binder;
    }

    public final void setMaxClientId$room_runtime_release(int i6) {
        this.maxClientId = i6;
    }
}
