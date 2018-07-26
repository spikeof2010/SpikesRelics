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

public class AbsolvementPower extends AbstractPower  {
    public static final String POWER_ID = "AbsolvementPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final int CARD_AMT = 3;
    private int damage;

    public AbsolvementPower(AbstractCreature owner, int damage) {
        this.name = NAME;
        this.ID = "AbsolvementPower";
        this.owner = owner;
        this.amount = 3;
        this.damage = damage;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/powers/AbsolvementPower.png");
    }


    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0];
        } else {
            this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
        }

    }
    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.damage += stackAmount;
        this.updateDescription();
    }
    public void onExhaust(AbstractCard card) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(this.damage, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }

    }
}