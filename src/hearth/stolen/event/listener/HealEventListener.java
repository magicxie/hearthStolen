package hearth.stolen.event.listener;

import hearth.stolen.event.BattleEventListener;
import hearth.stolen.event.impl.HealEvent;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class HealEventListener extends BattleEventListener<HealEvent>{
    @Override
    public void on(HealEvent event) {
        System.out.println(event.getTriggerBy() + " is healed by " + event.getHealPoint());
    }
}
