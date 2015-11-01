package hearth.stolen.event.impl;

import hearth.stolen.creature.Creature;
import hearth.stolen.event.BattleEvent;
import hearth.stolen.event.BattleEventType;
import hearth.stolen.range.Range;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class AttackEvent extends BattleEvent {

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    private Range range;

    public AttackEvent(Creature attacker, BattleEventType eventType, Range range) {

        super(attacker, eventType);
        this.range = range;
    }
}
