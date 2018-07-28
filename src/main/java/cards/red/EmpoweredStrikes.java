package cards.red;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import powers.DragonSoulPower;

public class EmpoweredStrikes
        extends AbstractCard
{
    public static final String ID = "EmpoweredStrikes";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("EmpoweredStrikes");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    public EmpoweredStrikes()
    {
        super("EmpoweredStrikes", NAME, "status/beta", "status/beta", 1, DESCRIPTION, CardType.SKILL, CardColor.RED, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 4;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = super.canUse(p, m);
        if (!canUse) {
            return false;
        } else {
            if (!p.hasPower("DragonSoulPower")){
                canUse = false;
                this.cantUseMessage = UPGRADE_DESCRIPTION;
            }

            return canUse;
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DragonSoulPower(AbstractDungeon.player, -1), -1));
            AbstractCard c = AbstractDungeon.returnTrulyRandomCard(CardType.ATTACK, AbstractDungeon.cardRandomRng).makeCopy();
        AbstractDungeon.actionManager.addToBottom(new ReduceCostAction(this, 1));
            c.baseDamage += magicNumber;
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
    }

    public AbstractCard makeCopy()
    {
        return new EmpoweredStrikes();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
            this.upgradeBaseCost(0);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("EmpoweredStrikes");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}