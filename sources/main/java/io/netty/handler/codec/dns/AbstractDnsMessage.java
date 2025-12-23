package io.netty.handler.codec.dns;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractDnsMessage extends AbstractReferenceCounted implements DnsMessage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SECTION_COUNT = 4;
    private Object additionals;
    private Object answers;
    private Object authorities;
    private short id;
    private final ResourceLeakTracker<DnsMessage> leak;
    private DnsOpCode opCode;
    private Object questions;
    private boolean recursionDesired;

    /* renamed from: z, reason: collision with root package name */
    private byte f43068z;
    private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
    private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();

    protected AbstractDnsMessage(int i6) {
        this(i6, DnsOpCode.QUERY);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear(DnsSection dnsSection) {
        clear(sectionOrdinal(dnsSection));
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count(DnsSection dnsSection) {
        return count(sectionOrdinal(dnsSection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        DnsMessage dnsMessage = (DnsMessage) obj;
        if (id() != dnsMessage.id()) {
            return false;
        }
        if (this instanceof DnsQuery) {
            if (!(dnsMessage instanceof DnsQuery)) {
                return false;
            }
        } else if (dnsMessage instanceof DnsQuery) {
            return false;
        }
        return true;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection) {
        return (T) recordAt(sectionOrdinal(dnsSection));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i6) {
        return (T) removeRecord(sectionOrdinal(dnsSection), i6);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setId(int i6) {
        this.id = (short) i6;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        setRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    protected AbstractDnsMessage(int i6, DnsOpCode dnsOpCode) {
        this.leak = leakDetector.track(this);
        setId(i6);
        setOpCode(dnsOpCode);
    }

    private void addRecord(int i6, DnsRecord dnsRecord) {
        checkQuestion(i6, dnsRecord);
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            setSection(i6, dnsRecord);
            return;
        }
        if (!(sectionAt instanceof DnsRecord)) {
            ((List) sectionAt).add(dnsRecord);
            return;
        }
        ArrayList<DnsRecord> newRecordList = newRecordList();
        newRecordList.add(castRecord(sectionAt));
        newRecordList.add(dnsRecord);
        setSection(i6, newRecordList);
    }

    private static <T extends DnsRecord> T castRecord(Object obj) {
        return (T) obj;
    }

    private static DnsRecord checkQuestion(int i6, DnsRecord dnsRecord) {
        if (i6 != SECTION_QUESTION || (ObjectUtil.checkNotNull(dnsRecord, "record") instanceof DnsQuestion)) {
            return dnsRecord;
        }
        throw new IllegalArgumentException("record: " + dnsRecord + " (expected: " + StringUtil.simpleClassName((Class<?>) DnsQuestion.class) + ')');
    }

    private int count(int i6) {
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            return 0;
        }
        if (sectionAt instanceof DnsRecord) {
            return 1;
        }
        return ((List) sectionAt).size();
    }

    private static ArrayList<DnsRecord> newRecordList() {
        return new ArrayList<>(2);
    }

    private <T extends DnsRecord> T recordAt(int i6) {
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            return null;
        }
        if (sectionAt instanceof DnsRecord) {
            return (T) castRecord(sectionAt);
        }
        List list = (List) sectionAt;
        if (list.isEmpty()) {
            return null;
        }
        return (T) castRecord(list.get(0));
    }

    private <T extends DnsRecord> T removeRecord(int i6, int i7) {
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i7 + " (expected: none)");
        }
        if (!(sectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) sectionAt).remove(i7));
        }
        if (i7 == 0) {
            T t5 = (T) castRecord(sectionAt);
            setSection(i6, null);
            return t5;
        }
        throw new IndexOutOfBoundsException("index: " + i7 + " (expected: 0)");
    }

    private Object sectionAt(int i6) {
        if (i6 == 0) {
            return this.questions;
        }
        if (i6 == 1) {
            return this.answers;
        }
        if (i6 == 2) {
            return this.authorities;
        }
        if (i6 == 3) {
            return this.additionals;
        }
        throw new Error();
    }

    private static int sectionOrdinal(DnsSection dnsSection) {
        return ((DnsSection) ObjectUtil.checkNotNull(dnsSection, "section")).ordinal();
    }

    private void setRecord(int i6, DnsRecord dnsRecord) {
        clear(i6);
        setSection(i6, checkQuestion(i6, dnsRecord));
    }

    private void setSection(int i6, Object obj) {
        if (i6 == 0) {
            this.questions = obj;
            return;
        }
        if (i6 == 1) {
            this.answers = obj;
        } else if (i6 == 2) {
            this.authorities = obj;
        } else {
            if (i6 != 3) {
                throw new Error();
            }
            this.additionals = obj;
        }
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear() {
        for (int i6 = 0; i6 < 4; i6++) {
            clear(i6);
        }
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int id() {
        return this.id & j1.f43986d;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsOpCode opCode() {
        return this.opCode;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setOpCode(DnsOpCode dnsOpCode) {
        this.opCode = (DnsOpCode) ObjectUtil.checkNotNull(dnsOpCode, "opCode");
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecursionDesired(boolean z5) {
        this.recursionDesired = z5;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setZ(int i6) {
        this.f43068z = (byte) (i6 & 7);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int z() {
        return this.f43068z;
    }

    private void clear(int i6) {
        Object sectionAt = sectionAt(i6);
        setSection(i6, null);
        if (sectionAt instanceof ReferenceCounted) {
            ((ReferenceCounted) sectionAt).release();
            return;
        }
        if (sectionAt instanceof List) {
            List list = (List) sectionAt;
            if (list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ReferenceCountUtil.release(it.next());
            }
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        clear();
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    public int hashCode() {
        return (id() * 31) + (!(this instanceof DnsQuery) ? 1 : 0);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain() {
        return (DnsMessage) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage touch() {
        return (DnsMessage) super.touch();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain(int i6) {
        return (DnsMessage) super.retain(i6);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord) {
        return (T) setRecord(sectionOrdinal(dnsSection), i6, dnsRecord);
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsMessage touch(Object obj) {
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    private <T extends DnsRecord> T setRecord(int i6, int i7, DnsRecord dnsRecord) {
        checkQuestion(i6, dnsRecord);
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i7 + " (expected: none)");
        }
        if (!(sectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) sectionAt).set(i7, dnsRecord));
        }
        if (i7 != 0) {
            throw new IndexOutOfBoundsException("index: " + i7 + " (expected: 0)");
        }
        setSection(i6, dnsRecord);
        return (T) castRecord(sectionAt);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count() {
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 += count(i7);
        }
        return i6;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i6) {
        return (T) recordAt(sectionOrdinal(dnsSection), i6);
    }

    private <T extends DnsRecord> T recordAt(int i6, int i7) {
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i7 + " (expected: none)");
        }
        if (!(sectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) sectionAt).get(i7));
        }
        if (i7 != 0) {
            throw new IndexOutOfBoundsException("index: " + i7 + "' (expected: 0)");
        }
        return (T) castRecord(sectionAt);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), i6, dnsRecord);
        return this;
    }

    private void addRecord(int i6, int i7, DnsRecord dnsRecord) {
        ArrayList<DnsRecord> newRecordList;
        checkQuestion(i6, dnsRecord);
        Object sectionAt = sectionAt(i6);
        if (sectionAt == null) {
            if (i7 != 0) {
                throw new IndexOutOfBoundsException("index: " + i7 + " (expected: 0)");
            }
            setSection(i6, dnsRecord);
            return;
        }
        if (sectionAt instanceof DnsRecord) {
            if (i7 == 0) {
                newRecordList = newRecordList();
                newRecordList.add(dnsRecord);
                newRecordList.add(castRecord(sectionAt));
            } else {
                if (i7 != 1) {
                    throw new IndexOutOfBoundsException("index: " + i7 + " (expected: 0 or 1)");
                }
                newRecordList = newRecordList();
                newRecordList.add(castRecord(sectionAt));
                newRecordList.add(dnsRecord);
            }
            setSection(i6, newRecordList);
            return;
        }
        ((List) sectionAt).add(i7, dnsRecord);
    }
}
