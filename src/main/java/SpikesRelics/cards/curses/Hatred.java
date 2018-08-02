package SpikesRelics.cards.curses;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Hatred
        extends CustomCard
{
    public static final String ID = "Hatred";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Hatred");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public Hatred()
    {
        super ("Hatred", NAME, "images/cards/Hatred.png", -2, DESCRIPTION, CardType.CURSE, CardColor.CURSE, CardRarity.CURSE, AbstractCard.CardTarget.NONE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!this.dontTriggerOnUseCard && p.hasRelic("Blue Candle")) {
            this.useBlueCandle(p);
        } else {
            for (AbstractMonster mo : AbstractDungeon.getMonsters().monsters){
                if (!mo.isDeadOrEscaped()){
                    AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(mo, mo, new StrengthPower(mo, 2), 2));
                }
            }
        }

    }
    public void triggerWhenDrawn() {
        AbstractDungeon.actionManager.addToBottom(new SetDontTriggerAction(this, false));
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }
    public AbstractCard makeCopy()
    {
        return new Hatred();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Hatred");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}