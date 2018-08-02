package SpikesRelics.cards.red;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import SpikesRelics.powers.DragonSoulPower;

public class DragonSoul
        extends AbstractCard
{
    public static final String ID = "DragonSoul";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DragonSoul");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public DragonSoul()
    {
        super("DragonSoul", NAME, "status/beta", "status/beta", 1, DESCRIPTION, CardType.SKILL, CardColor.RED, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DragonSoulPower(AbstractDungeon.player, 1), 1));
        for (AbstractMonster mo : AbstractDungeon.getMonsters().monsters) {
            if (!mo.isDeadOrEscaped()) {
                AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(mo, mo, new VulnerablePower(mo, 1, false), 1));
            }
        }
    }

    public AbstractCard makeCopy()
    {
        return new DragonSoul();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
            this.upgradeBaseCost(0);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("DragonSoul");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}