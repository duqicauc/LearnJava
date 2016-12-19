package org.java.learn.concurrent;

import java.util.LinkedList;

/**
 * When I write pieces of code which are synchronized, I usually avoid synchronizing on "this" or marking the whole
 * method as synchronized. When you synchronize on "this" inside the class, it might happen that other code outside of
 * your control also synchronize on the handle to your object, or worse, call notify on your handle. This would severely
 * mess up your well-written BlockingQueue code. I therefore as a habit always use private data members as locks inside
 * a class, in this case I use the private queue data member.
 *
 * 在使用synchronized关键字写并发代码时，我通常避免锁"this"或者锁整个方法。当你在类内部锁"this"时，可能会有在你掌控范围以外的代码也在同步
 * 你想锁住的对象，更糟糕的情况下这些代码可能针对你的线程发出锁通知。这里使用一个BlockingQueue进行举例，一般而言，针对私有数据成员加锁是一种
 * 更好的开发习惯，这种情况下我使用私有队列作为数据成员。
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/19
 * Time: 21:16
 */
public class BlockingQueue {

    /**
     * It makes logical sense to use a linked list for a FIFO queue,
     * although an ArrayList is usually more efficient for a short
     * queue (on most VMs).
     */
    private final LinkedList queue = new LinkedList();

    /**
     * This method pushes an object onto the end of the queue, and
     * then notifies one of the waiting threads.
     */
    public void push(Object o) {
        synchronized (queue) {
            queue.add(o);
            queue.notify(); //唤醒正在等待在该队列上的线程
        }
    }

    /**
     * The pop operation blocks until either an object is returned
     * or the thread is interrupted, in which case it throws an
     * InterruptedException.
     */
    public Object pop() throws InterruptedException {
        //如果队列为空，线程就在queue上阻塞（除非当前线程被中断，该方法抛出InterruptedException）
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            return queue.removeFirst();
        }
    }

    /**
     * Return the number of elements currently in the queue.
     */
    public int size() {
        return queue.size();
    }
}
