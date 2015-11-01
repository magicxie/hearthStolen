package hearth.stolen.creature;

import hearth.stolen.Life;
import hearth.stolen.creature.action.Action;
import hearth.stolen.creature.action.death.GeneralDeathAction;
import hearth.stolen.event.BattleEvent;
import hearth.stolen.event.BattleEventType;
import hearth.stolen.event.EventLoop;
import hearth.stolen.event.impl.DamageEvent;
import hearth.stolen.event.impl.DeathEvent;
import hearth.stolen.event.impl.HealEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class Creature {

    int position;
    int player;
    int maxLife;
    int currentLife;
    int group;
    int attack;
    int defense;
    String name;
    private Stack<Creature> attackedTo = new Stack<Creature>();
    private Stack<Creature> attackedFrom = new Stack<Creature>();
    private List<Action> deathActions;

    public Stack<Creature> getAttackedTo() {
        return attackedTo;
    }

    public void setAttackedTo(Stack<Creature> attackedTo) {
        this.attackedTo = attackedTo;
    }

    public Stack<Creature> getAttackedFrom() {
        return attackedFrom;
    }

    public void setAttackedFrom(Stack<Creature> attackedFrom) {
        this.attackedFrom = attackedFrom;
    }

    public void damage(int damage) {

        currentLife -= damage;

        EventLoop.getInstance().emit(new DamageEvent(this));

        if (currentLife < 0) {
            currentLife = 0;
        }
        if (currentLife == 0) {
            EventLoop.getInstance().emit(new DeathEvent(this));
        }
    }

    public void heal(int hp) {
        currentLife += hp;
        if (currentLife > maxLife) {
            currentLife = maxLife;
        }
        EventLoop.getInstance().emit(new HealEvent(this, hp));

    }

    public List<Action> getDeathActions() {
        if (deathActions == null) {
            deathActions = new LinkedList<Action>();
            deathActions.add(Action.DEATH_GENERAL);
        }
        return deathActions;
    }

    public void setDeathActions(List<Action> deathActions) {
        this.deathActions = deathActions;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Creature{" +
                ", player=" + player +
                ", life=" + currentLife +
                ", group=" + group +
                ", attack=" + attack +
                ", name='" + name + '\'' +
                '}';
    }
}
