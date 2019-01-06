package SpikesRelics.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnCardDrawPower;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class PlatinumSkinPower extends AbstractPower implements OnCardDrawPower {
    public static final String POWER_ID = "PlatinumSkinPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public PlatinumSkinPower(AbstractCreature owner, final int numofOrbs) {
        this.name = NAME;
        this.ID = "PlatinumSkinPower";
        this.owner = owner;
        this.amount = numofOrbs;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/powers/PlatinumSkinPower.png");
    }

    @Override
    public void onCardDraw(AbstractCard card) {
        if (card.type == AbstractCard.CardType.ATTACK || card.type == AbstractCard.CardType.SKILL){
            for (int i = 0; i < this.amount; i++) {
                if (card.upgraded == true){
                    if (card.type == AbstractCard.CardType.ATTACK) {
                        card.baseDamage += 2;
                    }
                    card.baseBlock += 2;
                    card.magicNumber += 1;
                }
            }
        }
    }
    public void updateDescription() {
            this.description = DESCRIPTIONS[0];
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
        this.updateDescription();
    }


}