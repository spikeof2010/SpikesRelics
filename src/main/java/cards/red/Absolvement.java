package cards.red;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import powers.AbsolvementPower;
import powers.RiggedDeck;

public class Absolvement
        extends AbstractCard
{
    public static final String ID = "Absolvement";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Absolvement");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public Absolvement()
    {
        super("Absolvement", NAME, "status/beta", "status/beta", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCard.CardColor.RED, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.isInnate = false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new AbsolvementPower(AbstractDungeon.player,this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy()
    {
        return new Absolvement();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isInnate = true;
            this.upgradeMagicNumber(1);
            this.upgradeBaseCost(0);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Absolvement");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}