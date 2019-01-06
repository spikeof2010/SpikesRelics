package SpikesRelics.cards.curses;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class CloudedMind
        extends AbstractCard
{
    public static final String ID = "CloudedMind";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("CloudedMind");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public CloudedMind()
    {
        super("CloudedMind", NAME, "status/beta", "status/beta", -2, DESCRIPTION, CardType.CURSE, CardColor.CURSE, CardRarity.CURSE, AbstractCard.CardTarget.NONE);
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
    public void triggerOnExhaust() {
        AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, 1));
    }
    public AbstractCard makeCopy()
    {
        return new CloudedMind();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("CloudedMind");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}