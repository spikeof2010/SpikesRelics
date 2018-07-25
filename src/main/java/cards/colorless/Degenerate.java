package cards.colorless;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.actions.defect.GashAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

public class Degenerate
        extends AbstractCard
{
    public static final String ID = "Degenerate";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Degenerate");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;


    public Degenerate()
    {
        super("Degenerate", NAME, "status/beta", "status/beta", 2, DESCRIPTION, CardType.ATTACK, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
        this.baseDamage = 15;
        this.baseMagicNumber = -6;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        AbstractDungeon.actionManager.addToBottom(new GashAction(this, this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new ReduceCostAction(this, 1));
        AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new VerticalAuraEffect(Color.FIREBRICK, p.hb.cX, p.hb.cY), 0.0F));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), 1));
    }

    public AbstractCard makeCopy()
    {
        return new Degenerate();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(4);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Degenerate");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}