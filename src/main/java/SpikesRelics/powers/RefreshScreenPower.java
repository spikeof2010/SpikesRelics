package SpikesRelics.powers;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import SpikesRelics.interfaces.IShufflePower;

public class RefreshScreenPower extends AbstractPower implements IShufflePower {
    public static final String POWER_ID = "RefreshScreenPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public RefreshScreenPower(AbstractCreature owner, final int numofOrbs) {
        this.name = NAME;
        this.ID = "RefreshScreenPower";
        this.owner = owner;
        this.amount = numofOrbs;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/powers/RefreshScreenPower.png");
    }

    @Override
    public void onShuffle() {
        for (int i = 0; i < this.amount; i++) {
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(AbstractOrb.getRandomOrb(true)));
        }
    }
    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        }

    }
    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
        this.updateDescription();
    }
}