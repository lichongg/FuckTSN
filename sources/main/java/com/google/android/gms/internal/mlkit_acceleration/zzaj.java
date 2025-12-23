package com.google.android.gms.internal.mlkit_acceleration;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzaj<V> extends zzbj implements ListenableFuture<V> {
    static final boolean zza;
    static final zzba zzb;
    private static final zza zzc;
    private static final Object zzd;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzk waiters;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzaj.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z5, @CheckForNull Throwable th) {
            this.zzc = z5;
            this.zzd = th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzaj, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzaj, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzaj, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzd zza(zzaj zzajVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzajVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzk zzb(zzaj zzajVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzajVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zze(zzaj zzajVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzak.zza(this.zzd, zzajVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzf(zzaj zzajVar, @CheckForNull Object obj, Object obj2) {
            return zzak.zza(this.zze, zzajVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzg(zzaj zzajVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzak.zza(this.zzc, zzajVar, zzkVar, zzkVar2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzf<V> implements Runnable {
        final zzaj<V> zza;
        final ListenableFuture<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzg extends zza {
        /* synthetic */ zzg(zzal zzalVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzd zza(zzaj zzajVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzajVar) {
                try {
                    zzdVar2 = zzajVar.listeners;
                    if (zzdVar2 != zzdVar) {
                        zzajVar.listeners = zzdVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzk zzb(zzaj zzajVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzajVar) {
                try {
                    zzkVar2 = zzajVar.waiters;
                    if (zzkVar2 != zzkVar) {
                        zzajVar.waiters = zzkVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zze(zzaj zzajVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzajVar) {
                try {
                    if (zzajVar.listeners != zzdVar) {
                        return false;
                    }
                    zzajVar.listeners = zzdVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzf(zzaj zzajVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzajVar) {
                try {
                    if (zzajVar.value != obj) {
                        return false;
                    }
                    zzajVar.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzg(zzaj zzajVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            synchronized (zzajVar) {
                try {
                    if (zzajVar.waiters != zzkVar) {
                        return false;
                    }
                    zzajVar.waiters = zzkVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private zzg() {
            super(null);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface zzh<V> extends ListenableFuture<V> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* synthetic */ zzj(zzan zzanVar) {
            super(null);
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.mlkit_acceleration.zzaj.zzj.1
                        @Override // java.security.PrivilegedExceptionAction
                        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzaj.class.getDeclaredField("waiters"));
                    zzb = unsafe.objectFieldOffset(zzaj.class.getDeclaredField("listeners"));
                    zzd = unsafe.objectFieldOffset(zzaj.class.getDeclaredField("value"));
                    zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e6) {
                    throw new RuntimeException(e6);
                }
            } catch (PrivilegedActionException e7) {
                throw new RuntimeException("Could not initialize intrinsics", e7.getCause());
            }
        }

        private zzj() {
            super(null);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zze(zzaj zzajVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzam.zza(zza, zzajVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzf(zzaj zzajVar, @CheckForNull Object obj, Object obj2) {
            return zzam.zza(zza, zzajVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final boolean zzg(zzaj zzajVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzam.zza(zza, zzajVar, zzc, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzd zza(zzaj zzajVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzajVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzajVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
        final zzk zzb(zzaj zzajVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzajVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzajVar, zzkVar2, zzkVar));
            return zzkVar2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzk {
        static final zzk zza = new zzk(false);

        @CheckForNull
        volatile zzk next;

        @CheckForNull
        volatile Thread thread;

        zzk(boolean z5) {
        }

        zzk() {
            zzaj.zzc.zzd(this, Thread.currentThread());
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z5 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private static void zzs(zzaj zzajVar, boolean z5) {
        zzd zzdVar;
        zzd zzdVar2 = null;
        while (true) {
            for (zzk zzb2 = zzc.zzb(zzajVar, zzk.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzajVar.zzj();
            zzd zzdVar3 = zzdVar2;
            zzd zza2 = zzc.zza(zzajVar, zzd.zza);
            zzd zzdVar4 = zzdVar3;
            while (zza2 != null) {
                zzd zzdVar5 = zza2.next;
                zza2.next = zzdVar4;
                zzdVar4 = zza2;
                zza2 = zzdVar5;
            }
            while (zzdVar4 != null) {
                Runnable runnable = zzdVar4.zzb;
                zzdVar = zzdVar4.next;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzajVar = zzfVar.zza;
                    if (zzajVar.value == zzfVar) {
                        if (zzc.zzf(zzajVar, zzfVar, zzn(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar4.zzc;
                    Objects.requireNonNull(executor);
                    zzt(runnable2, executor);
                }
                zzdVar4 = zzdVar;
            }
            return;
            zzdVar2 = zzdVar;
        }
    }

    private final void zzu(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzv(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzu(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzv(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return zzv(obj3);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class zza {
        abstract zzd zza(zzaj zzajVar, zzd zzdVar);

        abstract zzk zzb(zzaj zzajVar, zzk zzkVar);

        abstract void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2);

        abstract void zzd(zzk zzkVar, Thread thread);

        abstract boolean zze(zzaj zzajVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzaj zzajVar, @CheckForNull Object obj, Object obj2);

        abstract boolean zzg(zzaj zzajVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2);

        /* synthetic */ zza(zzai zzaiVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.mlkit_acceleration.zzaj.zzc.1
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }

            {
                super("Failure occurred while trying to finish a future.");
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class zzi<V> extends zzaj<V> implements zzh<V> {
        zzi() {
        }
    }

    static {
        boolean z5;
        Throwable th;
        zza zzgVar;
        Throwable th2;
        try {
            z5 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z5 = false;
        }
        zza = z5;
        zzb = new zzba(zzaj.class);
        byte b6 = 0;
        try {
            zzgVar = new zzj(null);
            th = null;
            th2 = null;
        } catch (Error | Exception e6) {
            try {
                th = null;
                th2 = e6;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzaj.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzaj.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzaj.class, Object.class, "value"));
            } catch (Error | Exception e7) {
                th = e7;
                zzgVar = new zzg(b6 == true ? 1 : 0);
                th2 = e6;
            }
        }
        zzc = zzgVar;
        if (th != null) {
            zzba zzbaVar = zzb;
            Logger zza2 = zzbaVar.zza();
            Level level = Level.SEVERE;
            zza2.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzbaVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(ListenableFuture listenableFuture) {
        Throwable zzf2;
        if (listenableFuture instanceof zzh) {
            Object obj = ((zzaj) listenableFuture).value;
            if (obj instanceof zzb) {
                zzb zzbVar = (zzb) obj;
                if (zzbVar.zzc) {
                    Throwable th = zzbVar.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((listenableFuture instanceof zzbj) && (zzf2 = ((zzbj) listenableFuture).zzf()) != null) {
            return new zzc(zzf2);
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!zza) && isCancelled) {
            zzb zzbVar2 = zzb.zzb;
            Objects.requireNonNull(zzbVar2);
            return zzbVar2;
        }
        try {
            Object zzo = zzo(listenableFuture);
            if (!isCancelled) {
                return zzo == null ? zzd : zzo;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(listenableFuture)));
        } catch (Error | Exception e6) {
            return new zzc(e6);
        } catch (CancellationException e7) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e7)) : new zzb(false, e7);
        } catch (ExecutionException e8) {
            return isCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e8)) : new zzc(e8.getCause());
        }
    }

    private final void zzp(StringBuilder sb) {
        try {
            Object zzo = zzo(this);
            sb.append("SUCCESS, result=[");
            if (zzo == null) {
                sb.append("null");
            } else if (zzo == this) {
                sb.append("this future");
            } else {
                sb.append(zzo.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzo)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append("]");
        } catch (Exception e7) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e7.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzr(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception e6) {
            e = e6;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (StackOverflowError e7) {
            e = e7;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzv.zza(runnable, "Runnable was null.");
        zzv.zza(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzt(runnable, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = 1
            goto Lb
        La:
            r4 = 0
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L5f
            boolean r1 = com.google.android.gms.internal.mlkit_acceleration.zzaj.zza
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zzb r1 = new com.google.android.gms.internal.mlkit_acceleration.zzaj$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zzb r1 = com.google.android.gms.internal.mlkit_acceleration.zzaj.zzb.zza
            goto L26
        L24:
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zzb r1 = com.google.android.gms.internal.mlkit_acceleration.zzaj.zzb.zzb
        L26:
            java.util.Objects.requireNonNull(r1)
        L29:
            r5 = 0
            r4 = r7
        L2b:
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zza r6 = com.google.android.gms.internal.mlkit_acceleration.zzaj.zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L58
            zzs(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf
            if (r4 == 0) goto L57
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zzf r0 = (com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzh
            if (r4 == 0) goto L54
            r4 = r0
            com.google.android.gms.internal.mlkit_acceleration.zzaj r4 = (com.google.android.gms.internal.mlkit_acceleration.zzaj) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4b
            r5 = 1
            goto L4c
        L4b:
            r5 = 0
        L4c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = 1
            goto L2b
        L53:
            return r3
        L54:
            r0.cancel(r8)
        L57:
            return r3
        L58:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf
            if (r6 != 0) goto L2b
            return r5
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzaj.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb);
        } else {
            zzq(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    protected String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbj
    @CheckForNull
    protected final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    protected final boolean zzk(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    protected final boolean zzl(Throwable th) {
        if (!zzc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    protected final boolean zzm() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    protected zzaj() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r1.isEmpty() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzq(java.lang.StringBuilder r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            java.lang.String r1 = "PENDING"
            r6.append(r1)
            java.lang.Object r1 = r5.value
            boolean r2 = r1 instanceof com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf
            java.lang.String r3 = "]"
            if (r2 == 0) goto L21
            java.lang.String r2 = ", setFuture=["
            r6.append(r2)
            com.google.android.gms.internal.mlkit_acceleration.zzaj$zzf r1 = (com.google.android.gms.internal.mlkit_acceleration.zzaj.zzf) r1
            com.google.common.util.concurrent.ListenableFuture<? extends V> r1 = r1.zzb
            r5.zzr(r6, r1)
            r6.append(r3)
            goto L4e
        L21:
            java.lang.String r1 = r5.zze()     // Catch: java.lang.StackOverflowError -> L30 java.lang.Exception -> L32
            r2 = 0
            if (r1 == 0) goto L2e
            boolean r4 = r1.isEmpty()     // Catch: java.lang.StackOverflowError -> L30 java.lang.Exception -> L32
            if (r4 == 0) goto L41
        L2e:
            r1 = r2
            goto L41
        L30:
            r1 = move-exception
            goto L33
        L32:
            r1 = move-exception
        L33:
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Exception thrown from implementation: "
            java.lang.String r1 = r2.concat(r1)
        L41:
            if (r1 == 0) goto L4e
            java.lang.String r2 = ", info=["
            r6.append(r2)
            r6.append(r1)
            r6.append(r3)
        L4e:
            boolean r1 = r5.isDone()
            if (r1 == 0) goto L5e
            int r1 = r6.length()
            r6.delete(r0, r1)
            r5.zzp(r6)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzaj.zzq(java.lang.StringBuilder):void");
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e6) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e6);
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j6);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z5 = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzv(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zzc;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return zzv(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzu(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzu(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                Object obj3 = this.value;
                Objects.requireNonNull(obj3);
                return zzv(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof zzf))) {
                    return zzv(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzajVar = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String str = "Waited " + j6 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String concat = str.concat(" (plus ");
                long j7 = -nanos;
                long convert = timeUnit.convert(j7, TimeUnit.NANOSECONDS);
                long nanos2 = j7 - timeUnit.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z5 = false;
                }
                if (convert > 0) {
                    String str2 = concat + convert + " " + lowerCase;
                    if (z5) {
                        str2 = str2.concat(",");
                    }
                    concat = str2.concat(" ");
                }
                if (z5) {
                    concat = concat + nanos2 + " nanoseconds ";
                }
                str = concat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(str.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + zzajVar);
        }
        throw new InterruptedException();
    }

    protected void zzj() {
    }
}
