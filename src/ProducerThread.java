public class ProducerThread extends Thread{
    private static int id = 0;
    MessageQueue mq;

    public ProducerThread(MessageQueue mq){
        this.mq = mq;
    }
    public void run() {

        while(this.id < 500){
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String packet = "packet number : " + nextId();
            mq.produce(packet);
        }
    }
    private static synchronized int nextId(){
        return id++;
    }
}
