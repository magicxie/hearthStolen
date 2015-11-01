package hearth.stolen.creature.action.death;

import hearth.stolen.creature.Creature;
import hearth.stolen.creature.action.Action;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class GeneralDeathAction implements Action {


    @Override
    public void act(Creature creature) {
        System.out.println(creature + " is dead!!");
    }
}
