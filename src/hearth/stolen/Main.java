package hearth.stolen;

import hearth.stolen.command.Attack;
import hearth.stolen.creature.Creature;
import hearth.stolen.creature.action.Action;
import hearth.stolen.creature.action.death.HealAttackerDeathAction;
import hearth.stolen.event.EventLoop;
import hearth.stolen.range.CustomRange;
import hearth.stolen.range.Range;

import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable{

    private EventLoop eventLoop = EventLoop.getInstance();

    public static void main(String[] args) {

        Main main = new Main();

        new Thread(main).start();

        Creature creature1 = new Creature();

        creature1.setCurrentLife(5);
        creature1.setAttack(2);
        creature1.setName("A");
        creature1.setMaxLife(6);

        Creature c2 = new Creature();
        c2.setCurrentLife(2);
        c2.setAttack(3);
        c2.setName("B");
        List<Action> list = new ArrayList<Action>();

        list.add(new HealAttackerDeathAction(2));
        c2.setDeathActions(list);

        Range range = new CustomRange(c2);
        new Attack(creature1, range).execute();



    }

    @Override
    public void run() {
        eventLoop.loop();
    }
}
