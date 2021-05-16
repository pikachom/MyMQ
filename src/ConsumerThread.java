public class ConsumerThread extends Thread{
    private final MessageQueue mq;
    public ConsumerThread(MessageQueue mq){
        this.mq = mq;
    }
    public void run(){
        while(true){
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String packet = mq.consume();
            System.out.println("consumer -> " + packet);
            System.out.println(mq.getCount() + " messages in queue now");
        }
    }

}
