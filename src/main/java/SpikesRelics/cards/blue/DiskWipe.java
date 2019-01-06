package SpikesRelics.cards.blue;

import SpikesRelics.powers.DiskWipePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DiskWipe
        extends AbstractCard
{
    public static final String ID = "DiskWipe";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DiskWipe");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public DiskWipe()
    {
        super("DiskWipe", NAME, "status/beta", "status/beta", 1, DESCRIPTION, CardType.POWER, CardColor.BLUE, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.isInnate = false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DiskWipePower(AbstractDungeon.player,1 ), 1));
    }

    public AbstractCard makeCopy()
    {
        return new DiskWipe();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("DiskWipe");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}