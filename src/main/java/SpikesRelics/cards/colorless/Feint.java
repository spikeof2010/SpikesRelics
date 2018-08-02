package SpikesRelics.cards.colorless;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;

public class Feint
        extends AbstractCard
{
    public static final String ID = "Feint";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Feint");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public Feint()
    {
        super("Feint", NAME, "status/beta", "status/beta", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.baseBlock = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.intent == AbstractMonster.Intent.DEBUFF || m.intent == AbstractMonster.Intent.DEFEND_DEBUFF || m.intent == AbstractMonster.Intent.ATTACK_DEBUFF || m.intent == AbstractMonster.Intent.STRONG_DEBUFF)
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        {
            if (m.intent == AbstractMonster.Intent.DEBUFF || m.intent == AbstractMonster.Intent.DEFEND_DEBUFF || m.intent == AbstractMonster.Intent.ATTACK_DEBUFF || m.intent == AbstractMonster.Intent.STRONG_DEBUFF)
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new ArtifactPower(p, this.magicNumber), this.magicNumber));
        }
    }

    public AbstractCard makeCopy()
    {
        return new Feint();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
            this.upgradeBlock(2);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Feint");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}