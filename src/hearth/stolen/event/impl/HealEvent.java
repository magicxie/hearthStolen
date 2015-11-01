package hearth.stolen.event.impl;

import hearth.stolen.creature.Creature;
import hearth.stolen.event.BattleEvent;
import hearth.stolen.event.BattleEventType;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class HealEvent extends BattleEvent {

    public int getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    private int healPoint;

    public HealEvent(Creature creature, int healPoint) {
        super(creature, BattleEventType.HEAL);
        this.healPoint = healPoint;
    }
}
