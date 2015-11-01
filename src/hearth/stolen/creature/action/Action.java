package hearth.stolen.creature.action;

import hearth.stolen.creature.Creature;
import hearth.stolen.creature.action.death.GeneralDeathAction;

/**
 * Created by eggcanfly on 15/11/1.
 */
public interface Action {

    void act(Creature creature);

    Action DEATH_GENERAL = new GeneralDeathAction();
}
