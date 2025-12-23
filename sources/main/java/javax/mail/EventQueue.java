package javax.mail;

import java.util.Vector;
import javax.mail.event.MailEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class EventQueue implements Runnable {
    private Thread qThread;
    private QueueElement head = null;
    private QueueElement tail = null;

    private synchronized QueueElement dequeue() throws InterruptedException {
        QueueElement queueElement;
        while (true) {
            try {
                queueElement = this.tail;
                if (queueElement != null) {
                    break;
                }
                wait();
            } catch (Throwable th) {
                throw th;
            }
        }
        QueueElement queueElement2 = queueElement.prev;
        this.tail = queueElement2;
        if (queueElement2 == null) {
            this.head = null;
        } else {
            queueElement2.next = null;
        }
        queueElement.next = null;
        queueElement.prev = null;
        return queueElement;
    }

    public synchronized void enqueue(MailEvent mailEvent, Vector vector) {
        try {
            QueueElement queueElement = new QueueElement(mailEvent, vector);
            QueueElement queueElement2 = this.head;
            if (queueElement2 == null) {
                this.head = queueElement;
                this.tail = queueElement;
            } else {
                queueElement.next = queueElement2;
                queueElement2.prev = queueElement;
                this.head = queueElement;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class QueueElement {
        MailEvent event;
        QueueElement next = null;
        QueueElement prev = null;
        Vector vector;

        QueueElement(MailEvent mailEvent, Vector vector) {
            this.event = mailEvent;
            this.vector = vector;
        }
    }

    void stop() {
        Thread thread = this.qThread;
        if (thread != null) {
            thread.interrupt();
            this.qThread = null;
        }
    }

    public EventQueue() {
        Thread thread = new Thread(this, "JavaMail-EventQueue");
        this.qThread = thread;
        thread.setDaemon(true);
        this.qThread.start();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                QueueElement dequeue = dequeue();
                if (dequeue != null) {
                    MailEvent mailEvent = dequeue.event;
                    Vector vector = dequeue.vector;
                    for (int i6 = 0; i6 < vector.size(); i6++) {
                        try {
                            mailEvent.dispatch(vector.elementAt(i6));
                        } catch (Throwable th) {
                            if (th instanceof InterruptedException) {
                                return;
                            }
                        }
                    }
                } else {
                    return;
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
