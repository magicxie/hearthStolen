package hearth.stolen.event;

import hearth.stolen.creature.Creature;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class BattleEvent {

    private BattleEventType eventType;
    private Creature triggerBy;

    public BattleEvent(Creature triggerBy, BattleEventType eventType) {

        this.triggerBy = triggerBy;
        this.eventType = eventType;
    }

    public BattleEvent(Creature triggerBy) {
        this.triggerBy = triggerBy;
    }

    public BattleEventType getEventType() {
        return eventType;
    }

    public void setEventType(BattleEventType eventType) {
        this.eventType = eventType;
    }

    public Creature getTriggerBy() {
        return triggerBy;
    }

    public void setTriggerBy(Creature triggerBy) {
        this.triggerBy = triggerBy;
    }
}
