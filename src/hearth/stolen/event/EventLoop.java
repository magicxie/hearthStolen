package hearth.stolen.event;

import hearth.stolen.event.listener.AttackEventListener;
import hearth.stolen.event.listener.DeathEventListener;
import hearth.stolen.event.listener.HealEventListener;

import java.util.*;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class EventLoop {

    private static EventLoop instance;

    protected EventLoop() {

        eventQueue = new LinkedList<>();
        listeners = new HashMap<>();

    }

    public synchronized static EventLoop getInstance(){

        if(instance == null){
            instance = new EventLoop();

            instance.regist(BattleEventType.ATTACKING, new AttackEventListener());
            instance.regist(BattleEventType.DEAD, new DeathEventListener());
            instance.regist(BattleEventType.HEAL, new HealEventListener());

        }

        return instance;

    }

    public void emit(BattleEvent event){
        System.out.println(event.getTriggerBy() + " emitting event " + event.getEventType());
        this.eventQueue.add(event);
    }

    public void regist(BattleEventType eventType, BattleEventListener listener){

        Queue<BattleEventListener> queue = listeners.get(eventType);

        if(queue == null){
            queue = new LinkedList<>();
            listeners.put(eventType, queue);
        }

        listeners.get(eventType).add(listener);

    }

    private Queue<BattleEvent> eventQueue;
    private Map<BattleEventType, Queue<BattleEventListener>> listeners;


    public void loop(){

        while(true){

            BattleEvent event = eventQueue.poll();
            if(event != null) {

                Queue<BattleEventListener> queue = listeners.get(event.getEventType());
                if(queue != null) {
                    for (BattleEventListener listener : queue) {
                        System.out.println("executing event" + event.getEventType());
                        listener.on(event);

                    }
                }else{
                }
            }else{
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
