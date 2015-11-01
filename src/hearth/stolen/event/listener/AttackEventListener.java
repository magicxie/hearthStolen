package hearth.stolen.event.listener;

import hearth.stolen.creature.Creature;
import hearth.stolen.event.BattleEventListener;
import hearth.stolen.event.BattleEventType;
import hearth.stolen.event.impl.AttackEvent;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class AttackEventListener extends BattleEventListener<AttackEvent> {

    @Override
    public void on(AttackEvent event) {

        for(Creature c : event.getRange().getTargets()){

            c.getAttackedFrom().push(event.getTriggerBy());
            c.damage(event.getTriggerBy().getAttack());

            event.getTriggerBy().getAttackedTo().push(c);
            event.getTriggerBy().damage(c.getAttack());
        }

    }
}
