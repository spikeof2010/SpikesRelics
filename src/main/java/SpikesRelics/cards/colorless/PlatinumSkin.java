package SpikesRelics.cards.colorless;

import SpikesRelics.powers.PlatinumSkinPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PlatinumSkin
        extends AbstractCard
{
    public static final String ID = "PlatinumSkin";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PlatinumSkin");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public PlatinumSkin()
    {
        super("PlatinumSkin", NAME, "status/beta", "status/beta", 2, DESCRIPTION, CardType.POWER, CardColor.COLORLESS, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.isInnate = false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PlatinumSkinPower(AbstractDungeon.player,1 ), 1));
    }

    public AbstractCard makeCopy()
    {
        return new PlatinumSkin();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isInnate = true;
            this.initializeDescription();
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("PlatinumSkin");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}