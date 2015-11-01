package hearth.stolen.event.impl;

import hearth.stolen.creature.Creature;
import hearth.stolen.event.BattleEvent;
import hearth.stolen.event.BattleEventType;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class DamageEvent extends BattleEvent {
    public DamageEvent(Creature creature) {
        super(creature, BattleEventType.DAMAGE);
    }
}
