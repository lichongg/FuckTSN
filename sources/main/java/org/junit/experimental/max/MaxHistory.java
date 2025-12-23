package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class b extends RunListener {

        /* renamed from: a, reason: collision with root package name */
        private long f51342a;

        /* renamed from: b, reason: collision with root package name */
        private Map<Description, Long> f51343b;

        private b() {
            this.f51342a = System.currentTimeMillis();
            this.f51343b = new HashMap();
        }

        @Override // org.junit.runner.notification.RunListener
        public void b(Failure failure) throws Exception {
            MaxHistory.this.putTestFailureTimestamp(failure.getDescription(), this.f51342a);
        }

        @Override // org.junit.runner.notification.RunListener
        public void e(Result result) throws Exception {
            MaxHistory.this.save();
        }

        @Override // org.junit.runner.notification.RunListener
        public void g(Description description) throws Exception {
            this.f51343b.put(description, Long.valueOf(System.nanoTime()));
        }

        @Override // org.junit.runner.notification.RunListener
        public void c(Description description) throws Exception {
            MaxHistory.this.putTestDuration(description, System.nanoTime() - this.f51343b.get(description).longValue());
        }

        /* synthetic */ b(MaxHistory maxHistory, a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Comparator<Description> {
        private c() {
        }

        /* synthetic */ c(MaxHistory maxHistory, a aVar) {
            this();
        }

        private Long b(Description description) {
            Long failureTimestamp = MaxHistory.this.getFailureTimestamp(description);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Description description, Description description2) {
            if (MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int compareTo = b(description2).compareTo(b(description));
            return compareTo != 0 ? compareTo : MaxHistory.this.getTestDuration(description).compareTo(MaxHistory.this.getTestDuration(description2));
        }
    }

    private static MaxHistory readHistory(File file) throws CouldNotReadCoreException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    return (MaxHistory) objectInputStream.readObject();
                } finally {
                    objectInputStream.close();
                }
            } finally {
                fileInputStream.close();
            }
        } catch (Exception e6) {
            throw new CouldNotReadCoreException(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    Long getFailureTimestamp(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    Long getTestDuration(Description description) {
        return this.fDurations.get(description.toString());
    }

    boolean isNewTest(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    public RunListener listener() {
        return new b(this, null);
    }

    void putTestDuration(Description description, long j6) {
        this.fDurations.put(description.toString(), Long.valueOf(j6));
    }

    void putTestFailureTimestamp(Description description, long j6) {
        this.fFailureTimestamps.put(description.toString(), Long.valueOf(j6));
    }

    public Comparator<Description> testComparator() {
        return new c(this, null);
    }

    private MaxHistory(File file) {
        this.fHistoryStore = file;
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (CouldNotReadCoreException e6) {
                e6.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }
}
