package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Result implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(c.class).getFields();
    private static final long serialVersionUID = 1;
    private final AtomicInteger count;
    private final CopyOnWriteArrayList<Failure> failures;
    private final AtomicInteger ignoreCount;
    private final AtomicLong runTime;
    private c serializedForm;
    private final AtomicLong startTime;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RunListener.ThreadSafe
    private class b extends RunListener {
        private b() {
        }

        /* synthetic */ b(Result result, a aVar) {
            this();
        }

        @Override // org.junit.runner.notification.RunListener
        public void b(Failure failure) throws Exception {
            Result.this.failures.add(failure);
        }

        @Override // org.junit.runner.notification.RunListener
        public void c(Description description) throws Exception {
            Result.this.count.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void d(Description description) throws Exception {
            Result.this.ignoreCount.getAndIncrement();
        }

        @Override // org.junit.runner.notification.RunListener
        public void f(Description description) throws Exception {
            Result.this.startTime.set(System.currentTimeMillis());
        }

        @Override // org.junit.runner.notification.RunListener
        public void e(Result result) throws Exception {
            Result.this.runTime.addAndGet(System.currentTimeMillis() - Result.this.startTime.get());
        }

        @Override // org.junit.runner.notification.RunListener
        public void a(Failure failure) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f51495a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f51496b;

        /* renamed from: c, reason: collision with root package name */
        private final List<Failure> f51497c;

        /* renamed from: d, reason: collision with root package name */
        private final long f51498d;

        /* renamed from: e, reason: collision with root package name */
        private final long f51499e;

        public c(Result result) {
            this.f51495a = result.count;
            this.f51496b = result.ignoreCount;
            this.f51497c = Collections.synchronizedList(new ArrayList(result.failures));
            this.f51498d = result.runTime.longValue();
            this.f51499e = result.startTime.longValue();
        }

        public static c f(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            return new c(objectInputStream.readFields());
        }

        public void g(ObjectOutputStream objectOutputStream) throws IOException {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("fCount", this.f51495a);
            putFields.put("fIgnoreCount", this.f51496b);
            putFields.put("fFailures", this.f51497c);
            putFields.put("fRunTime", this.f51498d);
            putFields.put("fStartTime", this.f51499e);
            objectOutputStream.writeFields();
        }

        private c(ObjectInputStream.GetField getField) throws IOException {
            this.f51495a = (AtomicInteger) getField.get("fCount", (Object) null);
            this.f51496b = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.f51497c = (List) getField.get("fFailures", (Object) null);
            this.f51498d = getField.get("fRunTime", 0L);
            this.f51499e = getField.get("fStartTime", 0L);
        }
    }

    public Result() {
        this.count = new AtomicInteger();
        this.ignoreCount = new AtomicInteger();
        this.failures = new CopyOnWriteArrayList<>();
        this.runTime = new AtomicLong();
        this.startTime = new AtomicLong();
    }

    private Object readResolve() {
        return new Result(this.serializedForm);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        new c(this).g(objectOutputStream);
    }

    public RunListener createListener() {
        return new b(this, null);
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public List<Failure> getFailures() {
        return this.failures;
    }

    public int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public int getRunCount() {
        return this.count.get();
    }

    public long getRunTime() {
        return this.runTime.get();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.serializedForm = c.f(objectInputStream);
    }

    public boolean wasSuccessful() {
        if (getFailureCount() == 0) {
            return true;
        }
        return false;
    }

    private Result(c cVar) {
        this.count = cVar.f51495a;
        this.ignoreCount = cVar.f51496b;
        this.failures = new CopyOnWriteArrayList<>(cVar.f51497c);
        this.runTime = new AtomicLong(cVar.f51498d);
        this.startTime = new AtomicLong(cVar.f51499e);
    }
}
