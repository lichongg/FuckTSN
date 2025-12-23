package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AbstractService() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1
        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new Supplier<String>() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1.1
                @Override // com.google.common.base.Supplier
                public String get() {
                    return AbstractExecutionThreadService.this.serviceName();
                }
            }).execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractExecutionThreadService.this.startUp();
                        notifyStarted();
                        if (isRunning()) {
                            try {
                                AbstractExecutionThreadService.this.run();
                            } catch (Throwable th) {
                                try {
                                    AbstractExecutionThreadService.this.shutDown();
                                } catch (Exception e6) {
                                    AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e6);
                                }
                                notifyFailed(th);
                                return;
                            }
                        }
                        AbstractExecutionThreadService.this.shutDown();
                        notifyStopped();
                    } catch (Throwable th2) {
                        notifyFailed(th2);
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    protected abstract void run() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j6, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j6, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j6, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j6, timeUnit);
    }

    protected Executor executor() {
        return new Executor() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), runnable).start();
            }
        };
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    protected AbstractExecutionThreadService() {
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    protected void triggerShutdown() {
    }
}
