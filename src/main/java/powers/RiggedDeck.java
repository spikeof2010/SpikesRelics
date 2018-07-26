package powers;

import basemod.BaseMod;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class RiggedDeck extends AbstractPower implements PostBattleSubscriber,
        PostDungeonInitializeSubscriber, PostDrawSubscriber {
    public static final String POWER_ID = "RiggedDeck";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final int CARD_AMT = 3;
    private int damage;
    private boolean IsPostDraw = true;

    public RiggedDeck(AbstractCreature owner, int damage) {
        this.name = NAME;
        this.ID = "RiggedDeck";
        this.owner = owner;
        this.amount = 3;
        this.damage = damage;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/powers/RiggedDeck.png");
    }

    @Override
    public void onInitialApplication() {
        BaseMod.subscribe(this);
    }

    @Override
    public void receivePostDraw(AbstractCard c) {
        if (IsPostDraw == true) {
            --this.amount;
            if (this.amount == 0) {
                this.flash();
                this.amount = 3;
                AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(this.damage, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            }

            this.updateDescription();
        }
    }

    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.damage + DESCRIPTIONS[2];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[3] + this.damage + DESCRIPTIONS[2];
        }

    }
    public void atEndOfRound() {
        IsPostDraw = false;
    }
    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.damage += stackAmount;
        this.updateDescription();
    }

    public void atStartOfTurnPostDraw() {
        IsPostDraw = true;
    }

    public void atStartOfTurn() {
        this.amount = 3;
        this.updateDescription();
        IsPostDraw = false;
    }

    @Override
    public void receivePostBattle(AbstractRoom battleRoom) {
        BaseMod.unsubscribeFromPostDraw(this);
        /*
         *  calling unsubscribeFromPostBattle inside the callback
         *  for receivePostBattle means that when we're calling it
         *  there is currently an iterator going over the list
         *  of subscribers and calling receivePostBattle on each of
         *  them therefore if we immediately try to remove the this
         *  callback from the post battle subscriber list it will
         *  throw a concurrent modification exception in the iterator
         *
         *  for now we just add a delay - yes this is an atrocious solution
         *  PLEASE someone with a better idea replace it
         */
        Thread delayed = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("could not delay unsubscribe to avoid ConcurrentModificationException");
                e.printStackTrace();
            }
            BaseMod.unsubscribeFromPostBattle(this);
        });
        delayed.start();
    }

    @Override
    public void receivePostDungeonInitialize() {
        BaseMod.unsubscribeFromPostDraw(this);
        /*
         *  calling unsubscribeFromPostDungeonInitialize inside the callback
         *  for receivePostDungeonInitialize means that when we're calling it
         *  there is currently an iterator going over the list
         *  of subscribers and calling receivePostDungeonInitialize on each of
         *  them therefore if we immediately try to remove the this
         *  callback from the post battle subscriber list it will
         *  throw a concurrent modification exception in the iterator
         *
         *  for now we just add a delay - yes this is an atrocious solution
         *  PLEASE someone with a better idea replace it
         */
        Thread delayed = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("could not delay unsubscribe to avoid ConcurrentModificationException");
                e.printStackTrace();
            }
            BaseMod.unsubscribeFromPostDungeonInitialize(this);
        });
        delayed.start();
    }
}