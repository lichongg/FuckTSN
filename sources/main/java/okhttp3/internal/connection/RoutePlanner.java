package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.collections.m;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Address;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface RoutePlanner {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ConnectResult {

        @Nullable
        private final Plan nextPlan;

        @NotNull
        private final Plan plan;

        @Nullable
        private final Throwable throwable;

        public ConnectResult(@NotNull Plan plan, @Nullable Plan plan2, @Nullable Throwable th) {
            g0.p(plan, "plan");
            this.plan = plan;
            this.nextPlan = plan2;
            this.throwable = th;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) obj;
            return g0.g(this.plan, connectResult.plan) && g0.g(this.nextPlan, connectResult.nextPlan) && g0.g(this.throwable, connectResult.throwable);
        }

        public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, Plan plan, Plan plan2, Throwable th, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                plan = connectResult.plan;
            }
            if ((i6 & 2) != 0) {
                plan2 = connectResult.nextPlan;
            }
            if ((i6 & 4) != 0) {
                th = connectResult.throwable;
            }
            return connectResult.copy(plan, plan2, th);
        }

        @NotNull
        public final Plan component1() {
            return this.plan;
        }

        @Nullable
        public final Plan component2() {
            return this.nextPlan;
        }

        @Nullable
        public final Throwable component3() {
            return this.throwable;
        }

        @NotNull
        public final ConnectResult copy(@NotNull Plan plan, @Nullable Plan plan2, @Nullable Throwable th) {
            g0.p(plan, "plan");
            return new ConnectResult(plan, plan2, th);
        }

        @Nullable
        public final Plan getNextPlan() {
            return this.nextPlan;
        }

        @NotNull
        public final Plan getPlan() {
            return this.plan;
        }

        @Nullable
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            int hashCode = this.plan.hashCode() * 31;
            Plan plan = this.nextPlan;
            int hashCode2 = (hashCode + (plan == null ? 0 : plan.hashCode())) * 31;
            Throwable th = this.throwable;
            return hashCode2 + (th != null ? th.hashCode() : 0);
        }

        public final boolean isSuccess() {
            return this.nextPlan == null && this.throwable == null;
        }

        @NotNull
        public String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ ConnectResult(Plan plan, Plan plan2, Throwable th, int i6, v vVar) {
            this(plan, (i6 & 2) != 0 ? null : plan2, (i6 & 4) != 0 ? null : th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Plan {
        /* renamed from: cancel */
        void mo289cancel();

        @NotNull
        /* renamed from: connectTcp */
        ConnectResult mo293connectTcp();

        @NotNull
        /* renamed from: connectTlsEtc */
        ConnectResult mo294connectTlsEtc();

        @NotNull
        /* renamed from: handleSuccess */
        RealConnection mo290handleSuccess();

        boolean isReady();

        @Nullable
        /* renamed from: retry */
        Plan mo291retry();
    }

    @NotNull
    Address getAddress();

    @NotNull
    m<Plan> getDeferredPlans();

    boolean hasNext(@Nullable RealConnection realConnection);

    boolean isCanceled();

    @NotNull
    Plan plan() throws IOException;

    boolean sameHostAndPort(@NotNull HttpUrl httpUrl);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class DefaultImpls {
    }
}
