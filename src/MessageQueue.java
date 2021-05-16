public class MessageQueue {
    private final String[] buffer;
    private int head, tail;
    private int count;

    public MessageQueue(int capacity){
        this.buffer = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void produce(String packet){
        while(count >= buffer.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[tail] = packet;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }
    public synchronized String consume(){
        while(count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String packet = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();

        return packet;
    }
    public int getCount(){
        return this.count;
    }
}
