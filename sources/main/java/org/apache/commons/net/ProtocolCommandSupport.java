package org.apache.commons.net;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import org.apache.commons.net.util.ListenerList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ProtocolCommandSupport implements Serializable {
    private static final long serialVersionUID = -8017692739988399978L;
    private final ListenerList __listeners = new ListenerList();
    private final Object __source;

    public void addProtocolCommandListener(f fVar) {
        this.__listeners.addListener(fVar);
    }

    public void fireCommandSent(String str, String str2) {
        ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.__source, str, str2);
        Iterator<EventListener> it = this.__listeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).d(protocolCommandEvent);
        }
    }

    public void fireReplyReceived(int i6, String str) {
        ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.__source, i6, str);
        Iterator<EventListener> it = this.__listeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b(protocolCommandEvent);
        }
    }

    public int getListenerCount() {
        return this.__listeners.getListenerCount();
    }

    public void removeProtocolCommandListener(f fVar) {
        this.__listeners.removeListener(fVar);
    }

    public ProtocolCommandSupport(Object obj) {
        this.__source = obj;
    }
}
