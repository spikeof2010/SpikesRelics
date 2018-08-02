package SpikesRelics.cards.red;

import SpikesRelics.cards.colorless.Roar;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BarbarianYell
        extends AbstractCard
{
    public static final String ID = "BarbarianYell";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BarbarianYell");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public BarbarianYell()
    {
        super("BarbarianYell", NAME, "status/beta", "status/beta", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.RED, AbstractCard.CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Roar(), this.magicNumber, true, false));
    }

    public AbstractCard makeCopy()
    {
        return new BarbarianYell();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
            this.upgradeBaseCost(0);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("BarbarianYell");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}