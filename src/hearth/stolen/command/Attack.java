package hearth.stolen.command;

import hearth.stolen.creature.Creature;
import hearth.stolen.event.BattleEventType;
import hearth.stolen.event.EventLoop;
import hearth.stolen.event.impl.AttackEvent;
import hearth.stolen.range.Range;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class Attack implements Command {

    private Creature executor;
    private Range range;


    public Attack(Creature executor, Range range) {
        this.executor = executor;
        this.range = range;
    }

    @Override
    public void execute() {

        EventLoop.getInstance().emit(new AttackEvent(executor, BattleEventType.ATTACKING, range));

    }
}
