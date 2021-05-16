public class Main {
    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue(100);
        ProducerThread producer = new ProducerThread(mq);
        ConsumerThread consumer = new ConsumerThread(mq);
        producer.start();
        consumer.start();
    }
}
