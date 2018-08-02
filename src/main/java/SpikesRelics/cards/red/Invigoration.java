package SpikesRelics.cards.red;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import SpikesRelics.powers.InvigorationPower;

public class Invigoration
        extends AbstractCard
{
    public static final String ID = "Invigoration";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Invigoration");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public Invigoration()
    {
        super("Invigoration", NAME, "status/beta", "status/beta", 2, DESCRIPTION, CardType.POWER, CardColor.RED, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new InvigorationPower(AbstractDungeon.player,this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy()
    {
        return new Invigoration();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Invigoration");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}