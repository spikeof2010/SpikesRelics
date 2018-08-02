package SpikesRelics.cards.curses;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Intolerance
        extends AbstractCard
{
    public static final String ID = "Intolerance";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Intolerance");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public Intolerance()
    {
        super("Intolerance", NAME, "status/beta", "status/beta", -2, DESCRIPTION, CardType.CURSE, CardColor.CURSE, CardRarity.CURSE, AbstractCard.CardTarget.NONE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!this.dontTriggerOnUseCard && p.hasRelic("Blue Candle")) {
            this.useBlueCandle(p);
        } else {
            AbstractDungeon.actionManager.addToTop(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
        }

    }
    public void triggerOnManualDiscard() {
        if (this.upgraded) {
            AbstractDungeon.actionManager.addToTop(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, 3, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
        } else {
            AbstractDungeon.actionManager.addToTop(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, 3, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
        }

    }
    public AbstractCard makeCopy()
    {
        return new Intolerance();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Intolerance");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}