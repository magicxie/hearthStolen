package hearth.stolen.creature.action.death;

import hearth.stolen.creature.Creature;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class HealAttackerDeathAction extends GeneralDeathAction {
    private int healPoint;

    public int getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    public void act(Creature creature) {
        super.act(creature);

        int size = creature.getAttackedFrom().size();

        if(size > 0) {
            creature.getAttackedFrom().peek().heal(this.healPoint);
        }

    }

    public HealAttackerDeathAction(int healPoint) {
        this.healPoint = healPoint;
    }

}
