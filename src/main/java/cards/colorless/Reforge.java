package cards.colorless;

import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Reforge
        extends AbstractCard
{
    public static final String ID = "Reforge";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Reforge");
    private static String NAME = cardStrings.NAME;
    private static String DESCRIPTION = cardStrings.DESCRIPTION;
    private static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    public Reforge()
    {
        super("Reforge", NAME, "status/beta", "status/beta", 3, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if(c.upgraded) {
                c.modifyCostForCombat(-1);
            }
            c.upgrade();
            }
        }

    public AbstractCard makeCopy()
    {
        return new Reforge();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.exhaust = false;
            this.upgradeBaseCost(2);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Reforge");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}