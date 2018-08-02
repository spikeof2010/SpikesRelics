package SpikesRelics.cards.green;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import SpikesRelics.powers.RiggedDeck;

public class RiggedDeckCard
        extends AbstractCard
{
    public static final String ID = "RiggedDeckCard";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("RiggedDeckCard");
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;

    public RiggedDeckCard()
    {
        super("RiggedDeckCard", NAME, "status/beta", "status/beta", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCard.CardColor.GREEN, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
        this.baseMagicNumber = 5;
        this.magicNumber = this.baseMagicNumber;
        this.isInnate = false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RiggedDeck(AbstractDungeon.player,this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy()
    {
        return new RiggedDeckCard();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isInnate = true;
            this.upgradeMagicNumber(1);
        }

    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("RiggedDeckCard");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}